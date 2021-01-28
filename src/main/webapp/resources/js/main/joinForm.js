(function(){
    
    const warnMaker = (msg) => {
        const warnMsg = document.createElement('DIV');
        warnMsg.id = 'warn-msg'
        warnMsg.innerText = msg;
        document.body.appendChild(warnMsg);
        let i = 4;
        const start = setInterval(() => {
          warnMsg.style.opacity = 0.01 * i
          i += 4;
          if (i == 500) {
            let j = 100;
            clearInterval(start);
            
            const end = setInterval(() => {
              warnMsg.style.opacity = 0.01 * j
              j -= 2;
              if (j == -2) {
                clearInterval(end);
                document.body.removeChild(warnMsg);
              }
            }, 20);
          }
        }, 20);
    }
    
    const member = {
        email: null,
        password: null,
        name: null,
        birth: null,
        gender: null,
        phone: null,
        photo: null,
        city: null,
        introduction: null,
        quote: null,
        field: null,
        lang: null,
        currentJob: null,
        department: null,
        type: null,
    };
    
    const confirm = {
        email: false,
        password: false,
        repassword: false,
        name: false,
        birth: false,
        gender: false,
        city: false,
        currentJob: false,
        department: false,
        introduction: false,
        quote: false,
        field: false,
        lang: false,
    }

    const exp = {
        email: /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i,
        password: /^[A-Za-z0-9]{6,12}$/,
        name: /^[가-힣]{2,4}$/,
        birth: /^(?:[0-9]{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[1,2][0-9]|3[0,1]))$/,
        city: /^[가-힣]{2,10}$/,
    }
    
    const warnMsg = {
        email: '이메일 형식이 맞지 않습니다.',
        password: '비밀번호는 영문 2자리 이상 + 숫자 6자리 이상입니다.',
        repassword: '입력하신 비밀번호가 서로 다릅니다.',
        name: '이름은 한글 2~4자리 입니다.',
        birth: '생년월일 형식이 맞지 않습니다.',
        gender: '주민등록번호 앞 자리는 1~4까지 입니다.',
        phone: '핸드폰 번호 형식은 000-0000-0000입니다.',
        city: '주소(시)를 입력해주세요.',
        introduction: '상세 정보를 입력해주세요.',
        quote: '인용문을 입력해주세요.',
        field: '분야를 선택해주세요.',
        lang: '언어를 선택해주세요.',
        currentJob: '최근 근무지를 입력해주세요.',
        department: '부서를 입력해주세요.',
    }
    const phone = [];
    document.querySelector('#phone-wrap').addEventListener('change', ({target}) => {
        if(target === document.querySelector('#phone-wrap input:nth-child(2)')){
            phone[0] = target.value;
        } else if(target === document.querySelector('#phone-wrap input:nth-child(3)')){
            phone[1] = target.value;
        } else {
            phone[2] = target.value;
        }
        const $phone = phone.join('-');
        member.phone = $phone;
        
    });
    
    document.querySelector('#join_form').addEventListener('change', ({target}) => {
        let checkedInput = document.querySelectorAll('input[name="' + target.name + '"]:checked');
        switch(target.id){
        case "name":
            if (exp.name.test(target.value)) {
                member.name = target.value;
                confirm.name = true;
                target.style.borderColor = '';
            } else {
                target.style.borderColor = 'red';
                warnMaker(warnMsg.name);
            } break;
        case "gender": 
            if(target.value > 0 && target.value < 5){
                member.gender = target.value;
                confirm.gender = true;
                target.style.borderColor = '';
            } else{
                target.style.borderColor = 'red';
                warnMaker(warnMsg.gender);
            }
            break;
        case "birth": 
            if(exp.birth.test(target.value)){
                member.birth = target.value;
                confirm.birth = true;
                target.style.borderColor = '';
            } else {
                warnMaker(warnMsg.birth);
                target.style.borderColor = 'red';
            }
            break;
        case "city":
            if(exp.city.test(target.value)){
                member.city = target.value;
                confirm.city = true;
                target.style.borderColor = '';
            } else {
                target.style.borderColor = 'red';
            }
            break;
        case "introduction":
            if (target.value) {
                member.introduction = target.value;
                confirm.introduction = true;
                target.style.borderColor = '';
            } else {
                target.style.borderColor = 'red';
                warnMaker(warnMsg.introduction);
            }
            break;
        case "quote":
            if (target.value) {
                member.quote = target.value;
                confirm.quote = true;
                target.style.borderColor = '';
            } else {
                target.style.borderColor = 'red';
                warnMaker(warnMsg.quote);
            }
            break;
        case "currentJob":
            if (target.value) {
                target.style.borderColor = '';
                member.currentJob = target.value;
                confirm.currentJob = true;
            } else {
                target.style.borderColor = 'red';
                warnMaker(warnMsg.currentJob);
            }
            break;
        case "department":
            if (target.value) {
                member.department = target.value;
                confirm.department = true;
                target.style.borderColor = '';
            } else {
                target.style.borderColor = 'red';
                warnMaker(warnMsg.department);
            }
            break;
        }
        
        switch(target.name){
        case "email":
            if (exp.email.test(target.value)) {
                member.email = target.value;
                confirm.email = true;
                target.style.borderColor = '';
            } else {
                target.style.borderColor = 'red';
                warnMaker(warnMsg.email);
            }
            break;
        case "password2":
            if (exp.password.test(target.value)) {
                target.style.borderColor = '';
                member.password = target.value;
                confirm.password = true;
            } else {
                target.style.borderColor = 'red';
                warnMaker(warnMsg.password);
            }
            break;
        case "repassword":
            const password = document.querySelector('input[name="password2"]');
            if (target.value === password.value) {
                confirm.repassword = true;
                target.style.borderColor = '';
            } else {
                target.style.borderColor = 'red';
                warnMaker(warnMsg.repassword);
            }
            break;
        case "field": case "lang":
            confirm[target.name] = true;
            if(checkedInput.length === 2){
                checkedInput[0].checked = false;
                checkedInput[1].checked = false;
                target.checked = true;
            }
            member[target.name] = target.value;
        }
        
        let result = false;
        for (let key in confirm) {
            if (confirm[key] == null) {
                result = true;
                break;
            } else {
                result = false;
            }
        }
        document.querySelector('#join-btn2').disabled = result;
    });
    
    document.querySelector('#join-btn2').addEventListener('click', () => {
        for (let key in confirm) {
            if (!confirm[key]) {
                alert('입력 안했음..');
                return;
            }
        }
        if(document.querySelector('#introduction')){
            let introduction = document.querySelector('#introduction').value;
            introduction = introduction.replace(/(?:\r\n|\r|\n)/g, '<br/>');
            member.introduction = introduction;
            
            let quote = document.querySelector('#quote').value;
            quote = quote.replace(/(?:\r\n|\r|\n)/g, '<br/>');
            member.quote = quote;
            
            member.photo = document.querySelector('#photo').value;
        }
        member.type = document.querySelector('#type').value;
        ajax('/join', 'POST', member).then((result) => {
            if(result) {
                location.href = '/';
            }
        });
    });
    
    function imgAjax(url, method, formData, fileType) {
        return new Promise((resolve, reject) => {

            const xhr = new XMLHttpRequest();

            xhr.onreadystatechange = () => {
                if (xhr.readyState === XMLHttpRequest.DONE) {
                    if (xhr.status === 200) {
                        resolve(xhr.response);
                    } else {
                        reject('Error', xhr.status);
                    }
                }
            }
            xhr.open(method, url);
            xhr.send(formData);
        });
    }
    
    const dropZone = document.querySelector('#drop-zone')
    if(dropZone){
        dropZone.addEventListener('dragenter', function (event) {
            event.preventDefault();
        });
        dropZone.addEventListener('dragover', function (event) {
            event.preventDefault();
        });
        dropZone.addEventListener('drop', function (event) {
            event.preventDefault();
            dropZone.style.borderStyle = 'none';
            dropZone.style.backgroundImage = 'none';
            var files = event.dataTransfer.files;
            var file = files[0];
            var fileType = file.type;
            
            var formData = new FormData();
            formData.append('file', file);
            console.log(formData.getAll('file'));
            
            var url = '/uploadImage';
            var method = 'POST';
            
            imgAjax(url, method, formData, fileType).then(function (result) {
                document.querySelector('#photo').value = result;
                dropZone.innerHTML = '<img src =' + result + '>';
            });
        });  
    }
    
})();