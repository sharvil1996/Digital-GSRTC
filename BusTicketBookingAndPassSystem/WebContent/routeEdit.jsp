<%@page import="com.dsynhub.digitalgsrtc.bean.StationBean"%>
<%@page import="com.dsynhub.digitalgsrtc.dao.StationDAO"%>
<%@page import="com.dsynhub.digitalgsrtc.bean.RouteBean"%>
<%@page import="java.util.List"%>
<%@page import="com.dsynhub.digitalgsrtc.dao.RouteDAO"%>
<%@page import="com.dsynhub.digitalgsrtc.bean.RouteBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin | Route Update</title>

</head>
<body>
<%@ include file="adminHeader.jsp"%>
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
	<%
		RouteBean routeBean = (RouteBean) request.getAttribute("routeBean");
		if (routeBean != null) {
	%>
	<div class="col-lg-6">
		<br />
		<div class="container">
			<form action="RouteUpdateServlet" method="post">
				<input type="hidden" name="routeId" id="routeId"
			value="<%=routeBean.getRouteId()%>">
				
				<div class="row">
					<div class="col-lg-10">
						<label class="col-sm-2"><font size="+1">Source : </font> </label>
						<div class="col-lg-6">
							<select name="selSourceName" id="selSourceName" class="form-control">
						<option value="0" selected="selected">Select Source</option>
							<%
								RouteBean routeSource = (RouteBean) request
											.getAttribute("routeBean");
									StationDAO sourceDAO = new StationDAO();

									List<StationBean> sourceList = sourceDAO.list();

									for (int i = 0; i < sourceList.size(); i++) {
										StationBean source = sourceList.get(i);

										if (source.getStationId().equals(routeSource.getSourceId())) {
							%>
							<option value="<%=source.getStationId()%>" selected="selected"><%=source.getStationName()%></option>
							<%
								} else {
							%>
							<option value="<%=source.getStationId()%>"><%=source.getStationName()%></option>
							<%
								}
									}
							%>
						</select>
						</div><font color="red">${msgRouteName}</font>
					</div>
				</div>
				<br>
				
				<div class="row">
					<div class="col-lg-10">
						<label class="col-sm-2"><font size="+1">Destination : </font> </label>
						<div class="col-lg-6">
							<select name="selDestinationName" id="selDestinationName" class="form-control">
						<option value="0" selected="selected">Select Destination</option>
							<%
								RouteBean routeDestination = (RouteBean) request
											.getAttribute("routeBean");
									StationDAO destinationDAO = new StationDAO();

									List<StationBean> destinationList = destinationDAO.list();

									for (int i = 0; i < destinationList.size(); i++) {
										StationBean destination = destinationList.get(i);

										if (destination.getStationId().equals(routeDestination.getDestinationId())) {
							%>
							<option value="<%=destination.getStationId()%>" selected="selected"><%=destination.getStationName()%></option>
							<%
								} else {
							%>
							<option value="<%=destination.getStationId()%>"><%=destination.getStationName()%></option>
							<%
								}
									}
							%>
						</select>
						</div><font color="red">${msgRouteName}</font>
					</div>
				</div>
				<br>
				
							
				<div class="row">
					<div class="col-lg-10">
						<label class="col-sm-3"><font size="+1">Is Active : </font>
						</label>
						<div class="col-md-7">
							<div class="col-sm-6">
								<input type="radio" name="rdoAvalibility" value="y" checked="checked" /> <font>Yes</font>
							</div>
							<div class="col-sm-6">
								<input type="radio" name="rdoAvalibility" value="n"/> <font>No</font>
							</div>
						</div>
					</div>
				</div>

				
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
 


