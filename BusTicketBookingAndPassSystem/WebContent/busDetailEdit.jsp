<%@page import="com.dsynhub.digitalgsrtc.bean.BusDetailBean"%>
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
<title>Admin | BusDetail Update</title>

</head>
<body>
<%@ include file="adminHeader.jsp"%>
<div style="margin-top: -850px;margin-left: 250px;">
	<section class="content-header">
	<h1>
		Bus Detail <small>Update</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="adminDashBoard.jsp"><i class="fa fa-dashboard"></i>
				Home</a></li>
		<li class="active">BusDetail</li>
	</ol>
	</section><br><br>
	<%
		BusDetailBean busDetailBean=(BusDetailBean) request.getAttribute("busDetailBean");
		if(busDetailBean!=null)
		{
	%>
	<div class="col-lg-6">
		<br />
		<div class="container">
			<form action="BusDetailUpdateServlet" method="post">
				<input type="hidden" name="busDetailId" id="busDetailId"
			value="<%= request.getParameter("busDetailId")%>">
				<div class="row">
					<div class="col-lg-10">
						<label class="col-sm-2"><font size="+1">Bus No :
						</font> </label>
						<div class="col-lg-6">
							
							<input type="text" id="selBusNo" class="form-control"
							name="selBusNo" maxlength="30" placeholder="BusNo."
							value="<%= busDetailBean.getBusNo()%>" readonly="readonly" />
						</div><font color="red">${busCategoryName}</font>
					</div>
				</div>
				<br>

				<div class="row">
					<div class="col-lg-10">
						<label class="col-sm-2"><font size="+1">Route : </font> </label>
						<div class="col-lg-6">
							<select name="selRoute" id="selRoute" class="form-control">
						<option value="0">Select Route</option>
							<% 
							RouteDAO routeDAO = new RouteDAO();
							List<RouteBean> routeList = routeDAO.list();

							for (int i = 0; i < routeList.size(); i++) {

								String tmp = "unselected";
								String type = request.getParameter("selRoute");
								if (routeList.get(i).getRouteId().equals(busDetailBean.getRouteId()))
								{
									tmp = "selected";
						%>

						<option value=<%=routeList.get(i).getRouteId()%> <%=tmp%>>
							<%=routeList.get(i).getSourceName()+"-"+routeList.get(i).getDestinationName()%></option>
						<%
								}
						else
						{
							%>

						<option value=<%=routeList.get(i).getRouteId()%>>
							<%=routeList.get(i).getSourceName()+"-"+routeList.get(i).getDestinationName()%></option>
						<%	
						}
							}
						%>
						</select>
						</div><font color="red">${route}</font>
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
 
