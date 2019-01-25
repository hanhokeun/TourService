package Controller.Tour;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.TourSuperController;
import Sql.TourSql;
import Util.POOLUtil;
import Util.PageUtil;
import VO.TourVO;

public class TourSearch implements TourSuperController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		//할일
		
		//보고싶은 페이지를 알아낸다
		String strPage = req.getParameter("nowPage");
		HttpSession session = req.getSession();
		int grade=0;
		if(session.getAttribute("mId")!=null) {
			String uid = (String)session.getAttribute("mId");
			grade = (int)session.getAttribute("grade");
			System.out.println("grade="+grade);
		}else {
			grade=0;
		}
		
		int nowPage = 0;
			if(strPage==null||strPage.length()==0){
				nowPage=1;
			}
			else {
				nowPage=Integer.parseInt(strPage);
			}
			//비지니스로직
			POOLUtil db = new POOLUtil();
			Connection con = db.getCon();
			//페이지 정보를 만들기위해서는 필수적으로 보고싶은페이지, 총데이터개수를 알아야한다
			//총데이터개수 구하기
			String sql2 = TourSql.getSQL(TourSql.SELECT_TOTAL);
			System.out.println("sql2="+sql2);
			int totalCount = 0;
			
			PreparedStatement stmt2 = db.getSTMT(con,sql2);
			try {
				ResultSet rs2 = stmt2.executeQuery();
				rs2.next();
				totalCount = rs2.getInt("TOT");
				System.out.println("totalCount ="+totalCount);
				db.close(rs2);
			} 	
			catch (Exception e2) {
				System.out.println("SELECT_TOTAL 실행에러"+e2);
			}
			
			//페이지정보를 만들어 놓을 예정~~~~~~~~
			//한화면에는 8개의 게시물이 보이도록 하고 
			//한화면에는 3개씩 페이지 이동기능을 만들예정
			PageUtil pinfo = new PageUtil(nowPage,totalCount,8,3);
			
			//String sql = ReBoardSql.getSQL(1);
			String sql = TourSql.getSQL(TourSql.SELECT_TOURINFO);
			System.out.println("sql="+sql);
			Statement stmt = db.getSTMT(con);
			ArrayList list = new ArrayList();
			try {
				//게시물 원글 검색 질의 명령수행하면 모든 게시물이 리턴되어진다
				ResultSet rs = stmt.executeQuery(sql);
				// 우리는 이 중에서 필요한 개수만 꺼내서 뷰에게 전달해야 한다
				// 해당 페이지 이전에 보여줄 데이터 버린다
				int skip = (pinfo.getNowPage()-1)*pinfo.getListCount();
				
				for(int i=0;i<skip;i++) {
					rs.next();
				}
				for(int i=0;i<pinfo.getListCount() && rs.next();i++) {
					TourVO vo = new TourVO();
					vo.setNo(rs.getInt("NO"));//알리아스로 소문자 지정했으나 컬럼명에서 대문자로 인식
					vo.setName(rs.getString("NAME"));
					vo.setArea(rs.getString("AREA"));
					vo.setTheme1(rs.getString("THEME1"));
					vo.setCnt(rs.getInt("CNT"));
					vo.setImg1(rs.getString("IMG1"));			
				//그 VO를 list에 넣어준다
				list.add(vo);
				}//for
				
				db.close(rs);
				} 	
			catch (Exception e) {
					System.out.println("SELECT_TOURINFO 실행에러 : "+e);
			}
			db.close(stmt);
			db.close(con);
			//모델
				req.setAttribute("INFO",list);
				req.setAttribute("PINFO",pinfo);
				req.setAttribute("GRADE", grade);
			//뷰		
				return "../VIEW/Tour/TourSearch.jsp";
			}
	
	}	
