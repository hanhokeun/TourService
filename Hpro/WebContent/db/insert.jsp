<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입창 예시</title>
<script src="../js/jquery-3.3.1.min.js"></script>
<style>
table {border:solid green;background-color:#FFFF48;}
th {font-style:italic;}
</style>
<script>
//중복확인 버튼이 눌려지면 idcheck.jsp로 가서 해당 아이디가 값이 있는지 여부 확인하고
//있으면 ->안됨, 없으면->가능 메세지를 result에 뿌리기
$(function(){
	var idchk=0;
	$('#btn1').click(function(){
		var id=$('#id').val()
		//아이디정규식체크
		reg1=/^[a-zA-Z0-9]{6,10}$/
		if(!reg1.test(id)){
			alert('아이디는 영문대소문자 또는 숫자  6~10자리로 입력해주세요')
			return false;
		}
		if(id.length==0){
			alert('아이디를 입력해주세요.')
			return false;
		}
		$.ajax({
			url:'idcheck.jsp',
			data:'id='+id+'&temp='+new Date(),
			dataType:'json',
			type:'get',
			success:function(data){
				var result = data.result;
				if(result=="YES"){
					html="<font color='blue'>사용가능한 아이디 입니다.</font>"
					idchk=1;
				}else{
					html="<font color='red'>이미 사용하고 있는 아이디입니다.</font>"
					$('#id').val('')
				}
					$('#result').html(html)
			},
			error:function(err){
				alert('에러!')
			}
		})
	})
	$('#zipcheck').click(function(){
		window.open("zipSearchForm.jsp","zip","width=800,height=500,toolbar=no,menubar=no")
	})
	$('#gaip').click(function(){
		if(idchk==0){
			alert('아이디 중복체크를 해주세요.')
			return false;
		}
		var id=$('#id').val()
		var pw1=$('#pw1').val()
		var	pw2=$('#pw2').val()
		var user=$('#user').val()
		var zipcode=$('#zipcode').val()
		var addr2=$('#addr2').val()
		if(id.length==0){
			alert('아이디를 입력해주세요.')
			$('#id').focus();
			return false;
		}
		if(pw1.length<8){
			alert('비밀번호는 8자리 이상이어야합니다.')
			pw1=$('#pw1').val('')
			$('#pw1').focus();
			return false;
		}
		if(pw1!=pw2){
			alert('비밀번호가 일치하지 않습니다.')
			pw1=$('#pw1').val('')
			pw2=$('#pw2').val('')
			$('#pw1').focus();
			return false;
		}
		if(user.length==0){
			alert('이름을 입력해주세요.')
			$('#user').focus();
			return false;
		}
		if(zipcode.length==0){
		 	alert('주소를 입력해주세요.')
		 	return false;
		}
		if(addr2.length==0){
			alert('상세주소를 입력해주세요.')
			$('#addr2').focus();
			return false;
		}
		if(!$('input[name="gender"]').is(':checked')){
			alert('성별을 선택해주세요')
			$('input[name="gender"]').focus();
			return false;
		}
		if(!$('input[name="email"]').val()){
			alert('이메일을 입력하세요')
			$('input[name="email"]').focus();
			return false;
		}
	})

})
</script>
</head>
<body>
<!-- 
create table member(
id varchar2(20) primary key,
pw varchar2(20),
name varchar2(20)
);
insert into member values('Ksiya','9304','유남기');
insert into member values('hong1,'1234','홍길동');
insert into member values('ninja,'1121','각시탈');
insert into member values('terror,'7890','안중근');
insert into member values('rct880','2345','마피아');
 -->





<h1 align="center">회원가입</h1>
<form action="idcheck.jsp" method="get">
<table border="1" align="center" width="35%">
    <tr>
        <th>아이디</th>
        <td><input type="text" id="id" name="id">
            <input type="button" value="중복확인" id="btn1">
            <div id="result"></div>
        </td>
    </tr>
    <tr>
        <th>비밀번호</th>
        <td><input type="password" id="pw1" name="pw1"></td>
    </tr>
    <tr>
        <th>비밀번호확인</th>
        <td><input type="password" id="pw2" name="pw2"></td>
    </tr>
    <tr>
        <th>이름</th>
        <td><input type="text" id="user" name="user"></td>
    </tr>
    <!-- 우편번호 검색추가 시작 -->
    <tr>
    	<th>우편번호</th>
    	<td><input type="text" id="zipcode" name="zipcode" readonly>
    	<input type="button" id="zipcheck" value="우편번호검색">
    	</td>
    </tr>
    <tr>
    	<th>주소<br/>
    	상세주소
    	</th>
    	<td><input type="text" id="addr" name="addr" size="50" readonly><br/>
    	<input type="text" id="addr2" name="addr2" size="50">
    	</td>
    </tr>
    <!-- 우편번호 검색추가 종료 -->
    <tr>
        <th>생년월일</th>
        <td><input type="date"></td>
    </tr>
    <tr>
        <th>성별</th>
        <td><input type="radio" name="gender">남자
            <input type="radio" name="gender">여자
        </td>
    </tr><tr>
        <th>이메일</th>
        <td><input type="email" name="email"></td>
    </tr>
    <tr>
        <th>휴대전화번호</th>
        <td>
            <select>
                <option>--선택하세요--</option>
                <option>010</option>
                <option>011</option>
                <option>017</option>
                <option>018</option>
                <option>019</option>
            </select>-
            <input type="text" size="5" id="tel1">-
            <input type="text" size="5" id="tel2">
        </td>
    </tr>
    <tr>
        <td colspan="2" align="center">
            <b>추가입력 희망사항</b><br>
            <textarea style="width:300px;height:100px;background:#EEEEEE;"></textarea></td>
    </tr>
    <tr>
        <td colspan="2" align="center">
            <input type="button" value="회원가입" id="gaip">
            <input type="reset" value="다시작성">
        </td>
    </tr>

</table>
</form>

</body>
</html>