<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<link rel="stylesheet" href="/css/mypage/myGuider.css">
<link rel="stylesheet" href="/css/guiders/modal.css">


<section>
	<div class="filter">
		<ul>
			<li class="all"><a> <span>전체</span>
			</a></li>
			<li class="name-asc"><a> <span>이름순</span>
			</a></li>
			<li class="date-desc"><a> <span>날짜순</span>
			</a></li>
			<li class="follower-count"><a> <span>팔로워수</span>
			</a></li>
		</ul>
	</div>

	<div class="title">

	</div>
	<div id="modal" class="modal">
		<div class="modal-content">
<!-- 			<span class="close">&times;</span> -->
			<div class="modal-content-title">
				<img src=""><br>
				<div>
					<strong style="color: #ff2d55"></strong>
					<span> 가이더</span>
				</div>
				<div id="current-job">
				  <span>근무 회사: </span>
				  <span></span>
				</div>
				<div id="dept">
				  <span>담당 부서: </span>
				  <span></span></div>
				<div id="field2">
				  <span>가이드 분야: </span>
				  <span></span>
				</div>
				<div  id="guider-info" style="color: rgb(199, 54, 34)">가이드 정보</div>
				<div>답변률 : 82% / 답변수 : 23 / 팔로워 : 54 / 등급 : Silver</div>
				<br>
			</div>
			<div class="modal-content-body">
				<p style="color: rgb(32, 51, 158)">주요 경력</p>
				<div></div>
			</div>
		</div>
	</div>
</section>

<script src="/js/mypage/myGuider.js" defer></script>

</body>

</html>