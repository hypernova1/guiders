<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<style>
section{
  margin: 10% 20% 13.5% 20%;
}
.item1 {
  border-top: 2px solid gray;
  border-bottom: 2px solid gray;
  grid-area: header;
}

.item2 {
  border-right: 2px solid gray;
  border-bottom: 2px solid gray;
  grid-area: menu;
  height: 200px;
}

.item4 {

  border-bottom: 2px solid gray;
  grid-area: right;
  height: 200px;
}

.grid-container {
  border-radius: 25px;
  display: grid;
  grid-template-areas:
    'header header'
    'menu right'
    'menu right'
    'footer footer';
  grid-gap: 1px;

  padding: 7px;
}

h1 {
  font-size: 24px;
  font-weight: normal;
  margin: 0.4em 0;
}

* {
  -moz-box-sizing: border-box;
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
}

a {
  text-decoration: none;
}

.btn {
  font-size: 18px;
  white-space: nowrap;
  width: 100%;
  padding: .8em 1.5em;
  font-family: Open Sans, Helvetica, Arial, sans-serif;
  margin-top: 2rem;
  line-height: 18px;
  display: inline-block;
  zoom: 1;
  color: #fff;
  text-align: center;
  position: relative;
  -webkit-transition: border .25s linear, color .25s linear, background-color .25s linear;
  transition: border .25s linear, color .25s linear, background-color .25s linear;
}

.btn i {
  padding-right: 0.8em;
  line-height: 22px;
}

.icon-only {
  padding: 1em;
}

.icon-only i {
  padding-right: 0;
  font-size: 22px;
  line-height: 22px;
}

.btn.btn-sunflower {

  width: 90%;
  border-radius: 10px;
  background-color: #ff2d55;
  border-color: #ff2d55;
  -webkit-box-shadow: 0 3px 0 #ff2d55;
  box-shadow: 0 3px 0 #ff2d55;
}

.btn.btn-sunflower:hover {
  background-color: #ff2d88;
}

.btn.btn-sunflower:active {
  top: 3px;
  outline: none;
  -webkit-box-shadow: none;
  box-shadow: none;
}


.grid-container>div {

  background-color: #fff;
  text-align: center;
  padding: 20px 0;
  font-size: 15px;
}

.join {
  text-align: center;
}

.auth-layout .choose-methods {
  display: flex;
  display: -ms-flexbox;
}

ol,
ul {
  list-style: none;
}

ul,
menu,
dir {
  display: block;
  list-style-type: disc;
  margin-block-start: 1em;
  margin-block-end: 1em;
  margin-inline-start: 0px;
  margin-inline-end: 0px;
  padding-inline-start: 40px;
}

.selecting {
  background-color: antiquewhite;
}

#serfa {
  width: 100%;
}
</style>

<section>
  <h1 class="join">
    회원가입
  </h1>

  <div class="grid-container">
    <div class="item1">

      회원 유형에 따라 가입 절차가 다르니, 본인에 해당하는 유형을 선택하여 주세요.
    </div>
    <div class="item2">
      <h1>멘토로 가입하기</h1>
      <h3>여러분의 도움을 필요로 하는 멘티들이 있습니다.</h3>
      <div class="row">
        <div class="col three">
          <a href="/joinform" class="btn btn-sunflower">바로가기</a>
        </div>
      </div>
    </div>
    <div class="item4">
      <h1>멘티로 가입하기</h1>
      <h3>원하는 멘토와 팔로우를 맺고, 도움을 받아보세요.</h3>
      <div class="row">
        <div class="col three">
          <a href="joinform" class="btn btn-sunflower">바로가기</a>
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