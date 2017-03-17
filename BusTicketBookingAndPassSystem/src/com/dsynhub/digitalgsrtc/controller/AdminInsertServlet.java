package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.bean.AdminBean;
import com.dsynhub.digitalgsrtc.dao.AdminDAO;
import com.dsynhub.digitalgsrtc.util.ValidationUtils;

public class AdminInsertServlet extends HttpServlet {
	static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String firstName = request.getParameter("txtFirstName");
		String middleName = request.getParameter("txtMiddleName");
		String lastName = request.getParameter("txtLastName");
		String email = request.getParameter("txtEmail");
		String password = request.getParameter("txtPassword");
		String confirmPassword = request.getParameter("txtCPassword");
		String mobileNo = request.getParameter("txtMobileNo");
		String gender = request.getParameter("rdoGender");
		String address = request.getParameter("txtAddress");
		String cityId = request.getParameter("selCityName");
		AdminBean adminBean = new AdminBean();
		System.out.println(gender+"<");
		boolean isError = false;
		
		if(gender==null)
		{
			isError=true;
			request.setAttribute("gender", "* select gender");
			
		}
		if(ValidationUtils.isEmpty(confirmPassword))
		{
			isError=true;
			request.setAttribute("cpassword", "*confirm password");
		}
		else if(password!=null && !password.equals(confirmPassword))
		{
			isError=true;
			request.setAttribute("cpassword", "confirm password does not match");
		}
		
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
		else if(!ValidationUtils.EmailFormatValidator(email))
		{
			isError=true;
			request.setAttribute("email", "* EmailFormate is not Valid.....");
		}
		else {
			request.setAttribute("txtEmail", email);
			adminBean.setEmail(email);
		}

		if (ValidationUtils.isEmpty(password)) {
			isError = true;
			request.setAttribute("password",
					"<font color=red>* PassWord is Required</font>");
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
		
		if (ValidationUtils.isEmpty(password)) {
			isError = true;
			request.setAttribute("password",
					"<font color=red>* PassWord is Required</font>");
		}

		else {
			request.setAttribute("pwd", password);
			adminBean.setPassword(ValidationUtils.base64encode(password));
			System.out.println("ADmin PAssword..."+ValidationUtils.base64decode(adminBean.getPassword()));
		}




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
			request.getRequestDispatcher("adminInsert.jsp").forward(request,
					response);
		} else {
			System.out.println("success");
			adminBean.setCityId(cityId);
			adminBean.setGender(gender);

			if (new AdminDAO().insert(adminBean)) {

				  SendEmail mail =new SendEmail();
			        String s = mail.SendEmail("REGISTRATION", email, "Reg successfully to DIGITAL INDIA....!!!     Now You Can Book Your Ticket Or Create Or Renew Your Pass...!!     Thanks For Registration..." + firstName+ " " + lastName+ "!!");

				
				System.out.println("Record Inserted");
				response.sendRedirect("AdminListServlet");

			} else {
				System.out.println("Record Not inserted");

			}

		}
	}

}
