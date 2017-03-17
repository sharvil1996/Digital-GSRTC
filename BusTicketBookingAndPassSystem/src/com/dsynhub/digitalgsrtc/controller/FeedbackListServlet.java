package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.bean.FeedbackBean;
import com.dsynhub.digitalgsrtc.dao.FeedbackDAO;

@SuppressWarnings("serial")
public class FeedbackListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<FeedbackBean> listOfFeedback = new FeedbackDAO().list();
		
		if(listOfFeedback!=null)
		{
			request.setAttribute("listOfFeedback",listOfFeedback);
			request.getRequestDispatcher("feedbackList.jsp").forward(request, response);
		}
	}

}
