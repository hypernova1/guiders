<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<link rel="stylesheet" href="/css/essay/list.css">
<section>
  <h1>Essay</h1>
  <div id="select-wrap">
    <select name="">
      <option value="" selected>분야</option>
      <option value="선택">진로</option>
      <option value="선택">팁</option>
      <option value="선택">하하</option>
      <option value="선택">오호라..</option>
    </select>
    <select name="">
      <option value="" selected>언어</option>
      <option value="선택">C</option>
      <option value="선택">C++</option>
      <option value="선택">JAVA</option>
      <option value="선택">JavaScript</option>
    </select>
  </div>
    <article>
      <ul id="essay-list">
      <c:forEach var="essay" items="${essayList}">
	      <li>
	        <div class="mtr-info">
	          <img  class="mtr-img" src="${essay.photo}">
	          <span class="guider">${essay.mname}</span>
	          <span class="etype">${essay.field}</span>
	        </div>
	        <div class="essay">
	           <div>
			          <h2 class="title"><a href="/essay/read?eno=${essay.eno}">${essay.etitle}</a></h2>
			          <span class="like">♥ ${essay.likecnt}</span>
			          <span class="regdate">${essay.regdate}</span>
	          </div>
	          <div class="content"><c:out value="${essay.econtent}"/></div>
	        </div>
	      </li>
      </c:forEach>
    </ul>
    <c:if test="${pageContext.request.userPrincipal.authorities eq '[ROLE_GUIDER]'}">
      <button id="writeBtn" type="button">글쓰기</button>
    </c:if>
  </article>
</section>

<script>
document.querySelector('#writeBtn').addEventListener('click', function(){
	location.href = '/essay/write';
});

</script>
  
<%@ include file="../include/footer.jsp" %>
  