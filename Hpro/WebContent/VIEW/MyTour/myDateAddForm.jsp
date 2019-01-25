<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>myDateAddForm.jsp</title>
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
<link rel="stylesheet" href="../css/jquery-ui.structure.min.css"/>
<link rel="stylesheet" href="../css/jquery-ui.theme.min.css"/>
<link rel="stylesheet" href="../css/jquery-ui.min.css"/> 
<script src="../js/jquery-3.3.1.min.js"></script>
<script src="../js/jquery-ui.min.js"></script>
<script>
$( function(){
	    $( "#startDate" ).datepicker({
	    	dateFormat:"yy-mm-dd",
	    	showMonthAfterYear: true ,
	    	changeMonth: true,
	    	changeYear: true,
	    	dayNamesMin: ['월', '화', '수', '목', '금', '토', '일'],
	    	monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
	    });
	    $( "#endDate" ).datepicker({
	    	dateFormat:"yy-mm-dd",
	    	showMonthAfterYear: true ,
	    	changeMonth: true,
		    changeYear: true,
		    dayNamesMin: ['월', '화', '수', '목', '금', '토', '일'],
		    monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
		    });
	    $('#submitBtn').click(function(){
	    	if($('#startDate').val()==""){
	    		alert('시작일자를 입력해주세요');
	    		$('#startDate').focus();
	    		return;
	    	}
	    	if($('#endDate').val()==""){
	    		alert('종료일자를 입력해주세요');
	    		$('#endDate').focus();
	    		return;
	    	}
	    	$('#datepicker').submit();
	    });
});
</script>
</head>
<body>
<div class="container">
	<h1 style="color:#84a3e1;" align="center">이 여행에 날짜 추가하기</h1>
	<form id="datepicker" name="datepicker" action="../MyTour/myDateAddProc.han" autocomplete="off">
		<c:if test="${empty STRTNO}">
			<input type="hidden"  name="nowPage" id="nowPage" value="${nowPage}"/>
			<input type="hidden"  name="mNo" id="mNo" value="${MNO}"/>
			<input type="hidden"  name="title" id="title" value="${TITLE}"/>
		</c:if>
		<c:if test="${not empty STRTNO}">
			<input type="hidden"  name="tNo" id="tNo" value="${TNO}"/>
			<input type="hidden"  name="nowPage" id="nowPage" value="${nowPage}"/>
			<input type="hidden"  name="mNo" id="mNo" value="${MNO}"/>
			<input type="hidden"  name="title" id="title" value="${TITLE}"/>
		</c:if>
		<table width="500" align="center" class="table table-striped">
				<tr align="center">
					<td colspan="2">여행의 날짜를 추가하고 여행 일정을 만드세요</td>
				</tr>
				<tr align="center">
					<td><label for="startDate">시작날짜:</label>
					<input type="text"  id="startDate" name="startDate" /></td>
					<td><label for="endDate">종료날짜:</label>
					<input type="text"  id="endDate" name="endDate" /></td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input type="button"  id="submitBtn" value="날짜 추가하기"/> </td>
				</tr>
		</table>
	</form>
</div>
</body>
</html>