<?xml version="1.0" encoding="UTF-8"?>
<%@ page language="java" contentType="application/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>      
<%
String sido = request.getParameter("sido");
String gugun = request.getParameter("gugun");
String doro = request.getParameter("doro");
//http://localhost:80/AJAXPro/db/zipSearch.jsp
//String sido="DJ";
//String gugun="Seo-gu";
//String doro="301704298154";
//ROADCODE,ROADNM
Class.forName("oracle.jdbc.driver.OracleDriver");
String url="jdbc:oracle:thin:@localhost:1521:XE";
Connection con=DriverManager.getConnection(url,"peach","1234");
Statement st=con.createStatement();
/*select distinct zipcode, sigungu, ubmyun,dong1,dong2, ri,roadnm,bldnm from dj 
where roadcode='301704298154' and sigungueng='Seo-gu'
order by roadnm ASC;*/
String sql="";
if(sido.equals("SJ")){
	sql="select distinct zipcode, sido,sigungu, ubmyun,dong1,dong2,";
	sql=sql+" ri,roadnm,bldnm from "+sido;
	sql=sql+" where roadcode='"+doro+"'order by roadnm";
}
else{
	sql="select distinct zipcode, sido,sigungu, ubmyun,dong1,dong2,";
	sql=sql+" ri,roadnm,bldnm from "+sido+" where sigungueng='"+gugun;
	sql=sql+"'and roadcode='"+doro+"'order by roadnm";
}
ResultSet rs=st.executeQuery(sql);
ArrayList list = new ArrayList();
while(rs.next()){
	HashMap map = new HashMap();
	map.put("zipcode",rs.getString("zipcode"));
	sido=rs.getString("sido");
	gugun=rs.getString("sigungu");
	String ubmyun=rs.getString("ubmyun");
	String dong1=rs.getString("dong1");
	String dong2=rs.getString("dong2");
	String ri=rs.getString("ri");
	doro=rs.getString("roadnm");
	String bldnm=rs.getString("bldnm");
	String addr=sido;
	if(gugun!=null&&gugun.trim().length()!=0){
		addr=addr+" "+gugun;
	}
	if(ubmyun!=null&&ubmyun.trim().length()!=0){
		addr=addr+" "+ubmyun;
	}
	addr=addr+" "+doro;
	boolean isOpen=false;
	if(dong1!=null&&dong1.trim().length()!=0 && dong2==null){
		if(isOpen){
			addr=addr+" "+dong1;
		}
		else{
			addr=addr+" ("+dong1;
			isOpen=true;
		}
	}
	if(dong2!=null&&dong2.trim().length()!=0){
		addr=addr+" ("+dong2;
		isOpen=true;
	}
	if(bldnm!=null&&bldnm.trim().length()!=0){
		addr=addr+" "+bldnm;
	}
	if(isOpen){
	addr=addr+")";
	}	
	map.put("addr",addr);
	list.add(map);
}
rs.close();
st.close();
con.close();
%>
<addrs>
<% 
	int size=list.size();
	for(int i=0;i<size;i++){
		HashMap temp =(HashMap)list.get(i);%>
	<addr>
		<zipcode><%=temp.get("zipcode")%></zipcode>
		<juso><%=temp.get("addr")%></juso>
	</addr>
<%}%>	
</addrs>


















