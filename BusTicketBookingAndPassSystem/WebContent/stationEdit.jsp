<%@page import="com.dsynhub.digitalgsrtc.bean.CityBean"%>
<%@page import="java.util.List"%>
<%@page import="com.dsynhub.digitalgsrtc.dao.CityDAO"%>
<%@page import="com.dsynhub.digitalgsrtc.bean.StationBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin | Station Update</title>

</head>
<body>
<%@ include file="adminHeader.jsp"%>
<div style="margin-top: -850px;margin-left: 250px;">
	<section class="content-header">
	<h1>
		Station <small>Update</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="adminDashBoard.jsp"><i class="fa fa-dashboard"></i>
				Home</a></li>
		<li class="active">Station</li>
	</ol>
	</section><br><br>
	<%
		StationBean stationBean = (StationBean) request
				.getAttribute("stationBean");
		if (stationBean != null) {
	%>
	<div class="col-lg-6">
		<div class="container">
			<form action="StationUpdateServlet" method="post" name="Registration">
				<input type="hidden" name="stationId" id="stationId" value="<%=stationBean.getStationId()%>">
				<br />
				<div class="row">
					<label class="col-sm-2"> <font size="+1">Name :</font> </label>
					<div class="col-lg-6">
						<input type="text" class="form-control" name="txtStationName"
							placeholder="Enter Station name" maxlength="30"
							value="<%=stationBean.getStationName()%>" />
					</div> <font color="red">${stationName}</font>
				</div>
				<br />
				
				<div class="row">
					<label class="col-sm-2"> <font size="+1">City Name :</font> </label>
					<div class="col-lg-6">
						<select name="selCityName" id="txtbusdepo" class="form-control">
							<option value="0">Select city</option>

								<%
									StationBean station = (StationBean)request.getAttribute("stationBean");					
											CityDAO cityDAO = new CityDAO();
											
											List<CityBean> cityList = cityDAO.list();
											
											for(int i=0;i<cityList.size();i++){
												CityBean city = cityList.get(i);
												
												
												if(city.getCityId().equals(station.getCityId()))
												{
								%>
								<option value="<%=city.getCityId()%>" selected="selected"><%=city.getCityName()%></option>
								<%
									}		
												else
												{
								%>
								<option value="<%=city.getCityId()%>"><%=city.getCityName()%></option>
								<%
									}
											}
								%>

						</select>
					</div><font color="red" ><b>${msgCityName}</b></font>
				</div>
				<br />
				
				<br />
				
					<label class="col-sm-2 control-label"></label>
					<input type="reset" value="Reset" name="reset"
						class="btn  btn-danger" />
					&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
					<input type="submit" value="Ragister" name="submit"
						class="btn btn-success" />
					
			</form>
		</div>
	</div>
<%}else{%>
<center><font color="red" size="+1"><br><br><br><br><br><br><br><b>No Data Found.....</b></font></center>> 
<%} %>
</div>
</body>
</html>

