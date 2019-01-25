package Controller.MyTour;

import java.sql.*;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.TourSuperController;
import DAO.MyTourDAO;
import Sql.MyTourSql;
import Util.POOLUtil;
import Util.PageUtil;

public class MyTourList implements TourSuperController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		//�Ķ���͹ޱ�
		String strPage=req.getParameter("nowPage");
		String strMNo= req.getParameter("mNo");
		//int mNo = Integer.parseInt(strMNo);
		int nowPage=0;
		if(strPage==null|| strPage.length()==0) {
			//�Ķ���Ͱ� ���� ���� �ʱ��������� 1�� ������
			nowPage=1;
		}else {
			nowPage= Integer.parseInt(strPage);
		}
		HttpSession session = req.getSession();
		int mNo=(int) session.getAttribute("mNo");
		//����Ͻ����� ����
		MyTourDAO dao = new MyTourDAO();
		int totalCount=dao.selectMyListTotalCount(mNo);
		//�󼼺��⿡ ���� ������ ����Ʈ ���� �޾ƿ���
		ArrayList list1 = dao.selectMyTourDetailTotalCount(mNo);
		//��������ϵ� ����¡ ó��
		PageUtil pinfo = new PageUtil(nowPage,totalCount,5,3);
		//�̸��� ��¥�� �� list
		ArrayList list2=dao.selectMyTourNameDate(pinfo,mNo); 
		//img�� �� list
		ArrayList list3=dao.selectMyTourImg(mNo); 
		dao.close();
		//��
		req.setAttribute("TOTALCOUNT", list1); //������ ���� ����
		req.setAttribute("LIST1", list2); //�̸��� ��¥
		req.setAttribute("LIST2", list3); //�̹�������Ʈ
		req.setAttribute("PINFO", pinfo); //����������
		req.setAttribute("MNO", mNo); //�α��ε� ȸ������ �Ѱ��ֱ�
		//��
		return "../VIEW/MyTour/myTourList.jsp";
	}

}
