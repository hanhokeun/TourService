package Sql;

public class MyTourSql {

	public static final int SELECT_TOURLIST = 1; //나의여행 리스트 검색
	public static final int INSERT_TOURNAME = 2 ; //나의 여행 추가
	public static final int SELECT_MYPICK = 3; //찜하기 여부 검색
	public static final int INSERT_MYPICK = 4; //찜하기
	public static final int SELECT_MYTOURTOTALCOUNT = 5; //총 여행목록 개수 검색
	public static final int SELECT_MYTOURTOTALNAMEDATE = 6; //나의여행이름,날짜 검색
	public static final int SELECT_MYTOURIMG = 7; //나의 여행 이미지 검색
	public static final int SELECT_MYTOURDETAIL = 8; //나의 상세여행 검색
	public static final int SELECT_MYTOURDETAILTOTALCOUNT = 9; //나의 상세여행지 목록 총개수 구하기 = 찜한 갯수
	public static final int SELECT_MTNO=10; //여행지 번호 구하기
	public static final int SELECT_MYTOURNAMEDATE=11; //각 여행의 이름과 날짜 검색하기-상세보기 사용
	public static final int UPDATE_MYTOURNAMEDATE=12; //각 여행의 이름과 날짜 수정하기
	public static final int UPDATE_DETAILSTART=13; //여행 일정 변화에 따른 조건적 시작날짜 수정
	public static final int SELECT_DETAILSTART=14; //상세 여행지 시작날짜 조회
	public static final int UPDATE_DETAILEND=15; //여행 일정 변화에 따른 조건적 종료날짜 수정
	public static final int SELECT_DETAILEND=16; //상세 여행지 종료날짜 조회
	public static final int SELECT_DETAILNANEDATE=17; //상세 여행지 이름과 날짜조회
	public static final int DELETE_MYTOURLIST=18; //내 여행리스트 삭제하기
	public static final int DELETE_MYTOURDETAIL=19; //상세 여행지 삭제하기
	public static final int UPDATE_DETAILDATE=20; //상세 여행지 일정 수정하기
	
