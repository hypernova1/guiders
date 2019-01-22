<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
.drop-zone {
	font-weight: bold;
	font-size: 25px;
	text-align: center;
	border: 1px solid black;
	width: 500px;
	height: 300px;
	display: table-cell;
	vertical-align: middle;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="drop-zone">여기에 끌어다놓으세요</div>

    <script>
        function ajax(url, method, formData, fileType) {
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
        document.querySelector('.drop-zone').addEventListener('dragenter', function (event) {
            event.preventDefault();
        });
        document.querySelector('.drop-zone').addEventListener('dragover', function (event) {
            event.preventDefault();
        });
        document.querySelector('.drop-zone').addEventListener('drop', function (event) {
            event.preventDefault();
            var files = event.dataTransfer.files;
            var file = files[0];
            var fileType = file.type;

            var formData = new FormData();
            formData.append('file', file);
            console.log(formData.getAll('file'));

            var url = 'http://localhost:8888/uploadImage';
            var method = 'POST';

            ajax(url, method, formData, fileType).then(function(result){
                consolt.log(result);
            });

        });  
    </script>

</body>
</html>