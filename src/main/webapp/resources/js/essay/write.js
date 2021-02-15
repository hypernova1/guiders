//전역변수
const obj = [];
//스마트에디터 프레임생성
nhn.husky.EZCreator.createInIFrame({
    oAppRef: obj,
    elPlaceHolder: "editor",
    sSkinURI: "/editor/SmartEditor2Skin.html",
    htParams : {
        // 툴바 사용 여부
        bUseToolbar : true,
        // 입력창 크기 조절바 사용 여부
        bUseVerticalResizer : true,
        // 모드 탭(Editor | HTML | TEXT) 사용 여부
        bUseModeChanger : true,
    }
});
//전송버튼
// document.getElementById("writeBtn").addEventListener('click', function(){
//     //id가 editor인 textarea에 에디터에서 대입
//     obj.getById["editor"].exec("UPDATE_CONTENTS_FIELD", []);
//     const title = $("#title").val();
//     fetch('/doA', {
//         method: 'POST',
//         headers: {
//             'Content-Type': 'application/json',
//             'x-http-method-override': 'post',
//         },
//         body: JSON.stringify({ title }),
//     }).then((res) => {
//         if (res.status === 200) {
//             //폼 submit
//             document.getElementById("insertEssayForm").submit();
//         }
//     })
// });
