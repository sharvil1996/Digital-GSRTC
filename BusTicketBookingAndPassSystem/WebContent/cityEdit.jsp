<%@page import="com.dsynhub.digitalgsrtc.bean.CityBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin | City Update</title>
<link rel="icon" href="DigitalGSRTC-photos/logo.ico" />
</head>
<body>
<%@ include file="adminHeader.jsp"%>
<div style="margin-top: -850px;margin-left: 250px;">
	<section class="content-header">
	<h1>
		City <small>Update</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="adminDashBoard.jsp"><i class="fa fa-dashboard"></i>
				Home</a></li>
		<li class="active">City</li>
	</ol>
	</section><br><br>
	<%
		CityBean cityBean = (CityBean) request.getAttribute("cityBean");
		if (cityBean != null) {
	%>
	<div class="col-lg-6">
		<br />
		<div class="container">
			<form action="CityUpdateServlet" method="post">
			<input type="hidden" name="cid" id="cid"
			value="<%=cityBean.getCityId()%>">
				<div class="row">
					<div class="col-lg-10">
						<label class="col-sm-2"><font size="+1">City Name:</font></label>
						<div class="col-lg-6">	
							<input type="text" name="txtCityName" placeholder="City Name"
								maxlength="15" value="<%=cityBean.getCityName()%>" 
								class="form-control" /></input> 
						</div><font color="red">${cityName}</font>
					</div>
				</div>
				<br>
				<br></br>
				<label class="col-sm-2 control-label"></label>
					<input type="reset" value="Reset" name="reset"
						class="btn  btn-danger">
					&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
					<input type="Submit" value="Submit" name="submit"
						class="btn btn-success">
			</form>
		</div>
	</div>
<%}else{%>
<center><font color="red" size="+1"><br><br><br><br><br><br><br><b>No Data Found.....</b></font></center> 
<%} %>
</div>
</body>
</html>




