package Controller.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.TourSuperController;
import Sql.MemberSql;
import Util.POOLUtil;
import Util.PageUtil;
import VO.MemberVO;

public class MemberList2 implements TourSuperController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("BoardList 컨트롤러다");
		//할일
		// 보고싶은 페이지를 알아낸다
		String strPage = req.getParameter("nowPage");
		int nowPage = 0;
		if(strPage == null || strPage.length()==0) {
			//파라미터가 없다
			nowPage = 1;
		}
		else {
			nowPage = Integer.parseInt(strPage);
		}
		
		// 비즈니스로직 수행
		// 리턴되어진 결과를 뷰에게 모델로 전달해야한다
		POOLUtil db = new POOLUtil();
		Connection con = db.getCon();
		
		// 페이지 정보를 만들기위해서는 필수적으로 보고싶은페이지, 총데이터개수를 알아야 한다
		// 총데이터개수 구하기
		String sql1 = MemberSql.getSQL(MemberSql.SELECT_MEMBERCOUNT);
		System.out.println("sql1="+sql1);
		int totalCount = 0;
		
		PreparedStatement stmt1 = db.getSTMT(con,sql1);
		try {
			ResultSet rs1 = stmt1.executeQuery();
			rs1.next();
			totalCount = rs1.getInt("CNT");
			System.out.println("totalCount ="+totalCount);
			db.close(rs1);
		} catch (Exception e) {
			System.out.println("SELECT_MEMBERCOUNT 에러="+e);
		}
		
		//페이지정보를 만들어 놓자
		//한화면에는 3개의 게시물이 보이도록 하고
		//한화면에는 3개씩 페이지 이동기능을 만들예정
		PageUtil pinfo = 
				new PageUtil(nowPage,totalCount,3,3);
				
		
		//String sql = ReBoardSql.getSQL(1);
		String sql =MemberSql.getSQL(MemberSql.SELECT_MEMBERLIST);
		Statement  stmt = db.getSTMT(con);
		ArrayList  list = new ArrayList();
		
		try {
			// 게시물 원글 검색 질의 명령수행하면 모든 게시물이 리턴되어진다
			ResultSet rs = stmt.executeQuery(sql);
			// 글에서 필요한 개수만 꺼내서 뷰에게 전달한다.
			// 해당 페이지 이전에 보여줄 데이터는 넘긴다.
			int skip = (pinfo.getNowPage()-1)*pinfo.getListCount();
			
				for(int i=0; i<skip; i++) {
					rs.next();
					// 데이터 베이스 작업 포인터를 필요없는 데이터에서 내린다? ??-_-?
				}
			
				
			//4번방식의 모델.. 여러타입의 여러개
			// 현재 페이지에서 보여줄 데이터만 꺼내서 사용한다.
				
			//while(rs.next()) { while 문을 쓰지않고 for문으로 작업처리한다. (while 은 무조건 가져오는것 이기 때문에 for문사용)
			for(int i=0; i<pinfo.getListCount() && rs.next();i++) { // 한페이지보여줄 listCount와 마지막페이지에 데이터는 3개가 아니기때문에
																							// rs.next() 를 사용한다.
				//한 바퀴돌때마다 한 줄씩 데이터가 출력된다
				//한 줄의 데이터는 VO클래스로 기억하고
				MemberVO vo = new MemberVO();
				
				vo.setNo(rs.getInt("no"));
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setBam(rs.getDate("bam"));												
				vo.setCnt(rs.getInt("CNT"));
				//System.out.println(rs.getString("WRITER"));
				//System.out.println(rs.getInt("CNT"));
				
				//그 VO를 list에 넣어준다
				list.add(vo);
				
			//}//while
			} // end 
			
			db.close(rs);
		} catch (Exception e) {
			System.out.println("SELECT_MEMBERLIST 실행에러 ="+e);
		}
		//사용이 끝난 커넥션은 반드시 커넥션 풀에 반납해야 다음 작업에서 커넥션을 사용할 수 있다
		db.close(stmt);
		db.close(con);
		
		//모델.. 뷰에게 MODEL을 전달한다라고 표현한다
		req.setAttribute("LIST", list);
		req.setAttribute("PINFO", pinfo);
		
		// 뷰(에서는 이 데이터를 이용해서 목록을 출력한다)
		return "../VIEW/Member/MemberList.jsp";
	}

}