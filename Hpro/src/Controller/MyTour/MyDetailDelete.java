package Controller.MyTour;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.TourSuperController;
import DAO.MyTourDAO;

public class MyDetailDelete implements TourSuperController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		//�Ķ���͹ޱ�
		String np=req.getParameter("np");
		String strMNo=req.getParameter("mNo");
		int mNo = Integer.parseInt(strMNo);
		String strMtNo=req.getParameter("mtNo");
		int mtNo = Integer.parseInt(strMtNo);
		String strTdNo=req.getParameter("tdNo");
		System.out.println("np="+np);
		System.out.println("mNo="+mNo);
		System.out.println("MtNo="+mtNo);
		System.out.println("td="+strTdNo);
		int tdNo = Integer.parseInt(strTdNo);
		String nowPage=req.getParameter("nowPage");
		
		//����Ͻ����� 
		MyTourDAO dao = new MyTourDAO();
		dao.deleteMyTourDetail(mtNo, tdNo);
		dao.close();
		
		//��
		req.setAttribute("MTNO", mtNo);
		req.setAttribute("MNO", mNo);
		req.setAttribute("nowPage", nowPage); //���ฮ��Ʈ�� �����̿�
		//req.setAttribute("NP", np); //�� ������ ������ �����̿�
		
		//��
		return "../VIEW/MyTour/myDetailDelete.jsp";
	}

}
