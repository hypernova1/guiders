/*$('.emailInput').change(function () {
  $("#selectEmail option:selected").each(function () {
    if ($(this).val() == '1') { //직접입력일 경우
      $("#str_email02").val(''); //값 초기화 
      $("#str_email02").attr("disabled", false); //활성화
    } else { //직접입력이 아닐경우
      $("#str_email02").val($(this).text()); //선택값 입력
      $("#str_email02").attr("disabled", true); //비활성화
    }
  });
});

$('#city').change(function () {
  $("#city option:selected").each(function () {
    $("#InputCity").val($(this).text()); //선택값 입력
  });
});*/

(function(){
    
    const member = {
            email: null,
            password: null,
            mname: null,
            gender: null,
            phone: null,
            photo: null,
            ctno: null,
            introdution: '',
            quote: '',
            field: null,
            lang: null,
            currentjob: null,
            dept: null,
            };
    
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
        case "mname": case "gender": case "phone": case "birth": 
        case "photo": case "ctno": case "introdution": case "quote":
        case "currentjob": case "dept":
            member[target.id] = target.value;
        }
        switch(target.name){
        case "email": case "password": 
            member[target.name] = target.value;
        case "field": case "lang":
            if(checkedInput.length == 2){
                checkedInput[0].checked = false;
                checkedInput[1].checked = false;
                target.checked = true;
            }
            member[target.name] = target.value;
        }
    });
    
    document.querySelector('#join-btn2').addEventListener('click', () => {
        let introdution = document.querySelector('#introdution').value;
        introdution = introdution.replace(/(?:\r\n|\r|\n)/g, '<br/>');
        member.introdution = introdution;
        
        let quote = document.querySelector('#quote').value;
        quote = quote.replace(/(?:\r\n|\r|\n)/g, '<br />');
        member.quote = quote;
        
        member.photo = document.querySelector('#photo').value;
        
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
            /* xhr.setRequestHeader('Content-Type', fileType); */
            /* xhr.send(JSON.stringify(formData)); */
            xhr.send(formData);
        });
    }
    
    document.querySelector('#drop-zone').addEventListener('dragenter', function (event) {
        event.preventDefault();
    });
    document.querySelector('#drop-zone').addEventListener('dragover', function (event) {
        event.preventDefault();
    });
    document.querySelector('#drop-zone').addEventListener('drop', function (event) {
        event.preventDefault();
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
            document.querySelector('#drop-zone').innerHTML = '<img src =' + result + '>';
        });

    });  
    
})();