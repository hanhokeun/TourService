<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>
	.content {
		text-align: center;
		margin : 0 auto;
	}
</style>
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
<title>Insert title here</title>
<script>
// 회원가입 무결성 검사. 값이 있을경우 없을경우
function JoinForm(){
	var idData = document.getElementById("id").value; //로 사용가능
	var pwData = document.getElementById("pw").value; //로 사용가능
	var nameData = document.getElementById("name").value; //로 사용가능
	var birthData = document.getElementById("birth").value; //로 사용가능
	var emailData = document.getElementById("email").value; //로 사용가능
	var phoneData = document.getElementById("phone").value; //로 사용가능
	
	if(idData=="" || idData.length==0){
		alert("아이디를  입력해주세요");
		document.getElementById("user_id").focus();
		return; // 함수의 강제종료
	}
	if(pwData=="" || pwData.length==0 ){
		alert("비밀번호를 입력해주세요");
		document.getElementById("user_password").focus();
		return; // 함수의 강제종료
	}
	if(nameData=="" || nameData.length==0 ){
		alert("이름을 입력해주세요");
		document.getElementById("user_name").focus();
		return; // 함수의 강제종료
	}
	if(birthData=="" || birthData.length==0 ){
		alert("생년월일을 입력해주세요");
		document.getElementById("user_birth").focus();
		return; // 함수의 강제종료
	}
	if(emailData=="" || emailData.length==0 ){
		alert("이메일를 입력해주세요");
		document.getElementById("user_birth").focus();
		return; // 함수의 강제종료
	}
	if(phoneData=="" || phoneData.length==0 ){
		alert("전화번호를 입력해주세요");
		document.getElementById("user_phone").focus();
		return; // 함수의 강제종료
	}
	
		// 폼을 submit
		document.getElementById("jFrm").submit();
		
		
}
</script>
<jsp:include page="./../../Header.jsp"></jsp:include>
</head>
<body>
<div class="container">
<div class="content">		
		<p>주민번호 등록과 실명인증 없이 회원가입이 가능합니다.</p>
</div>
	<div class="col-lg-3"></div>
		<div class="jumbotron" style="padding-top:20px;">
		<div class="col-lg-10">	
			<form method="post" action="../Member/MemberJoinProc.han" id="jFrm">
			<h3 style="text-align:center;">회원가입 </h3>
			<div class="form-group">
				<label for="id">아이디:</label>
				<input type="text" class="form-control" placeholder="아이디" id="id" name="id" maxlength="10">
			</div>
			<div class="form-group">
				<label for="pw">비밀번호:</label>
				<input type="password" class="form-control" placeholder="비밀번호"  id="pw"  name="pw" maxlength="15">
			</div>
			<div class="form-group">
				<label for="name">이름:</label>
				<input type="text" class="form-control" placeholder="이름" id="name"  name="name" maxlength="15">
			</div>
			<div class="form-group">
				<label for="birth">생년월일:</label>
				<input type="text" class="form-control" placeholder="생년월일(XXXX-XX-XX)" id="birth"  name="birth" maxlength="15">
			</div>
			<div class="form-group">
				<label for="email">이메일:</label>
				<input type="email" class="form-control" placeholder="이메일" id="email" name="email" maxlength="30ㅇ">
			</div>
			<div class="form-group">
				<label for="phone">전화번호:</label>
				<input type="text" class="form-control" placeholder="전화번호(XXX-XXXX-XXXX)" id="phone" name="phone" maxlength="30">
			</div>
			<div class="form-group" style="text-align:center;">
			<div class="form_btn">
            <input type="button" class="btn btn-outline-primary"  onclick="JoinForm()" value="회원가입"  " /> 
            <input type="reset" class="btn btn-outline-primary"  value="다시작성" />
			</div>
			</div>
		</form>
		</div>
		<div class="col-lg-3"></div>
		</div>	
</div>

<jsp:include page="./../../Footer.jsp"></jsp:include>
</body>
</html>