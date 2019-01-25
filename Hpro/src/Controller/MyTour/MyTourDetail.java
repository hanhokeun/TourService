package Controller.MyTour;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.TourSuperController;
import DAO.MyTourDAO;
import Util.PageUtil;
import VO.MyTourVO;

public class MyTourDetail implements TourSuperController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		//�Ķ���� �ޱ�
		String strMtNo=req.getParameter("mtNo"); //�����ȣ
		int mtNo=Integer.parseInt(strMtNo);
		String nowPage = req.getParameter("nowPage"); //���ฮ��Ʈ���� �޾ƿ� �����̿�
		String strMNo = req.getParameter("mNo"); //ȸ����ȣ
		int mNo = Integer.parseInt(strMNo);
		String strNp=req.getParameter("np"); //������ �󼼺����� ��������
		int np=0; 
		if(strNp==null||strNp.length()==0) {
			//�Ķ���Ͱ� ���� ���� �ʱ��������� 1�� ������
			np=1;
		}else {
			np= Integer.parseInt(strNp);
		}
		//����Ͻ�����
		MyTourDAO dao = new MyTourDAO();
		//������ ó���� ���� �� ������ ����Ʈ �� ���� ���ϱ�
		int totalCount=dao.selectMyListDetailTotalCount(mtNo);
		PageUtil pinfo = new PageUtil(np,totalCount,3,3);
		//���� ��� �󼼺��⿡ �� ����Ʈ��(�ʿ� ������ ����)�� ������ ��
		ArrayList list = dao.selectMyTourDetail(mtNo,pinfo);
		//���� �̸��� ��ü ���� ���� ��������
		MyTourVO vo = dao.selectMyTourNameDate(mNo,mtNo);//��ư���� ����
		dao.close();
		//��
		req.setAttribute("nowPage", nowPage); //���� ����Ʈ �����̿�
		req.setAttribute("MNO", mNo); //ȸ������
		req.setAttribute("PINFO", pinfo);  //����¡ó��
		req.setAttribute("LIST", list); //���������� ������
		req.setAttribute("VO", vo); //�����̸�,��¥
		//��
		return "../VIEW/MyTour/myTourDetail.jsp";
	}

}
