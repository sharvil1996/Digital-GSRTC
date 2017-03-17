<%@page import="com.dsynhub.digitalgsrtc.bean.SeatTypeBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin | SeatType Update</title>
<link rel="icon" href="DigitalGSRTC-photos/logo.ico" />
</head>
<body>
<%@ include file="adminHeader.jsp"%>
<div style="margin-top: -850px;margin-left: 250px;">
	<section class="content-header">
	<h1>
		Seat Type <small>Update</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="adminDashBoard.jsp"><i class="fa fa-dashboard"></i>
				Home</a></li>
		<li class="active">SeatType</li>
	</ol>
	</section><br><br>
	<%
		SeatTypeBean seatTypeBean = (SeatTypeBean) request
				.getAttribute("seatTypeBean");
		if (seatTypeBean != null) {
	%>
	<div class="col-lg-6">
		<br />
		<div class="container">
			<form action="SeatTypeUpdateServlet" method="post">
			<input type="hidden" name="seatTypeId" id="seatTypeId"
			value="<%=seatTypeBean.getSeatTypeId()%>">
				<div class="row">
					<div class="col-lg-10">
						<label class="col-sm-2"><font size="+1">SeatType Name:</font></label>
						<div class="col-lg-6">
							<input type="text" name="txtSeatTypeName" placeholder="Seat Type Name"
								maxlength="7" value="<%=seatTypeBean.getSeatTypeName()%>" 
								class="form-control" /></input> 
						</div><font color="red">${seatTypeName}</font>
					</div>
				</div>
				<br>
				<br></br>
				<label class="col-sm-2 control-label"></label>
					<input type="reset" value="Reset" name="reset"
						class="btn  btn-danger">
					&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
					<input type="Submit" value="Submit" name="submit"
						class="btn btn-success">
			</form>
		</div>
	</div>
<%}else{%>
<center><font color="red" size="+1"><br><br><br><br><br><br><br><b>No Data Found.....</b></font></center> 
<%} %>
</div>
</body>
</html>














