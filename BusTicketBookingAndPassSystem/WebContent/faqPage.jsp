<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
<link rel="icon" href="DigitalGSRTC-photos/logo.ico" /></head>
<body>
<%@ include file="header.jsp" %>
<%
		String loginAdminCheck = (String) session.getAttribute("loginAdminCheck");
		String loginUserCheck = (String) session.getAttribute("loginUserCheck");
		if (loginAdminCheck != null && loginUserCheck ==null) 
			response.sendRedirect("adminDashBoard.jsp");
		else if (loginAdminCheck == null && loginUserCheck !=null) 
			response.sendRedirect("userHomePage.jsp");
		else{
%>


		<div class="gujju-col m11 gujju-card-8"
			style="border-color: blue; margin-left: 50px; border: 2px solid skyblue; border-radius: 10px 10px 10px;">
			<div class="  btn-block gujju-theme-l4"
				style="outline-color: blue;padding: 5px;padding-left: 10px;" ><i class="fa fa-angle-double-right"></i>&emsp;
				Do I need to register a user account with DIGITAL GSRTC to book online (e-ticket)?</div>
			<ul
				style="text-decoration: none; outline-color: blue; list-style-type: circle; list-style-position: inside;">
				Yes, you will need a registered user account. The account registration is very brief and easy.
			</ul>
		</div>
		<br></br><br></br>
		<div class="gujju-col m11 gujju-card-8"
			style="border-color: blue; margin-left: 50px; border: 2px solid skyblue; border-radius: 10px 10px 10px;">
			<div class="  btn-block gujju-theme-l4"
				style="outline-color: blue;padding: 5px;padding-left: 10px;" ><i class="fa fa-angle-double-right"></i>&emsp;
				Does booking online (e-ticket) cost me more?
			</div>
			<ul
				style="text-decoration: none; outline-color: blue; list-style-type: circle; list-style-position: inside;">
				No, e-ticket booking does not include any additional charges. It will cost as much as you buy a reservation ticket from the counter.
			</ul>
		</div>
		<br></br><br></br>
		<div class="gujju-col m11 gujju-card-8"
			style="border-color: blue; margin-left: 50px; border: 2px solid skyblue; border-radius: 10px 10px 10px;">
			<div class="  btn-block gujju-theme-l4"
				style="outline-color: blue;padding: 5px;padding-left: 10px;" ><i class="fa fa-angle-double-right"></i>&emsp;
				Is there any contact no. for any queries regarding e-ticketing?
			</div>
			<ul
				style="text-decoration: none; outline-color: blue; list-style-type: circle; list-style-position: inside;">
				Yes, GSRTC has established a helpdesk with (24 X 7) tall free no. 1800 233 666666. Passengers can call anytime for the difficulties.
			</ul>
		</div>
		<br></br><br></br>
		<div class="gujju-col m11 gujju-card-8"
			style="border-color: blue; margin-left: 50px; border: 2px solid skyblue; border-radius: 10px 10px 10px;">
			<div class="  btn-block gujju-theme-l4"
				style="outline-color: blue;padding: 5px;padding-left: 10px;" ><i class="fa fa-angle-double-right"></i>&emsp;
				Does booking through mobile cost me more?
			</div>
			<ul
				style="text-decoration: none; outline-color: blue; list-style-type: circle; list-style-position: inside;">
				No, mobile booking does not include any additional charges. It's a free service.
			</ul>
		</div>
		<br></br><br></br>
		<div class="gujju-col m11 gujju-card-8"
			style="border-color: blue; margin-left: 50px; border: 2px solid skyblue; border-radius: 10px 10px 10px;">
			<div class="  btn-block gujju-theme-l4"
				style="outline-color: blue;padding: 5px;padding-left: 10px;" ><i class="fa fa-angle-double-right"></i>&emsp;
				Does booking at GSRTC franchisee (Agency) counters cost me more?
			</div>
			<ul
				style="text-decoration: none; outline-color: blue; list-style-type: circle; list-style-position: inside;">
				No! The fare remains same in GSRTC owned counters and franchisee counters.
			</ul>
		</div>
		<br></br><br></br>
		<div class="gujju-col m11 gujju-card-8"
			style="border-color: blue; margin-left: 50px; border: 2px solid skyblue; border-radius: 10px 10px 10px;">
			<div class="  btn-block gujju-theme-l4"
				style="outline-color: blue;padding: 5px;padding-left: 10px;" ><i class="fa fa-angle-double-right"></i>&emsp;
				Is it mandatory to carry ID proof for e-ticket?
			</div>
			<ul
				style="text-decoration: none; outline-color: blue; list-style-type: circle; list-style-position: inside;">
				Yes. It is a compulsory to carry photo ID proof.
			</ul>
		</div>
		<br></br><br></br>
		<div class="gujju-col m11 gujju-card-8"
			style="border-color: blue; margin-left: 50px; border: 2px solid skyblue; border-radius: 10px 10px 10px;">
			<div class="  btn-block gujju-theme-l4"
				style="outline-color: blue;padding: 5px;padding-left: 10px;" ><i class="fa fa-angle-double-right"></i>&emsp;
				What are the age criteria for child fare?
			</div>
			<ul
				style="text-decoration: none; outline-color: blue; list-style-type: circle; list-style-position: inside;">
				Children younger than 5 years are allowed to travel free.Children elder than 5 years and younger than 12 years will be charged for half ticket (50%).
			</ul>
		</div>
		<br></br><br></br>
		<div class="gujju-col m11 gujju-card-8"
			style="border-color: blue; margin-left: 50px; border: 2px solid skyblue; border-radius: 10px 10px 10px;">
			<div class="  btn-block gujju-theme-l4"
				style="outline-color: blue;padding: 5px;padding-left: 10px;" ><i class="fa fa-angle-double-right"></i>&emsp;
				I've lost my ticket. What do I do now?
			</div>
			<ul
				style="text-decoration: none; outline-color: blue; list-style-type: circle; list-style-position: inside;">
				If it is e-ticket you can login to GSRTC application and take printout and produce it at the time of boarding.
			</ul>
		</div>
		<br></br><br></br>
		<div class="gujju-col m11 gujju-card-8"
			style="border-color: blue; margin-left: 50px; border: 2px solid skyblue; border-radius: 10px 10px 10px;">
			<div class="  btn-block gujju-theme-l4"
				style="outline-color: blue;padding: 5px;padding-left: 10px;" ><i class="fa fa-angle-double-right"></i>&emsp;
				I have booked e-ticket in my name can someone else travel in the ticket?
			</div>
			<ul
				style="text-decoration: none; outline-color: blue; list-style-type: circle; list-style-position: inside;">
				No, Ticket is not transferable.
			</ul>
		</div>
		<br></br><br></br>
		<div class="gujju-col m11 gujju-card-8"
			style="border-color: blue; margin-left: 50px; border: 2px solid skyblue; border-radius: 10px 10px 10px;">
			<div class="  btn-block gujju-theme-l4"
				style="outline-color: blue;padding: 5px;padding-left: 10px;" ><i class="fa fa-angle-double-right"></i>&emsp;
				What are the advantages of purchasing an Advance Reservation bus ticket with DigitalGSRTC?
			</div>
			<ul
				style="text-decoration: none; outline-color: blue; list-style-type: circle; list-style-position: inside;">
				DigitalGSRTC offers variety of services. There are several advantages of advance reservation with DigitalGSRTC, such as
				You can choose your seat You can book your bus tickets through Internet, using GPRS enabled Mobile, or in person at your nearest counter of our wide spread franchisee network chain and GSRTC booking counters.
				Choice based on boarding points, timing and bus type
				Provision of relief vehicle in case of bus break down
				Providing safe journey with statutory speed limits and skilled drivers
			</ul>
		</div>
		
		
		
<%} %>
<script>
			$(document).ready(function() {
				$("#aboutus").removeClass("gujju-blue gujju-card-24");
				$("#aboutus").addClass("gujju-theme-d2 gujju-card-24");
				 
			});
			</script>
</body>
</html>