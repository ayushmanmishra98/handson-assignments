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
import com.hsbc.exception.UserNotFoundException;
import com.hsbc.model.beans.User;
import com.hsbc.model.service.UserService;
import com.hsbc.model.util.UserFactory;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName=request.getParameter("user");
		int id=Integer.parseInt(userName);
		UserService service=(UserService)UserFactory.getInstance("service");
		try {
		User found=service.getUser(id);
		HttpSession session = request.getSession();
		session.setAttribute("userKey", found);
		RequestDispatcher rd = request.getRequestDispatcher("found.jsp");
		rd.forward(request, response);
		}catch (UserNotFoundException e) {	
			RequestDispatcher rd = request.getRequestDispatcher("notfound.jsp");
			request.setAttribute("err", e.getMessage());
			rd.forward(request, response);
		}
	}

}
