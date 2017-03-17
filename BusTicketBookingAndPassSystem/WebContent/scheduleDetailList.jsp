<%@page import="com.dsynhub.digitalgsrtc.util.ValidationUtils"%>
<%@page import="com.dsynhub.digitalgsrtc.bean.ScheduleDetailBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin | ScheduleDetail List</title>

<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<link rel="icon" href="DigitalGSRTC-photos/logo.ico" />
<style>
td,tr,th
{text-transform: uppercase;}
</style>
<style>
         i.custom {font-size: 2em; color: #367fa9;}
</style>
</head>
<body>
<%@include file="adminHeader.jsp"%>
<div style="margin-top: -850px;margin-left: 250px;">	
	<section class="content content-header">
	<h1>
		Schedule Detail <small>List</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="adminDashBoard.jsp"><i class="fa fa-dashboard"></i>
				Home</a></li>
		<li class="active">ScheduleDetail</li>
	</ol><br><br>
	<a href="routeInsert.jsp"><input type="button" value="ADD" name="ADD"
						class="btn btn-primary"></a><br><br>
		<div class="row">
			<div class="col-xs-12">
				<div class="box">
					<div class="box-body">
						<table id="example1" class="table table-bordered table-hover table-striped">
						<%
							ArrayList<ScheduleDetailBean> listOfScheduleDetail = (ArrayList) request
								.getAttribute("listofScheduleDetail");

							if (listOfScheduleDetail != null) {
						%>
							<thead class="gujju-theme text-uppercase">
								<tr>
									<th><center>Bus No</center></th>
									<th><center>Departure Time</center></th>
									<th><center>Source Name</center></th>
									<th><center>Destination Name</center></th>
									<th><center>Action</center></th>
								</tr>
							</thead>
							

							<tbody>
							
							<%
								for (int i = 0; i < listOfScheduleDetail.size(); i++) {
											ScheduleDetailBean scheduleDetailBean = listOfScheduleDetail.get(i);
							%>
								<tr>
									<td><center><%= scheduleDetailBean.getBusNo()%></center></td>
									<td><center><%= scheduleDetailBean.getDepartureTime()%></center></td>
									<td><center><%= scheduleDetailBean.getSource()%></center></td>
									<td><center><%= scheduleDetailBean.getDestination()%></center></td>
									<td><center>
										<a href="ScheduleDetailEditServlet?scheduleId=<%=scheduleDetailBean.getScheduleId()%>">
										<img src="DigitalGSRTC-photos/edit.ico" width="30" height="30" /></a>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<a href="ScheduleDetailDeleteServlet?scheduleId=<%=scheduleDetailBean.getScheduleId()%>">
										<img src="DigitalGSRTC-photos/Recycle Bin.ico" height="30" width="30" /> </a>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<a href="ScheduleSessionServlet?scheduleId=<%=scheduleDetailBean.getScheduleId()%>">
										<i class="fa fa-ticket custom" title="Book Ticket"></i></a>
										
										<!-- <i class="fa fa-info" title="All info"></i>formtarget="_blank" -->
										
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



























<%-- <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>

		<table border="1" align="center" width="100%">

			<%
				ArrayList<ScheduleDetailBean> listOfScheduleDetail = (ArrayList) request
						.getAttribute("listofScheduleDetail");

				if (listOfScheduleDetail != null) {
			%>
			<tr>

				<th>Bus No</th>
				<th>Schedule Id</th>
				<th>Arrival Time</th>
				<th>Derparture Time</th>
				<th>Time Taken</th>
				<th>Source Name</th>
				<th>Destination Name</th>
				<th>Distance</th>
				<th>Off Date</th>
				<th>Week Of Day</th>
				<th>Action</th>
			</tr>

			<%
				for (int i = 0; i < listOfScheduleDetail.size(); i++) {
						ScheduleDetailBean scheduleDetailBean = listOfScheduleDetail
								.get(i);
			%>

			<tr>

				<td align="center"><%=scheduleDetailBean.getBusNo()%></td>
				<td align="center"><%=scheduleDetailBean.getScheduleId()%></td>
				<td align="center"><%=scheduleDetailBean.getArrivalTime()%></td>
				<td align="center"><%=scheduleDetailBean.getDepartureTime()%></td>


				<%
					Integer time = scheduleDetailBean.getTimeTaken();
							String TimeTaken = "";
							if (time > 60) {
								time /= 60;
								TimeTaken += time + " Hr";
							} else {
								TimeTaken += time + " Min";
							}
				%>
				<td align="center"><%=TimeTaken%></td>

				<td align="center"><%=scheduleDetailBean.getSource()%></td>
				<td align="center"><%=scheduleDetailBean.getDestination()%></td>
				<td align="center"><%=scheduleDetailBean.getDistance()%></td>
				<td align="center"><%=scheduleDetailBean.getOffDate()%></td>
				<td align="center"><%=ValidationUtils.getDay(scheduleDetailBean
						.getWeekOfDay())%>

				<td align="center">
				<a href="ScheduleDetailEditServlet?scheduleId=<%=scheduleDetailBean.getScheduleId()%>">Change</a>
				<a href="ScheduleDetailDeleteServlet?scheduleId=<%=scheduleDetailBean.getScheduleId()%>">Delete</a>
				<a href="ScheduleSessionServlet?scheduleId=<%=scheduleDetailBean.getScheduleId()%>">Book Ticket</a>
				</td>

			</tr>

			<%
				}
				}

				else {
			%>

			<h1>No Record Found....!</h1>
			<%
				}
			%>



		</table>


	</center>

</body>
</html> --%>