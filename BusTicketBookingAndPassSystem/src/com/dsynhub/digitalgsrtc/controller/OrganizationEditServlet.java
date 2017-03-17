package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.bean.OrganizationBean;

import com.dsynhub.digitalgsrtc.dao.OrganizationDAO;
public class OrganizationEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String orgId = request.getParameter("orgId");
		System.out.println(orgId);
		OrganizationBean organizationBean = new OrganizationDAO().getByPK(orgId);
		if(organizationBean!=null){
				request.setAttribute("organizationBean", organizationBean);
				request.getRequestDispatcher("organizationEdit.jsp").forward(request, response);
		}else{
				response.sendRedirect("organizationListServlet");
		}

		
	}

}
