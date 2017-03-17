package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.bean.PassTypeBean;
import com.dsynhub.digitalgsrtc.dao.PassTypeDAO;
import com.dsynhub.digitalgsrtc.util.ValidationUtils;


public class PassTypeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String passTypeName = request.getParameter("txtPassTypeName");
		
		boolean isError=false;
		PassTypeBean passTypebean = new PassTypeBean();
		if(ValidationUtils.isEmpty(passTypeName))
		{
			request.setAttribute("passTypeName", "<font color=red>* Name is Required</font>");
			isError=true;
		}else{
			request.setAttribute("txtPassTypeName", passTypeName);
			if(passTypeName == null)
				passTypeName="";
			passTypebean.setPassTypeName(passTypeName);
		}
		
		if(isError)
		{
			System.out.println("error");
			request.getRequestDispatcher("passTypeInsert.jsp").forward(request, response);
		}else{
			System.out.println("success");	
			if(new PassTypeDAO().insert(passTypebean)) {
				response.sendRedirect("PassTypeListServlet");
			}else{
				response.sendRedirect("passTypeInsert.jsp");
			}
		}

	
	}

}
