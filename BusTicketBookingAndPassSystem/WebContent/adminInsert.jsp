<%@page import="com.dsynhub.digitalgsrtc.bean.CityBean"%>
<%@page import="com.dsynhub.digitalgsrtc.dao.CityDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin | Admin Insert</title>
<noscript>
	<div style="color: #FF0000">place enable java script</div>
</noscript>
<script type="text/javascript" src="DigitalGSRTC-javaScript/mainscript.js"></script>
<link rel="icon" href="DigitalGSRTC-photos/logo.ico" />
</head>
<body>
<%@ include file="adminHeader.jsp"%>
<div style="margin-top: -850px;margin-left: 250px;">
	<section class="content-header">
	<h1>
		Admin <small>Insert</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="adminDashBoard.jsp"><i class="fa fa-dashboard"></i>
				Home</a></li>
		<li class="active">Admin</li>
	</ol>
	</section><br><br>
	<div class="col-lg-6">
		<div class="container">
			<form action="AdminInsertServlet" method="post" name="Registration">
				<br />
				<div class="row ">
					<label class="col-sm-2"> <font size="+1">Name :</font> </label>
					<div class="col-sm-2">
						<input type="text" class="form-control" name="txtFirstName"
							maxlength="15" placeholder="First Name"
							value="${txtFirstName}" oninput="space(this);onlytext(this); nodigit(this);" /> 
						<font color="red">${firstName}
						</font>
					</div>
					<div class="col-sm-2">
						<input type="text" class="form-control" name="txtMiddleName"
							maxlength="15" placeholder="Middle Name"
							value="${txtMiddleName}" oninput="space(this);onlytext(this); nodigit(this);" />
							 <font  style="color: red;">${middleName}</font>
					</div>
					<div class="col-sm-2">
						<input type="text" class="form-control" name="txtLastName"
							maxlength="15" placeholder="Last Name"
							value="${txtLastName}" oninput="space(this);onlytext(this); nodigit(this);" /> 
							<font color="red">${lastName}</font>
					</div>
				</div>
				<br />
				<div class="row">
					<label class="col-sm-2"> <font size="+1">Email :</font> </label>

					<div class="col-lg-6">
						<input type="text" class="form-control" name="txtEmail"
							placeholder="example@gmail.com" maxlength="30"
							value="${txtEmail}" /> <font color="red">${email}
						</font>
					</div>
				</div>
				<br />
				<div class="row">
					<label class="col-sm-2"> <font size="+1">Password :</font>
					</label>
					<div class="col-lg-6">
						<input type="password" class="form-control" name="txtPassword"
							value="${pwd}" placeholder="Create Password"
							maxlength="30" /> <font color="red">${password}
						</font>
					</div>
				</div>
				<br />
				<div class="row">
					<label class="col-sm-2"> <font size="+1">Conform
							Password :</font> </label>
					<div class="col-lg-6">
						<input type="password" class="form-control" name="txtCPassword"
							placeholder="Re-Enter Password" maxlength="30"
							value="${cpwd}" /> <font color="red">${cpassword}
						</font>
					</div>
				</div>
				<br />
				<div class="row">
				  	<label class="col-sm-2"> <font size="+1">Mobile No :</font> </label>
					<div class="col-lg-6">
						<input type="text" class="form-control" name="txtMobileNo"
							placeholder="mobile number" maxlength="10" value="${txtmobileNo}" oninput="space(this);onlydigit(this);"/> 
						<font color="red">${mobileNo}</font>
					</div>
				</div>
				<br />
				<div class="row">
						<%
							String gen = request.getParameter("rdoGender"), ml = "", fml = "";
							if (gen != null) {

								if (gen.equals("male"))
									ml = "checked";
								else
									fml = "checked";
							}
						%>
						<label class="col-sm-3"><font size="+1">Gender: </font>
						</label>
						<div class="col-md-7">
							<div class="col-sm-6">
								<input type="radio" class="radio" name="rdoGender" value="male"
									<%=ml%> />Male
							</div>
							<div class="col-sm-6">
								<input type="radio" class="radio" name="rdoGender"
									placeholder="Enter Mobile" <%=fml%> value="female" /> <font>Female</font>
							</div>
						</div>
				</div>
					&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
					<font color="red">${gender}
					</font>
				<br />
				
				
				
				<div class="row">
					<label class="col-sm-2"> <font size="+1">Address :</font> </label>
					<div class="col-lg-6">
						<textarea maxlength="255" rows="3" class="form-control" cols="18" name="txtAddress">${txtAddress}</textarea>
						<font color="red">${address}</font>
					</div>
				</div>
				<br />
				
				<div class="row">
					<label class="col-sm-2"> <font size="+1">City :</font> </label>
					<div class="col-lg-6">
						<select name="selCityName" id="txtbusdepo" class="form-control">
							<option value="0">Select City</option>
							<% 
						CityDAO cityDAO = new CityDAO();
						List<CityBean> cityList = cityDAO.list();
						
						for(int i=0;i<cityList.size();i++)
						{
	
							String tmp="unselected";
							String type=request.getParameter("selCityName");
							if(type==null)
								tmp="unselected";
							else if(cityList.get(i).getCityId().equals(type))
								tmp="selected";
					%>	
	
					<option value=<%=cityList.get(i).getCityId()%> <%=tmp %> > <%=cityList.get(i).getCityName() %></option>
					<% 
						}
					%>
					</select>
					<font color="red">${city}</font>
					</div>
				</div>
				<br />
				<br />
				
					<label class="col-sm-2 control-label"></label>
					<input type="reset" value="Reset" name="reset"
						class="btn  btn-danger">
					&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
					<input type="Submit" value="Ragister" name="submit"
						class="btn btn-success">
					
			</form>
		</div>
	</div>
</div>
</body>
</html>