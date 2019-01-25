<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css?family=Sunflower:300" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
	body{
		font-family: 'Sunflower', sans-serif;
	}
</style>
<link rel="stylesheet" href="../css/jquery-ui.structure.min.css"/>
<link rel="stylesheet" href="../css/jquery-ui.theme.min.css"/>
<link rel="stylesheet" href="../css/jquery-ui.min.css"/> 
<script src="../js/jquery-3.3.1.min.js"></script>
<script src="../js/jquery-ui.min.js"></script>
<script>
$( function() {
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
	    
	    //수정하기
	    $('#eList').click(function(){
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
	    	$('#eFrm').submit();
	    	
	    });
	    //삭제하기
	    $('#deleteBtn').click(function(){
	    	$(opener.location).attr('href','../MyTour/myTourDelete.han?np=${NP}&mNo=${MNO}&mtNo=${VO.mtNo}&nowPage=${nowPage}');
	    	self.close();
	    });
})
</script>
</head>
<body>
<div class="container">
	<h1 align="center" style="color:#84a3e1;">내 여행 수정하기</h1>
	<form id="eFrm" method="POST" action="../MyTour/myTourModifyProc.han" > 
		<input type="hidden" name="nowPage" id="nowPage" value="${nowPage}"/>
		<input type="hidden"  name="np" id="np" value="${NP}"/>
		<input type="hidden"  name="mtNo" id="mtNo" value="${VO.mtNo}"/>
		<input type="hidden"  name="mNo" id="mNo" value="${MNO}"/>
		<table width="350"  class="table table-striped">
			<tr align="center">
				<td colspan="2">여행 이름</td>
			</tr>
			<tr align="center">
				<td colspan="2"><textarea name="title" id="title" style="resize:none; width:200px;" placeholder="${VO.name}"></textarea></td>
			</tr>
			<tr align="center">
				<td><label for="startDate">시작날짜:</label>
				<input type="text"  id="startDate" name="startDate" value="${VO.start}"/></td>
				<td><label for="endDate">종료날짜:</label>
				<input type="text"  id="endDate" name="endDate" value="${VO.end}" /></td>
			</tr>
			<tr>
				<td align="right" colspan="2">
					<input type="button" name="deleteBtn" id="deleteBtn" value="해당 여행 삭제하기"/>
					<input type="button" name="eList" id="eList" value="내여행 수정하기"/>
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>