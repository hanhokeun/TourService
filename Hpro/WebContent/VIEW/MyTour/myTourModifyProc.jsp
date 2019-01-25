<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/jquery-ui.structure.min.css"/>
<link rel="stylesheet" href="../css/jquery-ui.theme.min.css"/>
<link rel="stylesheet" href="../css/jquery-ui.min.css"/> 
<script src="../js/jquery-3.3.1.min.js"></script>
<script src="../js/jquery-ui.min.js"></script>
</head>
<body>
		<c:if test="${CHANGE eq 1}">
			<script>
				alert('내 여행 정보가 수정되었습니다');
			</script>
		</c:if>
		<c:if test="${CHANGE eq 0}">
			<script>alert('내 여행 정보 수정이 실패했습니다');</script>
		</c:if>
	<script>
		opener.location.href="../MyTour/myTourDetail.han?mtNo=${MTNO}&np=${NP}&mNo=${MNO}";
		self.close();
	</script>
</body>
</html>