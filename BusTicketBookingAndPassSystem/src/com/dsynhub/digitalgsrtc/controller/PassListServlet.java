package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.bean.PassBean;
import com.dsynhub.digitalgsrtc.dao.PassDAO;

@SuppressWarnings("serial")	
public class PassListServlet extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<PassBean> listofPass = new PassDAO().list();
		if(listofPass != null)
		{
			request.setAttribute("listofPass",listofPass);
			request.getRequestDispatcher("passList.jsp").forward(request, response);
		}else{
			System.out.println("No Record Found....");
		}
	}

}
