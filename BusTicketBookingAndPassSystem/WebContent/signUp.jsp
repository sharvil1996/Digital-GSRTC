<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.util.List"%>
<%@page import="com.dsynhub.digitalgsrtc.dao.CityDAO"%>
<%@page import="com.dsynhub.digitalgsrtc.bean.CityBean"%>
<%@page import="java.util.ArrayList"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Registration User</title>
<link rel="icon" href="DigitalGSRTC-photos/logo.ico" />
<script type="text/javascript" src="DigitalGSRTC-javaScript/mainscript.js"></script>
<style >
input
{
text-transform: capitalize;
}
</style>
</head>
<body class="col-*-*">
<%
		String loginAdminCheck = (String) session.getAttribute("loginAdminCheck");
		String loginUserCheck = (String) session.getAttribute("loginUserCheck");
		if (loginAdminCheck != null && loginUserCheck ==null) 
			response.sendRedirect("adminDashBoard.jsp");
		else if (loginAdminCheck == null && loginUserCheck !=null) 
			response.sendRedirect("userHomePage.jsp");
		else{
%>
	<%@include file="header.jsp"%>
		<form action="UserSignUpServlet" method="post"
			class="gujju-animation-top " >
			<div class="container gujju-card-8">
				<div class="row" style="text-align: center;">
					<h1 class="text-info">
						Registration <span class="fa-user-plus fa"></span>
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
								id="txtfirstName" name="txtFirstName" maxlength="15" oninput="space(this);onlytext(this); nodigit(this);"  
								placeholder="First Name" value="${param.txtfirstName}"  required/> <font
								color="red">${firstName} </font>
						</div>
						<div class="col-md-3">
							<input type="text" class="form-control" name="txtMiddleName"
								id="txtmiddleName" maxlength="1" placeholder="Middle Name" oninput="space(this);onlytext(this); nodigit(this);" 
								value="${param.txtmiddleName}" required/> <font color="red" >${middleName}
							</font>
						</div>
						<div class="col-md-3">
							<input type="text" class="form-control" name="txtLastName"
								id="txtlastName" placeholder="Last Name" maxlength="15" oninput="space(this);onlytext(this); nodigit(this);" 
								value="${param.txtlastName}" required/> <font color="red">${lastName}
							</font>
						</div>
					</div>
				</div>
				<br />
				<div class="row">
					<div class="col-lg-8">
						<div class="col-sm-3">
							<font size="+1">Email:</font>
						</div>
						<div class="col-md-9">

							<input type="email" class="form-control" name="txtEmail"
								id="txtemail" maxlength="30" placeholder="Enter Email" style="text-transform: none;"
								value="${param.txtemail}" required/><font color="red">${email}
							</font>
						</div>
					</div>
					<br /> <br /> <br />
					<div class="row">
						<div class="col-lg-8">
							<div class="col-sm-3">
								<font size="+1">Password:</font>
							</div>
							<div class="col-md-9">
								<input type="password" class="form-control" name="txtPassword"
									id="txtpassword" maxlength="30" placeholder="Create password" style="text-transform: none;"
									value="${param.pwdpassword}" required/> <font color="red">${password}
								</font>
							</div>
						</div>
					</div>

					<br /> <br />
					<div class="row">
						<div class="col-lg-8">
							<div class="col-sm-3">
								<font size="+1">Conform Password:</font>
							</div>
							<div class="col-md-9">
								<input type="password" class="form-control" name="txtCPassword"
									id="txtpassword" maxlength="30" placeholder="Re-enter password" style="text-transform: none;"
									value="${param.pwdcpassword}" required/> <font color="red">${cpassword}
								</font>

							</div>
						</div>
					</div>

					<br />
					<div class="row">
						<div class="col-lg-8">
							<div class="col-sm-3">
								<font size="+1">Mobile Number:</font>
							</div>
							<div class="col-md-9">

								<input type="text" name="txtMobileNo" class="form-control"
									id="txtmobile" maxlength="10" placeholder="Enter mobile number"
									value="${param.txtmobile}" oninput="space(this);onlydigit(this);" required/><font color="red">${mobileNo}
								</font>
							</div>
						</div>
					</div>

					<br />
					<% String gen=request.getParameter("rdoGender"),ml="",fml="";
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
									<label class="gujju-checkbox">
									 <input type="radio" name="rdogender" id="rdoGender"
										value="male" <%=ml %>  checked />
											<div class="gujju-checkmark"></div>
											 Male 
									</label> 
									<label class="gujju-checkbox">
									 <input
											type="radio" name="rdogender" id="rdoGender"
										value="female" <%=fml %> />
												<div class="gujju-checkmark"></div>
												 Female 
									</label>
									<font color="red">${msggender} </font>
						</div>
					</div>

					<br />
									<br />
					<div class="row">
						<div class="col-lg-8">
							<div class="col-sm-3">
								<font size="+1">&emsp;Address:</font>
							</div>
							<div class="col-md-9">
								<textarea rows="2" class="form-control" cols="5" name="txtAddress" required>${param.txtaddress}</textarea>
								<font color="red">${txtAddress}</font>
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

								<select name="selCityName" id="txtbusdepo" class="form-control" required>
									<option value="0" selected="selected">select city</option>
									<% List<CityBean>  cityBeansList=new CityDAO().list();

for(int i=0;i<cityBeansList.size();i++)
{

	String tmp="unselected";
	String type=request.getParameter("selcity");
	if(type==null)
	tmp="unselected";
	else if(Integer.parseInt((cityBeansList.get(i).getCityId()))==Integer.parseInt(type))
	tmp="selected";


%>


									<option value=<%=cityBeansList.get(i).getCityId()%> <%=tmp %>><%=cityBeansList.get(i).getCityName() %></option>
									<% } %>
								</select> <font color="red">${city} </font>

							</div>
						</div>
					</div>
					<br />
					<div class="row">
						<div class="col-lg-8">
							<div class="col-md-5">
								<input type="submit" class="gujju-theme  gujju-blockquote gujju-btn "
									style="margin-left: 190px;" />
							</div>
							<input type="reset" class="gujju-blockquote  gujju-btn gujju-green" />
						</div>
<br></br>
					</div>

				</div>
			</div>
	</div>	</form>
 	<%@include
		file="footer.jsp"%> 
 	
<script>
			$(document).ready(function() {
				$("#signup").removeClass("gujju-blue gujju-card-24");
				$("#signup").addClass("gujju-theme-d2 gujju-card-24");
				 
			});
			</script>
<%} %>
</body>
	
</html>
