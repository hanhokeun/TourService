package Controller.MyTour;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.TourSuperController;
import DAO.MyTourDAO;

public class MyDetailModifyProc implements TourSuperController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		String np = req.getParameter("np"); //�����̿�
		String strMNo = req.getParameter("mNo"); //ȸ����ȣ
		int mNo = Integer.parseInt(strMNo);
		String strMtNo = req.getParameter("mtNo"); //�����ȣ
		int mtNo = Integer.parseInt(strMtNo);
		String strTdNo = req.getParameter("tdNo"); //��� �󼼿�������ȣ
		int tdNo = Integer.parseInt(strTdNo);
		String nowPage = req.getParameter("nowPage"); //���ฮ��Ʈ �����̿�
		//��������
		String title=req.getParameter("title");
		String start=req.getParameter("startDate");
		String end=req.getParameter("endDate");
		
		//����Ͻ�����
		MyTourDAO dao = new MyTourDAO();
		dao.updateMyTourDetail(start, end, tdNo);
		dao.close();
		
		req.setAttribute("MNO", mNo);
		req.setAttribute("MTNO", mtNo);
		req.setAttribute("NP", np);
		req.setAttribute("TDNO", tdNo);
		req.setAttribute("nowPage", nowPage);
		
		return "../VIEW/MyTour/myDetailModifyProc.jsp";
	}

}
