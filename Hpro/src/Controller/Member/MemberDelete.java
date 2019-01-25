package Controller.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.TourSuperController;
import DAO.MemberDAO;

public class MemberDelete implements TourSuperController{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {

		//����
				//�Ķ���� �ް�
				String	  id = req.getParameter("uid");
				System.out.println("id="+id);
				String nowPage = req.getParameter("nowPage");
				
				//��������
				MemberDAO dao =new MemberDAO();
				int DELETE = dao.MemberDelete(id);							
				 //�ش��ϴ� boardDelete ���� �Խù��� �����ϱ�����
				dao.close();												// ���������� �ƴ��� �������� �����ִ� �ڵ�
				
				/*if(DELETE==1) { //����
					System.out.println("������ ��ҽ��ϴ�.");
					req.setAttribute("DELETE",DELETE);						
				}
				else if(DELETE==0){ //����		
					System.out.println("������ �������޽��ϴ�.");
					req.setAttribute("DELETE", DELETE);		
				}
				*/
				//��
				req.setAttribute("DELETE", DELETE);
				req.setAttribute("nowPage", nowPage);
				
		
		
		return "../VIEW/Member/MemberDelete.jsp";
	}

	
}
