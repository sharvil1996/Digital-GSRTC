<%@page import="com.dsynhub.digitalgsrtc.bean.CityBean"%>
<%@page import="com.dsynhub.digitalgsrtc.dao.CityDAO"%>
<%@page import="com.dsynhub.digitalgsrtc.bean.UserBean"%>
<%@page import="java.util.List"%>
<%@page import="com.dsynhub.digitalgsrtc.dao.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin | Station Insert</title>
<link rel="icon" href="DigitalGSRTC-photos/logo.ico" />
<script type="text/javascript" src="DigitalGSRTC-javaScript/mainscript.js"></script>
</head>
<body>
<%@ include file="adminHeader.jsp"%>
<div style="margin-top: -850px;margin-left: 250px;">
	<section class="content-header">
	<h1>
		Station <small>Insert</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="adminDashBoard.jsp"><i class="fa fa-dashboard"></i>
				Home</a></li>
		<li class="active">Station</li>
	</ol>
	</section><br><br>
	<div class="col-lg-6">
		<br />
		<div class="container">
			<form action="StationInsertServlet" method="post">
				<div class="row">
					<div class="col-lg-10">
						<label class="col-sm-2"><font size="+1">Name : </font> </label>
						<div class="col-lg-6">
							<input type="text" size="30" maxlength="50" class="form-control"
								name="txtStationName" placeholder="Enter Station Name" value="${txtStationName}" oninput="space(this);onlytext(this); nodigit(this);"/>
						</div><font color="red">${stationName}</font><br>
					</div>
				</div>
				<br/>
				
				<div class="row">
					<div class="col-lg-10">
						<label class="col-sm-2"><font size="+1">City Name : </font> </label>
						<div class="col-lg-6">
							<select name="selCityName" id="selCityName" class="form-control">
					<option value="0" selected="selected">Select city</option>
					<%
							CityDAO cityDAO = new CityDAO();
							List<CityBean> cityList = cityDAO.list();
			
							for(int i=0;i<cityList.size();i++)
							{
									String tmp="unselected";
									String type=request.getParameter("selCityName");
									if(type==null)
											tmp="unselected";
									else if(cityList.get(i).getCityId().equals(type))
											tmp="selected";
								%>
								<option value=<%=cityList.get(i).getCityId()%> <%=tmp%>>
									<%=cityList.get(i).getCityName()%></option>
								<%
							}
								%>
					</select>
						</div><font color="red">${msgCityName}</font><br>
					</div>
				</div>
				<br/>
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