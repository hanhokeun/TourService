<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        
</style>
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		//수정하기 버튼 클릭시
		$("#mBtn").click(function(){
			//여러분이 무결성 검사하시고...
			$("#mFrm").submit();
		});
	});	
</script>
</head>
<body>
<div class="container">
		<form id="mFrm" method="POST" action="../ReBoard/ModifyProc.han">
		  <%--	폼을 이용해서 submit시킬때는 폼안에 없는 데이터는 서버에 전달되지x
		  			같이 보내야할 필요한 데이터가 있면 <input type="hidden"으로 숨겨서 보내야한다
		   --%>
			<input type="hidden" name="nowPage" value="${nowPage}"/>
			<input type="hidden" name="oriNo"   value="${BOARD.no}"/>
		<table class="table table-striped">
			<tr>
				<th>글제목</th>
				<td>
					<input class="form-control" type="text" name="title" id="title" value="${BOARD.title}"/>
				</td>
			</tr>
			<tr>
				<th>글내용</th>
				<td>
					<textarea class="form-control" name="body" id="body">${BOARD.body}</textarea>
				</td>
			</tr>
			<!-- <tr>
				<th>비밀번호</th>
				<td>
				주의!!! 비밀번호는 절대로 출력하면 x. value속성을 사용하지x
					<input class="form-control" type="password" name="pw" id="pw" placeholder="Enter password"/>
				</td>
			</tr> -->
			<tr>
				<th colspan="2">
					<input type="button" id="mBtn" value="수정하기"/>
				</th>
			</tr>
		</table>
	</form>
 </div>
</body>
</html>







