<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.dsynhub.digitalgsrtc.bean.UserBean"%>
<%@page import="java.util.List"%>
<%@page import="com.dsynhub.digitalgsrtc.dao.CityDAO"%>
<%@page import="com.dsynhub.digitalgsrtc.bean.CityBean"%>
<%@page import="java.util.ArrayList"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Registration User</title>
<link rel="icon" href="DigitalGSRTC-photos/logo.ico" />
<script type="text/javascript"
	src="DigitalGSRTC-javaScript/mainscript.js"></script>
<style>
input {
	text-transform: capitalize;
}
</style>
<%
	UserBean userBean = (UserBean) request.getAttribute("userBean");
		if (userBean != null) {
%>
</head>
<body class="col-*-*">
	<%@include file="userHeader.jsp"%>
	<form action="UserProfileUpdateServlet" method="post"
		class="gujju-animation-top ">
		<input type="hidden" name="userId" value="<%=userBean.getUserId()%>">

			<div class="container gujju-card-8">
				<div class="row" style="text-align: center;">
					<h1 class="text-info">
						Your Profile Edit <span class="fa-user-plus fa"></span>
					</h1>
				</div>
				<br />
				<div class="row ">
					<div class="col-lg-8">
						<div class="col-sm-3">
							<font size="+1">Name:</font>
						</div>
						<div class="col-md-3">
							<input type="text" class="form-control" class="form-control"
								id="txtfirstName" name="txtFirstName" maxlength="15"
								oninput="space(this);onlytext(this); nodigit(this);"
								placeholder="First Name" value="<%=userBean.getFirstName()%>" />
							<font color="red">${firstName} </font>
						</div>
						<div class="col-md-3">
							<input type="text" class="form-control" name="txtMiddleName"
								id="txtmiddleName" maxlength="1" placeholder="Middle Name"
								oninput="space(this);onlytext(this); nodigit(this);"
								value="<%=userBean.getMiddleName()%>" /> <font color="red">${middleName}
							</font>
						</div>
						<div class="col-md-3">
							<input type="text" class="form-control" name="txtLastName"
								id="txtlastName" placeholder="Last Name" maxlength="15"
								oninput="space(this);onlytext(this); nodigit(this);"
								value="<%=userBean.getLastName()%>" /> <font color="red">${lastName}
							</font>
						</div>
					</div>
				</div>
				<br />
				<div class="row">

					<br />
					<div class="row">
						<div class="col-lg-8">
							<div class="col-sm-3">
								<font size="+1">Mobile Number:</font>
							</div>
							<div class="col-md-9">

								<input type="text" name="txtMobileNo" class="form-control"
									id="txtmobile" maxlength="10" placeholder="Enter mobile number"
									oninput="space(this);onlydigit(this);"
									value="<%=userBean.getMobileNo()%>" /><font color="red">${mobileNo}
								</font>
							</div>
						</div>
					</div>

					<br />
					<%
						String gen=userBean.getGender(),ml="",fml="";
						if(gen!=null)
						{
							if(gen.equals("male"))
						ml="checked";
							else
						fml="checked";
						}
					%>

					<div class="row">
						<div class="col-lg-8">
							<div class="col-sm-3">
								<font size="+1">Gender:</font>
							</div>
							<div class="col-lg-4">
								<label class="gujju-checkbox"> <input type="radio"
									name="rdoGender" id="rdoGender" value="male" <%=ml%> />
									<div class="gujju-checkmark"></div> Male
								</label> <label class="gujju-checkbox"> <input type="radio"
									name="rdoGender" id="rdoGender" value="female" <%=fml%> />
									<div class="gujju-checkmark"></div> Female
								</label> <font color="red">${msgGender} </font>
							</div>
						</div>

						<br /> <br />
						<div class="row">
							<div class="col-lg-8">
								<div class="col-sm-3">
									<font size="+1">&emsp;Address:</font>
								</div>
								<div class="col-md-9">

									<textarea rows="2" class="form-control" cols="5"
										name="txtAddress"><%=userBean.getAddress()%></textarea>
									<font color="red">${txtAddress} </font>
								</div>
							</div>
						</div>

						<br />
						<div class="row">
							<div class="col-lg-8">
								<div class="col-sm-3">
									<font size="+1">&emsp;City:</font>
								</div>
								<div class="col-md-9">

									<select name="selCityName" id="txtbusdepo" class="form-control"
										style="text-transform: capitalize;">
										<option value="0" selected="selected">select city</option>
										<%
											CityDAO cityDAO = new CityDAO();
														
														List<CityBean> cityList = cityDAO.list();
														
														for(int i=0;i<cityList.size();i++)
														{
															CityBean city = cityList.get(i);
															if(city.getCityId().equals(userBean.getCityId()))
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
									</select> <font color="red">${city} </font>

								</div>
							</div>
						</div>
						<br />
						<div class="row">
							<div class="col-lg-8">
								<div class="col-md-5">
									<input type="submit"
										class="gujju-theme  gujju-blockquote gujju-btn "
										style="margin-left: 190px;" />
								</div>
								<input type="reset"
									class="gujju-blockquote  gujju-btn gujju-green" />
							</div>
							<br></br>
						</div>

					</div>
				</div>
			</div>
	</form>
	<%
		}else{
	%>
	<th align="left"><font size="5" color="red"> No data found</font></th>
	<%
		}
	%>
	<%@include file="footer.jsp"%>

	<script>
		$(document).ready(function() {
			$("#signup").removeClass("gujju-blue gujju-card-24");
			$("#signup").addClass("gujju-theme-d2 gujju-card-24");

		});
	</script>

</body>

</html>