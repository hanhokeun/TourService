<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/css?family=Sunflower:300" rel="stylesheet">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>로그인</title>
<script>
 
</script>
<style>
	body{
		font-family: 'Sunflower', sans-serif;
	}
</style>
</head>
<body>
 
	<%--
		이 화면에서는 
		1. 유저에게 삭제성공여부를  alert를 이용해서 알려준다
				-1이면 존재하지않는 아이디,	 0 이면 비밀번호가 잘못되었다고 alert창을 띄워준다
		2. 로그인폼으로 이동
	--%>
		<c:if test="${CHANGE eq 0}">
			<script>
				alert("비밀번호가 잘못되었습니다");
			</script>
		</c:if>
		<c:if test="${CHANGE eq -1}">
			<script>
				alert("존재하지않는 아이디입니다.");
			</script>
		</c:if>	
		
		<%-- 주의!!! ★★★
					redirect시키면 이전의 작업내용은 실행되지 않는다
		 --%>
		<script>
			location.href="../Member/LoginForm.han";
		</script> 
</body>
</html>