document.querySelector('article>ul').addEventListener('click', ({target}) => {
	
	let eno = target.parentNode.getAttribute('data-eno');
	
    if(target.parentElement.id === 'li-head' || target.className !== 'title') return;

    const divElem = target.parentElement.nextSibling;
    if(divElem.className === 'essay-body active'){
      divElem.classList.remove('active');
      divElem.classList.add('disable');
    } else if(divElem.className === 'essay-body disable'){
      divElem.classList.remove('disable');
      divElem.classList.add('active');
    } else {
      const div = document.createElement('DIV');
      div.className = 'essay-body';
      
      ajax('/mypage/likeEssay/'+eno, 'get', eno).then((result) => {
          div.innerHTML = `<div class="essay">
              <div class="essay-content">${result}</div>
              <div class="like">♥</div>
            </div>`;
      });
      div.classList.add('active');
      target.parentElement.after(div);
      return;
    }
});