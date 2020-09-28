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


@WebServlet("/Item")
public class Item extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		HttpSession session=request.getSession();
		ArrayList<String> a1=null;
		
		String name=request.getParameter("p");
		
		if(session.getAttribute("key2")==null) {
			a1=new ArrayList<String>();
			a1.add(name);
		}else {
			a1=(ArrayList<String>)session.getAttribute("key2");
			a1.add(name);
		}
		
		
		session.setAttribute("key2",a1);
		pw.print("<html><body><p>");
		pw.print("<p>Product Count"+a1.size()+"</p>");
		pw.print("</p></body></html>");
		RequestDispatcher rd=request.getRequestDispatcher("Item.html");
		rd.include(request, response);
	}

}
