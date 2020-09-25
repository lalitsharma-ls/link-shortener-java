package com.example.linkshorten.Dto;

/**
 * @project linkshorten
 * @Author Lalit Sharma on 25/09/20
 **/
public class LinkExpandDTO {
  private String originalLink;

  public LinkExpandDTO() {
  }

  public LinkExpandDTO(String originalLink) {
    this.originalLink = originalLink;
  }

  public String getOriginalLink() {
    return originalLink;
  }

  public void setOriginalLink(String originalLink) {
    this.originalLink = originalLink;
  }
}
