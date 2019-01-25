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
<%--더이상 보여줄 것이 없으므로 여행지 페이지를 다시 보여주도록 한다 
	<c:redirect url="../MyTour/myPickForm.han?tNo=${TNO}">
	</c:redirect>--%>
	<c:if test="${CHANGE eq 1}">
		<script>alert('관광지가 등록되었으니 내여행 목록을 확인해보세요');</script>
	</c:if>
	<c:if test="${CHANGE eq 0}">
		<script>alert('이미 등록된 관광지입니다');</script>
	</c:if>
	<script>
		location.href="../MyTour/myPickForm.han?tNo=${TNO}&nowPage=${nowPage}&mNo=${MNO}";
		self.close();
	</script>
</body>
</html>