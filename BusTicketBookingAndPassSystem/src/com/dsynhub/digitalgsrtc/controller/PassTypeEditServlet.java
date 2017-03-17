package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.bean.PassTypeBean;
import com.dsynhub.digitalgsrtc.dao.PassTypeDAO;


public class PassTypeEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		
		String passTypeId = request.getParameter("passTypeId");
		
		PassTypeBean passTypeBean = new PassTypeDAO().getByPK(passTypeId);
		if(passTypeBean!=null){
				request.setAttribute("passTypeBean", passTypeBean);
				request.getRequestDispatcher("passTypeEdit.jsp").forward(request, response);
		}else{
				response.sendRedirect("PassTypeListServlet");
		}

		
	}

}
