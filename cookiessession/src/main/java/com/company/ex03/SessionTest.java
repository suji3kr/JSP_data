package com.company.ex03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet ("/sess")
public class SessionTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();     //세션생성
		out.print("세션 아이디: " +session.getId() + "<br/>");
		out.print("최근 세션 생성시간: " +new Date(session.getCreationTime())+"<br>");
		out.print("최근 세션 접근시간: " +new Date(session.getLastAccessedTime())+"<br>");
		out.print("세션 유효시간: " +session.getMaxInactiveInterval() + "<br/>");
		if(session.isNew()) {
			out.print("새 세션이 만들어졌습니다.");
		}
		
		session.invalidate();  //invalidate를 호출하여 생성된 세션객체를 강제로 삭제합니다.
		
	}

}
