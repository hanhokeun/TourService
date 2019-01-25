
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
	<c:redirect url="../MyTour/myDateAddForm.han">
		<c:if test="${empty STRTNO}">
				<c:param name="nowPage" value="${nowPage}"/>
				<c:param name="mNo" value="${MNO}"/>
				<c:param name="title" value="${TITLE}"/>
			
		</c:if>
		<c:if test="${not empty STRTNO}">
					<c:param name="nowPage" value="${nowPage}"/>
					<c:param name="mNo" value="${MNO}"/>
					<c:param name="tNo" value="${TNO}"/>
					<c:param name="title" value="${TITLE}"/>
		</c:if>
	</c:redirect> 
</body>
</html>