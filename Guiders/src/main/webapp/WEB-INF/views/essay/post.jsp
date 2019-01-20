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
    <span id="likeSpan" style="font-weight: bold;">♡ ${essayVO.likecnt}</span>
    <c:if test="${pageContext.request.userPrincipal.name == essayVO.mname}">
        <button id="removeBtn" type="button">삭제</button>
        <button id="modifyBtn" type="button">수정</button>
    </c:if>
  </div>
  <div id="mtr-detail">
    <img id="mtr-img" src="https://media.wnyc.org/i/800/0/l/85/1/bach.png">
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
	
	if(modifyBtn){
		modifyBtn.addEventListener('click', function(){
				const eno = '${param.eno}';
				location.href = "/essay/modify?eno=" + eno;
		});
	}
	
	document.querySelector('#likeSpan').addEventListener('click', function(e){
		console.log(e.target);
		console.log('${userInfo.email}');
		
	});
	
</script>

<%@ include file="../include/footer.jsp" %>