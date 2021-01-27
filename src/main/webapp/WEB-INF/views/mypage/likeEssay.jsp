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
		          <div class="writer">${essay.name}</div>
		          <div class="field">${essay.field}</div>
		          <div class="lang">${essay.lang}</div>
		          <div class="title">${essay.title}</div>
		          <div class="regdate">${essay.regDate}</div>
		        </li>
	      </c:forEach>
<!--         <li id="li-head">
          <div class="writer">가이더</div>
          <div class="field">분야</div>
          <div class="lang">언어</div>
          <div class="title">제목</div>
          <div class="regdate">등록일</div>
        </li>
        <li data-mno="1">
          <div class="writer">바흐</div>
          <div class="field">진로</div>
          <div class="lang">C++</div>
          <div class="title">피아노로 코딩하기</div>
          <div class="regdate">2018-01-01</div>
        </li>
        <li data-mno="2">
          <div class="writer">모차르트</div>
          <div class="field">팁</div>
          <div class="lang">JAVA</div>
          <div class="title">오페라로 대화하는 법</div>
          <div class="regdate">2018-01-01</div>
        </li> -->
      </ul>
    </article>
  </section>

<%@ include file="../include/footer.jsp" %>