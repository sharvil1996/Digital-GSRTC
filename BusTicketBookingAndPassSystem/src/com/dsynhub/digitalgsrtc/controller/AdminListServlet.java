package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.bean.AdminBean;
import com.dsynhub.digitalgsrtc.dao.AdminDAO;

@SuppressWarnings("serial")
public class AdminListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<AdminBean> listOfUser = new AdminDAO().list();
		
		if(listOfUser!=null)
		{
			request.setAttribute("listOfAdmin",listOfUser);
			request.getRequestDispatcher("adminList.jsp").forward(request, response);
		}
	}

}
