package com.guiders.web.member.domain;

public class GuiderVO extends MemberVO {

  private String introdution;
  private String currentjob;
  private String dept;
  private String quote;
  private String field;
  private String lang;
  
  public String getCurrentjob() {
    return currentjob;
  }
  public void setCurrentjob(String currentjob) {
    this.currentjob = currentjob;
  }
  public String getDept() {
    return dept;
  }
  public void setDept(String dept) {
    this.dept = dept;
  }
  public String getIntrodution() {
    return introdution;
  }
  public void setIntrodution(String introdution) {
    this.introdution = introdution;
  }
  public String getQuote() {
    return quote;
  }
  public void setQuote(String quote) {
    this.quote = quote;
  }
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
}
