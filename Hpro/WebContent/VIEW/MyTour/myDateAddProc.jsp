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
	<c:if test="${empty STRTNO}">
		<script>
			location.href="../MyTour/myTourList.han?nowPage=${nowPage}&mNo=${MNO}&title=${TITLE}";
			self.close();
		</script>
	</c:if>
	<c:if test="${not empty STRTNO}">
		<script>
			location.href="../MyTour/myPickProc.han?tNo=${TNO}&title=${TITLE}&nowPage=${nowPage}&mNo=${MNO}";
		</script>
	</c:if>
	<%-- <c:redirect url="../MyTour/myPickForm.han">
			<c:param name="nowPage" value="${nowPage}"/>
			<c:param name="mNo" value="${MNO}"/>
			<c:param name="title" value="${TITLE}"/>
		</c:redirect>
		<c:redirect url="../MyTour/myTourList.han">
			<c:param name="nowPage" value="${nowPage}"/>
			<c:param name="tNo" value="${TNO}"/>
			<c:param name="mNo" value="${MNO}"/>
			<c:param name="title" value="${TITLE}"/>
		</c:redirect>
	<script>
		location.href="../MyTour/myPickForm.han?tNo=${TNO}&nowPage=${nowPage}&mNo=${MNO}";
		self.close();
	</script>--%>
</body>
</html>