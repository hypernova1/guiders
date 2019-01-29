<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<link rel="stylesheet" href="/css/guiders/guiders.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="/js/guiders/guiders.js" defer></script>
<section>
	<div class="select-type">
		<ul>
			<li>
				<button>진로</button>
			</li>
			<li>
				<button>취업</button>
			</li>
			<li>
				<button>커리큘럼</button>
			</li>
			<li>
				<button>전문언어</button>
			</li>
		</ul>
	</div>

	<div class="guider-wrapper"></div>

<div id="modal" class="modal">
    <div class="modal-content">
      <span class="close">&times;</span>
      <div class="modal-content-title">
        <img src=""><br>
        <div>
          <strong style="color: #ff2d55"></strong>
          <span> 가이더</span>
        </div>
        <div id="current-job">
          <span>근무 회사: </span>
          <span></span>
        </div>
        <div id="dept">
          <span>담당 부서: </span>
          <span></span></div>
        <div id="field2">
          <span>가이드 분야: </span>
          <span></span>
        </div>
        <div id="guider-info" style="color: rgb(199, 54, 34)">인용문</div>
        <div id="quote"></div>
        <br>
      </div>
      <div class="modal-content-body">
        <p style="color: rgb(32, 51, 158)">주요 경력</p>
        <div></div>
      </div>
    </div>
  </div>

</section>
<%@ include file="../include/footer.jsp"%>

</body>
</html>