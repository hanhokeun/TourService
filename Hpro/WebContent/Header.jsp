<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width", initial-scale="1">	
	<link href="https://fonts.googleapis.com/css?family=Sunflower:300" rel="stylesheet">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>  
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="css/codingBooster.css"> 
<title>Insert title here</title>
<style>
	body{
		font-family: 'Sunflower', sans-serif;
		font-size: 15pt;
	}
</style>
</head>
<body>
 <!-- 로그인이 된 사람들의 세션을 만들어 준다. 
회원값이 있는 사람들은 ID에 정보가 담기게 되고
아닌 사람은 null값을 가지게 된다.
-->
	<!-- nav -->

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
  		<a class="navbar-brand" href="../main.jsp">일인용여행</a>
  		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
    		<span class="navbar-toggler-icon"></span>
  		</button>
  			<div class="collapse navbar-collapse" id="navbarTogglerDemo02">
    			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
      				<li class="nav-item">
        				<a class="nav-link" href="../Tour/TourSearch.han">관광지</a>
      				</li>
      				<li class="nav-item">
        				<a class="nav-link" href=" ../ReBoard/BoardList.han">여행 자유게시판</a>
      				</li>
      				<li class="nav-item">
        				<a class="nav-link disabled" href="../MyTour/myTourList.han">나만의 여행</a>
      				</li>
    			</ul>
   <!-- 접속하기는 로그인안한 사람만 보여주게하기 -->
		<%
		if(session.getAttribute("mId") == null){
		%> 
    <form class="nav navbar-nav navbar-right">                  
      <ul class="buttons">  			
		<li><a href="../Member/LoginForm.han" class="btn btn-outline-primary">로그인</a></li>
		<li><a href="../Member/MemberJoinForm.han" class="btn btn-outline-primary">회원가입</a></li>		
	</ul>
    </form>
<% 
}else{
%>	   
    <form class="nav navbar-nav navbar-right">                  
      <ul class="buttons">      	
		<li><a href="../Member/LoginOut.han" class="btn btn-outline-primary">로그아웃</a></li>			
	</ul>
    </form>
<%
}
%>    
  </div>
</br></br></br>
</br>
</nav>
	<!-- //nav -->
</br> </br></br>
</body>
</html>