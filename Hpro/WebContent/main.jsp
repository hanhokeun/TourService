<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">	
<link href="https://fonts.googleapis.com/css?family=Sunflower:300" rel="stylesheet">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script
  src="https://code.jquery.com/jquery-3.3.1.js"
  integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
  crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>  
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="css/codingBooster.css"> 
<style>
	body{
		font-family: 'Sunflower', sans-serif;
	}
</style>
<title>Insert title here</title>
</head>
<body>
<!-- 로그인이 된 사람들의 세션을 만들어 준다. 
회원값이 있는 사람들은 ID에 정보가 담기게 되고
아닌 사람은 null값을 가지게 된다.
-->
<%
		String id = null;
		if(session.getAttribute("mId") != null){
		id = (String) session.getAttribute("mId");
		}
%>
	<!-- nav -->

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="main.jsp">일인용여행</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
      <li class="nav-item">
        <a class="nav-link" href="Tour/TourSearch.han">관광지</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href=" ReBoard/BoardList.han">여행 자유게시판</a>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="MyTour/myTourList.han">나만의 여행</a>
      </li>
    </ul>
   <!-- 접속하기는 로그인안한 사람만 보여주게하기 -->
<%
if(id == null){
%> 
    <form class="nav navbar-nav navbar-right">                  
      <ul class="buttons">  			
		<li><a href="Member/LoginForm.han" class="btn btn-outline-primary">로그인</a></li>
		<li><a href="Member/MemberJoinForm.han" class="btn btn-outline-primary">회원가입</a></li>		
	</ul>
    </form>
<% 
}else if(id.equals("admin")){
%>	   
    <form class="nav navbar-nav navbar-right">                  
      <ul class="buttons">
      <li><a href="Member/MemberList.han"  class="btn btn-outline-primary">회원관리</a></li>      	
		<li><a href="Member/LoginOut.han" class="btn btn-outline-primary">로그아웃</a></li>			
	</ul>
    </form>    
<% 
}else{
%>	   
    <form class="nav navbar-nav navbar-right">                  
      <ul class="buttons">      	
		<li><a href="Member/LoginOut.han" class="btn btn-outline-primary">로그아웃</a></li>			
	</ul>
    </form>
<%
}
%>    
  </div>
 </br></br></br> 
</nav>
	<!-- //nav -->
</br> 

	<!--banner carousel image -->
	<div id="demo" class="carousel slide" data-ride="carousel">
  <ul class="carousel-indicators">
    <li data-target="#demo" data-slide-to="0" class="active"></li>
    <li data-target="#demo" data-slide-to="1"></li>
    <li data-target="#demo" data-slide-to="2"></li>
  </ul>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="/Hpro/images/s2.jpg" alt="Los Angeles" >        
    </div>
    <div class="carousel-item">
      <img src="/Hpro/images/s3.jpg" alt="Chicago">         
    </div>
    <div class="carousel-item">
      <img src="/Hpro/images/s1.jpg" alt="New York">         
    </div>
  </div>
  <a class="carousel-control-prev" href="#demo" data-slide="prev">
    <span class="carousel-control-prev-icon"></span>
  </a>
  <a class="carousel-control-next" href="#demo" data-slide="next">
    <span class="carousel-control-next-icon"></span>
  </a>
</div>
	<!--//banner image -->
