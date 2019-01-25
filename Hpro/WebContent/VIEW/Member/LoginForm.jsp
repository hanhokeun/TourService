<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<style>
	.content {
		text-align: center;
		margin : 0 auto;
	}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/css?family=Sunflower:300" rel="stylesheet">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<script>
function LoginProc(){
	var idData = document.getElementById("id").value; //로 사용가능
	var pwData = document.getElementById("pw").value; //로 사용가능
	//alert(idData+"  /   "+pwData);
	
	if(idData=="" || idData.length==0){
		alert("아이디를  입력해주세요");
		document.getElementById("id").focus();
		return; // 함수의 강제종료
	}
	if(pwData=="" || pwData.length==0 ){
		alert("비밀번호를 입력해주세요");
		document.getElementById("pw").focus();
		return; // 함수의 강제종료
		
	}
	
	// 폼을 submit
	document.getElementById("lFrm").submit();				
}
</script>
<style>
	body{
		font-family: 'Sunflower', sans-serif;
	}
</style>
</head>
<body>
</br></br></br>

<div class="content">	
	<div class="login_content">		
		<p>주민번호 등록과 실명인증 없이 회원가입이 가능합니다.</p>
	</div>
</div>
</br>
<div class="container">	
	<div class="col-lg-4"></div>
		<div class="col-lg-4">
			<div class="jumbotron" style="padding-top:20px;">
			<form method="post" action="../Member/LoginProc.han" id="lFrm">
			<h3 style="text-align:center;">로그인 화면</h3>
				<div class="form-group">
				<label for="id">아이디:</label>
					<input type="text" class="form-control" placeholder="아이디" name="id"  id="id"  maxlength="20">
				</div>
					<div class="form-group">
					<label for="pw">비밀번호:</label>
						<input type="password" class="form-control" placeholder="비밀번호" name="pw"   id="pw"   maxlength="20">
					</div>
						<input type="button"  class="btn btn-primary form-control"  id ="lbtn" onClick="LoginProc()" value="로그인" >
			</form>
			</div>
		</div>
		<div class="col-lg-4"></div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script> 
<jsp:include page="./../../Footer.jsp"></jsp:include>
</body>
</html>