package Controller.Member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Controller.TourSuperController;
import DAO.MemberDAO;
import VO.MemberVO;


public class LoginProc implements TourSuperController  {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
			System.out.println("LoginProc��Ʈ�ѷ�");
			//����		
		
			// �Ķ���Ͱ� �ޱ�		
			
			//�α��� ȭ�鿡�� �Էµ� ���̵�� ��й�ȣ�� �����´�.
			String id = req.getParameter("id"); 
			System.out.println("id="+id);
			String pw = req.getParameter("pw");			
			System.out.println("pw="+pw);
			
			// ��������. DB���� ���̵�.��й�ȣ Ȯ��
			MemberDAO dao = new MemberDAO();
			//int result =dao.LoginCheck(id, pw);
			MemberVO vo = new MemberVO();
			vo=dao.LoginCheck(id, pw);
			String viewPage="";	
			dao.close();
			
			//�α��� ����
			if(vo.getChange()==1){
				HttpSession session = req.getSession();
				System.out.println("id="+id);
		        session.setAttribute("mId", id);	//���̵� ���ǿ� �־��ֱ�
		        session.setAttribute("mNo", vo.getNo()); //ȸ����ȣ �־��ֱ�
		        session.setAttribute("grade", vo.getGrade()); //ȸ�� ��޹ޱ�
				viewPage="../VIEW/Member/LoginProc.jsp";
				}
			//�������ġ
			else if(vo.getChange()==0) {
				 req.setAttribute("CHANGE",vo.getChange());
				 viewPage="../VIEW/Member/LoginForm1.jsp";
				}
			//�������� �ʴ� ���̵�	
			else{
				System.out.println("result=");
				req.setAttribute("CHANGE",vo.getChange());
				viewPage="../VIEW/Member/LoginForm1.jsp";
				}
			 return viewPage;
	}
}

