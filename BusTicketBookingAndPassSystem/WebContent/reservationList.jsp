<%@page import="java.util.ArrayList"%>
<%@page import="com.dsynhub.digitalgsrtc.bean.ReservationBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin | Reservation List</title>

<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<link rel="icon" href="DigitalGSRTC-photos/logo.ico" />
<style>
td,tr,th
{text-transform: uppercase;}
 i.custom {font-size: 1.5em; color: #367fa9;}
</style>
</head>
<body>
<%@include file="adminHeader.jsp"%>
<div style="margin-top: -850px;margin-left: 250px;">	
	<section class="content content-header">
	<h1>
		Reservation <small>List</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="adminDashBoard.jsp"><i class="fa fa-dashboard"></i>
				Home</a></li>
		<li class="active">Reservation</li>
	</ol><br><br>
	<a href="adminSearch.jsp"><input type="button" value="ADD" name="ADD"
						class="btn btn-primary"></a><br><br>
		<div class="row">
			<div class="col-xs-12">
				<div class="box">
					<div class="box-body">
						<table id="example1" class="table table-bordered table-hover table-striped">
						<%
								ArrayList<ReservationBean> listOfReservation = (ArrayList) request
										.getAttribute("listofReservation");

								if (listOfReservation != null) {
							%>
							<thead class="gujju-theme text-uppercase">
								<tr>
									<th><center> Name</center></th>
									<th><center>Source</center></th>
									<th><center>Destination</center></th>
									<th><center>No Of Seat</center></th>
									<th><center>Journey Date</center></th>
									<th><center>Available</center></th>
									<th><center>Action</center></th>
								</tr>
							</thead>
							

							<tbody>
							<%
								for (int i = 0; i < listOfReservation.size(); i++) {
										ReservationBean reservationBean = listOfReservation.get(i);
							%>
								<tr>
									<td><%=reservationBean.getFirstName()%>&nbsp;&nbsp;<%=reservationBean.getMiddleName()%>&nbsp;&nbsp;<%=reservationBean.getLastName()%></td>
									<td><%=reservationBean.getSourceName()%></td>
									<td><%=reservationBean.getDestinationName()%></td>
									<td><%=reservationBean.getNoOfSeat()%></td>
									<td><%=reservationBean.getJourneyDate()%></td>
									<% if(reservationBean.getIsCancel().equals("y")){ %>
										<td align="center"><img src="DigitalGSRTC-photos/no1.jpg" height="20" width="20" class="img-rounded"/></td>
									<%}else{ %>
										<td align="center"><img src="DigitalGSRTC-photos/yes1.jpg" height="20" width="20" class="img-rounded"/></td>
									<%} %>
									<td><a class="btn-default btn" title="Detail"
										href="ReservationDetailListServlet?reservationId=<%=reservationBean.getReservationId()%>">
										<i class="fa fa-list-ul custom" title="Detail"></i></a>&nbsp;
									<a class="btn-default btn"
										href="ReservationEditServlet?reservationId=<%=reservationBean.getReservationId()%>">
											<img src="DigitalGSRTC-photos/edit.ico" height="20" width="20" />
									</a>&nbsp;
									<a class="btn-default btn"
										href="ReservationDeleteServlet?reservationId=<%=reservationBean.getReservationId()%>">
											<img src="DigitalGSRTC-photos/Recycle Bin.ico" height="20"
											width="20" />
									</a></td>
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
