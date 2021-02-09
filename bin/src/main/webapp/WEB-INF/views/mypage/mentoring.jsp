<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../include/header.jsp" %>
<script src="https://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="/editor/js/HuskyEZCreator.js" charset="utf-8"></script>

<script type="text/javascript">
    $(function () {
        //전역변수
        var obj = [];
        //스마트에디터 프레임생성
        nhn.husky.EZCreator.createInIFrame({
            oAppRef: obj,
            elPlaceHolder: "editor",
            sSkinURI: "/editor/SmartEditor2Skin.html",
            htParams: {
                // 툴바 사용 여부
                bUseToolbar: true,
                // 입력창 크기 조절바 사용 여부
                bUseVerticalResizer: true,
                // 모드 탭(Editor | HTML | TEXT) 사용 여부
                bUseModeChanger: true,
            }
        });
        //전송버튼
        $("#answer-btn").click(function () {
            //id가 editor인 textarea에 에디터에서 대입
            obj.getById["editor"].exec("UPDATE_CONTENTS_FIELD", []);
            //폼 submit
            $("#answer-form").submit();
        });
    });
</script>

<link rel="stylesheet" href="/css/mypage/mentoring.css">
<script src="/js/mypage/mentoring.js" defer></script>
<section>
    <input type="hidden" value="${mentoring.id}" id="id">
    <div id="question">
        <h1 id="title">Q. ${mentoring.title}</h1>
        <div id="field">${mentoring.field}</div>
        <div id="lang">${mentoring.lang}</div>
        <div id="regDate">등록일: ${mentoring.createdDate}</div>
        <div class="content">
            ${mentoring.content}
        </div>
    </div>
    <h2 id="answer-title">Guider's Answer..</h2>
    <c:if test="${mentoring.answer != null}">
        <div id="answerDate">답변일: ${mentoring.answerDate}</div>
    </c:if>
    <div id="answer">
        <c:choose>
            <c:when test="${pageContext.request.userPrincipal.name eq mentoring.guider.name and mentoring.answer == null}">
                <form action="/mentoring/answer" method="post" id="answer-form">
                    <textarea name="mreply" id="editor" placeholder="답변을 달아주세요."></textarea>
                    <input type="hidden" name="mtrno" value="${mentoring.id}">
                </form>
            </c:when>
            <c:when test="${mentoring.answer != null}">
                <div class="content">${mentoring.answer}</div>
            </c:when>
            <c:otherwise>
                <div class="content">아직 답변이 등록되지 않았습니다.</div>
            </c:otherwise>
        </c:choose>
        <c:if test="${pageContext.request.userPrincipal.name eq mentoring.guider.email and mentoring.answer == null}">
            <div id="btn-wrap">
                <button class="btn" id="answer`-btn">등록</button>
            </div>
        </c:if>
    </div>
    <div id="mtr-detail">
        <img id="mtr-img" src="${mentoring.guider.photoUrl}">
        <div class="mtr-name">
            <span>${mentoring.guider.name}</span>
            <span>멘토</span>
            <div id="mtr-btn-wrap">
                <div id="mtr-essay-btn">작성 에세이 보기</div>
                <div id="mtr-page-btn">멘토 상세정보</div>
            </div>
        </div>
    </div>
    <button class="btn" id="return-page">돌아가기</button>
</section>
<%@ include file="../include/footer.jsp" %>

