package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.bean.BusBean;
import com.dsynhub.digitalgsrtc.dao.BusDAO;
import com.dsynhub.digitalgsrtc.util.ValidationUtils;

public class BusUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String busNo = request.getParameter("txtBusNo");
		String capacity = request.getParameter("numCapacity");
		String busDepoId = request.getParameter("selDepoName");
		String busCategoryId = request.getParameter("selBusCategoryName");
		String busTypeId = request.getParameter("selBusTypeName");
		String isAvailable = request.getParameter("rdoAvalibility");
		
		BusBean busBean = new BusBean();
		
		System.out.println(busCategoryId + " " + busDepoId + " " + busNo + " " + busTypeId + " " + capacity);
		
		boolean isError = false;
		
		if (ValidationUtils.isEmpty(busNo)) {
			isError = true;
			request.setAttribute("busNo", "please enter bus no");
		}
		else {
			request.setAttribute("txtBusNo", busNo);
			busBean.setBusNo(busNo);
		}
		
		
		if (ValidationUtils.isEmpty(capacity)) {
			isError = true;
			request.setAttribute("capacity", "please enter capacity");
		}
		else {
			request.setAttribute("numCapacity", capacity);
			busBean.setCapacity(capacity);
		}
		
		
		if (busDepoId.equals("0")) {
			isError = true;
			request.setAttribute("msgDepoName", "Please Select Bus Depo");
		}else{
			request.setAttribute("", busDepoId);
			busBean.setBusDepoId(busDepoId);
		}
		
		if (busTypeId.equals("0")) {
			isError = true;
			request.setAttribute("msgBusTypeName", "please select bus type");
		}else{
			request.setAttribute("", busTypeId);
			busBean.setBusTypeId(busTypeId);
		}
		
		if (busCategoryId.equals("0")) {
			isError = true;
			request.setAttribute("msgBusCategoryName", "please select bus Category");
		}else{
			request.setAttribute("", busCategoryId);
			busBean.setBusCategoryId(busCategoryId);
		}

		
		
		if (isError) 
		{
			System.out.println("error");
			request.setAttribute("busBean",busBean);
			request.getRequestDispatcher("busEdit.jsp").forward(request, response);
		} 
		else 
		{
				System.out.println("success");

				busBean.setBusNo(busNo);
				busBean.setBusCategoryId(busCategoryId);
				busBean.setBusDepoId(busDepoId);
				busBean.setBusTypeId(busTypeId);
				busBean.setCapacity(capacity);
				busBean.setIsAvailable(isAvailable);
				
				
				
				
		
				if(new BusDAO().update(busBean)) {
				  
				  System.out.println("Record Inserted");
				  response.sendRedirect("BusListServlet");
				  
			  } 
			  else {
				  System.out.println("Record Not inserted");
			  
			  }

		}

	}

}
