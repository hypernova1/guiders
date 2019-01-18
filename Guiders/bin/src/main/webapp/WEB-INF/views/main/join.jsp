<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<link rel="stylesheet" href="/css/main/join.css">

<section>
  <h1 class="join">
    회원가입
  </h1>

  <div class="grid-container">
    <div class="item1">

      회원 유형에 따라 가입 절차가 다르니, 본인에 해당하는 유형을 선택하여 주세요.
    </div>
    <div class="item2">
      <h1>가이더로 가입하기</h1>
      <h3>여러분의 도움을 필요로 하는 멘티들이 있습니다.</h3>
      <div class="row">
        <div class="col three">
          <a href="/joinform?guider=true" class="btn btn-sunflower">바로가기</a>
        </div>
      </div>
    </div>
    <div class="item4">
      <h1>팔로워로 가입하기</h1>
      <h3>원하는 멘토와 팔로우를 맺고, 도움을 받아보세요.</h3>
      <div class="row">
        <div class="col three">
          <a href="joinform?guider=false" class="btn btn-sunflower">바로가기</a>
        </div>
      </div>
    </div>
    <div></div>
  </div>
  <!-- <ul class="choose-methods">
  <li> <div to="#" class="auth-method">
    <div class="selecting">
      <dl>
        <dt>
          <span>아이핀 인증 &nbsp;:</span>
        </dt>
        <dd>아이핀 아이디/비밀번호를 통해<br>편리하게 본인인증이 가능합니다.</dd>
      </dl>
    </div></div></li>
    
    <li> <div to="#" class="auth-method">
      <div class="selecting">
        <dl>
          <dt>
            <span>휴대전화 인증 &nbsp;:</span>
          </dt>
          <dd>신용평가 기관의 휴대전화 인증을<br>통해 본인인증이 가능합니다.</dd>
        </dl>
      </div></div></li></ul> -->
    </section>

<%@ include file="../include/footer.jsp" %>