	public static String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
		case 20:
			buff.append("update TourDetail ");
			buff.append("set tDetail_start=?, ");
			buff.append("tDetail_end=? ");
			buff.append("where tDetail_No=? ");
			buff.append("and td_IsShow='Y' ");
			break;
		case 19:
			buff.append("update TourDetail ");
			buff.append("set td_IsShow='N' ");
			buff.append("where mt_No=? ");
			buff.append("and tDetail_No=? ");
			break;
		case 18:
			buff.append("update MyTour ");
			buff.append("set mt_IsShow='N' ");
			buff.append("where mt_No=? ");
			buff.append("and m_No=? ");
			break;
		case 17:
			buff.append("select tDetail_No as tdno, ");
			buff.append("t_Name as name, tDetail_Start as tdstart, ");
			buff.append("tDetail_End as tdend ");
			buff.append("from TourDetail, Tour ");
			buff.append("where td_IsShow='Y' ");
			buff.append("and TourDetail.t_No=Tour.t_No ");
			buff.append("and tDetail_No=? ");
			break;
		case 16:
			buff.append("select tDetail_End as tdend ");
			buff.append("from TourDetail ");
			buff.append("where td_IsShow='Y' ");
			buff.append("and mt_No=? ");
			buff.append("and ((tDetail_End>?) "); //여행 종료일보다 클 때
			buff.append("or (tDetail_End<?)) "); //여행 시작일보다 작을 때
			break;
		case 15://상세 여행지의 종료일이 여행의 종료일보다 클 때  or 여행 종료일이 여행의 시작일보다 작을 때 변경
			buff.append("update TourDetail ");
			buff.append("set tDetail_End=? ");
			buff.append("where mt_No=? ");
			buff.append("and td_IsShow='Y' ");
			buff.append("and ((tDetail_End>?) "); //여행의 종료일보다 클 때
			buff.append("or (tDetail_End<?)) "); //여행의 시작일보다 작을 때
			break;
		case 14://상세 여행지의 시작일이 여행의 종료일보다 클 때  or 여행 시작일이 여행의 시작일보다 작을 때
			buff.append("select tDetail_Start as tdstart ");
			buff.append("from TourDetail ");
			buff.append("where td_IsShow='Y' ");
			buff.append("and mt_No=? ");
			buff.append("and ((tDetail_Start<?) "); //여행의 시작일보다 작을 때
			buff.append("or (tDetail_Start>?)) "); //여행의 종료일보다 클 때
			break;
		case 13://상세 여행지의 시작일이 여행의 종료일보다 클 때  or 여행 시작일이 여행의 시작일보다 작을 때 변경
			buff.append("update TourDetail ");
			buff.append("set tDetail_Start=? ");
			buff.append("where mt_No=? ");
			buff.append("and td_IsShow='Y' ");
			buff.append("and ((tDetail_Start<?) "); //여행의 시작일보다 작을 때
			buff.append("or (tDetail_Start>?)) "); //여행의 종료일보다 클 때
			break;
		case 12:
			buff.append("update MyTour ");
			buff.append("set mt_Name=?, ");
			buff.append("mt_Start=?, ");
			buff.append("mt_End=? ");
			buff.append("where mt_No=? ");
			buff.append("and m_No=? ");
			buff.append("and mt_IsShow='Y' ");
			break;
		case 11:
			buff.append("select mt_No as no, ");
			buff.append("mt_Name as name, ");
			buff.append("mt_Start as mtstart, ");
			buff.append("mt_End as mtend ");
			buff.append("from MyTour ");
			buff.append("where m_No=? ");
			buff.append("and mt_No=? ");
			break;
		case 1:
			buff.append("select  ");
			buff.append("mt_No as no, mt_Name as name ");
			buff.append("from ");
			buff.append("MyTour ");
			buff.append("where ");
			buff.append("m_No=? and ");
			buff.append("mt_IsShow='Y'  ");
			buff.append("order by name  ");
			break;
		case 2:
			buff.append("insert into ");
			buff.append("MyTour values(");
			buff.append("(select nvl(max(mt_No),0)+1 from MyTour), ");
			buff.append(" ?,  ?, 'Y',  ?,  ?)");
			break;
		case 3:
			buff.append("select ");
			buff.append("t_No as tno ");
			buff.append("from MyTour, TourDetail ");
			buff.append("where MyTour.mt_No=TourDetail.mt_No ");
			buff.append("and MyTour.mt_No=? ");
			buff.append("and m_No=? ");
			buff.append("and td_IsShow='Y' ");
			break;
		case 4:
			buff.append("insert into ");
			buff.append("TourDetail values(");
			buff.append("(select nvl(max(tDetail_No),0)+1 from TourDetail), ");
			buff.append("?, ?, 'Y', ");
			buff.append("(select mt_Start from MyTour "); 
			buff.append("where mt_No=? and m_No=?), "); 
			buff.append("(select mt_End from MyTour "); 
			buff.append("where mt_No=? and m_no=?))"); 
			break;	
		case 5:
			buff.append("select ");
			buff.append("count(*) as cnt ");
			buff.append("from MyTour ");
			buff.append("where mt_IsShow='Y' ");
			buff.append("and m_No=?");
			break;
		case 6:
			buff.append("select mt_No as no, ");
			buff.append("mt_Name as name, ");
			buff.append("mt_Start as mtstart, ");
			buff.append("mt_End as mtend ");
			buff.append("from MyTour ");
			buff.append("where m_No=? ");
			buff.append("and mt_IsShow='Y' ");
			buff.append("order by mt_no ");
			break;
		case 7:
			buff.append("select rownum, ");
			buff.append("no, tNo, img from(");
			buff.append("select rownum, mt_No as no, ");
			buff.append("tourDetail.t_No as tNo, ");
			buff.append("t_Img1 as img from ");
			buff.append("tourDetail, tour ");
			buff.append("where mt_No=? and  ");
			buff.append("tourDetail.t_No=tour.t_No) ");
			buff.append("where rownum<4");
			break;
		case 8:
			buff.append("select tDetail_No as tdno, ");
			buff.append("TourDetail.t_No as tno, ");
			buff.append("mt_No as mtno, ");
			buff.append("t_Name as name, t_img1 as img, ");
			buff.append("t_Addr as addr, ");
			buff.append("t_Theme1 as theme, ");
			buff.append("t_X as x, t_Y as y, ");
			buff.append("t_Area as area, ");
			buff.append("tDetail_Start as tdstart, ");
			buff.append("tDetail_End as tdend ");
			buff.append("from Tour, TourDetail ");
			buff.append("where TourDetail.t_No=Tour.t_No ");
			buff.append("and t_IsShow='Y' ");
			buff.append("and mt_No=? ");
			buff.append("and td_IsShow='Y' ");
			buff.append("order by tDetail_Start ");
			break;
		case 9:
			buff.append("select ");
			buff.append("count(*) as cnt, ");
			buff.append("mt_No as mtno ");
			buff.append("from TourDetail ");
			buff.append("where mt_No=? ");
			buff.append("and td_IsShow='Y' ");
			buff.append("group by mt_No ");
			break;
		case 10:
			buff.append("select mt_No as no ");
			buff.append("from MyTour ");
			buff.append("where m_No=? ");
			buff.append("and mt_IsShow='Y' ");
			break;
		}
		return buff.toString();
	}
}
