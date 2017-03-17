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
<title>PassDetail Detail List</title>

<link rel="icon" href="DigitalGSRTC-photos/logo.ico" /></head>
<body class="col-*-*">
	<%
		PassBean passBean = (PassBean) session
				.getAttribute("passBean");
		if (passBean != null)
	%>

	<form >
		<button onclick="p()" style="margin-left: 600px; position: absolute;"
			class="gujju-blue gujju-btn">
			<i class="fa-print fa"></i>&emsp;<b>Print Pass</b>
		</button>
		<div
			style="margin-top: 30px; background-color: transparent; border:3px; border-color:blue; padding-left: 30px;">
			<div>
				<img src="upload\\QRCode\\<%=passBean.getFirstName()+" "+passBean.getMiddleName()+" "+passBean.getLastName()%>.gif" width="100" height="100" /> <font
					face="Jokerman" size="+5" style="margin-top: -10px; color: #2196F3">GujjuBus</font>
			</div>

			<br /> <img alt="photo Not Found"
				src="<%="upload/pass/" + passBean.getPhoto()%>"
				style="margin-left: 150px; margin-top: -20px; position: absolute;"
				width="120" height="140" />


			<div style="position: absolute; margin-top: 100px;">

				<div style="margin-top: 100px;">
					<div
						style="margin-top: -70px; margin-left: 110px; text-transform: uppercase; word-spacing: 2em;">
						<b><%=passBean.getFirstName()%> <%=passBean.getMiddleName()%>
							<%=passBean.getLastName()%></b>
					</div>
				</div>
				<div style="margin-left: 80px;">
					<b style="weigth: 300px;"><b>Start Date:&emsp;&nbsp;</b> </b>
					<%=new Date().toString().substring(0, 10) + " 2015"%><br /> <b>Pass
						Validity:</b><%=passBean.getValidity() + " months"%>
					<br />
				</div>
				<div style="margin-left: 80px;">
					<b style="weigth: 300px;"><b>End Date:&emsp;&nbsp;</b> </b>
					<%=passBean.getEndTermDate()%><br /> 
					<br />
				</div>
				<div style="margin-left: 80px">
					<b>Route: &emsp;&emsp;&emsp;</b>
					<%=passBean.getSource()%>
					-
					<%=passBean.getDestination()%>
				</div>
				<div style="margin-left: 80px">
					<b>Organization:</b><%=passBean.getOrganizationName()%>
					<br /> <b>Amount:&emsp;&emsp;</b>
					<%=Integer.parseInt(passBean.getValidity())*300%>
				</div>
				<br />

				<div style="margin-left: 80px">
					<div>
						<b>Email :</b><%=passBean.getEmail()%><br /> <b>Organization
							Address :</b>
						<%=passBean.getOrganizationAddress()%>
					</div>

				</div>
				<br /> <br /> <br /> <br />

			</div>
		</div>
	</form>
	<script>
		function p() {
			window.print();
		}
	</script>

</body>
</html>