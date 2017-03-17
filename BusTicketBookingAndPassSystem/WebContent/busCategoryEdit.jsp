<%@page import="com.dsynhub.digitalgsrtc.bean.BusCategoryBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin | BusCategory Insert</title>
</head>
<body>
<%@ include file="adminHeader.jsp"%>
<div style="margin-top: -850px;margin-left: 250px;">
	<section class="content-header">
	<h1>
		Bus Category <small>Update</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="adminDashBoard.jsp"><i class="fa fa-dashboard"></i>
				Home</a></li>
		<li class="active">BusCategory</li>
	</ol>
	</section><br><br>
	<%
		BusCategoryBean busCategoryBean = (BusCategoryBean) request
				.getAttribute("busCategoryBean");
		if (busCategoryBean != null) {
	%>
	<div class="col-lg-6">
		<br />
		<div class="container">
			<form action="BusCategoryUpdateServlet" method="post">
			<input type="hidden" name="busCategoryId" id="busCategoryId"
			value="<%=busCategoryBean.getBusCategoryId()%>">
				<div class="row">
					<div class="col-lg-10">
						<label class="col-sm-2"><font size="+1">Category Name:</font></label>
						<div class="col-lg-6">	
							<input type="text" name="txtBusCategoryName" placeholder="BusCategory Name"
								maxlength="15" value="<%=busCategoryBean.getBusCategoryName()%>" id="txtfirstName"
								class="form-control" /></input> 
						</div><font color="red">${busCategoryName}</font>
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


