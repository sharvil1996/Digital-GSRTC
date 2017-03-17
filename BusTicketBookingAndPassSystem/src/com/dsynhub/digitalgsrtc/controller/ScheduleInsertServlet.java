package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.bean.ScheduleBean;
import com.dsynhub.digitalgsrtc.dao.ScheduleDAO;

public class ScheduleInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String busNo = request.getParameter("selBusNo");

		boolean isError = false;
		if (busNo.equals("0")) {
			request.setAttribute("msgSelBusNo", "please select bus no");
			isError = true;
		}

		if (isError) {
			request.getRequestDispatcher("scheduleInsert.jsp").forward(
					request, response);
		} else {
			ScheduleBean scheduleBean = new ScheduleBean();
			scheduleBean.setBusNo(busNo);
			if (new ScheduleDAO().insert(scheduleBean)) {
				request.getRequestDispatcher("ScheduleListServlet").forward(
						request, response);

			} else {
				request.getRequestDispatcher("scheduleDetailInsert.jsp")
						.forward(request, response);

			}
		}

	}

}
