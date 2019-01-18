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
			<li><img class="profile-img" src="/img/naruto.jpg"></li>
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
			<li><img class="profile-img" src="/img/naruto.jpg"></li>
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
			<li><img class="profile-img" src="/img/naruto.jpg"></li>
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
	<div id="modal" class="modal">
		<div class="modal-content">
			<span class="close">&times;</span>
			<div class="modal-content-title">
				<img src="/img/naruto.jpg"><br>
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

<script>
        var body = document.body;
        var guiderModal = document.getElementById("modal");
            
        var profileImg = document.getElementsByClassName("profile-img")[0];
        
            
        var modalSpan = document.getElementsByClassName("close")[0];
            
        profileImg.addEventListener("click",function(){
            guiderModal.style.display = "block";
            body.style.overflow = "hidden";
        });
            
        modalSpan.addEventListener("click", function(){
             guiderModal.style.display = "none";
             body.style.overflow = "";
        });
            
        window.addEventListener("click", function(){
            if(event.target == guiderModal){
                guiderModal.style.display = "none";
                body.style.overflow = "";
            }
            
/*             let i = 1;
            guiderModal.style.display = 'block';
            const increase = setInterval(function(){
              if (i == 51) {
                clearInterval(increase);
              } else {
                guiderModal.style.backgroundColor = 'rgba(0, 0, 0,' + 0.01 * i + ')';
                i++;
              }
            }, 10); */
            
        });

     </script>

</body>

</html>