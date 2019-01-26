<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<meta charset="utf-8" />
<title>Page Title</title>
<style>
*, *::after, *::before {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

form {
	text-align: center;
	margin-top: 2%;
}

#login-body {
	border: 1px solid #95a5a6;
	width: 420px;
	height: 370px;
	text-align: center;
	border-radius: 4px;
	box-shadow: 1px 1px 3px;
	margin: auto;
	margin-top: 50px;
}

#msg {
	text-align: center;
	font-size: 1.5rem;
}

#login-body>div:nth-child(1) {
	margin: 50px 0 50px;
}

button {
	margin-bottom: 30px;
	all: unset;
	border: 1px solid white;
	background: #ff2d55;
	color: white;
	padding: 10px 15px;
	border-radius: 4px;
	font-weight: bold;
	cursor: pointer;
}

#login-body>div>div {
	margin: 30px 0;
}

#login-body input {
	all: unset;
	padding: 0 5px;
	width: 250px;
	height: 40px;
	border: 1px solid #95a5a6;
	border-radius: 4px;
	text-align: left;
}

#login-body label {
	display: block;
	font-size: 1.2rem;
	font-weight: bold;
	margin-bottom: 10px;
}

#logo {
	width: 100px;
	height: 35px;
	margin: 20px;
	user-select: none;
}
</style>
</head>
<body>
	<img src="/img/logo.png" id="logo">
	<form>
		<h1 id="msg">권한이 없습니다. 로그인 해주세요.</h1>
		<div id="login-body">
			<div>
				<div id="email">
					<label>아이디</label> <input type="text" name="email">
				</div>
				<div id="password">
					<label>비밀번호</label> <input type="password" name="password">
				</div>
			</div>
			<button type="button" onclick="signin()">로그인</button>
		</div>
	</form>

	<script>
		function signin() {
			$.ajax({
				url : '/login',
				data : $('form input').serialize(),
				type : 'POST',
				dataType : 'json',
				beforeSend : function(xhr) {
					xhr.setRequestHeader("Accept", "application/json");
					/* xhr.setRequestHeader('x-CSRFToken', '${_csrf.token}'); */
				}
			}).done(function(result) {
				var error = result.error;
				var url = result.url;
				if (error) {
					console.log("error : " + error)
				}
				if (error == false) {
					if (url == '') {
						url = '<c:url value="/" />';
					}
					console.log(url);
					location.href = url;
				}
			});
		}
		
  	if('${pageContext.request.userPrincipal}'){
			alert('이미 로그인 되어 있습니다.');
			history.back();
		}
	</script>
</body>
</html>