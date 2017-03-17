<%@page import="com.dsynhub.digitalgsrtc.bean.BusTypeBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin | Bus Type List</title>

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
		Bus Type <small>List</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="adminDashBoard.jsp"><i class="fa fa-dashboard"></i>
				Home</a></li>
		<li class="active">BusType</li>
	</ol><br><br>
	<a href="busTypeInsert.jsp"><input type="button" value="ADD" name="ADD"
						class="btn btn-primary"></a><br><br>
		<div class="row">
			<div class="col-xs-12">
				<div class="box">
					<div class="box-body">
						<table id="example1" class="table table-bordered table-hover table-striped">
						<%  
							ArrayList<BusTypeBean> listOfBusType = (ArrayList) request.getAttribute("listofBusType");;
		
							if(listOfBusType!=null)
							{
						%>
							<thead class="gujju-theme text-uppercase">
								<tr>
									<th><center>BusType Id</center></th>
									<th><center>BusType Name</center></th>
									<th><center>Action</center></th>
								</tr>
							</thead>
							

							<tbody>
							<%
						
							for(int i=0;i<listOfBusType.size();i++)
							{
								BusTypeBean busTypeBean = listOfBusType.get(i);
								
								%>
								<tr>
									<td><center><%=busTypeBean.getBusTypeId()%></center></td>
									<td><center><%=busTypeBean.getBusTypeName()%></center></td>
									<td><center>
										<a href="BusTypeEditServlet?busTypeId=<%= busTypeBean.getBusTypeId()%>">
										<img src="DigitalGSRTC-photos/edit.ico" width="30" height="30" /></a>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<a href="BusTypeDeleteServlet?busTypeId=<%= busTypeBean.getBusTypeId()%>">
										<img src="DigitalGSRTC-photos/Recycle Bin.ico" height="30" width="30" /> </a>
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


