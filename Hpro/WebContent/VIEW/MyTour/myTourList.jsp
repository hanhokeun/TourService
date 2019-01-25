<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>�� ���� ��Ϻ���</title>
<script src="../js/jquery-3.3.1.min.js"></script>
<script>
	$(function(){
		$('#addBtn').click(function(){
			//$(location).attr('href','../MyTour/myListAddForm.han?nowPage=${PINFO.nowPage}&mNo=${MNO}')	;	
			var winObj=window.open('../MyTour/myListAddForm.han?nowPage=${PINFO.nowPage}&mNo=${MNO}','TourAdd','width=700, height=500');
		})
	})
</script>
<link href="https://fonts.googleapis.com/css?family=Sunflower:300" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<jsp:include page="./../../Header.jsp"></jsp:include>
<style>
	body{
		font-family: 'Sunflower', sans-serif;
	}
</style>
</head>
<body>
<div class="container">
	<h1 align="center" >�� ���� ��Ϻ���</h1>
	<hr>
	<table class="table table-condensed" align="center" width="700">
		<tr>
			<td align="center">���� �����</td>
			<td colspan="3" align="right"><button type="button" id="addBtn" name="addBtn" class="btn btn-default">�߰��ϱ�</button></td>
		</tr>
		<c:forEach var="temp2" items="${LIST1}">
				<tr>
					<td width="100" align="center" style="font-size:15pt;">
						<a href="../MyTour/myTourDetail.han?mtNo=${temp2.no}&nowPage=${PINFO.nowPage}&mNo=${MNO}">${temp2.name}</a>
					</td>
					<td width="150" align="center">
						${temp2.start} ����<br/>
						${temp2.end} ����
					</td>
					<td width="500" align="center">
						<c:forEach var="temp3" items="${LIST2}">
							<c:if test="${temp2.no eq temp3.mtNo}">
								<img src="../Sampleimg/${temp3.img1}" width="200px" height="150px" />
							</c:if> 
						</c:forEach>
					</td>
					<td width="50" align="center" class="text-muted">
						<c:forEach var="temp1" items="${TOTALCOUNT}">
							<c:if test="${temp2.no eq temp1.mtNo}">
								${temp1.count}��<br/>
								������
							</c:if> 
						</c:forEach>
					</td>
				</tr>
		</c:forEach>
		<tr>
		<td align="center" colspan="4">
			<%--���� ��ũ ����� --%>
			<c:if test="${PINFO.startPage eq 1}">[����]</c:if>
			<c:if test="${PINFO.startPage ne 1}">
				<%--��ũ�� �ٽ� ��Ϻ��⸦ ��û+���ϴ� �������� �˷��ָ� �� --%>
				<a href="../MyTour/myTourList.han?nowPage=${PINFO.startPage-1}">[����]</a></c:if>
			<%--[1][2][3]��ũ ����� ǥ�õ� ������ ������ PageUtil���� ���� --%>
			<c:forEach var="page" begin="${PINFO.startPage}" end="${PINFO.endPage}">
				<a href="../MyTour/myTourList.han?nowPage=${page}&mNo=${MNO}">[${page}]</a>
			</c:forEach>
			<%--���� ��ũ ����� --%>
			<c:if test="${PINFO.endPage eq PINFO.totalPage}">[����]</c:if>
			<c:if test="${PINFO.endPage ne PINFO.totalPage}">
				<a href="../MyTour/myTourList.han?nowPage=${PINFO.endPage+1}&mNo=${MNO}">[����]</a>
			</c:if>
			</td>
		</tr>
	</table>
</div>
<jsp:include page="./../../Footer.jsp"></jsp:include>
</body>
</html>