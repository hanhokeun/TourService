package Controller.Tour;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.TourSuperController;
import DAO.TourDAO;
import Sql.TourSql;
import VO.TourVO;
import Util.*;

public class TourInfo implements TourSuperController  {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		//����
		POOLUtil db = new POOLUtil();
		Connection con = db.getCon();
		
		TourVO vo2 = new TourVO();
		HttpSession session = req.getSession();
		int grade=0;
		if(session.getAttribute("mId")!=null) {
			String uid = (String)session.getAttribute("mId");
			grade = (int)session.getAttribute("grade");
		}else {
			grade=0;
		}
		//�Ķ���� �ް�
		String nowPage = req.getParameter("nowPage");
		System.out.println(nowPage);
		String strNo = req.getParameter("tNo");
		System.out.println(strNo);
		int tNo = Integer.parseInt(strNo);
		
		
		//��ȸ�� ����
		String sql7= TourSql.getSQL(7);
		System.out.println("sql7="+sql7);
		PreparedStatement stmt2 = db.getSTMT(con, sql7);
		
		TourVO vo1 = new TourVO();
		
		try {
			//���ǿ� �� ����� �� �Խù��� �۹�ȣ�� �����ؼ� ����� ���´�
			boolean isHit = false;	//��ȸ�� ������ ���� ������ �Ǵ��ϴ� ����
			ArrayList list = (ArrayList)session.getAttribute("SHOW");
			if(list==null || list.size()==0) {
				// �� ���� � �۵� ������ ����
				// �� ����� ��ȸ���� �������Ѿ� �Ѵ�
				isHit = true;
				list= new ArrayList();	//�ּҰ� ���
				list.add(tNo);
				session.setAttribute("SHOW",list);
			}
			else if(list.contains(tNo)) {
				//�̻���� �� ���� ������ �����Ƿ� ��ȸ���� ����x
				isHit = false;
			}
			else {
				//�� ����� �ٸ� ���� �þ ���� ���� ������ ���� ��� ��ȸ�� ����
				isHit=true;
				list.add(tNo);
				session.setAttribute("SHOW",list);
			}
			
			//�ش� �۹�ȣ�� rb_Hit�÷��� �����͸� 
			//��ȸ�� ������ �ص� �Ǵ� ����� ������Ų��
			//���� � ����� �ٽ� �Խù��� ������ �ϸ�
			//���� ���ǿ� �̹� �� �Խù� ��ȣ�� Ȯ���Ͽ���
			//�����ϸ� ��ȸ���� ������ ��������
			//�������� ������ ��ȸ�� ����
			
			stmt2.setInt(1,tNo);
			//�ش� �۹�ȣ�� �÷��� �����͸� ��ȸ�� ������ �ص� �Ǵ� ����� ������Ų��
			if(isHit==true) {
			stmt2.executeUpdate();
			}
		} catch (Exception e) {
			System.out.println("��ȸ������ ����="+e);
		}
		
		
		
		
		//�󼼺��⸦���� ������ ���� �˻�
		//������ ��ȣ�� �´� ������ ������ ������ ����
		String sql2 = TourSql.getSQL(3);
		System.out.println("�������������ǹ�="+sql2);
		PreparedStatement stmt = db.getSTMT(con, sql2);
		try {
			stmt.setInt(1,tNo);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			vo2.setNo(rs.getInt("NO"));
			vo2.setName(rs.getString("NAME"));
			vo2.setArea(rs.getString("AREA"));
			vo2.setTheme1(rs.getString("THEME1"));
			vo2.setCnt(rs.getInt("CNT"));
			vo2.setImg1(rs.getString("IMG1"));
			vo2.setImg2(rs.getString("IMG2"));
			vo2.setImg3(rs.getString("IMG3"));
			vo2.setImg4(rs.getString("IMG4"));
			vo2.setAddr(rs.getString("ADDR"));
			vo2.setCon(rs.getString("CON"));
			vo2.setX(rs.getDouble("X"));
			vo2.setTy(rs.getDouble("TY"));
			db.close(rs);
		}
		catch(Exception e) {
			System.out.println("������ ������ȸ ���࿡��="+e);
		}
		db.close(stmt);
		db.close(con);
		//��
		req.setAttribute("VIEW",vo2);
		req.setAttribute("nowPage",nowPage);
		req.setAttribute("GRADE", grade);
		//��
		return "../VIEW/Tour/TourInfo.jsp";
	}

}
