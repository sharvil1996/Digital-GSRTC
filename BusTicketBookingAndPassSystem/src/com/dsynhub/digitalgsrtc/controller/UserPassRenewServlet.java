package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dsynhub.digitalgsrtc.bean.PassBean;
import com.dsynhub.digitalgsrtc.bean.UserBean;
import com.dsynhub.digitalgsrtc.dao.PassDAO;

@SuppressWarnings("serial")
public class UserPassRenewServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		UserBean userBean=(UserBean)session.getAttribute("userBean");
		
		PassBean passBean=new PassDAO().getByUserId(userBean.getUserId());
		System.out.println("sssssss+    "+passBean.getPassId());
		
		if(new PassDAO().isExist(userBean.getUserId()))
		{
			if(new PassDAO().renewPass(passBean))
			{
				session.setAttribute("passBean", passBean);
				response.sendRedirect("UserPassRenewConfirmServlet");
			}
		}
		else
			response.sendRedirect("errorRenewPass.jsp");
	}

}
