<%@page import="com.dsynhub.digitalgsrtc.bean.BusCategoryBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin | BusCategory Insert</title>
<script type="text/javascript" src="DigitalGSRTC-javaScript/mainscript.js"></script>
</head>
<body>
<%@ include file="adminHeader.jsp"%>
<div style="margin-top: -850px;margin-left: 250px;">
	<section class="content-header">
	<h1>
		Bus Category <small>Insert</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="adminDashBoard.jsp"><i class="fa fa-dashboard"></i>
				Home</a></li>
		<li class="active">BusCategory</li>
	</ol>
	</section><br><br>
	<div class="col-lg-4"><br><br>
		<form action="BusCategoryInsertServlet" method="post">
			<div class="container">
				<div class="row">
					<label class="col-md-2"> <font size="+1" pointsize="5">&emsp;
							Bus Category : </font>
					</label>
					<div class="col-md-5">
						<input type="text" size="30" maxlength="7"
							placeholder="Bus Category name" name="txtBusCategoryName"
							class="form-control" oninput="space(this);onlytext(this); nodigit(this);">
					</div>
					<font color="red" size="+1"><b>${busCategoryName}</b></font> <br /> <br /><br><br>
					
					<label class="col-sm-2 control-label"></label>
					<input type="reset" value="Reset" name="reset"
						class="btn  btn-danger">
					&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
					<input type="Submit" value="Submit" name="submit"
						class="btn btn-success">
			
				</div>
			</div>
		</form>
	</div>
</div>	
</body>
</html>

