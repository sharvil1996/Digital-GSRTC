package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dsynhub.digitalgsrtc.bean.AdminBean;
import com.dsynhub.digitalgsrtc.bean.LogsBean;
import com.dsynhub.digitalgsrtc.bean.UserBean;
import com.dsynhub.digitalgsrtc.dao.LogsDAO;
import com.dsynhub.digitalgsrtc.dao.UserDAO;
import com.dsynhub.digitalgsrtc.util.ValidationUtils;

public class LoginController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		
		String userName = request.getParameter("txtEmail");
		String password = request.getParameter("txtPassword");
		boolean isError = false;

		
		
		if (ValidationUtils.isEmpty(userName)) {
			isError = true;
			request.setAttribute("email", "please enter username");
		} else {
			request.setAttribute("txtEmail", userName);
		}
		if (ValidationUtils.isEmpty(password)) {
			isError = true;
			request.setAttribute("password", "please enter password");
		}
		if (isError) {

			request.getRequestDispatcher("userLoginPage.jsp").forward(request,
					response);
		} else {
			HttpSession session = request.getSession();
			System.out.println(userName + " " + password);
			Object obj = new UserDAO().checkUser(userName,ValidationUtils.base64encode(password));
			if (obj == null) {
				request.setAttribute("msgUser",
						"please enter valid username or password");
				request.getRequestDispatcher("userLoginPage.jsp").forward(
						request, response);
			} else if (obj instanceof UserBean) {

				UserBean user = (UserBean) obj;
				session.setAttribute("userBean", user);
				session.setAttribute("loginUserCheck","loginUserCheck");
				// System.out.println(session.getAttribute("scheduleDetailBean"));
				if (session.getAttribute("scheduleDetailBean") != null) {
					// response.sendRedirect("userReservationInsert.jsp");
					/*
					 * Date date = new Date(); String str=(date.toString()); //
					 * display time and date using toString()
					 * System.out.println(str.substring(0,20));
					 */
				} else {
					session.setAttribute("userBean", user);
					java.util.Date date = new java.util.Date();
					String loginTime = (date.toString());
					LogsBean logsBean = new LogsBean();
					logsBean.setUserName(user.getFirstName()+" "+user.getMiddleName()+" "+user.getLastName());
					logsBean.setUserType("User");
					logsBean.setLoginTime(loginTime.substring(0, 20));
					logsBean.setLogoutTime(" ");
					session.setAttribute("logsBean", logsBean);
					System.out.println("user Login Succsss");
					response.sendRedirect("userHomePage.jsp");
				}
			} else {
				AdminBean admin = (AdminBean) obj;
				java.util.Date date = new java.util.Date();
				String loginTime = (date.toString());
				LogsBean logsBean = new LogsBean();
				logsBean.setUserName(admin.getFirstName()+" "+admin.getMiddleName()+" "+admin.getLastName());
				logsBean.setUserType("Admin");
				logsBean.setLoginTime(loginTime.substring(0, 20));
				logsBean.setLogoutTime(" ");

				session.setAttribute("logsBean", logsBean);
				System.out.println("Ammin Login Succsss");
				session.setAttribute("adminBean", admin);
				session.setAttribute("loginAdminCheck","loginAdminCheck");
				response.sendRedirect("adminDashBoard.jsp");
			}
		}

	}
}
