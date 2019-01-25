<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
				1이면 삭제성공,	0이면 삭제X
		2. 목록보기로 이동
	--%>
		<c:if test="${DELETE eq 1}">
			<script>
				alert("회원이 추방 되었습니다");				
			</script>
		</c:if>
		<c:if test="${DELETE eq 0}">
			<script>
				alert("회원이 추방되지 않았습니다");				
			</script>
		</c:if>	
		
		<%-- 주의!!! ★★★
					redirect시키면 이전의 작업내용은 실행되지 않는다
		 --%>
		<script>
			location.href="../Member/MemberList.han";
		</script> 
</body>
</html>