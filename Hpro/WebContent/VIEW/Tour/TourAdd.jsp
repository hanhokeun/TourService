<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<script src="../js/jquery-3.3.1.min.js"></script>
<script>
$(function(){
	/* $('#zipcheck').click(function(){
		window.open("../db/zipSearchForm.jsp","zip","width=800,height=500,toolbar=no,menubar=no") */
	//})
	$('#img1').change(function(){
		var strimg1 = $('#img1').val();
		var startIdx1 = strimg1.lastIndexOf("\\");
		var timg = strimg1.substr((startIdx1+1));
		$('#imgpath1').val(timg);
		
	})
	$('#img2').change(function(){
		var strimg2 = $('#img2').val();
		var startIdx2 = strimg2.lastIndexOf("\\");
		var timg = strimg2.substr((startIdx2+1));
		$('#imgpath2').val(timg);
		
	})
	$('#img3').change(function(){
		var strimg3 = $('#img3').val();
		var startIdx3 = strimg3.lastIndexOf("\\");
		var timg = strimg3.substr((startIdx3+1));
		$('#imgpath3').val(timg);
		
	})
	$('#img4').change(function(){
		var strimg4 = $('#img4').val();
		var startIdx4 = strimg4.lastIndexOf("\\");
		var timg = strimg4.substr((startIdx4+1));
		$('#imgpath4').val(timg);
		
	})
	$('#aBtn').click(function(){
		//무결성검사
		var atname=$('#atName').val()
		if(atname==null || atname.length==0){
			alert('관광지 명을 등록해주세요.')
			$('#atName').focus();
			return false;
		}
		var alname=$('#alName').val()
		if(alname=="--선택하세요--"){
			alert('지역을 선택해주세요.')
			return false;
		}
		var addr=$('#addr').val()
		if(addr==null||addr.length==0){
			alert('주소를 등록해주세요')
			return false;
		}
		var addr2=$('#addr2').val()
		if(addr2==null||addr2.length==0){
			alert('상세주소를 입력해주세요')
			return false;
		}
		if(!$('input[name="theme"]').is(':checked')){
			alert('테마를 선택해주세요')
			return false;
		}
		//폼을 submit
		$('#aFrm').submit();
	})
	$('#cBtn').click(function(){
		location.href="../Tour/TourSearch.han";
	})
	$('#sBtn').click(function(){
		var theme = $('[name="theme"]:checked').val()
		$('#atheme').val(theme)
	})	
});

</script>
</head>
<body>
	<h1 align="center">관광지 추가창 </h1>
	<!-- 받아와야할 파라미터 
	1.관광지 이름
	2.관광지 테마
	3.관광지 주소
	4.관광지 지역
	5.관광지 요약
	6.관광지 사진 주소
	-->
<div="container">
<div class="col-lg-3"></div>
<div class="col-lg-6">	
<form id="aFrm" action="../Tour/TourAddProc.han" method="POST">	
<!-- <table border="1" align="center" width="40%"> -->
<table class="table table-striped">
	<tr>
		<th>관광지명</th>
		<td><input type="text" id="atName" name="atName"/></td>
	</tr>
	</br>
	<tr>
		<th>지역</th>
		<td>
			<select id="alName" name="alName">
				<option value="0">--선택하세요--</option>
				<option>서울</option>
				<option>인천</option>
				<option>광주</option>
				<option>대전</option>
				<option>대구</option>
				<option>울산</option>
				<option>부산</option>
				<option>경기도</option>
				<option>강원도</option>
				<option>충청북도</option>
				<option>충청남도</option>
				<option>전라북도</option>
				<option>전라남도</option>
				<option>경상북도</option>
				<option>경상남도</option>
				<option>제주</option>
			</select>
		</td>
	</tr>
	<tr>
    	<th>주소<br/>
    	상세주소
    	</th>
    	<td>
    		<input type="text" id="addr" name="addr" size="50" >
    		<!-- <input type="button" id="zipcheck" value="주소검색"><br/> -->
    		<input type="text" id="addr2" name="addr2" size="50">
    	</td>
    </tr>
	<tr>
		<th>테마</th>
		<td>
			<input type="radio"  name="theme" value="자연"/>자연
			<input type="radio"  name="theme" value="문화/예술/역사"/>문화/예술/역사
			<input type="radio"  name="theme" value="레포츠"/>레포츠
			<br/>
			<input type="text" name="atheme" id= atheme readonly/>
			<input type="button" id="sBtn" name="sBtn" value="가져오기"/>
		</td>
	</tr>
	<tr>
		<th id="imgs">이미지</th>
		<td>
			<input type="file" id="img1"  /><br/>
			<input type="file" id="img2" /><br/>
			<input type="file" id="img3" /><br/>
			<input type="file" id="img4" /><br/>
		</td>
	</tr>
	<tr>
		<th>이미지 경로</th>
		<td>
			<input type="text" id="imgpath1" name="img1" size="40" value="" readonly><br/>
			<input type="text" id="imgpath2" name="img2" size="40" value="" readonly><br/>
			<input type="text" id="imgpath3" name="img3" size="40" value="" readonly><br/>
			<input type="text" id="imgpath4" name="img4" size="40" value="" readonly><br/>
		</td>
	</tr>
	<tr>
		<th>관광지 요약 설명</th>
		<td><textarea style="width:520px;height:300px;" name="tcon"></textarea></td>
	</tr>
	<tr>
		<th>위도</th>
		<td><input type="text" name="x" id="wido"/></td>
	</tr>
	<tr>
		<th>경도</th>
		<td><input type="text" name="y" id="kyengdo"/></td>
	</tr>
	<tr>
		<th colspan="2">
			<input type="button" class="btn btn-primary" id="aBtn" value="등록"/ >
			<input type="button" class="btn btn-default" id="cBtn" value="취소"/>
		</th>
	</tr>
</table>
</form>
</div>
<div class="col-lg-3"></div>
</div>
</body>
</html>