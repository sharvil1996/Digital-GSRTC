<%@page import="com.dsynhub.digitalgsrtc.bean.ScheduleDetailBean"%>
<%@page import="com.dsynhub.digitalgsrtc.bean.ReservationDetailBean"%>
<%@page import="com.dsynhub.digitalgsrtc.bean.ReservationBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirm Ticket</title>
<link rel="icon" href="DigitalGSRTC-photos/logo.ico" />
</head>
<body>
	<%@include file="userHeader.jsp"%>
	<%
		ReservationBean reservationBean = (ReservationBean) session
				.getAttribute("reservationBean");
		ReservationDetailBean reservationDetailBean = (ReservationDetailBean) session
				.getAttribute("reservationDetailBean");
		ScheduleDetailBean scheduleBean = (ScheduleDetailBean) session
				.getAttribute("scheduleDetailBean");
	%>

	<form action="UserReservationConfirmServlet" method="post">
		<center>
			<br />
			<br />
			<br />
			<br />
			<div class="col-lg-25 gujju-card-2" align="center">
				<table
					style="text-align: center; text-transform: uppercase;"
					align="center">
					<tr>
						<td style="color: white">HI</td>
					</tr>
					<tr>
						<td>Source : <%=scheduleBean.getSource()%>
						</td>
					</tr>
					<tr>
						<td>Destination : <%=scheduleBean.getDestination()%>
						</td>
					</tr>

					<tr>
						<td>Journey Date: <%=reservationBean.getJourneyDate()%>
						</td>
					</tr>

					<tr>
						<td>Total Amount: <%=reservationBean.getTotalAmount()%>
						</td>
					</tr>


					<tr>
						<td>No Of Seat : <%=reservationBean.getNoOfSeat()%>
						</td>
					</tr>
					<tr>
						<td>Seat No : <%
							String[] listOfreservationDetail = reservationDetailBean
									.getSeatNo();

							for (int i = 0; i < listOfreservationDetail.length; i++) {
						%> <%=listOfreservationDetail[i] + "  "%> <%
 	}
 %>
						</td>
					</tr>

					<tr>
					</tr>
					<tr>
						<td>Amount : <%=reservationBean.getTotalAmount()%>
						</td>
					</tr>
					<tr>
						<td style="color: white">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="1" style="text-align: center;"><input
							type="submit" value="Confirm" class="gujju-blue gujju-btn" /></td>
					</tr>
					<tr>
						<td style="color: white">&nbsp;</td>
					</tr>
					
				</table>
			</div>
		</center>
	</form>
</body>
</html>