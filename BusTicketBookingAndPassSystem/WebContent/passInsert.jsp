<%@page import="com.dsynhub.digitalgsrtc.bean.OrganizationBean"%>
<%@page import="com.dsynhub.digitalgsrtc.dao.OrganizationDAO"%>
<%@page import="com.dsynhub.digitalgsrtc.bean.PassTypeBean"%>
<%@page import="com.dsynhub.digitalgsrtc.dao.PassTypeDAO"%>
<%@page import="com.dsynhub.digitalgsrtc.bean.StationBean"%>
<%@page import="com.dsynhub.digitalgsrtc.dao.StationDAO"%>
<%@page import="com.dsynhub.digitalgsrtc.bean.RouteBean"%>
<%@page import="com.dsynhub.digitalgsrtc.dao.RouteDAO"%>
<%@page import="com.dsynhub.digitalgsrtc.bean.UserBean"%>
<%@page import="com.dsynhub.digitalgsrtc.dao.UserDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin | Pass Insert</title>

</head>
<body>
<%@ include file="adminHeader.jsp"%>
<div style="margin-top: -850px;margin-left: 250px;">
	<section class="content-header">
	<h1>
		Pass <small>Insert</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="adminDashBoard.jsp"><i class="fa fa-dashboard"></i>
				Home</a></li>
		<li class="active">Pass</li>
	</ol>
	</section><br><br>
	<div class="col-lg-6">
		<br />
		<div class="container">
			<form action="PassInsertServlet" method="post" enctype="multipart/form-data">
					
				<div class="row">
					<div class="col-lg-10">
						<label class="col-sm-2"><font size="+1" >User Name : </font> </label>
						<div class="col-lg-6">
							<select name="selUserName" id="selUserName" class="form-control">
						<option value="0" selected="selected">Select User</option>
						<%
							UserDAO userDAO = new UserDAO();
							List<UserBean> userList = userDAO.list();

							for (int i = 0; i < userList.size(); i++) {
								String user = userList.get(i).getFirstName() + " "
										+ userList.get(i).getMiddleName() + " "
										+ userList.get(i).getLastName();
								String tmp = "unselected";
								String type = request.getParameter("selUserName");
								if (type == null)
									tmp = "unselected";
								else if (userList.get(i).getUserId().equals(type))
									tmp = "selected";
						%>

						<option value=<%=userList.get(i).getUserId()%> <%=tmp%>>
							<%=user%></option>
						<%
							}
						%>
				</select>
						</div><font color="red">${userName}</font>
					</div>
				</div>
				<br>			
				
				<div class="row">
					<div class="col-lg-10">
						<label class="col-sm-2"><font size="+1">Source :
						</font> </label>
						<div class="col-lg-6">
							<select name="selSourceName" id="selBusTypeName" class="form-control">
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
						</div><font color="red">${sourceName}</font>
					</div>
				</div>
				<br>

				<div class="row">
					<div class="col-lg-10">
						<label class="col-sm-2"><font size="+1" >Destination : </font> </label>
						<div class="col-lg-6">
							<select name="selDestinationName" id="selBusCategoryName" class="form-control">
						<option value="0" selected="selected">Select Destination</option>
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
						<option value=<%=destinationList.get(i).getStationId()%> <%=tmp%>>
							<%=destinationList.get(i).getStationName()%></option>
						<%
							}
						%>
				</select>
						</div><font color="red">${destinationId}</font>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-lg-10">
						<label class="col-sm-2"><font size="+1">Pass Type : </font> </label>
						<div class="col-lg-6">
							<%
						PassTypeDAO passTypeDAO = new PassTypeDAO();
						List<PassTypeBean> passTypeList = passTypeDAO.list();
					
						for (int i = 0; i < passTypeList.size(); i++) {
					%> &emsp;<input type="radio" name="rdoPassType"
					value=<%=passTypeList.get(i).getPassTypeId()%> checked="checked">&emsp; <%=passTypeList.get(i).getPassTypeName()%>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</option>
					<%
						}
					%> 
						</div><font color="red">${passType}</font>
					</div>
				</div>
				<br />

				<div class="row">
					<div class="col-lg-10">
						<label class="col-sm-2"><font size="+1">Validity : </font> </label>
						<div class="col-lg-6">
							<%
						String one = "", three = "", six = "", gen = request
								.getParameter("rdoValidity");
						if (gen != null) {
							if (gen.equals("1"))
								one = "checked";
							else if (gen.equals("3"))
								three = "checked";
							else
								six = "checked";

						}
					%>&emsp; 
					<input type="radio" name="rdoValidity" value="1" checked="checked">&nbsp;1 Months &emsp;&emsp;&emsp;&emsp;&emsp;
					<input type="radio" name="rdoValidity" value="3" <%=three%>>&nbsp;3 Months &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
					<input type="radio" name="rdoValidity" value="6" <%=six%>>&nbsp;6 Months &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
						</div><font color="red">${validity}</font>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-10">
						<label class="col-sm-2"><font size="+1" >Organization : </font> </label>
						<div class="col-lg-6">
							<select name="selOrganization" id="selOrganization" class="form-control">
						<option value="0" selected="selected">Select Organization</option>
						<%
							OrganizationDAO organizationDAO = new OrganizationDAO();
							List<OrganizationBean> organizationList = organizationDAO.list();

							for (int i = 0; i < organizationList.size(); i++) {
								String tmp = "unselected";
								String type = request.getParameter("selOrganization");
								if (type == null)
									tmp = "unselected";
								else if (organizationList.get(i).getOrgId().equals(type))
									tmp = "selected";
						%>
						<option value=<%=organizationList.get(i).getOrgId()%> <%=tmp%>>
							<%=organizationList.get(i).getOrgName()%></option>
						<%
							}
						%>
				</select>
						</div><font color="red">${organization}</font>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-lg-10">
						<label class="col-sm-2"><font size="+1" >PassPort Size Photo : </font> </label>
						<div class="col-lg-6">
							<input type="file" name="photo"> 
						</div><font color="red">${file}</font>
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


