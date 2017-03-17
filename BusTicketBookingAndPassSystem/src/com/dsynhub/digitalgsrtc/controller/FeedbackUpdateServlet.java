package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.bean.FeedbackBean;
import com.dsynhub.digitalgsrtc.dao.FeedbackDAO;
import com.dsynhub.digitalgsrtc.util.ValidationUtils;

@SuppressWarnings("serial")
public class FeedbackUpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String feedbackId=request.getParameter("feedbackId");
		String feedback = request.getParameter("txtFeedback");
		String userId = request.getParameter("selUserName");
		boolean isError=false;
		
		FeedbackBean feedbackBean=new FeedbackBean();
		
		if (ValidationUtils.isEmpty(feedback)) {
			isError = true;
			request.setAttribute("feedback",
					"<font color=red>* Feedback is Required</font>");
		}

		else {
			request.setAttribute("txtfeedback", feedback);
			feedbackBean.setFeedback(feedback);
		}

		if (userId.equals("0")) {
			isError = true;
			request.setAttribute("userName",
					"<font color=red>* UserName is Required</font>");
		}
		else
		{
			request.setAttribute("", userId);
			feedbackBean.setUserId(userId);
		}

		if (isError) {
			System.out.println("error");
			request.getRequestDispatcher("feedbackEdit.jsp").forward(request,
					response);
		} else {
			System.out.println("success");
			
			feedbackBean.setFeedbackId(feedbackId);
			if (new FeedbackDAO().update(feedbackBean)) {

				System.out.println("Record Updated");
				response.sendRedirect("FeedbackListServlet");

			} else {
				System.out.println("Record Not Updated");

			}

		}

	}


}
