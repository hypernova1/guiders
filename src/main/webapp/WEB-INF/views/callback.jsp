<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>네이버 아이디로 로그인하셨습니다</title>
</head>
<body>

  <h2 style="text-align: center" id="name"></h2>
  <h4 style="text-align: center" id="email"></h4>
  
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
  $(document).ready(function() {
    var name = ${result}.response.name;
    var email = ${result}.response.email;
    var url = "${prevPage}";
    if(!url){
    	url = '/';
    }
    console.log(url);
    $("#name").html("환영합니다. "+name+"님");
    $("#email").html("E-mail 주소 : " + email);
    
    sessionStorage.setItem("naverName",${result}.response.name);
    
    setTimeout("location.href = '" +url +"'", 1000);
    });
</script>
</body>
</html>