<%@page import="com.dsynhub.digitalgsrtc.dao.ReservationDAO"%>
<%@page import="com.dsynhub.digitalgsrtc.dao.UserDAO"%>
<%@page import="com.dsynhub.digitalgsrtc.dao.PassDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Admin Dashboard</title>
<!-- <link rel="stylesheet	" href="DigitalGSRTC-css/digitalgsrtc.css" />
<link rel="stylesheet" href="DigitalGSRTC-css/Gujju.css" />
<link rel="stylesheet" href="DigitalGSRTC-css/gujju-theme-theme.css" />
<link rel="stylesheet"
	href="DigitalGSRTC-css/font-awesome-4.5.0/css/font-awesome.min.css" />
<script src="DigitalGSRTC-javaScript/model/bootstrap.min.js"></script>

<script src="DigitalGSRTC-javaScript/header/Header.js"></script>

<script type="text/javascript"
	src="DigitalGSRTC-javaScript/model/bootstrap.min.js"></script>

<script src="DigitalGSRTC-javaScript/Jquery/jquery.min.js"
	type="text/javascript"></script> -->

<link rel="icon" href="DigitalGSRTC-photos/logo.ico" />
</head>
<body>
	<%@include file="adminHeader.jsp"%>
	<div style="margin-top: -850px; margin-left: 250px;">
		<section class="content-header">
		<h1>
			Dashboard <small></small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="adminDashBoard.jsp"><i class="fa fa-dashboard"></i>
					Home</a></li>
			<li class="active">Dashboard</li>
		</ol>
		</section>
		<br> <br>
		<br><br>

		<div class="container">
			<div class="" align="center">
				<div class="row">
				<div class="col-sm-1"></div>
					<div class="col-xs-9">
						<div class="panel panel-default"
							style="background-color: rgba(24,97,139,1);">
							<div class="panel-body " style="font-weight: bold; color: white;">Total</div>
						</div>
					</div>
					<div class="col-sm-1"></div>
				</div>
				<div class="row">
				<div class="col-sm-1"></div>
					<div class="col-sm-3">

						<div class="panel panel-default  ">
							<div class="panel-heading "
								style="color: white; background-color: #367FA9;">
								<i class="fa-user-plus fa" style="font-size: 40px;">&emsp;&emsp;
								</i>
								<h2 style="display: inline-block; margin: 0;"><%=new UserDAO().list().size()%></h2>
							</div>
							<div class="panel-body gujju-theme-d2" style="font-weight: bold;">Registration</div>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="panel panel-default   gujju-card-16 ">
							<div class="panel-heading  "
								style="color: white; background-color: #367FA9;">
								<i class="fa-ticket fa" style="font-size: 40px;">&emsp;&emsp;
									 <%=new ReservationDAO().list().size()%> 
								</i>
							</div>
							<div class="panel-body gujju-theme-d2" style="font-weight: bold;">Reservation</div>
						</div>
					</div>


					<div class="col-sm-3">
						<div class="panel panel-default     gujju-card-16 ">
							<div class="panel-heading "
								style="color: white; background-color: #367FA9;">
								<i class="fa fa-newspaper-o" style="font-size: 40px;">&emsp;&emsp;
									
								</i><h2 style="display:inline-block;margin:0;"><%=new PassDAO().list().size()%></h2>
							</div>
							<div class="panel-body gujju-theme-d2" style="font-weight: bold;">Pass
								Generated</div>
						</div>
					</div>
					<div class="col-sm-1"></div>
				</div>
				<div class="row">
					<div class="col-sm-1"></div>
					<div class="col-xs-9">

						<div class="panel panel-default gujju-card-16 ">
							<div class="panel-body gujju-theme-d3"
								style="font-weight: bold; background-color: rgba(24,97,139,1); color: white;"
								id="date">
								<script type="text/javascript">
									document.getElementById('date').innerHTML = "Today : "
											+ new Date().getDate()
											+ "/"
											+ (new Date().getMonth() + 1)
											+ "/"
											+ new Date().getFullYear();
								</script>
							</div>
						</div>
					</div>
					<div class="col-sm-1"></div>
				</div>
				<div class="row">
				<div class="col-sm-1"></div>
					<div class="col-sm-3">
						<div class="panel panel-default     gujju-card-16 ">
							<div class="panel-heading "
								style="color: white; background-color: #367FA9;">
								<i class="fa fa-user-plus" style="font-size: 40px;">&emsp;&emsp;
									 <%=new UserDAO().getRegularUserList().size()%> 
								</i>
							</div>
							<div class="panel-body gujju-theme-d2" style="font-weight: bold;">Registartion
								Done</div>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="panel panel-default     gujju-card-16 ">
							<div class="panel-heading "
								style="color: white; background-color: #367FA9;">
								<i class="fa fa-ticket" style="font-size: 40px;">&emsp;&emsp;
									 <%=new ReservationDAO().getRegularReservationList().size()%>
								</i>
							</div>
							<div class="panel-body gujju-theme-d2" style="font-weight: bold;">
								Reservation Done</div>
						</div>
					</div>

					<div class="col-sm-3">
						<div class="panel panel-default     gujju-card-16 ">
							<div class="panel-heading "
								style="color: white; background-color: #367FA9;">
								<i class="fa fa-newspaper-o" style="font-size: 40px;">&emsp;&emsp;
									 <%=new PassDAO().getRegularPassDetailList().size()%> 
								</i>
							</div>
							<div class="panel-body gujju-theme-d2" style="font-weight: bold;">Pass
								Generated</div>
						</div>
					</div>
					<div class="col-sm-1"></div>
				</div>


			</div>
		</div>
	</div>
	<!-- <script>
		$(document).ready(function() {
			$("#desh").addClass("effect");
		});
	</script> -->
	<%-- <%@include file="footer.jsp" %> --%>
</body>
</html>