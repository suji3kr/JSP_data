package com.company.ex1;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;


// @WebServlet("/member")  다른 맴버와 충돌 방지 주석, 실행 안할때
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		MemberDAO  dao = new MemberDAO();
		
		List<MemberVO> list = dao.listMembers();  //dao에 있는 리스트단위를 실행해서 보여줘
		
		out.print("<html><body>");
		out.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
		out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td></tr>");
		
		for(int i = 0; i<list.size(); i++) {   //vo 인스턴스 단위로 가져와줘
			
			MemberVO memberVO = (MemberVO) list.get(i);  
			String id = memberVO.getId();
			String pwd = memberVO.getPwd();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			Date joinDate = memberVO.getJoinDate();
			out.print("<tr><td>" +id + "</td><td>" +pwd + "</td><td>" +name + "</td><td>" +email +"</td><td>" +joinDate + "</td></tr>");
		}
			
		out.print("<table><body><html>");
	}

}
