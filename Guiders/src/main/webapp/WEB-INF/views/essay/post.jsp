<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<style>
  *, *::before, *::after{
    margin: 0;
    padding: 0;
    box-sizing: border-box;
  }
  section{
    margin: 10% 20%;
  }
  #title{
    text-align: center;
    margin-top: 20px;
    font-size: 2rem;
  }
  #mtr-info{
    float: right;
    margin-right: 40px;
  }
  #mtr-info>img{
    width: 120px;
    height: 120px;
    border-radius: 100%;
  }
  .mtr-name{
    text-align: center;
    font-weight: bold;
  }
  #field, #lang{
    display: inline-block;
    border: 1px solid;
    border-radius: 4px;
    text-align: center;
    padding: 4px;
    width: 3rem;
    cursor: unset;
    user-select: none;
  }
  #content{
    margin-top: 30px;
    border-top: 1px solid #bdc3c7;
    padding-top: 30px;
  }
  #like{
    margin-top: 100px;
    text-align: center;
    color: red;
    font-size: 1.3rem;
  }
  #like>span{
    display: inline-block;
    padding: 4px;
    width: 120px;
    border: 1px solid #b2bec3;
    border-radius: 8px;
  }
  .mtr-name>span:nth-child(2){
    font-size: 1rem;
    color: #6d6d72;
  }
  #mtr-detail{
    margin: 30px 0;
    padding: 20px;
    height: 160px;
    border-top: 1.5px solid #b2bec3; 
    border-bottom: 1.5px solid #b2bec3; 
  }
  #mtr-detail>div{
    float: left;
    font-size: 1.5em;
    margin: 3px;
  }
  .mtr-name>.follow-btn, .mtr-name>.qna-btn{
    display: inline-block;
    border: 2px solid red;
    border-radius: 4px;
    padding: 4px;
    font-size: 0.8rem;
    cursor: pointer;
  }
  #mtr-img{
    float: right;
    width: 120px;
    height: 120px;
    border-radius: 100%;
    margin-right: 10px;
  }
  #mtr-btn-wrap{
    margin-top: 20px;
    text-align: left;
  }
  #mtr-essay-btn, #mtr-page-btn{
    font-size: 1rem;
    font-weight: 400;
    margin: 10px;
    cursor: pointer;
  }
  #mtr-essay-btn:hover, #mtr-page-btn:hover{
    text-decoration: underline;
  }
</style>

<section>
  <article>
    <div id="mtr-info">
<!--         <img src="https://media.wnyc.org/i/800/0/l/85/1/bach.png">
        <div class="mtr-name">바흐</div> -->
    </div>
    <div id="field">진로</div>
    <div id="lang">C++</div>
    <h1 id="title">어떡하지..</h1>
    <div id="content">Lorem ipsum dolor sit amet consectetur adipisicing elit. Laudantium, minima explicabo. Animi temporibus minima vitae dolor dolorem ratione ducimus eius cumque? Nemo consequuntur quo voluptatum ipsam dolorem illo quod fugiat.
    Dicta qui facere illo iure neque! Quo veniam modi velit et quam debitis iusto vitae laborum dolor repellat totam sapiente, autem est voluptas numquam error adipisci in enim unde laudantium!
    Quasi commodi non incidunt odio eum, beatae distinctio, ducimus mollitia at provident veritatis unde aperiam saepe omnis fugit quia et dolorum reprehenderit ullam sunt. Beatae quisquam consequuntur obcaecati deleniti rerum.
    Maiores odio, vel deleniti sed nihil minima, hic tenetur fugit suscipit labore dolor illum eligendi neque ad nam? Aliquam repudiandae mollitia incidunt corporis neque amet. Odio autem qui earum voluptate.
    Asperiores eaque perspiciatis debitis obcaecati est in, fugit numquam voluptate odio quasi libero quos ipsum labore neque esse voluptas non architecto, minima qui nulla pariatur? Minus delectus quasi itaque ullam.
    Placeat, eveniet, repellendus accusantium possimus officia expedita fugiat alias sint id beatae itaque maiores aut facere quia nisi, temporibus optio asperiores distinctio blanditiis repudiandae ut. Ullam incidunt recusandae eligendi quos!
    Perferendis, voluptate soluta aspernatur tempore totam fugiat enim sapiente officiis amet perspiciatis, illum autem obcaecati adipisci quis voluptates odit at aliquid optio quibusdam, ullam sed quam libero. Aspernatur, fugit ab.
    Accusantium quibusdam suscipit rerum saepe eius sequi. Dolorum molestias adipisci omnis, magnam nemo vel ipsam libero, ullam necessitatibus assumenda provident! Veritatis amet laborum voluptatibus quae tenetur? Repudiandae eligendi voluptatibus quasi.
    Nulla, omnis aspernatur porro labore delectus, odio voluptas repudiandae modi aliquam commodi atque. Voluptate quae nobis odio neque ipsam placeat itaque. Quia asperiores dignissimos distinctio, hic accusantium illum iste laborum.
    Nobis facilis qui fugit, laboriosam laborum fugiat hic, minima dolores necessitatibus atque nemo voluptatem consequatur expedita commodi ex facere iste iure quas. Commodi incidunt facilis adipisci quas culpa, iste nemo?</div>
  </article>
  <div id="like">
    <span>♥ 3</span>
  </div>
  <div id="mtr-detail">
    <img id="mtr-img" src="https://media.wnyc.org/i/800/0/l/85/1/bach.png">
    <div class="mtr-name">
      <span>바흐</span>
      <span>멘토</span>
      <div class="follow-btn">팔로우</div>
      <div class="qna-btn">질문하기</div>
      <div id="mtr-btn-wrap">
        <div id="mtr-essay-btn">
          작성 에세이 보기
        </div>
        <div id="mtr-page-btn">
          멘토 상세정보
        </div>
      </div>
    </div>
  </div>
</section>

<%@ include file="../include/footer.jsp" %>