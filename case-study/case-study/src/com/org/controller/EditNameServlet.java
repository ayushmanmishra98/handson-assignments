package com.org.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.exception.NotFound;
import com.org.model.beans.Contact;
import com.org.model.beans.Profile;
import com.org.model.service.ProfileService;
import com.org.model.utility.FactoryClass;
import com.org.model.utility.Type;

/**
 * Servlet implementation class EditNameServlet
 */
@WebServlet("/EditNameServlet")
public class EditNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Profile profileSession=(Profile)session.getAttribute("profileKey");
		
		int profileId=profileSession.getProfileId();
		
		String id=request.getParameter("id");
		
		int contactId=Integer.parseInt(id);
		String name=request.getParameter("name");
		ProfileService service=(ProfileService)FactoryClass.getInstance(Type.SERVICE);
		try {
		Contact updated=service.updateContactName(profileId,contactId,name);
		RequestDispatcher rd = request.getRequestDispatcher("updatesuccess.html");
		rd.forward(request, response);
		}catch(NotFound e){
			RequestDispatcher rd = request.getRequestDispatcher("incorrect.jsp");
			request.setAttribute("err", e.getMessage());
			rd.include(request, response);
		}
	}

}
