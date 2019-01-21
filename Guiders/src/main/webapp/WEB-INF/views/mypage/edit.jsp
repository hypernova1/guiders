<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<link rel="stylesheet" href="/css/mypage/edit.css">
<div id="wrapper">
  <aside>
    <ul>
      <li><a href="/mypage/myGuider">My Guiders</a></li>
      <li><a href="/mypage/likeEssay">Like Essay</a></li>
      <li><a href="/mypage/edit">Edit Infomation</a></li>
    </ul>
  </aside>
  <section>
    <h2>회원정보 수정</h2>
    <form id="input-wrapper" method="post">
      <div>
          <label>아이디</label>
          <input type="email" name="email" value="${vo.email}" readonly>
      </div>
      <div>
        <label>이름</label>
        <input type="text" name="mname" placeholder="이름" value="${vo.mname}">
      </div>
      <div>
        <label>비밀번호</label>
        <input type="password" name="password" placeholder="비밀번호">
      </div>
      <div>
        <label>재입력</label>
        <input type="password" placeholder="비밀번호 확인">
      </div>
      <div>
          <label>전화번호</label>
          <input type="text" name="phone" placeholder="전화번호" value="${vo.phone}">
      </div>
      <c:choose>
      <c:when test="${pageContext.request.userPrincipal.authorities eq '[ROLE_GUIDER]'}">
      <div>
          <label>분야</label>
          <input type="text" name="field" placeholder="분야" value="${vo.field}">
      </div>
      <div>
        <label>지역</label>
        <input type="text" name="ctno" placeholder="지역" value="${vo.ctno}">
      </div>
      <div>
        <label>언어</label>
        <input type="text" name="lang" placeholder="언어" value="${vo.lang}">
      </div>
      <div>
        <label>최근직장</label>
        <input type="text" name="currentjob" placeholder="언어" value="${vo.currentjob}">
      </div>
      <div>
        <label>부서</label>
        <input type="text" name="dept" placeholder="부서" value="${vo.dept}">
      </div>
      <div id="quote">
        <label>인용문</label>
        <textarea placeholder="인용문" name="quote">${vo.quote}</textarea>
      </div>
      <div>
        <label>경력란</label>
        <textarea placeholder="경력란" name="introdution">${vo.introdution}</textarea>
      </div>
      </c:when>
      <c:otherwise>
      <div></div>
      </c:otherwise>
      </c:choose>
      <div id="btn-wrap">
        <button type="submit" class="btn">수정</button>
      </div>
    </form>
  </section>
</div>
<%@ include file="../include/footer.jsp" %>
