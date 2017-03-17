package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.bean.BusBean;
import com.dsynhub.digitalgsrtc.dao.BusDAO;

public class BusEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String busNo = request.getParameter("busNo");
		
		BusBean busBean = new BusDAO().getByPK(busNo);
		if(busBean!=null){
			System.out.println(busBean.getBusNo());
				request.setAttribute("busBean", busBean);
				request.getRequestDispatcher("busEdit.jsp").forward(request, response);
		}else{
				response.sendRedirect("BusListServlet");
		}

		
	}

}