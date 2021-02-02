const mypageList = document.querySelector('#mypage-list');
const modal = document.querySelector('#login-modal');

document.querySelector('#mypage').addEventListener('click', function () {
  mypageList.classList.toggle('active');
  mypageList.style.height = mypageList.classList.contains('active') ? mypageList.scrollHeight + 'px' : 0;
  mypageList.style.borderColor = mypageList.classList.contains('active') ? '#f5f6fa' : '';
});

if(document.querySelector('#login')){
	document.querySelector('#login').addEventListener('click', function(){
		  mypageList.classList.toggle('active');
		  mypageList.style.height = mypageList.classList.contains('active') ? mypageList.scrollHeight + 'px' : 0;
		  mypageList.style.borderColor = mypageList.classList.contains('active') ? '#f5f6fa' : '';
		  
		  let i = 1;
		  modal.style.display = 'block';
		  const increase = setInterval(function(){
		    if (i === 51) {
		      clearInterval(increase);
		    } else {
		      modal.style.backgroundColor = 'rgba(0, 0, 0,' + 0.01 * i + ')';
		      i++;
		    }
		  }, 10);
		});
}

window.addEventListener('click', function(e) {
  const modalBody = document.querySelector('#login-modal-content');
  if(e.target.id === 'login-modal') {
    let i = 50;
    const decrease = setInterval(function(){
      if(i === -1) {
        modal.style.display = 'none';
        modalBody.style.opacity = 1;
        clearInterval(decrease);
      } else {
        modal.style.backgroundColor = 'rgba(0, 0, 0,' + 0.01 * i + ')';
        modalBody.style.opacity = String(0.02 * i);
        i--;
      }
    }, 10);
  }
});

function get_msg(message) {
	var move = '70px';
	jQuery('#message').text(message);
	jQuery('#message').animate({
		top : '+=' + move
	}, 'slow', function() {
		jQuery('#message').delay(1000).animate({
			top : '-=' + move
		}, 'slow');
	});
}

document.querySelector('#login-fail-modal-content>button').addEventListener('click', () => {
    document.querySelector('#login-fail-modal').style.display = 'none';
});

function signin() {
	const email = document.getElementById('email').value;
	const password = document.getElementById('password').value;

	fetch('/api/login',{
		method: 'POST',
		headers: {
			'Content-Type': 'application/json',
		},
		body: JSON.stringify({ email, password })
	}).then((res) => {
		if (res.status === 404) {
			document.querySelector('#login-fail-modal').style.display = 'block';
			return;
		}
		location.reload();
	});
}


document.querySelector('.search-btn').addEventListener('click', function(e){
	let keyword = document.querySelector('.search-txt').value;
	if(!keyword){
		alert('검색 키워드를 입력해주세요');
		return;
	}
	document.querySelector('#search-form').submit();
});

let naverName = sessionStorage.getItem("naverName");
if(naverName != null){
	document.querySelector('#naverName').textContent = naverName + '님';
}

const naverLogoutTag = document.querySelector('#naverLogout');
if (naverLogoutTag != null) {
	naverLogoutTag.addEventListener('click', function(){
		console.log('........');
		sessionStorage.removeItem("naverName");
		window.open("https://nid.naver.com/nidlogin.logout","네이버 로그아웃",
			"width=800, height=700, toolbar=no, menubar=no, scrollbars=no, resizable=yes");
		location.href = '/logout';

	});
}

document.querySelector('#naver-login').addEventListener('click', function(){
	location.href = '${url}';
});