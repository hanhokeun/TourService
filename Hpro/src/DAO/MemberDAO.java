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
	
	
	//����� �ʿ��� ������ (�Լ�)�߰�
	//������ ȸ�� �߹�	//
			public int MemberDelete(String id) {
				String sql = MemberSql.getSQL(MemberSql.DELETE_MEMBERDELETE);
				PreparedStatement stmt = db.getSTMT(con, sql);
				int change = 0;
				
				try {
					stmt.setString(1, id);
					
					// update���Ǹ���� ������ �� ��ȭ�� ������ ������ �˾Ƴ���
					//	1�̸� �Ѱ��� ������ ���̰�
					//	0�̸� �������� ���� ���̴�
					change = stmt.executeUpdate();
					
					if(change>0){
		                System.out.println("���� ����"+change);   
		               // ok=1;
		            }else{
		                System.out.println("���� ����"+change);
		            }				
					
				}
				catch(Exception e) {
					System.out.println("ȸ������ ���� ���� ����="+e);
				}
				db.close(stmt);
				return change;
			}
	
		//ȸ������ ���̵� �˻�
		public void MemberCheck(String id) {
			String sql = MemberSql.getSQL(MemberSql.SELECT_MEMBER);
			PreparedStatement stmt = db.getSTMT(con, sql);
			ResultSet rs = null;
			try {
				stmt.executeQuery();
				stmt.setString(1, id);
				
			} catch (SQLException e) {
				
				System.out.println("ȸ��ID��ȸ ����"+e);
			}
		}
	
	 
	  //ȸ������ ó��
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
			
			r =  stmt.executeUpdate(); //���� -> ����
			
			 if(r>0){
	                System.out.println("���� ����");   
	               // ok=1;
	            }else{
	                System.out.println("���� ����");
	            }
			 
		 } catch (Exception e) {
				System.out.println("ȸ����� ó�� ���� ���� = " + e);
			}
		 db.close(stmt);
			return r;
		}
	 
		// �α���ó�� üũ   
		public MemberVO LoginCheck(String id, String pw) {
			//���ǹ�
			String sql  = MemberSql.getSQL(MemberSql.SELECT_LOGIN);
			System.out.println("�α��� ó���� ���� ȸ������ ��ȸ sql="+sql);
			PreparedStatement stmt = db.getSTMT(con, sql);
			ResultSet rs = null;
			String dbPW = ""; // db���� ���� ��й�ȣ�� ���� ����			
			MemberVO vo =new MemberVO();
			
			try {				
				stmt.setString(1,id);				
			    rs =stmt.executeQuery();			    
			    if (rs.next()){ // �Էµ� ���̵� �ش��ϴ� ��� �������
	                dbPW = rs.getString("pw"); // ����� ������ �ִ´�.
	                if (dbPW.equals(pw)) { //��й�ȣ�� �´��� Ȯ���غ���
	                	vo.setNo(rs.getInt("mNo"));
	                	vo.setChange(1);
	                	vo.setGrade(rs.getInt("mgrade"));
	                }else {
	                	vo.setChange(0); //��й�ȣ�� Ʋ�� ���
	                }
			    }else {
			    	vo.setChange(-1); //ȸ�� ������ ���� ���
			    }
			  db.close(rs);
			}
	        catch (SQLException e) {
				System.out.println("�α���ó�� ���ǽ��� ����="+e);
			}
			db.close(stmt);	            
			return vo;
		}
		
		public void close() {
			db.close(con);
		}
		
	}

