 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>내 여행 상세보기</title>
<link href="https://fonts.googleapis.com/css?family=Sunflower:300" rel="stylesheet">
<link rel="stylesheet" href="../../css/bootstrap.min.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<jsp:include page="./../../Header.jsp"></jsp:include>
<style>
	body{
		font-family: 'Sunflower', sans-serif;
	}
</style>
<script src="../js/jquery-3.3.1.min.js"></script>
<script>
	$(function(){
		//여행리스트로 돌아가기
		$('#beforeBtn').click(function(){
			$(location).attr('href','../MyTour/myTourList.han?nowPage=${nowPage}&mNo=${MNO}');
		});
		
		//수정하기
		$('#nameBtn').click(function(){
			var winObj=window.open('../MyTour/myTourModifyForm.han?np=${PINFO.nowPage}&mNo=${MNO}&mtNo=${VO.mtNo}&nowPage=${nowPage}','aa','width=1000, height=500');
		});
		//날짜보여주기
		$('#dateBtn').click(function(){
			$(location).attr('href','#')
		});
		//상세날짜 수정
		$('.detailBtn').click(function(){
			//오프너로 폼 보내기
			var tdNo=$(this).attr('param');
			var winObj=window.open("../MyTour/myDetailModifyForm.han?np=${PINFO.nowPage}&mNo=${MNO}&tdNo="+tdNo+"&mtNo=${VO.mtNo}&nowPage=${nowPage}",'bb','width=1000, height=500');
		});
		//상세일정 삭제
		$('.delBtn').click(function(){
			var tdNo=$(this).attr('param');
			$('#tempNowPage').val("${nowPage}");
			$('#tempTdNo').val(tdNo);
			$('#tempMNo').val("${MNO}");
			$('#tempMtNo').val("${VO.mtNo}");
			$('#tempNp').val("${PINFO.nowPage}");
			$('#tempTdFrm').submit();
		});
		
	})
</script>
</head>
<body>
<div class="container">
	<h1 align="center">${VO.name}</h1>
	<hr>
	<table width="800" class="table table-condensed">
		<tr>
			<td align="left" colspan="2"><button type="button" class="btn btn-default" id="beforeBtn" name="beforeBtn">←내 여행으로 돌아가기</button></td>
			<td align="right"><button type="button" class="btn btn-default" id="nameBtn" name="nameBtn">내 여행정보 수정하기</button></td>
		</tr>
		<tr>
			<td align="left" colspan="3"><button type="button" class="btn btn-primary disabled" id="dateBtn" name="dateBtn">${VO.start}부터 ${VO.end}까지의 일정</button></td>
		</tr>
	</table>
	<form id="detailFrm" name="detailFrm" method="POST">
		<input type="hidden" name="nowPage" id="nowPage" value="${nowPage}"/>
		<input type="hidden"  name="np" id="np" value="${PINFO.nowPage}"/>
		<input type="hidden"  name="mNo" id="mNo" value="${MNO}"/>
		<input type="hidden"  name="mtNo" id="mtNo" value="${VO.mtNo}"/>
		<input type="hidden"  name="tdNo" id="tdNo" value="${VO.tdNo}"/>
		<table width="800" class="table table-hover">
				<c:forEach var="temp" items="${LIST}">
					<tr>
						<td rowspan="2" align="center"><img src="../Sampleimg/${temp.img1}" width="200px" height="150px"/></td>
						<td align="center" style="font-size:12pt"><a href="../Tour/TourInfo.han?tNo=${temp.no}">${temp.name}</a></td>							
						<td align="center">${temp.area}</td>
						<td colspan="2" align="center" style="font-size:10pt; font-color:#6691ff;">상세일정</td>
						<td align="right"><button type="button" class="delBtn" param="${temp.tdNo}" width="50">여행 삭제하기</button>
						</td>
					</tr>
					<tr>
						<td align="center">${temp.theme1}</td>
						<td align="center">${temp.address}</td>
						<td align="center">시작날짜:${temp.start}</td>
						<td align="center">종료날짜:${temp.end}</td>
						<td colspan="2" align="right"><button type="button" class="detailBtn" param ="${temp.tdNo}">일정 수정하기</button></td>
					</tr>
				</c:forEach>
		</table>
	</form>
	<table width="800" class="table table-hover">
			<tr>
				<td align="center" colspan="6">
					<%--이전 링크 만들기 --%>
					<c:if test="${PINFO.startPage eq 1}">[이전]</c:if>
					<c:if test="${PINFO.startPage ne 1}">
						<%--링크는 다시 목록보기를 요청+원하는 페이지를 알려주면 됨 --%>
						<a href="../MyTour/myTourDetail.han?np=${PINFO.startPage-1}&mNo=${MNO}&mtNo=${VO.no}&nowPage=${nowPage}">[이전]</a></c:if>
					<%--[1][2][3]링크 만들기 표시될 페이지 개수는 PageUtil에서 설정 --%>
					<c:forEach var="page" begin="${PINFO.startPage}" end="${PINFO.endPage}">
						<a href="../MyTour/myTourDetail.han?np=${page}&mNo=${MNO}&mtNo=${VO.no}&nowPage=${nowPage}">[${page}]</a>
					</c:forEach>
					<%--다음 링크 만들기 --%>
					<c:if test="${PINFO.endPage eq PINFO.totalPage}">[다음]</c:if>
					<c:if test="${PINFO.endPage ne PINFO.totalPage}">
						<a href="../MyTour/myTourDetail.han?np=${PINFO.endPage+1}&mNo=${MNO}&mtNo=${VO.no}&nowPage=${nowPage}">[다음]</a>
					</c:if>
				</td>
			</tr>
	</table>
</div>
<%--여행지 삭제를 위한 임시 폼을 만들어 놓는다 --%>
	<form id="tempTdFrm" name="tempTdFrm" method="post" action="../MyTour/myDetailDelete.han">
		<input type="hidden" name="nowPage" id="tempNowPage"/>
		<input type="hidden" name="tdNo" id="tempTdNo" />
		<input type="hidden" name="mNo" id="tempMNo"/>
		<input type="hidden" name="mtNo" id="tempMtNo"/>
		<input type="hidden" name="np" id="tempNp"/>
	</form>
<jsp:include page="./../../Footer.jsp"></jsp:include>
</body>
</html>