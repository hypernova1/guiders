<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
#header-img {
  margin-top: 64px;
  width: 100%;
  height: 400px;
  background-image: url("https://www.womeninoilandgas.com.au/wp-content/uploads/2016/11/Mentoring-banner.jpg");
  background-repeat: none;
  background-size: cover;
  z-index: 100;
}
#header-img>div{
  position: absolute;
  top: 200px;
  left: 200px;
  font-size: 2rem;
  color: white;
}
#header-img>div>p{
  margin-bottom: 30px;
}
.btn{
  all: unset;
  display: inline-block;
  font-size: 1rem;
  padding: 10px 15px;
  margin: 5px;
  border-radius: 4px;
  border-color: white;
  background-color: #ff2d55;
  user-select: none;
  cursor: pointer;
}
.btn:hover{
  color: #ff2d55;
  background-color: black;
  transition: 0.3s;
}
section {
  text-align: center;
}
#article>h2 {
  text-align: left;
  margin-top: 30px;
  margin-left: 8%;
}
img {
  width: 120px;
  height: 60px;
}
article {
  display: inline-block;
  margin: 10px;
  width: 412px;
  height: 490px;
  border: 1px solid #dfe6e9;
  border-radius: 4px;
}
.article-title {
  margin: 5px;
}
.article-content {
  text-align: left;
  padding: 20px;
  color: #6d6d72;
  height: 190px;
  overflow: hidden;
}
.article-img {
  width: 100%;
  height: 200px;
}
#article-header {
  text-align: left;
}
.line {
  text-align: center;
}
.line>div {
  display: inline-block;
  width: 90%;
  border-top: 1px solid #f5f6fa;
}

