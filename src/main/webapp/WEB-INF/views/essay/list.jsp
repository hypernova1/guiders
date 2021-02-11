<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<link rel="stylesheet" href="/css/essay/list.css">
<section>
	<h1>Essay</h1>
	<div id="select-wrap">
		<select name="field">
			<option value="" selected>분야</option>
			<option value="진로">진로</option>
			<option value="팁">팁</option>
			<option value="하하">하하</option>
			<option value="오호라">오호라..</option>
		</select>
		<select name="lang">
			<option value="" selected>언어</option>
			<option value="C">C</option>
			<option value="C++">C++</option>
			<option value="Java">Java</option>
			<option value="JavaScript">JavaScript</option>
		</select>
	</div>
	<article>
		<ul id="essay-list">
			<c:forEach var="essay" items="${essayPage.content}">
				<li>
					<div class="mtr-info">
						<img class="mtr-img" src="${essay.writerPhotoUrl}">
						<span class="guider">${essay.writer}</span> <span class="etype">${essay.field}</span>
					</div>
					<div class="essay">
						<div>
							<h2 class="title">
								<a href="/essay/detail/${essay.id}">${essay.title}</a>
							</h2>
							<span class="like">♥ ${essay.likeCount}</span>
							<span class="regDate">${essay.createdDate}</span>
						</div>
						<div class="content">
							<c:out value="${essay.content}" />
						</div>
					</div>
				</li>
			</c:forEach>
		</ul>

		<button id="writeBtn" type="button">글쓰기</button>

		<c:set var="start" value="${(essayPage.number / 5) * 5 + 1}" />
		<c:set var="end" value="${(essayPage.totalPages == 0) ? 1 : (start + (5 - 1) < essayPage.totalPages ? start + (5 - 1) : essayPage.totalPages)}" />
		<div id="pagination">
			<ul class="pagination">
				<c:if test="${!essayPage.first and essayPage.number ne 0}">
					<li class="pagination-li prev"><a href="/essay/list?page=${param.page}&keyword=${param.keyword}">prev</a></li>
				</c:if>
				<c:forEach var="idx" begin="${start}" end="${end}">
				  <c:choose>
				    <c:when test="${idx == param.page}">
				      <li class="pagination-li">
					      <span class="pagination-active">${idx}</span>
				      </li>
				    </c:when>
				    <c:otherwise>
				      <li class="pagination-li"><a href="/essay/list?page=${idx}&keyword=${param.keyword}">${idx}</a></li>
				    </c:otherwise>
				  </c:choose>
				</c:forEach>
				<c:if test="${!essayPage.last}">
					<li class="pagination-li next"><a href="/essay/list?page=${essayPage + 1}&keyword=${param.keyword}">next</a></li>
				</c:if>
			</ul>
		</div>
	</article>
</section>

<script>
	document.querySelector('#writeBtn').addEventListener('click', function() {
		location.href = '/essay/write';
	});
</script>

<%@ include file="../include/footer.jsp"%>
