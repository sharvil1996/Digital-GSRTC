<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="icon" href="DigitalGSRTC-photos/logo.ico" /></head>
<script>
function goBack() {
    window.history.back();
}
</script>
<body>
<%@include file="userHeader.jsp" %>

<center><p class="gujju-half gujju-red gujju-card-30 text-uppercase"><br />
<emsp>You have no Pass...!!&emsp;</emsp>
<button onclick="goBack()" class="gujju-green gujju-btn">Go Back</button>
<br /></p></center>
</body>
</html>