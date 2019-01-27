package com.guiders.web.util;

public class PageCriteria {

  private int page;
  private int perPageNum;
  private String keyword;

  public PageCriteria() {
    this.page = 1;
    this.perPageNum = 5;
    this.keyword = "";
  }

  public int getPage() {
    return page;
  }

  public int getPerPageNum() {
    return perPageNum;
  }

  public void setPage(int page) {
    if (page <= 0) {
      return;
    } else {
      this.page = page;
    }
  }

  public void setPerPageNum(int perPageNum) {
    if (perPageNum < 5 || perPageNum > 25) {
      return;
    } else {
      this.perPageNum = perPageNum;
    }
  }

  public void setKeyword(String keyword) {
    this.keyword = keyword;
  }

  public Integer getPageStart() {
    return (this.page - 1) * perPageNum;
  }

  public String getKeyword() {
    return keyword;
  }

}
