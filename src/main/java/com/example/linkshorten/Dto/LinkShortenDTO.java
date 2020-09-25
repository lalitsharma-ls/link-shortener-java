package com.example.linkshorten.Dto;

/**
 * @project linkshorten
 * @Author Lalit Sharma on 21/09/20
 **/
public class LinkShortenDTO {
  private String originalLink;
  private String shortenLink;
  private String id;

  public LinkShortenDTO(String originalLink, String shortenLink, String id) {
    this.originalLink = originalLink;
    this.shortenLink = shortenLink;
    this.id = id;
  }

  public String getOriginalLink() {
    return originalLink;
  }

  public void setOriginalLink(String originalLink) {
    this.originalLink = originalLink;
  }

  public String getShortenLink() {
    return shortenLink;
  }

  public void setShortenLink(String shortenLink) {
    this.shortenLink = shortenLink;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
