package com.guiders.web.guiders.domain;

public class MentoringVO {
  
  private Integer mtrno;
  private String follower;
  private String guider;
  private String field;
  private String lang;
  private String mtitle;
  private String mcontent;
  private String mreply;
  private String regdate;
  private String replydate;
  private Integer likecnt;
  
  
  public String getField() {
    return field;
  }
  public void setField(String field) {
    this.field = field;
  }
  public String getLang() {
    return lang;
  }
  public void setLang(String lang) {
    this.lang = lang;
  }
  public Integer getMtrno() {
    return mtrno;
  }
  public void setMtrno(Integer mtrno) {
    this.mtrno = mtrno;
  }
  public String getFollower() {
    return follower;
  }
  public void setFollower(String follower) {
    this.follower = follower;
  }
  public String getGuider() {
    return guider;
  }
  public void setGuider(String guider) {
    this.guider = guider;
  }
  public String getMtitle() {
    return mtitle;
  }
  public void setMtitle(String mtitle) {
    this.mtitle = mtitle;
  }
  public String getMcontent() {
    return mcontent;
  }
  public void setMcontent(String mcontent) {
    this.mcontent = mcontent;
  }
  public String getMreply() {
    return mreply;
  }
  public void setMreply(String mreply) {
    this.mreply = mreply;
  }
  public String getRegdate() {
    return regdate;
  }
  public void setRegdate(String regdate) {
    this.regdate = regdate;
  }
  public String getReplydate() {
    return replydate;
  }
  public void setReplydate(String replydate) {
    this.replydate = replydate;
  }
  public Integer getLikecnt() {
    return likecnt;
  }
  public void setLikecnt(Integer likecnt) {
    this.likecnt = likecnt;
  }
  
}
