package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Sql.TourSql;
import Util.POOLUtil;
import VO.TourVO;

public class TourDAO {

	private POOLUtil db;
	private Connection con;
	public TourDAO() {
		db = new POOLUtil();
		con = db.getCon();
	}
	
	//기능 필요할 때마다 함수 추가
	//테마로 검색된 관광지 개수
	public int countTheme(String theme1) {
		String sql11=TourSql.getSQL(11);
		System.out.println("sql11="+sql11);
		int totalCount=0;
		PreparedStatement stmt = db.getSTMT(con, sql11);
		
		try {
			stmt.setString(1, theme1);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			totalCount = rs.getInt("TOT");
			db.close(rs);
		}
		catch(Exception e) {
			System.out.println("테마검색질의 개수에러="+e);
		}
		db.close(stmt);
		return totalCount;
	}
	
	
	//지역과 테마로 동시에 검색하기
	public ArrayList searchEach(String theme1, String area) {
		String sql10=TourSql.getSQL(10);
		System.out.println("sql10="+sql10);
		PreparedStatement stmt = db.getSTMT(con, sql10);
		ArrayList list = new ArrayList();
		try {
			stmt.setString(1, theme1);
			stmt.setString(2, area);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
			TourVO vo = new TourVO();
			vo.setNo(rs.getInt("NO"));
			vo.setName(rs.getString("NAME"));
			vo.setAddr(rs.getString("ADDR"));
			vo.setCon(rs.getString("CON"));
			vo.setImg1(rs.getString("IMG1"));
			vo.setImg2(rs.getString("IMG2"));
			vo.setImg3(rs.getString("IMG3"));
			vo.setImg4(rs.getString("IMG4"));
			vo.setTheme1(rs.getString("THEME1"));
			vo.setX(rs.getDouble("X"));
			vo.setTy(rs.getDouble("TY"));
			vo.setArea(rs.getString("AREA"));
			vo.setCnt(rs.getInt("CNT"));
			
			list.add(vo);
			}
			db.close(rs);
		}
		catch(Exception e){
			System.out.println("두조건 동시 질의에러="+e);
		}
		db.close(stmt);
		return list;
	}
	
	//지역으로 검색하기
	public ArrayList searchArea(String area) {
		String sql9=TourSql.getSQL(9);
		System.out.println("sql9="+sql9);
		PreparedStatement stmt = db.getSTMT(con, sql9);
		
		ArrayList list = new ArrayList();
		try {
			stmt.setString(1, area);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
			TourVO vo = new TourVO();
			vo.setNo(rs.getInt("NO"));
			vo.setName(rs.getString("NAME"));
			vo.setAddr(rs.getString("ADDR"));
			vo.setCon(rs.getString("CON"));
			vo.setImg1(rs.getString("IMG1"));
			vo.setImg2(rs.getString("IMG2"));
			vo.setImg3(rs.getString("IMG3"));
			vo.setImg4(rs.getString("IMG4"));
			vo.setTheme1(rs.getString("THEME1"));
			vo.setX(rs.getDouble("X"));
			vo.setTy(rs.getDouble("TY"));
			vo.setArea(rs.getString("AREA"));
			vo.setCnt(rs.getInt("CNT"));
			list.add(vo);
			}
			db.close(rs);
		}
		catch(Exception e) {
			System.out.println("지역별 검색질의에러="+e);
		}
		db.close(stmt);
		return list;
	}
	
	//테마로 검색하기
	public ArrayList searchTheme(String theme1) {
		
		
		String sql8=TourSql.getSQL(8);
		System.out.println("sql8="+sql8);
		PreparedStatement stmt = db.getSTMT(con, sql8);
		ArrayList list = new ArrayList();
		try {
			stmt.setString(1,theme1);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
			TourVO vo = new TourVO();
			vo.setNo(rs.getInt("NO"));
			vo.setName(rs.getString("NAME"));
			vo.setAddr(rs.getString("ADDR"));
			vo.setCon(rs.getString("CON"));
			vo.setImg1(rs.getString("IMG1"));
			vo.setImg2(rs.getString("IMG2"));
			vo.setImg3(rs.getString("IMG3"));
			vo.setImg4(rs.getString("IMG4"));
			vo.setTheme1(rs.getString("THEME1"));
			vo.setX(rs.getDouble("X"));
			vo.setTy(rs.getDouble("TY"));
			vo.setArea(rs.getString("AREA"));
			vo.setCnt(rs.getInt("CNT"));
			
			list.add(vo);
			}
			db.close(rs);
		}
		catch(Exception e) {
			System.out.println("테마별 검색질의에러="+e);
		}
		db.close(stmt);
		return list;
	}
	
	//관광지 정보 삭제하기
	public int deleteInfo(int tNo) {
		String sql6= TourSql.getSQL(6);
		System.out.println("sql6="+sql6);
		PreparedStatement stmt = db.getSTMT(con, sql6);
		int change =0;
		
		try {
			stmt.setInt(1, tNo);
			change = stmt.executeUpdate();
			System.out.println("관광지삭제 질의결과="+change);
		}
		catch(Exception e) {
			System.out.println("관광지 삭제 질의에러="+e);
		}
		db.close(stmt);
		return change;
	}
	
	//관광지 정보 수정하기

	public void updateInfo(String name, String area, String addr,String theme1,
			String img1,String img2,String img3,String img4,String tcon, double x,double y,int tNo) {
		String sql5 = TourSql.getSQL(5);
		System.out.println("sql5="+sql5);
		PreparedStatement stmt = db.getSTMT(con, sql5);
		try {
			stmt.setString(1, name);
			stmt.setString(2, area);
			stmt.setString(3, addr);
			stmt.setString(4, theme1);
			stmt.setString(5, img1);
			stmt.setString(6, img2);
			stmt.setString(7, img3);
			stmt.setString(8, img4);
			stmt.setString(9, tcon);
			stmt.setDouble(10, x);
			stmt.setDouble(11, y);
			stmt.setInt(12, tNo);
			
			stmt.executeUpdate();
		}
		catch(Exception e) {
			System.out.println("관광지정보수정 질의에러="+e);
		}
		db.close(stmt);
	}
	//관광지 수정을위한 기본정보 불러오기
	public TourVO SelectDetail(int tNo) {
		String sql3 = TourSql.getSQL(3);
		PreparedStatement stmt = db.getSTMT(con, sql3);
		TourVO vo = new TourVO();
		
		try {
			stmt.setInt(1, tNo);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			
			vo.setNo(rs.getInt("NO"));
			vo.setName(rs.getString("NAME"));
			vo.setAddr(rs.getString("ADDR"));
			vo.setCon(rs.getString("CON"));
			vo.setImg1(rs.getString("IMG1"));
			vo.setImg2(rs.getString("IMG2"));
			vo.setImg3(rs.getString("IMG3"));
			vo.setImg4(rs.getString("IMG4"));
			vo.setTheme1(rs.getString("THEME1"));
			vo.setX(rs.getDouble("X"));
			vo.setTy(rs.getDouble("TY"));
			vo.setArea(rs.getString("AREA"));
			vo.setCnt(rs.getInt("CNT"));
			db.close(rs);
		}
		catch(Exception e) {
			System.out.println("수정을위한 정보조회 에러="+e);
		}
		db.close(stmt);
		return vo;
	}
	
	
	//관광지 기본정보 질의문
	public TourVO selectDetail() {
		String sql1 = TourSql.getSQL(1);
		Statement stmt = db.getSTMT(con);
		TourVO vo = new TourVO();
		try {
				ResultSet rs = stmt.executeQuery(sql1);
				rs.next();
		
				vo.setNo(rs.getInt("NO"));
				vo.setName(rs.getString("NAME"));
				vo.setAddr(rs.getString("ADDR"));
				vo.setCon(rs.getString("CON"));
				vo.setImg1(rs.getString("IMG1"));
				vo.setImg2(rs.getString("IMG2"));
				vo.setImg3(rs.getString("IMG3"));
				vo.setImg4(rs.getString("IMG4"));
				vo.setTheme1(rs.getString("THEME1"));
				vo.setX(rs.getDouble("X"));
				vo.setTy(rs.getDouble("TY"));
				vo.setArea(rs.getString("AREA"));
				vo.setCnt(rs.getInt("CNT"));
				db.close(rs);
		}
		catch(Exception e) {
			System.out.println("관광지정보질의 실행에러"+e);
		}
		db.close(stmt);
		return vo;
	}
		public int totalCount(int totalCount) {
			return totalCount;
		}
	
		public void close() {
			db.close(con);
		}
}
