package com.org.controller;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class DisplayAllContacts
 */
@WebServlet("/DisplayAllContacts")
public class DisplayAllContacts extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Profile profileSession=(Profile)session.getAttribute("profileKey");
		int id=profileSession.getProfileId();
		ProfileService service=(ProfileService)FactoryClass.getInstance(Type.SERVICE);
		List<Contact> allContacts=service.getAllContacts(id);
		request.setAttribute("allContactsKey",allContacts);
		RequestDispatcher rd=request.getRequestDispatcher("displayAll.jsp");
		rd.forward(request, response);
	}


}
