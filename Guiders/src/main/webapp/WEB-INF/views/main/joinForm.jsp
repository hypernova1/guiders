<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<link rel="stylesheet" href="/css/main/joinForm.css">
<script src="/js/main/joinForm.js" defer></script>

<style>
    #drop-zone {
        font-weight: bold;
        font-size: 25px;
        text-align: center;
        border: 1px solid black;
        width: 185px;
        height: 250px;
        position: relative;
        margin: auto;
        vertical-align: center;
    }

    #drop-zone > img {
        width: auto;
        height: auto;
        max-height: 100%;
        max-width: 100%;
    }
</style>

<section>
    <div id="join_form">
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
          <input type="text" name="email">
        </div>
      <div>
        <label>이름</label>
        <input type="text" id="mname">
      </div>
      <div>
        <label>비밀번호</label>
        <input type="password" name="password">
      </div>
      <div>
        <label>재입력</label>
        <input type="password" id="repassword">
      </div>
      <div id="phone-wrap">
          <label>전화번호</label>
        <input type="text">―<input type="text">―<input type="text">
        <input type="hidden" id="phone">
      </div>
      <div id="identity">
        <label>주민등록번호</label>
        <input type="text" id="birth">―<input type="text" id="gender" maxlength="1">●●●●●●
      </div>
       <div>
        <label>지역</label>
        <input type="text" id="address" class="inputAddr" readonly />
      </div>
      <c:if test="${guider eq true }">
      <div>
        <label>최근직장</label>
        <input type="text" id="currentjob">
      </div>
      <div>
        <label>부서</label>
        <input type="text" id="dept">
      </div>
	      <div id="introdution-wrap">
	        <div>
	          <label>경력란</label>
	        </div>
	        <textarea id="introdution" placeholder="경력 상세 기술"></textarea>
	      </div>
	      <div id="quote-wrap">
	        <div>
	          <label>인용문</label>
	        </div>
	        <textarea id="quote" placeholder="오늘 나는 이렇게 무너진다만, 내일의 나는 무너진다."></textarea>
	      </div>
	      
	      <div id="drop-zone">여기에 사진을 드래그 해주세요</div>
	      
	      
	      <div id="field">
	        <div>
	          <label>분야</label>
	        </div>
	        <input type="checkbox" id="c1" name="field" value="취업상담"/>
	        <label for="c1"><span></span>취업상담</label>
	        <input type="checkbox" id="c2" name="field" value="학업조언"/>
	        <label for="c2"><span></span>학업조언</label>
	        <input type="checkbox" id="c3" name="field" value="자소서첨삭"/>
	        <label for="c3"><span></span>자소서첨삭</label>
	        <p></p>
	      </div>
	      <div id="lang">
	        <div>
	          <label>언어</label>
	        </div>
	        <input type="checkbox" id="l1" name="lang" value="Java" />
	        <label for="l1"><span></span>JAVA</label>
	
	        <input type="checkbox" id="l2" name="lang" value="C"/>
	        <label for="l2"><span></span>C</label>
	
	        <input type="checkbox" id="l3" name="lang" value="Python"/>
	        <label for="l3"><span></span>파이썬</label>
	
	        <input type="checkbox" id="l4" name="lang" value="Ruby" />
	        <label for="l4"><span></span>루비</label>
	
	        <input type="checkbox" id="l5" name="lang" value="PHP"/>
	        <label for="l5"><span></span>PHP</label>
	      </div>
      </c:if>
      <div class="clearfix">
        <button type="button" id="join-btn2">확인</button>

      </div>
    </div>
  </section>
  
    <script>
        function imgAjax(url, method, formData, fileType) {
            return new Promise((resolve, reject) => {

                const xhr = new XMLHttpRequest();

                xhr.onreadystatechange = () => {
                    if (xhr.readyState === XMLHttpRequest.DONE) {
                        if (xhr.status === 200) {
                            resolve(xhr.response);
                        } else {
                            reject('Error', xhr.status);
                        }
                    }
                }
                xhr.open(method, url);
                /* xhr.setRequestHeader('Content-Type', fileType); */
                /* xhr.send(JSON.stringify(formData)); */
                xhr.send(formData);
            });
        }
        document.querySelector('#drop-zone').addEventListener('dragenter', function (event) {
            event.preventDefault();
        });
        document.querySelector('#drop-zone').addEventListener('dragover', function (event) {
            event.preventDefault();
        });
        document.querySelector('#drop-zone').addEventListener('drop', function (event) {
            event.preventDefault();
            var files = event.dataTransfer.files;
            var file = files[0];
            var fileType = file.type;

            var formData = new FormData();
            formData.append('file', file);
            console.log(formData.getAll('file'));

            var url = '/uploadImage';
            var method = 'POST';

            imgAjax(url, method, formData, fileType).then(function (result) {
                console.log(result);
                var img = JSON.stringify(result);
                document.querySelector('#drop-zone').innerHTML = '<img src =' + img + '>';
            });

        });  
    </script>
  

<%@ include file="../include/footer.jsp" %>