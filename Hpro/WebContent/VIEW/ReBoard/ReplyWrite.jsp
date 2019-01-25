<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Insert title here</title>
</head>
<body>
	<%--	이 문서는 댓글 등록을 한 후
	          상세보기를 보여줌으로써 댓글이 등록된 결과를 확인하도록..
	--%>
	<c:redirect url="../ReBoard/BoardDetail.han">
		<c:param name="oriNo" value="${oriNo}" />
		<c:param name="nowPage" value="${nowPage}" />
	</c:redirect>
</body>
</html>