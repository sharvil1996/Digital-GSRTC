package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.bean.ScheduleDetailBean;
import com.dsynhub.digitalgsrtc.dao.ScheduleDetailDAO;


public class ScheduleDetailListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List<ScheduleDetailBean> listofScheduleDetail= new ScheduleDetailDAO().list();
		if (listofScheduleDetail != null) {
			request.setAttribute("listofScheduleDetail", listofScheduleDetail);
			request.getRequestDispatcher("scheduleDetailList.jsp").forward(
					request, response);
		} else {
			System.out.println("No Record Found....");
		}

	}

}
