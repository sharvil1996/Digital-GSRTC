<%@page import="com.dsynhub.digitalgsrtc.util.ValidationUtils"%>
<%@page import="com.dsynhub.digitalgsrtc.bean.ScheduleDetailBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Schedule Detail</title>

<link rel="stylesheet" href="DigitalGSRTC-css/font-awesome.min.css" />
<link rel="icon" href="DigitalGSRTC-photos/logo.ico" /></head>
<body class="col-*-*">
	<%@include file="userHeader.jsp"%>
	<%
			ArrayList<ScheduleDetailBean> scheduleDetailBeanList = (ArrayList) request.getAttribute("scheduleDetailBeans");
		%>
	<br />
	<div class="container-fluid">
		<div class="gujju-row">
			<table class="table-responsive table table-hover table gujju-card-8">
				<thead class="gujju-theme text-uppercase" >
					<tr>
						<th>bus no</th>
						<th>source</th>
						<th>destination</th>
						<th>distance</th>
						<th>arrival time</th>
						<th>departure time</th>
						<th>time taken</th>
						<th>Bus Category</th>
						<th>Bus Type</th>
						<th>off day</th>
						<th colspan=2>Action</th>
					</tr>
				</thead>
				<tbody>
					<%
					for (int i = 0; i < scheduleDetailBeanList.size(); i++) {
						ScheduleDetailBean scheduleDetailBean = scheduleDetailBeanList.get(i);
				%>
				<%Integer time = scheduleDetailBean.getTimeTaken();
	String TimeTaken="";
	if(time>60)
	{
		time/=60;
		TimeTaken+=time+" Hr";
	}
	else
	{
		TimeTaken+=time+"min";
	}
	%>
					<tr>
						<td><%=scheduleDetailBean.getBusNo()%></td>
						<td><%=scheduleDetailBean.getSource()%></td>
						<td><%=scheduleDetailBean.getDestination()%></td>
						<td><%=scheduleDetailBean.getDistance()%></td>
						<td><%=scheduleDetailBean.getArrivalTime()%></td>
						<td><%=scheduleDetailBean.getDepartureTime()%></td>
						
						<td><%= TimeTaken %></td>
						
						<td>Normal</td>
						<td>Express</td>
						<td><%=ValidationUtils.getDay(scheduleDetailBean
						.getWeekOfDay())%></td>
						<td>
						<td><a
							href="UserScheduleSessionServlet?scheduleId=<%=scheduleDetailBean.getScheduleId() %>"
							class=" fa-ticket fa gujju-blue gujju-btn"
							style="font-size: 20px">Book Ticket</a></td>
					</tr>
					<%
					}
				%>
				</tbody>
			</table>
		</div>
	</div>
	
	<%@include
		file="userFooter.jsp"%> 
</body>
</html>