<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%@ page isErrorPage="true"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>error</title>
<script>
function goBack() {
    window.history.back();
}
</script>
</head>
<body>
<center>
	<img alt="Oops !!! Something went wrong" src="DigitalGSRTC-photos/error.png">
	<button onclick="goBack()">Go Back</button>
</center>
</body>
</html>