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
            introdution: null,
            quote: null,
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
        
        ajax('/join', 'POST', member).then((result) => {
            if(result) {
                location.href = '/';
            }
        });
    })
    
})();