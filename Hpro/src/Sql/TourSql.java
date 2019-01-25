package Sql;

public class TourSql {
	
	//여기는 질의 명령코드를 입력하는 곳
	//필요한 질의 명령
	public static final int SELECT_TOURINFO =1;	//관광지 요약정보
	public static final int SELECT_TOTAL =2;	//총 관광지 개수	
	public static final int SELECT_TOURDINFO =3;//관광지 정보검색
	public static final int INSERT_TOURINFO =4;	//관광지 정보추가
	public static final int UPDATE_TOURINFO =5;	//관광지 정보 수정
	public static final int DELETE_TOURINFO =6;	//관광지 정보 삭제
	public static final int UPDATE_COUNT =7;	//관광지 조회수 증가
	public static final int SEARCH_THEME =8;	//테마별 관광지 조회
	public static final int SEARCH_AREA =9;		//지역별 관광지 조회
	public static final int SEARCH_EACH =10;	//지역+테마 조건 조회
	public static final int TOTAL_THEME =11;	//테마별 검색 관광지수
	public static final int TOTAL_AREA =12;	//지역별 검색 관광지수
	public static final int TOTAL_EACH =13;	//테마+지역별 검색 관광지수
	
	
	public static String getSQL(int code){
		
		StringBuffer buff = new StringBuffer();
		
		switch(code) {
		case 1:// 관광지 정보 조회 질의문
			buff.append("SELECT");
			buff.append(" t_No AS no,");
			buff.append(" t_Name AS name,");
			buff.append(" t_Addr AS addr,");
			buff.append(" t_Con AS con,");
			buff.append(" t_Img1 AS img1,");
			buff.append(" t_Img2 AS img2,");
			buff.append(" t_Img3 AS img3,");
			buff.append(" t_Img4 AS img4,");
			buff.append(" t_Theme1 AS theme1,");
			buff.append(" t_X AS x,");
			buff.append(" t_Y AS ty,");
			buff.append(" t_Area AS area,");
			buff.append(" t_Count AS cnt");
			buff.append(" FROM");
			buff.append(" Tour");
			buff.append(" WHERE");
			buff.append(" t_IsShow='Y'");
			buff.append(" ORDER BY");
			buff.append(" t_No ASC");
			break;
		case 2://총 게시물 개수
			buff.append("SELECT");
			buff.append(" COUNT(*) AS tot");
			buff.append(" FROM");
			buff.append(" Tour");
			buff.append(" WHERE");
			buff.append(" t_IsShow='Y'");
			break;
		case 3://관광지 정보 상세보기
			buff.append("SELECT");
			buff.append(" t_No AS no,");
			buff.append(" t_Name AS name,");
			buff.append(" t_Addr AS addr,");
			buff.append(" t_Con AS con,");
			buff.append(" t_Img1 AS img1,");
			buff.append(" t_Img2 AS img2,");
			buff.append(" t_Img3 AS img3,");
			buff.append(" t_Img4 AS img4,");
			buff.append(" t_Theme1 AS theme1,");
			buff.append(" t_X AS x,");
			buff.append(" t_Y AS ty,");
			buff.append(" t_Area AS area,");
			buff.append(" t_Count AS cnt");
			buff.append(" FROM");
			buff.append(" Tour");
			buff.append(" WHERE");
			buff.append(" t_IsShow='Y'");
			buff.append(" AND");
			buff.append(" t_No=?");
			break;
		case 4:
			buff.append("INSERT");
			buff.append(" INTO");
			buff.append(" Tour");
			buff.append(" VALUES");
			buff.append(" ((SELECT NVL(MAX(t_No),0)+1 FROM Tour),");
			buff.append(" ?,?,'none','none',?,?,?,?,?,?,?,?,?,0,'Y')");
			break;
		case 5:
			buff.append("UPDATE");
			buff.append(" Tour");
			buff.append(" SET");
			buff.append(" t_Name = ?,");
			buff.append(" t_Area = ?,");
			buff.append(" t_Addr= ?,");
			buff.append(" t_Theme1=?,");
			buff.append(" t_Img1=?,");
			buff.append(" t_Img2=?,");
			buff.append(" t_Img3=?,");
			buff.append(" t_Img4=?,");
			buff.append(" t_Con=?,");
			buff.append(" t_X=?,");
			buff.append(" t_Y=?");
			buff.append(" WHERE");
			buff.append(" t_No=?");
			break;
		case 6:
			buff.append("UPDATE");
			buff.append(" Tour");
			buff.append(" SET");
			buff.append(" t_IsShow='N'");
			buff.append(" WHERE");
			buff.append(" t_No=?");
			break;
		case 7:
			buff.append("UPDATE");
			buff.append(" Tour");
			buff.append(" SET");
			buff.append(" t_Count = t_Count+1");
			buff.append(" WHERE");
			buff.append(" t_No=?");
			break;
		case 8:
			buff.append("SELECT");
			buff.append(" t_No AS no,");
			buff.append(" t_Name AS name,");
			buff.append(" t_Addr AS addr,");
			buff.append(" t_Con AS con,");
			buff.append(" t_Img1 AS img1,");
			buff.append(" t_Img2 AS img2,");
			buff.append(" t_Img3 AS img3,");
			buff.append(" t_Img4 AS img4,");
			buff.append(" t_Theme1 AS theme1,");
			buff.append(" t_X AS x,");
			buff.append(" t_Y AS ty,");
			buff.append(" t_Area AS area,");
			buff.append(" t_Count AS cnt");
			buff.append(" FROM");
			buff.append(" Tour");
			buff.append(" WHERE");
			buff.append(" t_IsShow='Y'");
			buff.append(" AND");
			buff.append(" t_Theme1=?");
			buff.append(" ORDER BY");
			buff.append(" t_No ASC");
			break;
		case 9:
			buff.append("SELECT");
			buff.append(" t_No AS no,");
			buff.append(" t_Name AS name,");
			buff.append(" t_Addr AS addr,");
			buff.append(" t_Con AS con,");
			buff.append(" t_Img1 AS img1,");
			buff.append(" t_Img2 AS img2,");
			buff.append(" t_Img3 AS img3,");
			buff.append(" t_Img4 AS img4,");
			buff.append(" t_Theme1 AS theme1,");
			buff.append(" t_X AS x,");
			buff.append(" t_Y AS ty,");
			buff.append(" t_Area AS area,");
			buff.append(" t_Count AS cnt");
			buff.append(" FROM");
			buff.append(" Tour");
			buff.append(" WHERE");
			buff.append(" t_IsShow='Y'");
			buff.append(" AND");
			buff.append(" t_Area=?");
			buff.append(" ORDER BY");
			buff.append(" t_No ASC");
			break;
		case 10:
			buff.append("SELECT");
			buff.append(" t_No AS no,");
			buff.append(" t_Name AS name,");
			buff.append(" t_Addr AS addr,");
			buff.append(" t_Con AS con,");
			buff.append(" t_Img1 AS img1,");
			buff.append(" t_Img2 AS img2,");
			buff.append(" t_Img3 AS img3,");
			buff.append(" t_Img4 AS img4,");
			buff.append(" t_Theme1 AS theme1,");
			buff.append(" t_X AS x,");
			buff.append(" t_Y AS ty,");
			buff.append(" t_Area AS area,");
			buff.append(" t_Count AS cnt");
			buff.append(" FROM");
			buff.append(" Tour");
			buff.append(" WHERE");
			buff.append(" t_IsShow='Y'");
			buff.append(" AND");
			buff.append(" t_Theme1=?");
			buff.append(" AND");
			buff.append(" t_Area=?");
			buff.append(" ORDER BY");
			buff.append(" t_No ASC");
			break;
		case 11:
			buff.append("SELECT");
			buff.append(" COUNT(*) AS tot");
			buff.append(" FROM");
			buff.append(" (SELECT");
			buff.append(" t_No AS no,");
			buff.append(" t_Name AS name,");
			buff.append(" t_Addr AS addr,");
			buff.append(" t_Con AS con,");
			buff.append(" t_Img1 AS img1,");
			buff.append(" t_Img2 AS img2,");
			buff.append(" t_Img3 AS img3,");
			buff.append(" t_Img4 AS img4,");
			buff.append(" t_Theme1 AS theme1,");
			buff.append(" t_X AS x,");
			buff.append(" t_Y AS y,");
			buff.append(" t_Area AS area,");
			buff.append(" t_Count AS cnt");
			buff.append(" FROM");
			buff.append(" Tour");
			buff.append(" WHERE");
			buff.append(" t_IsShow='Y'");
			buff.append(" AND");
			buff.append(" t_Theme1=?");
			buff.append(" ORDER BY");
			buff.append(" no ASC)");
			break;
		case 12:
			buff.append("SELECT");
			buff.append(" COUNT(*) AS tot");
			buff.append(" FROM");
			buff.append(" (SELECT");
			buff.append(" t_No AS no,");
			buff.append(" t_Name AS name,");
			buff.append(" t_Addr AS addr,");
			buff.append(" t_Con AS con,");
			buff.append(" t_Img1 AS img1,");
			buff.append(" t_Img2 AS img2,");
			buff.append(" t_Img3 AS img3,");
			buff.append(" t_Img4 AS img4,");
			buff.append(" t_Theme1 AS theme1,");
			buff.append(" t_X AS x,");
			buff.append(" t_Y AS y,");
			buff.append(" t_Area AS area,");
			buff.append(" t_Count AS cnt");
			buff.append(" FROM");
			buff.append(" Tour");
			buff.append(" WHERE");
			buff.append(" t_IsShow='Y'");
			buff.append(" AND");
			buff.append(" t_Area=?");
			buff.append(" ORDER BY");
			buff.append(" no ASC)");
			break;
		case 13:
			buff.append("SELECT");
			buff.append(" COUNT(*) AS tot");
			buff.append(" FROM");
			buff.append(" (SELECT");
			buff.append(" t_No AS no,");
			buff.append(" t_Name AS name,");
			buff.append(" t_Addr AS addr,");
			buff.append(" t_Con AS con,");
			buff.append(" t_Img1 AS img1,");
			buff.append(" t_Img2 AS img2,");
			buff.append(" t_Img3 AS img3,");
			buff.append(" t_Img4 AS img4,");
			buff.append(" t_Theme1 AS theme1,");
			buff.append(" t_X AS x,");
			buff.append(" t_Y AS y,");
			buff.append(" t_Area AS area,");
			buff.append(" t_Count AS cnt");
			buff.append(" FROM");
			buff.append(" Tour");
			buff.append(" WHERE");
			buff.append(" t_IsShow='Y'");
			buff.append(" AND");
			buff.append(" t_Theme1=?");
			buff.append(" AND");
			buff.append(" t_Area=?");
			buff.append(" ORDER BY");
			buff.append(" t_No ASC)");
			break;
		}
		return buff.toString();	
	}
}
