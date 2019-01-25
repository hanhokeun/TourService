<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<title>Insert title here</title>
<script src = "../js/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<script>
$(function(){
	$('#lBtn').click(function(){
		$(location).attr('href',"../Tour/TourSearch.han?nowPage=${nowPage}")
	})		
	$('#pBtn').click(function(){
		var winObj=window.open('../MyTour/myPickForm.han?tNo=${VIEW.no}','TourPick','width=700, height=500');
	})
})
function mProc(){
	location.href="../Tour/TourModify.han?nowPage=${nowPage}&tNo=${VIEW.no}"
}
function dProc(){
	var conf =confirm('정말삭제하시겠습니까?')
	if(conf==false){
		return false;
	}
	location.href="../Tour/TourDelete.han?nowPage=${nowPage}&tNo=${VIEW.no}"
}
</script>
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=RJC3MJZ8L82LKHjp2nx3"></script>
<style>

#timg {padding:10px 0px 0px 0px;}
</style>
</head>
<body>
<jsp:include page="./../../Header.jsp"></jsp:include>
<form name="a">	
<!-- <table width="100%"> -->
<div class="container">
<table class="table table-striped">
	<tr>
		<td colspan="6"><h2 id="tname">${VIEW.name}</h2>
		
		<input type="hidden" name="tname" id="tname" value="${VIEW.name}"/>
		<input type="hidden" name="x" id="x" value="${VIEW.x}"/>
		<input type="hidden" name="ty" id="y" value="${VIEW.ty}"/>
		<input type="hidden" name="taddr" id="taddr" value="${VIEW.addr}"/>
		<input type="hidden" name="img1" id="img1" value="${VIEW.img1}"/>
		<input type="hidden" name="theme1" id="theme1" value="${VIEW.theme1}"/>
		</td>
	</tr>
<c:if test="${GRADE eq 9}">
	<tr>
		<td colspan=5 align="right">
			<input type="button" value="관광지 정보 수정" onclick="mProc()" class="btn btn-primary"/>
			<input type="button" value="관광지 삭제" onclick="dProc()" class="btn btn-danger">
		</td>
	</tr>
</c:if>
	<tr>
		<td align="left" width="20%"><Strong>지역</Strong> :${VIEW.area}</td>
		<td align="left" width="20%"><Strong>테마</Strong> :${VIEW.theme1}</td>
		<td align="left" width="20%"><Strong>조회수</Strong>:${VIEW.cnt}</td>
		<td align="right" width="40%" colspan="2"><input type="button" id="lBtn" value="목록으로" class="btn btn-default"/>
		<input type="button" id="pBtn" value="찜하기" class="btn btn-link"></td>
	</tr>
</table>
</div>
</form>
	<hr size="5px">
	<br/>
<form name="tInfo" id="tInfo">
<table border="0" id="timg" align="center">
	<tr>
		<td rowspan="3">
		<div id="map" align="center" style="width:450px;height:457px;"></div>

			<script>
				//위도와 경도 값으로 지도 불러오기
				var x = a.x.value;
				var y = a.ty.value;
				var name = a.tname.value;
				var addr = a.taddr.value;
				var img1 = a.img1.value;
				var theme1 = a.theme1.value;
			
				var map = new naver.maps.Map('map', {
    				center: new naver.maps.LatLng( x, y),
    				zoom: 10,
    				mapTypeId: naver.maps.MapTypeId.NORMAL
				});
				// 지도 유형 변경하기
				var btns = $(".buttons > input");
				btns.on("click", function(e) {
				    e.preventDefault();

				    var mapTypeId = this.id;

				    if (map.getMapTypeId() !== naver.maps.MapTypeId[mapTypeId]) {
				        map.setMapTypeId(naver.maps.MapTypeId[mapTypeId]); 

				        btns.removeClass("control-on");
				        $(this).addClass("control-on");
				    }
				});
				
				//마커지정
				var marker = new naver.maps.Marker({
				    position: new naver.maps.LatLng(x, y),
				    map: map
				});
				
				// 해당 관광지 간략 정보 입력
				var contentString = [
    			'<div class="iw_inner" style="border:solid 3px lime;">',
    			'   <h3>'+name+'</h3>',
   		 		'   <p>'+addr+'<br>',
    			'       <img src="../Sampleimg/'+img1+'" width="100" height="100" class="thumb" /><br>',
    			'       '+theme1+'<br>',
    			'   </p>',
    			'</div>'
				].join('');
				var infowindow = new naver.maps.InfoWindow({
				    content: contentString
				});

				naver.maps.Event.addListener(marker, "click", function(e) {
				    if (infowindow.getMap()) {
				        infowindow.close();
				    } else {
				        infowindow.open(map, marker);
				    }
				});
			</script>
		</td>		
		<td rowspan="3"><img height="457px" width="450px" src="../Sampleimg/${VIEW.img1}"></td>
		<td><img height="150px" width="250px" src="../Sampleimg/${VIEW.img2}"></td>
	</tr>
	<tr>
		<td><img height="150px" width="250px" src="../Sampleimg/${VIEW.img3}"></td>
	</tr>
	<tr>
		<td><img height="150px" width="250px" src="../Sampleimg/${VIEW.img4}"></td>
	</tr>
</table>
</form>	
<hr  size="5px">
<br/>
<h2>상세위치  : ${VIEW.addr}</h2>
<hr  size="5px">
<h2 style="color:green;">관광지 요약</h2><br/>
<span>${VIEW.brCon}</span>
<br/>
<br/>
<br/>
<jsp:include page="./../../Footer.jsp"></jsp:include>		
</body>
</html>