package Controller.ReBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Controller.TourSuperController;
import DAO.ReBoardDAO;
import VO.ReBoardVO;

// ������ �ϱ����� (db���� �ش�۹�ȣ�� ������ ������ ��) ���� ���� ������ ��Ʈ�ѷ�
public class ModifyForm implements TourSuperController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("ModifyForm��Ʈ�ѷ�");
		//����
		//�Ķ���͹ޱ�
		String strNo = req.getParameter("oriNo");
		int	   oriNo = Integer.parseInt(strNo);
		System.out.println("oriNo="+oriNo);
		String	nowPage = req.getParameter("nowPage");	//�����̿�
		
		//����Ͻ����� ����..db���� �ش�۹�ȣ�� ����select
		ReBoardDAO dao = new ReBoardDAO();
		ReBoardVO vo = dao.selectDetail(oriNo);
		dao.close();
		
		//��
		req.setAttribute("BOARD", vo);
		req.setAttribute("nowPage", nowPage);
		
		//��
		return "../VIEW/ReBoard/ModifyForm.jsp";
	}

}







