<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Guiders</title>
<style>
@font-face {
  font-family: 'yoon';
  src: url('/font/HANYOONGOTHIC760.TTF') format('truetype');
}
*, *::before, *::after {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}
body {
  font-family: 'yoon';
}
header {
  top: 0;
  opacity: 0.98;
  width: 100%;
  height: 64px;
  position: fixed;
  background-color: white;
  padding: 10px;
  border-bottom: 1px solid #b2bec3;
  z-index: 1;
}
#header-content {
  width: 80%;
  margin: auto;
}

nav {
  display:flex;
  float: right;
}
.menu-content {
  display: inline-block;
  margin: 0 5px;
  margin-top: 10px;
  font-size: 1.3rem;
  cursor: pointer;
  user-select: none;
}
.menu-content:nth-child(4) {
  margin-left: 30px;
}
.menu-content>span:hover {
  color: #ff2d55;
  transition: 0.3s;
}
#logo {
  width: 120px;
  height: 50px;
  margin-left: 20px;
  cursor: pointer;
}
#mypage{
  width: 30px;
  height: 30px;
}
#mypage-list {
  overflow: hidden;
  position: fixed;
  top: 60px;
  height: 0;
  list-style: none;
  font-size: 1rem;
  border: 1px solid white;
  background-color: white;
  transition: height 0.3s;
}
#mypage-list>li {
  padding: 5px 20px;
}
#mypage-list>li:hover {
  background: #dcdde1;
  transition: 0.3s;
}
a{
  text-decoration: none;
  color: black;
}
#login-modal{
  position: fixed;
  display: none;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: 1;
}
#login-modal-content{
  position: fixed;
  left: 50%;
  top: 50%;
  width: 450px;
  height: 420px;
  text-align: center;
  transform: translate(-50%, -50%);
  border: 1px solid #95a5a6;
  border-radius: 4px;
  box-shadow: 1px 1px 2px;
  padding: 10px;
  background: white;
  animation: 0.5s move;
}
#modal-title{
  margin: 20px 0 40px 0;
}
#id, #password{
  font-weight: bold;
  margin: 20px;
}
#id>label, #password>label{
  display: block;
  margin-left: 70px;
  text-align: left;
  font-size: 1.2rem;
}
#id>input, #password>input{
  margin-top: 10px;
  width: 250px;
  height: 40px;
  border-radius: 4px;
  padding: 8px;
  border: 1px solid#95a5a6;
}
#modal-content>div:nth-child(3){
  margin-top: 20px;
}
#login-modal-content button{
  all: unset;
  border: 1px solid white;
  background: #ff2d55;
  color: white;
  padding: 10px 15px;
  border-radius: 4px;
  font-weight: bold;
  cursor: pointer;
}
#login-modal-content button:hover{
  background: black;
  color: #ff2d55;
  transition: 0.3s;
}
#etc{
  margin-top: 30px;
  font-size: 0.9rem;
  color: #7f8c8d;
  font-weight: 500;
}
#join-btn, #pwd-btn{
  cursor: pointer;
}
#join-btn:hover, #pwd-btn:hover{
  text-decoration: underline;
}
@keyframes move {
  0%{
    top: 0;
  }
  50% {
    top: 70%;
  }
  100%{
    top: 50%;
  }
}
.search-box {
    top: 18%;
    left: 22%;
    position: absolute;
    /* transform: translate(-50%, -50%); */
    background: white;
    height: 50px;
    border-radius: 40px;
    padding: 10px;
}

.span-word{
    font-weight: bold;
    position: relative;
    top: 2px;
}

.search-box:hover{
    border: 3px solid #ff2d55;
}

.search-box:hover>.search-txt {
    width: 240px;
    padding: 0 6px;
}

.search-box:hover>.search-btn {
    background: white;
    color: black;
}
.search-box:hover>.span-word{
    display: none;
}

.search-btn {
    color: #e84118;
    float: right;
    width: 30px;
    height: 30px;
    border-radius: 50%;
    background:white;
    display: flex;
    justify-content: center;
    align-items: center; 
    transition: 0.4s;
    color: white;
    cursor: pointer;
}

