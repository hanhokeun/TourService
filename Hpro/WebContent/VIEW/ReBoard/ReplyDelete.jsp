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
	<h1>ReplyDelete.jsp</h1>
	<%--
		삭제여부실행결과로 넘어오는 값이 
		0이면 실패
			"삭제가 실패되었습니다" 메세지 출력
		1이면 성공
			"삭제 성공!" 메세지 출력
			
		상세보기로~	
	 --%>
	 <c:if test="${CHANGE eq 0}">
		 <script>
		 	alert("삭제가 실패되었습니다");
		 </script>
	 </c:if>
	 
	  <c:if test="${CHANGE eq 1}">
		 <script>
		 	alert("삭제 성공");
		 </script>
	 </c:if>
	 
	 <script>
	 	location.href="../ReBoard/BoardDetail.han?oriNo=${oriNo}&nowPage=${nowPage}";
	 </script>
</body>
</html>








