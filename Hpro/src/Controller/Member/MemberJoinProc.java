package Controller.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.TourSuperController;
import DAO.MemberDAO;

public class MemberJoinProc implements TourSuperController{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {

		// ����
		//�ڹٺ� ����
		//�Ķ���Ͱ� �ޱ�
		String id =  req.getParameter("id");
		String pw=  req.getParameter("pw");
		String name= req.getParameter("name");		
		String birth= req.getParameter("birth");
		String email= req.getParameter("email");
		String phone= req.getParameter("phone");  		
		
		/*TourVO member = new TourVO();		
		
		member.setId(req.getParameter("user_id"));
		member.setPw(req.getParameter("user_password"));
		member.setName(req.getParameter("user_name"));
		member.setBirth(req.getParameter("user_birth"));
		member.setEmail( req.getParameter("user_email"));
		member.setPhone(req.getParameter("user_phone"));
					*/
		//����Ͻ� ���� ����
		MemberDAO dao = new MemberDAO();		
		int r = dao.MemberJoin(id, pw, name, birth, email, phone);
		
		if(r==1) { //����
			req.setAttribute("OK",r);						
		}
		else if(r==0){ //����		
			req.setAttribute("OK", r);		
		}
		// ��
				
		
		//��		
				return  "../VIEW/Member/MemberJoinProc.jsp";
		
		
		
	}

}
