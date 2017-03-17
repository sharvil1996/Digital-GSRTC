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

<link rel="icon" href="DigitalGSRTC-photos/logo.ico" />
<script>
function goBack() {
    window.history.back();
}
</script>
</head>
<body>
	<%
		PassBean passBean = (PassBean) session.getAttribute("passBean");
		if (passBean != null)
	%>

	<form>
		<button onclick="p()"
			style="text-align: center; position: fixed; top: 0; width: 150px; left: 50%; margin-left: -75px;"
			class="gujju-blue gujju-btn">
			<i class="fa-print fa"></i>&emsp;<b>Print Pass</b>
		</button>
		<button onclick="goBack()" class="gujju-green gujju-btn">Go Back</button>
		<br> <br>
		<table
			style="width: 45%; margin: 0 auto; font-family: 'Trebuchet MS'; font-size: 18px; color: rgba(70, 70, 70, 1); background-image: url('DigitalGSRTC-photos/logo1.png'); background-repeat: no-repeat; background-position: -40px 280px; background-size: 400px 210px;">
			<tr style="text-align: center;">
				<td colspan="2"><span
					style="font-family: alpha54; font-size: 42px; color: #2196F3;">Digital
						GSRTC</span></td>
			</tr>
			<tr>
				<td><img
					src="upload\\QRCode\\ReNew\\<%=passBean.getFirstName() + " " + passBean.getMiddleName()
					+ " " + passBean.getLastName()%>.gif"
					width="125" height="125"
					style="box-shadow: 0 2px 3px rgba(0, 0, 0, 0.3); border-radius: 3px;" /></td>
				<td style="text-align: right;"><img alt="photo Not Found"
					src="<%="upload/pass/" + passBean.getPhoto()%>"
					style="box-shadow: 0 2px 3px rgba(0, 0, 0, 0.3); border-radius: 3px;"
					width="120" height="140" /></td>
			</tr>
			<tr>
				<td colspan="2"
					style="padding: 10px 0; text-align: center; text-transform: uppercase; font-weight: 900; font-size: 26px;"><%=passBean.getFirstName()%>
					<%=passBean.getMiddleName()%> <%=passBean.getLastName()%></td>
			</tr>
			<tr>
				<td style="font-weight: 900;">Start Date</td>
				<td style="text-align: center;"><%=new Date().toString().substring(0, 10) + " 2016"%></td>
			</tr>
			<tr>
				<td style="font-weight: 900;">Pass Validity</td>
				<td style="text-align: center;"><%=passBean.getValidity() + " months"%></td>
			</tr>
			<tr>
				<td style="font-weight: 900;">End Date</td>
				<td style="text-align: center;"><%=passBean.getEndTermDate()%></td>
			</tr>
			<tr>
				<td style="font-weight: 900;">Route</td>
				<td style="text-align: center;"><%=passBean.getSource()%> - <%=passBean.getDestination()%></td>
			</tr>
			<tr>
				<td style="font-weight: 900;">Organization</td>
				<td style="text-align: center;"><%=passBean.getOrganizationName()%></td>
			</tr>
			<tr>
				<td style="font-weight: 900;">Amount</td>
				<td style="text-align: center;"><%=Integer.parseInt(passBean.getValidity()) * 300%></td>
			</tr>
			<tr>
				<td style="font-weight: 900;">Email</td>
				<td style="text-align: center;"><%=passBean.getEmail()%></td>
			</tr>
			<tr>
				<td style="font-weight: 900;">Organization Address</td>
				<td style="text-align: center;"><%=passBean.getOrganizationAddress()%></td>
			</tr>
		</table>
	</form>
	<script>
		function p() {
			window.print();
		}
	</script>

</body>
</html>