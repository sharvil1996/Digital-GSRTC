<%@page import="com.dsynhub.digitalgsrtc.bean.CityBean"%>
<%@page import="com.dsynhub.digitalgsrtc.dao.CityDAO"%>
<%@page import="com.dsynhub.digitalgsrtc.bean.BusCategoryBean"%>
<%@page import="com.dsynhub.digitalgsrtc.dao.BusCategoryDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.dsynhub.digitalgsrtc.dao.BusTypeDAO"%>
<%@page import="com.dsynhub.digitalgsrtc.bean.BusTypeBean"%>
<%@page import="com.dsynhub.digitalgsrtc.bean.BusBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin | Bus Update</title>

</head>
<body>
<%@ include file="adminHeader.jsp"%>
<div style="margin-top: -850px;margin-left: 250px;">
	<section class="content-header">
	<h1>
		Bus <small>Update</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="adminDashBoard.jsp"><i class="fa fa-dashboard"></i>
				Home</a></li>
		<li class="active">Bus</li>
	</ol>
	</section><br><br>
	<%	
		BusBean busBean = (BusBean) request.getAttribute("busBean");
		if (busBean != null) 
		{
	%>
	<div class="col-lg-6">
		<div class="container">
			<form action="BusUpdateServlet" method="post" name="Registration">
				<input type="hidden" name="busNo" value="<%=busBean.getBusNo()%>">
				<br />
				
				<div class="row">
					<label class="col-sm-2"> <font size="+1">Bus No :</font>
					</label>
					<div class="col-lg-6">
						<input type="text" class="form-control" name="txtBusNo"
							value="<%=busBean.getBusNo()%>" readonly="readonly" placeholder="Bus No"
							maxlength="15" /> 
					</div><font color="red">${busNo}</font>
				</div>
				<br />
				
				<div class="row">
					<label class="col-sm-2"> <font size="+1">Bus type :</font> </label>
					<div class="col-lg-6">
						<select name="selBusTypeName" id="txtbusdepo" class="form-control">
							<option value="0">Select Bus Type</option>
							<%
								BusTypeDAO busTypeDAO = new BusTypeDAO();
									List<BusTypeBean> busTypeList = busTypeDAO.list();

									for (int i = 0; i < busTypeList.size(); i++) {
										BusTypeBean busType = busTypeList.get(i);
										if (busType.getBusTypeId().equals(busBean.getBusTypeId())) {
							%>
							<option value="<%=busType.getBusTypeId()%>" selected="selected"><%=busType.getBusTypeName()%></option>
							<%
								} else {
							%>
							<option value="<%=busType.getBusTypeId()%>"><%=busType.getBusTypeName()%></option>
							<%
								}
									}
							%>
						</select>
					</div><font color="red" >${msgBusTypeName}</font>
				</div>
				<br />
				
				<div class="row">
					<label class="col-sm-2"> <font size="+1">Bus Category :</font> </label>
					<div class="col-lg-6">
						<select name="selBusCategoryName" id="txtbusdepo" class="form-control">
							<option value="0" selected="selected" class="form-control">Select
								Bus Category Name</option>
							<%
								BusCategoryDAO busCategoryDAO = new BusCategoryDAO();
									List<BusCategoryBean> busCategoryList = busCategoryDAO.list();

									for (int i = 0; i < busCategoryList.size(); i++) {
										BusCategoryBean busCategory = busCategoryList.get(i);
										if (busCategory.getBusCategoryId().equals(
												busBean.getBusCategoryId())) {
							%>
							<option value="<%=busCategory.getBusCategoryId()%>"
								selected="selected"><%=busCategory.getBusCategoryName()%></option>
							<%
								} else {
							%>
							<option value="<%=busCategory.getBusCategoryId()%>"><%=busCategory.getBusCategoryName()%></option>
							<%
								}
									}
							%>
						</select>
					</div><font color="red" >${msgBusCategoryName}</font>
				</div>
				<br />
				
				<div class="row">
					<label class="col-sm-2"> <font size="+1">Capacity :</font>
					</label>
					<div class="col-lg-6">
						<input type="number" min="30" max="55" class="form-control" name="numCapacity"
							value="<%=busBean.getCapacity()%>" placeholder="Enter Capacity"
							maxlength="15" /> 
					</div><font color="red">${capacity}</font>
				</div>
				<br />
				
				<div class="row">
					<label class="col-sm-2"> <font size="+1">Bus Depo: :</font> </label>
					<div class="col-lg-6">
						<select name="selDepoName" id="txtbusdepo" class="form-control">
							<option value="0">Select Depo</option>
							<%
								CityDAO cityDAO = new CityDAO();
									List<CityBean> cityList = cityDAO.list();

									for (int i = 0; i < cityList.size(); i++) {
										CityBean city = cityList.get(i);
										if (city.getCityId().equals(busBean.getBusDepoId())) {
							%>
							<option value="<%=city.getCityId()%>" selected="selected"><%=city.getCityName()%></option>
							<%
								} else {
							%>
							<option value="<%=city.getCityId()%>"><%=city.getCityName()%></option>
							<%
								}
								}
							%>
						</select>
					</div><font color="red" >${city}</font>
				</div>
				<br />
				
				<div class="row">
						<label class="col-sm-3"><font size="+1">Is Available : </font>
						</label>
						<div class="col-md-7">
							<div class="col-sm-6">
								<input type="radio" name="rdoAvalibility" value="y" checked="checked" /> <font>Yes</font>
							</div>
							<div class="col-sm-6">
								<input type="radio" name="rdoAvalibility" value="n"  /> <font>No</font>
							</div>
						</div>
				</div>
				<br />
				
				<br />
				
					<label class="col-sm-2 control-label"></label>
					<input type="reset" value="Reset" name="reset"
						class="btn  btn-danger" />
					&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
					<input type="submit" value="Submit" name="submit"
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





