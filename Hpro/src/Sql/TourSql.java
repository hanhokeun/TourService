package Sql;

public class TourSql {
	
	//����� ���� ����ڵ带 �Է��ϴ� ��
	//�ʿ��� ���� ���
	public static final int SELECT_TOURINFO =1;	//������ �������
	public static final int SELECT_TOTAL =2;	//�� ������ ����	
	public static final int SELECT_TOURDINFO =3;//������ �����˻�
	public static final int INSERT_TOURINFO =4;	//������ �����߰�
	public static final int UPDATE_TOURINFO =5;	//������ ���� ����
	public static final int DELETE_TOURINFO =6;	//������ ���� ����
	public static final int UPDATE_COUNT =7;	//������ ��ȸ�� ����
	public static final int SEARCH_THEME =8;	//�׸��� ������ ��ȸ
	public static final int SEARCH_AREA =9;		//������ ������ ��ȸ
	public static final int SEARCH_EACH =10;	//����+�׸� ���� ��ȸ
	public static final int TOTAL_THEME =11;	//�׸��� �˻� ��������
	public static final int TOTAL_AREA =12;	//������ �˻� ��������
	public static final int TOTAL_EACH =13;	//�׸�+������ �˻� ��������
	
	
	public static String getSQL(int code){
		
		StringBuffer buff = new StringBuffer();
		
		switch(code) {
		case 1:// ������ ���� ��ȸ ���ǹ�
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
		case 2://�� �Խù� ����
			buff.append("SELECT");
			buff.append(" COUNT(*) AS tot");
			buff.append(" FROM");
			buff.append(" Tour");
			buff.append(" WHERE");
			buff.append(" t_IsShow='Y'");
			break;
		case 3://������ ���� �󼼺���
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
