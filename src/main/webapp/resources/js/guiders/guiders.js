const body = document.body;
const guiderModal = document.querySelector("#modal");
const modalSpan = document.getElementsByClassName("close")[0];

window.addEventListener('load', () => {
    fetch(`/guider?page=${page}`)
        .then((res) => res.json())
        .then((data) => drawGuiderList(data))
});

modalSpan.addEventListener("click", () => {
     guiderModal.style.display = "none";
     body.style.overflow = "";
});

window.addEventListener("click", () => {
    if(event.target === guiderModal){
        guiderModal.style.display = "none";
        body.style.overflow = "";
    }
});

document.querySelector('.guider-wrapper').addEventListener('click', ({target}) => {
    const id = target.parentElement.id || target.parentElement.parentElement.id;
    switch(target.className){
        case "profile-img":
            fetch(`/guider/${id}`)
                .then((res) => res.json())
                .then((guider) => {
                    drawModal(guider);
                });
            break;
        case "btn follow":
            fetch(`follow/${id}`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
            }).then((res) => {
                if (res.status === 200) {
                    target.innerText = 'UnFollow';
                    target.classList.remove('follow');
                    target.classList.add('unfollow');
                } else {
                    let i = 1;
                    const modal = document.querySelector('#login-modal');
                    modal.style.display = 'block';
                    const increase = setInterval(function() {
                        if (i === 51) {
                            clearInterval(increase);
                        } else {
                            modal.style.backgroundColor = `rgba(0, 0, 0,${0.01 * i})`;
                            i++;
                        }
                    }, 10);
                }
            })
            break;
        case "btn unfollow":
            fetch(`/follow/${id}`, {
                method: 'DELETE'
            }).then((res) => {
                if (res.status === 200) {
                    target.innerText = 'Follow';
                    target.classList.remove('unfollow');
                    target.classList.add('follow');
                }
            });
            break;
        }
});

let page = 1;

function drawGuiderList(guiderList) {
    let data = ''
    guiderList.forEach(guider => {
        data += `
            <div class="wrapper">
                <div class="container" id="${guider.id}">
                    <img src="${guider.photoUrl}" alt="" class="profile-img">
                    <div class="content">
                    <div class="sub-content">
                    <h1>${guider.name}</h1>
                    <span>${guider.email}</span>
                    <p>${guider.department}</p>
                    <span class="location">
                        <i class="fa fa-map-marker" aria-hidden="true"></i>${guider.currentJob}
                    </span>
                </div>`
        if (guider.isFollow) {
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

function drawModal(guider) {
    document.querySelector('.modal-content-title>img').src = guider.photoUrl;
    document.querySelector('div>strong').innerText = guider.name;
    document.querySelector('.modal-content-title>div:nth-child(4)>span:nth-child(2)').innerText
        = guider.currentJob;
    document.querySelector('.modal-content-title>div:nth-child(5)>span:nth-child(2)').innerText
        = guider.department;
    document.querySelector('.modal-content-title>div:nth-child(6)>span:nth-child(2)').innerText
        = guider.field;
    document.querySelector('.modal-content-body>div').innerHTML = guider.introduction;
    document.querySelector('#quote').innerHTML = guider.quote;
    guiderModal.style.display = "block";
}

window.addEventListener('scroll', () => {
    const wrap = document.querySelector('.guider-wrapper');
    const contentHeight = wrap.offsetHeight;
    const yOffset = window.pageYOffset;
    const y = yOffset + window.innerHeight;

    if(y >= contentHeight){
      page++;
      fetch(`/guider?page=${page}`)
          .then((res) => res.json())
          .then((result) => {
              if(result.length) return;
              drawGuiderList(result);
          })
    }
});