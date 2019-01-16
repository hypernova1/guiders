const mypageList = document.querySelector('#mypage-list');

document.querySelector('#mypage').addEventListener('click', function () {
  mypageList.classList.toggle('active');
  mypageList.style.height = mypageList.classList.contains('active') ? mypageList.scrollHeight + 'px' : 0;
  mypageList.style.borderColor = mypageList.classList.contains('active') ? '#f5f6fa' : '';
});

document.querySelector('#logo').addEventListener('click', function(){
    location.href = '/';
});

document.querySelector('#essay').addEventListener('click', function(){
    location.href = '/essay/list';
});

document.querySelector('#guiders').addEventListener('click', function(){
    location.href = '/guiders';
});

const modal = document.querySelector('#login-modal');
document.querySelector('#login').addEventListener('click', function(){
  mypageList.classList.toggle('active');
  mypageList.style.height = mypageList.classList.contains('active') ? mypageList.scrollHeight + 'px' : 0;
  mypageList.style.borderColor = mypageList.classList.contains('active') ? '#f5f6fa' : '';
  let i = 1;
  modal.style.display = 'block';
  const increase = setInterval(function(){
    if (i == 51) {
      clearInterval(increase);
    } else {
      modal.style.backgroundColor = 'rgba(0, 0, 0,' + 0.01 * i + ')';
      i++;
    }
  }, 10);
});

window.addEventListener('click', function(e) {
  if(e.target.id == 'login-modal') {
    let i = 50;
    const decrease = setInterval(function(){
      if(i == -1) {
        modal.style.display = 'none';
        clearInterval(decrease);
      } else {
        modal.style.backgroundColor = 'rgba(0, 0, 0,' + 0.01 * i + ')';
        i--;
      }
    }, 10);
  }
});
