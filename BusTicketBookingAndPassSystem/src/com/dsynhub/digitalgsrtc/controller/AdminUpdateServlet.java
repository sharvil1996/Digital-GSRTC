package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.bean.AdminBean;
import com.dsynhub.digitalgsrtc.dao.AdminDAO;
import com.dsynhub.digitalgsrtc.util.ValidationUtils;

@SuppressWarnings("serial")
public class AdminUpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String adminId = request.getParameter("adminId");
		String firstName = request.getParameter("txtFirstName");
		String middleName = request.getParameter("txtMiddleName");
		String lastName = request.getParameter("txtLastName");
		String email = request.getParameter("txtEmail");
		String mobileNo = request.getParameter("txtMobileNo");
		String gender = request.getParameter("rdoGender");
		String address = request.getParameter("txtAddress");
		String cityId = request.getParameter("selCityName");
		String isActive=request.getParameter("rdoactive");
		String password = request.getParameter("pwdpassword");
		
		
		AdminBean adminBean = new AdminBean();

		boolean isError = false;

		if (ValidationUtils.isEmpty(firstName)) {
			isError = true;
			request.setAttribute("firstName",
					"<font color=red>* First Name is Required</font>");
		}

		else {
			request.setAttribute("txtFirstName", firstName);
			adminBean.setFirstName(firstName);
		}

		if (ValidationUtils.isEmpty(middleName)) {
			isError = true;
			request.setAttribute("middleName",
					"<font color=red>* Middle Name is Required</font>");
		}

		else {
			request.setAttribute("txtMiddleName", middleName);
			adminBean.setMiddleName(middleName);
		}

		if (ValidationUtils.isEmpty(lastName)) {
			isError = true;
			request.setAttribute("lastName",
					"<font color=red>* Last Name is Required</font>");
		}

		else {
			request.setAttribute("txtLastName", lastName);
			adminBean.setLastName(lastName);
		}

		if (ValidationUtils.isEmpty(email)) {
			isError = true;
			request.setAttribute("email",
					"<font color=red>* Email is Required</font>");
		}

		else {
			request.setAttribute("txtEmail", email);
			adminBean.setEmail(email);
		}

		if (ValidationUtils.isEmpty(mobileNo)) {
			isError = true;
			request.setAttribute("mobileNo",
					"<font color=red>* MobileNo is Required</font>");
		}

		else {
			request.setAttribute("txtmobileNo", mobileNo);
			adminBean.setMobileNo(mobileNo);
		}

		/*
		 * memberDOB=memberDOB.replaceAll("/", "-"); String
		 * a[]=memberDOB.split("-"); memberDOB=a[2]+"-"+a[0]+"-"+a[1];
		 * System.out.println(memberDOB);
		 */

		if (ValidationUtils.isEmpty(address)) {
			isError = true;
			request.setAttribute("address",
					"<font color=red>* ADDRESS is Required</font>");
		}

		else {
			request.setAttribute("txtaddress", address);
			adminBean.setAddress(address);
		}

		if (cityId.equals("0")) {
			isError = true;
			request.setAttribute("city",
					"<font color=red>* CITY is Required</font>");
		}
		else
		{
				request.setAttribute("", cityId);
				adminBean.setCityId(cityId);
		}

		if (isError) {
			System.out.println("error");
			adminBean.setPassword(password);
			adminBean.setAdminId(adminId);
			adminBean.setGender(gender);
			adminBean.setIsActive(isActive);
			request.setAttribute("adminBean",adminBean);
			request.getRequestDispatcher("adminEdit.jsp").forward(request,
					response);
		} else {
			System.out.println("success");
			adminBean.setCityId(cityId);
			adminBean.setAdminId(adminId);
			adminBean.setGender(gender);
			adminBean.setIsActive(isActive);

			if (new AdminDAO().update(adminBean)) {

				System.out.println("Record Updated");
				response.sendRedirect("AdminListServlet");

			} else {
				System.out.println("Record Not Updated");

			}

		}

	}

}
