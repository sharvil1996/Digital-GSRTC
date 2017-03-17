package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.bean.UserBean;
import com.dsynhub.digitalgsrtc.dao.UserDAO;
import com.dsynhub.digitalgsrtc.util.ValidationUtils;

public class UserPassWordResetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password=request.getParameter("pwdPassword");
		String confirmPassword=request.getParameter("pwdCpassword");
		String emailId=request.getParameter("emailId");
		
		boolean isError=false;
		if(ValidationUtils.isEmpty(confirmPassword))
		{
			isError=true;
			request.setAttribute("msgPassword","please enter password");
		}
		else if(password!=null && password.length()<6)
		{
			isError=true;
			request.setAttribute("msgPassword","password must contain 6 character ");
		}
		if(ValidationUtils.isEmpty(confirmPassword))
		{
			isError=true;
			request.setAttribute("msgCpassword","please enter confirm password");
		}
		else if(password!=null && !password.equals(confirmPassword))
		{
			isError=true;
			request.setAttribute("msgCpassword","confirm password does not match");
		}
		if(isError)
		{
			request.getRequestDispatcher("resetPassword.jsp").forward(request, response);
		}
		else
		{
			UserBean userBean=new UserBean();
			userBean.setPassword(password);
			userBean.setEmail(emailId);
			if(new UserDAO().resetPassword(userBean))
			{
				System.out.println("Insert");
				request.setAttribute("msgLogin", "password succesffully changed<br>login again to continue");
				request.getRequestDispatcher("userLoginPage.jsp").forward(request, response);
				
			}
			else
			{
				request.getRequestDispatcher("resetPassword.jsp").forward(request, response);
			}
		}

	}
}
