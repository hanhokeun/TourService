package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Sql.MemberSql;
import Util.POOLUtil;
import VO.MemberVO;

public class MemberDAO {
	
	private POOLUtil db;
	private Connection con;	
	
	public MemberDAO() {
		db = new POOLUtil();
		con = db.getCon();
	}
	
	
	//기능을 필요할 때마다 (함수)추가
	//관리자 회원 추방	//
			public int MemberDelete(String id) {
				String sql = MemberSql.getSQL(MemberSql.DELETE_MEMBERDELETE);
				PreparedStatement stmt = db.getSTMT(con, sql);
				int change = 0;
				
				try {
					stmt.setString(1, id);
					
					// update질의명령을 실행한 후 변화된 데이터 개수를 알아내서
					//	1이면 한개가 수정된 것이고
					//	0이면 수정되지 않은 것이다
					change = stmt.executeUpdate();
					
					if(change>0){
		                System.out.println("삭제 성공"+change);   
		               // ok=1;
		            }else{
		                System.out.println("삭제 실패"+change);
		            }				
					
				}
				catch(Exception e) {
					System.out.println("회원삭제 질의 실행 에러="+e);
				}
				db.close(stmt);
				return change;
			}
	
		//회원가입 아이디 검사
		public void MemberCheck(String id) {
			String sql = MemberSql.getSQL(MemberSql.SELECT_MEMBER);
			PreparedStatement stmt = db.getSTMT(con, sql);
			ResultSet rs = null;
			try {
				stmt.executeQuery();
				stmt.setString(1, id);
				
			} catch (SQLException e) {
				
				System.out.println("회원ID조회 에러"+e);
			}
		}
	
	 
	  //회원가입 처리
	 public int MemberJoin(String id, String pw, String name, String birth, String email,String phone) {
		 
		 String sql = MemberSql.getSQL(MemberSql.INSERT_MEMBER);
		 System.out.println("INSERT_MEMBER sql="+sql);
		 PreparedStatement stmt = db.getSTMT(con, sql);
		int r = 0;
		 try {

			stmt.setString(1, id);
			stmt.setString(2, pw);
			stmt.setString(3, name);
			stmt.setString(4, birth);
			stmt.setString(5, email);
			stmt.setString(6, phone);
			
			r =  stmt.executeUpdate(); //실행 -> 저장
			
			 if(r>0){
	                System.out.println("가입 성공");   
	               // ok=1;
	            }else{
	                System.out.println("가입 실패");
	            }
			 
		 } catch (Exception e) {
				System.out.println("회원등록 처리 실행 에러 = " + e);
			}
		 db.close(stmt);
			return r;
		}
	 
		// 로그인처리 체크   
		public MemberVO LoginCheck(String id, String pw) {
			//질의문
			String sql  = MemberSql.getSQL(MemberSql.SELECT_LOGIN);
			System.out.println("로그인 처리를 위한 회원정보 조회 sql="+sql);
			PreparedStatement stmt = db.getSTMT(con, sql);
			ResultSet rs = null;
			String dbPW = ""; // db에서 꺼낸 비밀번호를 담을 변수			
			MemberVO vo =new MemberVO();
			
			try {				
				stmt.setString(1,id);				
			    rs =stmt.executeQuery();			    
			    if (rs.next()){ // 입력된 아이디에 해당하는 비번 있을경우
	                dbPW = rs.getString("pw"); // 비번을 변수에 넣는다.
	                if (dbPW.equals(pw)) { //비밀번호가 맞는지 확인해보기
	                	vo.setNo(rs.getInt("mNo"));
	                	vo.setChange(1);
	                	vo.setGrade(rs.getInt("mgrade"));
	                }else {
	                	vo.setChange(0); //비밀번호만 틀릴 경우
	                }
			    }else {
			    	vo.setChange(-1); //회원 정보가 없을 경우
			    }
			  db.close(rs);
			}
	        catch (SQLException e) {
				System.out.println("로그인처리 질의실행 에러="+e);
			}
			db.close(stmt);	            
			return vo;
		}
		
		public void close() {
			db.close(con);
		}
		
	}

