package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.bean.AdminBean;
import com.dsynhub.digitalgsrtc.dao.AdminDAO;


@SuppressWarnings("serial")
public class AdminEditServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String adminId = request.getParameter("adminId");
		System.out.println("admin > "+adminId+" < ");
		AdminBean adminBean = new AdminDAO().getByPK(adminId);
		
		
		if(adminBean!=null)
		{
			request.setAttribute("adminBean",adminBean);
			request.getRequestDispatcher("adminEdit.jsp").forward(request, response);
		}
	
	
	}

}
