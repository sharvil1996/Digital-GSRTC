<%@page import="com.dsynhub.digitalgsrtc.bean.UserBean"%>
<%@page import="java.util.List"%>
<%@page import="com.dsynhub.digitalgsrtc.dao.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User | Feedback Insert</title>

</head>
<body>
<%@ include file="adminHeader.jsp"%>
<div style="margin-top: -850px;margin-left: 250px;">
	<section class="content-header">
	<h1>
		Feedback <small>Insert</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="userHeader.jsp"><i class="fa fa-dashboard"></i>
				Home</a></li>
		<li class="active">Feedback</li>
	</ol>
	</section><br><br>
	<div class="col-lg-6">
		<br />
		<div class="container">
			<form action="FeedbackInsertServlet" method="post">
				<div class="row">
					<div class="col-lg-10">
						<label class="col-sm-2"><font size="+1">User Name : </font> </label>
						<div class="col-lg-6">
						<select name="selUserName" id="selUserName" class="form-control">
							<option value="0" selected="selected">Select User</option>
							<%
								UserDAO userDAO = new UserDAO();
											List<UserBean> userList = userDAO.list();
											
											for(int i=0;i<userList.size();i++)
											{
								
												String tmp="unselected";
												String type=request.getParameter("selUserName");
												if(type==null)
													tmp="unselected";
												else if(userList.get(i).getUserId().equals(type))
													tmp="selected";
							%>

							<option value=<%=userList.get(i).getUserId()%> <%=tmp%>>
								<%=userList.get(i).getFirstName()+" "+userList.get(i).getLastName()%></option>
							<%
								}
							%>
						</select>
					</div>
					<font color="red">${userName}</font><br>
				</div>
				</div>
				<br/>
				<div class="row">
					<div class="col-lg-10">
						<label class="col-sm-2"><font size="+1">Feedback : </font> </label>
						<div class="col-lg-6">
							<textarea rows="3" class="form-control" cols="18" name="txtFeedback">${txtFeedback}</textarea>
						</div><font color="red">${feedback}</font>
					</div>	
				</div>
				<br/>
				<br/>
				<br/>
				<br />
				
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