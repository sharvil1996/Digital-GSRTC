package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.bean.BusBean;
import com.dsynhub.digitalgsrtc.dao.BusDAO;
import com.dsynhub.digitalgsrtc.util.ValidationUtils;

public class BusInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String busNo = request.getParameter("txtBusNo");
		String busDepoId = request.getParameter("selDepoName");
		String busCategoryId = request.getParameter("selBusCategoryName");
		String busTypeId = request.getParameter("selBusTypeName");
		
		BusBean busBean = new BusBean();
		
		System.out.println(busCategoryId + " " + busDepoId + " " + busNo + " " + busTypeId );
		
		boolean isError = false;
		
		if (ValidationUtils.isEmpty(busNo)) {
			isError = true;
			request.setAttribute("busNo", "please enter bus no");
		}
		else {
			request.setAttribute("txtBusNo", busNo);
			busBean.setBusNo(busNo);
		}
		
		
/*		if (ValidationUtils.isEmpty(capacity)) {
			isError = true;
			request.setAttribute("capacity", "please enter capacity");
		}
		else {
			request.setAttribute("numCapacity", capacity);
			busBean.setCapacity(capacity);
		}
*/		
		
		if (busDepoId.equals("0")) {
			isError = true;
			request.setAttribute("msgDepoName", "Please Select Bus Depo");
		}
		
		if (busTypeId.equals("0")) {
			isError = true;
			request.setAttribute("msgBusTypeName", "please select bus type");
		}
		
		if (busCategoryId.equals("0")) {
			isError = true;
			request.setAttribute("msgBusCategoryName", "please select bus Category");
		}

		
		
		if (isError) 
		{
			System.out.println("error");
			request.getRequestDispatcher("busInsert.jsp").forward(request, response);
		} 
		else 
		{
				System.out.println("success");

				busBean.setBusNo(busNo);
				busBean.setBusCategoryId(busCategoryId);
				busBean.setBusDepoId(busDepoId);
				busBean.setBusTypeId(busTypeId);
				busBean.setCapacity("55");
				
				
				
				
		
				if(new BusDAO().insert(busBean)) {
				  
				  System.out.println("Record Inserted");
				  response.sendRedirect("BusListServlet");
				  
			  } 
			  else {
				  System.out.println("Record Not inserted");
			  
			  }

		}

	}

}
