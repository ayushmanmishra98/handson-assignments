package com.org.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.exception.NotFound;
import com.org.model.beans.Profile;
import com.org.model.service.ProfileService;
import com.org.model.utility.FactoryClass;
import com.org.model.utility.Type;

/**
 * Servlet implementation class DeleteProfileServlet
 */
@WebServlet("/DeleteProfileServlet")
public class DeleteProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Profile profileSession=(Profile)session.getAttribute("profileKey");
		int id=profileSession.getProfileId();
		ProfileService service=(ProfileService)FactoryClass.getInstance(Type.SERVICE);
		try {
		service.deleteProfile(id);
		PrintWriter pw=response.getWriter();
		pw.print("<html><body><p>");
		pw.print("<p>Profile Deleted.</p>");
		pw.print("</p></body></html>");
		RequestDispatcher rd = request.getRequestDispatcher("register.html");
		rd.include(request, response);
		}catch(NotFound e) {
			RequestDispatcher rd = request.getRequestDispatcher("incorrect.jsp");
			rd.include(request, response);
		}
	}

}
