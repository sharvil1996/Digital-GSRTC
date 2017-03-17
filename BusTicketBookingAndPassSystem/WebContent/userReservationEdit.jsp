<%@page import="com.dsynhub.digitalgsrtc.bean.ReservationBean"%>
<%@page import="java.util.List"%>
<%@page import="com.dsynhub.digitalgsrtc.dao.UserDAO"%>
<%@page import="com.dsynhub.digitalgsrtc.bean.UserBean"%>
<%@page import="com.dsynhub.digitalgsrtc.bean.BusBean"%>
<%@page import="com.dsynhub.digitalgsrtc.bean.RouteBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Registration.jsp User</title>
<noscript>
	<div style="color: #FF0000">place enable java script</div>
</noscript>
<link rel="icon" href="DigitalGSRTC-photos/logo.ico" />
</head>
<body>
	<%@include file="userHeader.jsp"%>
	<br />
	<br />
	<%
		ReservationBean reservationBean  = (ReservationBean) request
				.getAttribute("reservationBean");
		if (reservationBean != null) {
	%>
	<%!ArrayList<RouteBean> routeBeansList;
			ArrayList<BusBean> busBeansList;%>
	<form action="UserReservationUpdateServlet" method="post">
		<input type="hidden" name="reservationId" id="reservationId"
			value="<%=reservationBean.getReservationId()%>">
		<div class="col-lg-6">
			<div class="container">
				<div class="row">
					<div class="col-lg-8">
						<div class="col-sm-3">
							<font size="+1">select user :</font>
						</div>
						<div class="col-md-9">


							<%-- <select name="selUserName" class="form-control" id="selUserName">
								<option value="0" selected="selected">select
									User Name</option>
								<%
									List<UserBean> userBeansList = new UserDAO().list();
										String type = reservationBean.getUserId();
										for (int i = 0; i < userBeansList.size(); i++) {

											String tmp = "unselected";
											if (userBeansList.get(i).getUserId().equals(type))
												tmp = "selected";
								%>


								<option disabled="disabled" value=<%=userBeansList.get(i).getUserId()%> <%=tmp%>><%=userBeansList.get(i).getEmail()%></option>
								<%
									}
								%>
							</select><font color="red"><b>${msgUserName}</b></font>
 --%>
							<input type="text" class="form-control" readonly="readonly"
								value="${reservationBean.email}" name="email" /> <font
								color="red"><b>${msgSeat}</b></font>

						</div>
					</div>
				</div>

				<br />
				<div class="row">
					<div class="col-lg-8">
						<div class="col-sm-3">
							<font size="+1">No of Seat:</font>
						</div>
						<div class="col-md-9">
							<input type="text" class="form-control text-capitalize" min="1"
								max="552" maxlength="2" placeholder="No of Seat"
								value="${reservationBean.noOfSeat}" name="noOfSeat" /> <font
								color="red"><b>${msgSeat}</b></font>
						</div>
					</div>
				</div>

				<br />
				<div class="row">
					<div class="col-lg-8">
						<div class="col-sm-3">
							<font size="+1">Journey Date:</font>
						</div>
						<div class="col-md-9">
							<input type="date" class="form-control" id="date" name="resDate"
								placeholder="mm-dd-yyyy" value="${reservationBean.journeyDate}"
								min="2014-01-01" disabled /> ${msgDate}
						</div>
					</div>
				</div>

				<br />

				<div class="row">
					<div class="col-lg-8">
						<div class="col-md-5">
							<input type="submit" class="btn-primary  btn " />
						</div>
						<input type="reset" class="btn-success btn" />
					</div>
				</div>
			</div>
		</div>
	</form>
	</div>
	<%
					}
				%>
</body>
<script>
	var input = document.getElementById("date");
	var today = new Date();
	var day = today.getDate();
	// Set month to string to add leading 0
	var mon = new String(today.getMonth() + 1); //January is 0!
	var yr = today.getFullYear();

	if (mon.length < 2) {
		mon = "0" + mon;
	}

	var date = new String(yr + '-' + mon + '-' + day);

	input.disabled = false;
	input.setAttribute('min', date);
</script>
<br><br><br><br><br><br>
	<%@include
		file="userFooter.jsp"%> 

</html>
