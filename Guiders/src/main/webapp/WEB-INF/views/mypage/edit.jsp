<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
  <style>
    *, *::before, *::after{
      margin: 0;
      padding: 0;
      box-sizing: border-box;
    }
    #wrapper{
      margin: 8% 5%;
    }
    aside{
      float: left;
      height: 700px;
    }
    aside>ul{
      list-style: none;
      border-right: 1px solid #bdc3c7;
      padding: 2rem;
      text-align: center;
    }
    aside>ul>li{
      padding: 10px;
      font-size: 1.2rem;
      user-select: none;
      cursor: pointer;
      color: #7f8c8d;
    }
    aside>ul>li:hover{
      text-decoration: underline;
      text-decoration-color:#7f8c8d;
    }
    section{
      text-align: center;
    }
    section>h2{
      text-align: center;
    }
    #input-wrapper {
      margin: 2rem 0 1rem;
    }
    label{
      display: inline-block;
      margin: 10px;
      width: 80px;
      text-align: right;
      font-weight: bold;
    }
    input{
      all:unset;
      font-size: 1.2rem;
      margin: 0.5rem auto;
      padding: 0 1rem;
      width: 300px;
      height: 40px;
      border: 1px solid #95a5a6;
      border-radius: 4px;
      text-align: left;
    }
    ::placeholder {
      color: #bdc3c7;
    }
    input[readonly]{
      background-color: #ecf0f1;
      cursor: no-drop;
    }
    .btn{
      all: unset;
      display: inline-block;
      font-size: 1rem;
      padding: 10px 15px;
      margin: 5px;
      color: white;
      border-radius: 4px;
      border-color: white;
      background-color: #ff2d55;
      user-select: none;
      cursor: pointer;
    }
    textarea{
      width: 332px;
      height: 200px;
      padding: 4px;
      resize: none;
      border-radius: 4px;
    }
    form>div{
      display: inline-block;
      width: 450px;
    }
    #btn-wrap{
      margin-top: 30px;
    }
  </style>
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
