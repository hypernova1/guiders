package com.guiders.web.essay.domain;

import com.guiders.web.member.domain.GuiderVO;

public class EssayVO extends GuiderVO{

	private Integer eno;
	private String email;
	private String field;
	private String lang;
	private String etitle;
	private String econtent;
	private Integer likecnt;
	private String regdate;

	public Integer getEno() {
		return eno;
	}

	public void setEno(Integer eno) {
		this.eno = eno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getEtitle() {
		return etitle;
	}

	public void setEtitle(String etitle) {
		this.etitle = etitle;
	}

	public String getEcontent() {
		return econtent;
	}

	public void setEcontent(String econtent) {
		this.econtent = econtent;
	}

	public Integer getLikecnt() {
		return likecnt;
	}

	public void setLikecnt(Integer likecnt) {
		this.likecnt = likecnt;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "EssayVO [eno=" + eno + ", email=" + email + ", field=" + field + ", lang=" + lang + ", etitle=" + etitle
				+ ", econtent=" + econtent + ", likecnt=" + likecnt + ", regdate=" + regdate + "]";
	}

}
