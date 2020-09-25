package com.example.linkshorten.Dto;

import com.example.linkshorten.entity.LinkInfo;

/**
 * @project linkshorten
 * @Author Lalit Sharma on 22/09/20
 **/
public class LinkInfoDTO {

  private String originalLink;
  private String shortLink;
  private LinkInfo analytics;

  public LinkInfoDTO() {
  }

  public LinkInfoDTO(String originalLink, String shortLink, LinkInfo analytics) {
    this.originalLink = originalLink;
    this.shortLink = shortLink;
    this.analytics = analytics;
  }

  public String getOriginalLink() {
    return originalLink;
  }

  public void setOriginalLink(String originalLink) {
    this.originalLink = originalLink;
  }

  public String getShortLink() {
    return shortLink;
  }

  public void setShortLink(String shortLink) {
    this.shortLink = shortLink;
  }

  public LinkInfo getAnalytics() {
    return analytics;
  }

  public void setAnalytics(LinkInfo analytics) {
    this.analytics = analytics;
  }
}
