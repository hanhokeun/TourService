<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
<title>Insert title here</title>
</head>

  <script>
$(function(){
	$('.dBtn').click(function(){
		var conf = confirm('회원을 삭제하시겠습니까?');
		if(conf==false){
			return false;
		}
		var thistr = $(this).parents("tr");
		var tid = thistr.children(".tid");
		var id = tid.text();
		$('#uid').val(id);
		//location.href="../Member/MemberDelete.han?nowPage=${nowPage}&id=${temp.id}";
		$('#tempReFrm').submit();
	})
	
})
</script>
<body>
<jsp:include page="./../../Header.jsp"></jsp:include>
  <%-- 댓글삭제하기위한 임시폼을 만들어 놓는다 --%>
	<form id="tempReFrm" method="get" action="../Member/MemberDelete.han">
		<input type="hidden" name="nowPage"    value="${PINFO.nowPage}"/>
		<input type="hidden" name="uid" id="uid" value=""/>
	<!-- 	<input type="hidden" name="nowPage" id="tempRenowPage" /> -->
	</form>
	
	
	
	<div class="container">
  <%-- 1.목록을 출력 --%>
  <table border="1" width="600" align="center" class="table table-striped">
  	<tr>
  		<th>번호</th>
  		<th>이름</th>
  		<th>아이디</th>
  		<th>가입일</th>
  		<th>삭제</th>
  	</tr>
  	<c:forEach var="temp" items="${LIST}">  		
  		<tr>
  			<td>${temp.no}</td>
  			<td>${temp.name}</td>
  			<td class="tid">${temp.id}</td>
  			<td>${temp.bam}</td>
  			<td><input type="button" class="dBtn" name="id"value="삭제" /></td>
  		</tr>  		
  	</c:forEach>
  </table>
  
<%-- param="${temp.id} --%>
  
  <%-- 2.페이지 이동 기능을 추가   [이전][1][2][3][다음]--%>
  <table border="1" width="600" align="center" class="table table-striped">
  	<tr>
  		<td align="center">
  		<%-- 이전링크만들기 --%>
  		<c:if test="${PINFO.startPage eq 1}">
  			[이전]
  		</c:if>
  		<c:if test="${PINFO.startPage ne 1}">
  			<%-- 링크는 다시 목록보기를 요청+ 원하는 페이지를 알려주면된다--%>
  			<a href="../Member/MemberList.han?nowPage=${PINFO.startPage-1}">[이전]</a>
  		</c:if>
  		
  		<%-- [1][2][3] 링크만들기 --%>
  		<c:forEach var="page" begin="${PINFO.startPage}" 
  		                      end="${PINFO.endPage}">
			<a href="../Member/MemberList.han?nowPage=${page}">[${page}]</a>
  		</c:forEach>
  		
  		<%-- [다음]링크만들기 --%>
  		<c:if test="${PINFO.endPage eq PINFO.totalPage}">
  			[다음]
  		</c:if>
  		<c:if test="${PINFO.endPage ne PINFO.totalPage}">
  			<a href="../Member/MemberList.han?nowPage=${PINFO.endPage+1}">[다음]</a>
  		</c:if>
  		
  		</td>
  	</tr>	
  </table>	
  </div>  
  <jsp:include page="./../../Footer.jsp"></jsp:include>
</body>
</html>