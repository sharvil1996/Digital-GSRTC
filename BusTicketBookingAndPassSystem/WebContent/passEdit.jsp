<%@page import="com.dsynhub.digitalgsrtc.bean.PassBean"%>
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
<title>Admin | Pass Update</title>

</head>
<body>
<%@ include file="adminHeader.jsp"%>
<div style="margin-top: -850px;margin-left: 250px;">
	<section class="content-header">
	<h1>
		Pass <small>Update</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="adminDashBoard.jsp"><i class="fa fa-dashboard"></i>
				Home</a></li>
		<li class="active">Pass</li>
	</ol>
	</section><br><br>
	<%
	PassBean passBean = (PassBean) request.getAttribute("passBean");
	if (passBean != null) {
	%>
	<div class="col-lg-6">
		<div class="container">
			<form action="PassUpdateServlet" method="post" name="Registration" enctype="multipart/form-data">
				<input type="hidden" name="selUserName" id="selUserName" value=<%=passBean.getUserId()%>>
				<input type="hidden" name="selName" id="selName" value=<%=passBean.getFirstName()%>>
				<input type="hidden" name="passId" id="passId" value=<%=passBean.getPassId()%>>
				<br />
				
				
				<div class="row">
					<label class="col-sm-2"> <font size="+1">Source :</font> </label>
					<div class="col-lg-6">
						<select name="selSourceName" id="txtbusdepo" class="form-control">
							<option value="0" selected="selected">Select Source</option>
						<%
							StationDAO sourceDAO = new StationDAO();
								List<StationBean> sourceList = sourceDAO.list();

								for (int i = 0; i < sourceList.size(); i++) {
									String tmp = "unselected";
									String type = request.getParameter("selSourceName");
									
									if (sourceList.get(i).getStationId()
											.equals(passBean.getSourceId()))
										tmp = "selected";
									else
										tmp="";
						%>
						<option value=<%=sourceList.get(i).getStationId()%> <%=tmp%>>
							<%=sourceList.get(i).getStationName()%></option>
						<%
							}
						%>
						</select>
					</div><font color="red" >${sourceName}</font>
				</div>
				<br />
				
				<div class="row">
					<label class="col-sm-2"> <font size="+1">Destination :</font> </label>
					<div class="col-lg-6">
						<select name="selDestinationName" id="txtbusdepo" class="form-control">
							<option value="0" selected="selected">Select Destination</option>
						<%
							StationDAO destinationDAO = new StationDAO();
								List<StationBean> destinationList = destinationDAO.list();

								for (int i = 0; i < destinationList.size(); i++) {
									String tmp = "unselected";
									String type = request.getParameter("selDestinationName");
									if (destinationList.get(i).getStationId()
											.equals(passBean.getDestinationId()))
										tmp = "selected";
									else
										tmp="";
						%>
						<option value=<%=destinationList.get(i).getStationId()%> <%=tmp%>>
							<%=destinationList.get(i).getStationName()%></option>
						<%
							}
						%>
						</select>
					</div><font color="red" >${destinationId}</font>
				</div>
				<br />
				
				<div class="row">
					<label class="col-sm-2"> <font size="+1">PassType :</font>
					</label>
					<div class="col-lg-6">
					<% 		PassTypeDAO passTypeDAO = new PassTypeDAO();
							List<PassTypeBean> passTypeList = passTypeDAO.list();

							for (int i = 0; i < passTypeList.size(); i++) {
								System.out.println(passTypeList.get(i).getPassTypeId()+"hissss"+passBean.getPassTypeId());
								if (passTypeList.get(i).getPassTypeId()
										.equals(passBean.getPassTypeId())) {
					%> <div class="col-sm-3">
					<input type="radio" name="rdoPassType" 
					value=<%=passTypeList.get(i).getPassTypeId()%> checked="checked"></div>
					<%=passTypeList.get(i).getPassTypeName()%> 
					<%
 						} else {
 					%>
 					<div class="col-sm-3">
 					 <input type="radio" name="rdoPassType"
					value=<%=passTypeList.get(i).getPassTypeId()%>> </div>
					<%=passTypeList.get(i).getPassTypeName()%>
					<%
						}
							}
					%> 
					</div><font color="red">${passType}</font>
				</div>
				<br />
				
				<div class="row">
					<label class="col-sm-2"> <font size="+1">Validity :</font> </label>
					<div class="col-lg-6">
					
							<%
						String one = "", three = "", six = "";
								if (passBean.getValidity().equals("1"))
									one = "checked";
								else if (passBean.getValidity().equals("3"))
									three = "checked";
								else
									six = "checked";

					%> 
					<div class="col-sm-3">
						<input type="radio" name="rdoValidity" value="1" checked="checked" />1 Months 
					</div>
					<div class="col-sm-3">
						<input type="radio" name="rdoValidity" value="3" <%=three%> />3 Months
					</div>
					<div class="col-sm-3">
						<input type="radio" name="rdoValidity" value="6" <%=six%> />6 Months
					</div>
					</div><font color="red" >${validity}</font>
				</div>
				<br />
				
				<div class="row">
					<label class="col-sm-2"> <font size="+1">Organization :</font> </label>
					<div class="col-lg-6">
						<select name="selOrganization" id="txtbusdepo" class="form-control">
							<option value="0" selected="selected">Select Organization</option>
						<%
							OrganizationDAO organizationDAO = new OrganizationDAO();
								List<OrganizationBean> organizationList = organizationDAO
										.list();

								for (int i = 0; i < organizationList.size(); i++) {
									String tmp = "unselected";
									String type = request.getParameter("selOrganization");
									if (organizationList.get(i).getOrgId()
											.equals(passBean.getOrgId()))
										tmp = "selected";
									else
										tmp="";
						%>
						<option value=<%=organizationList.get(i).getOrgId()%> <%=tmp%>>
							<%=organizationList.get(i).getOrgName()%></option>
						<%
							}
						%>
				</select> 
					</div><font color="red" >${organization}</font>
				</div>
				<br />
				
				<div class="row">
					<label class="col-sm-2"> <font size="+1">Image :</font> </label>
					<div class="col-lg-6">
						<input type="file" name="photo" value=<%=passBean.getPhoto()%>> 
					</div><font color="red" >${file}</font>
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

