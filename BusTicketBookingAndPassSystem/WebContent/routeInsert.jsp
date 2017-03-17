<%@page import="java.util.List"%>
<%@page import="com.dsynhub.digitalgsrtc.bean.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dsynhub.digitalgsrtc.dao.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin | Route Insert</title>
<style type="text/css">
.option	{
	text-transform: capitalize;
}
</style>
</head>
<body>
	<%@ include file="adminHeader.jsp"%>
	<div style="margin-top: -850px; margin-left: 250px;">
		<section class="content-header">
		<h1>
			Route <small>Insert</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="adminDashBoard.jsp"><i class="fa fa-dashboard"></i>
					Home</a></li>Route
			</li>
		</ol>
		</section>
		<br>
		<br>
		<div class="col-lg-6">
			<br />
			<div class="container">
				<form action="RouteInsertServlet" method="post" style="text-transform: capitalize;">
					<div class="row">
						<div class="col-lg-10">
							<label class="col-sm-2"><font size="+1">Source : </font>
							</label>
							<div class="col-lg-6">
								<select name="selSourceName" id="selSourceName"
									class="form-control">
									<option value="0" selected="selected">Select Source</option>
									<%
										StationDAO sourceDAO = new StationDAO();
										List<StationBean> sourceList = sourceDAO.list();

										for (int i = 0; i < sourceList.size(); i++) {
											String tmp = "unselected";
											String type = request.getParameter("selSourceName");
											if (type == null)
												tmp = "unselected";
											else if (sourceList.get(i).getStationId().equals(type))
												tmp = "selected";
									%>
									<option value=<%=sourceList.get(i).getStationId()%> <%=tmp%>>
										<%=sourceList.get(i).getStationName()%></option>
									<%
										}
									%>
								</select>
							</div>
							<font color="red">${msgSourceName}</font><br>
						</div>
					</div>
					<br />
					<div class="row">
						<div class="col-lg-10">
							<label class="col-sm-2"><font size="+1">Destination:
							</font> </label>
							<div class="col-lg-6">
								<select name="selDestinationName" id="selDestinationName"
									class="form-control">
									<option value="0" selected="selected">Select
										Destination</option>
									<%
										StationDAO destinationDAO = new StationDAO();
										List<StationBean> destinationList = destinationDAO.list();

										for (int i = 0; i < destinationList.size(); i++) {
											String tmp = "unselected";
											String type = request.getParameter("selDestinationName");
											if (type == null)
												tmp = "unselected";
											else if (destinationList.get(i).getStationId().equals(type))
												tmp = "selected";
									%>
									<option value=<%=destinationList.get(i).getStationId()%>
										<%=tmp%>>
										<%=destinationList.get(i).getStationName()%></option>
									<%
										}
									%>
								</select>
							</div>
							<font color="red">${msgDestinationName}</font><br>
						</div>
					</div>
					<br /> <br /> <br />
					<br> <label class="col-sm-2 control-label"></label> <input
						type="reset" value="Reset" name="reset" class="btn  btn-danger">
					&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
					<input type="Submit" value="Submit" name="submit"
						class="btn btn-success">

				</form>
			</div>
		</div>
	</div>
</body>
</html>