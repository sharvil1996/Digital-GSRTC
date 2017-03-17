<%@page import="java.util.Date"%>
<%@page import="com.dsynhub.digitalgsrtc.bean.PassBean"%>
<%@page import="com.dsynhub.digitalgsrtc.bean.UserBean"%>
<%@page import="com.dsynhub.digitalgsrtc.bean.OrganizationBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PassDetail Detail List</title>
<link rel="icon" href="DigitalGSRTC-photos/logo.ico" /></head>
<body class="col-*-*">
<%@include file="userHeader.jsp"%>
		<div class="container">
			<div class="row">
				<div class="col-lg-10">
					<%
					
					PassBean passBean = (PassBean)request.getAttribute("passBean");
					UserBean userBean=(UserBean)session.getAttribute("userBean");
					if (passBean != null)
				%>
					<form>
						<a href="UserPassConfirmServlet" formtarget="_blank" class="gujju-green gujju-btn"><i  style="font-size: 30px;"></i>Confirm</a>
						<table class="table-hover table gujju-card-4">
							<tbody>
								 <tr>
									<td>Photo : <img alt="photo not found"
										src="<%="upload/pass/"+passBean.getPhoto()%>"
										height="150" width="150"></td>
</tr> 						<%session.setAttribute("passBean", passBean);%>
									<tr>
									<td>First Name : <%=passBean.getFirstName()%></td>
									</tr>
								<tr>
									<td>Middle Name : <%=passBean.getMiddleName()%></td>
								<tr>
									<td>Last Name : <%=passBean.getLastName()%></td>
								<tr>
									<td>Email : <%=passBean.getEmail()%></td>
								</tr>
								<tr>
									<td>Source : <%= passBean.getSource()%></td>
								</tr>
								<tr>
									<td>Destination : <%= passBean.getDestination()%>
									</td>		
								</tr>
									<tr>
									<td>Start Date : <%=new Date().toString().substring(0, 10)+" 2015"%>
									</td>
									
							
								</tr>
							
									<tr>
									<td>Pass Validity : <%=passBean.getValidity()+" months"%></td>
								</tr>
								<tr>
								<tr>
									<td>Amount : <%=(Integer.parseInt(passBean.getValidity())*300)%> Rs.</td>
								</tr>
								<tr>
									<td>Organization : <%=passBean.getOrganizationName()%>
									</td>
								</tr>
								<tr>
									<td>Organization Address : <%=passBean.getOrganizationAddress()%>
									</td>
								</tr>
							</tbody>
						</table>
					</form>
				</div>
			</div>
		</div>


<script >
$(document).ready(function() {
$("#addorg").show(300);
			$("#showorg").hide();
			
			$("#addorg").click(function(){
				$("#orglist").hide(300);
				$("#showorg").toggle(300);
			
			});
			});
			</script>
</body>
</html>