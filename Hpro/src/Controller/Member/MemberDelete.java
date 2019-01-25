package Controller.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.TourSuperController;
import DAO.MemberDAO;

public class MemberDelete implements TourSuperController{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {

		//할일
				//파라미터 받고
				String	  id = req.getParameter("uid");
				System.out.println("id="+id);
				String nowPage = req.getParameter("nowPage");
				
				//로직수행
				MemberDAO dao =new MemberDAO();
				int DELETE = dao.MemberDelete(id);							
				 //해당하는 boardDelete 에서 게시물을 삭제하기위해
				dao.close();												// 삭제성공이 됐는지 유저에게 보여주는 코드
				
				/*if(DELETE==1) { //성공
					System.out.println("삭제를 담았습니다.");
					req.setAttribute("DELETE",DELETE);						
				}
				else if(DELETE==0){ //실패		
					System.out.println("삭제를 담지못햇습니다.");
					req.setAttribute("DELETE", DELETE);		
				}
				*/
				//모델
				req.setAttribute("DELETE", DELETE);
				req.setAttribute("nowPage", nowPage);
				
		
		
		return "../VIEW/Member/MemberDelete.jsp";
	}

	
}
