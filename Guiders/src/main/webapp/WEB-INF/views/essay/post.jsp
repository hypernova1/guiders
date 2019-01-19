<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<link rel="stylesheet" href="/css/essay/post.css">

<section>
  <article>
    <div id="mtr-info">
<!--         <img src="https://media.wnyc.org/i/800/0/l/85/1/bach.png">
        <div class="mtr-name">바흐</div> -->
    </div>
    <div id="field">진로</div>
    <div id="lang">C++</div>
    <h1 id="title">${map.etitle}</h1>
    <div id="content">${map.econtent}</div>
  </article>
  <div id="like">
    <span>♥ ${map.likecnt}</span>
  </div>
  <div id="mtr-detail">
    <img id="mtr-img" src="https://media.wnyc.org/i/800/0/l/85/1/bach.png">
    <div class="mtr-name">
      <span>${map.mname}</span>
      <span>멘토</span>
      <div class="follow-btn">팔로우</div>
      <div class="qna-btn">질문하기</div>
      <div id="mtr-btn-wrap">
        <div id="mtr-essay-btn">
          작성 에세이 보기
        </div>
        <div id="mtr-page-btn">
          멘토 상세정보
        </div>
      </div>
    </div>
  </div>
</section>

<%@ include file="../include/footer.jsp" %>