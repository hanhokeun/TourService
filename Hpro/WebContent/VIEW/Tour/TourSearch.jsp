<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel="stylesheet"
href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<script src="../js/jquery-3.3.1.min.js"></script>
<script>
$(function(){
	$('#rsBtn').click(function(){
		$('#lName').val(0)
	})
	$('#sBtn').click(function(){
		var theme = $('[name="theme"]:checked').val()
		var area = $('select > option:selected').val()
		if(theme==null&&area=="0"){//
			alert('조건을 설정해주세요!')
			return false;
		}
		else{
		$("#sFrm").attr("action","../Tour/TourSearchProc.han?theme="+theme+"&area="+area);
		$('#sFrm').submit();
		}
	})
	$('#taBtn').click(function(){
		location.href="../Tour/TourAdd.han";
	})
})
</script>
<jsp:include page="../../Header.jsp"></jsp:include>
</head>
<body>
	<header></header>
	<h1 align="center" id="intro">관광데이터 검색</h1><br/>
	
<div class="container">
<form id="sFrm" method="get">	
<!-- <table border="1" align=center  width="650px" id="search"> -->
<table class="table table-striped">
	<tr>
		<th class="opt">테마</th>
		<td class="opbody">
			<input type="radio" class="theme" name="theme" value="자연"/>자연
			<input type="radio" class="theme" name="theme" value="문화/예술/역사"/>문화/예술/역사
			<input type="radio" class="theme" name="theme" value="레포츠"/>레포츠
		</td>
	</tr>
	<tr>
		<th class="opt">지역</th>
		<td class="opbody">
			<select id="lName" name="lName">
				<option value="0" selected>--선택하세요--</option>
				<option value="서울">서울</option>
				<option value="인천">인천</option>
				<option value="광주">광주</option>
				<option value="대전">대전</option>
				<option value="대구">대구</option>
				<option value="울산">울산</option>
				<option value="부산">부산</option>
				<option value="경기도">경기도</option>
				<option value="강원도">강원도</option>
				<option value="충청북도">충청북도</option>
				<option value="충청남도">충청남도</option>
				<option value="전라북도">전라북도</option>
				<option value="전라남도">전라남도</option>
				<option value="경상북도">경상북도</option>
				<option value="경상남도">경상남도</option>
				<option value="제주">제주</option>
			</select>
		</td>
	</tr>
	<tr align="center">
		<th colspan="2">
			<input type="button" class="btn btn-primary" id="sBtn" value="검색"/>
			<input type="reset" class="btn btn-secondary" id="rsBtn" value="초기화"/>
	<c:if test="${GRADE eq 9}">
      	<div class="admin" id="aBtn" align="right">
         	<input type="button" id="taBtn" value="관광지 추가 " class="btn btn-warning"/>
      	</div>
   </c:if>
			
		</th>
	</tr>
</table>
<br/><br/>
</form>
</div>
<%-- 관광지 띄우기--%>
<!-- <div class="container" align="center"> -->
<div class="row">
		<c:forEach var="tlist" items="${INFO}">
			<div class="col-md-3" style="margin-bottom:40px">
			<a href="../Tour/TourInfo.han?nowPage=${PINFO.nowPage}&tNo=${tlist.no}"><img src="../Sampleimg/${tlist.img1}" width="350px" height="150px"></a><br/>		
				<a href="../Tour/TourInfo.han?nowPage=${PINFO.nowPage}&tNo=${tlist.no}">${tlist.name}</a><br/>
						테마 :${tlist.theme1} 지역:${tlist.area} 조회수 :${tlist.cnt}
			</div>			
		</c:forEach>
</div>
<!-- <table border="1" width="94%" align="center" style="background-color:;"> -->
</br></br>
</br></br>
<table class="table">
		<tr>
			<td align="center">
			<%-- 이전 링크 만들기 --%>
			<c:if test="${PINFO.startPage eq 1}">
				[이전]
			</c:if>
			<c:if test="${PINFO.startPage ne 1}">
				<a href="../Tour/TourSearch.han?nowPage=${PINFO.startPage-1}">[이전]</a>
			</c:if>
			<%-- [1][2][3]링크만들기 --%>
			<c:forEach var="page" begin="${PINFO.startPage}" end="${PINFO.endPage}">
				<a href="../Tour/TourSearch.han?nowPage=${page}">[${page}]</a>
			</c:forEach>	
			<%-- 다음 링크 만들기 --%>
			<c:if test="${PINFO.endPage eq PINFO.totalPage}">
				[다음]
			</c:if>
			<c:if test="${PINFO.endPage ne PINFO.totalPage}">
				<a href="../Tour/TourSearch.han?nowPage=${PINFO.endPage+1}">[다음]</a>
			</c:if>
			</td>		
		</tr>
	</table>
	
</body>
</html>