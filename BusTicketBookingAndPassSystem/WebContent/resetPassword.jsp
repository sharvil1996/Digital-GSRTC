<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="icon" href="DigitalGSRTC-photos/logo.ico" />
<style>
input {
	text-transform: capitalize;
}
</style>
</head>

</head>


<body>
	<%@include file="header.jsp"%>
	<form action="UserPassWordResetServlet"
		method="post">
		<input type="hidden" name="emailId" value="<%=request.getParameter("emailId")%>"/>
		<div class="row">
			<div class="col-lg-8">
				<div class="col-sm-3">
					<font size="+1">New Password:</font>
				</div>
				<div class="col-md-9">
					<input type="password" class="form-control" name="pwdPassword"
						id="txtPassword" maxlength="30" placeholder="Create password"
						value="${pwdPassword}" /> <font color="red"><b>${msgPassword}</b></font>
				</div>
			</div>
		</div>
		<br /> <br />
		<div class="row">
			<div class="col-lg-8">
				<div class="col-sm-3">
					<font size="+1">Re-Enter New Password:</font>
				</div>
				<div class="col-md-9">
					<input type="password" class="form-control" name="pwdCpassword"
						id="txtPassword" maxlength="30" placeholder="Re-enter password"
						value="${pwdCpassword}" /> <font color="red"><b>${msgCpassword}</b></font>

				</div>
				<br>
			</div>
		</div>
			<br><br><br>
				<input type="submit" class="btn btn-success" value="change password" style="margin-left: 100px;">
			
	</form>
</body>
</html>