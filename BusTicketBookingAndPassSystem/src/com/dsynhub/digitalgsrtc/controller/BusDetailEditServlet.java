package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.bean.BusBean;
import com.dsynhub.digitalgsrtc.bean.BusDetailBean;
import com.dsynhub.digitalgsrtc.dao.BusDAO;
import com.dsynhub.digitalgsrtc.dao.BusDetailDAO;


@SuppressWarnings("serial")
public class BusDetailEditServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String busDetailId = request.getParameter("busDetailId");
		
		BusDetailBean busDetailBean = new BusDetailDAO().getByPK(busDetailId);
		if(busDetailBean!=null){
			System.out.println(busDetailBean.getBusNo());
				request.setAttribute("busDetailBean", busDetailBean);
				request.getRequestDispatcher("busDetailEdit.jsp").forward(request, response);
		}else{
				response.sendRedirect("BusListServlet");
		}
	}

}
