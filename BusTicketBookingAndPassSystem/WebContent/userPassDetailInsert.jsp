<%@page import="java.util.List"%>
<%@page import="com.dsynhub.digitalgsrtc.dao.PassTypeDAO"%>
<%@page import="com.dsynhub.digitalgsrtc.dao.PassDAO"%>
<%@page import="com.dsynhub.digitalgsrtc.bean.PassTypeBean"%>
<%@page import="com.dsynhub.digitalgsrtc.dao.OrganizationDAO"%>
<%@page import="com.dsynhub.digitalgsrtc.bean.OrganizationBean"%>
<%@page import="com.dsynhub.digitalgsrtc.bean.UserBean"%>
<%@page import="com.dsynhub.digitalgsrtc.dao.UserDAO"%>
<%@page import="com.dsynhub.digitalgsrtc.dao.PassTypeDAO"%>
<%@page import="com.dsynhub.digitalgsrtc.dao.PassDAO"%>
<%@page import="com.dsynhub.digitalgsrtc.bean.PassTypeBean"%>
<%@page import="com.dsynhub.digitalgsrtc.bean.StationBean"%>
<%@page import="com.dsynhub.digitalgsrtc.dao.StationDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pass Insert</title>
<link rel="icon" href="DigitalGSRTC-photos/logo.ico" />
<style type="text/css">
input,select,option{
text-transform: capitalize;
}
</style>
</head>
<body class="col-*-*">

	<%@include file="userHeader.jsp"%>

	<%
		UserBean userBean=(UserBean)session.getAttribute("userBean");
	%>
	<form action="UserPassInsertServlet" method="post"
		enctype="multipart/form-data">
		<input type="hidden" name="selUserName" id="selUserName"
			value="<%=userBean.getUserId()%>">

		<div class="container">
			<div class="row">
				<div class="col-lg-10 text-info fa-user-plus fa"
					style="font-size: 30px;" align="center">
					&emsp;New Pass<br>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-lg-10">
					<label class="col-sm-4"><font size="+1"> Source</font> </label>
					<div class="col-lg-6">
						<select name="selSourceName" id="selSourceName"
							class="form-control" style="text-transform: capitalize;">
							<option value="0" selected="selected">select source</option>
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
						</select> ${sourceName}
					</div>
				</div>
			</div>
			<br /> <br>
			<div class="row">
				<div class="col-lg-10">
					<label class="col-sm-4"><font size="+1"> Destination
					</font> </label>
					<div class="col-lg-6">

						<select name="seldestination" id="txtbusdepo" class="form-control">

							<option value="0" selected="selected">Select Destination</option>

							<%
								StationDAO sourceDAO1 = new StationDAO();
														List<StationBean> sourceList1 = sourceDAO.list();

														for (int i = 0; i < sourceList1.size(); i++) {
															String tmp = "unselected";
															String type = request.getParameter("selSourceName");
															if (type == null)
																tmp = "unselected";
															else if (sourceList1.get(i).getStationId().equals(type))
																tmp = "selected";
							%>
							<option value=<%=sourceList1.get(i).getStationId()%> <%=tmp%>>
								<%=sourceList1.get(i).getStationName()%></option>
							<%
								}
							%>
						</select> ${destinationName}
					</div>
				</div>
			</div>
			<br />

			<div class="row">
				<div class="col-lg-10">
					<label class="col-sm-4"><font size="+1"> Pass Type </font>
					</label>
					<div class="col-lg-6">
						<%
							PassTypeDAO passTypeDAO = new PassTypeDAO();
										List<PassTypeBean> passTypeList = passTypeDAO.list();

										for (int i = 0; i < passTypeList.size(); i++) {
						%>
						<input type="radio" name="rdoPassType"
							value=<%=passTypeList.get(i).getPassTypeId()%> checked="checked">
						<%=passTypeList.get(i).getPassTypeName()%>
						<%
							}
						%>
						${passType}
					</div>
				</div>
			</div>
			<br />
			<div class="row">
				<div class="col-lg-10">
					<label class="col-sm-4"><font size="+1"> Pass
							Validity </font> </label>
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
						%>
						<input type="radio" name="rdoValidity" value="1" checked="checked">1
						Months <input type="radio" name="rdoValidity" value="3" <%=three%>>3
						Months <input type="radio" name="rdoValidity" value="6" <%=six%>>6
						Months ${validity}
					</div>
				</div>
			</div>
			<br />

			<div class="row">
				<div class="col-lg-10" id="orglist">
					<label class="col-sm-4"><font size="+1">
							Organization </font> </label>
					<div class="col-lg-6">
						<select name="selOrganization" class="form-control">
							<option value="0" selected="selected">
								Select organization
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
						</select> ${organization}
					</div>
				</div>
				<!-- <input type="button" id="addorg" class="btn-info  input-sm"
					value="Add Organization"> --> <br /> <br />
				<div id="showorg">
					<div class="row">
						<div class="col-lg-10">
							<label class="col-sm-4"><font size="+1">
									Organization Name </font> </label>
							<div class="col-lg-6">
								<input type="text" class="form-control" name="txtorg"
									value="${param.txtorg}"> ${msgorgname}
							</div>

						</div>
					</div>
					<br />
					<div class="row">
						<div class="col-lg-10">
							<label class="col-sm-4"><font size="+1">
									Organization Address</font> </label>
							<div class="col-lg-6">

								<textarea name="txtaddress" class="form-control"> ${param.txtaddress}</textarea>
								${msgorgadd}
							</div>
						</div>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-lg-10">
						<label class="col-sm-4"><font size="+1"> Passport
								Size photo</font> </label>
						<div class="col-lg-6">

							<input type="file" name="photo" value="${passBean.photo}">${file}
						</div>
					</div>
				</div>

				<br>

				<div class="col-lg-5">
					<input type="submit" class="gujju-btn gujju-theme " />
				</div>
				<div class="col-md-4">
					<input type="reset" class="gujju-btn gujju-green " value="Clear" />
				</div>
			</div>
		</div>
	</form>

	<script>
		$(document).ready(function() {

			$("#addorg").show(300);
			$("#showorg").hide();

			$("#addorg").click(function() {
				$("#orglist").hide(300);
				$("#showorg").toggle(300);
			});
		});
	</script>

	 <%@include file="userFooter.jsp"%> 
</body>
</html>