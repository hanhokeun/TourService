<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>    
<%
String id = request.getParameter("id");
Class.forName("oracle.jdbc.driver.OracleDriver");
String url="jdbc:oracle:thin:@localhost:1521:XE";
Connection con=DriverManager.getConnection(url,"namki","you");
Statement st=con.createStatement();
String sql="select count(*) as cnt from member where id='"+id+"'";
ResultSet rs = st.executeQuery(sql);
rs.next();
int cnt = rs.getInt("cnt");
rs.close();
st.close();
con.close();
if(cnt==0){
%>
{"result":"YES"}
<%}else{%>
{"result":"NO"}
<%}%>    

