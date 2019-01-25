<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		$('#aList').click(function(){
			if($('#title').val()==""){
				alert('여행이름을 입력해주세요');
				$('#title').focus();
				return;
			}
		$('#tFrm').submit();
		});
	});
</script>
<link href="https://fonts.googleapis.com/css?family=Sunflower:300" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
	body{
		font-family: 'Sunflower', sans-serif;
		font-size: 18pt;
	}
</style>
</head>
<body>
<div class="container">
	<h1 style="color:#84a3e1;" align="center">여행 만들기</h1>
	<form id="tFrm" method="POST" action="../MyTour/myListAddProc.han" > 
		<c:if test="${empty STRTNO}">
			<input type="hidden"  name="nowPage" id="nowPage" value="${nowPage}"/>
			<input type="hidden"  name="mNo" id="mNo" value="${MNO}"/>
		</c:if>
		<c:if test="${not empty STRTNO}">
			<input type="hidden"  name="tNo" id="tNo" value="${TNO}"/>
			<input type="hidden"  name="nowPage" id="nowPage" value="${nowPage}"/>
			<input type="hidden"  name="mNo" id="mNo" value="${MNO}"/>
		</c:if>
		<table width="450" class="table table-striped" >
			<tr>
				<td align="center" style="padding: 10px;">여행 이름</td>
			</tr>
			<tr align="center">
				<td><textarea name="title" id="title" placeholder="여행 이름을 설정해주세요" style="resize:none; width:200px;"></textarea></td>
			</tr>
			<tr>
				<td align="right"><input type="button" name="aList" id="aList" value="여행 만들기"/></td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>