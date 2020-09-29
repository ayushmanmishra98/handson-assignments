package com.hsbc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsbc.exception.AuthenticationException;
import com.hsbc.model.beans.User;
import com.hsbc.model.service.UserService;
import com.hsbc.model.util.UserFactory;

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
		long phoneNumber=Long.parseLong(phone);
		UserService service=(UserService)UserFactory.getInstance("service");
		User user = new User();
		user.setName(userName);
		user.setPassword(password);
		user.setPhone(phoneNumber);
		User registered=service.createUser(user);
		RequestDispatcher rd = request.getRequestDispatcher("registersuccess.html");
		rd.forward(request, response);
	}

}
