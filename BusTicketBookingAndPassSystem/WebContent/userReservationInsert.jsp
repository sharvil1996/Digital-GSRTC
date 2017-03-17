<%@page import="com.dsynhub.digitalgsrtc.bean.BusBean"%>
<%@page import="com.dsynhub.digitalgsrtc.bean.RouteBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Registration.jsp User</title>
<noscript>
	<div style="color: #FF0000">place enable java script</div>
</noscript>
<link rel="icon" href="DigitalGSRTC-photos/logo.ico" />
</head>
<body class="col-*-*">
	<%@include file="userHeader.jsp"%>
	<div class="col-lg-6">
		<%!ArrayList<RouteBean> routeBeansList;
	ArrayList<BusBean> busBeansList;%>
		<form action="UserReservationInsertServlet" method="post">
			<br />
			<div class="col-lg-6">
				<div class="container">
					<div class="row">
						<div class="col-lg-8">
							<div class="col-sm-3">
								<font size="+1">No of Seat:</font>
							</div>
							<div class="col-md-9">
								<input type="number" class="form-control text-capitalize"
									min="1" max="5" maxlength="1" placeholder="No of Seat"
									name="noOfSeat" /> <font color="red"><b>${msgSeat}</b></font>
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
									onfocus="take();" placeholder="yyyy-mm-dd" value="${resDate}" />
							</div>
						</div>

					</div>

					<br />

					<div class="row">
						<div class="col-lg-8">
							<div class="col-lg-5">
								<input type="submit" class="gujju-btn gujju-theme "
									onclick="Validation();" />
							</div>
							<div class="col-md-4">
								<input type="reset" class="gujju-btn gujju-green " value="Clear" />
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
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


</body>
</html>
