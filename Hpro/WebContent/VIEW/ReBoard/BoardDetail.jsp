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
<jsp:include page="./../../Header.jsp"></jsp:include>
<style>
        #wrap{
            width:300px;
            height:100px;
            margin-left:auto; 
            margin-right:auto;
            text-align:center;
        }
      th, td{
      		text-align:center;
      }
      body{
        	font-family: 'Sunflower', sans-serif;
        	font-size: 18pt;
        }
      
  
</style>
<title>Insert title here</title>
<%--
	jQuery를 이용하기 위해서는 jQuery라이브러리가 필요하다
	1. 라이브러리를 다운받아서 사용하는 방법
	2. CDN네트워크를 이용해서 사용하는 방법		
 --%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		//목록보기
		$("#lBtn").click(function(){
			//목록보기로 강제로 이동
			//자바스크립트		location.href="요청내용";
			//location.href="../ReBoard/BoardList.re?nowPage=${nowPage}";
			
			//jQuery $(선택자).attr('속성명',"데이터")
			$(location).attr("href","../ReBoard/BoardList.han?nowPage=${nowPage}");
		});
		
		//(원글)수정
		// 적절한 이벤트를 이용해서 적절한 요청처리하기(컨트롤러-> 뷰) 숙제
		$('#mBtn').click(function(){
			$(location).attr('href',"../ReBoard/ModifyForm.han?oriNo=${VIEW.no}&nowPage=${nowPage}");
		});
		
		// (원글)삭제/ id="dBtn" value="삭제하기"
		// 적절한 이벤트를 이용해서 적절한 요청처리하기(컨트롤러-> 뷰) 숙제
		$('#dBtn').click(function(){
			//1. 비밀번호를 입력받는다
			var pw = prompt('비밀번호를 입력하세요');
			//2. hidden에 필요한 데이터를 심어놓는다			
					//자바스크립트
						//특정id요소의 값을 가져오기
						//document.getElementById("id명").value;
						//특정id요소의 값을 설정하기
						//document.getElementById("id명").value=값;
					//jQuery
						//$(선택자).val(); 		//특정id요소의 값을 가져오기
						//$(선택자).val(데이터); //특정id요소의 값을 설정하기
			$("#imsiOriNo").val("${VIEW.no}");
			$("#imsiPw").val(pw);
			
			//3. 요청들어간다
			$("#imsiFrm").submit();

		});
		
		//댓글수정버튼 클릭하면 상세화면에서  댓글수정폼으로 변경되도록 하고 싶다
		//class="rmBtn"  param="${temp.no}"/>
		$('.rmBtn').click(function(){
			//이벤트가 발생한 객체 $(this)
			var button = $(this);
			
			//해당 버튼이 속한 테이블을 알아내자
			var table = button.parents("table");
			var id = table.attr("id"); 
			
			//테이블을 감추자
			$("#"+id).hide();
			
			//수정폼을 보여주자
			var formid = "frm"+id;
			$("#"+formid).show(); 
		
		});
		
		//댓글수정
		$(".modifyB").click(function(){
			//해당 댓글수정버튼이 포함된 폼을 찾아서 서브밋해야한다
			var form = $(this).parents("form");
			$(form).submit();
		});
		
		
		//댓글삭제 class="rdBtn" param="${temp.no}"/>
		$('.rdBtn').click(function(){
			//이벤트가 발생한 객체에 있는 param속성값을 가져오자
			var reNo = $(this).attr("param");
			var pw = prompt("비밀번호를 입력해 주세요");
			
			//<input type="hidden"의 값을 셋팅
			$("#tempReNo").val(reNo);
			$("#tempRenowPage").val("${nowPage}");
			$("#tempReOriNo").val("${VIEW.no}");
			$("#tempRePw").val(pw);
			
			$("#tempReFrm").submit();
		});
		
		//댓글등록
		//<input type="button" id="wrBtn" value="글등록" onClick="wrWrite;"/>
		$("#wrBtn").click(function(){
			//1. 입력한 데이터 가져오기
			var	title = $("#title").val();
			if(title == "") {
				alert("제목을 반드시 입력해 주세요");
				return;
			}
			//	나머지 두개도 해보자.
			
			//	2.	서버에 전송한다.
			$("#wrFrm").submit();
		});
		
	
		//댓글추천(좋아요) 클릭시
		//class="rgBtn" value="좋아요(${temp.good})" param="${temp.no}" />
		//$(선택자).on("이벤트명",function(){});

		$(".rgBtn").on("click",function(){
		//이벤트가 발생한 좋아요 단추의 param속성값을 가져오자!
		var reNo= $(this).attr("param");
		$(location).attr("href","../ReBoard/ReplyRecommand.han?reNo="+reNo+"&kind=1&tNO=${VIEW.no}&nowPage=${nowPage}");
		
		});
		
		//댓글추천(나빠요) 클릭시
		//class="rbBtn" value="나빠요(${temp.bad})" param="${temp.no}" />
		$(".rbBtn").on("click",function(){
			var reNo= $(this).attr("param");
			$(location).attr("href","../ReBoard/ReplyRecommand.han?reNo="+reNo+"&kind=2&tNO=${VIEW.no}&nowPage=${nowPage}");
		});
		
	});
	
