
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.util.List"%>
<%@page import="com.dsynhub.digitalgsrtc.bean.AdminBean"%>
<%@page import="com.dsynhub.digitalgsrtc.dao.CityDAO"%>
<%@page import="com.dsynhub.digitalgsrtc.bean.CityBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin | Admin Update</title>

</head>
<body>
<%@ include file="adminHeader.jsp"%>
<div style="margin-top: -850px;margin-left: 250px;">
	<section class="content-header">
	<h1>
		Admin <small>Update</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="adminDashBoard.jsp"><i class="fa fa-dashboard"></i>
				Home</a></li>
		<li class="active">Admin</li>
	</ol>
	</section><br><br>
	<%	
		AdminBean adminBean = (AdminBean) request.getAttribute("adminBean"); 
		if(adminBean != null)
		{
	%>
	<div class="col-lg-6">
		<div class="container">
			<form action="AdminUpdateServlet" method="post" name="Registration">
				<input type="hidden" name="adminId" value="<%=request.getParameter("adminId")%>"/>
				<br />
				<div class="row ">
					<label class="col-sm-2"> <font size="+1">Name :</font> </label>
					<div class="col-sm-2">
						<input type="text" class="form-control" name="txtFirstName"
							maxlength="15" placeholder="First Name"
							value="${adminBean.firstName}" /> 
						<font color="red">${firstName}
						</font>
					</div>
					<div class="col-sm-2">
						<input type="text" class="form-control" name="txtMiddleName"
							maxlength="15" placeholder="Middle Name"
							value="${adminBean.middleName}" />
							 <font  style="color: red;">${middleName}</font>
					</div>
					<div class="col-sm-2">
						<input type="text" class="form-control" name="txtLastName"
							maxlength="15" placeholder="Last Name"
							value="${adminBean.lastName}" /> <font color="red">${lastName}
						</font>
					</div>
				</div>
				<br />
				<div class="row">
					<label class="col-sm-2"> <font size="+1">Email :</font> </label>

					<div class="col-lg-6">
						<input type="text" class="form-control" name="txtEmail"
							placeholder="example@gmail.com" maxlength="30"
							value="${adminBean.email}" /> <font color="red">${email}
						</font>
					</div>
				</div>
				<br />
				<div class="row">
					<label class="col-sm-2"> <font size="+1">Password :</font>
					</label>
					<div class="col-lg-6">
						<input type="password" class="form-control" name="txtPassword"
							value="${adminBean.password}" readonly="readonly" placeholder="Create Password"
							maxlength="30" /> <font color="red">${password}
						</font>
					</div>
				</div>
				<br />
				
				<div class="row">
				  	<label class="col-sm-2"> <font size="+1">Mobile No :</font> </label>
					<div class="col-lg-6">
						<input type="text" class="form-control" name="txtMobileNo"
							placeholder="mobile number" maxlength="10"
							value="${adminBean.getMobileNo()}" /> <font color="red">${mobileNo}
						</font>
					</div>
				</div>
				<br />
				<div class="row">
						<%
							String gen = adminBean.getGender();
							String ml = "", fml = "";
							if (gen.equals("male"))
								ml = "checked";
							else
								fml = "checked";
						%>
						<label class="col-sm-3"><font size="+1">Gender: </font>
						</label>
						<div class="col-md-7">
							<div class="col-sm-6">
								<input type="radio" name="rdoGender" id="rdoGender" value="male"
									<%=ml%> /> <font>Male</font>
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
						<textarea maxlength="255" rows="3" class="form-control" cols="18" name="txtAddress">${adminBean.getAddress()}</textarea>
						<font color="red">${address}</font>
					</div>
				</div>
				<br />
				
				<div class="row">
					<label class="col-sm-2"> <font size="+1">City :</font> </label>
					<div class="col-lg-6">
						<select name="selCityName" id="txtbusdepo" class="form-control">
							<option value="0">Select City</option>
							<option value="0" selected="selected">select city</option>
							<%
								List<CityBean> cityBeansList = new CityDAO().list();
								int type = Integer.parseInt(adminBean.getCityId());
								for (int i = 0; i < cityBeansList.size(); i++) {

									String tmp = "unselected";
									if (Integer.parseInt(cityBeansList.get(i).getCityId()) == type)
										tmp = "selected";
							%>


							<option value=<%=cityBeansList.get(i).getCityId()%> <%=tmp%>><%=cityBeansList.get(i).getCityName()%></option>
							<%
								}
							%>
						</select><font color="red" ><b>${msgcity}</b></font>
					</div>
				</div>
				<br />
				
				<div class="row">
						<%
								String y = "", n = "";
								if (adminBean.getIsActive().equals("y"))
									y = "checked";
								else
									n = "checked";
							%>
						<label class="col-sm-3"><font size="+1">Is Active : </font>
						</label>
						<div class="col-md-7">
							<div class="col-sm-6">
								<input type="radio" name="rdoactive" value="y" <%=y%> /> <font>Yes</font>
							</div>
							<div class="col-sm-6">
								<input type="radio" name="rdoactive" value="n" <%=n%> /> <font>No</font>
							</div>
						</div>
				</div>
					&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
					<font color="red">${gender}
					</font>
				<br />
				
				<br />
				
					<label class="col-sm-2 control-label"></label>
					<input type="reset" value="Reset" name="reset"
						class="btn  btn-danger" />
					&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
					<input type="submit" value="Ragister" name="submit"
						class="btn btn-success" />
					
			</form>
		</div>
	</div>
<%}else{%>
<center><font color="red" size="+1"><br><br><br><br><br><br><br><b>No Data Found.....</b></font></center>> 
<%} %>
</div>
</body>
</html>




