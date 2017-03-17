package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.bean.PassBean;
import com.dsynhub.digitalgsrtc.dao.PassDAO;


public class PassEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		
		String passId = request.getParameter("passId");
		
		PassBean passBean = new PassDAO().getByPK(passId);
		if(passBean!=null){
				request.setAttribute("passBean", passBean);
				request.getRequestDispatcher("passEdit.jsp").forward(request, response);
		}else{
				response.sendRedirect("PassListServlet");
		}

		
	}

}
