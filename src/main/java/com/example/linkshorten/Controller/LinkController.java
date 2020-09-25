package com.example.linkshorten.Controller;

import com.example.linkshorten.Co.LinkExpandCO;
import com.example.linkshorten.Co.LinkShortenCO;
import com.example.linkshorten.Dto.LinkExpandDTO;
import com.example.linkshorten.Dto.LinkInfoDTO;
import com.example.linkshorten.Dto.LinkShortenDTO;
import com.example.linkshorten.Exception.ApiRequestException;
import com.example.linkshorten.Service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @project linkshorten
 * @Author Lalit Sharma on 21/09/20
 **/
@RestController
@CrossOrigin
public class LinkController {

    @Autowired
    LinkService linkService;

    @GetMapping("/")
    private String indexHandle(){
      return "Welcome to link shorten service.";
    }

    @PostMapping("/link/short")
    private LinkShortenDTO linkShorten(@RequestBody LinkShortenCO co){
      return linkService.shortenLink(co);
    }

    @PostMapping("expand/")
    private LinkExpandDTO expandLink(@RequestBody LinkExpandCO co)
            throws IOException {
       return linkService.expandLink(co);
    }

    @GetMapping("/info/{linkId}")
    private LinkInfoDTO getLinkInfo(@PathVariable("linkId") String linkId){
      return linkService.getLinkInfo(linkId);
    }

}
