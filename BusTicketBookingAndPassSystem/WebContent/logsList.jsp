<%@page import="com.dsynhub.digitalgsrtc.bean.LogsBean"%>
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
</head>
<body>
<%@include file="adminHeader.jsp"%>
<div style="margin-top: -850px;margin-left: 250px;">	
	<section class="content content-header">
	<h1>
		Logs<small>List</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="adminDashBoard.jsp"><i class="fa fa-dashboard"></i>
				Home</a></li>
		<li class="active">Logs</li>
	</ol><br><br>
		<div class="row">
			<div class="col-xs-12">
				<div class="box">
					<div class="box-body">
						<table id="example1" class="table table-bordered table-hover table-striped">
						<%  
							ArrayList<LogsBean> listOfLogs = (ArrayList) request.getAttribute("listOfLogs");;
		
							if(listOfLogs!=null)
							{
						%>
							<thead class="gujju-theme text-uppercase">
								<tr>
									<th><center>User Name</center></th>
									<th><center>User Type</center></th>
									<th><center>Login Time</center></th>
									<th><center>Logout Time</center></th>
								</tr>
							</thead>
							

							<tbody>
							<%
						
							for(int i=0;i<listOfLogs.size();i++)
							{
								LogsBean logsBean = listOfLogs.get(i);
								
								%>
								<tr>
									<td><center><%=logsBean.getUserName()%></center></td>
									<td><center><%=logsBean.getUserType()%></center></td>
									<td><center><%=logsBean.getLoginTime()%></center></td>
									<td><center><%=logsBean.getLogoutTime()%></center></td>

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


