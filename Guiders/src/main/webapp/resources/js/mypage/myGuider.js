window.addEventListener('load', () => {
    ajax('/mypage/myGuiders', 'GET', {}).then((result) => {
        const guiderList = JSON.parse(result);
        guiderList.forEach((guider) => {
          document.querySelector('.title').innerHTML += `<ul class="follower-content">
            <li class="explain">
              <div>멘토 정보</div>
              <div>질문글 : 3개</div>
            </li>
            <li>
              <img class="profile-img" src="/img/naruto.jpg">
              <div class="guider-name">` + guider.mname + ` 가이더</div>
            </li>
            <li>
              <p>근무 회사 : Coupang</p>
              <p>담당 부서 : UI Design</p>
              <p>가이드 분야 : 취업 상담</p>
            </li>
            <li>
              <p>호카게가 되려면 어떤 라인을 타야 할까요?</p>
              <p>3대 호카게 할아버지가 재산 꿀꺽한거 알고 있긴 하신가요</p>
              <p>나선환쪽 말고 다른 인술 사용할 생각은 없으신가요?</p>
            </li>
            <li>
              <button class="question-btn">질문하기</button>
              <button class="unfollow-btn">UNFOLLOW</button>
            </li>
          </ul>`
        })
    });
});

/*document.querySelector('.question-btn').addEventListener('click', function() {
    const modal = document.querySelector('#mtr-modal');
    const modalBody = document.querySelector('#mtr-modal-body');
    modal.style.display = 'block';
    let i = 1;
    const increase = setInterval(function () {
      if (i == 51) {
        clearInterval(increase);
      } else {
        modal.style.backgroundColor = 'rgba(0, 0, 0,' + 0.01 * i + ')';
        i++;
      }
    }, 10);

    
    });
  });*/

var body = document.body;
var guiderModal = document.getElementById("modal");
var modalSpan = document.getElementsByClassName("close")[0];
    
document.querySelector('.title').addEventListener("click", ({target}) => {
    switch(target.className){
    case 'profile-img':
        guiderModal.style.display = "block";
        body.style.overflow = "hidden";
        break;
    case 'question-btn':
        const modal = document.querySelector('#mtr-modal');
        const modalBody = document.querySelector('#mtr-modal-body');
        modal.style.display = 'block';
        let i = 1;
        const increase = setInterval(function () {
          if (i == 51) {
            clearInterval(increase);
          } else {
            modal.style.backgroundColor = 'rgba(0, 0, 0,' + 0.01 * i + ')';
            i++;
          }
        }, 10);
        document.querySelector('#mtr-cancel').addEventListener('click', function () {
            let i = 50;
            const decrease = setInterval(function () {
                if (i == -1) {
                    modal.style.display = 'none';
                    modalBody.style.opacity = 1;
                    clearInterval(decrease);
                } else {
                    modal.style.backgroundColor = 'rgba(0, 0, 0,' + 0.01 * i + ')';
                    modalBody.style.opacity = 0.02 * i;
                    i--;
                }
            }, 10);
        });
        break;
    }
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