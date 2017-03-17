<%@page import="com.dsynhub.digitalgsrtc.bean.RouteBean"%>
<%@page import="com.dsynhub.digitalgsrtc.dao.RouteDAO"%>
<%@page import="com.dsynhub.digitalgsrtc.bean.BusBean"%>
<%@page import="java.util.List"%>
<%@page import="com.dsynhub.digitalgsrtc.dao.BusDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin | BusDetail Insert</title>
<link rel="icon" href="DigitalGSRTC-photos/logo.ico" />
</head>
<body>
<%@ include file="adminHeader.jsp"%>
<div style="margin-top: -850px;margin-left: 250px;">
	<section class="content-header">
	<h1>
		Bus Detail <small>Insert</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="adminDashBoard.jsp"><i class="fa fa-dashboard"></i>
				Home</a></li>
		<li class="active">BusDetail</li>
	</ol>
	</section><br><br>
	<div class="col-lg-6">
		<br />
		<div class="container">
			<form action="BusDetailInsertServlet" method="post">
				
				<div class="row">
					<div class="col-lg-10">
						<label class="col-sm-2"><font size="+1">Bus No :
						</font> </label>
						<div class="col-lg-6">
							<select name="selBusNo" id="selBusNo" class="form-control">
								<option value="0" selected="selected">Select Bus</option>
						<%
							BusDAO busDAO = new BusDAO();
							List<BusBean> busList = busDAO.list();

							for (int i = 0; i < busList.size(); i++) {
								String busNo = busList.get(i).getBusNo().replace(" ", "-");
								String tmp = "unselected";
								String type = request.getParameter("selBusNo");
								if (type == null)
									tmp = "unselected";
								else if (busList.get(i).getBusNo().equals(type))
									tmp = "selected";
						%>

						<option value=<%=busNo%> <%=tmp%>>
							<%=busList.get(i).getBusNo()%></option>
						<%
							}
						%>
						</select>
						</div><font color="red">${busNo}</font>
					</div>
				</div>
				<br>

				<div class="row">
					<div class="col-lg-10">
						<label class="col-sm-2"><font size="+1">Route : </font> </label>
						<div class="col-lg-6">
							<select name="selRoute" id="selRoute" class="form-control">
						<option value="0" selected="selected">Select Route</option>
						<%
							RouteDAO routeDAO = new RouteDAO();
							List<RouteBean> routeList = routeDAO.list();

							for (int i = 0; i < routeList.size(); i++) {

								String tmp = "unselected";
								String type = request.getParameter("selRoute");
								if (type == null)
									tmp = "unselected";
								else if (routeList.get(i).getRouteId().equals(type))
									tmp = "selected";
						%>

						<option value=<%=routeList.get(i).getRouteId()%> <%=tmp%>>
							<%=routeList.get(i).getSourceName() + "-"
						+ routeList.get(i).getDestinationName()%></option>
						<%
							}
						%>
						</select>
						</div><font color="red">${route}</font>
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
</div>
</body>
</html>


