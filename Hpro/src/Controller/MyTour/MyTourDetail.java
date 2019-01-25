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
		//파라미터 받기
		String strMtNo=req.getParameter("mtNo"); //여행번호
		int mtNo=Integer.parseInt(strMtNo);
		String nowPage = req.getParameter("nowPage"); //여행리스트에서 받아온 릴레이용
		String strMNo = req.getParameter("mNo"); //회원번호
		int mNo = Integer.parseInt(strMNo);
		String strNp=req.getParameter("np"); //여행지 상세보기의 현페이지
		int np=0; 
		if(strNp==null||strNp.length()==0) {
			//파라미터가 없는 경우는 초기페이지를 1로 보여줌
			np=1;
		}else {
			np= Integer.parseInt(strNp);
		}
		//비즈니스로직
		MyTourDAO dao = new MyTourDAO();
		//페이지 처리를 위한 상세 여행지 리스트 총 개수 구하기
		int totalCount=dao.selectMyListDetailTotalCount(mtNo);
		PageUtil pinfo = new PageUtil(np,totalCount,3,3);
		//여행 목록 상세보기에 들어갈 리스트들(필요 관광지 정보)만 가져온 것
		ArrayList list = dao.selectMyTourDetail(mtNo,pinfo);
		//여행 이름과 전체 여행 일자 가져오기
		MyTourVO vo = dao.selectMyTourNameDate(mNo,mtNo);//버튼안의 내용
		dao.close();
		//모델
		req.setAttribute("nowPage", nowPage); //여행 리스트 릴레이용
		req.setAttribute("MNO", mNo); //회원정보
		req.setAttribute("PINFO", pinfo);  //페이징처리
		req.setAttribute("LIST", list); //여행지보기 정보들
		req.setAttribute("VO", vo); //여행이름,날짜
		//뷰
		return "../VIEW/MyTour/myTourDetail.jsp";
	}

}
