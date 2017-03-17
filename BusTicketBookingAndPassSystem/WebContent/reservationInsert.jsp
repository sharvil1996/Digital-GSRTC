<%@page import="com.dsynhub.digitalgsrtc.dao.UserDAO"%>
<%@page import="com.dsynhub.digitalgsrtc.bean.UserBean"%>
<%@page import="com.dsynhub.digitalgsrtc.bean.BusBean"%>
<%@page import="com.dsynhub.digitalgsrtc.bean.RouteBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dsynhub.digitalgsrtc.dao.StationDAO"%>
<%@page import="com.dsynhub.digitalgsrtc.bean.StationBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reservation Insert</title>
<link rel="icon" href="DigitalGSRTC-photos/logo.ico" />
</head>
<body>
	<%@ include file="adminHeader.jsp"%>
	<div style="margin-top: -850px; margin-left: 250px;">
		<section class="content-header">
		<h1>
			Reservation <small>Insert</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="adminDashBoard.jsp"><i class="fa fa-dashboard"></i>
					Home</a></li>
			<li class="active">Admin</li>
		</ol>
		</section>
		<br> <br> ${msgReservation}
		<%!ArrayList<RouteBean> routeBeansList;
	ArrayList<BusBean> busBeansList;%>
		<div class="col-lg-6">
			<div class="container">
				<form action="ReservationInsertServlet" method="post">
					<div class="row">

						<br />
						<div class="col-lg-13">
							<label class="col-sm-2"> <font size="+1">&emsp;Select
									User &emsp;:</font>
							</label>
							<div class="col-lg-6">
								<select name="selUser" class="form-control">

									<option value="0" selected="selected">Select User
										[Email]</option>
									<%
										List<UserBean> userBeansList = new UserDAO().list();
										for (int i = 0; i < userBeansList.size(); i++) {
											String j = request.getParameter("selUser");
											String tmp = "unselected";
											if (j == null)
												tmp = "unselected";
											else if (j.equals(userBeansList.get(i).getUserId()))
												tmp = "selected";
									%>

									<option value="<%=userBeansList.get(i).getUserId()%>" <%=tmp%>><%=userBeansList.get(i).getEmail()%></option>
									<%
										}
									%>
								</select><font color="red"><b>${msgUser}</b></font>
							</div>
						</div>
						<br /> <br /> <br /> 
						<div class="col-lg-13">
							<label class="col-sm-2"> <font size="+1">&emsp;&nbsp;No
									of Seat &emsp; :</font>
							</label>
							<div class="col-lg-6">
								<input type="text" class="form-control text-capitalize" min="1"
									max="552" maxlength="2" placeholder="No of Seat" value = "${seat}"
									name="noOfSeat" oninput="space(this);onlydigit(this);" /> <font
									color="red"><b>${msgSeat}</b></font>
							</div>

						</div>
						<br /> <br /> <br /> 
						<div class="col-lg-13">
							<label class="col-sm-2"> <font size="+1">&emsp;&nbsp;Journey
									Date &emsp; :</font>
							</label>
							<div class="col-lg-6">
								<input type="date" class="form-control" id="date" name="resDate"
									placeholder="mm-dd-yyyy" value="${journeyDate}" min="2014-01-01"
									disabled /><font color="red"><b>${msgDate}</b></font>
							</div>


						</div>
						<br /> <br /> <br /> <br /> <label
							class="col-sm-2 control-label"></label> <input type="reset"
							value="Reset" name="reset" class="btn  btn-danger">
						&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
						<input type="Submit" value="Ragister" name="submit"
							class="btn btn-success">
					</div>

				</form>
			</div>
		</div>
		<%-- 	<%@ include file="userFooter.jsp"%> --%>
	</div>
	<script>
		var input = document.getElementById("date");
		var today = new Date();
		var day = today.getDate();
		// Set month to string to add leading 0
		var mon = new String(today.getMonth() + 1); //January is 0!
		var yr = today.getFullYear();

		if (mon.length < 2) {
			mon = "0" + mon;
		}

		var date = new String(yr + '-' + mon + '-' + day);

		input.disabled = false;
		input.setAttribute('min', date);
	</script>
</body>
</html>
