<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Insert title here</title>
</head>
<body>
	<%--	�� ������ ��� ����� �� ��
	          �󼼺��⸦ ���������ν� ����� ��ϵ� ����� Ȯ���ϵ���..
	--%>
	<c:redirect url="../ReBoard/BoardDetail.han">
		<c:param name="oriNo" value="${oriNo}" />
		<c:param name="nowPage" value="${nowPage}" />
	</c:redirect>
</body>
</html>