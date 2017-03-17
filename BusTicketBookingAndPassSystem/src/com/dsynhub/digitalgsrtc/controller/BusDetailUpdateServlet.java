package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.bean.BusDetailBean;
import com.dsynhub.digitalgsrtc.dao.BusDetailDAO;

public class BusDetailUpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String busDetailId=request.getParameter("busDetailId");
		String routeId = request.getParameter("selRoute");
		String busNo = request.getParameter("selBusNo");
		String available = request.getParameter("rdoAvalibility");
		boolean isError=false;
		BusDetailBean busDetailBean = new BusDetailBean();
		
		if (busNo.equals("0")) {
			isError = true;
			request.setAttribute("busNo",
					"<font color=red>* BusNo is Required</font>");
		}

		else {
			request.setAttribute("selBusNo", busNo);
			busDetailBean.setBusNo(busNo);
		}

		if (routeId.equals("0")) {
			isError = true;
			request.setAttribute("route",
					"<font color=red>* Route is Required</font>");
		}

		else {
			request.setAttribute("selRoute", routeId);
			busDetailBean.setRouteId(routeId);
		}

		if (isError) {
			System.out.println("error");
			request.getRequestDispatcher("busDetailEdit.jsp").forward(request,
					response);
		} else {
			System.out.println("success");
			busDetailBean.setIsAvailable(available);
			busDetailBean.setBusDetailId(busDetailId);
			if (new BusDetailDAO().update(busDetailBean)) {

				System.out.println("Record Inserted");
				response.sendRedirect("BusDetailListServlet");

			} else {
				System.out.println("Record Not inserted");

			}

		}
	}

}
