package com.example.linkshorten.Service;

import com.example.linkshorten.Co.LinkExpandCO;
import com.example.linkshorten.Co.LinkShortenCO;
import com.example.linkshorten.Dto.LinkExpandDTO;
import com.example.linkshorten.Dto.LinkInfoDTO;
import com.example.linkshorten.Dto.LinkShortenDTO;
import com.example.linkshorten.Exception.ApiRequestException;

import javax.servlet.http.HttpServletRequest;

/**
 * @project linkshorten
 * @Author Lalit Sharma on 21/09/20
 **/
public interface LinkService {

  LinkShortenDTO shortenLink(LinkShortenCO co);

  LinkExpandDTO expandLink(LinkExpandCO co) throws ApiRequestException;

  LinkInfoDTO getLinkInfo(String linkId);
}

