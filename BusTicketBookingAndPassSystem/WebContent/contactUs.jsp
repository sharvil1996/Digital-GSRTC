<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//gujjuC//DTD XHTML 1.0 Transitional//EN" "http://www.gujju.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.gujju.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Contact Us</title>

<link rel="icon" href="DigitalGSRTC-photos/logo.ico" /></head>

<body>
<%
		String loginAdminCheck = (String) session.getAttribute("loginAdminCheck");
		String loginUserCheck = (String) session.getAttribute("loginUserCheck");
		if (loginAdminCheck != null && loginUserCheck ==null) 
			response.sendRedirect("adminDashBoard.jsp");
		else if (loginAdminCheck == null && loginUserCheck !=null) 
			response.sendRedirect("userHomePage.jsp");
		else{
%>
	<%@include file="header.jsp"%>
	<br />

<div class="gujju-container ">
	
		<div class="col-lg-5" style="float: left;"><iframe
		src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d29377.821342812917!2d72.59196469999999!3d23.0154115!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x395e9a93fb84129b%3A0x5d9d15a6b0aead8b!2sGujarat+State+Road+Transport+Corporation!5e0!3m2!1sen!2sin!4v1448883151214"
		width="600" height="305" frameborder="0"
		style="border: 0; float: left;" allowfullscreen></iframe>
		</div>
	
	<div style="size: 10; text-align: left; float: right;"
		class="gujju-col m6 gujju gujju-card-2 ">
		
	
		<div style="height: 300px; font-size: 24px;">
			<label class="gujju-text-blue"> &nbsp;&nbsp;&nbsp;Contact Us</label><br /> <font
				class=" text-right" face="Times New Roman">&emsp;<i
				class="gujju-text-blue fa-map-marker fa "></i><u> Address</u></font><br /> <font
				face="Times New Roman" size="+1">&emsp;&emsp;&emsp;Central Office, C/O Central
				Workshop GSRTC, Naroda, Gita Mandir,<br /> &emsp;&emsp;&emsp;Ahmedabad, Gujarat 380001</font> <br />
			    &emsp;<i class=" gujju-text-blue fa-phone fa"></i> <font
				face="Times New Roman" size="+1">+91 9033037081</font> <br /> <br />
		</div>
	</div>
	 </div>
 <%@ include file="footer.jsp" %> 
<script>
			 $(document).ready(function() {
				$("#contactus").removeClass("gujju-blue gujju-card-24");
				$("#contactus").addClass("gujju-theme-d2 gujju-card-24");
				 
			}); 
			</script>
<%} %>
</body>
</html>
