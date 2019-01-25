package Controller.MyTour;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.TourSuperController;
import DAO.MyTourDAO;
import VO.MyTourVO;

public class MyTourModifyForm implements TourSuperController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		//�Ķ���͹ޱ�
		String np=req.getParameter("np"); //������ �󼼺��� �����̿�
		String strMNo=req.getParameter("mNo");
		int mNo = Integer.parseInt(strMNo);
		String strMtNo = req.getParameter("mtNo"); //�����ȣ
		int mtNo = Integer.parseInt(strMtNo);
		String nowPage = req.getParameter("nowPage"); //���ฮ��Ʈ �����̿�
		
		//����Ͻ����� ����
		MyTourDAO dao = new MyTourDAO();
		MyTourVO vo = dao.selectMyTourNameDate(mNo, mtNo); //�����̸��� ��¥ �޾��ֱ�
		
		req.setAttribute("nowPage", nowPage);
		req.setAttribute("NP", np); //�����̿�
		req.setAttribute("MNO",mNo);
		req.setAttribute("VO", vo); 
		return "../VIEW/MyTour/myTourModifyForm.jsp";
	}

}
