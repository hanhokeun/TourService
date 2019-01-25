package Controller.Tour;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.TourSuperController;
import Sql.TourSql;
import Util.POOLUtil;
import Util.PageUtil;
import VO.TourVO;

public class TourSearch implements TourSuperController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		//����
		
		//������� �������� �˾Ƴ���
		String strPage = req.getParameter("nowPage");
		HttpSession session = req.getSession();
		int grade=0;
		if(session.getAttribute("mId")!=null) {
			String uid = (String)session.getAttribute("mId");
			grade = (int)session.getAttribute("grade");
			System.out.println("grade="+grade);
		}else {
			grade=0;
		}
		
		int nowPage = 0;
			if(strPage==null||strPage.length()==0){
				nowPage=1;
			}
			else {
				nowPage=Integer.parseInt(strPage);
			}
			//�����Ͻ�����
			POOLUtil db = new POOLUtil();
			Connection con = db.getCon();
			//������ ������ ��������ؼ��� �ʼ������� �������������, �ѵ����Ͱ����� �˾ƾ��Ѵ�
			//�ѵ����Ͱ��� ���ϱ�
			String sql2 = TourSql.getSQL(TourSql.SELECT_TOTAL);
			System.out.println("sql2="+sql2);
			int totalCount = 0;
			
			PreparedStatement stmt2 = db.getSTMT(con,sql2);
			try {
				ResultSet rs2 = stmt2.executeQuery();
				rs2.next();
				totalCount = rs2.getInt("TOT");
				System.out.println("totalCount ="+totalCount);
				db.close(rs2);
			} 	
			catch (Exception e2) {
				System.out.println("SELECT_TOTAL ���࿡��"+e2);
			}
			
			//������������ ����� ���� ����~~~~~~~~
			//��ȭ�鿡�� 8���� �Խù��� ���̵��� �ϰ� 
			//��ȭ�鿡�� 3���� ������ �̵������ ���鿹��
			PageUtil pinfo = new PageUtil(nowPage,totalCount,8,3);
			
			//String sql = ReBoardSql.getSQL(1);
			String sql = TourSql.getSQL(TourSql.SELECT_TOURINFO);
			System.out.println("sql="+sql);
			Statement stmt = db.getSTMT(con);
			ArrayList list = new ArrayList();
			try {
				//�Խù� ���� �˻� ���� ��ɼ����ϸ� ��� �Խù��� ���ϵǾ�����
				ResultSet rs = stmt.executeQuery(sql);
				// �츮�� �� �߿��� �ʿ��� ������ ������ �信�� �����ؾ� �Ѵ�
				// �ش� ������ ������ ������ ������ ������
				int skip = (pinfo.getNowPage()-1)*pinfo.getListCount();
				
				for(int i=0;i<skip;i++) {
					rs.next();
				}
				for(int i=0;i<pinfo.getListCount() && rs.next();i++) {
					TourVO vo = new TourVO();
					vo.setNo(rs.getInt("NO"));//�˸��ƽ��� �ҹ��� ���������� �÷����� �빮�ڷ� �ν�
					vo.setName(rs.getString("NAME"));
					vo.setArea(rs.getString("AREA"));
					vo.setTheme1(rs.getString("THEME1"));
					vo.setCnt(rs.getInt("CNT"));
					vo.setImg1(rs.getString("IMG1"));			
				//�� VO�� list�� �־��ش�
				list.add(vo);
				}//for
				
				db.close(rs);
				} 	
			catch (Exception e) {
					System.out.println("SELECT_TOURINFO ���࿡�� : "+e);
			}
			db.close(stmt);
			db.close(con);
			//��
				req.setAttribute("INFO",list);
				req.setAttribute("PINFO",pinfo);
				req.setAttribute("GRADE", grade);
			//��		
				return "../VIEW/Tour/TourSearch.jsp";
			}
	
	}	
