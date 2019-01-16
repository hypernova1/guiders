$('#selectEmail').change(function () {
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
});
