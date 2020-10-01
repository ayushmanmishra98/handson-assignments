package com.org.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.model.beans.Contact;
import com.org.model.beans.Profile;
import com.org.model.service.ProfileService;
import com.org.model.utility.FactoryClass;
import com.org.model.utility.Type;

/**
 * Servlet implementation class GetContactServlet
 */
@WebServlet("/GetContactServlet")
public class GetContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Profile profileSession=(Profile)session.getAttribute("profileKey");
		int id=profileSession.getProfileId();
		String id1=request.getParameter("id");
		int convertId=Integer.parseInt(id1);
		ProfileService service=(ProfileService)FactoryClass.getInstance(Type.SERVICE);
		Contact contact=service.getContact(id,convertId);
		request.setAttribute("contactFound",contact);
		RequestDispatcher rd = request.getRequestDispatcher("showcontactdetails.jsp");
		rd.forward(request, response);
	}

}
