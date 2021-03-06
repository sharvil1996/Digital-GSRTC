package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.bean.UserBean;
import com.dsynhub.digitalgsrtc.dao.UserDAO;

@SuppressWarnings("serial")
public class UserListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<UserBean> listOfUser = new UserDAO().list();
		
		if(listOfUser!=null)
		{
			request.setAttribute("listOfUser",listOfUser);
			request.getRequestDispatcher("userList.jsp").forward(request, response);
		}
	}

}
