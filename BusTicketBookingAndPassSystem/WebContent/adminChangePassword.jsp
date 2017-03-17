<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
<link rel="icon" href="DigitalGSRTC-photos/logo.ico" />
</head>

<body>
	<%@include file="adminHeader.jsp"%>
	<div style="margin-top: -850px; margin-left: 250px;">
		<section class="content-header">
		<h1>
			Password <small>Change</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="adminDashBoard.jsp"><i class="fa fa-dashboard"></i>
					Home</a></li>
			<li class="active">Admin</li>
		</ol>
		</section>
		<br>
		<br>
		<form action="AdminPasswordChangeServet" method="post">
			<div class="container">
				<div class="row">
					<div class="col-lg-8">
						<div class="col-sm-3">
							<font size="+1">Old Password:</font>
						</div>
						<div class="col-md-9">
							<input type="password" class="form-control" name="pwdOldPassword"
								id="txtoldpassword" maxlength="30" placeholder="Create password"
								value="${pwdOldPassword}" /> <font color="red"><b>${msgOldPassword}</b></font>
						</div>
					</div>
				</div>
				<br />
				<div class="row">
					<div class="col-lg-8">
						<div class="col-sm-3">
							<font size="+1">New Password:</font>
						</div>
						<div class="col-md-9">
							<input type="password" class="form-control" name="pwdPassword"
								id="txtpassword" maxlength="30" placeholder="Create password"
								value="${pwdPassword}" /> <font color="red"><b>${msgPassword}</b></font>
						</div>
					</div>
				</div>

				<br /> 
				<div class="row">
					<div class="col-lg-8">
						<div class="col-sm-3">
							<font size="+1">Conform Password:</font>
						</div>
						<div class="col-md-9">
							<input type="password" class="form-control" name="pwdCpassword"
								id="txtpassword" maxlength="30" placeholder="Re-enter password"
								value="${pwdCpassword}" /> <font color="red"><b>${msgCpassword}</b></font>

						</div>
						<br /> <br /> <br /> <input type="submit"
							class="btn btn-success"
							style="margin-left: 270px;" value="Change Password">
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>