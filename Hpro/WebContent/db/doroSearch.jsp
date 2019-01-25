<?xml version="1.0" encoding="UTF-8"?>
<%@ page language="java" contentType="application/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>       
<%
String sido = request.getParameter("sido");
String gugun = request.getParameter("gugun");
Class.forName("oracle.jdbc.driver.OracleDriver");
String url="jdbc:oracle:thin:@localhost:1521:XE";
Connection con=DriverManager.getConnection(url,"peach","1234");
Statement st=con.createStatement();
String sql="";
if(sido.equals("SJ")){
	sql="select distinct ROADCODE,ROADNM from "+sido+" order by roadnm";
}
else{
	sql ="select distinct ROADCODE,ROADNM from "+sido+" where sigungueng='"+gugun+"' order by roadnm";
}
ResultSet rs = st.executeQuery(sql);
ArrayList list = new ArrayList();
while(rs.next()){
	HashMap map = new HashMap();
	map.put("code",rs.getString("roadcode"));
	map.put("name",rs.getString("roadnm"));
	list.add(map);	
}
rs.close();
st.close();
con.close();
%>
<doros>
<%
int size=list.size();
for(int i=0;i<size;i++){
	HashMap temp=(HashMap)list.get(i);%>
	<doro>
		<code><%=temp.get("code")%></code>
		<name><%=temp.get("name")%></name>
	</doro>
<%
}
%>
</doros>


















