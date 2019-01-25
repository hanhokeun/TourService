package Controller.ReBoard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.TourSuperController;
import DAO.ReBoardDAO;
import Sql.ReBoardSql;
import Util.POOLUtil;
import Util.PageUtil;
import VO.ReBoardVO;

public class BoardList implements TourSuperController{
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		//����
		HttpSession session = req.getSession();
		int grade=0;
		if(session.getAttribute("mId")!=null) {
			String mid = (String)session.getAttribute("mId");
			grade = (int)session.getAttribute("grade");
		}else {
			grade=0;
		}
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
		ReBoardDAO dao = new ReBoardDAO();
		
		int totalCount = dao.selectTotalCount();// �ѵ����Ͱ��� ���ϱ�
		PageUtil pinfo = new PageUtil(nowPage,totalCount,5,3); //������� ���� ������ ������ ���� ����
				
		ArrayList list=dao.selectBoardList(pinfo); //�� ����Ʈ ���ϱ�
		dao.close();
		
		//��
		req.setAttribute("LIST", list);
		req.setAttribute("PINFO", pinfo);
		req.setAttribute("GRADE", grade);
		// ��(������ �� �����͸� �̿��ؼ� ����� ����Ѵ�)
		return "../VIEW/ReBoard/BoardList.jsp";
	}

}







