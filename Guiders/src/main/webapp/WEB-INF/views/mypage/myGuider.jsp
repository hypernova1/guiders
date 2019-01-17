<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<<<<<<< HEAD
<link rel="stylesheet" href="/css/mypage/myGuider">
=======
section {
	/*margin: 130px 5%;
    text-align: center;*/
	top: 0;
	width: 100%;
	position: relative;
}

section {
	top: 0;
	margin: 130px 5%;
}

.title { /* 팔로워 리스트 크기 조정 */
	width: 1000px;
	margin-left: 190px;
	display: flex;
	flex-direction: column;
}

.title .follower-content {
	height: 200px;
	display: flex;
	border: 2px solid #6d6d72;
	border-radius: 20px;
	box-shadow: 0 2px 10px 0 rgba(0, 0, 0, 0.16), 0 2px 10px 0
		rgba(0, 0, 0, 0.12);
	list-style: none;
	margin-bottom: 5px; /* 프로필 밑쪽 간격 */
	padding-left: 30px;
	/* padding-right: 20px; */
}

.title .follower-content li {
	/* height: 100%;
            width: 100%; */
	/* display: flex;
            align-items: center; */
	/* margin: auto 0 auto 0; */
	margin: auto;
}

.title .follower-content li img { /* 프로필 사진 */
	width: 130px;
	height: 130px;
	border-radius: 50%;
}

.title .follower-content li p { /* li 안의 p태그 (글) */
	/* width: 100%;
            margin-bottom: 10px; */
	margin: 10px 0;
	user-select: none;
}

.title .follower-content li p:hover {
	text-decoration: underline;
	cursor: pointer;
}

.filter { /* 필터 크기 조정 */
	width: 1000px;
	margin-left: 190px;
	margin-bottom: 50px;
}

.filter>ul {
	display: flex;
	list-style: none;
	height: 60px;
	background-color: #fcfcfc;
}

.filter ul li {
	margin: auto;
	height: 100%;
	width: 100%;
	text-align: center;
	line-height: 3.7em;
}

.filter ul .all {
	border-top: 1px solid #6d6d72;
	border-right: 1px solid #6d6d72;
	background-color: white;
	font-weight: bold;
}

.filter ul .name-asc {
	border-top: 1px solid #6d6d72;
	border-bottom: 1px solid #6d6d72;
}

.filter ul .date-desc {
	border-top: 1px solid #6d6d72;
	border-bottom: 1px solid #6d6d72;
}

.filter ul .follower-cnt {
	border-top: 1px solid #6d6d72;
	border-bottom: 1px solid #6d6d72;
}

.unfollow-btn {
	all: unset;
	clear: both;
	text-align: center;
	height: 35px;
	background: #ff2d55;
	color: white;
	text-transform: uppercase;
	line-height: 38px;
	font-weight: 600;
	cursor: pointer;
	border: 3px solid #ff2d55;
	border-radius: 5px;
	/* text-shadow: 0 0 10px white */
}

.explain {
	list-style: none;
	position: absolute;
	width: 100%;
	margin-top: 10px;
	font-weight: bold;
}

.explain div {
	display: inline-block;
	width: 35%;
}

.explain div:nth-child(1) {
	padding-left: 130px;
}
</style>
>>>>>>> work1

<section>
	<div class="filter">
		<ul>
			<li class="all"><a> <span>전체</span>
			</a></li>
			<li class="name-asc"><a> <span>이름순</span>
			</a></li>
			<li class="date-desc"><a> <span>날짜순</span>
			</a></li>
			<li class="follower-cnt"><a> <span>팔로워수</span>
			</a></li>
		</ul>
	</div>

	<div class="title">
		<ul class="follower-content">
			<li class="explain">
				<div>멘토 정보</div>
				<div>질문글 : 3개</div>
			</li>
			<li><img src="/img/naruto.jpg"></li>
			<li>
				<p>근무 회사 : Coupang</p>
				<p>담당 부서 : UI Design</p>
				<p>가이드 분야 : 취업 상담</p>
			</li>
			<li>
				<p>호카게가 되려면 어떤 라인을 타야 할까요?</p>
				<p>3대 호카게 할아버지가 재산 꿀꺽한거 알고 있긴 하신가요</p>
				<p>나선환쪽 말고 다른 인술 사용할 생각은 없으신가요?</p>
			</li>
			<li>
				<button class="unfollow-btn">UNFOLLOW</button>
			</li>
		</ul>

		<ul class="follower-content">
			<li><img src="/img/naruto.jpg"></li>
			<li>
				<p>근무 회사 : Coupang</p>
				<p>담당 부서 : UI Design</p>
				<p>가이드 분야 : 취업 상담</p>
			</li>
			<li>
				<p>호카게가 되려면 어떤 라인을 타야 할까요??...</p>
				<p>3대 호카게 할아버지가 재산 꿀꺽한거 알고 있긴 하신가요...</p>
				<p>나선환쪽 말고 다른 인술 사용할 생각은 없으신가...</p>

			</li>
			<li><button class="unfollow-btn">UNFOLLOW</button></li>
		</ul>


		<ul class="follower-content">
			<li><img src="/img/naruto.jpg"></li>
			<li>
				<p>근무 회사 : Coupang</p>
				<p>담당 부서 : UI Design</p>
				<p>가이드 분야 : 취업 상담</p>
			</li>
			<li>
				<p>호카게가 되려면 어떤 라인을 타야 할까요?</p>
				<p>3대 호카게 할아버지가 재산 꿀꺽한거 알고 있긴 하신...</p>
				<p>나선환쪽 말고 다른 인술 사용할 생각은 없으신가..</p>

			</li>
			<li><button class="unfollow-btn">UNFOLLOW</button></li>
		</ul>


	</div>
</section>
<<<<<<< HEAD
=======
</body>

</html>
>>>>>>> work1
