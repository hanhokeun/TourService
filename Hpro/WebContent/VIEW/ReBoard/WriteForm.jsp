<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/css?family=Sunflower:300" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<jsp:include page="./../../Header.jsp"></jsp:include>
<style>
        #wrap{
            width:530px;
            margin-left:auto; 
            margin-right:auto;
            text-align:center;
  
        }
        body{
        	font-family: 'Sunflower', sans-serif;
        	textarea:autosize;
        	text-align:center;
        }
		
</style>
<title>WriteForm</title>
<script>
	//글등록버튼 클릭시
	function WriteProc(){
		//무결성검사
		//무결성검사란? 필수항목이 입력이 안된 경우를 처리...
				
		//자바스크립로 무결성 검사하는 방법
		//1. document.getElementById()를 이용해서 특정요소에 접근
		//2. value속성을 이용해서 입력한 값을 알아내고
		//3. 값의 존재여부를 판단
		var title = document.getElementById("title");
		var titleData = title.value;
		//var titleData = document.getElementById("title").value;
		if(titleData==""){
			alert("제목은 반드시 입력해주세요");
			title.focus();
			return;
		}
		// 나머지는 숙제
				
		//폼을 submit
		document.getElementById("wFrm").submit();
	}	
</script>
</head>
<body>

<div class="container">
		<h1 align="center"  style="color:#737373">게시물 등록</h1>
	<%-- 글쓰기 폼만들어 보여주자 --%>
	<form id="wFrm" method="POST" action="../ReBoard/WriteProc.han">
		
        	
	<table class="table table-striped">
			<tr>
				<th>글제목</th>
				<td>
					<input class="form-control" id="title" type="text" name="title">		
				</td>
			</tr>
			<tr>
				<th>글내용</th>
				<td>
					<textarea class="form-control" name="body" id="body"></textarea>
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
				 <input type="password" class="form-control" name="pw" id="pw" placeholder="Enter password">
				</td>
			</tr>
			<tr align="center">
				<th colspan="2">
					<input type="button" id="wBtn" value="글등록" onClick="WriteProc();"/>
				</th>
			</tr>
		
	</table>

	</form>
 </div>
 <jsp:include page="./../../Footer.jsp"></jsp:include>
</body>
</html>














