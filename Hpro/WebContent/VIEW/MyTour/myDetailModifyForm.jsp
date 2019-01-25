<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		font-size: 18pt;
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
	<h1 style="color:blue;" align="center">${VO.name}의 일정 수정하기</h1>
	<form id="datepicker" name="datepicker" action="../MyTour/myDetailModifyProc.han">
			<input type="hidden"  name="np" id="np" value="${NP}"/>
			<input type="hidden"  name="mNo" id="mNo" value="${MNO}"/>
			<input type="hidden"  name="mtNo" id="mtNo" value="${MTNO}"/>
			<input type="hidden"  name="tdNo" id="tdNo" value="${VO.tdNo}"/>
		<table class="table table-striped" width="350">
				<tr align="center">
					<td><label for="startDate">시작날짜:</label>
					<input type="text"  id="startDate" name="startDate" value="${VO.start}"/></td>
					<td><label for="endDate">종료날짜:</label>
					<input type="text"  id="endDate" name="endDate" value="${VO.end}"/></td>
				</tr>
				<tr align="center">
					<td colspan="2" align="right"><input type="button"  id="submitBtn" value="날짜  수정하기"/> </td>
				</tr>
		</table>
	</form>
</div>
</body>
</html>