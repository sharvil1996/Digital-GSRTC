<%@page import="com.dsynhub.digitalgsrtc.bean.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin | Admin List</title>

<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<link rel="icon" href="DigitalGSRTC-photos/logo.ico" />
<style>
td,tr,th
{text-transform: uppercase;}
</style>
</head>
<body>
<%@include file="adminHeader.jsp"%>
<div style="margin-top: -850px;margin-left: 250px;">	
	<section class="content content-header">
	<h1>
		Admin <small>List</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="adminDashBoard.jsp"><i class="fa fa-dashboard"></i>
				Home</a></li>
		<li class="active">Admin</li>
	</ol><br><br>
	<a href="adminInsert.jsp"><input type="button" value="ADD" name="ADD"
						class="btn btn-primary"></a><br><br>
		<div class="row">
			<div class="col-xs-12">
				<div class="box">
					<div class="box-body">
						<table id="example1" class="table table-bordered table-hover table-striped">
						<%
							ArrayList<AdminBean> listOfAdmin = (ArrayList) request.getAttribute("listOfAdmin");

							if (listOfAdmin != null) {
						%>
							<thead class="gujju-theme text-uppercase">
								<tr >
									<th><center>Name</center></th>
									<th><center>Email</center></th>
									<th><center>Gender</center></th>
									<th><center>Mobile No</center></th>
									<th><center>City</center></th>
									<th><center>Is Active</center></th>
									<th><center>Action</center></th>
								</tr>
							</thead>
							

							<tbody>
							<%
								for (int i = 0; i < listOfAdmin.size(); i++) {
								AdminBean adminBean = listOfAdmin.get(i);
							%>
								<tr>
									<td><center><%=adminBean.getFirstName() + " "
														+ adminBean.getMiddleName() + " "
														+ adminBean.getLastName()%>
									</center></td>
									<td><center><%=adminBean.getEmail()%></center></td>
									<td><center><%=adminBean.getGender()%></center></td>
									<td><center><%=adminBean.getMobileNo()%></center></td>
									<td><center><%=adminBean.getCityName()%></center></td>
									<% if(adminBean.getIsActive().equals("n")){ %>
										<td align="center"><img src="DigitalGSRTC-photos/no1.jpg" height="30" width="30" class="img-rounded"/></td>
									<%}else{ %>
										<td align="center"><img src="DigitalGSRTC-photos/yes1.jpg" height="30" width="30" class="img-rounded"/></td>
									<%} %>
									<td><center>
										<a href="AdminEditServlet?adminId=<%=adminBean.getAdminId()%>"><img
											src="DigitalGSRTC-photos/edit.ico" width="30" height="30" class="img-rounded"  /></a>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<a href="AdminDeleteServlet?adminId=<%=adminBean.getAdminId()%>">
										<img src="DigitalGSRTC-photos/Recycle Bin.ico" height="30" width="30" class="img-rounded"/> </a>
									</center></td>

								</tr>
								
							<%
								}
								}

							else {
							%>

							<h1><center>No Record Found....!</center></h1>
							<%
									}
							%>
								
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</section>				
</div>
</body>
</html>
