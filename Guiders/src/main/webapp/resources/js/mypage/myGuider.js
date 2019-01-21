window.addEventListener('load', () => {
    ajax('/mypage/myGuiders', 'GET', {}).then((result) => {
        const guiderList = JSON.parse(result);
        
        guiderList.forEach((guider) => {
            let ques = '';
            if(guider.question.length){
                ques = '<p class="question-head">질문 목록</p>';
                guider.question.forEach((q) => {
                    ques += '<p class="question" data-mtrno="' + q.mtrno + '">' + q.mtitle + '</p>';
                });
            } else{
                ques = '<p class="question-suggestion">질문을 남겨보세요!</>'
            }
          document.querySelector('.title').innerHTML += `<ul class="follower-content">

            <li>
              <img class="profile-img" src="/img/naruto.jpg">
              <div class="guider-name">` + guider.mname + ` 가이더</div>
            </li>
            <li>
              <div class="mtr-info">
                <div class="job"><div>근무회사</div> ` + guider.currentjob + `</div>
                <div class="dept"><div>부서</div> ` + guider.dept + `</div>
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
            </li>
            <input type="hidden" value="` + guider.email + `">
          </ul>
          `
        })
    });
});

/*
 * document.querySelector('.question-btn').addEventListener('click', function() {
 * const modal = document.querySelector('#mtr-modal'); const modalBody =
 * document.querySelector('#mtr-modal-body'); modal.style.display = 'block'; let
 * i = 1; const increase = setInterval(function () { if (i == 51) {
 * clearInterval(increase); } else { modal.style.backgroundColor = 'rgba(0, 0,
 * 0,' + 0.01 * i + ')'; i++; } }, 10);
 * 
 * 
 * }); });
 */

var body = document.body;
var guiderModal = document.getElementById("modal");
var modalSpan = document.getElementsByClassName("close")[0];
const mtrModal = document.querySelector('#mtr-modal');
const mtrModalBody = document.querySelector('#mtr-modal-body');

document.querySelector('.title').addEventListener("click", ({target}) => {
    switch(target.className){
    case 'profile-img':
        guiderModal.style.display = "block";
        body.style.overflow = "hidden";
        break;
    case 'question-btn':
        const hiddenList = target.parentElement.parentElement.querySelectorAll('input[type="hidden"]');
        document.querySelector('#guider-email').value = 
            target.parentElement.parentElement.querySelector('input').value;
        document.querySelector('#field').innerText = hiddenList[0].value;
        document.querySelector('#lang').innerText = hiddenList[1].value;
        document.querySelector('#mtr-modal-body>h2>span').innerText = hiddenList[2].value;
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
    }
    
    if(target.getAttribute('data-mtrno')){
        location.href = '/qna/' + target.getAttribute('data-mtrno');
    }
    
});

document.querySelector('#mtr-submit').addEventListener('click', function({target}) {
    const mentoring = {
            guider: document.querySelector('#guider-email').value,
            field: document.querySelector('#field').innerText,
            lang: document.querySelector('#lang').innerText,
            mtitle: document.querySelector('input[name="mtitle"]').value,
            mcontent: document.querySelector('textarea[name="mcontent"]').value,
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

    
modalSpan.addEventListener("click", function(){
     guiderModal.style.display = "none";
     body.style.overflow = "";
});
    
window.addEventListener("click", function(){
    if(event.target == guiderModal){
        guiderModal.style.display = "none";
        body.style.overflow = "";
    }
});