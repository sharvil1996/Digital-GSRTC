package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.bean.BusCategoryBean;
import com.dsynhub.digitalgsrtc.dao.BusCategoryDAO;
import com.dsynhub.digitalgsrtc.util.ValidationUtils;


public class BusCategoryUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		
		
		String busCategoryName = request.getParameter("txtBusCategoryName");
		String busCategoryId = request.getParameter("busCategoryId");
		boolean isError=false;
		
		
		BusCategoryBean busCategorybean = new BusCategoryBean();
		
		if(ValidationUtils.isEmpty(busCategoryName))
		{
			request.setAttribute("busCategoryName", "<font color=red>* Name is Required</font>");
			isError=true;
		}else{
			request.setAttribute("txtBusCategoryName", busCategoryName);
			if(busCategoryName == null)
				busCategoryName="";
			busCategorybean.setBusCategoryName(busCategoryName);
		}
		
		if(isError)
		{
			busCategorybean.setBusCategoryId(busCategoryId);
			busCategorybean.setBusCategoryName(busCategoryName);
			request.setAttribute("busCategoryBean",busCategorybean);
			request.getRequestDispatcher("busCategoryEdit.jsp").forward(request, response);
		}else{
			busCategorybean.setBusCategoryId(busCategoryId);
			
			if(new BusCategoryDAO().update(busCategorybean))
			{
				response.sendRedirect("BusCategoryListServlet");
			}
			else
			{
				response.sendRedirect("busCategoryEdit.jsp");
			}
		}

		
	}

}
