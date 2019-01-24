package com.guiders.config.mybatis.config;

public class PageMaker {

	private Criteria cri;
	private int startPage, endPage;
	private boolean prev, next;
	private int displayNum;
	private int total;

	
	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayNum() {
		return displayNum;
	}

	public void setDisplayNum(int displayNum) {
		this.displayNum = displayNum;
	}

	public Criteria getCri() {
		return cri;
	}

	public int getTotal() {
		return total;
	}

	public PageMaker() {
		this.displayNum = 10;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}

	public void setTotal(int total) {
		this.total = total;
		calc();
	}

	public void calc() {
		endPage = (int) (Math.ceil((cri.getPage() / (double) displayNum)) * displayNum);
		startPage = (endPage - displayNum) + 1;
		prev = startPage == 1 ? false : true;
		next = endPage * cri.getPerPageNum() >= total ? false : true;

		int tempEndPage = (int) Math.ceil((total / (double) cri.getPerPageNum()));
		if (endPage > tempEndPage) {
			endPage = tempEndPage;
		}
	}
}
