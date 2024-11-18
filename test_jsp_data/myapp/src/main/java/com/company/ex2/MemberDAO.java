package com.company.ex2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	
	
	private static final String driver = "oracle.jdbc.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String user = "kmr";
	private static final String pwd = "kmr";
			
	
	// private Statement stmt; pstmt 로 대체 
	private PreparedStatement pstmt;
	private Connection con;
	
	public List<MemberVO> listMembers(){
		
		List<MemberVO> list = new ArrayList<>();  //메모리 할당
		
			try {
				connDB();  //연결하는 함수
				String query ="select * from t_member";
				System.out.println("prepareStatement :" + query);    //확인차
//				ResultSet rs = stmt.executeQuery(query);
				pstmt = con.prepareStatement(query);
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()){  //데이터 베이스로부터 값을 가져와서 set 에 집어 넣어야 함
					String id = rs.getString("id");      //rs = result set 데이터로부터 변수에 집어넣는다. //묶어서=> list 
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
		private void connDB() {
			
			try {
				Class.forName(driver);
				System.out.println("Oracle 드라이버 로딩 성공");
				con = DriverManager.getConnection(url, user, pwd);
				System.out.println("Connection 생성 성공");
				
				//Preparesatement ->create 필요없음
//				stmt = con.createStatement();
//				System.out.println("Statement 생성 품목");
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}

}
