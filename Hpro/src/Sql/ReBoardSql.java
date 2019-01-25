package Sql;

//�� Ŭ������ ���Ǹ���� ����..�ʿ�� �˷��ִ� ����� ���� Ŭ����

public class ReBoardSql {

	//���Ǹ�� �ڵ� �������ְ� �ο��ϱ� ���� �ڵ尪�� �̸��� �ο�����
	public static final int SELECT_BOARDLIST = 1;	//�Խù� ��� �˻�
	public static final int SELECT_TOTALCOUNT = 2;	//�� ���۰Խù� ��
	public static final int INSERT_ORIBOARD = 3; 	//���۵��
	public static final int UPDATE_HIT = 4;//��ȸ�� ����
	public static final int SELECT_DETAIL = 5; //���ۻ󼼺���
	public static final int	SELECT_REPLY = 6;  //��ۻ󼼺���~~�������ۼ��ؾ���~~~~
	public static final int	UPDATE_BOARD = 7;  //���ۼ���
	public static final int	DELETE_BOARD = 8;  //���ۻ���
	public static final int UPDATE_REPLY = 9;  //��ۼ���
	public static final int DELETE_REPLY = 10; //��ۻ���
	public static final int INSERT_REPLY = 11; //��۵��
	

	
	
	public static String getSQL(int code) {
		
		StringBuffer buff = new StringBuffer();
	
		switch(code) {
		case 11: //��۵��
			buff.append(" INSERT ");
			buff.append(" INTO ");
			buff.append("	Reply ");
			buff.append(" VALUES ");
			buff.append("	( (SELECT NVL(MAX(r_NO), 0) + 1 FROM Reply), ");
			buff.append("	 ?, ?, ?, ?, SYSDATE, 'Y',?) ");
			break;
		case 10: //��ۻ���
			buff.append("UPDATE ");
			buff.append("	reply ");
			buff.append("SET ");
			buff.append("	r_IsShow='N' ");
			buff.append("WHERE ");
			buff.append("	r_No=? ");
			buff.append("	AND ");
			buff.append("	r_Password=?");
			break;
		case 9:  //��ۼ���
			buff.append("UPDATE ");
			buff.append("	REPLY ");
			buff.append("SET ");
			buff.append("	r_Title=?, ");
			buff.append("	r_Content=?, ");
			buff.append("	r_Password=? ");
			buff.append("WHERE ");
			buff.append("	r_No=?");
			break;
		case 8: //���ۻ���
			buff.append("UPDATE ");
			buff.append("	reBoard ");
			buff.append("SET ");
			buff.append("	rb_IsShow='N' ");
			buff.append("WHERE ");
			buff.append("	rb_No=? ");
			buff.append("	AND ");
			buff.append("	rb_Password=?");
			break;
		case 7: //���ۼ���
			buff.append("UPDATE ");
			buff.append("	ReBoard ");
			buff.append("SET ");
			buff.append("	rb_Title=?, ");
			buff.append("	rb_Content=? ");
			buff.append(" WHERE ");
			buff.append("	rb_No=?");
			break;
		case 6: //��ۺ���
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
		case 5: //���ۻ󼼺���
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
		case 3: //���۵��
			buff.append("INSERT INTO ");
			buff.append("	ReBoard ");
			buff.append("VALUES((SELECT  NVL(MAX(rb_No),0)+1 FROM ReBoard), ");
			buff.append(" ?, ?, ?,SYSDATE,0,'Y',?)");
			break;
		case 2:	//�� ���۰Խù� ��
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
