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
*,
*::before,
*::after {
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
  float: right;
  margin-right: 20px;
}
.menu-content {
  display: inline-block;
  margin: 0 5px;
  margin-top: 10px;
  font-size: 1.3rem;
  cursor: pointer;
  user-select: none;
}
.menu-content>span:hover {
  color: #ff2d55;
  transition: 0.3s;
}
#logo {
  width: 120px;
  height: 50px;
  padding: 10px 0;
  cursor: pointer;
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
</style>
</head>
<body>
<header>
    <div id="header-content">
      <nav>
        <div class="menu-content"><span id="guiders">Guiders</span></div>
        <div class="menu-content"><span>Meeting</span></div>
        <div class="menu-content"><span id="essay">Essay</span></div>
        <div class="menu-content"><span id="mypage">My Page</span>
          <ul id="mypage-list">
            <li>My Guiders</li>
            <li>Like Essay</li>
            <li><a href="/mypage/edit">정보수정</a></li>
            <li>Logout</li>
          </ul>
        </div>
      </nav>
      <img src="/img/logo.png" id="logo">
    </div>
  </header>
  <script>
    document.querySelector('#mypage').addEventListener('click', function () {
      const mypageList = document.querySelector('#mypage-list');
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
    })
  </script>