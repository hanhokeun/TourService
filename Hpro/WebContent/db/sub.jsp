<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%--
create table news(
no number,
title varchar2(100)
);
insert into news values(1,'평화의 평양 여정, 북미 중재 길을 잇다');
insert into news values(2,'강백호가 말하는 이정후·김재환 그리고 오재원');
insert into news values(3,'아이폰XS 오늘 출시…전세계 애플매장 북적');
http://localhost:8080/AJAXPro/db/sub.jsp?no=1 호출시 이렇게 해야됨(no값을 가져가야함)
 --%>    
 <%
 String no=request.getParameter("no");
 Class.forName("oracle.jdbc.driver.OracleDriver");
 String url="jdbc:oracle:thin:@localhost:1521:XE";
 Connection con=DriverManager.getConnection(url,"namki","you");
 Statement st=con.createStatement();
 String sql="select * from news where no="+no;
 ResultSet rs=st.executeQuery(sql);
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><title>Insert title here</title>
</head>
<body>
<%
while(rs.next()){
	String title=rs.getString("title");
%>
<h2><%=title%></h2>
<%
}
rs.close();
st.close();
con.close();
%>
</body></html>
