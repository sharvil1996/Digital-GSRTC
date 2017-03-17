package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.bean.BusTypeBean;
import com.dsynhub.digitalgsrtc.bean.OrganizationBean;
import com.dsynhub.digitalgsrtc.dao.BusTypeDAO;
import com.dsynhub.digitalgsrtc.dao.OrganizationDAO;
import com.dsynhub.digitalgsrtc.util.ValidationUtils;

public class OraganizationInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String organizationName = request.getParameter("txtOrgName");
		String organizationAddress = request.getParameter("txtOrgAddress");
		
		boolean isError=false;
		OrganizationBean organizationBean = new OrganizationBean();
		
		if(ValidationUtils.isEmpty(organizationName))
		{
			request.setAttribute("orgName", "<font color=red>* Name is Required</font>");
			isError=true;
		}else{
			request.setAttribute("txtOrgName", organizationName);
			if(organizationName == null)
				organizationName="";
			organizationBean.setOrgName(organizationName);
		}

		if(ValidationUtils.isEmpty(organizationAddress))
		{
			request.setAttribute("orgAddress", "<font color=red>* Name is Required</font>");
			isError=true;
		}else{
			request.setAttribute("txtOrgAddress", organizationAddress);
			if(organizationAddress == null)
				organizationAddress="";
			organizationBean.setOrgAddress(organizationAddress);
		}

		
		if(isError)
		{
			System.out.println("error");
			request.getRequestDispatcher("organizationInsert.jsp").forward(request, response);
		}else{
			System.out.println("success");	
			if(new OrganizationDAO().insert(organizationBean)) {
				response.sendRedirect("OrganizationListServlet");
			}else{
				response.sendRedirect("organizationInsert.jsp");
			}
		}

	
	}

}
