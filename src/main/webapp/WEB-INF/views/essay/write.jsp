<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<link rel="stylesheet" href="/css/essay/write.css">
<script src="https://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="/editor/js/HuskyEZCreator.js" charset="utf-8"></script>

<script type="text/javascript" src="/js/essay/write.js"></script>

<form action="/essay/write" method="post" id="insertEssayForm">
    <h1>에세이 작성</h1>
    <div id="title-wrap">
        <input id="title" name="title" type="text" placeholder="제목">
    </div>
    <div id="content-wrap">
        <textarea id="editor" name="content" placeholder="내용"></textarea>
    </div>
    <div id="btn-wrap">
        <button id="writeBtn" type="button">등록</button>
        <button id="cancelBtn" type="button">취소</button>
    </div>
</form>

<%@ include file="../include/footer.jsp" %>