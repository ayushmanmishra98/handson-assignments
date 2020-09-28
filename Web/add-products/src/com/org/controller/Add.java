package com.org.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Add
 */
@WebServlet("/index")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<String> a1=new ArrayList<String>();
		HttpSession session=request.getSession();
		String id=session.getId();
		String name=request.getParameter("name");
		a1.add(name);
		session.setAttribute("key1",a1);
		
		PrintWriter pw=response.getWriter();
		pw.print("<html><body><p>");
		pw.print("<p>Product Count"+a1.size()+"</p>");
		pw.print("</p></body></html>");
		RequestDispatcher rd=request.getRequestDispatcher("index.html");
		rd.include(request, response);
	}

}