</script>
</head>
<body>
	<div class="container">
		<div align="center"><h1 style="color:#737373;">여행 자유게시판</h1></div>
		<%--1.상세 내용 보기 --%>
			<table class="table table-striped">
				<tr>
					<th>글번호</th>
					<td>${VIEW.no}</td>
					<th>조회수</th>
					<td>${VIEW.hit}</td>
				</tr>
				<tr>
					<th>글쓴이</th>
					<td>${VIEW.writer}</td>
					<th>작성일</th>
					<td>${VIEW.wday}</td>
				</tr>
				<tr>
					<th>제목</th>
					<td colspan="3">${VIEW.title}</td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="3">${VIEW.brBody}</td>
				</tr>
			</table>
			<%--2.기타 부가 기능(목록보기, 원글수정, 원글삭제) --%>
			<table class="table table-striped">
				<tr>
					<td align="center">
						<input type="button" id="lBtn" value="목록보기" />
						<%-- 수정,삭제는 자신이 쓴 글에대해서만 권한이 부여되게. 
								컨트롤러에서 알아낸 글쓴이와 
								로그인한 정보가 같은지 비교한 후 처리하여 권한부여
						--%>
						<c:if test="${VIEW.writer eq sessionScope.mId}">
							<input type="button" id="mBtn" value="수정" />
							<input type="button" id="dBtn" value="삭제" />
						</c:if>
					</td>
				</tr>
			</table>		
			<%--3.댓글 보기       --%>
			<%-- 댓글이 없는 경우 --%>
			<c:if test="${empty REPLY}">
				<table class="table table-striped">
					<tr>
						<td align="center" style="color:#004d1a;">
							댓글이 없어요
						</td>
					</tr>
				</table>	
			</c:if>
			<%-- 댓글이 존재하는 경우.. 댓글수만큼 반복출력 ${temp.VO클래스의 GET함수}--%>
			<c:if test="${not empty REPLY}">
				<c:forEach var="temp" items="${REPLY}">
				<table class="table table-striped" id="${temp.no}" >
			<%-- 		<table id="${temp.no}" > --%>
						<tr>
							<th>댓글번호</th>
							<td>${temp.no}</td>
							<th>원글번호</th>
							<td>${temp.oriNo}</td>
						</tr>
						<tr>
							<th>글쓴이</th>
							<td>${temp.writer}</td>
							<th>작성일</th>
							<td>${temp.wday}</td>
						</tr>
						<tr>
							<th>제목</th>
							<td colspan="3">${temp.title}</td>
						</tr>
						<tr>
							<th>내용</th>
							<td colspan="3">${temp.brBody}</td>
						</tr>
						<tr>
							<td colspan="4" align="center">
								<input type="button" class="rmBtn" value="수정" param="${temp.no}"/>
								<input type="button" class="rdBtn" value="삭제" param="${temp.no}"/>
							</td>	
					</table>					 
			 
				<form id="frm${temp.no}" method="POST" action="../ReBoard/ReplyModify.han" style="display:none;">
					<input type="hidden" name="reNo"    value="${temp.no}"/>
					<input type="hidden" name="oriNo"   value="${temp.oriNo}"/>
					<input type="hidden" name="nowPage" value="${nowPage}"/>
					<table class="table table-striped">
							<tr>
								<th>(댓글)제목</th>
								<td>
									<input type="text"  name="title" id="title${temp.no}"  value="${temp.title}" class="form-control input-lg" />
								</td>
							</tr>
							<tr>
								<th>(댓글)내용</th>
								<td>
									<textarea  name="body" id="body${temp.no}" class="form-control input-lg" >${temp.body}</textarea>
								</td>
							</tr>
							<tr>
								<th>(댓글)비밀번호</th>
								<td>
									<input type="password"  name="pw" id="pw${temp.no}" class="form-control input-lg"/>
								</td>
							</tr>
							<tr>
								<td colspan="2" align="center">
									<input type="button"  
									       class="modifyB"  value="댓글수정" />
								</td>
							</tr>
					</table>
				</form>
			</c:forEach>
			</c:if>
			<%--4.댓글 쓰기 폼 보여주기--%>
		<div class="form-group">
			<form id="wrFrm" method="POST" action="../ReBoard/ReplyWrite.han">
				<input type="hidden" id="oriNo" name="oriNo" value="${VIEW.no}">		
				<input type="hidden" id="nowPage" name="nowPage" value="${nowPage}">
				<input type="hidden" id="mNo" name="mNo" value="${nowPage}">
				<table class="table table-striped">
					<tr>
						<th>댓글제목</th>
						<td>
							<input class="form-control" type="text" name="title" id="title"/>
						</td>
					</tr>
					<tr>
						<th>댓글내용</th>
						<td>
							<textarea class="form-control" name="body" id="body"></textarea>
						</td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td>
							<input class="form-control" type="password" name="pw" id="pw"/>
						</td>
					</tr>
					<tr>
						<th colspan="2">
							<input type="button" id="wrBtn" value="글등록">
						</th>
					</tr>
		
			</table>
				</form>
			</div>
			<%-- 원글삭제하기위한 임시폼을 만들어 놓는다 --%>
			<form id="imsiFrm" method="POST" action="../ReBoard/BoardDelete.han">
				<input type="hidden" name="oriNo" id="imsiOriNo"/>
				<input type="hidden" name="pw"    id="imsiPw"/>
			</form>
			
				<%-- 댓글삭제하기위한 임시폼을 만들어 놓는다--%>
			<form id="tempReFrm" method="POST" action="../ReBoard/ReplyDelete.han">
				<input type="hidden" name="oriNo" id="tempReOriNo"/>
				<input type="hidden" name="pw"    id="tempRePw"/>
				<input type="hidden" name="reNo"  id="tempReNo" />
				<input type="hidden" name="nowPage" id="tempRenowPage" /> 
			</form>
	</div>
<jsp:include page="./../../Footer.jsp"></jsp:include>
</body>
</html>

















