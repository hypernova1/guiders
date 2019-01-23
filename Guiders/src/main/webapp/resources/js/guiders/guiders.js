const body = document.body;
const guiderModal = document.querySelector("#modal");
    
const modalSpan = document.getElementsByClassName("close")[0];

modalSpan.addEventListener("click", () => {
     guiderModal.style.display = "none";
     body.style.overflow = "";
});
window.addEventListener("click", () => {
    if(event.target == guiderModal){
        guiderModal.style.display = "none";
        body.style.overflow = "";
    }
});

document.querySelector('.guider-wrapper').addEventListener('click', ({target}) => {
    switch(target.className){
    case "profile-img":
        const guiderEmail = target.parentElement.querySelector('span').innerText;
        ajax(`/guider?email=${guiderEmail}`, 'GET', {}).then((result) => {
            const guider = JSON.parse(result);
            document.querySelector('.modal-content-title>img').src = guider.photo;
            document.querySelector('div>strong').innerText = guider.mname;
            document.querySelector('.modal-content-title>div:nth-child(4)>span:nth-child(2)').innerText 
                = guider.currentjob;
            document.querySelector('.modal-content-title>div:nth-child(5)>span:nth-child(2)').innerText
                = guider.dept;
            document.querySelector('.modal-content-title>div:nth-child(6)>span:nth-child(2)').innerText
            = guider.field;
            document.querySelector('.modal-content-body > div').innerHTML = guider.introdution;
        });
        guiderModal.style.display = "block";
        break;
    case "btn follow":
        ajax('/follow', 'POST', {guider: target.parentElement.children[0].children[1].innerText}).then((result) => {
            const _result = JSON.parse(result);
           if(_result){
               target.innerText = 'UnFollow';
               target.classList.remove('follow');
               target.classList.add('unfollow');
           } else {
               let i = 1;
               const modal = document.querySelector('#login-modal');
               modal.style.display = 'block';
               const increase = setInterval(function(){
                 if (i == 51) {
                   clearInterval(increase);
                 } else {
                   modal.style.backgroundColor = 'rgba(0, 0, 0,' + 0.01 * i + ')';
                   i++;
                 }
               }, 10);
           }
        });
        break;
    case "btn unfollow":
        ajax('/follow', 'DELETE', {guider: target.parentElement.children[0].children[1].innerText}).then((result) => {
            if(result){
               target.innerText = 'Follow';
               target.classList.remove('unfollow');
               target.classList.add('follow');
            }
        });
        break;
    
    }
});

let page = 0;

const getData = (result) => {
        const guiders = JSON.parse(result);
        let data = ''
        guiders.forEach(guider => {
          data += `
              <div class="wrapper">
              <div class="container">
                <img src="` + guider.photo + `" alt="" class="profile-img">
                <div class="content">
                  <div class="sub-content">
                    <h1>` + guider.mname + `</h1>
                    <span>` + guider.email + `</span>
                    <p>` + guider.dept + `</p>
                    <span class="location">
                      <i class="fa fa-map-marker" aria-hidden="true"></i>` + guider.currentjob + `</span>
                  </div>`
                  if(guider.fno){
                      data += `<div class="btn unfollow">UnFollow</div>`
                  } else {
                      data += `<div class="btn follow">Follow</div>`
                  }
                data += `</div>
              </div>
            </div>`
           });
        document.querySelector('.guider-wrapper').innerHTML += data;
}

window.addEventListener('load', () => {
    ajax('/guider/list/' + page, 'GET', {}).then((result) => {
      getData(result);
    });
});

window.addEventListener('scroll', () => {
    const wrap = document.querySelector('.guider-wrapper');
    const contentHeight = wrap.offsetHeight;
    const yOffset = window.pageYOffset;
    const y = yOffset + window.innerHeight;

    if(y >= contentHeight){
      page += 16;
      ajax('/guider/list/' + page, 'GET', {}).then((result) => {
        if(!JSON.parse(result).length) return;
        getData(result);
      });
    }
        
});