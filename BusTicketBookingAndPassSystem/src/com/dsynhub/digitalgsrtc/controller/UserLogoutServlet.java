package com.dsynhub.digitalgsrtc.controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dsynhub.digitalgsrtc.bean.LogsBean;
import com.dsynhub.digitalgsrtc.dao.LogsDAO;

public class UserLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		java.util.Date date = new java.util.Date();
		String logoutTime = (date.toString());

		LogsBean logsBean = (LogsBean) session.getAttribute("logsBean");

		logsBean.setLogoutTime(logoutTime.substring(0, 20));
		logsBean.setUserType("Normal");

		BufferedWriter file = null;
		file = new BufferedWriter(
				new FileWriter(
						"E:\\BusTicketBookingAndPassSystem\\WebContent\\Logging.txt",
						true));

		file.write("\n--------------------------------------------------------------------------------------------------------------------------\n");
		file.close();

		if (new LogsDAO().insert(logsBean)) {
			session.removeAttribute("userBean");
			session.removeAttribute("loginUserCheck");
			session.invalidate();
			response.sendRedirect("userLoginPage.jsp");
		}
	}

}
