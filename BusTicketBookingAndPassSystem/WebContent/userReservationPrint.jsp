<%@page import="com.dsynhub.digitalgsrtc.dao.StationDAO"%>
<%@page import="com.dsynhub.digitalgsrtc.bean.UserBean"%>
<%@page import="com.dsynhub.digitalgsrtc.bean.ReservationDetailBean"%>
<%@page import="com.dsynhub.digitalgsrtc.bean.ReservationBean"%>
<%@page import="java.io.File"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.ByteArrayOutputStream"%>
<%@page import="java.util.Date"%>
<%@page import="com.dsynhub.digitalgsrtc.bean.PassBean"%>
<%@page import="com.dsynhub.digitalgsrtc.bean.OrganizationBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="DigitalGSRTC-css/font-awesome-4.5.0/css/font-awesome.min.css" />
<link rel="stylesheet" href="DigitalGSRTC-css/digitalgsrtc.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- <link rel="icon" href="DigitalGSRTC-photos/logo.ico" /></head> -->
<body class="col-*-*">
	<%
		ReservationBean reservationBean = (ReservationBean) request.getAttribute("reservationBean");
		ReservationDetailBean reservationDetailBean = (ReservationDetailBean) request
			.getAttribute("reservationDetailBean");
		session.setAttribute("reservationBean",reservationBean);
		session.setAttribute("reservationDetailBean",reservationDetailBean);
		UserBean userBean=(UserBean)session.getAttribute("userBean");
	%>
	<button onclick="p()"
		style="text-align: center; position: fixed; top: 0; width: 150px; left: 50%; margin-left: -75px;"
		class="gujju-blue gujju-btn">
		<i class="fa-print fa"></i>&emsp;<b>Print Ticket</b>
	</button>
	<a href="userHomePage.jsp" class="gujju-green gujju-btn">HOME</a>
	<br>
	<br>
	<br>
	<form>
		<table
			style="width: 45%; margin: 0 auto; font-family: 'Trebuchet MS'; font-size: 18px; color: rgba(70, 70, 70, 1); background-image: url('DigitalGSRTC-photos/logo1.png'); background-repeat: no-repeat; background-position: -40px 100px; background-size: 400px 210px;">
			<tr style="text-align: center;">
				<td colspan="2"><span
					style="font-family: alpha54; font-size: 42px; color: #2196F3;">Digital
						GSRTC</span></td>
			</tr>
			<tr>
				<td colspan="2"
					style="padding: 10px 0; text-align: center; text-transform: uppercase; font-weight: 900; font-size: 26px;"><%=userBean.getFirstName()%>
					<%=userBean.getMiddleName()%> <%=userBean.getLastName()%></td>
			</tr>
			<tr>
				<td style="font-weight: 900;">Source :</td>
				<td style="text-align: center;"><%=new StationDAO().getByPK(reservationBean.getSourceId()).getStationName()%></td>
			</tr>
			<tr>
				<td style="font-weight: 900;">Destination :</td>
				<td style="text-align: center;"><%=new StationDAO().getByPK(reservationBean.getDestinationId()).getStationName()%></td>
			</tr>
			<tr>
				<td style="font-weight: 900;">Journey Date :</td>
				<td style="text-align: center;"><%=reservationBean.getJourneyDate()%></td>
			</tr>

			<tr>
				<td style="font-weight: 900;">Total Amount :</td>
				<td style="text-align: center;"><%=reservationBean.getTotalAmount()%></td>
			</tr>

			<tr>
				<td style="font-weight: 900;">No Of Seat :</td>
				<td style="text-align: center;"><%=reservationBean.getNoOfSeat()%></td>
			</tr>
			<tr>
				<td style="font-weight: 900;">Seat No :</td>
				<td style="text-align: center;">
					<%
						String seat[] = reservationDetailBean.getSeatNo();
																for (String i : seat) {
					%> <%=i + " , "%> <%
 	}
 %>
				</td>
			</tr>

			<tr>
				<td style="font-weight: 900;">Amount :</td>
				<td style="text-align: center;"><%=reservationBean.getTotalAmount()%></td>
			</tr>
		</table>
	</form>

	<script>
		function p() {
			window.print();
		}
	</script>
</body>
<br>
<div style="margin-top: 400px;">

	<%-- <%@include file="footer.jsp" %> --%>

</div>
</html>

