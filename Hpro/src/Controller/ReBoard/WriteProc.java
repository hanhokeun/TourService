package Controller.ReBoard;

import java.sql.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.TourSuperController;
import Sql.ReBoardSql;
import Util.POOLUtil;

public class WriteProc implements TourSuperController{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		//����
		// �Ķ���͹ް�
		String title = req.getParameter("title");
		String body = req.getParameter("body");
		String pw = req.getParameter("pw");
		
		// ������ ������ �۾��̴� ���ǿ��� �޾Ƽ�  �����Ѵ�
		HttpSession session = req.getSession();
		int mNo = (int) session.getAttribute("mNo");
		// �۵�� ����..db���� insert.. ����,������Ʈ��Ʈ,����
		POOLUtil db = new POOLUtil();
		Connection con = db.getCon();
		String sql = 
		ReBoardSql.getSQL(ReBoardSql.INSERT_ORIBOARD); 	
		System.out.println("sql="+sql);
		PreparedStatement stmt = db.getSTMT(con, sql);
		
		try {
			//?ä����
			stmt.setInt(1, mNo);
			stmt.setString(2, title);
			stmt.setString(3, body);
			stmt.setString(4, pw);
			
			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("���۵�� ���� ���� ����="+e);
		}
		db.close(stmt);
		db.close(con);
		
		// ��
		
		// �� 
		return "../VIEW/ReBoard/WriteProc.jsp";
	}

}






