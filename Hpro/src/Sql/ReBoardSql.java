package Sql;

//이 클래스는 질의명령을 보관..필요시 알려주는 기능을 가진 클래스

public class ReBoardSql {

	//질의명령 코드 가독성있게 부여하기 위해 코드값에 이름을 부여하자
	public static final int SELECT_BOARDLIST = 1;	//게시물 목록 검색
	public static final int SELECT_TOTALCOUNT = 2;	//총 원글게시물 수
	public static final int INSERT_ORIBOARD = 3; 	//원글등록
	public static final int UPDATE_HIT = 4;//조회수 증가
	public static final int SELECT_DETAIL = 5; //원글상세보기
	public static final int	SELECT_REPLY = 6;  //댓글상세보기~~쿼리문작성해야함~~~~
	public static final int	UPDATE_BOARD = 7;  //원글수정
	public static final int	DELETE_BOARD = 8;  //원글삭제
	public static final int UPDATE_REPLY = 9;  //댓글수정
	public static final int DELETE_REPLY = 10; //댓글삭제
	public static final int INSERT_REPLY = 11; //댓글등록
	

	
	
	public static String getSQL(int code) {
		
		StringBuffer buff = new StringBuffer();
	
		switch(code) {
		case 11: //댓글등록
			buff.append(" INSERT ");
			buff.append(" INTO ");
			buff.append("	Reply ");
			buff.append(" VALUES ");
			buff.append("	( (SELECT NVL(MAX(r_NO), 0) + 1 FROM Reply), ");
			buff.append("	 ?, ?, ?, ?, SYSDATE, 'Y',?) ");
			break;
		case 10: //댓글삭제
			buff.append("UPDATE ");
			buff.append("	reply ");
			buff.append("SET ");
			buff.append("	r_IsShow='N' ");
			buff.append("WHERE ");
			buff.append("	r_No=? ");
			buff.append("	AND ");
			buff.append("	r_Password=?");
			break;
		case 9:  //댓글수정
			buff.append("UPDATE ");
			buff.append("	REPLY ");
			buff.append("SET ");
			buff.append("	r_Title=?, ");
			buff.append("	r_Content=?, ");
			buff.append("	r_Password=? ");
			buff.append("WHERE ");
			buff.append("	r_No=?");
			break;
		case 8: //원글삭제
			buff.append("UPDATE ");
			buff.append("	reBoard ");
			buff.append("SET ");
			buff.append("	rb_IsShow='N' ");
			buff.append("WHERE ");
			buff.append("	rb_No=? ");
			buff.append("	AND ");
			buff.append("	rb_Password=?");
			break;
		case 7: //원글수정
			buff.append("UPDATE ");
			buff.append("	ReBoard ");
			buff.append("SET ");
			buff.append("	rb_Title=?, ");
			buff.append("	rb_Content=? ");
			buff.append(" WHERE ");
			buff.append("	rb_No=?");
			break;
		case 6: //댓글보기
			buff.append("SELECT ");
			buff.append("	r_No		AS 	no, ");
			buff.append("	rb_No		AS	 oriNo, ");
			buff.append("	m_Id	 AS writer, ");
			buff.append("	r_Title		AS 	title, ");
			buff.append("	r_Content	AS 	body, ");
			buff.append("	r_Date		AS 	wday ");
			buff.append("FROM ");
			buff.append("	Reply,Member ");
			buff.append(" WHERE ");
			buff.append(" Reply.m_No=Member.m_No ");
			buff.append(" and ");
			buff.append("	r_IsShow='Y' ");
			buff.append("	AND ");
			buff.append("	rb_No=? ");
			buff.append(" ORDER BY ");
			buff.append("	r_No DESC");
			break;
		case 5: //원글상세보기
			buff.append("SELECT ");
			buff.append("	rb_No AS no, ");
			buff.append("	m_Id	 AS writer, ");
			buff.append("	rb_Title	AS	 title, ");
			buff.append("	rb_Content	AS body, ");
			buff.append("	rb_Hit AS hit, ");
			buff.append("	rb_Date	AS	 wday ");
			buff.append("FROM ");
			buff.append(" ReBoard, Member ");
			buff.append("WHERE ");
			buff.append("	ReBoard.m_No=Member.m_No and ");
			buff.append("	rb_No =? ");
			buff.append("	AND ");
			buff.append("	rb_IsShow='Y' ");
			break;
		case 4:
			buff.append("UPDATE ");
			buff.append("	ReBoard ");
			buff.append("SET ");
			buff.append("	rb_Hit=rb_Hit+1 ");
			buff.append("WHERE ");
			buff.append("	rb_No=?");
			break;
		case 3: //원글등록
			buff.append("INSERT INTO ");
			buff.append("	ReBoard ");
			buff.append("VALUES((SELECT  NVL(MAX(rb_No),0)+1 FROM ReBoard), ");
			buff.append(" ?, ?, ?,SYSDATE,0,'Y',?)");
			break;
		case 2:	//총 원글게시물 수
			buff.append("select ");
			buff.append("count(*) as cnt ");
			buff.append(" from ");
			buff.append(" ReBoard ");
			buff.append(" Where ");
			buff.append(" rb_IsShow='Y' ");
			break;
		case 1:  //SELECT_BOARDLIST
			buff.append("select ReBoard.rb_No as rbno, ");
			buff.append("ReBoard.m_No as mno, ");
			buff.append("Member.m_Id as id, ");
			buff.append("ReBoard.rb_Title as title, ");
			buff.append("ReBoard.rb_Hit as hit, ");
			buff.append("ReBoard.rb_Date as wday, ");
			buff.append("NVL(rt.cnt,0) AS cnt ");
			buff.append("FROM ReBoard, ");
			buff.append("(select count(*) as cnt, rb_No from Reply group by rb_No) rt, ");
			buff.append("Member ");
			buff.append("Where ReBoard.rb_No=rt.rb_No(+) ");
			buff.append("and Member.m_No=ReBoard.m_No ");
			buff.append("and rb_IsShow='Y' ");
			buff.append("order by ReBoard.rb_No desc ");
			break;
		}
		return 	buff.toString();
	}
	
	
}
