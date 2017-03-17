<%@page import="com.dsynhub.digitalgsrtc.bean.OrganizationBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin | Organization Update</title>
<link rel="icon" href="DigitalGSRTC-photos/logo.ico" />
</head>
<body>
<%@ include file="adminHeader.jsp"%>
<div style="margin-top: -850px;margin-left: 250px;">
	<section class="content-header">
	<h1>
		Organization <small>Update</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="adminDashBoard.jsp"><i class="fa fa-dashboard"></i>
				Home</a></li>
		<li class="active">Organization</li>
	</ol>
	</section><br><br>
	<%
		OrganizationBean organizationBean = (OrganizationBean) request
				.getAttribute("organizationBean");
		if (organizationBean != null) {
	%>
	<div class="col-lg-6">
		<div class="container">
			<form action="OrganizationUpdateServlet" method="post" name="Registration">
				<input type="hidden" name="orgId" id="orgId" value="<%=organizationBean.getOrgId()%>">
				<br />
				
				<div class="row">
					<div class="col-lg-10">
						<label class="col-sm-2"><font size="+1">Name:</font></label>
						<div class="col-lg-6">	
						<input type="text" name="txtOrgName" placeholder="Enter Organization name"
								maxlength="15" value="<%=organizationBean.getOrgName()%>" 
								class="form-control" /></input> 
						</div><font color="red">${orgName}</font>
					</div>
				</div>
				<br>
				
				<div class="row">
				  <div class="col-lg-10">
					<label class="col-sm-2"> <font size="+1">Address :</font> </label>
					<div class="col-lg-6">
						<textarea maxlength="255" rows="3" class="form-control" cols="18" name="txtOrgAddress">${organizationBean.getOrgAddress()}</textarea>
					</div><font color="red">${orgAddress}</font>
				  </div>
				</div>
				<br />
				
				
				<br />
				
					<label class="col-sm-2 control-label"></label>
					<input type="reset" value="Reset" name="reset"
						class="btn  btn-danger" />
					&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
					<input type="submit" value="Submit" name="submit"
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

