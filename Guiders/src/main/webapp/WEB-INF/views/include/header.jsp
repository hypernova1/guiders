<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Guiders</title>
<link rel="icon" type="image/png"  href="/img/guiders.png"/>
<link rel="stylesheet" href="/css/include/header.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
	integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script src="/js/include/header.js" defer></script>
<script src="/js/common/ajax.js"></script>
</head>
<body>
	<header>
		<div id="header-content">
			<div class="search-box">
				<span class="span-word">검색</span> <input type="text"
					name="searchText" class="search-txt" placeholder="검색어 입력" /> <a
					class="search-btn"> <i class="fas fa-search"></i>
				</a>
			</div>
			<nav>
				<div class="menu-content">
					<span id="guiders">Guiders</span>
				</div>
				<!-- <div class="menu-content">
					<span>Meeting</span>
				</div> -->
				<div class="menu-content">
					<span id="essay">Essay</span>
				</div>
				<div class="menu-content">
					<img src="/img/iconmonstr-user-circle-thin.svg" id="mypage">

					<c:choose>
						<c:when test="${pageContext.request.userPrincipal.name != null}">
							<ul id="mypage-list">
								<c:choose>
									<c:when test="${pageContext.request.userPrincipal.authorities eq '[ROLE_GUIDER]'}">
										<li><a href="/mypage/questions">Questions</a></li>
									</c:when>
									<c:otherwise>
										<li><a href="/mypage/myGuider">My Guiders</a></li>
									</c:otherwise>
								</c:choose>
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
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <div class="menu-content">
              <span>${pageContext.request.userPrincipal.name}님</span>
            </div>
          </c:if>
			</nav>
			<img src="/img/logo.png" id="logo">
		</div>
	</header>

	<div id="login-modal">
		<div id="login-modal-content">
			<h1 id="modal-title">Login</h1>
			<form id="form" action="./j_spring_security_check" method="post">
				<div id="id">
					<label>아이디</label> <input type="text" name="email" id="email">
				</div>
				<div id="password">
					<label>비밀번호</label> <input type="password" name="password"
						id="password">
				</div>
				<div>
					<button type="button" onclick="signin()">로그인</button>

				</div>
			</form>
<!-- 			<div id="etc">
				<span id="join-btn"><a href="/join">회원가입</a></span> l <span id="pwd-btn">비밀번호 찾기</span>
			</div> -->
		</div>
	</div>
	
	<div id="login-fail-modal">
	  <div id="login-fail-modal-content">
	    <div>회원 정보가 맞지 않습니다.</div>
	    <button class="btn">확인</button>
	  </div>
	</div>

	<form id="mtr-modal">
		<section id="mtr-modal-body">
			<h2>
				<span></span>에게 질문
			</h2>
			<article>
				<div id="select-wrap">
					<div id="field"></div>
					<div id="lang"></div>
				</div>
				<div id="title">
					<input type="text" name="mtitle">
				</div>
				<div id="content">
					<textarea name="mcontent"></textarea>
				</div>
			</article>
			<div id="btn-wrap">
				<button type="button" id="mtr-submit">등록</button>
				<button type="button" id="mtr-cancel">취소</button>
			</div>
			<input type="hidden" id="guider-email">
		</section>
	</form>