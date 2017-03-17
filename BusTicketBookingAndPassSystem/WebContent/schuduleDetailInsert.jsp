<%@page import="java.util.List"%>
<%@page import="com.dsynhub.digitalgsrtc.dao.StationDAO"%>
<%@page import="com.dsynhub.digitalgsrtc.dao.RouteDAO"%>
<%@page import="com.dsynhub.digitalgsrtc.bean.RouteBean"%>
<%@page import="com.dsynhub.digitalgsrtc.dao.BusDetailDAO"%>
<%@page import="com.dsynhub.digitalgsrtc.bean.BusDetailBean"%>
<%@page import="com.dsynhub.digitalgsrtc.bean.StationBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Schedule Insert</title>
<script type="text/javascript" src="DigitalGSRTC-javaScript/mainscript.js"></script>
<script type='text/javascript'
	src='/BusTicketBookingAndPassSystem/dwr/interface/RouteDAO.js'></script>
<script type='text/javascript'
	src='/BusTicketBookingAndPassSystem/dwr/engine.js'></script>
<script type='text/javascript'
	src='/BusTicketBookingAndPassSystem/dwr/util.js'></script>
<script type="text/javascript">
	function getBusNo(busId) {
		dwr.util.removeAllOptions("selBusNo");
		if (busId == '') {
			var data = [ {
				BusNumber : '---select Bus No---',
				BusId : +''
			} ];
			dwr.util.addOptions("selBusNo", data, "busNo", "busNo");
		} else {
			RouteDAO.getDistinctBusNo(busId, function(data) {
				dwr.util.addOptions("selBusNo", data, "busNo", "busNo");
			});
		}
	}
