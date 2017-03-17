package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.bean.BusTypeBean;
import com.dsynhub.digitalgsrtc.dao.BusTypeDAO;
import com.dsynhub.digitalgsrtc.util.ValidationUtils;


public class BusTypeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		
		
		String busTypeName = request.getParameter("txtBusTypeName");
		String busTypeId = request.getParameter("busTypeId");
		boolean isError=false;
		
		
		BusTypeBean busTypebean = new BusTypeBean();
		
		if(ValidationUtils.isEmpty(busTypeName))
		{
			request.setAttribute("busTypeName", "<font color=red>* Name is Required</font>");
			isError=true;
		}else{
			request.setAttribute("txtBusTypeName", busTypeName);
			if(busTypeName == null)
				busTypeName="";
			busTypebean.setBusTypeName(busTypeName);
		}
		
		if(isError)
		{
			busTypebean.setBusTypeId(busTypeId);
			busTypebean.setBusTypeName(busTypeName);
			request.setAttribute("busTypeBean",busTypebean);
			request.getRequestDispatcher("busTypeEdit.jsp").forward(request, response);
		}else{
			busTypebean.setBusTypeId(busTypeId);
			
			if(new BusTypeDAO().update(busTypebean))
			{
				response.sendRedirect("BusTypeListServlet");
			}
			else
			{
				response.sendRedirect("busTypeEdit.jsp");
			}
		}

		
	}

}
