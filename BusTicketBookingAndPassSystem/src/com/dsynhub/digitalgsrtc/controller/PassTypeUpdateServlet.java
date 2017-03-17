package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.bean.PassTypeBean;
import com.dsynhub.digitalgsrtc.dao.PassTypeDAO;
import com.dsynhub.digitalgsrtc.util.ValidationUtils;


public class PassTypeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		
		
		String passTypeName = request.getParameter("txtPassTypeName");
		String passTypeId = request.getParameter("passTypeId");
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
			passTypebean.setPassTypeId(passTypeId);
			passTypebean.setPassTypeName(passTypeName);
			request.setAttribute("passTypeBean",passTypebean);
			request.getRequestDispatcher("passTypeEdit.jsp").forward(request, response);
		}else{
			passTypebean.setPassTypeId(passTypeId);
			
			if(new PassTypeDAO().update(passTypebean))
			{
				response.sendRedirect("PassTypeListServlet");
			}
			else
			{
				response.sendRedirect("passTypeEdit.jsp");
			}
		}

		
	}

}