<br>
<br>
	<!-- menu intruduce -->	
	<div class="container">			
		<div class="row">
			<div class="col-md-4">
				<h4>전체 여행지</h4>
				<br>
				<p>내가 가고 싶은 여행지. 지역별, 테마별로 여행지를 보여줍니다.</p>				
				<ul class="buttons">
							<li><a href="Tour/TourSearch.han" class="btn btn-outline-primary">더보기</a></li>
				</ul>
			</div>
			<div class="col-md-4">
				<h4>리뷰 게시판</h4>
				<br>
				<p> 여행지에서 겪은 여러분의 직접적인 경험이 다른 여행자들에게 유용한 여행 정보가 됩니다.</p>
				<ul class="buttons">
							<li><a href="ReBoard/BoardList.han" class="btn btn-outline-primary">더보기</a></li>
				</ul>
			</div>
			<div class="col-md-4">
				<h4>나만의 여행게시판</h4>
				<br>
				<p>혼자만이 느낄 수 있는 같은듯 다른 기분,자신만의 여행을 통해서 여행을 가치를 더한다. </p>
				<ul class="buttons">
							<li><a href="MyTour/myTourList.han" class="btn btn-outline-primary">더보기</a></li>
				</ul>
			</div>
		</div>
		<hr>		
	</div>
	<!-- menu intruduce -->	

	<!-- 지역별 여행지 -->
			<section class="wrapper style3 container">
				<header class="major">
					<h2>지역별로 떠나는 여행</h2>
				</header>
				<br>
			<div class="row">
				<div class="col-md-4">
					<section>
						<a href="#" class="image featured"><img src="/Hpro/images/z4.jpg"  alt="" width="360" height="200" /></a>
						<header>
						<br>	
						<h4>서울 특별시</h4>
						</header>
						<br>
						<p>경복궁</p><br>						
					</section>
				</div>
								
				<div class="col-md-4">
					<section>
						<a href="#" class="image featured"><img src="/Hpro/images/z5.jpg"  alt=""width="360" height="200" /></a>
						<header>
						<br>	
						<h4>제주 특별시</h4>
						</header>
						<br>
						<p> 정방 폭포</p>
					</section>
				</div>
								
				<div class="col-md-4">
					<section>
						<a href="#" class="image featured"><img src="/Hpro/images/z6.jpg"   alt="" width="360" height="200" /></a>						
						<header>
						<br>
						<h4>부산 광역시</h4>
						</header>
						<br>
						<p>해운대</p>
					</section>
				</div>								
								
				</div>
					<footer class="major">
						<ul class="buttons">
							<li><a href="#" class="btn btn-outline-primary">지역별 여행지 더보기</a></li>
						</ul>
					</footer>
				</section>					
		<!-- //지역별 여행지 -->
				<hr>

		<!-- 테마별 여행지 -->
			<section class="wrapper style3 container">
				<header class="major">
					<h2>테마별로 떠나는 여행</h2>
				</header>
				<br>	
			<div class="row">
				<div class="col-md-4">
					<section>
						<a href="#" class="image featured"><img src="/Hpro/images/z1.jpg"  alt="" width="360" height="200" /></a>
						<header>
							<br>
							<h4>자연 테마</h4>
						</header>
							<br>
							<p>가지산 도립공원(밀양)</p>
					</section>
			</div>
								
			<div class="col-md-4">
				<section>
					<a href="#" class="image featured"><img src="/Hpro/images/z4.jpg"  alt="" width="360" height="200" /></a>
						<header>
							<br>
							<h4>역사</h4>
						</header>
							<br>
							<p>강화 고인돌 유적[유네스코 지정 유산]</p>
				</section>									
			</div>
								
			<div class="col-md-4">
				<section>
					<a href="#" class="image featured"><img src="/Hpro/images/z3.jpg"  alt="" width="360" height="200" /></a>
						<header>
							<br>
							<h4>레포츠</h4>
						</header>
							<br>
							<p>강촌 레일파크</p>
				</section>									
			</div>						
		</div>
	
		<footer class="major">			
			<ul class="buttons">
			<br>
				<li><a href="#" class="btn btn-outline-primary">테마별 여행지 더보기</a></li>				
			</ul>
		</footer>
		</section>
		<!-- //테마별 여행지 -->
		<br>	

	<footer style="background-color: #4C4C4C; color: #ffffff">
		<div class="container">
				<br>
				<div class="row">
					<div class="col-sm-4" style="text-align: center;"><h6>copyright &copy; 2018</h6><br><h8>구로 IT경영기술 개발원</h8></div>
					<div class="col-sm-4" style="text-align: center;"><h6>3팀소개</h6><br>3팀 대장 이상집  부하 한호근,유남기,장수경</h6><h8>시작은 웅대하였으나 결과는 미약하였다.</h8></div>
					<div class="col-sm-4" style="text-align: center;"><h6>개발목표</h6><br>여행지에 대한 정보와 리뷰를 제공하고 사용자간 정보 공유 </div>						
				</div>							
		</div>	
	
	</footer>	
	
	<!-- Scripts -->
	<script src="https://code.jquery.com/jquery-3.1.1min.js"></script>
	<script src="js/bootstrap.js"></script>	
	<script src="js/jquery.min.js"></script>
	<script src="js/jquery.dropotron.min.js"></script>
	<script src="js/jquery.scrolly.min.js"></script>
	<script src="js/jquery.scrollex.min.js"></script>
	<script src="js/browser.min.js"></script>
	<script src="js/breakpoints.min.js"></script>
	<script src="js/util.js"></script>
	<script src="js/main.js"></script>
</body>
</html>