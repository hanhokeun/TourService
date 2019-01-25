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
<%--해당 여행이 삭제되었기 때문에 삭제된 여부를 알려준 뒤에 내여행리스트로 다시 넘겨준다 --%>
	<c:if test="${CHANGE eq 1}">
		<script>alert('내 여행 삭제가 완료되었습니다');</script>
	</c:if>
	<c:if test="${CHANGE eq 0}">
		<script>alert('내 여행 삭제가 실패했습니다');</script>
	</c:if>
	<script>
		location.href="../MyTour/myTourList.han?nowPage=${nowPage}&mNo=${MNO}";
	</script>
</body>
</html>