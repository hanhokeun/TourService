<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
   <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="../js/jquery-3.3.1.min.js"></script>
<script>
$(function(){
	/* $('#zipcheck').click(function(){
		window.open("../db/zipSearchForm.jsp","zip","width=800,height=500,toolbar=no,menubar=no")
	$('#faddr').empty()	
	}) */
	$('#mimg1').change(function(){
		var strimg1 = $('#mimg1').val();
		var startIdx1 = strimg1.lastIndexOf("\\");
		var timg = strimg1.substr((startIdx1+1));
		$('#imgpath1').val(timg);
		
	})
	$('#mimg2').change(function(){
		var strimg2 = $('#mimg2').val();
		var startIdx2 = strimg2.lastIndexOf("\\");
		var timg = strimg2.substr((startIdx2+1));
		$('#imgpath2').val(timg);
		
	})
	$('#mimg3').change(function(){
		var strimg3 = $('#mimg3').val();
		var startIdx3 = strimg3.lastIndexOf("\\");
		var timg = strimg3.substr((startIdx3+1));
		$('#imgpath3').val(timg);
		
	})
	$('#mimg4').change(function(){
		var strimg4 = $('#mimg4').val();
		var startIdx4 = strimg4.lastIndexOf("\\");
		var timg = strimg4.substr((startIdx4+1));
		$('#imgpath4').val(timg);
		
	})
	$('#mBtn').click(function(){
		//무결성검사
		var mtname=$('#mtName').val()
		if(mtname==null || mtname.length==0){
			alert('관광지 명을 등록해주세요.')
			$('#mtName').focus();
			return false;
		}
		var mlname=$('#mlName').val()
		if(mlname=="--선택하세요--"){
			alert('지역을 선택해주세요.')
			return false;
		}
		var addr=$('#addr').val()
		if(addr==null||addr.length==0){
			alert('주소를 등록해주세요')
			return false;
		}
		var maddr2=$('#maddr2').val()
		if(maddr2==null||maddr2.length==0){
			alert('상세주소를 입력해주세요')
			return false;
		}
		if(!$('input[name="mtheme"]').is(':checked')){
			alert('테마를 선택해주세요')
			return false;
		}
		//폼을 submit
		$('#mFrm').submit();
	})
	$('#cBtn').click(function(){
		location.href="../Tour/TourSearch.han";
	})
	$('#sBtn').click(function(){
		var mtheme = $('[name="mtheme"]:checked').val()
		$('#mtheme').val(mtheme)
	})	
});

</script>
</head>
<body>
	<h1 align="center">관광지 수정창</h1>
	<!-- 받아와야할 파라미터 
	1.관광지 이름
	2.관광지 테마
	3.관광지 주소
	4.관광지 지역
	5.관광지 요약
	6.관광지 사진 주소
	-->
</br>
<form id="mFrm" action="../Tour/TourModifyProc.han" method="POST">	
	<input type="hidden" name="nowPage" value="${nowPage}">
	<input type="hidden" name="tNo" value="${VIEW2.no}">

<div class="container">
<!-- <table border="1" align="center" width="40%"> -->
<table class="table table-striped">
	<tr>
		<th>관광지명</th>
		<td><input type="text" id="mtName" name="mtName" value="${VIEW2.name}"/></td>
	</tr>
	<tr>
		<th>지역</th>
		<td>
			<select id="mlName" name="mlName">
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
    		<input type="text" id="addr" name="addr" size="50"><br/>
    		<!-- <input type="button" id="zipcheck" value="주소검색"><br/> -->
    		<input type="text" id="maddr2" name="maddr2" size="50"><br/>
    		<span id="faddr">수정전 주소 :${VIEW2.addr}</span>
    	</td>
    </tr>
	<tr>
		<th>테마</th>
		<td>
			<input type="radio"  name="mtheme" value="자연"/>자연
			<input type="radio"  name="mtheme" value="문화/예술/역사"/>문화/예술/역사
			<input type="radio"  name="mtheme" value="레포츠"/>레포츠
			<br/>
			<input type="text" name="mtheme" id= mtheme value="${VIEW2.theme1}" readonly/>
			<input type="button" id="sBtn" name="sBtn" value="가져오기"/>
		</td>
	</tr>
	<tr>
		<th id="imgs">이미지</th>
		<td>
			<input type="file" id="mimg1" /><br/>
			<input type="file" id="mimg2" /><br/>
			<input type="file" id="mimg3" /><br/>
			<input type="file" id="mimg4" /><br/>
		</td>
	</tr>
	<tr>
		<th>이미지 경로</th>
		<td>
			<input type="text" id="imgpath1" name="mimg1" size="40" value="${VIEW2.img1}" readonly><br/>
			<input type="text" id="imgpath2" name="mimg2" size="40" value="${VIEW2.img2}" readonly><br/>
			<input type="text" id="imgpath3" name="mimg3" size="40" value="${VIEW2.img3}" readonly><br/>
			<input type="text" id="imgpath4" name="mimg4" size="40" value="${VIEW2.img4}" readonly><br/>
		</td>
	</tr>
	<tr>
		<th>관광지 요약 설명</th>
		<td><textarea style="width:520px;height:300px;" name="mtcon">${VIEW2.brCon}</textarea></td>
	</tr>
	<tr>
		<th>위도</th>
		<td><input type="text" name="mx" id="mwido" value="${VIEW2.x}"/></td>
	</tr>
	<tr>
		<th>경도</th>
		<td><input type="text" name="my" id="mkyengdo" value="${VIEW2.ty}"/></td>
	</tr>
	<tr>
		<th colspan="2">
			<input type="button" class="btn btn-default" id="mBtn" value="수정"/ >
			<input type="button" class="btn btn-default" id="cBtn" value="취소"/>
		</th>
	</tr>
</table>
</div>
</form>
</body>
</html>