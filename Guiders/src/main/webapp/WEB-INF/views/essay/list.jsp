<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<style>

#pagination{
  text-align: center;
}

#pagination>.pagination { 
  /* display: inline-block; */
  padding-left:0;
	margin-top: 0;
	margin-bottom: 0;
}

.pagination > .pagination-li{
  display: inline-block;
	/* text-align: center; */
	margin-left: 7px;
	margin-right: 7px;
}

.pagination-active{
	width: 30px;
	height: 30px;
	font-size: 20px;
	font-weight: bold;
	background-color: #ff2d55;
	/* border: 2px solid #ff2d55; */
	border-radius: 3px;
  color: white;
}

.pagination-li > a:hover {
	color: #ff2d55;
	font-size: 20px;
	font-weight: bold;
	transition: 0.2s;
}


</style>

<link rel="stylesheet" href="/css/essay/list.css">
<section>
<<<<<<< HEAD
	<h1>Essay</h1>
	<div id="select-wrap">
		<select name="">
			<option value="" selected>분야</option>
			<option value="선택">진로</option>
			<option value="선택">팁</option>
			<option value="선택">하하</option>
			<option value="선택">오호라..</option>
		</select> <select name="">
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
						<img class="mtr-img" src="${essay.photo}"> <span
							class="guider">${essay.mname}</span> <span class="etype">${essay.field}</span>
					</div>
					<div class="essay">
						<div>
							<h2 class="title">
								<a href="/essay/read?eno=${essay.eno}">${essay.etitle}</a>
							</h2>
							<span class="like">♥ ${essay.likecnt}</span> <span
								class="regdate">${essay.regdate}</span>
						</div>
						<div class="content">
							<c:out value="${essay.econtent}" />
						</div>
					</div>
				</li>
			</c:forEach>
		</ul>

		<button id="writeBtn" type="button">글쓰기</button>

		<div id="pagination">
			<ul class="pagination">
				<c:if test="${pm.prev}">
					<li class="pagination-li prev"><a href="/essay/list?page=${pm.startPage -1}">prev</a></li>
				</c:if>
				<c:forEach var="idx" begin="${pm.startPage}" end="${pm.endPage}">
				  <c:choose>
				    <c:when test="${idx == pm.cri.page}">
				      <li class="pagination-li">
					      <span class="pagination-active">${idx}</span>
				      </li>
				    </c:when>
				    <c:otherwise>
				      <li class="pagination-li"><a href="/essay/list?page=${idx}">${idx}</a></li>				    
				    </c:otherwise>
				  </c:choose>
				</c:forEach>
				<c:if test="${pm.next}">
					<li class="pagination-li next"><a href="/essay/list?page=${pm.endPage + 1}">next</a></li>
				</c:if>
			</ul>
		</div>
	</article>
</section>
=======
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
>>>>>>> 36feec1766ce4491e9300064c41cd5403f72114c

<script>
	document.querySelector('#writeBtn').addEventListener('click', function() {
		location.href = '/essay/write';
	});
</script>

<%@ include file="../include/footer.jsp"%>
