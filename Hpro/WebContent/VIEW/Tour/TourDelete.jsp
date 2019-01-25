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
	<%-- 삭제 성공여부를 alert로 알려줄것 
		1.	1이면 삭제성공 0 이면 실패
		2.	관광지 검색창으로 이동 
	--%>
	
	<c:if test="${CHANGE eq 1}">
		<script>alert('정상적으로 삭제되었습니다!')</script>
	</c:if>	
	<c:if test="${CHANGE eq 0}">
		<script>alert('삭제에 실패했습니다!')</script>
	</c:if>
	 <%-- 주의!!! ★★★
	 	redirect시키면 이전의 작업내용은 실행되지 않는다
	  --%>	
	<script>
		location.href="../Tour/TourSearch.han"
	</script>	
	
</body>
</html>