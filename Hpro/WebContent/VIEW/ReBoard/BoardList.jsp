<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/css?family=Sunflower:300" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
        wrap{
            width:530px;
            margin-left:auto; 
            margin-right:auto;
            text-align:center;
        }      
        body{
        	font-family: 'Sunflower', sans-serif;
        }
        th{
        	text-align:center;
        }
</style>
<title>리뷰게시판</title>
<script>
	function WriteForm(){
		location.href="../ReBoard/WriteForm.han";
	}
</script>
</head>

<body>
<jsp:include page="./../../Header.jsp"></jsp:include>

  <%-- 1.목록을 출력 --%>
 <div class="container"> 
	<h1 style="color:#737373; margin-left:20px;" align="center">여행 자유게시판</h1> 
 		<table class="table table-striped">
		  	<tr align="center">
		  		<th>번호</th>
		  		<th>글쓴이</th>
		  		<th> 제목</th>
		  		<th>조회수</th>
		  		<th>작성일</th>
		  		<th>댓글수</th>
		  	</tr>
		  	<c:forEach var="temp" items="${LIST}">
		  		<tr align="center">
		  			<td>${temp.no}</td>
		  			<td>${temp.writer}</td>
		  			<td><a href="../ReBoard/BoardDetail.han?oriNo=${temp.no}&nowPage=${PINFO.nowPage}">${temp.title}</a></td>
		  			<td>${temp.hit}</td>
		  			<td>${temp.wday}</td>
		  			<td>${temp.cnt}</td>
		  		</tr>
		  	</c:forEach>
		  </table>
  <%-- 2.페이지 이동 기능을 추가   [이전][1][2][3][다음]--%>
  <table class="table table-striped">
  	<tr>
  		<td align="center">
  		<%-- 이전링크만들기 --%>
  		<c:if test="${PINFO.startPage eq 1}">
  			[이전]
  		</c:if>
  		<c:if test="${PINFO.startPage ne 1}">
  			<%-- 링크는 다시 목록보기를 요청+ 원하는 페이지를 알려주면된다--%>
  			<a href="../ReBoard/BoardList.han?nowPage=${PINFO.startPage-1}">[이전]</a>
  		</c:if>
  		
  		<%-- [1][2][3] 링크만들기 --%>
  		<c:forEach var="page" begin="${PINFO.startPage}" 
  		                      end="${PINFO.endPage}">
			<a href="../ReBoard/BoardList.han?nowPage=${page}">[${page}]</a>
  		</c:forEach>
  		
  		<%-- [다음]링크만들기 --%>
  		<c:if test="${PINFO.endPage eq PINFO.totalPage}">
  			[다음]
  		</c:if>
  		<c:if test="${PINFO.endPage ne PINFO.totalPage}">
  			<a href="../ReBoard/BoardList.han?nowPage=${PINFO.endPage+1}">[다음]</a>
  		</c:if>
  		
  		</td>
  	</tr>	
  </table>
  <%-- 3.목록보기에서 필요한 다른 기능(글쓰기)을 처리하도록 한다 --%>	
  <c:if test="${GRADE ne 0}">
	  <table class="table table-striped">
	  	<tr>
	  		<td align="center">
	  			<input type="button" id="wbtn" value="글쓰기" onClick="WriteForm();"/>
	  		</td>
	  	</tr>
	  </table>	
 </c:if>
 </div>
 
<jsp:include page="./../../Footer.jsp"></jsp:include>
</body>
</html>
















