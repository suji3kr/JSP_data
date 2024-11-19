package com.company.ex4;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	

	private PreparedStatement pstmt;
	private Connection con;
	private DataSource dataFactory;
	
	
	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext  =(Context) ctx.lookup("java:/comp/env");
			dataFactory =(DataSource) envContext.lookup("jdbc/mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}



	public List<MemberVO> listMembers(){
		
		List<MemberVO> list = new ArrayList<>();  //메모리 할당
		
			try {
				con = dataFactory.getConnection();

				String query ="select * from t_member";
				System.out.println("prepareStatement :" + query);    //확인차

				pstmt = con.prepareStatement(query);
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()){  //데이터 베이스로부터 값을 가져와서 set 에 집어 넣어야 함
					String id = rs.getString("id");           //rs = result set 데이터로부터 변수에 집어넣는다. //묶어서=> list 
					String pwd = rs.getString("pwd");
					String name = rs.getString("name");
					String email = rs.getString("email");
					Date joinDate = rs.getDate("joinDate");
							                                  //낱개를 하나의 묶음으로 처리 vo 
					 
					
					MemberVO vo = new MemberVO();
					vo.setId(id);
					vo.setPwd(pwd);
					vo.setName(name);
					vo.setEmail(email);
					vo.setJoinDate(joinDate);
					
					list.add(vo);  //vo.지정한것들을 list에 넣음 	
				}
				
				
				rs.close();
				pstmt.close();
				con.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
			
	}
	
	public void addMember(MemberVO memberVO) {   //삽입
	
		try {
			con = dataFactory.getConnection();
			String id = memberVO.getId();
			String pwd = memberVO.getPwd();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			
			String query = "insert into t_member";
				   query += " (id, pwd, name, email)";
				   query += " values(?, ?, ?, ?)";  //value 앞 공백 필수

			System.out.println("prepareStatement: "+ query);
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
		
			pstmt.executeUpdate();          // 내용이 변경 될때 갱신됨
			pstmt.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delMember(String id) {    //삭제 
		
		try {
			con = dataFactory.getConnection();
			String query = "delete from t_member " + "where id = ?";
			System.out.println("prepareStatement: "+ query);
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, id);
			pstmt.executeUpdate();      
			pstmt.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
