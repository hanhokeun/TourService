<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		$('#addList').click(function(){
			$(location).attr('href','../MyTour/myListAddForm.han?tNo=${TNO}&nowPage=${PINFO.nowPage}&mNo=${MNO}');
		})
		$('.stBtn').click(function(){
			var form = $(this).parents("form");
			$(form).submit();
		})
	})
</script>
<link href="https://fonts.googleapis.com/css?family=Sunflower:300" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
	body{
		font-family: 'Sunflower', sans-serif;
	}
</style>
</head>
<body>
<div class="container">
	<%--여행이름 리스트 보여주기 --%>
	<%--1.로그인이 되지 않은 경우 --%>
	<c:if test="${MNO eq 0}">
		<script>
			alert('로그인을 한 후에 이용해주세요')
			location.href="../Tour/TourInfo.han?tNo=${TNO}";
			self.close();
		</script>
	</c:if>
	<%--2.로그인이 된 경우 --%>
		<%--1) 여행지가 등록되지 않은 경우 --%>
	<c:if test="${MNO ne 0 && empty MyTour}">
			<table border="1" width="500" align="center">
				<tr>
					<th style="color:red;">등록된 여행리스트가 없습니다 추가해주세요</th>
				</tr>
				<tr>
					<td><input type="button" id="addList" value="새 여행만들기"/> 
				</tr>
			</table>
	</c:if>
		<%--2) 여행지가 등록된 경우 --%>
	<c:if test="${MNO ne 0 && not empty MyTour}">
		<form id="frm" method="post" action="../MyTour/myPickProc.han">
			<table width="500" align="center" class="table table-striped">
				<c:forEach var="temp"  items="${MyTour}">
					<input type="hidden" name="nowPage" value="${PINFO.nowPage}"/>
					<input type="hidden" name="mtName" value="${temp.name}"/>
					<input type="hidden" name="mtNo" value="${temp.no}"/>
					<input type="hidden" name="tNo" value="${TNO}"/>
					<input type="hidden" name="mNo" value="${MNO}"/>
					<tr>
							<td>${temp.name}</td>
							<th><input type="button"  class="stBtn"  value="저장하기"  param="${temp.no}"/></th>
					</tr>
				</c:forEach>
					<tr>
						<td align="center" colspan="2">
								<%--이전 링크 만들기 --%>
								<c:if test="${PINFO.startPage eq 1}">[이전]</c:if>
								<c:if test="${PINFO.startPage ne 1}">
									<%--링크는 다시 목록보기를 요청+원하는 페이지를 알려주면 됨 --%>
									<a href="../MyTour/myPickForm.han?nowPage=${PINFO.startPage-1}&tNo=${TNO}">[이전]</a></c:if>
								<%--[1][2][3]링크 만들기 표시될 페이지 개수는 PageUtil에서 설정 --%>
								<c:forEach var="page" begin="${PINFO.startPage}" end="${PINFO.endPage}">
									<a href="../MyTour/myPickForm.han?nowPage=${page}&tNo=${TNO}">[${page}]</a>
								</c:forEach>
								<%--다음 링크 만들기 --%>
								<c:if test="${PINFO.endPage eq PINFO.totalPage}">[다음]</c:if>
								<c:if test="${PINFO.endPage ne PINFO.totalPage}">
									<a href="../MyTour/myPickForm.han?nowPage=${PINFO.endPage+1}&tNo=${TNO}">[다음]</a></c:if>
						</td>
					</tr>
			</table>
			<table width="500" align="center" class="table table-striped">
					<tr>
						<td colspan="2" align="right"><input type="button" id="addList" value="새 여행 만들기"/> </td>
					</tr>
			</table>
		</form>
	</c:if>
</div>
</body>
</html>