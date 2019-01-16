<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<style>
h2{
  margin-bottom: 2rem;
  margin-left: 100px;
}
input{
  display: inline-block;
  font-size: 1.2rem;
  padding: 0 1rem;
  margin: 10px 5px;
  border:1px solid #95a5a6;
  border-radius: 4x;
}
::placeholder {
  color: #bdc3c7;
}
button {
  background-color: #ff2d55;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  opacity: 0.9;
  border-radius: 4px;
  margin-left: 100px;
}
button:hover {
  opacity:1;
}
section{
  margin: 10%;
  text-align: center;
}
.emailInput {
    width: 50%;
}
input[type="text"], input[type="password"]{
  width: 300px;
  height: 40px;
  border-radius: 4px;
}

/* IE 10, 11의 네이티브 화살표 숨기기 */
select::-ms-expand {
display: none;
}
select {
width: 200px; /* 원하는 너비설정 */
padding: .8em .5em; /* 여백으로 높이 설정 */
font-family: inherit;  /* 폰트 상속 */
background: url('이미지 경로') no-repeat 95% 50%; /* 네이티브 화살표를 커스텀 화살표로 대체 */
border: 1px solid #999;
border-radius: 0px; /* iOS 둥근모서리 제거 */
-moz-appearance: none;
appearance: none;
-webkit-appearance: none;  /* 네이티브 외형 감추기 */
-moz-appearance: none;
appearance: none;
background: url no-repeat 95% 50%;  
margin-right:10px;
}
input[type="checkbox"] , input[type="radio"] {
    display:none;
}
input[type="checkbox"] + label , input[type="radio"] + label {
    color: black;
}
input[type="checkbox"] + label span , input[type="radio"] + label span {
  display:inline-block;
  width:19px;
  height:19px;
  vertical-align:middle;
  background:url(https://s3-us-west-2.amazonaws.com/s.cdpn.io/210284/check_radio_sheet.png) left top no-repeat;
  cursor:pointer;
}

input[type="checkbox"]:checked + label span , input[type="radio"]:checked + label span{
  background:url(https://s3-us-west-2.amazonaws.com/s.cdpn.io/210284/check_radio_sheet.png) -19px top no-repeat;
}
textarea{
  resize: none;
  width: 400px;
  height: 200px;
  border-radius: 4px;
  padding: 5px;
}
#phone>input{
  width: 83px;
}
div>label{
  display: inline-block;
  font-weight: bold;
  width: 100px;
  text-align: right;
}
#identity>input{
  width: 132.5px;
}
#identity>input:nth-child(3){
  width: 50px;
}
#field, #lang{
  text-align: center;
  margin: 1.5rem 0 1.5rem 100px;
}
#field>label, #lang>label{
  width: auto;
}
#field>div>label, #lang>div>label{
  text-align: center;
}
#intro{
  margin-top: 10px;
}
#quote, #intro{
  margin-left: 100px;
}
#quote>div, #intro>div{
  text-align: center;
}
#quote>div>label, #intro>div>label{
  text-align: center;
  margin: 10px 0;
}
</style>

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
  
    <script>
    $('#selectEmail').change(function () {
      $("#selectEmail option:selected").each(function () {
        if ($(this).val() == '1') { //직접입력일 경우
          $("#str_email02").val(''); //값 초기화 
          $("#str_email02").attr("disabled", false); //활성화
        } else { //직접입력이 아닐경우
          $("#str_email02").val($(this).text()); //선택값 입력
          $("#str_email02").attr("disabled", true); //비활성화
        }
      });
    });

    $('#city').change(function () {
          $("#city option:selected").each(function () {
            $("#InputCity").val($(this).text()); //선택값 입력
          });
  </script>


<%@ include file="../include/footer.jsp" %>