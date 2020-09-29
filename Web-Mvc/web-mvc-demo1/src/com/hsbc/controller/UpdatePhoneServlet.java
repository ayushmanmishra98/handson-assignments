package com.hsbc.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsbc.model.beans.User;
import com.hsbc.model.service.UserService;
import com.hsbc.model.util.UserFactory;

/**
 * Servlet implementation class UpdatePhoneServlet
 */
@WebServlet("/UpdatePhoneServlet")
public class UpdatePhoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		User userSession=(User)session.getAttribute("userKey");
		int id=userSession.getUserId();
		String phone=request.getParameter("phone");
		long phoneNumber=Long.parseLong(phone);
		UserService service=(UserService)UserFactory.getInstance("service");
		User registered=service.updatePhone(id, phoneNumber);
		RequestDispatcher rd = request.getRequestDispatcher("updatesuccess.html");
		rd.forward(request, response);
	}

}
