<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

  <style>
    section{
      margin: 8% 15%;
      min-height: 620px;
    }
    article>ul>li{
      display: flex;
      list-style: none;
      font-size: 1.2rem;
      padding: 10px;
      border-bottom: 1px solid;
      border-left: 4px solid;
      border-right: 1px solid;
      border-color: #b2bec3;
      border-left-color: #ff2d55;
    }
    #li-head{
      font-weight: bold;
      border-top: 1px solid;
      border-top-left-radius: 4px;
      border-top-right-radius: 4px;
      border-color: #b2bec3;
      border-left-color: #ff2d55;
      user-select: none;
    }
    article>ul>li:last-child{
      border-bottom-left-radius: 4px;
      border-bottom-right-radius: 4px;
    }
    article>ul>li>div{
      text-align: center;
    }
    .writer{
      flex: 1.5;
    }
    .field, .lang{
      flex: 1;
    }
    .title{
      flex: 8;
      text-align: left;
      padding-left: 30px;
    }
    .title>span:nth-child(1){
      cursor: pointer;
    }
    .regDate{
      flex: 1.5;
      font-size: 0.8rem;
    }
    article>ul>li:hover:not(#li-head){
      background-color: #ecf0f1;
      transition: 0.3s;
      
    }
    .essay-body{
      border-left: 4px solid #b2bec3;
      border-right: 1px solid #b2bec3;
      height: 0;
      overflow: hidden;
    }
    .active{
      height: 600px;
      animation: active 1s;
      overflow: scroll;
    }
    .disable{
      height: 0;
      animation: disable 1s;
    }
    @keyframes active{
      0%{
        height: 0;
        color: white;
      }
      100%{
        height: 600px;
        color: black;
      }
    }
    @keyframes disable{
      0%{
        height: 600px;
        color: black;
      }
      100%{
        height: 0;
        color: white;
      }
    }
    .essay-content{
      padding: 30px 50px;
      height: 600px;
    }
    .reply-wating, .reply-complete {
      font-size: 0.9rem;
      margin-left: 20px;
    }
    .reply-wating{
      color: red;
    }
    .reply-complete{
      color: blue;
      font-weight: bold;
    }
  </style>
  <section>
    <article>
      <ul>
        <li id="li-head">
          <div class="writer">팔로워</div>
          <div class="field">분야</div>
          <div class="lang">언어</div>
          <div class="title">제목</div>
          <div class="regDate">질문날짜</div>
        </li>
        <c:forEach items="${mentorings}" var="mentoring">
	        <li data-mtrno="${mentoring.id}">
	          <div class="writer">${mentoring.name}</div>
	          <div class="field">${mentoring.field}</div>
	          <div class="lang">${mentoring.lang}</div>
	          <div class="title"><span><a href="/qna/${mentoring.id}">${mentoring.title}</a></span>
	           <c:choose>
	             <c:when test="${mentoring.replydate == null}">
	               <span class="reply-wating">[답변대기 중]</span>
	             </c:when>
	             <c:otherwise>
	              <span class="reply-complete">[답변 완료]</span>
	             </c:otherwise>
	           </c:choose>
	          </div>
	          <div class="regDate">${mentoring.createdDate}</div>
	        </li>
        </c:forEach>
      </ul>
    </article>
  </section>
<%@ include file="../include/footer.jsp" %>