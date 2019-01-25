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
	<h1>ReplyModify.jsp문서</h1>
	<%--
			수정이 완료되었으므로 보여줄건 없고.. 대신 수정내용을 확인하기위해 상세보기로 가겠다
	--%>
		<c:redirect url="../ReBoard/BoardDetail.han">
			<c:param name="oriNo"  		value="${oriNo}" />
			<c:param name="nowPage"		value="${nowPage}" />
		</c:redirect> 
</body>
</html>