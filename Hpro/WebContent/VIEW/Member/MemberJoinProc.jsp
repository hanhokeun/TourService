<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
		이 화면에서는 
		1. 유저에게 삭제성공여부를  alert를 이용해서 알려준다
				-1이면 존재하지않는 아이디,	 0 이면 비밀번호가 잘못되었다고 alert창을 띄워준다
		2. 로그인폼으로 이동
	--%>
		<c:if test="${OK eq 1}">
			<script>
				alert("회원가입이 성공적으로 되었습니다.");
				 location.href="../main.jsp";				
			</script>
		</c:if>
		<c:if test="${OK eq 0}">
			<script>
				alert("회원가입이 실패하였습니다.");
				/* location.href="../Member/MemberJoinForm.han"; */
				history.back();
			</script>
		</c:if>	
		
		<%-- 주의!!! ★★★
					redirect시키면 이전의 작업내용은 실행되지 않는다
		 --%>
		<script>
			/* location.href="../Member/LoginForm.han"; */
		</script>
 </body>
</html>