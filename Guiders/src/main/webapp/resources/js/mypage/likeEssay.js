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
                         <div class="like">♥</div>
                       </div>`;
      div.classList.add('active');
      target.parentElement.after(div);
      return;
    }
  });
