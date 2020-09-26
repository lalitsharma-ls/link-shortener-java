package com.example.linkshorten.Service.impl;

import com.example.linkshorten.Co.LinkExpandCO;
import com.example.linkshorten.Co.LinkShortenCO;
import com.example.linkshorten.Dto.LinkExpandDTO;
import com.example.linkshorten.Dto.LinkInfoDTO;
import com.example.linkshorten.Dto.LinkShortenDTO;
import com.example.linkshorten.Exception.ApiRequestException;
import com.example.linkshorten.Repository.LinkInfoRepository;
import com.example.linkshorten.Repository.LinkRepository;
import com.example.linkshorten.Service.LinkService;
import com.example.linkshorten.entity.Link;
import com.example.linkshorten.entity.LinkInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

/**
 * @project linkshorten
 * @Author Lalit Sharma on 21/09/20
 **/
@Service
public class LinkServiceImpl implements LinkService {

  @Autowired
  LinkRepository linkRepository;

  @Autowired
  LinkInfoRepository linkInfoRepository;

  private static final String allowedString = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
  private static final char[] base64chars=allowedString.toCharArray();
  private static final int base=allowedString.length();
  @Override
  public LinkShortenDTO shortenLink(LinkShortenCO co) {

    Integer count= linkRepository.getLastLinkId()==null?0:linkRepository.getLastLinkId() + 1;
    StringBuilder linkId = new StringBuilder();
    String finalShortUrl="https://ttnurl.tk/";
    int tempCount=count;
    if (tempCount==0){
      finalShortUrl=finalShortUrl+String.valueOf(base64chars[0]);
    }else{
      while (tempCount>0){
        linkId.append(base64chars[(int) tempCount%base]);
        tempCount=tempCount/base;
      }
    }
    finalShortUrl=finalShortUrl+linkId.reverse().toString();

    Link newLink=new Link();
    newLink.setId(count);
    newLink.setOriginalLink(co.getLink());
    newLink.setShortLink(finalShortUrl);

    LinkInfo linkInfo= new LinkInfo();
    linkInfo.setId(count);
    linkInfo.setVisits(0);
    linkInfo.setLinkCreationTime(Date.valueOf(LocalDate.now()));
    linkInfo.setLinkExpirationTime(Date.valueOf(LocalDate.now().plusDays(10)));
    linkInfoRepository.save(linkInfo);
    linkRepository.save(newLink);
    return new LinkShortenDTO(co.getLink(),finalShortUrl,finalShortUrl.split(".tk/")[1]);
  }

  @Override
  public LinkExpandDTO expandLink(LinkExpandCO co) throws ApiRequestException {

    int decode = getDecodedValue(co.getLinkId());
    LinkInfo linkInfo= linkInfoRepository.findById(decode).get();
    if (linkInfo.getLinkExpirationTime().after(Date.valueOf(LocalDate.now()))){

      linkInfo.setVisits(linkInfo.getVisits()+1);
       String referValue=co.getReferrer() !=null && !co.getReferrer().equals("") && !co.getReferrer().contains("ttnurl.tk")?co.getReferrer():"direct";
      if (!linkInfo.getRefers().stream().anyMatch(refer-> refer.equals(referValue))){
        List<String> referer = linkInfo.getRefers();
        referer.add(referValue);
        linkInfo.setRefers(referer);
      }
      linkInfoRepository.save(linkInfo);
      Link link=linkRepository.findById(decode).get();

      return new LinkExpandDTO(link.getOriginalLink());
    }else{
      throw new ApiRequestException("Link is expired!");
    }


  }

  private int getDecodedValue(String linkId) {
    char[] linkChars= linkId.toCharArray();
    int len = linkChars.length;
    int counter=1;
    int decode=0;
    for (int i = 0; i < len; i++) {
      decode+=allowedString.indexOf(linkChars[i])*Math.pow(base,len-counter);
      counter+=1;
    }
    return decode;
  }

  @Override
  public LinkInfoDTO getLinkInfo(String linkId) {
    if (linkId.equals("")){
      throw new ApiRequestException("Invalid linkId");
    }else{
      int decode = getDecodedValue(linkId);
      Link link= linkRepository.findById(decode).orElseThrow(()->new ApiRequestException("Link not found!"));
      LinkInfo linkInfo= linkInfoRepository.findById(decode).orElseThrow(()->new ApiRequestException("Link not found!"));
      return new LinkInfoDTO(link.getOriginalLink(),link.getShortLink(),linkInfo);  
    }
  }
}
