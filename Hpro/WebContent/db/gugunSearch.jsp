<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>      
<%
String sido = request.getParameter("sido");
Class.forName("oracle.jdbc.driver.OracleDriver");
String url="jdbc:oracle:thin:@localhost:1521:XE";
Connection con=DriverManager.getConnection(url,"peach","1234");
Statement st=con.createStatement();
String sql = "select distinct sigungu,sigungueng from "+sido+" order by sigungu";
ResultSet rs= st.executeQuery(sql);
ArrayList list = new ArrayList();
while(rs.next()){
	HashMap map = new HashMap();
	map.put("name",rs.getString("sigungu"));
	map.put("code",rs.getString("sigungueng"));
	list.add(map);
}
rs.close();
st.close();
con.close();%>
{
	"gugun":
	[
<%		int size=list.size();
			for(int i=0;i<size;i++){
			HashMap map=(HashMap)list.get(i);
				if(i==size-1){//마지막 데이터%>
				{"code":"<%=map.get("code")%>","name":"<%=map.get("name")%>"}
				<%}
				else{%>
				{"code":"<%=map.get("code")%>","name":"<%=map.get("name")%>"},
<%				}
			}%>
	]
}
	