#makers-title{
  text-align: center;
  margin-top: 30px;
}
#makers {
  margin-top: 20px;
  display: flex;
  justify-content: center;
}
.maker {
  display: inline-block;
  width: 300px;
  height: 400px;
  margin: 4px;
  border: 1px solid #dcdde1;
  border-radius: 4px;
}
.maker-img {
  padding: 20px;
}
.maker-img>img {
  display: inline-block;
  border-radius: 100%;
  width: 150px;
  height: 150px;
}
</style>
<%@ include file="../include/header.jsp" %>
<div id="header-img">
    <div>
      <p>지금 바로 가입하세요.</p>
      <button type="button" class="btn" id="join">가입하기</button>
    </div>
  </div>
  <section id="article">
    <h2>꼭 짚고 넘어가야할.. 건 아니지만.. 그래도 좀 필요한 거 같은..</h2>
    <article>
      <img class="article-img" src="https://t1.daumcdn.net/cfile/tistory/1112763C4F78EAB610" alt="">
      <h3 class="article-title">
        무엇을 만들어야 할까요?
      </h3>
      <div class="article-content">
        Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptas qui hic inventore cum rerum impedit provident
        quam accusamus vitae, alias, vero aliquid iure quaerat omnis! Mollitia numquam sit nisi molestias?
        Lorem ipsum, dolor sit amet consectetur adipisicing elit. Repellat nihil commodi ad maxime sit autem, aperiam
        repellendus accusantium voluptas quod! Quisquam quae aut ducimus ipsam expedita soluta laudantium modi
        reiciendis?
        Lorem ipsum dolor sit amet consectetur adipisicing elit. Ipsum quidem veritatis quasi unde non assumenda ullam
        expedita quia corporis recusandae? Corporis, vitae quae deserunt hic aut voluptas dignissimos voluptate
        quaerat?
      </div>
    </article>
    <article>
      <img class="article-img" src="https://t1.daumcdn.net/cfile/tistory/2625CC40588CBDE913">
      <h3 class="article-title">
        바흐가 최고시다.
      </h3>
      <div class="article-content">
        Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptas qui hic inventore cum rerum impedit provident
        quam accusamus vitae, alias, vero aliquid iure quaerat omnis! Mollitia numquam sit nisi molestias?
        Lorem ipsum, dolor sit amet consectetur adipisicing elit. Repellat nihil commodi ad maxime sit autem, aperiam
        repellendus accusantium voluptas quod! Quisquam quae aut ducimus ipsam expedita soluta laudantium modi
        reiciendis?
        Lorem ipsum dolor sit amet consectetur adipisicing elit. Ipsum quidem veritatis quasi unde non assumenda ullam
        expedita quia corporis recusandae? Corporis, vitae quae deserunt hic aut voluptas dignissimos voluptate
        quaerat?
      </div>
    </article>
    <article>
      <img class="article-img" src="http://www.nzkoreapost.com/data/editor/1503/3734505848_1427323781.5205.jpg">
      <h3 class="article-title">
        구텐탁 블리츠크랭크 구텐베레크
      </h3>
      <div class="article-content">
        Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptas qui hic inventore cum rerum impedit provident
        quam accusamus vitae, alias, vero aliquid iure quaerat omnis! Mollitia numquam sit nisi molestias?
        Lorem ipsum, dolor sit amet consectetur adipisicing elit. Repellat nihil commodi ad maxime sit autem, aperiam
        repellendus accusantium voluptas quod! Quisquam quae aut ducimus ipsam expedita soluta laudantium modi
        reiciendis?
        Lorem ipsum dolor sit amet consectetur adipisicing elit. Ipsum quidem veritatis quasi unde non assumenda ullam
        expedita quia corporis recusandae? Corporis, vitae quae deserunt hic aut voluptas dignissimos voluptate
        quaerat?
      </div>
    </article>
    <article>
      <img class="article-img" src="http://t1.daumcdn.net/brunch/service/user/2seV/image/Os4W45qhzxorO-9Q9lEuGbUjOfw.jpg">
      <h3 class="article-title">
        좌절하는 법
      </h3>
      <div class="article-content">
        Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptas qui hic inventore cum rerum impedit provident
        quam accusamus vitae, alias, vero aliquid iure quaerat omnis! Mollitia numquam sit nisi molestias?
        Lorem ipsum, dolor sit amet consectetur adipisicing elit. Repellat nihil commodi ad maxime sit autem, aperiam
        repellendus accusantium voluptas quod! Quisquam quae aut ducimus ipsam expedita soluta laudantium modi
        reiciendis?
        Lorem ipsum dolor sit amet consectetur adipisicing elit. Ipsum quidem veritatis quasi unde non assumenda ullam
        expedita quia corporis recusandae? Corporis, vitae quae deserunt hic aut voluptas dignissimos voluptate
        quaerat?
      </div>
    </article>
    <article>
      <img class="article-img" src="https://www.stibee.com/uploads/141f42f7154652aa9a58299613c6b01f898a0d49/8957-e5c82016d5f04254fb4237c7f9dbd655.jpg">
      <h3 class="article-title">
        노력하는 자는 천재를 이길 수 없다.
      </h3>
      <div class="article-content">
        Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptas qui hic inventore cum rerum impedit provident
        quam accusamus vitae, alias, vero aliquid iure quaerat omnis! Mollitia numquam sit nisi molestias?
        Lorem ipsum, dolor sit amet consectetur adipisicing elit. Repellat nihil commodi ad maxime sit autem, aperiam
        repellendus accusantium voluptas quod! Quisquam quae aut ducimus ipsam expedita soluta laudantium modi
        reiciendis?
        Lorem ipsum dolor sit amet consectetur adipisicing elit. Ipsum quidem veritatis quasi unde non assumenda ullam
        expedita quia corporis recusandae? Corporis, vitae quae deserunt hic aut voluptas dignissimos voluptate
        quaerat?
      </div>
    </article>
    <article>
      <img class="article-img" src="http://img.seoul.co.kr/img/upload/2018/02/04/SSI_20180204152416_V.jpg">
      <h3 class="article-title">
        공부를 왜 하는 걸까.
      </h3>
      <div class="article-content">
        Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptas qui hic inventore cum rerum impedit provident
        quam accusamus vitae, alias, vero aliquid iure quaerat omnis! Mollitia numquam sit nisi molestias?
        Lorem ipsum, dolor sit amet consectetur adipisicing elit. Repellat nihil commodi ad maxime sit autem, aperiam
        repellendus accusantium voluptas quod! Quisquam quae aut ducimus ipsam expedita soluta laudantium modi
        reiciendis?
        Lorem ipsum dolor sit amet consectetur adipisicing elit. Ipsum quidem veritatis quasi unde non assumenda ullam
        expedita quia corporis recusandae? Corporis, vitae quae deserunt hic aut voluptas dignissimos voluptate
        quaerat?
      </div>
    </article>
  </section>
  <div class="line">
    <div></div>
  </div>

  <h2 id="makers-title">DEVELOPERS</h2>
  <section id="makers">
    <div class="maker">
      <div class="maker-img">
        <img src="https://t1.daumcdn.net/cfile/tistory/2668BD39515EC54510">
      </div>
      <h3 class="maker-name">바흐</h3>
      <div class="maker-tech">
        
      </div>
    </div>
    <div class="maker">
      <div class="maker-img">
        <img src="http://auditorium.kr/wp-content/uploads/2018/09/13_%EC%95%84%EB%82%B4%EC%97%90%EA%B2%8C-%EB%B3%B4%EB%82%B4%EB%8A%94-%EB%AA%A8%EC%B0%A8%EB%A5%B4%ED%8A%B8%EC%9D%98-%ED%8E%B8%EC%A7%80_1.jpg">
      </div>
      <h3 class="maker-name">모차르트</h3>
    </div>
    <div class="maker">
      <div class="maker-img">
        <img src="http://imgnn.seoul.co.kr/img//upload/2015/01/08/SSI_20150108110205_V.jpg">
      </div>
      <h3 class="maker-name">베토벤</h3>
    </div>
    <div class="maker">
      <div class="maker-img">
        <img src="https://t1.daumcdn.net/cfile/tistory/140D813A516FF2110F">
      </div>
      <h3 class="maker-name">슈베르트</h3>
    </div>
  </section>
  
  <script>
    document.querySelector('#join').addEventListener('click', () => {
        location.href = '/join';
    })
  </script>
  
  <%@ include file="../include/footer.jsp" %>