</script>
<link rel="icon" href="DigitalGSRTC-photos/logo.ico" />
</head>
<body>
<%@include file="adminHeader.jsp"%>
	<div style="margin-top: -850px; margin-left: 250px;">
	<section class="content-header">
	<h1>
		Schedule Detail <small>Insert</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="adminDashBoard.jsp"><i class="fa fa-dashboard"></i>
				Home</a></li>Schedule</li>
	</ol>
	</section><br><br>
		<br />
		<div class="container">
			<form action="ScheduleDetailInsertServlet" method="post">
				<%!List<StationBean> stationBeansList;%>

				<%
				
				ArrayList<BusDetailBean> busDetailBeans=new BusDetailDAO().getDistinctBusDetailList();
				%>
				<label class="col-sm-2"> Route</label>
				<div class="row">
					<div class="col-lg-5">
						<select name="selRouteName" class="col-lg-2 form-control"
							onChange="java:getBusNo(this.value)">
							<option value="0">---Select route---</option>
							<%
						for(int i=0;i<busDetailBeans.size();i++){
							RouteBean routeBean=new RouteDAO().getRouteByPK2(busDetailBeans.get(i).getRouteId());	
							if(routeBean.getRouteId().equals(busDetailBeans.get(i).getRouteId())){
								
					%>
							<option value="<%=routeBean.getRouteId()%>"><%= routeBean.getSourceName()+"  -  "+routeBean.getDestinationName() %>
							</option>
							<%
						}}
					%>
						</select>
					</div><font color="red">${msgRouteName}</font>
				</div><br>
				<label class="col-sm-2"> Bus No</label>
				<div class="row">
					<div class="col-lg-5">
						<select name="selBusNo" id="selBusNo"
							class="col-lg-2 form-control">
							<option value="0">---select bus no---</option>
						</select> 
					</div><font color="red"> ${msgBusNo} </font>  
				</div><br />

				<label class="col-sm-2"> Source </label>
				<div class="row">
					<div class="col-md-5">
						<input list="sourceName" name="sourceName" class="form-control" 
							autocomplete="off" value="${sourceName}" />
							<datalist id="sourceName">
							 <%
 								stationBeansList = new StationDAO().list();

							 	for (int i = 0; i < stationBeansList.size(); i++) {
	
 									String tmp = "unselected";
 									String type = request.getParameter("selSourceName");
 									if (type == null)
 										tmp = "unselected";
 									else if (stationBeansList.get(i).getStationId().equals(type))
 										tmp = "selected";
 								%>

								<option value="<%=stationBeansList.get(i).getStationName()%>"></option>
									<!-- all option value  name like Gandhinagar-->
									 <%
 										}
 									%>
 							 </datalist>	
						
					</div><font color="red">${msgSourceName}</font>
				</div>
				<br /> <label class="col-sm-2"> Destination </label>
				<div class="row">
					<div class="col-md-5">
						<input list="destinationName" name="destinationName" class="form-control"
							autocomplete="off" value="${destinationName}" />
						<datalist id="destinationName">
						 <%
 							stationBeansList = new StationDAO().list();

 							for (int i = 0; i < stationBeansList.size(); i++) {

						 		String tmp = "unselected";
 								String type = request.getParameter("selDestinationName");
 								if (type == null)
 									tmp = "unselected";
 								else if (stationBeansList.get(i).getStationId().equals(type))
 									tmp = "selected";
 						%>

						<option value="<%=stationBeansList.get(i).getStationName()%>"></option>
						<!-- all option value  name like Gandhinagar-->
						 <%
						 	}
 						%>
 					</datalist>
						
					</div><font color="red">${msgDestinationName}</font>
				</div>
				<br /> 
				<label class="col-sm-2">Distance</label>
				<div class="row">

					<div class="col-md-5">
						<input type="text" value="${txtDistance}" class="form-control"
							name="txtDistance" maxlength="3" oninput="space(this);onlydigit(this);"/> 
					</div><font color="red">
							${msgDistance}</font>
				</div>




				<br />
				 <label class="col-sm-2"> Week Off Day</label>
				<div class="row">

					<div class="col-md-5">
						<select class="form-control" name="weekOffDay">
							<option value="0">Select</option>
							<option value="1">SUNDAY</option>
							<option value="2">MONDAY</option>
							<option value="3">TUESDAY</option>
							<option value="4">WEDNESDAY</option>
							<option value="5">THURSDAY</option>
							<option value="6">FRIDAY</option>
							<option value="7">SATURDAY</option>
						</select> 
					</div><font color="red">${msgWeekOffDay}</font>
				</div>
				<br /> 
				<label class="col-sm-2"> Week Off Date </label>
				<div class="row">
					<div class="col-md-5">
						<input type="date" name="txtWeekOffDate" class="form-control"
							value="${weekOffDate}" />
					</div>
					<font color="red">${msgweekOffDate}</font>
				</div>

				<br /> <label class="col-sm-2"> Arrival Time </label>
				<div class="row">
					<div class="col-md-5">
						<input type="time" name="txtArrivalTime" value="${arrivalTime}" class="form-control" />
					</div>
					<font color="red">${msgArrivalTime}</font>
				</div>
					<br /> <label class="col-sm-2"> Departure Time </label>
				<div class="row">
					<div class="col-md-5">
						<input type="time" name="txtDepartureTime" value="${departureTime}" class="form-control" />
					</div>
					<font color="red">${msgDepartureTime}</font>
				</div>
				<br /> <label class="col-sm-2"> Reach Time </label>
				<div class="row">
					<div class="col-md-5">
						<input type="time" name="txtReachTime" value="${reachTime}" class="form-control" />
					</div>
					<font color="red">${msgReachTime}</font>
				</div>
				<br /> <br /> <br /><br>
				
					<label class="col-sm-2 control-label"></label>
					<input type="reset" value="Reset" name="reset"
						class="btn  btn-danger">
					&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
					<input type="Submit" value="Submit" name="submit"
						class="btn btn-success">
				
			</form>

		</div>
	</div>
	<script>
		$(document).ready(function() {
			$("#treeSchedule").show();
			$("#schedule").addClass("effect");
			$("#addSchedule").addClass("effect");
		});
	</script>

</body>
</html>
