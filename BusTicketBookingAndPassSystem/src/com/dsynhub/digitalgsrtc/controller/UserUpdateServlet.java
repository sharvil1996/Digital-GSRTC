package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.bean.UserBean;
import com.dsynhub.digitalgsrtc.dao.UserDAO;
import com.dsynhub.digitalgsrtc.util.ValidationUtils;

@SuppressWarnings("serial")
public class UserUpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String firstName = request.getParameter("txtFirstName");
		String middleName = request.getParameter("txtMiddleName");
		String lastName = request.getParameter("txtLastName");
		String email = request.getParameter("txtEmail");
		String mobileNo = request.getParameter("txtMobileNo");
		String gender = request.getParameter("rdoGender");
		String address = request.getParameter("txtAddress");
		String cityId = request.getParameter("selCityName");
		String isActive=request.getParameter("rdoactive");

		UserBean userBean = new UserBean();

		boolean isError = false;

		if (ValidationUtils.isEmpty(firstName)) {
			isError = true;
			request.setAttribute("firstName",
					"<font color=red>* First Name is Required</font>");
		}

		else {
			request.setAttribute("txtFirstName", firstName);
			userBean.setFirstName(firstName);
			;
		}

		if (ValidationUtils.isEmpty(middleName)) {
			isError = true;
			request.setAttribute("middleName",
					"<font color=red>* Middle Name is Required</font>");
		}

		else {
			request.setAttribute("txtMiddleName", middleName);
			userBean.setMiddleName(middleName);
		}

		if (ValidationUtils.isEmpty(lastName)) {
			isError = true;
			request.setAttribute("lastName",
					"<font color=red>* Last Name is Required</font>");
		}

		else {
			request.setAttribute("txtLastName", lastName);
			userBean.setLastName(lastName);
		}

		if (ValidationUtils.isEmpty(email)) {
			isError = true;
			request.setAttribute("email",
					"<font color=red>* Email is Required</font>");
		}

		else {
			request.setAttribute("txtEmail", email);
			userBean.setEmail(email);
		}

		if (ValidationUtils.isEmpty(mobileNo)) {
			isError = true;
			request.setAttribute("mobileNo",
					"<font color=red>* MobileNo is Required</font>");
		}

		else {
			request.setAttribute("txtmobileNo", mobileNo);
			userBean.setMobileNo(mobileNo);
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
			userBean.setAddress(address);
		}

		if (cityId.equals("0")) {
			isError = true;
			request.setAttribute("city",
					"<font color=red>* CITY is Required</font>");
		}
		else
		{
				request.setAttribute("", cityId);
				userBean.setCityId(cityId);
		}

		if (isError) {
			System.out.println("error");
			request.setAttribute("userBean",userBean);
			request.getRequestDispatcher("userEdit.jsp").forward(request,
					response);
		} else {
			System.out.println("success");
			userBean.setCityId(cityId);
			userBean.setUserId(userId);
			userBean.setGender(gender);
			userBean.setIsActive(isActive);

			if (new UserDAO().update(userBean)) {

				System.out.println("Record Updated");
				response.sendRedirect("UserListServlet");

			} else {
				System.out.println("Record Not Updated");

			}

		}

	}

}
