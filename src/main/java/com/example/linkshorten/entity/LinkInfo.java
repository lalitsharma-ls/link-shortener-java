package com.example.linkshorten.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * @project linkshorten
 * @Author Lalit Sharma on 21/09/20
 **/
@Entity
public class LinkInfo {
  @Id
  private Integer id;

  private Integer visits;

  private Date linkCreationTime;

  private Date linkExpirationTime;

  @ElementCollection(targetClass = String.class)
  private List<String> refers = new ArrayList<>();
  public LinkInfo() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getVisits() {
    return visits;
  }

  public void setVisits(Integer visits) {
    this.visits = visits;
  }

  public Date getLinkCreationTime() {
    return linkCreationTime;
  }

  public void setLinkCreationTime(Date linkCreationTime) {
    this.linkCreationTime = linkCreationTime;
  }

  public Date getLinkExpirationTime() {
    return linkExpirationTime;
  }

  public void setLinkExpirationTime(Date linkExpirationTime) {
    this.linkExpirationTime = linkExpirationTime;
  }


  public List<String> getRefers() {
    return refers;
  }

  public void setRefers(List<String> refers) {
    this.refers = refers;
  }
}
