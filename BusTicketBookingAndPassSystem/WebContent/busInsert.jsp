<%@page import="com.dsynhub.digitalgsrtc.bean.CityBean"%>
<%@page import="com.dsynhub.digitalgsrtc.dao.CityDAO"%>
<%@page import="com.dsynhub.digitalgsrtc.dao.BusCategoryDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.dsynhub.digitalgsrtc.dao.BusTypeDAO"%>
<%@page import="com.dsynhub.digitalgsrtc.bean.BusCategoryBean"%>
<%@page import="com.dsynhub.digitalgsrtc.bean.BusTypeBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin | Bus Insert</title>

</head>
<body>
<%@ include file="adminHeader.jsp"%>
<div style="margin-top: -850px;margin-left: 250px;">
	<section class="content-header">
	<h1>
		Bus <small>Insert</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="adminDashBoard.jsp"><i class="fa fa-dashboard"></i>
				Home</a></li>
		<li class="active">Bus</li>
	</ol>
	</section><br><br>
	<div class="col-lg-6">
		<br />
		<div class="container">
			<form action="BusInsertServlet" method="post">
				<div class="row">
					<div class="col-lg-10">
						<label class="col-sm-2"><font size="+1">Bus No
								: </font> </label>
						<div class="col-lg-6">
							<input type="text" name="txtBusNo" placeholder="Bus Number"
								maxlength="12" value="${txtBusNo}" id="txtbusNo"
								class="form-control" style="text-transform: uppercase;" /></input> 
						</div><font color="red">${busNo}</font>
					</div>
				</div>
				<br>
				
				<div class="row">
					<div class="col-lg-10">
						<label class="col-sm-2"><font size="+1">Bus Type :
						</font> </label>
						<div class="col-lg-6">
							<select name="selBusTypeName" id="selBusTypeName" class="form-control">
								<option value="0" selected="selected">Select Bus Type</option>
								<%
									BusTypeDAO busTypeDAO = new BusTypeDAO();
													List<BusTypeBean> busTypeList = busTypeDAO.list();

													for (int i = 0; i < busTypeList.size(); i++) {

														String tmp = "unselected";
														String type = request.getParameter("selBusTypeName");
														if (type == null)
															tmp = "unselected";
														else if (busTypeList.get(i).getBusTypeId().equals(type))
															tmp = "selected";
								%>

								<option value=<%=busTypeList.get(i).getBusTypeId()%> <%=tmp%>>
									<%=busTypeList.get(i).getBusTypeName()%></option>
								<%
									}
								%>
							</select>
						</div><font color="red">${msgBusTypeName}</font>
					</div>
				</div>
				<br>

				<div class="row">
					<div class="col-lg-10">
						<label class="col-sm-2"><font size="+1" >Bus Category : </font> </label>
						<div class="col-lg-6">
							<select name="selBusCategoryName" id="selBusCategoryName" class="form-control">
						<option value="0" selected="selected">Select Bus Category
							Name</option>
						<%
							BusCategoryDAO busCategoryDAO = new BusCategoryDAO();
							List<BusCategoryBean> busCategoryList = busCategoryDAO.list();

							for (int i = 0; i < busTypeList.size(); i++) {

								String tmp = "unselected";
								String type = request.getParameter("selBusCategoryName");
								if (type == null)
									tmp = "unselected";
								else if (busCategoryList.get(i).getBusCategoryId().equals(type))
									tmp = "selected";
						%>

						<option value=<%=busCategoryList.get(i).getBusCategoryId()%>
							<%=tmp%>>
							<%=busCategoryList.get(i).getBusCategoryName()%></option>
						<%
							}
						%>
							</select>
						</div><font color="red">${msgBusCategoryName}</font>
					</div>
				</div>
				<br>
				<%-- <div class="row">
					<div class="col-lg-10">
						<label class="col-sm-2"><font size="+1">Capacity : </font> </label>
						<div class="col-lg-6">
							<input type="number" placeholder="Capacity of Bus"
								name="numCapacity" maxlength="3" min="30" max="56"
								value="${numCapacity}" class="form-control" /></input>
						</div><font color="red">${capacity}</font>
					</div>
				</div> 
				<br />
--%>
				<div class="row">
					<div class="col-lg-10">
						<label class="col-sm-2"><font size="+1">Bus Depo : </font> </label>
						<div class="col-lg-6">
							<select name="selDepoName" id="selDepoName" class="form-control">
						<option value="0" selected="selected">Select Bus Depo
							Name</option>
						<%
							CityDAO cityDAO = new CityDAO();
							List<CityBean> busCityList = cityDAO.list();

							for (int i = 0; i < busCityList.size(); i++) {

								String tmp = "unselected";
								String type = request.getParameter("selDepoName");
								if (type == null)
									tmp = "unselected";
								else if (busCityList.get(i).getCityId().equals(type))
									tmp = "selected";
						%>

						<option value=<%=busCityList.get(i).getCityId()%> <%=tmp%>>
							<%=busCityList.get(i).getCityName()%></option>
						<%
							}
						%>
							</select>
						</div><font color="red">${msgDepoName}</font>
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
</div>
</body>
</html>