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
            lang:null,
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
        switch(target.id){
        case "email": case "password": case "mname": case "gender": case "phone": case "birth": 
        case "photo": case "ctno": case "introdution": case "quote": case "field": case "lang": 
            member[target.id] = target.value;
        }
        console.log(member);
    })
    
    document.querySelector('#join-btn2').addEventListener('click', () => {
        
        ajax('/join', 'POST', member).then((result) => {
            if(result) {
                location.href = '/';
            }
        });
    })
    
})();