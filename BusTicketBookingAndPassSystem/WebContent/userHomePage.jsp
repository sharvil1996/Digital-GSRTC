<%@page import="com.dsynhub.digitalgsrtc.dao.StationDAO"%>
<%@page import="com.dsynhub.digitalgsrtc.bean.StationBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//gujjuC//DTD XHTML 1.0 Transitional//EN" "http://www.gujju.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<script type="text/javascript" src="DigitalGSRTC-javaScript/mainscript.js"></script>
<title>Digitalgsrtc.In</title>
<style>
input {
	text-transform: capitalize;
}
</style>
<link rel="icon" href="DigitalGSRTC-photos/logo.ico" />
</head>
<body>
	<%@ include file="userHeader.jsp"%>
	<% String hello = (String)request.getAttribute("msgFeedback"); 
	System.out.print(hello);
	%>

		${msgUser} ${msgReservation} ${msgFeedback}
		<%!List<StationBean> stationBeansList;%>
		<br /> <br />
		<form action="UserScheduleListServlet" method="post">
			<div class="gujju-container " style="margin-left: 320px;">
				<div class=" gujju-col m9 gujju-card-8"
					style="margin-left: 30px; text-align: center;">
					<div class="row">

						<h3 style="text-align: center;">
							Search Bus Here <i class="fa-search fa" style="color: #0099FF"></i>
						</h3>
						<br />
						<div class="col-lg-13">
							<label class="col-lg-3">From :</label>
							<div class="col-md-7">
							<input list="Source" name="selSourceName" maxlength="20"
									placeholder="Source" class="form-control" autocomplete="off"
									value="${sourceName}" />
							<datalist id="Source"> <%
 								stationBeansList = new StationDAO().list();
 								for (int i = 0; i < stationBeansList.size(); i++) {

							 		String tmp = "unselected";
 									String type = request.getParameter("selSourceName");
 									if (type == null)
 										tmp = "unselected";
 									else if (stationBeansList.get(i).getStationId().equals(type))
 										tmp = "selected";
 								%>
								<option value="<%=stationBeansList.get(i).getStationName()%>"></option>
								 <%
 								}
 								%> 
 							</datalist>
								<font color="red"> ${msgSourceName}</font>
							</div>
						</div>
						<br /> <br />
						<div class="col-lg-13">
							<label class="col-lg-3">To :</label>
							<div class="col-md-7">
								<input list="Destination" placeholder="Destination"
									name="selDestinationName" maxlength="20" class="form-control"
									autocomplete="off" value="${DestinationName}" />
								<datalist id="Destination"> <%
 									stationBeansList = new StationDAO().list();
	
									 	for (int i = 0; i < stationBeansList.size(); i++) {

 											String tmp = "unselected";
 											String type = request.getParameter("selDestinationName");
 											if (type == null)
 												tmp = "unselected";
 											else if (stationBeansList.get(i).getStationId().equals(type))
								 				tmp = "selected";
											 %>


											<option value="<%=stationBeansList.get(i).getStationName()%>"></option>
											<%
 										}
 									%> 
 								</datalist>
								<font color="red"> ${msgDestinationName}</font>
							</div>

							<br /> <br />
						</div>
						<br />
						<div class="gujju-col m7">
							<button type="submit"
								class="fa-search fa   gujju-btn gujju-theme"
								style="margin-left: 180px;">&emsp;Search Bus</button>
							<br /> <br />
						</div>
					</div>
				</div>


			</div>
		</form>
			<%@ include file="userFooter.jsp"%>
		
</body>
</html>
