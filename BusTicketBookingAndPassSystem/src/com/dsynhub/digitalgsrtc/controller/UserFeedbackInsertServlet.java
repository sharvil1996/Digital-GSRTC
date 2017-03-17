package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.bean.FeedbackBean;
import com.dsynhub.digitalgsrtc.dao.FeedbackDAO;
import com.dsynhub.digitalgsrtc.util.ValidationUtils;

public class UserFeedbackInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String feedback = request.getParameter("txtFeedback");
		String userId = request.getParameter("userId");
		boolean isError = false;
		FeedbackBean feedbackBean = new FeedbackBean();
		feedbackBean.setUserId(userId);
		feedbackBean.setFeedback(feedback);

		if (isError) {
			System.out.println("error");
			request.getRequestDispatcher("feedbackInsert.jsp").forward(request,
					response);
		} else {
			request.setAttribute("msgFeedback",
					"Feedback Successfully Send");
			if (new FeedbackDAO().insert(feedbackBean)) {

				System.out.println("Record Inserted");
				
				response.sendRedirect("userHomePage.jsp");

			} else {
				System.out.println("Record Not inserted");

			}

		}

	}

}
