<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<style>
section{
  margin: 10% 15%;
  min-height: 420px;
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
  cursor: auto;
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
  cursor: pointer;
}
.field, .lang{
  flex: 1;
}
.title{
  flex: 8;
  text-align: left;
  padding-left: 30px;
  cursor: pointer;
}
.regdate{
  flex: 1.5;
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
.essay-body{
}
.essay-content{
  margin: 30px 50px;
}
</style>

<section>
    <article>
      <ul>
      
        <li id="li-head">
          <div class="writer">가이더</div>
          <div class="field">분야</div>
          <div class="lang">언어</div>
          <div class="title">제목</div>
          <div class="regdate">등록일</div>
        </li>
        <li data-mno="1">
          <div class="writer">바흐</div>
          <div class="field">진로</div>
          <div class="lang">C++</div>
          <div class="title">피아노로 코딩하기</div>
          <div class="regdate">2018-01-01</div>
        </li>
        <li data-mno="2">
          <div class="writer">모차르트</div>
          <div class="field">팁</div>
          <div class="lang">JAVA</div>
          <div class="title">오페라로 대화하는 법</div>
          <div class="regdate">2018-01-01</div>
        </li>
      </ul>
    </article>
  </section>
<script>
  document.querySelector('article>ul').addEventListener('click', ({target}) => {
    if(target.parentElement.id === 'li-head' || target.className !== 'title') return;

    const divElem = target.parentElement.nextSibling;
    if(divElem.className === 'essay-body active'){
      divElem.classList.remove('active');
      divElem.classList.add('disable');
    } 
    else if(divElem.className === 'essay-body disable'){
      divElem.classList.remove('disable');
      divElem.classList.add('active');
    }else {
      const div = document.createElement('DIV');
      div.className = 'essay-body';
      // 포스트 Ajax로 가져와서 추가
      div.innerHTML = `<div class="essay">
                          <div class="essay-content">
                              Lorem, ipsum dolor sit amet consectetur adipisicing elit. Iure dolores esse aspernatur aut assumenda voluptatum saepe at delectus accusantium. Voluptas perferendis iure quos in error itaque quaerat velit corporis eaque!
    Delectus itaque modi nam suscipit eveniet ratione quisquam ipsa incidunt quibusdam, vero asperiores quis reprehenderit molestiae, labore debitis necessitatibus culpa deserunt consequuntur blanditiis perspiciatis quod dolor unde eaque facere! Repudiandae.
    A, amet vel eveniet recusandae assumenda dolores beatae dolore iste ullam ducimus, repellendus magnam alias tempore provident rem est quisquam minus facilis eaque perspiciatis debitis. Quasi molestias ab reprehenderit sint?
    Consectetur fugiat maxime error laboriosam optio veritatis cum quos iure corporis tempora! Corrupti porro sed quidem amet officia expedita reprehenderit, asperiores ratione, doloremque dolore fugiat ut, consequuntur facere odio autem.
    Sed earum omnis pariatur doloremque, tempore iste ullam voluptatem nostrum nesciunt vel reiciendis harum? Doloribus placeat cumque, molestiae reprehenderit aut consequatur voluptatem adipisci dicta ad quae vero rem asperiores ut!
    Atque possimus suscipit vitae laboriosam a quasi labore accusamus similique illum, quia dicta soluta esse maiores nam quae molestias porro neque? Illo eaque repudiandae libero rem earum reiciendis atque mollitia!
    Dicta iste quaerat voluptatem nulla exercitationem explicabo possimus maiores. Cumque nulla tenetur natus perspiciatis. Nobis voluptas sit deleniti soluta obcaecati quibusdam, officiis vero nesciunt vitae tenetur, enim expedita suscipit! Corrupti.
    Doloribus, tempora labore, illo obcaecati repudiandae voluptatem officia facere doloremque eaque nihil, esse aut minima iure alias eum? Non officiis, maxime quod quam assumenda amet beatae eum nostrum aliquam provident.
    Accusamus voluptatibus consequuntur numquam deserunt omnis natus error eaque pariatur. Nemo facere suscipit numquam cumque cum! Qui quo quis voluptates, nobis accusamus sequi corrupti mollitia repellat et aliquam. Vel, enim!
    Beatae harum quibusdam mollitia iste, temporibus totam soluta quod accusamus laudantium maiores eaque suscipit. Laborum ex repellat odio praesentium facilis at voluptatibus, expedita rerum optio deleniti, error provident excepturi similique.
                          </div>
                       </div>`;
      div.classList.add('active');
      target.parentElement.after(div);
      return;
    }
  });
</script>


<%@ include file="../include/footer.jsp" %>