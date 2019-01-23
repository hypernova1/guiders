package com.guiders.config.mybatis.config;

public class PageMaker {

	private Criteria cri;
	private int startPage, endPage;
	private boolean prev, next;
	private int displayNum;
	private int total;

	public PageMaker() {
		this.displayNum = 5;
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
