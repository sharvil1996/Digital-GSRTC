<%@page import="com.dsynhub.digitalgsrtc.bean.ReservationBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin | User Reservation List</title>
<title>Reservation List</title>

<link rel="icon" href="DigitalGSRTC-photos/logo.ico" />
</head>
<body class="col-*-*">
	<%@include file="userHeader.jsp"%>
	${msgreservation} ${msgcancel}
	<%!ArrayList<ReservationBean> reservationBeansList;%>
	<% System.out.print("Hello"); %>
	<div class="container">
		<div class="row">
			<div class="col-lg-10 text-primary ">
				<center style="font-size: 40px; font-weight: 800;"
					class="fa-ticket fa">&emsp;Booking</center>
			</div>
		</div>
		<br />
		<div class="row">
			<table class="table-hover table-responsive table gujju-card-4">
				<thead class="gujju-theme">
					<tr>
						<th>Source</th>
						<th>Destination</th>
						<th>No Of Seat</th>
						<th>Journey Date</th>
						<th colspan="3">Action</th>
					</tr>
				</thead>
				<tbody>
					<%
							reservationBeansList = (ArrayList) session.getAttribute("reservationBean");
							for (int i = 0; i < reservationBeansList.size(); i++) {
								ReservationBean reservationBean = reservationBeansList.get(i);
						%>
					<tr>
						<td><%=reservationBean.getSourceName()%></td>
						<td><%=reservationBean.getDestinationName()%></td>
						<td><%=reservationBean.getNoOfSeat()%></td>
						<td><%=reservationBean.getJourneyDate()%></td>
						<td>
					<!-- 	<input type="button" >   -->
						<a
							href="UserReservationDetailListServlet?reservationId=<%=reservationBean.getReservationId()%>"
							class="btn-default btn ">
							<div class="fa-print fa" style="font-size: 30px; color: #2196F3; margin-top: -3px;"></div>
						</a> 
						<a class="btn-default btn"
							href="UserReservationEditServlet?reservationId=<%=reservationBean.getReservationId()%>">
								<img src="DigitalGSRTC-photos/edit.ico" height="30" width="25" />
						</a>
						<a class="btn-default btn"
							href="ReservationCancelServlet?reservationId=<%=reservationBean.getReservationId()%>">
								<div class="fa fa-trash "
									style="font-size: 30px; color: #2196F3; margin-top: -3px;"></div>
						</a>
						
						 
						</td>
					</tr>
						<%
							}
						%>
				</tbody>
			</table>
		</div>
	</div>
	<script>
		$(document).ready(function() {
			$("#yourbooking").removeClass("gujju-blue gujju-card-24");
			$("#yourbooking").addClass("gujju-theme-d2 gujju-card-24");

		});
	</script>
	<%@include file="userFooter.jsp"%>
</body>
</html>