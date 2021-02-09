document.querySelector('article>ul').addEventListener('click', ({target}) => {
	
	let id = target.parentNode.getAttribute('data-id');
	
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
      
      ajax('/api/essay/' + id, 'get', id).then((essay) => {
          div.innerHTML = `<div class="essay">
              <div class="essay-content">${essay.content}</div>
              <div class="like">♥</div>
            </div>`;
      });
      div.classList.add('active');
      target.parentElement.after(div);
    }
});