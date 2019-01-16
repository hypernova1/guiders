<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<link rel="stylesheet" href="/css/main/joinForm.css">
<script src="/js/main/joinForm.js" defer></script>

<section>
    <div class="join_form">
    <c:choose>
      <c:when test="${guider eq true}">
	      <h2>Guider Join</h2>
      </c:when>
      <c:otherwise>
	      <h2>Follower Join</h2>
      </c:otherwise>
    </c:choose>
      <div>
          <label>이메일</label>
          <input class="emailInput" type="text" placeholder="이메일">
        </div>
      <div>
        <label>이름</label>
        <input type="text" placeholder="이름을 입력하세요">
      </div>
      <div>
        <label>비밀번호</label>
        <input type="password" placeholder="비밀번호를 입력하세요">
      </div>
      <div>
        <label>재입력</label>
        <input type="password" placeholder="비밀번호 재입력">
      </div>
      <div id="phone">
          <label>전화번호</label>
        <input type="text">―<input type="text">―<input type="text">
      </div>
      <div id="identity">
        <label>주민등록번호</label>
        <input type="text" name="birth">―<input type="text" name="gender" maxlength="1">●●●●●●
      </div>
       <div>
        <label>지역</label>
        <input type="text" name="addr" class="inputAddr" readonly />
        <!-- <select name="city" id="city">
        </select> -->
      </div>
      <c:if test="${guider eq true }">
	      <div id="intro">
	        <div>
	          <label>경력란</label>
	        </div>
	        <textarea name="" placeholder="경력 상세 기술"></textarea>
	      </div>
	      <div id="quote">
	        <div>
	          <label>인용문</label>
	        </div>
	        <textarea name="" placeholder="오늘 나는 이렇게 무너진다만, 내일의 나는 무너진다."></textarea>
	      </div>
	      <div id="field">
	        <div>
	          <label>분야</label>
	        </div>
	        <input type="checkbox" id="c1" name="cc" />
	        <label for="c1"><span></span>취업상담</label>
	        <input type="checkbox" id="c2" name="cc" />
	        <label for="c2"><span></span>학업조언</label>
	        <input type="checkbox" id="c3" name="cc" />
	        <label for="c3"><span></span>자소서첨삭</label>
	        <input type="checkbox" id="c10" name="cc" />
	        <label for="c10"><span></span>아응애에요</label>
	        <p></p>
	      </div>
	      <div id="lang">
	        <div>
	          <label>언어</label>
	        </div>
	        <input type="checkbox" id="l1" name="lan" />
	        <label for="l1"><span></span>JAVA</label>
	
	        <input type="checkbox" id="l2" name="lan" />
	        <label for="l2"><span></span>C</label>
	
	        <input type="checkbox" id="l3" name="lan" />
	        <label for="l3"><span></span>파이썬</label>
	
	        <input type="checkbox" id="l4" name="lan" />
	        <label for="l4"><span></span>루비</label>
	
	        <input type="checkbox" id="l5" name="lan" />
	        <label for="l5"><span></span>PHP</label>
	      </div>
      </c:if>
      <div class="clearfix">
        <button type="submit">확인</button>

      </div>
    </div>
  </section>
  

<%@ include file="../include/footer.jsp" %>