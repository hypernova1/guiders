<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<script src="/js/common/ajax.js" defer></script>
<link rel="stylesheet" href="/css/essay/post.css">

<section>
  <article>
    <div id="field">진로</div>
    <div id="lang">C++</div>
    <h1 id="title">${essayVO.etitle}</h1>
    <div id="content">${essayVO.econtent}</div>
  </article>
  <div id="like">
    <span id="likeSpan" style="font-weight: bold;">
	    <c:if test="${confirmLike == true}">♥</c:if>
	    <c:if test="${confirmLike == false}">♡</c:if>
	    ${essayVO.likecnt}
    </span>
    <form id="essayPostForm" action="/essay/delete" method="post">
      <input type="hidden" name="eno" value="${essayVO.eno}">
    </form>
    <c:if test="${pageContext.request.userPrincipal.name == essayVO.mname}">
        <button id="removeBtn" type="button">삭제</button>
        <button id="modifyBtn" type="button">수정</button>
    </c:if>
  </div>
  <div id="mtr-detail">
    <img id="mtr-img" src="${essayVO.photo}">
    <div class="mtr-name">
      <span>${essayVO.mname}</span>
      <span>멘토</span>
      <div class="follow-btn">팔로우</div>
      <div class="qna-btn">질문하기</div>
      <div id="mtr-btn-wrap">
        <div id="mtr-essay-btn">
          작성 에세이 보기
        </div>
        <div id="mtr-page-btn">
          멘토 상세정보
        </div>
      </div>
    </div>
  </div>
</section>

<script type="text/javascript" defer>
	const modifyBtn = document.querySelector('#modifyBtn');
	/* let likeIcon = document.querySelector('#likeSpan').innerText.substring(0, 1); */
	const removeBtn = document.querySelector('#removeBtn');
	
	if(modifyBtn){
		modifyBtn.addEventListener('click', function(){
				const eno = '${param.eno}';
				location.href = "/essay/modify?eno=" + eno;
		});
	}
	
	document.querySelector('#likeSpan').addEventListener('click', function(e){
		const email = '${userInfo.email}';
		if(!email){
			alert('로그인이 필요합니다.');
			/* console.log(document.querySelector('#login-modal')); */
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
			return;
		}
		const eno = '${param.eno}';
		let data = {email: email, eno: eno};
		ajax('/essay/'+eno, 'put', data).then(function(result){
			let cnt = result;
			console.log('좋아요 갯수 : ' + cnt);
			/* location.reload(true); */
			if(document.querySelector('#likeSpan').innerText.substring(0, 1) == '♡'){
				document.querySelector('#likeSpan').innerText = '♥'+ ' ' +cnt;
			}else if (document.querySelector('#likeSpan').innerText.substring(0, 1) == '♥'){
				document.querySelector('#likeSpan').innerText = '♡'+ ' ' +cnt;
			}
		});
	});
	
	if(removeBtn){
		removeBtn.addEventListener('click', function(e) {
			console.log('삭제 버튼 클릭');
			e.preventDefault();
			if(confirm('정말 삭제하시겠습니까?')){				
				  document.querySelector('#essayPostForm').submit();
			}
		});
	}
	
	
</script>

<%@ include file="../include/footer.jsp" %>