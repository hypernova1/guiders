<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

      <style>
    *, *::before, *::after{
      margin: 0;
      padding: 0;
      box-sizing: border-box;
    }
    h1{
      text-align: center;
    }
    ul{
      list-style: none;
    }
    #essay-list>li{
      display: flex;
      margin: 8px;
      padding: 0.4rem;
      height: 200px;
      border: 1px solid #b2bec3;
      border-radius: 4px;
    }
    #essay-list>li:hover{
      box-shadow: 2px 2px rgba(0, 0, 0, 0.8);
      transition: 0.3s;
    }
    span{
      display: inline-block;
    }
    section{
      margin: 10%;
      margin-top: 100px;
    }
    .etype{
      position: relative;
    }
    .title{
      display: inline-block;
      padding-left: 10px;
    }
    .title:hover{
      text-decoration: underline;
      cursor: pointer;
    }
    .guider{
      display: block;
      font-size: 1.2rem;
      font-weight: bold;
    }
    .like{
      margin-left: 30px;
      color: red;
    }
    .regdate{
      float: right;
      margin-right: 10px;
    }
    article{
      margin: 5%;
      margin-top: 1%;
    }
    .mtr-info{
      display: inline-block;
      text-align: center;
      margin-left: 30px;
      padding: 10px;
      width: 140px;
    }
    .mtr-img{
      border: 3px solid red;
      border-radius: 100%;
      width: 120px;
      height: 120px;
      cursor: pointer;
    }
    .essay{
      margin-left: 30px;
      display: inline-block;
      width: 100%;
      padding: 5px;
    }
    .content{
      display: inline-block;
      width: auto;
      height: 113px;
      margin-top: 20px;
      padding: 5px;
      color: #636e72;
      overflow: hidden;
    }
    #select-wrap{
      margin-left: 6%;
    }
    select{
      all: unset;
      padding: 5px;
      width: 90px;
      height: 25px;
      font-size: 1.2rem;
      border: 1.5px solid #ff2d55;
      border-radius: 4px;
      font-weight: bold;
    }
  </style>
  
  <section>
    <h1>에쎄이</h1>
    <div id="select-wrap">
      <select name="">
        <option value="" selected>분야</option>
        <option value="선택">진로</option>
        <option value="선택">팁</option>
        <option value="선택">하하</option>
        <option value="선택">오호라..</option>
      </select>
      <select name="">
        <option value="" selected>언어</option>
        <option value="선택">C</option>
        <option value="선택">C++</option>
        <option value="선택">JAVA</option>
        <option value="선택">JavaScript</option>
      </select>
    </div>
      <article>
        <ul id="essay-list">
          <li>
          <div class="mtr-info">
            <img  class="mtr-img" src="https://media.wnyc.org/i/800/0/l/85/1/bach.png">
            <span class="guider">바흐</span>
            <span class="etype">진로</span>
          </div>
          <div class="essay">
            <h2 class="title">피아노 강사님 모집합니다.</h2>
            <span class="like">♥ 3</span>
            <span class="regdate">2019.01.01</span>
            <div class="content">
              Lorem ipsum, dolor sit amet consectetur adipisicing elit. Blanditiis tenetur rerum perspiciatis minus quo, temporibus eius architecto nam tempora repellat saepe eos aliquid ratione officiis, ducimus error in, reiciendis cupiditate.
              Lorem ipsum dolor, sit amet consectetur adipisicing elit. Voluptate alias necessitatibus amet sunt exercitationem, voluptas quia aliquam voluptatibus nisi aspernatur neque dolorum porro deserunt quaerat consectetur quibusdam, fugit veniam ducimus.
              Lorem ipsum dolor sit amet consectetur adipisicing elit. Laborum omnis temporibus neque, maiores, repellat expedita facilis aliquid ducimus, repudiandae delectus eum? Incidunt placeat fugit voluptas blanditiis praesentium consequuntur possimus nemo?
            </div>
          </div>
        </li>
        <li>
          <div class="mtr-info">
            <img  class="mtr-img" src="https://seoul-p-studio.bunjang.net/product/57982666_1_1467814743_w640.jpg">
            <span class="guider">아인슈타인</span>
            <span class="etype">언어</span>
          </div>
          <div class="essay">
            <h2 class="title">물리학 선생님 구합니다.</h2>
            <span class="like">♥ 3</span>
            <span class="regdate">2019.01.01</span>
            <div class="content">
              Lorem ipsum, dolor sit amet consectetur adipisicing elit. Blanditiis tenetur rerum perspiciatis minus quo, temporibus eius architecto nam tempora repellat saepe eos aliquid ratione officiis, ducimus error in, reiciendis cupiditate.
              Lorem ipsum dolor, sit amet consectetur adipisicing elit. Voluptate alias necessitatibus amet sunt exercitationem, voluptas quia aliquam voluptatibus nisi aspernatur neque dolorum porro deserunt quaerat consectetur quibusdam, fugit veniam ducimus.
              Lorem ipsum dolor sit amet consectetur adipisicing elit. Laborum omnis temporibus neque, maiores, repellat expedita facilis aliquid ducimus, repudiandae delectus eum? Incidunt placeat fugit voluptas blanditiis praesentium consequuntur possimus nemo?
            </div>
          </div>
        </li>
        <li>
          <div class="mtr-info">
            <img  class="mtr-img" src="https://post-phinf.pstatic.net/MjAxNzA3MjNfMiAg/MDAxNTAwNzQwODc3NjYw.3AVk_oTTVTN1yE6CE8_6oijWOccSuZa-XVy9EQnrNBsg.jJMvFkcp-ykUEG-sp6y3kAg_vXArcwYFSl1k6Nl2dEgg.JPEG/hqdefault.jpg?type=w1200">
            <span class="guider">브람스</span>
            <span class="etype">진로</span>
          </div>
          <div class="essay">
            <h2 class="title">관현악의 5대 요소</h2>
            <span class="like">♥ 3</span>
            <span class="regdate">2019.01.01</span>
            <div class="content">
              Lorem ipsum, dolor sit amet consectetur adipisicing elit. Blanditiis tenetur rerum perspiciatis minus quo, temporibus eius architecto nam tempora repellat saepe eos aliquid ratione officiis, ducimus error in, reiciendis cupiditate.
              Lorem ipsum dolor, sit amet consectetur adipisicing elit. Voluptate alias necessitatibus amet sunt exercitationem, voluptas quia aliquam voluptatibus nisi aspernatur neque dolorum porro deserunt quaerat consectetur quibusdam, fugit veniam ducimus.
              Lorem ipsum dolor sit amet consectetur adipisicing elit. Laborum omnis temporibus neque, maiores, repellat expedita facilis aliquid ducimus, repudiandae delectus eum? Incidunt placeat fugit voluptas blanditiis praesentium consequuntur possimus nemo?
            </div>
          </div>
        </li>
      </ul>
    </article>
  </section>
  
  <%@ include file="../include/footer.jsp" %>
  