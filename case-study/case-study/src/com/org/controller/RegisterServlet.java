package com.org.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.org.model.beans.Profile;
import com.org.model.service.ProfileService;
import com.org.model.utility.FactoryClass;
import com.org.model.utility.Type;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName=request.getParameter("user");
		String password=request.getParameter("pass");
		String phone=request.getParameter("phone");
		String dob=request.getParameter("dob");
		long phoneNumber=Long.parseLong(phone);
		ProfileService service=(ProfileService)FactoryClass.getInstance(Type.SERVICE);
		Profile profile = new Profile();
		profile.setName(userName);
		profile.setPassword(password);
		profile.setPhoneNo(phoneNumber);
		profile.setDOB(dob);
		Profile registered=service.store(profile);
		PrintWriter pw=response.getWriter();
		pw.print("<html><body><p>");
		pw.print("<p>Hello"+profile.getName()+"you have successfully registered</p>");
		pw.print("<p>Profile Id"+profile.getProfileId()+"</p>");
		pw.print("<p>Profile Name"+profile.getName()+"</p>");
		pw.print("<p>Phone Number"+profile.getPhoneNo()+"</p>");
		pw.print("<p>Date Of Birth"+profile.getDOB()+"</p>");
		pw.print("</p></body></html>");
		RequestDispatcher rd = request.getRequestDispatcher("login.html");
		rd.include(request, response);
	}

}
