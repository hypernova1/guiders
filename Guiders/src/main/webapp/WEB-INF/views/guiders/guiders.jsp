<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<link rel="stylesheet" href="/css/guiders/styles.css">
<link rel="stylesheet" href="/css/guiders/modal.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="/js/guiders/guiders.js" defer></script>
<section>
	<div class="select-type">
		<ul>
			<li>
				<button>진로</button>
			</li>
			<li>
				<button>취업</button>
			</li>
			<li>
				<button>커리큘럼</button>
			</li>
			<li>
				<button>전문언어</button>
			</li>
		</ul>
	</div>

	<div class="guider-wrapper"></div>

	<div id="modal" class="modal">
		<div class="modal-content">
			<span class="close">&times;</span>
			<div class="modal-content-title">
				<img src="/img/1.png"><br>
				<p>
					<strong style="color: #ff2d55">김멘토</strong>님 정보
				</p>
				<p>근무 회사 : Coupang</p>
				<p>담당 부서 : UI Design</p>
				<p>가이드 분야 : 취업 상담</p>
				<br>
				<p style="color: rgb(199, 54, 34)">가이드 정보</p>
				<p>답변률 : 82% / 답변수 : 23 / 팔로워 : 54 / 등급 : Silver</p>
				<br>

			</div>
			<div class="modal-content-body">
				<p style="color: rgb(32, 51, 158)">주요 경력</p>
				<div>
					현) 2018.9~ 현재 스투트가르트 스포츠카(주) 포르쉐 서초센터 사원 세일즈 영업관리<br> 전)
					2017.8~2018.8 한국닛산 상품기획팀 사원 <br> 2016.12~2017.6 한국국제협력단 파키스탄
					해외사무소 인턴십 <br> 2014.12~2015.12 K-move 멘토링 해외취업 멘티활동
				</div>
			</div>
		</div>
	</div>

</section>
<%@ include file="../include/footer.jsp"%>

</body>
</html>