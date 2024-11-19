package com.company.ex4;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.Setter;


@WebServlet("/member3")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	throws ServletException, IOException {
		doHandle(request,response);
				

	}

	protected void doPost(HttpServletRequest request,HttpServletResponse response)
	throws ServletException, IOException {
		doHandle(request,response);
		
	}
	protected void doHandle(HttpServletRequest request,HttpServletResponse response)
	throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();	
	    MemberDAO  dao = new MemberDAO();
			List membersList = dao.listMembers();
			request.setAttribute("membersList", membersList);
			RequestDispatcher dispatch = request.getRequestDispatcher("viewMembers");
			dispatch.forward(request, response);
		}
	
	}
