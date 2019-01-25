package Controller.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.TourSuperController;
import Sql.MemberSql;
import Util.POOLUtil;
import Util.PageUtil;
import VO.MemberVO;

public class MemberList2 implements TourSuperController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("BoardList ��Ʈ�ѷ���");
		//����
		// ������� �������� �˾Ƴ���
		String strPage = req.getParameter("nowPage");
		int nowPage = 0;
		if(strPage == null || strPage.length()==0) {
			//�Ķ���Ͱ� ����
			nowPage = 1;
		}
		else {
			nowPage = Integer.parseInt(strPage);
		}
		
		// ����Ͻ����� ����
		// ���ϵǾ��� ����� �信�� �𵨷� �����ؾ��Ѵ�
		POOLUtil db = new POOLUtil();
		Connection con = db.getCon();
		
		// ������ ������ ��������ؼ��� �ʼ������� �������������, �ѵ����Ͱ����� �˾ƾ� �Ѵ�
		// �ѵ����Ͱ��� ���ϱ�
		String sql1 = MemberSql.getSQL(MemberSql.SELECT_MEMBERCOUNT);
		System.out.println("sql1="+sql1);
		int totalCount = 0;
		
		PreparedStatement stmt1 = db.getSTMT(con,sql1);
		try {
			ResultSet rs1 = stmt1.executeQuery();
			rs1.next();
			totalCount = rs1.getInt("CNT");
			System.out.println("totalCount ="+totalCount);
			db.close(rs1);
		} catch (Exception e) {
			System.out.println("SELECT_MEMBERCOUNT ����="+e);
		}
		
		//������������ ����� ����
		//��ȭ�鿡�� 3���� �Խù��� ���̵��� �ϰ�
		//��ȭ�鿡�� 3���� ������ �̵������ ���鿹��
		PageUtil pinfo = 
				new PageUtil(nowPage,totalCount,3,3);
				
		
		//String sql = ReBoardSql.getSQL(1);
		String sql =MemberSql.getSQL(MemberSql.SELECT_MEMBERLIST);
		Statement  stmt = db.getSTMT(con);
		ArrayList  list = new ArrayList();
		
		try {
			// �Խù� ���� �˻� ���� ��ɼ����ϸ� ��� �Խù��� ���ϵǾ�����
			ResultSet rs = stmt.executeQuery(sql);
			// �ۿ��� �ʿ��� ������ ������ �信�� �����Ѵ�.
			// �ش� ������ ������ ������ �����ʹ� �ѱ��.
			int skip = (pinfo.getNowPage()-1)*pinfo.getListCount();
			
				for(int i=0; i<skip; i++) {
					rs.next();
					// ������ ���̽� �۾� �����͸� �ʿ���� �����Ϳ��� ������? ??-_-?
				}
			
				
			//4������� ��.. ����Ÿ���� ������
			// ���� ���������� ������ �����͸� ������ ����Ѵ�.
				
			//while(rs.next()) { while ���� �����ʰ� for������ �۾�ó���Ѵ�. (while �� ������ �������°� �̱� ������ for�����)
			for(int i=0; i<pinfo.getListCount() && rs.next();i++) { // �������������� listCount�� �������������� �����ʹ� 3���� �ƴϱ⶧����
																							// rs.next() �� ����Ѵ�.
				//�� ������������ �� �پ� �����Ͱ� ��µȴ�
				//�� ���� �����ʹ� VOŬ������ ����ϰ�
				MemberVO vo = new MemberVO();
				
				vo.setNo(rs.getInt("no"));
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setBam(rs.getDate("bam"));												
				vo.setCnt(rs.getInt("CNT"));
				//System.out.println(rs.getString("WRITER"));
				//System.out.println(rs.getInt("CNT"));
				
				//�� VO�� list�� �־��ش�
				list.add(vo);
				
			//}//while
			} // end 
			
			db.close(rs);
		} catch (Exception e) {
			System.out.println("SELECT_MEMBERLIST ���࿡�� ="+e);
		}
		//����� ���� Ŀ�ؼ��� �ݵ�� Ŀ�ؼ� Ǯ�� �ݳ��ؾ� ���� �۾����� Ŀ�ؼ��� ����� �� �ִ�
		db.close(stmt);
		db.close(con);
		
		//��.. �信�� MODEL�� �����Ѵٶ�� ǥ���Ѵ�
		req.setAttribute("LIST", list);
		req.setAttribute("PINFO", pinfo);
		
		// ��(������ �� �����͸� �̿��ؼ� ����� ����Ѵ�)
		return "../VIEW/Member/MemberList.jsp";
	}

}