<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<script src="/js/common/ajax.js" defer></script>
<link rel="stylesheet" href="/css/essay/post.css">

<section>
  <article>
    <div id="field">${essay.field}</div>
    <div id="lang">${essay.lang}</div>
    <h1 id="title">${essay.title}</h1>
    <div id="content">${essay.content}</div>
  </article>
  <div id="like">
    <span id="likeSpan" style="font-weight: bold;">
	    <c:if test="${confirmLike == true}">♥</c:if>
	    <c:if test="${confirmLike == false}">♡</c:if>
	    ${essay.likeCount}
    </span>
    <form id="essayPostForm" action="/essay/delete" method="post">
      <input type="hidden" name="id" value="${essay.id}">
    </form>
    <c:if test="${pageContext.request.userPrincipal.name == essay.name}">
        <button id="removeBtn" type="button">삭제</button>
        <button id="modifyBtn" type="button">수정</button>
    </c:if>
  </div>
  <div id="mtr-detail">
    <img id="mtr-img" src="${essay.writerPhotoUrl}">
    <div class="mtr-name">
      <span>${essay.name}</span>
      <span>멘토</span>
      <div class="follow-btn">팔로우</div>
      <div class="qna-btn">질문하기</div>
      <div id="mtr-btn-wrap">
        <div id="mtr-essay-btn">작성 에세이 보기</div>
        <div id="mtr-page-btn">멘토 상세정보</div>
      </div>
    </div>
  </div>
  <div id="button-wrap">
    <button id="listBtn">목록으로</button>
    <button id="beforeBtn">뒤로가기</button>
  </div>
</section>

<script>
	const modifyBtn = document.querySelector('#modifyBtn');
	const removeBtn = document.querySelector('#removeBtn');
	
	if(modifyBtn){
		modifyBtn.addEventListener('click', function(){
				const id = '${param.id}';
				location.href = "/essay/modify?id=" + id;
		});
	}
	
	document.querySelector('#likeSpan').addEventListener('click', function(e){
		const email = '${userInfo.email}';
		if(!email){
			alert('로그인이 필요합니다.');
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
		const id = '${param.id}';
		let data = { email , id };
		ajax('/essay/' + id, 'put', data).then(function(result){
			let count = result;
			console.log('좋아요 갯수 : ' + count);
			if(document.querySelector('#likeSpan').innerText.substring(0, 1) == '♡'){
				document.querySelector('#likeSpan').innerText = '♥'+ ' ' +count;
			}else if (document.querySelector('#likeSpan').innerText.substring(0, 1) == '♥'){
				document.querySelector('#likeSpan').innerText = '♡'+ ' ' +count;
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
	
	document.querySelector('#button-wrap').addEventListener('click', ({target}) => {
	    console.log(target);
	    if(target.id == 'beforeBtn'){
	        history.back();
	    } else if(target.id == 'listBtn'){
	        location.href = '/essay/list';
	    }
	})
	
	
</script>

<%@ include file="../include/footer.jsp" %>