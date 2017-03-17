package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.bean.BusTypeBean;
import com.dsynhub.digitalgsrtc.dao.BusTypeDAO;


public class BusTypeEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		
		String busTypeId = request.getParameter("busTypeId");
		
		BusTypeBean busTypeBean = new BusTypeDAO().getByPK(busTypeId);
		if(busTypeBean!=null){
				request.setAttribute("busTypeBean", busTypeBean);
				request.getRequestDispatcher("busTypeEdit.jsp").forward(request, response);
		}else{
				response.sendRedirect("BusTypeListServlet");
		}

		
	}

}
