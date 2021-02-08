<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="../include/header.jsp" %>

<link rel="stylesheet" href="/css/mypage/question.css">
<section>
    <article>
        <ul>
            <li id="li-head">
                <div class="writer">팔로워</div>
                <div class="field">분야</div>
                <div class="lang">언어</div>
                <div class="title">제목</div>
                <div class="regDate">질문날짜</div>
            </li>
            <c:forEach items="${mentoringList}" var="mentoring">
                <li data-mtrno="${mentoring.id}">
                    <div class="writer">${mentoring.writer}</div>
                    <div class="field">${mentoring.field}</div>
                    <div class="lang">${mentoring.lang}</div>
                    <div class="title"><span><a href="/mentoring/${mentoring.id}">${mentoring.title}</a></span>
                        <c:choose>
                            <c:when test="${mentoring.answerDate == null}">
                                <span class="answer-waiting">[답변대기 중]</span>
                            </c:when>
                            <c:otherwise>
                                <span class="answer-complete">[답변 완료]</span>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <div class="regDate">${mentoring.createdDate}</div>
                </li>
            </c:forEach>
        </ul>
    </article>
</section>
<%@ include file="../include/footer.jsp" %>