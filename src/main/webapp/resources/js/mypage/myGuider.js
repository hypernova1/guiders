window.addEventListener('load', () => {
    ajax('/following', 'GET', {}).then((result) => {
        const guiderList = JSON.parse(result);
        
        guiderList.forEach((guider) => {
            let ques = '';
            if(guider.question.length){
                ques = '<p class="question-head">질문 목록</p>';
                guider.question.forEach((q) => {
                    ques += '<p class="question" data-mtrno="' + q.id + '">' + q.title + '</p>';
                });
            } else{
                ques = '<p class="question-suggestion">질문을 남겨보세요!</>'
            }
          document.querySelector('.title').innerHTML +=
          `<ul class="follower-content">
            <li>
              <img class="profile-img" src="` + guider.photo + `">
              <div class="guider-name">` + guider.name + ` 가이더</div>
            </li>
            <li>
              <div class="mtr-info">
                <div class="job"><div>근무회사</div> ` + guider.currentJob + `</div>
                <div class="department"><div>부서</div> ` + guider.department + `</div>
                <input type="hidden" class="field "value="` + guider.field + `">
                <input type="hidden" class="lang" value="` + guider.lang + `">
              </div>
            </li>
            <li>
              ${ques}
            </li>
            <li>
              <button class="question-btn">질문하기</button>
              <button class="unfollow-btn">UNFOLLOW</button>
              <div class="more-qna">전체 질문 보기</div>
            </li>
            <input type="hidden" class="guider-email" value="` + guider.email + `">
          </ul>`
        });
    });
});

const body = document.body;
const guiderModal = document.getElementById("modal");
const modalSpan = document.getElementsByClassName("close")[0];
const mtrModal = document.querySelector('#mtr-modal');
const mtrModalBody = document.querySelector('#mtr-modal-body');

document.querySelector('.title').addEventListener("click", ({target}) => {
    switch(target.className){
    case 'profile-img':
        const guiderEmail = target.parentElement.parentElement.lastElementChild.value;
        ajax(`/guider?email=${guiderEmail}`, 'GET', {}).then((result) => {
            const guider = JSON.parse(result);
            document.querySelector('.modal-content-title>img').src = guider.photo;
            document.querySelector('div>strong').innerText = guider.name;
            document.querySelector('.modal-content-title>div:nth-child(4)>span:nth-child(2)').innerText 
                = guider.currentJob;
            document.querySelector('.modal-content-title>div:nth-child(5)>span:nth-child(2)').innerText
                = guider.department;
            document.querySelector('.modal-content-title>div:nth-child(6)>span:nth-child(2)').innerText
            = guider.field;
            document.querySelector('.modal-content-body > div').innerHTML = guider.introduction;
            guiderModal.style.display = "block";
        });
        break;
        
    case 'question-btn':
        const hiddenList = target.parentElement.parentElement.querySelectorAll('input[type="hidden"]');
        document.querySelector('#field').innerText = hiddenList[0].value;
        document.querySelector('#lang').innerText = hiddenList[1].value;
        document.querySelector('#guider-email').value = hiddenList[2].value;
        document.querySelector('#mtr-modal-body>h2>span').innerText = 
            target.parentElement.parentElement.firstElementChild.children[1].innerText
        mtrModal.style.display = 'block';
        let i = 1;
        const increase = setInterval(function () {
          if (i == 51) {
            clearInterval(increase);
          } else {
            mtrModal.style.backgroundColor = 'rgba(0, 0, 0,' + 0.01 * i + ')';
            i++;
          }
        }, 10);
        break;
        
    case "more-qna": 
        location.href = `/mentoring/list?email=${target.parentElement.parentElement.querySelector('.guider-email').value}`;
    }
    
    if(target.getAttribute('data-mtrno')){
        location.href = '/qna/' + target.getAttribute('data-mtrno');
    }
    
});

document.querySelector('#mtr-submit').addEventListener('click', function({target}) {
    let content = document.querySelector('textarea[name="content"]').value;
    content = content.replace(/(?:\r\n|\r|\n)/g, '<br />');
    const mentoring = {
            guider: document.querySelector('#guider-email').value,
            field: document.querySelector('#field').innerText,
            lang: document.querySelector('#lang').innerText,
            title: document.querySelector('input[name="title"]').value,
            content: content,
    }
    
    
    
    ajax('/mentoring', 'POST', mentoring).then((result) => {
        if (result){
           location.reload(); 
        } else {
            console.log(result);
        }
    });
    
});

document.querySelector('#mtr-cancel').addEventListener('click', function () {
    let i = 50;
    const decrease = setInterval(function () {
        if (i == -1) {
            mtrModal.style.display = 'none';
            mtrModalBody.style.opacity = 1;
            clearInterval(decrease);
        } else {
            mtrModal.style.backgroundColor = 'rgba(0, 0, 0,' + 0.01 * i + ')';
            mtrModalBody.style.opacity = 0.02 * i;
            i--;
        }
    }, 10);
});

    
/*modalSpan.addEventListener("click", function(){
     guiderModal.style.display = "none";
     body.style.overflow = "";
});*/
    
window.addEventListener("click", function(){
    if(event.target == guiderModal){
        guiderModal.style.display = "none";
        body.style.overflow = "";
    }
});