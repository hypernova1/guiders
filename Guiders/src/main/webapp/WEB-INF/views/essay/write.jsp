<%@ include file="../include/header.jsp" %>

<link rel="stylesheet" href="/css/essay/write.css">

<form>
  <h1>에세이 작성</h1>
  <div id="title">
    <input type="text" placeholder="제목">
  </div>
  <div id="content">
    <textarea name="ecotent" placeholder="내용"></textarea>
  </div>
  <div id="btn-wrap">
    <button type="submit">등록</button>
    <button type="button">취소</button>
  </div>
</form>


<%@ include file="../include/footer.jsp" %>