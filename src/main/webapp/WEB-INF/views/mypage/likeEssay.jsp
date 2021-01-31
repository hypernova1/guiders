<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<link rel="stylesheet" href="/css/mypage/likeEssay.css">
<script src="/js/mypage/likeEssay.js" defer></script>
<section>
    <article>
      <ul>
	      <li id="li-head">
	          <div class="writer">가이더</div>
	          <div class="field">분야</div>
	          <div class="lang">언어</div>
	          <div class="title">제목</div>
	          <div class="regdate">등록일</div>
	      </li>
	      <c:forEach var="essay" items="${essayList}">
		        <li data-id="${essay.id}">
		          <div class="writer">${essay.writer}</div>
		          <div class="field">${essay.field}</div>
		          <div class="lang">${essay.lang}</div>
		          <div class="title">${essay.title}</div>
		          <div class="regdate">${essay.createdDate}</div>
		        </li>
	      </c:forEach>
      </ul>
    </article>
  </section>

<%@ include file="../include/footer.jsp" %>