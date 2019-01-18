<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Guiders</title>
<link rel="stylesheet" href="/css/include/header.css">
<link rel="stylesheet"
  href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
  integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
  crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script src="/js/include/header.js" defer></script>
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
        ${pageContext.request.userPrincipal.name}
        <c:if test="${pageContext.request.userPrincipal.name != null}">
	        <div class="menu-content">
	          <span>${pageContext.request.userPrincipal.name}님</span>
	        </div>
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
      <form id="form" action="./j_spring_security_check" method="post">
      <div id="id">
        <label>아이디</label>
        <input type="text" name="email" id="email">
      </div>
      <div id="password">
        <label>비밀번호</label>
        <input type="password" name="password" id="password">
      </div>
      <div>
        <button type="button" onclick="signin()">로그인</button>
        
      </div>
      </form>
      <div id="etc">
        <span id="join-btn">회원가입</span>
        l
        <span id="pwd-btn">비밀번호 찾기</span>
      </div>
    </div>
  </div>