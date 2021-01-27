<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<link rel="stylesheet" href="/css/essay/write.css">
<script src="https://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="/editor/js/HuskyEZCreator.js" charset="utf-8"></script>

<script type="text/javascript">
    $(function(){
        //전역변수
        var obj = [];              
        //스마트에디터 프레임생성
        nhn.husky.EZCreator.createInIFrame({
            oAppRef: obj,
            elPlaceHolder: "editor",
            sSkinURI: "/editor/SmartEditor2Skin.html",
            htParams : {
                // 툴바 사용 여부
                bUseToolbar : true,            
                // 입력창 크기 조절바 사용 여부
                bUseVerticalResizer : true,    
                // 모드 탭(Editor | HTML | TEXT) 사용 여부
                bUseModeChanger : true,
            }
        });
        //전송버튼
        $("#writeBtn").click(function(){
            //id가 editor인 textarea에 에디터에서 대입
            obj.getById["editor"].exec("UPDATE_CONTENTS_FIELD", []);
            var title = $("#title").val();
            $.ajax({
            	url: '/doA',
            	data: title,
            	type: 'POST',
              headers : {
                    "content-type" : "application/json",
                    "x-http-method-override" : "post"},
            	dataType: 'json'
            });
            
            //폼 submit
            $("#inserteEssayForm").submit();
        });
    });
</script>


<form action="/essay/write" method="post" id="inserteEssayForm" enctype="multipart/form-data">
  <h1>에세이 작성</h1>
  <input type="hidden" name="email" value="${email}">
  <div id="title">
    <input id="title" name="title" type="text" placeholder="제목">
  </div>
  <div id="content">
    <textarea id="editor" name="content" placeholder="내용"></textarea>
  </div>
  <div id="btn-wrap">
    <button id="writeBtn" type="button">등록</button>
    <button id="cancleBtn" type="button">취소</button>
  </div>
</form>


<%@ include file="../include/footer.jsp" %>