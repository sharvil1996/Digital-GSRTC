<%@page import="java.util.ArrayList"%>
<%@page import="com.dsynhub.digitalgsrtc.bean.FeedbackBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin | Feedback List</title>

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
		Feedback <small>List</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="adminDashBoard.jsp"><i class="fa fa-dashboard"></i>
				Home</a></li>
		<li class="active">Feedback</li>
	</ol><br><br>
	<!-- <a href="feedbackInsert.jsp"><input type="button" value="ADD" name="ADD"
						class="btn btn-primary"></a> --><br><br>
		<div class="row">
			<div class="col-xs-12">
				<div class="box">
					<div class="box-body">
						<table id="example1" class="table table-bordered table-hover table-striped">
						<%  
								ArrayList<FeedbackBean> listOfFeedback = (ArrayList) request.getAttribute("listOfFeedback");
				
								if(listOfFeedback!=null)
								{
						%>
							<thead class="gujju-theme text-uppercase">
								<tr>
									<th><center>User Name</center></th>
									<th><center>Feedback</center></th>
									<th><center>Action</center></th>
								</tr>
							</thead>
							

							<tbody>
							<%
						
							for(int i=0;i<listOfFeedback.size();i++)
							{
								FeedbackBean feedbackBean = listOfFeedback.get(i);
								
								%>
								<tr>
									<td><center><%=feedbackBean.getUserName()%></center></td>
									<td><center><%=feedbackBean.getFeedback()%></center></td>
									<td><center>
										<%-- <a href="FeedbackEditServlet?feedbackId=<%= feedbackBean.getFeedbackId()%>">
										<img src="DigitalGSRTC-photos/edit.ico" width="30" height="30" /></a>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										 --%><a href="FeedbackDeleteServlet?feedbackId=<%= feedbackBean.getFeedbackId()%>">
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

