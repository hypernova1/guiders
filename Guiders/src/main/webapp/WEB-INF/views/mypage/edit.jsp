<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<link rel="stylesheet" href="/css/mypage/edit.css">
<div id="wrapper">
  <aside>
    <ul>
      <li>My Guiders</li>
      <li>Like Essay</li>
      <li>Edit Infomation</li>
    </ul>
  </aside>
  <section>
    <h2>회원정보 수정</h2>
    <form id="input-wrapper">
      <div>
          <label>아이디</label>
          <input type="email" name="email" value="chtlstjd01@naver.com" readonly>
      </div>
      <div>
        <label>이름</label>
        <input type="text" placeholder="이름">
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
          <input type="text" placeholder="전화번호">
      </div>
      <div>
          <label>분야</label>
          <input type="text" placeholder="분야">
      </div>
      <div>
        <label>언어</label>
        <input type="text" placeholder="언어">
      </div>
      <div>
        <label>학력</label>
        <input type="text" placeholder="학력">
      </div>
      <div id="quote">
        <label>인용문</label>
        <textarea placeholder="인용문"></textarea>
      </div>
      <div>
        <label>경력란</label>
        <textarea placeholder="경력란"></textarea>
      </div>
      <div id="btn-wrap">
        <button type="submit" class="btn">수정</button>
      </div>
    </form>
  </section>
</div>
<%@ include file="../include/footer.jsp" %>