.search-btn>i {
    position: relative;
    font-size: 20px;
    color: #ff2d55;
}

.search-txt {
    border: none;
    background: none;
    outline: none;
    float: left;
    padding: 0;
    color: black;
    font-size: 15px;
    transition: 0.4s;
    width: 0px;
    line-height: 30px;
    font-weight: bold;
}

.logo, .search-box{
  float: left;
}

</style>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
    crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<header>
    <div id="header-content">
      <div class="search-box">
          <span class="span-word">검색</span>
          <input type="text" name="searchText" class="search-txt" placeholder="검색어 입력" />
          <a class="search-btn">
              <i class="fas fa-search"></i>
          </a>
      </div>
      <nav>
        <div class="menu-content"><span id="guiders">Guiders</span></div>
        <div class="menu-content"><span>Meeting</span></div>
        <div class="menu-content"><span id="essay">Essay</span></div>
        <div class="menu-content"><img src="/img/iconmonstr-user-circle-thin.svg" id="mypage">
        <c:if test="${pageContext.request.userPrincipal.name != null}">
        <div class="menu-content"><span>${pageContext.request.userPrincipal.name}님</span></div>
        </c:if>
        <c:choose>
          <c:when test="${pageContext.request.userPrincipal.name != null}">
          <ul id="mypage-list">
            <li>My Guiders</li>
            <li><a href="/mypage/likeEssay">Like Essay</a></li>
            <li><a href="/mypage/edit">정보수정</a></li>
            <li><a href="/signout">Logout</a></li>
          </ul>
          </c:when>
          <c:otherwise>
           <ul id="mypage-list">
            <li id="login">Login</li>
          </ul>
          </c:otherwise>
        </c:choose>
        </div>
      </nav>
      <img src="/img/logo.png" id="logo">
    </div>
  </header>
  
  <div id="login-modal">
    <div id="login-modal-content">
      <h1 id="modal-title">Login</h1>
      <div id="id">
        <label>아이디</label>
        <input type="text">
      </div>
      <div id="password">
        <label>비밀번호</label>
        <input type="password">
      </div>
      <div>
        <button>로그인</button>
        
      </div>
      <div id="etc">
        <span id="join-btn">회원가입</span>
        l
        <span id="pwd-btn">비밀번호 찾기</span>
      </div>
    </div>
  </div>
<script>
  const mypageList = document.querySelector('#mypage-list');
  document.querySelector('#mypage').addEventListener('click', function () {
    mypageList.classList.toggle('active');
    mypageList.style.height = mypageList.classList.contains('active') ? mypageList.scrollHeight + 'px' : 0;
    mypageList.style.borderColor = mypageList.classList.contains('active') ? '#f5f6fa' : '';
  });
  
  document.querySelector('#logo').addEventListener('click', function(){
      location.href = '/';
  });
  
  document.querySelector('#essay').addEventListener('click', function(){
      location.href = '/essay/list';
  });
  
  document.querySelector('#guiders').addEventListener('click', function(){
      location.href = '/guiders';
  });
  
  const modal = document.querySelector('#login-modal');
  document.querySelector('#login').addEventListener('click', function(){
      mypageList.classList.toggle('active');
      mypageList.style.height = mypageList.classList.contains('active') ? mypageList.scrollHeight + 'px' : 0;
      mypageList.style.borderColor = mypageList.classList.contains('active') ? '#f5f6fa' : '';
      let i = 1;
      modal.style.display = 'block';
      const increase = setInterval(function(){
        if (i == 51) {
          clearInterval(increase);
        } else {
          modal.style.backgroundColor = 'rgba(0, 0, 0,' + 0.01 * i + ')';
          i++;
        }
      }, 10);
    });

    window.addEventListener('click', function(e) {
      if(e.target.id == 'login-modal') {
        let i = 50;
        const decrease = setInterval(function(){
          if(i == -1) {
            modal.style.display = 'none';
            clearInterval(decrease);
          } else {
            modal.style.backgroundColor = 'rgba(0, 0, 0,' + 0.01 * i + ')';
            i--;
          }
        }, 10);
      }
    });
</script>