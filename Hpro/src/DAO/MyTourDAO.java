package DAO;

import java.sql.*;
import java.util.*;

import Sql.MyTourSql;
import Util.POOLUtil;
import Util.PageUtil;
import VO.MyTourVO;

public class MyTourDAO {

	//private static final String Integer = null;
	private POOLUtil db;
	private Connection con;
	public MyTourDAO() {
		db= new POOLUtil();
		con = db.getCon();
	}
	//상세 여행 일정 수정하기
	public void updateMyTourDetail(String start, String end, int tdNo) {
		String sql = MyTourSql.getSQL(MyTourSql.UPDATE_DETAILDATE);
		System.out.println("상세 여행지 일정 수정하기 sql="+sql);
		PreparedStatement stmt = db.getSTMT(con, sql);
		try {
			stmt.setString(1, start);
			stmt.setString(2, end);
			stmt.setInt(3, tdNo);
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("상세 여행지 일정 수정 질의문 실행 에러="+e);
		}
		db.close(stmt);
	}
	//상세 여행지 삭제하기
	public void deleteMyTourDetail(int mtNo, int tdNo) {
		String sql = MyTourSql.getSQL(MyTourSql.DELETE_MYTOURDETAIL);
		System.out.println("상세 여행지 삭제하기 sql="+sql);
		PreparedStatement stmt = db.getSTMT(con, sql);
		try {
			stmt.setInt(1, mtNo);
			stmt.setInt(2, tdNo);
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("상세 여행지 삭제하기 질의문 실행 에러="+e);
		}
		db.close(stmt);
	}
	//내 여행 삭제하기
	public int deleteMyTourList(int mtNo, int mNo) {
		String sql = MyTourSql.getSQL(MyTourSql.DELETE_MYTOURLIST);
		System.out.println("내 여행 삭제하기 sql="+sql);
		PreparedStatement stmt = db.getSTMT(con, sql);
		int change=0;
		try {
			stmt.setInt(1,mtNo);
			stmt.setInt(2,mNo);
			change=stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("내 여행 삭제하기 질의문 실행 에러="+e);
		}
		db.close(stmt);
		return change;
	}
	//상세 여행지의 일정 검색
	public MyTourVO selectDetailNameDate(int tdNo) {
		String sql = MyTourSql.getSQL(MyTourSql.SELECT_DETAILNANEDATE);
		System.out.println("상세 여행지의 이름과 날짜 조회 sql="+sql);
		PreparedStatement stmt = db.getSTMT(con, sql);
		MyTourVO vo = new MyTourVO();
		try {
			stmt.setInt(1, tdNo);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			vo.setTdNo(tdNo);
			vo.setName(rs.getString("name"));
			vo.setStart(rs.getString("tdstart"));
			vo.setEnd(rs.getString("tdend"));
			db.close(rs);
		} catch (Exception e) {
			System.out.println("상세 여행지의 이름과 날짜 조회 질의문 실행 에러="+e);
		}
		db.close(stmt);
		return vo; 
	}
	//각 여행의 이름과 날짜 수정 함수
	public int updateMyTourNameDate(String name, String start, String end,int mtNo, int mNo) {
		String sql = MyTourSql.getSQL(MyTourSql.UPDATE_MYTOURNAMEDATE);
		System.out.println("해당 여행의 이름과 날짜 수정 sql="+sql);
		PreparedStatement stmt = db.getSTMT(con, sql);
		int change=0;
		try {
			stmt.setString(1, name);
			stmt.setString(2, start);
			stmt.setString(3, end);
			stmt.setInt(4, mtNo);
			stmt.setInt(5, mNo);
			change=stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("해당 여행의 이름과 날짜 수정 질의문 실행 에러="+e);
		}
		db.close(stmt);
		return change;
	}
	//여행의 날짜 수정에 따른 상세 여행지 시작날짜 수정함수
	public void updateTourDetailStart(String start,String end,int mtNo) {
		String sql = MyTourSql.getSQL(MyTourSql.SELECT_DETAILSTART);
		System.out.println("상세 여행지 시작날짜 조회sql="+sql);
		PreparedStatement stmt = db.getSTMT(con, sql);
		try {
			stmt.setInt(1, mtNo);
			stmt.setString(2, start);
			stmt.setString(3, end);
			ResultSet rs = stmt.executeQuery();
			System.out.println("rs.next()전");
			if(rs.next()) {
				System.out.println("rs.next()후");
				String sql1= MyTourSql.getSQL(MyTourSql.UPDATE_DETAILSTART);
				System.out.println("여행일자 수정에 따른 상세여행지 시작날짜 수정 sql1="+sql1);
				PreparedStatement stmt1 = db.getSTMT(con, sql1);
				stmt1.setString(1, start);
				stmt1.setInt(2, mtNo);
				stmt1.setString(3, start);
				stmt1.setString(4, end);
				int stmt1Result=stmt1.executeUpdate();
				System.out.println("stmt1Result="+stmt1Result);
				db.close(stmt1);
			}
			db.close(rs);
		} catch (Exception e) {
			System.out.println("여행 날짜 수정에 따른 상세여행지 시작날짜 수정 질의문  실행 에러="+e);
		}
		db.close(stmt);
	}
	//여행의 날짜 수정에 따른 상세 여행지 종료날짜 수정함수
	public void updateTourDetailEnd(String end,String start,int mtNo) {
		String sql = MyTourSql.getSQL(MyTourSql.SELECT_DETAILEND);
		System.out.println("상세 여행지 종료날짜 조회sql="+sql);
		PreparedStatement stmt = db.getSTMT(con, sql);
		try {
			stmt.setInt(1, mtNo);
			stmt.setString(2, end);
			stmt.setString(3, start);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				String sql1= MyTourSql.getSQL(MyTourSql.UPDATE_DETAILEND);
				PreparedStatement stmt1 = db.getSTMT(con, sql1);
				stmt1.setString(1, end);
				stmt1.setInt(2, mtNo);
				stmt1.setString(3, end);
				stmt1.setString(4, start);
				stmt1.executeUpdate();
				db.close(stmt1);
			}
			db.close(rs);
		} catch (Exception e) {
			System.out.println("여행 날짜 수정에 따른 상세여행지 시작날짜 수정 질의문  실행 에러="+e);
		}
		db.close(stmt);
	}
	//해당 여행의 이름과 날짜 검색 함수 ->페이징 처리 없음(수정폼과 상세보기에서 사용)
	public MyTourVO selectMyTourNameDate(int mNo, int mtNo) {
		String sql = MyTourSql.getSQL(MyTourSql.SELECT_MYTOURNAMEDATE);
		System.out.println("해당 여행의 이름과 날짜 검색 sql="+sql);
		PreparedStatement stmt = db.getSTMT(con, sql);
		MyTourVO vo = new MyTourVO();
		try {
			stmt.setInt(1, mNo);
			stmt.setInt(2, mtNo);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			vo.setMtNo(rs.getInt("no"));
			vo.setName(rs.getString("name"));
			vo.setStart(rs.getString("mtstart"));
			vo.setEnd(rs.getString("mtend"));
			db.close(rs);
		} catch (Exception e) {
			System.out.println("해당 여행 이름과 날짜 검색 질의문 실행 에러="+e);
		}
		db.close(stmt);
		return vo;
	}
	//나의 여행지 상세보기 검색 함수
	public ArrayList selectMyTourDetail(int mtNo,PageUtil pinfo) {
		String sql = MyTourSql.getSQL(MyTourSql.SELECT_MYTOURDETAIL);
		System.out.println("나의 여행지 상세보기 검색 함수sql="+sql);
		PreparedStatement stmt = db.getSTMT(con, sql);
		ArrayList list = new ArrayList();
		try {
			stmt.setInt(1, mtNo);
			ResultSet rs = stmt.executeQuery();
			int skip = (pinfo.getNowPage()-1)*pinfo.getListCount();
			for(int i=0; i<skip; i++) {
				rs.next(); 
			}
			for(int i=0; i<pinfo.getListCount()&&rs.next();i++) {
				MyTourVO vo = new MyTourVO();
				vo.setTdNo(rs.getInt("tdno"));
				vo.setNo(rs.getInt("tno"));
				vo.setMtNo(rs.getInt("mtno"));
				vo.setName(rs.getString("name"));
				vo.setImg1(rs.getString("img"));
				vo.setAddress(rs.getString("addr"));
				vo.setTheme1(rs.getString("theme"));
				vo.setX(rs.getString("x"));
				vo.setY(rs.getString("y"));
				vo.setArea(rs.getString("area"));
				vo.setStart(rs.getString("tdstart"));
				vo.setEnd(rs.getString("tdend"));
				list.add(vo);
			}
			db.close(rs);
		} catch (SQLException e) {
			System.out.println("나의 여행 상세보기 질의문 실행 에러="+e);
		}
		db.close(stmt);
		return list;
	}
	//찜하기에서 여행목록 보여주기 함수
	public ArrayList selectMyTour(int mNo, PageUtil pinfo) {
		String sql = MyTourSql.getSQL(MyTourSql.SELECT_TOURLIST);
		System.out.println("sql="+sql+','+mNo);
		PreparedStatement stmt = db.getSTMT(con, sql);
		ArrayList list = new ArrayList();
		try {
			stmt.setInt(1, mNo);
			ResultSet rs = stmt.executeQuery();
			int skip = (pinfo.getNowPage()-1)*pinfo.getListCount();
			for(int i=0; i<skip; i++) {
				rs.next(); 
			}
			for(int i=0; i<pinfo.getListCount()&&rs.next();i++) {
				MyTourVO vo = new MyTourVO();
				vo.setNo(rs.getInt("no"));
				vo.setName(rs.getString("name"));
				System.out.println("여행번호="+rs.getInt("no"));
				System.out.println("여행이름="+rs.getString("name"));
				list.add(vo);
			}
			db.close(rs);
		} catch (Exception e) {
			System.out.println("여행 리스트 불러오기 에러="+e);
		}
		db.close(stmt);
		return list;
	}
	//내여행추가하기 함수 
	public void insertTourList(int mNo,String Name,String start, String end) {
		String sql = MyTourSql.getSQL(MyTourSql.INSERT_TOURNAME);
		System.out.println("여행추가sql="+sql);
		PreparedStatement stmt = db.getSTMT(con, sql);
		try {
			stmt.setInt(1, mNo);
			stmt.setString(2, Name);
			stmt.setString(3, start);
			stmt.setString(4, end);
			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("여행 추가하기 질의 실행 에러="+e);
		}
		db.close(stmt);
	}
	//내 여행지 찜하기 함수
	public int insertMyPick(int mtNo,int tNo, int mNo,String mtName) {
		//먼저 찜을 했는 지에 대한 여부에 대하여 알아본다
		int kind=0;
		//없는 경우에 0, 있는 경우에는 1
		String sql = MyTourSql.getSQL(MyTourSql.SELECT_MYPICK);
		System.out.println("여행지 등록 여부 검색 질의문 ="+sql);
		PreparedStatement stmt = db.getSTMT(con, sql);
		int change = 0; //찜하기 등록여부 확인시켜주기 위해 -> 실행되었다면 1, 아니라면 0
		try {
			stmt.setInt(1, mtNo);
			stmt.setInt(2, mNo);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				if(tNo==rs.getInt("tno")) {
					kind=1;     //이미찜
					db.close(rs);
					System.out.println("kind="+kind);
				}
				else{
					kind=0;
					db.close(rs);
				}
			}
		} catch (Exception e) {
			System.out.println("찜하기 목록 여부 불러오기 에러 ="+e);
		}

		if(kind==0) {
			String sql1= MyTourSql.getSQL(MyTourSql.INSERT_MYPICK);
			PreparedStatement stmt1 = db.getSTMT(con, sql1);			
			System.out.println("여행지 등록 질의문 ="+sql1);
			try {
				System.out.println("tNo="+tNo);
				System.out.println("mtNo="+mtNo);
				stmt1.setInt(1, tNo);
				stmt1.setInt(2, mtNo);
				stmt1.setInt(3, mtNo);
				stmt1.setInt(4, mNo);
				stmt1.setInt(5, mtNo);
				stmt1.setInt(6, mNo);
				change=stmt1.executeUpdate();
				db.close(stmt1);
				System.out.println("try안의 change="+change);
			} catch (Exception e) {
				System.out.println("여행지 등록하기 질의 실행 에러="+e);
			}
		}
		else {
			change=0;
		}
		db.close(stmt);
		return change;
	}
	//나의 여행 리스트의 이름과 날짜 가져와 보여주기 ->페이징 처리(여행리스트에서 보여주기)
	public ArrayList selectMyTourNameDate(PageUtil pinfo, int mNo) {
		String sql = MyTourSql.getSQL(MyTourSql.SELECT_MYTOURTOTALNAMEDATE);
		System.out.println("나의 여행,날짜 목록 조회하기 질의문 ="+sql);
		PreparedStatement stmt = db.getSTMT(con, sql);
		//페이지 정보만들기 -> 한 화면에 6개까지 넘기기는 5쪽까지 표현
		ArrayList list = new ArrayList();
		try {
			stmt.setInt(1, mNo);
			//여행 리스트 검색 질의 명령 수행 뒤 모든 게시물 리턴되어짐
			ResultSet rs = stmt.executeQuery();
			//필요한 개수만 꺼내서 뷰에서 전달 -> 이전 페이지의 데이터들 버리고 현데이터가 있는 페이지 보여줌
			int skip = (pinfo.getNowPage()-1)*pinfo.getListCount();
			for(int i=0; i<skip; i++) {
				rs.next(); 
			}
			for(int i=0; i<pinfo.getListCount()&&rs.next();i++) {
				MyTourVO vo = new MyTourVO();
				vo.setNo(rs.getInt("no"));
				vo.setName(rs.getString("name"));
				vo.setStart(rs.getString("mtstart"));
				vo.setEnd(rs.getString("mtend"));
				//vo를 list에 넣어주기
				list.add(vo);
			}
			db.close(rs);
		} catch (Exception e) {
			System.out.println("여행리스트 불러오기 에러="+e);
		}
		db.close(stmt);
		return list;
	}
	//나의 여행목록의 총 개수를 검색
	public int selectMyListTotalCount(int mNo) {
		String sql = MyTourSql.getSQL(MyTourSql.SELECT_MYTOURTOTALCOUNT);
		System.out.println("나의 총 여행목록리스트 검색 질의문="+sql);
		int totalCount=0;
		PreparedStatement stmt = db.getSTMT(con,sql);
		try {
			stmt.setInt(1, mNo);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			totalCount=rs.getInt("cnt");
			System.out.println("totalCount"+totalCount);
			db.close(rs);
		} catch (Exception e) {
			System.out.println("나의 총 여행목록리스트 수 불러오기 에러="+e);
		}
		db.close(stmt);
		return totalCount;
	}
	//찜한 여행 갯수 구하기
	public ArrayList selectMyTourDetailTotalCount(int mNo) {
		String sql = MyTourSql.getSQL(MyTourSql.SELECT_MTNO); //여행번호 구하기
		System.out.println("여행번호구하기 ="+sql);
		PreparedStatement stmt = db.getSTMT(con,sql);
		int mtNo=0;
		ArrayList list = new ArrayList();
		try {
			stmt.setInt(1, mNo);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				mtNo = rs.getInt("no");
				String sql1 = MyTourSql.getSQL(MyTourSql.SELECT_MYTOURDETAILTOTALCOUNT);//찜한 여행지 갯수 구하기
				PreparedStatement stmt1 = db.getSTMT(con, sql1);
				stmt1.setInt(1, mtNo);
				ResultSet rs1 = stmt1.executeQuery();
				while(rs1.next()) {
					MyTourVO vo = new MyTourVO();
					vo.setCount(rs1.getInt("cnt"));
					vo.setMtNo(rs1.getInt("mtNo"));
					list.add(vo);
				}
				db.close(rs1);
				db.close(stmt1);
			}
			db.close(rs);
		} catch (Exception e) {
			System.out.println("총 여행지 개수 구하기 오류="+e);
		}
		db.close(stmt);
		return list;
	}
	//나의 여행 리스트의 사진 가져오기
	public  ArrayList selectMyTourImg(int mNo) {
		String sql = MyTourSql.getSQL(MyTourSql.SELECT_MTNO); //여행번호 구하기
		PreparedStatement stmt = db.getSTMT(con,sql);
		int mtNo=0;
		ArrayList list = new ArrayList();
		try {
			stmt.setInt(1, mNo);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				mtNo = rs.getInt("no");
				String sql1 = MyTourSql.getSQL(MyTourSql.SELECT_MYTOURIMG);//찜한 이미지의 첫번째 검색
				System.out.println("찜한 이미지의 첫번째 이미지 찾아내기 sql="+sql1);
				PreparedStatement stmt1 = db.getSTMT(con, sql1);
				stmt1.setInt(1, mtNo);
				ResultSet rs1 = stmt1.executeQuery();
				while(rs1.next()) {
					MyTourVO vo = new MyTourVO();
					vo.setNo(rs1.getInt("rownum")); //순서번호
					vo.setMtNo(rs1.getInt("no")); //여행번호
					vo.setTNo(rs1.getInt("tNo")); //상세여행지번호
					vo.setImg1(rs1.getString("img"));//이미지명
					System.out.println(rs1.getInt("rownum"));
					System.out.println(rs1.getInt("no"));
					System.out.println(rs1.getInt("tNo"));
					System.out.println(rs1.getString("img"));
					list.add(vo);
				}
				db.close(rs1);
				db.close(stmt1);
			}
			db.close(rs);
		} catch (Exception e) {
			System.out.println("찜한 이미지의 첫번째 이미지 찾아내기 질의문 실행 에러="+e);
		}
		db.close(stmt);
		return list;
	}
	//나의 여행 상세보기 목록 보여주기
	public ArrayList selectMyTourDetail(int mtNo) {
		String sql= MyTourSql.getSQL(MyTourSql.SELECT_MYTOURDETAIL);
		System.out.println("나의 여행 상세보기 목록 질의문="+sql);
		PreparedStatement stmt = db.getSTMT(con, sql);
		ArrayList list = new ArrayList();
		try {
			stmt.setInt(1, mtNo);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				MyTourVO vo = new MyTourVO();
				vo.setTdNo(rs.getInt("tdno"));
				vo.setTNo(rs.getInt("tno"));
				vo.setMtNo(rs.getInt("mtno"));
				vo.setName(rs.getString("name"));
				vo.setImg1(rs.getString("img"));
				vo.setAddress(rs.getString("addr"));
				vo.setTheme1(rs.getString("theme"));
				vo.setX(rs.getString("x"));
				vo.setArea(rs.getString("area"));
				list.add(vo);
			}
			db.close(rs);
		} catch (Exception e) {
			System.out.println("나의 여행 상세 목록 보여주기 에러="+e);
		}
		db.close(con);
		return list;
	}
	//페이지 처리를 위한 상세 여행지 리스트 총 개수 구하기
	public int selectMyListDetailTotalCount(int mtNo) {
		String sql = MyTourSql.getSQL(MyTourSql.SELECT_MYTOURDETAILTOTALCOUNT);
		System.out.println("나의  상세여행지 총 목록리스트 개수 검색 질의문="+sql);
		int totalCount=0;
		PreparedStatement stmt = db.getSTMT(con,sql);
		try {
			stmt.setInt(1,mtNo);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				totalCount=rs.getInt("cnt");
				System.out.println(rs.getInt("cnt"));
			}else {
				totalCount=0;
			}
			db.close(rs);
		} catch (Exception e) {
			System.out.println("나의 상세 여행지 리스트 총 개수 불러오기 에러="+e);
		}
		db.close(stmt);
		return totalCount;
	}
	//커넥션을 닫아줄 함수
	public void close() {
		db.close(con);
	}
}
