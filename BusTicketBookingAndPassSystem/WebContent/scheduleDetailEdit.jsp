<%@page import="com.dsynhub.digitalgsrtc.bean.StationBean"%>
<%@page import="com.dsynhub.digitalgsrtc.dao.StationDAO"%>
<%@page import="com.dsynhub.digitalgsrtc.dao.BusDAO"%>
<%@page import="com.dsynhub.digitalgsrtc.bean.BusBean"%>
<%@page import="com.dsynhub.digitalgsrtc.bean.BusDetailBean"%>
<%@page import="java.util.List"%>
<%@page import="com.dsynhub.digitalgsrtc.dao.BusDetailDAO"%>
<%@page import="com.dsynhub.digitalgsrtc.bean.ScheduleDetailBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Schedule Insert</title>

<link rel="icon" href="DigitalGSRTC-photos/logo.ico" />
</head>
<body>
	<%@include file="adminHeader.jsp"%>
	<div style="margin-top: -850px;margin-left: 250px;">
		<section class="content-header">
	<h1>
		Route <small>Update</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="adminDashBoard.jsp"><i class="fa fa-dashboard"></i>
				Home</a></li>
		<li class="active">Route</li>
	</ol>
	</section><br><br>
		<%!List<StationBean> stationBeansList;%>

		<br />
		<div class="container">
			<%
				ScheduleDetailBean scheduleDetailBean = (ScheduleDetailBean) request
						.getAttribute("scheduleDetailBean");
			
			%>
			<form action="ScheduleDetailUpdateServlet"
				name="ScheduleDetailUpdateServlet" id="ScheduleDetailUpdateServlet"
				method="post">
				<input type="hidden" name="scheduleId" id="scheduleId"
					value="<%=scheduleDetailBean.getScheduleId()%>">
				<%
					List<BusBean> busDAOs = new BusDAO().list();
				%>
				<label class="col-sm-2"> Bus No</label>
				<div class="row">
					<div class="col-lg-5">
						<input list="Source" name="selBusNo" id="selBusNo"
							class="col-lg-2 form-control" autocomplete="off"
							value="<%=scheduleDetailBean.getBusNo()%>" readonly="readonly" />
						<datalist id="BusNo"> <%
 	for (int i = 0; i < busDAOs.size(); i++) {
 		String tmp = "unselected";
 %>
						<option value="<%=busDAOs.get(i).getBusNo()%>"></option>
						<%
							}
						%> </datalist>
						<br /> <font color="red"><b>${msgBusNo}</b></font> <br />
					</div>
				</div>
				<br>
				
				<label class="col-sm-2"> Source </label>
				<div class="row">
					<div class="col-md-5">
						<input list="Source" name="selSourceName" class="form-control"
							value="<%=scheduleDetailBean.getSource()%>" autocomplete="off" />
						<datalist id="Source"> <%
 	stationBeansList = new StationDAO().list();
 	String type = scheduleDetailBean.getSourceId();

 	for (int i = 0; i < stationBeansList.size(); i++) {
 %>
						<option value="<%=stationBeansList.get(i).getStationName()%>"><%=stationBeansList.get(i).getStationName()%></option>
						<!-- all option value  name like Ahmedabad--> <%
 	}
 %> </datalist>
					</div>
					<font color="red"><b> ${msgSourceName}</b></font>
				</div>

				<br /> <label class="col-sm-2"> Destination </label>
				<div class="row">
					<div class="col-md-5">
						<input list="Destination" name="selDestinationName"
							class="form-control"
							value="<%=scheduleDetailBean.getDestination()%>"
							autocomplete="off" />
						<datalist id="Destination"> <%
								stationBeansList = new StationDAO().list();
								type = scheduleDetailBean.getDestinationId();
								for (int i = 0; i < stationBeansList.size(); i++) {

									String tmp = "unselected";
									if (stationBeansList.get(i).getStationId().equals(type))
										tmp = "selected";
							%>


						<option value="<%=stationBeansList.get(i).getStationName()%>"
							<%=tmp%>></option>
						<!-- all option value  name like Gandhinagar--> <%
 	}
 %> </datalist>
					</div>
					<font color="red"><b>${msgDestinationName}</b></font>
				</div>

				<br /> <label class="col-sm-2"> Week Of </label>
				<div class="row">
					<div class="col-md-5">
						<%
							String arry[] = new String[8];
							for (int i = 0; i < arry.length; i++) {
								if (scheduleDetailBean.getWeekOfDay() == i)
									arry[i] = "selected";
								else
									arry[i] = "selected";
							}
						%>
						<select class="form-control" name="weekOffDay">
							<option value="0" <%=arry[0]%>>None</option>
							<option value="1" <%=arry[1]%>>SUNDAY</option>
							<option value="2" <%=arry[2]%>>MONDAY</option>
							<option value="3" <%=arry[3]%>>TUESDAY</option>
							<option value="4" <%=arry[4]%>>WEDNESDAY</option>
							<option value="5" <%=arry[5]%>>THURSDAY</option>
							<option value="6" <%=arry[6]%>>FRIDAY</option>
							<option value="7" <%=arry[7]%>>SATURDAY</option>
						</select>
					</div>

				</div>
				<br /> <label class="col-sm-2"> Off Date </label>
				<div class="row">
					<div class="col-md-5">
						<input type="date" name="txtWeekOffDate"
							value="<%=scheduleDetailBean.getOffDate()%>" class="form-control" />
					</div>
					<font color="red"><b>${msgweekOffDate}</b></font>
				</div>
				<br /> <label class="col-sm-2"> Arrival Time </label>
				<div class="row">
					<div class="col-md-5">
						<input type="time" name="txtArrivalTime"
							value="<%=scheduleDetailBean.getArrivalTime()%>"
							class="form-control" />
					</div>
					<font color="red"><b>${msgArrivalTime}</b></font>
				</div>

				<br /> <label class="col-sm-2"> Departure Time </label>
				<div class="row">
					<div class="col-md-5">
						<input type="time" name="txtDepartureTime"
							value="<%=scheduleDetailBean.getDepartureTime()%>"
							class="form-control" />
					</div>
					<font color="red"><b>${msgDepartureTime}</b></font>
				</div>
				<br /> <label class="col-sm-2"> Reach Time </label>
				<div class="row">
					<div class="col-md-5">
						<input type="time" name="txtReachTime" class="form-control"
							value="<%=scheduleDetailBean.getReachTime()%>" />
					</div>
					<font color="red"><b>${msgReachTime}</b></font>
				</div>
				<br />
				<label class="col-sm-2 control-label"></label>
					<input type="reset" value="Reset" name="reset"
						class="btn  btn-danger">
					&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
					<input type="Submit" value="Submit" name="submit"
						class="btn btn-success">
			</form>

		</div>
	</div>
	<script type="text/javascript">
	<!--
		//-->
		$(document).ready(function() {
			$("#treeSchedule").show();
			$("#schedule").addClass("effect");
			$("#addSchedule").addClass("effect");
		});
	</script>

</body>
</html>
