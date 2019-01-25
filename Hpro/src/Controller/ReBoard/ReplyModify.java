package Controller.ReBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.TourSuperController;
import DAO.ReBoardDAO;

public class ReplyModify implements TourSuperController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		//����
		// �Ķ���� �ް�
		String strNo=req.getParameter("reNo");
		int    reNo=Integer.parseInt(strNo); //��۹�ȣ
		String title=req.getParameter("title");//�������
		String body=req.getParameter("body");//��۳���
		String pw=req.getParameter("pw");//��ۺ��
		String oriNo=req.getParameter("oriNo");//�����̿�
		String nowPage=req.getParameter("nowPage");//�����̿�
//		System.out.println("reNo ="+reNo);
//		System.out.println("pw ="+pw);
//		System.out.println("oriNo ="+oriNo);
//		System.out.println("nowPage ="+nowPage);
		
		// ��������.. DAO
		ReBoardDAO dao = new ReBoardDAO();
		dao.updateReply(reNo,title,body,pw);
		dao.close();
		
		// ��
		req.setAttribute("oriNo", oriNo);
		req.setAttribute("nowPage", nowPage);
		
		// ��
		return "../VIEW/ReBoard/ReplyModify.jsp";
	}

}
