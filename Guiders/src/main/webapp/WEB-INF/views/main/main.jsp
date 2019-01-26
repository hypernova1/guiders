<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>
<link rel="stylesheet" href="/css/main/main.css">
<script src="/js/main/main.js" defer></script>
<div id="header-img">
	<c:choose>
	 <c:when test="${pageContext.request.userPrincipal == null}">
    <div>
      <p>지금 바로 가입하세요.</p>
      <button type="button" class="btn" id="join">가입하기</button>
    </div>
	 </c:when>
	 <c:otherwise>
	 <div>
	   <p>실패란 보다 현명하게 다시 시작할 수 있는 기회다.</p>
	   <p> - 헨리포</p>
	 </div>
	 </c:otherwise>
	</c:choose>
  </div>
  <section id="article">
  </section>
  <div class="line">
    <div></div>
  </div>

  <h2 id="makers-title">DEVELOPERS</h2>
  <section id="makers">
    <div class="maker">
    <div class="card">
      <div class="face front">
        <img src="/img/maker/june.jpg">
        <div class="name">정원준</div>
        <div class="role-title">ROLE</div>
        <div class="role">시큐리티, 스케쥴 관리</div>
      </div>
      <div class="face back">
        ddd
      </div>
    </div>
  </div>
  <div class="maker">
    <div class="card">
      <div class="face front">
        <img src="/img/maker/sam.jpg">
        <div class="name">권샘찬</div>
        <div class="role-title">ROLE</div>
        <div class="role">회원 관리, 화면 디자인</div>
      </div>
      <div class="face back">
        ddd
      </div>
    </div>
  </div>
  <div class="maker">
    <div class="card">
      <div class="face front">
        <img src="/img/maker/jeon.jpg">
        <div class="name">전지영</div>
        <div class="role-title">ROLE</div>
        <div class="role">게시판, 화면 디자인</div>
      </div>
      <div class="face back">
        ddd
      </div>
    </div>
  </div>
  <div class="maker">
    <div class="card">
      <div class="face front">
        <img src="/img/maker/hune.jpg">
        <div class="name">김정훈</div>
        <div class="role-title">ROLE</div>
        <div class="role">회원검색, 화면 디자인</div>
      </div>
      <div class="face back">
        ddd
      </div>
    </div>
  </div>
  </section>
  
  <script src="/js/common/ajax.js"></script>
  <script>
  window.addEventListener('load', () => {
     ajax('/essays', 'GET', {}).then((result) => {
         const essays = JSON.parse(result);
         
         let data = '<h2>인기 에세이</h2>';
         const regex = /<img[^>]*src=[\"']?([^>\"']+)[\"']?[^>]*>/i;
         essays.forEach((essay) => {
             const img = essay.econtent.match(regex);
             
             data += '<article>';
             if(img){
	             const src = img[1];
               data += '<img class="article-img" src="' + src + '">';
             } else {
               data += '<img class="article-img" src="https://t1.daumcdn.net/cfile/tistory/1112763C4F78EAB610">';
             }
             data += '<h3 class="article-title" data-eno="' + essay.eno + '">' + essay.etitle + '</h3>';
             data += '<div class="article-content">' + essay.econtent.replace(/(<([^>]+)>)/ig,""); + '</div>';
             data += '</article>';
         });
         document.querySelector('#article').innerHTML = data;
     });
  });
  
  document.querySelector('#article').addEventListener('click', ({target}) => {
      if(target.className == 'article-title'){
          location.href = '/essay/read?eno=' + target.getAttribute('data-eno');
      }
  })
  
  </script>
  <%@ include file="../include/footer.jsp" %>
