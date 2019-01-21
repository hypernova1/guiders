<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../include/header.jsp"%>

<link rel="stylesheet" href="/css/mypage/qna.css">
<script src="/js/mypage/qna.js" defer></script>
  <section>
    <input type="hidden" value="${mentoring.mtrno}" id="mtrno">
    <div id="question">
      <h1 id="title">Q. ${mentoring.mtitle}</h1>
      <div id="field">${mentoring.field}</div>
      <div id="lang">${mentoring.lang}</div>
      <div id="regdate">등록일: ${mentoring.regdate}</div>
      <div class="content">
        ${mentoring.mcontent}
      </div>
    </div>
    <h2 id="answer-title">Guider's Answer..</h2>
    <c:if test="${mentoring.mreply != null}">
    <div id="replydate">답변일: ${mentoring.replydate}</div>
    </c:if>
    <div id="answer">
      <div class="content">
        <c:choose>
			    <c:when test="${pageContext.request.userPrincipal.name eq guider.mname and mentoring.mreply == null}">
			      <textarea id="answer-textarea" placeholder="답변을 달아주세요."></textarea>
			    </c:when>
		      <c:when test="${mentoring.mreply != null}">
		        ${mentoring.mreply}
		      </c:when>
		      <c:otherwise>아직 답변이 등록되지 않았습니다.</c:otherwise>
        </c:choose>
      </div>
      <c:if test="${pageContext.request.userPrincipal.name eq guider.mname and mentoring.mreply == null}">
      <div id="btn-wrap">
        <button class="btn" id="reply-btn">등록</button>
      </div>
      </c:if>
    </div>
    <div id="mtr-detail">
        <img id="mtr-img" src="https://media.wnyc.org/i/800/0/l/85/1/bach.png">
        <div class="mtr-name">
          <span>${guider.mname}</span>
          <span>멘토</span>
          <div id="mtr-btn-wrap">
            <div id="mtr-essay-btn">작성 에세이 보기</div>
            <div id="mtr-page-btn">멘토 상세정보</div>
          </div>
        </div>
      </div>
    <button class="btn" id="return-page">돌아가기</button>
  </section>
<%@ include file="../include/footer.jsp"%>

