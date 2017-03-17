package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.bean.BusCategoryBean;
import com.dsynhub.digitalgsrtc.dao.BusCategoryDAO;


public class BusCategoryEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		
		String busCategoryId = request.getParameter("busCategoryId");
		
		BusCategoryBean busCategoryBean = new BusCategoryDAO().getByPK(busCategoryId);
		if(busCategoryBean!=null){
				request.setAttribute("busCategoryBean", busCategoryBean);
				request.getRequestDispatcher("busCategoryEdit.jsp").forward(request, response);
		}else{
				response.sendRedirect("BusCategoryListServlet");
		}

		
	}

}
