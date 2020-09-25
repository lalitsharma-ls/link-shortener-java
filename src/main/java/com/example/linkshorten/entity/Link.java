package com.example.linkshorten.entity;

import javax.persistence.*;

/**
 * @project linkshorten
 * @Author Lalit Sharma on 21/09/20
 **/
@Entity
public class Link {

  @Id
  private Integer id;
  private String originalLink;
  private String shortLink;

  public Link() {
  }

  public Link(Integer id, String originalLink, String shortLink) {
    this.id = id;
    this.originalLink = originalLink;
    this.shortLink = shortLink;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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
}
