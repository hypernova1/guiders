<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

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

    <c:if test="${pageContext.request.userPrincipal.name == essay.email}">
        <button id="removeBtn" type="button">삭제</button>
        <button id="modifyBtn" type="button">수정</button>
    </c:if>

    </div>
    <div id="mtr-detail">
        <img id="mtr-img" src="${essay.writerPhotoUrl}">
        <div class="mtr-name">
            <span>${essay.writer}</span>
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
    </sectio

    <script>
        const modifyBtn = document.querySelector('#modifyBtn');
        const removeBtn = document.querySelector('#removeBtn');

        if(modifyBtn){
            modifyBtn.addEventListener('click', function(){
                const id = '${essay.id}';
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
                    if (i === 51) {
                        clearInterval(increase);
                    } else {
                        modal.style.backgroundColor = 'rgba(0, 0, 0,' + 0.01 * i + ')';
                        i++;
                    }
                }, 10);
                return;
            }
            const id = '${param.id}';
            const data = { email , id };

            fetch(`/essay/${id}/like`, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(data)
            }).then((res) => res.json())
                .then((count) => {
                    let likeSpan = document.querySelector('#likeSpan');
                    let emoticon = likeSpan.innerText.substring(0, 1);
                    if (emoticon === '♡'){
                        likeSpan.innerText = '♥'+ ' ' +count;
                    } else if (emoticon === '♥'){
                        likeSpan.innerText = '♡'+ ' ' +count;
                    }
                });
        });

        if(removeBtn){
            removeBtn.addEventListener('click', function(e) {
                e.preventDefault();
                if(confirm('정말 삭제하시겠습니까?')){
                    location.href = '/essay/delete/${essay.id}';
                }
            });
        }

        document.querySelector('#button-wrap').addEventListener('click', ({target}) => {
            if(target.id === 'beforeBtn'){
                history.back();
            } else if(target.id === 'listBtn'){
                location.href = '/essay/list';
            }
        });
    </script>

<%@ include file="../include/footer.jsp" %>