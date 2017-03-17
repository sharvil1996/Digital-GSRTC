<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin | ReservationStatus Insert</title>
<script type="text/javascript" src="DigitalGSRTC-javaScript/mainscript.js"></script>
</head>
<body>
<%@ include file="adminHeader.jsp"%>
<div style="margin-top: -850px;margin-left: 250px;">
	<section class="content-header">
	<h1>
		Reservation Status <small>Insert</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="adminDashBoard.jsp"><i class="fa fa-dashboard"></i>
				Home</a></li>
		<li class="active">ReservationStatus
		</li>
	</ol>
	</section><br><br>
	<div class="col-lg-6">
		<br />
		<div class="container">
			<form action="ReservationStatusInsertServlet" method="post">
				<div class="row">
					<div class="col-lg-10">
						<label class="col-sm-2"><font size="+1">Reservation Status : </font> </label>
						<div class="col-lg-6">
							<input type="text" size="30" maxlength="7" class="form-control"
								name="txtReservationStatusName" placeholder="Reservation Status Name" oninput="space(this);onlytext(this); nodigit(this);"/>
					</div><font color="red">${reservationStatusName}</font><br>
				</div>
				<br></br><br><br>
				
					<label class="col-sm-2 control-label"></label>
					<input type="reset" value="Reset" name="reset"
						class="btn  btn-danger">
					&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
					<input type="Submit" value="Submit" name="submit"
						class="btn btn-success">
					
				</div>
			</form>
		</div>
	</div>
</div>
</body>
</html>


