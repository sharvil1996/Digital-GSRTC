<%@page import="com.dsynhub.digitalgsrtc.bean.*"%>
<%@page import="com.dsynhub.digitalgsrtc.dao.CityDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		UserBean userBean = (UserBean) request.getAttribute("userBean");
		if (userBean != null) {
	%>
	<form action="UserUpdateServlet" method="post" name="cityForm">
		<table>
			<input type="hidden" name="userId" value="<%=request.getParameter("userId")%>">
			<tr>
				<th align="left"><font size="5" color="blue"> First Name</font></th>
				<th><font size="5" color="red">:</font></th>
				<td><input type="text" value="${userBean.getFirstName()}" placeholder="Your First Name"
					name="txtFirstName" size="26" style="height: 19px; float: left;">
					${firstName}</td>
			</tr>
			<tr>
				<th align="left"><font size="5" color="blue"> Middle Name</font></th>
				<th><font size="5" color="red">:</font></th>
				<td><input type="text" value="${userBean.getMiddleName()}" placeholder="Your Middle Name"
					name="txtMiddleName" size="26" style="height: 19px; float: left;">
					${middleName}</td>
			</tr>
			<tr>
				<th align="left"><font size="5" color="blue"> Last Name</font></th>
				<th><font size="5" color="red">:</font></th>
				<td><input type="text" value="${userBean.getLastName()}" placeholder="Your Last Name"
					name="txtLastName" size="26" style="height: 19px; float: left;">
					${lastName}</td>
			</tr>
			<tr>
				<th align="left"><font size="5" color="blue">Email</font></th>
				<th><font size="5" color="red">:</font></th>
				<td><input type="text" value="${userBean.getEmail()}" placeholder="abc@gmail.com"
					name="txtEmail" size="26" style="height: 19px; float: left;">
					${email}</td>
			</tr>
			<tr>
				<th align="left"><font size="5" color="blue">Mobile NO</font></th>
				<th><font size="5" color="red">:</font></th>
				<td><input type="text" value="${userBean.getMobileNo()}" placeholder="1234567890"
					name="txtMobileNo" size="26" style="height: 19px; float: left;">
					${mobileNo}</td>
			</tr>
			
			<tr>
				<th align="left"><font size="5" color="blue">Gender</font></th>
				<th><font size="5" color="red">:</font></th>
				<td>
					Male<input type="radio" name="rdoGender" id="rdoMale" value="male" checked="checked" value="${rdoGender}">
					Female<input type="radio" name="rdoGender" id="rdoFemale" value="female" value="${rdoGender}">
				</td>
			</tr> 

			<tr>
				<th align="left"><font size="5" color="blue">Address</font></th>
				<th><font size="5" color="red">:</font></th>
				<td>
					<textarea rows="5" cols="30" name="txtAddress">${userBean.getAddress()}</textarea>
					${address}
					</td>
			</tr>
			
			<tr>
				<th align="left"><font size="5" color="blue">City Name</font></th>
				<th><font size="5" color="red">:</font></th>
				<td>
					<select name="selCityName" id="selCityName">
					<option value="0" selected="selected">Select City</option>
					<% 
						UserBean user = (UserBean)request.getAttribute("userBean");		
					
						CityDAO cityDAO = new CityDAO();
						
						List<CityBean> cityList = cityDAO.list();
						
						for(int i=0;i<cityList.size();i++)
						{
							CityBean city = cityList.get(i);
							if(city.getCityId().equals(user.getCityId()))
							{
							%>
								<option value="<%=city.getCityId()%>" selected="selected"><%=city.getCityName()%></option>
							<%
							}		
							else
							{
					 			%>
						 			<option value="<%=city.getCityId()%>"><%=city.getCityName()%></option>
								<%
							}
						}
					%>	
					</select>
				${cityName}
				</td>
			</tr>	
			
			<tr><div class="row">
					<div class="col-lg-8">
						<td><label class="col-sm-3"><font size="+1">
								Is Active: </font> </label></td>

						<td><div class="col-md-4">
							<%
								String y = "", n = "";
								if (userBean.getIsActive().equals("y"))
									y = "checked";
								else
									n = "checked";
							%>

							<div class="col-sm-5">
								<input type="radio" name="rdoactive" value="y" <%=y%> /> <font>Yes</font>
							</div>
							<div class="col-sm-5">
								<input type="radio" name="rdoactive" value="n" <%=n%> /> <font>No</font>
							</div></td>
						</div>
					</div>
				</div>
			
			<tr>
				<td align="center"><br> <input type="reset" value="Reset"
					name="reset"
					style="background-color: red; color: white; width: 100px; height: 30px">
				</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="Submit" value="Ragister" name="submit"
					style="background-color: Green; color: white; width: 100px; height: 30px">
				</td>
			</tr>
		</table>
	</form>
	<%}else{%>
	 	<th align="left"><font size="5" color="red"> No data found</font></th> <%} %>
</body>
</html>







