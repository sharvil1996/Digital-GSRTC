package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.bean.UserBean;
import com.dsynhub.digitalgsrtc.dao.UserDAO;

@SuppressWarnings("serial")
public class UserProfileEditServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		
		UserBean userBean = new UserDAO().getByPK(userId);
		
		
		if(userBean!=null)
		{
			request.setAttribute("userBean",userBean);
			request.getRequestDispatcher("userProfileEdit.jsp").forward(request, response);
		}
	
	
	}

}
