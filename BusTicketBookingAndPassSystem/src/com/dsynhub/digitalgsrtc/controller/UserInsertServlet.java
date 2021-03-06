package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.bean.UserBean;
import com.dsynhub.digitalgsrtc.dao.UserDAO;
import com.dsynhub.digitalgsrtc.util.ValidationUtils;

public class UserInsertServlet extends HttpServlet {
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
		String mobileNo = request.getParameter("txtMobileNo");
		String gender = request.getParameter("rdoGender");
		String address = request.getParameter("txtAddress");
		String cityId = request.getParameter("selCityName");
		String confirmPassword = request.getParameter("txtCPassword");

		UserBean userBean = new UserBean();

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

		else if(!ValidationUtils.EmailFormatValidator(email))
		{
			isError=true;
			request.setAttribute("email", "* Email Format is not valid....");
		}
		else {
			request.setAttribute("txtEmail", email);
			userBean.setEmail(email);
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
			userBean.setMobileNo(mobileNo);
		}
		
		if (ValidationUtils.isEmpty(password)) {
			isError = true;
			request.setAttribute("password",
					"<font color=red>* PassWord is Required</font>");
		}

		else {
			request.setAttribute("pwd", password);
			userBean.setPassword(ValidationUtils.base64encode(password));
			System.out.println("ADmin PAssword..."+ValidationUtils.base64decode(userBean.getPassword()));
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
			request.getRequestDispatcher("userInsert.jsp").forward(request,
					response);
		} else {
			System.out.println("success");
			userBean.setCityId(cityId);
			userBean.setGender(gender);

			if (new UserDAO().insert(userBean)) {

				  SendEmail mail =new SendEmail();
			        String s = mail.SendEmail("REGISTRATION", email, "Reg successfully to DIGITAL INDIA....!!!     Now You Can Book Your Ticket Or Create Or Renew Your Pass...!!     Thanks For Registration..." + firstName+ " " + lastName+ "!!");

				
				
				System.out.println("Record Inserted");
				response.sendRedirect("UserListServlet");

			} else {
				System.out.println("Record Not inserted");

			}

		}
	}

}
