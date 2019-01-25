package Controller.ReBoard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import Controller.TourSuperController;
import Sql.ReBoardSql;
import Util.POOLUtil;
import VO.ReBoardVO;

public class BoardDetail implements TourSuperController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		//����
		//1. �Ķ���͹ް�
		String strNo = req.getParameter("oriNo");//�۹�ȣ���
		int    oriNo = Integer.parseInt(strNo);
		
		// �Ķ���� �����̷� �Ѿ�� �����͸� ����
		String nowPage=req.getParameter("nowPage");//���������������ȣ 
		HttpSession session = req.getSession();
		
		// ���ǿ� �� ����� �� �Խù��� �۹�ȣ�� �����ؼ� ����� ���´�
		boolean isHit = false;	//��ȸ�� ������ ���������� �Ǵ��ϴ� ����
		ArrayList	list = 
				(ArrayList)session.getAttribute("SHOW");
		
		if(list==null || list.size()==0 ) {
			isHit = true;
			list = new ArrayList();
			list.add(oriNo);
			session.setAttribute("SHOW",list);
		}
		else if(list.contains(oriNo)) {
			isHit = false;
		}
		else {
			isHit = true;
			list.add(oriNo);
			session.setAttribute("SHOW",list);
		}
			
		//2. ��ȸ������.. db����..����..������Ʈ��Ʈ, ����
		POOLUtil db = new POOLUtil();
		Connection con = db.getCon();
		String sql  = 
				ReBoardSql.getSQL(ReBoardSql.UPDATE_HIT);
		System.out.println("sql="+sql);
		
		PreparedStatement stmt = db.getSTMT(con, sql);
		
		try {
			stmt.setInt(1, oriNo);
			if(isHit == true) {
				stmt.executeUpdate();
			}
		} catch (Exception e) {
			System.out.println("UPDATE_HIT���� ����="+e);
		}
		db.close(stmt);
		
		
		//3. �󼼺��⸦ �ϱ����� �ش� �������� �˻�
		String sqlD = ReBoardSql.getSQL(ReBoardSql.SELECT_DETAIL);
		System.out.println("�󼼺���sqlD="+sqlD);
		ReBoardVO vo = new ReBoardVO();//�󼼺��� ����� ������� ����	
		stmt = db.getSTMT(con, sqlD);
		try {
			stmt.setInt(1,oriNo);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			vo.setNo(rs.getInt("NO"));
			vo.setWriter(rs.getString("WRITER"));
			vo.setTitle(rs.getString("TITLE"));
			vo.setBody(rs.getString("BODY"));
			vo.setHit(rs.getInt("HIT"));
			vo.setWday(rs.getString("WDAY"));
			db.close(rs);
		} catch (Exception e) {
			System.out.println("�󼼺��� ���� ����="+e);
		}		
		db.close(stmt);
						
		//4. �ش� �ۿ� �޸� ����� �˻�
		sql = ReBoardSql.getSQL(6);
		System.out.println("��۰˻� sql="+sql);
		stmt = db.getSTMT(con, sql);
		ArrayList list1 = new ArrayList();		
		
		try {
			stmt.setInt(1,oriNo);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				//�� ���� �����͸� VO�� ����
				ReBoardVO vo1 = new ReBoardVO();
				vo1.setNo(rs.getInt("NO"));
				vo1.setOriNo(rs.getInt("ORINO"));
				vo1.setWriter(rs.getString("WRITER"));
				vo1.setTitle(rs.getString("TITLE"));
				vo1.setBody(rs.getString("BODY"));
				vo1.setWday(rs.getString("WDAY"));
				list1.add(vo1);
			}
			db.close(rs);
		}
		catch(Exception e) {
			System.out.println("��۰˻� ���� ����="+e);
		}
				
		db.close(stmt);
		db.close(con);
		
		//5. ����� �𵨷�..
		req.setAttribute("VIEW",vo); //�󼼺��� ��� ������
		req.setAttribute("REPLY",list1);//��۰˻� ��� ������
		//	�Ķ���� �����̴� ����ؼ� ���� ������ �˷��־�� �Ѵ�
		req.setAttribute("nowPage",nowPage);
		
		//��
		return "../VIEW/ReBoard/BoardDetail.jsp";
	}

}









