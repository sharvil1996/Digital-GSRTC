<%@page import="com.dsynhub.digitalgsrtc.dao.StationDAO"%>
<%@page import="com.dsynhub.digitalgsrtc.bean.StationBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Search</title>
<link rel="icon" href="DigitalGSRTC-photos/logo.ico" />
<style>
input {
	text-transform: capitalize;
}
</style>
</head>
<body>
<%@ include file="adminHeader.jsp"%>
<div style="margin-top: -850px;margin-left: 250px;">
	<section class="content-header">
	<h1>
		Admin <small>Search</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="adminDashBoard.jsp"><i class="fa fa-dashboard"></i>
				Home</a></li>
		<li class="active">Admin</li>
	</ol>
	</section><br><br>
		${msgUser} ${msgReservation}
		<%!List<StationBean> stationBeansList;%>
	<div class="col-lg-6">
		<div class="container">
		 <form action="AdminScheduleListServlet" method="post">
					<div class="row">
						<h3 >
							&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
							Search Bus Here <i class="fa-search fa" style="color: #0099FF"></i>
						</h3>
						<br />
						<div class="col-lg-13">
							<label class="col-sm-2"> <font size="+1">&emsp;&emsp;&emsp;From &emsp;:</font> </label>
							<div class="col-lg-6">
							<input list="Source" name="selSourceName" maxlength="20"
									placeholder="Source" class="form-control" autocomplete="off"
									value="${sourceName}" />
							<datalist id="Source"> <%
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
								 <%
 								}
 								%> 
 							</datalist>
								<font color="red"> ${msgSourceName}</font>
							</div>
						</div>
						
						<br /> <br />
						<div class="col-lg-13">
							<label class="col-sm-2"> <font size="+1">&emsp;&emsp;&emsp;To &emsp;&emsp; :</font> </label>
							<div class="col-lg-6">
								<input list="Destination" placeholder="Destination"
									name="selDestinationName" maxlength="20" class="form-control"
									autocomplete="off" value="${DestinationName}" />
								<datalist id="Destination"> <%
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
											<%
 										}
 									%> 
 								</datalist>
								<font color="red"> ${msgDestinationName}</font>
							</div>

							<br /> <br />
			  			</div>
						<br />
						<div class="gujju-col m7" style="margin-left: 200px;">
							<button type="submit"
								class="fa-search fa   btn btn-primary"
								style="margin-left: 180px;">&emsp;Search Bus</button>
							<br /> <br />
						</div>
					</div>
				
		</form>
		</div>
		</div>
		<%-- 	<%@ include file="userFooter.jsp"%> --%>
		</div>
</body>
</html>
