package Sql;

public class MemberSql {

	public static final int SELECT_LOGIN = 51; //�α���ó��
	public static final int INSERT_MEMBER = 52;
	public static final int SELECT_MEMBER = 53;
	public static final int SELECT_MEMBERCOUNT = 54;	//�� ���۰Խù� ��
	public static final int SELECT_MEMBERLIST = 55;	//�Խù� ��� �˻�
	public static final int DELETE_MEMBERDELETE = 56;	//�Խù� ��� �˻�
	public static String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		
		switch(code) {
		
		case 56: //������ ȸ������
			buff.append("UPDATE ");
			buff.append("	MEMBER ");
			buff.append("SET ");
			buff.append("	m_IsShow='N' ");
			buff.append("WHERE ");
			buff.append("	m_id=? ");
			break;
		
		
		case 55:  //������ ȸ����� ��ȸ SELECT_MEMBERLIST
			buff.append("SELECT ");
			buff.append("(SELECT Count(m_no) FROM MEMBER) AS CNT, ");
			buff.append("	M_NO			AS	no, ");
			buff.append("	M_ID				AS	id, ");
			buff.append("	M_NAME		AS	name, ");
			buff.append("	M_BAM			AS	bam ");			
			buff.append("FROM ");
			buff.append("	MEMBER ");
			buff.append(" WHERE");
			buff.append(" m_IsShow='Y'");
			buff.append(" ORDER BY M_NO DESC");
			break;
		
		case 54:	//�� ȸ��������ϱ�
			buff.append("SELECT ");
			buff.append("	Count(m_no) AS CNT ");
			buff.append("FROM ");
			buff.append("	MEMBER");		
			break;
			
		case 53 :  // ȣ�� ���̵� ���ϱ�
			buff.append("Select ");
			buff.append("* ");
			buff.append("FROM ");
			buff.append("MEMBER ");
			buff.append("m_id=? ");
			break;
			
		case 52: //ȸ�������� ó��
			buff.append("INSERT ");
			buff.append("INTO			 ");
			buff.append("MEMBER	 ");			
			buff.append("VALUES		 ");
			buff.append("((SELECT NVL(MAX(M_NO),0)+1 FROM MEMBER),	 ");
			buff.append("?, 	");
			buff.append("?,	 ");
			buff.append("?, 	");
			buff.append("?, 	");
			buff.append("?, 	");
			buff.append("SYSDATE, ");
			buff.append("1, ");
			buff.append("?, ");
			buff.append("'Y'");
			buff.append(")");
			break;
		
		case 51:  // �α���ó��
			buff.append("SELECT m_No as mNo, ");			
			buff.append("	m_Pw AS pw, ");
			buff.append("m_Grade AS mgrade ");
			buff.append("FROM ");
			buff.append("Member ");
			buff.append("WHERE ");
			buff.append("m_Id =? ");			
			break;
		
			
			
		}
		
		return 	buff.toString();
	}	
}
