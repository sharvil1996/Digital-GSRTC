<%@page import="java.util.List"%>
<%@page import="com.dsynhub.digitalgsrtc.bean.UserBean"%>
<%@page import="com.dsynhub.digitalgsrtc.dao.UserDAO"%>
<%@page import="com.dsynhub.digitalgsrtc.bean.FeedbackBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin | Feedback Update</title>
<link rel="icon" href="DigitalGSRTC-photos/logo.ico" />
</head>
<body>
<%@ include file="adminHeader.jsp"%>
<div style="margin-top: -850px;margin-left: 250px;">
	<section class="content-header">
	<h1>
		Feedback <small>Update</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="adminDashBoard.jsp"><i class="fa fa-dashboard"></i>
				Home</a></li>
		<li class="active">Feedback</li>
	</ol>
	</section><br><br>
	<%	
		FeedbackBean feedbackBean = (FeedbackBean)request.getAttribute("feedbackBean");	
		if (feedbackBean != null) 
		{
	%>
	<div class="col-lg-6">
		<div class="container">
			<form action="FeedbackUpdateServlet" method="post" name="Registration">
				<input type="hidden" name="feedbackId" value="<%=request.getParameter("feedbackId")%>">
				<br />
				
				<div class="row">
					<label class="col-sm-2"> <font size="+1">User :</font> </label>
					<div class="col-lg-6">
						<select name="selUserName" id="txtbusdepo" class="form-control">
							<option value="0" selected="selected">Select User</option>
					<% 
							
					
						UserDAO userDAO = new UserDAO();
						
						List<UserBean> userList = userDAO.list();
						
						for(int i=0;i<userList.size();i++)
						{
							UserBean userBean = userList.get(i);
							if(userBean.getUserId().equals(feedbackBean.getUserId()))
							{
							%>
								<option value="<%=userBean.getUserId()%>" selected="selected"><%=userBean.getFirstName()+" "+userBean.getLastName()%></option>
							<%
							}		
							else
							{
					 			%>
						 			<option value="<%=userBean.getUserId()%>"><%=userBean.getFirstName()+" "+userBean.getLastName()%></option>
								<%
							}
						}
					%>	
					</select>
					</div><font color="red" >${cityName}</font>
				</div>
				<br />
				
				<div class="row">
					<label class="col-sm-2"> <font size="+1">Feedback :</font> </label>
					<div class="col-lg-6">
						<textarea maxlength="255" rows="3" class="form-control" cols="18" name="txtFeedback">${feedbackBean.getFeedback()}</textarea>
						<font color="red">${feedback}</font>
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





