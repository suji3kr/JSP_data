package com.company;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ExampleServlet01")   //다른 사람에게 링크 변경해서 유포, 확장자 숨겨서 가능
public class ExampleServlet01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>이클립스 서블릿 만들기</h1>");
		out.println("</body>");
		out.println("</html>");
	
	}

}
