package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.dao.UserDAO;
import com.dsynhub.digitalgsrtc.util.ValidationUtils;

public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("txtEmail");
		boolean isError = false;
		System.out.println(userName + " user ");
		
		if (ValidationUtils.isEmpty(userName)) {
			isError = true;
			request.setAttribute("userName", "please enter username");
		}  else if (!new UserDAO().isEmailExists(userName)) {
			isError = true;
			request.setAttribute("usrname", "please enter valid email id");
		}
		if (isError) {
			request.getRequestDispatcher("ForgotPassword.jsp").forward(request,
					response);
		} else {

			System.out.println("hi");
			String tmp = "http://localhost:6018/BusTicketBookingAndPassSystem/resetPassword.jsp?emailId=" + userName;
			String from = "digitalgsrtc2016@gmail.com";
			String password = "digital2016";
			String subject = "Forgot Password";
			String message = "Please click below link to change your password...! "
					+ tmp;
			String[] to = new String[1];
			to[0] = userName;
			if (new SendEmail().sendMail(from, password, subject, message, to)) {
				request.setAttribute("msgLogin", "succesfully send to "
						+ "your email<br>please check your email<br>");
				request.getRequestDispatcher("userLoginPage.jsp").forward(
						request, response);
			} else {
				request.setAttribute("msgLogin", "failed!please try again");
				request.getRequestDispatcher("forgotPassword.jsp").forward(
						request, response);

			}

		}
	}

}
