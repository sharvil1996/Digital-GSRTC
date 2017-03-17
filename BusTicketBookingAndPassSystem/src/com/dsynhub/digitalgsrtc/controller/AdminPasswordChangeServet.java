package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dsynhub.digitalgsrtc.bean.AdminBean;
import com.dsynhub.digitalgsrtc.dao.AdminDAO;
import com.dsynhub.digitalgsrtc.util.ValidationUtils;

public class AdminPasswordChangeServet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String oldPassword = request.getParameter("pwdOldPassword");
		String password = request.getParameter("pwdPassword");
		String confirmPassword = request.getParameter("pwdCpassword");
		
		System.out.println(oldPassword +  " " + password + " " + confirmPassword);
		
		boolean isError = false;
		HttpSession session = request.getSession();
		AdminBean adminBean = (AdminBean) session.getAttribute("adminBean");
		
		if (ValidationUtils.isEmpty(oldPassword)) {
			isError = true;
			request.setAttribute("msgOldPassword", "please enter old password");
		} else if (!adminBean.getPassword().equals(ValidationUtils.base64encode(oldPassword))) {
			isError = true;
			request.setAttribute("msgOldPassword",
					"please enter correct old password");
		}
		if (ValidationUtils.isEmpty(password)) {
			isError = true;
			request.setAttribute("msgPassword", "please enter password");
		} else if (password != null && password.length() < 6 ) {
			isError = true;
			request.setAttribute("msgPassword",
					"password must contain 6 character ");
		}
		if (ValidationUtils.isEmpty(confirmPassword)) {
			isError = true;
			request.setAttribute("msgCpassword",
					"please enter confirm password");
		} else if (password != null && !password.equals(confirmPassword)) {
			isError = true;
			request.setAttribute("msgCpassword",
					"confirm password does not match");
		}
		if (isError) {
			request.getRequestDispatcher("adminChangePassword.jsp").forward(
					request, response);
		} else {
			adminBean = (AdminBean) session.getAttribute("adminBean");
			adminBean.setPassword(ValidationUtils.base64encode(confirmPassword));
			if (new AdminDAO().changePassword(adminBean)) {
				request.setAttribute("msgLogin",
						"password succesffully changed<br>login again to continue");
				request.getRequestDispatcher("userLoginPage.jsp").forward(
						request, response);

			} else {
				request.getRequestDispatcher("adminChangePassword.jsp").forward(
						request, response);
			}
		}
	}

}
