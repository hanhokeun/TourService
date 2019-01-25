package Controller.MyTour;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.TourSuperController;
import DAO.MyTourDAO;
import Util.PageUtil;
import VO.MyTourVO;

public class MyPickForm implements TourSuperController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("MyPickForm��Ʈ�ѷ�");
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			System.out.println("���ڵ�����="+e);
		}
		//���ǿ� �α����� �Ǿ��ִٰ� ��������
		HttpSession session = req.getSession();
		int mNo=0;
		String strNo= req.getParameter("tNo"); //������ ��ȣ �ޱ�
		int tNo = Integer.parseInt(strNo);
		
		//�α����� �ȵ� ���
		if(session.getAttribute("mNo")==null) {
			mNo =0;
		}else {
			mNo=(int)session.getAttribute("mNo");			
			
			String strPage = req.getParameter("nowPage");
			int nowPage=0;
			if(strPage==null|| strPage.length()==0) {
				//�Ķ���Ͱ� ���� ���� �ʱ��������� 1�� ������
				nowPage=1;
			}else {
				nowPage= Integer.parseInt(strPage);
			}
			
			
			MyTourDAO dao = new MyTourDAO();
			System.out.println("DAO�����Ϸ�");
			//���������� �����
			int totalCount = dao.selectMyListTotalCount(mNo);
			PageUtil pinfo = new PageUtil(nowPage,totalCount,3,5); //����¡ ó���ϱ� ���� ����
			
			ArrayList list= dao.selectMyTour(mNo,pinfo); //�Ŀ� ȸ�� ��ȣ�� �Ű������� ���
			dao.close();
			
			//��
			req.setAttribute("MyTour", list); //���������� �����ֱ� ���� ����Ʈ
			req.setAttribute("PINFO", pinfo); //����¡ ó���� ����  ����
		}
		req.setAttribute("TNO", tNo); 
		req.setAttribute("MNO", mNo); //�α���Ȯ���� ���� ȸ����ȣ
		//��
		return "../VIEW/MyTour/myPickForm.jsp";
	}

}
