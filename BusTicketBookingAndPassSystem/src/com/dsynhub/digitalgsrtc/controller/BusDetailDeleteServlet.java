package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.dao.BusDetailDAO;

@SuppressWarnings("serial")
public class BusDetailDeleteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String busDetailId = request.getParameter("busDetailId");

		if (new BusDetailDAO().delete(busDetailId)) {
			response.sendRedirect("BusDetailListServlet");

		} else {
			response.sendRedirect("BusDetailListServlet");

		}
	}

}
