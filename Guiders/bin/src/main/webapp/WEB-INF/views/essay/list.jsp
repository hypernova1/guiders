<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<link rel="stylesheet" href="/css/essay/list.css">
<section>
  <h1>Essay</h1>
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
    <button id="writeBtn" type="button">글쓰기</button>
  </article>
</section>

<script>


document.querySelector('#writeBtn').addEventListener('click', function(){
	location.href = '/essay/write';
});

</script>
  
<%@ include file="../include/footer.jsp" %>
  