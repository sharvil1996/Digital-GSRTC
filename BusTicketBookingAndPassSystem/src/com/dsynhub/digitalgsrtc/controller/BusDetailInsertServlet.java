package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.bean.BusDetailBean;
import com.dsynhub.digitalgsrtc.dao.BusDetailDAO;

@SuppressWarnings("serial")
public class BusDetailInsertServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String routeId = request.getParameter("selRoute");
		String busNo = request.getParameter("selBusNo");
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
			request.getRequestDispatcher("busDetailInsert.jsp").forward(request,
					response);
		} else {
			System.out.println("success");

			if (new BusDetailDAO().insert(busDetailBean)) {

				System.out.println("Record Inserted");
				response.sendRedirect("BusDetailListServlet");

			} else {
				System.out.println("Record Not inserted");

			}

		}

	}

}
