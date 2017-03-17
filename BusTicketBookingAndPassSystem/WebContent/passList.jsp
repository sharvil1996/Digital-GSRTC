<%@page import="com.dsynhub.digitalgsrtc.bean.PassBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin | PassList List</title>

<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<link rel="icon" href="DigitalGSRTC-photos/logo.ico" />
<style>
td,tr,th
{text-transform: uppercase;}
</style>
</head>
<body>
<%@include file="adminHeader.jsp"%>
<div style="margin-top: -850px;margin-left: 250px;">	
	<section class="content content-header">
	<h1>
		Pass List <small>List</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="adminDashBoard.jsp"><i class="fa fa-dashboard"></i>
				Home</a></li>
		<li class="active">PassList</li>
	</ol><br><br>
	<a href="passInsert.jsp"><input type="button" value="ADD" name="ADD"
						class="btn btn-primary"></a><br><br>
		<div class="row">
			<div class="col-xs-12">
				<div class="box">
					<div class="box-body">
						<table id="example1" class="table table-bordered table-hover table-striped">
						<%
								ArrayList<PassBean> listOfPass = (ArrayList) request.getAttribute("listofPass");
								if (listOfPass != null){
						%>
							<thead class="gujju-theme text-uppercase">
								<tr>
									<th align="center">Full Name</th>
									<th align="center">Email</th>
									<th align="center">Pass Type</th>
									<th align="center">Route</th>
									<th align="center">Date</th>
									<th align="center">Amount</th>
									<th align="center">Is Active</th>
									<th align="center">Action</th>
								</tr>
							</thead>
							

							<tbody>
							<%
									for (int i = 0; i < listOfPass.size(); i++) 
									{
											PassBean passBean = listOfPass.get(i);
											String amount=(Integer.parseInt(passBean.getValidity()) * 300)+"";
							%>
								<tr>
									<td align="center"><%=passBean.getFirstName() + " " 
														+ passBean.getMiddleName() + " "
														+ passBean.getLastName()%></td>
									<td align="center"><%=passBean.getEmail()%></td>
									<td align="center"><%=passBean.getPassType()%></td>
									<td align="center"><%=passBean.getSource()+ " - "
															+ passBean.getDestination()%></td>
									<td align="center"><%=passBean.getStartTermDate() + " TO "
														    + passBean.getEndTermDate()%></td>
									<td align="center"><%=amount%></td>
									<% if(passBean.getIsActive().equals("n")){ %>
										<td align="center"><img src="DigitalGSRTC-photos/no1.jpg" height="30" width="30" class="img-rounded"/></td>
									<%}else{ %>
										<td align="center"><img src="DigitalGSRTC-photos/yes1.jpg" height="30" width="30" class="img-rounded"/></td>
									<%} %>
									<td><center>
										<a href="PassEditServlet?passId=<%=passBean.getPassId()%>">
										<img src="DigitalGSRTC-photos/edit.ico" width="30" height="30" /></a>
										
										<a href="PassDeleteServlet?passId=<%=passBean.getPassId()%>">
										<img src="DigitalGSRTC-photos/Recycle Bin.ico" height="30" width="30" /> </a>
									</center></td>

								</tr>
								
							<%
								}
								}

							else {
							%>

							<h1><center>No Record Found....!</center></h1>
							<%
									}
							%>
								
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</section>				
</div>
</body>
</html>



