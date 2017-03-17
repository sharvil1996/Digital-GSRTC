<!DOCTYPE html>
<%-- <%@page import="com.designhub.fitnessplus.bean.AdminBean"%> --%>
<%@page import="com.dsynhub.digitalgsrtc.bean.AdminBean"%>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>BMS | Dashboard</title>
    
<noscript>
  <meta HTTP-EQUIV="Refresh" CONTENT="0;URL=JavaScriptErrorPage.html" >
</noscript>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

	<link rel="stylesheet" href="AdminBootstrap/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="DigitalGSRTC-css/font-awesome.min.css">
    <link rel="stylesheet" href="DigitalGSRTC-css/ionicons.min.css">
    <link rel="stylesheet" href="AdminBootstrap/dist/css/AdminLTE.min.css">
    <link rel="stylesheet" href="AdminBootstrap/dist/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="AdminBootstrap/plugins/datatables/dataTables.bootstrap.css">


	<link rel="icon" href="DigitalGSRTC-photos/logo.ico" />
	 <script type="text/javascript">
function logoEffect()
{
	$("#img-rounded").css({"transition": "2s all","transform": "rotateY(360deg)"});
}

</script>
  </head>
  <body class="hold-transition skin-blue sidebar-mini fixed">
  <% 
	AdminBean adminBeanHeader = (AdminBean)session.getAttribute("adminBean");
  
  if(adminBeanHeader != null)
  {
  	
  %>
    <div class="wrapper">
      <header class="main-header">
        <a href="adminDashBoard.jsp" class="logo">
          <span class="logo-mini"><b></b>BMS</span>
          <span class="logo-lg"><b>Digital GSRTC</b></span>
        </a>
        <nav class="navbar navbar-static-top" role="navigation">
          <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button"></a>
          <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">              
              <li class="dropdown user user-menu">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                
                 <i
					class="fa-user fa"></i><font style="text-transform: uppercase;">${adminBean.firstName}&nbsp;${adminBean.lastName} </font> <b class="caret"></b>
			</a>
                <ul class="dropdown-menu" style="border-color: black;">                  
                  <li class="user-header">
                    <img src="AdminBootstrap/dist/img/admin.png" class="img-circle" alt="User Image">
                    <p>
                     <font style="text-transform: uppercase;">${adminBean.firstName}&nbsp;&nbsp;${adminBean.lastName} </font>
                    </p>
                  </li>
                  <li class="user-footer">
                    <div class="pull-left">
                      <a href="adminChangePassword.jsp" class="btn btn-default btn-flat">Change Password</a>
                    </div>
                   
                    <div class="pull-right">
                      <a href="AdminLogoutServlet" class="btn btn-default btn-flat">Sign out</a>
                    </div>
                  </li>
                </ul>
              </li>              
            </ul>
          </div>
        </nav>
      </header>
      <aside class="main-sidebar" style="min-height: 900px;">
        <section class="sidebar">
          <div class="user-panel">
            <div class="pull-left image">
              <img src="AdminBootstrap/dist/img/admin.png" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
              <p> <font style="text-transform: uppercase;">${adminBean.firstName} </font> </p>
              <a href=""><i class="fa fa-circle text-success"></i> Online</a>
            </div>
          </div>
          <ul class="sidebar-menu">
            <li class="header">MAIN NAVIGATION</li>
            <li class=" treeview">
              <a href="adminDashBoard.jsp">
                <i class="fa fa-dashboard"></i> <span>Dashboard</span> <!--<i class="fa fa-angle-left pull-right"></i>-->
              </a>          
            </li>
            
             <!-- -----------------------------------Management-------------------------------   -->
   			
   			<li class="treeview">
              <a href="AdminListServlet">
              <i class="fa fa-user-secret"></i>
                <span>Management</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
           
            <!-- -----------------------------------Management > user Mgt-------------------------------   -->
            
            <li class="treeview">
              <a href="UserListServlet">
              <i class="fa fa-user"></i>
                <span>User Management</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <li><a href="userInsert.jsp"><i class="fa fa-user-plus"></i> User Ragistration </a></li>
                <li><a href="UserListServlet"><i class="fa fa-users"></i> User List </a></li>
              </ul>
            </li>
   	
   			<!-- -----------------------------------Management > admin Mgt-------------------------------   -->
   
            <li class="treeview">
              <a href="AdminListServlet">
              <i class="fa fa-user-secret"></i>
                <span>Admin Management</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <li><a href="adminInsert.jsp"><i class="fa fa-user-plus"></i> Admin Ragistration </a></li>
                <li><a href="AdminListServlet"><i class="fa fa-users"></i> Admin List </a></li>
              </ul>
            </li>   
            
            <!-- -----------------------------------Management > bus Mgt-------------------------------   -->
                    
            <li class="treeview">
              <a href="BusListServlet">
                <i class="fa fa-bus"></i>
                <span>Bus Management</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
             <ul class="treeview-menu">
             	
             	<li class="treeview">
            	  <a href="BusListServlet">
                	<i class="fa fa-bus"></i>
                	<span>Bus</span>
                	<i class="fa fa-angle-left pull-right"></i>
             	 </a>
             	 <ul class="treeview-menu">
             		<li><a href="busInsert.jsp"><i class="fa fa-gg"></i> Bus Insert</a></li>
           		    <li><a href="BusListServlet"><i class="fa fa-gg"></i> Bus List</a></li>
            	 </ul>
            	</li>
             	
             	<li class="treeview">
            	  <a href="BusDetailListServlet">
                	<i class="fa fa-gear"></i>
                	<span>Bus Details</span>
                	<i class="fa fa-angle-left pull-right"></i>
             	 </a>
             	 <ul class="treeview-menu">
             		<li><a href="busDetailInsert.jsp"><i class="fa fa-gg"></i> Bus Detail Insert</a></li>
           		    <li><a href="BusDetailListServlet"><i class="fa fa-gg"></i> Bus Detail List</a></li>
            	 </ul>
            	</li>
            	
            	<li class="treeview">
            	  <a href="BusTypeListServlet">
                	<i class="fa fa-subway"></i>
                	<span>Bus Type</span>
                	<i class="fa fa-angle-left pull-right"></i>
             	 </a>
             	 <ul class="treeview-menu">
             		<li><a href="busTypeInsert.jsp"><i class="fa fa-gg"></i> Bus Detail Insert</a></li>
           		    <li><a href="BusTypeListServlet"><i class="fa fa-gg"></i> Bus Detail List</a></li>
            	 </ul>
            	</li>
             	
             	<li class="treeview">
            	  <a href="BusTypeListServlet">
                	<i class="fa fa-sitemap"></i>
                	<span>Bus Category</span>
                	<i class="fa fa-angle-left pull-right"></i>
             	 </a>
             	 <ul class="treeview-menu">
             		<li><a href="busCategoryInsert.jsp"><i class="fa fa-gg"></i> Bus Category Insert</a></li>
           		    <li><a href="BusCategoryListServlet"><i class="fa fa-gg"></i> Bus Category List</a></li>
            	 </ul>
            	</li>
             	                
              </ul>
            </li>
            
            <!-- -----------------------------------Management > bus Mgt-------------------------------   -->
            
             <li class="treeview">
              <a href="PassListServlet">
                <i class="fa fa-newspaper-o"></i>
                <span>Pass Management</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
             <ul class="treeview-menu">
             	
             	<li class="treeview">
            	  <a href="PassListServlet">
                	<i class="fa fa-newspaper-o"></i>
                	<span>Pass</span>
                	<i class="fa fa-angle-left pull-right"></i>
             	 </a>
             	 <ul class="treeview-menu">
             		<li><a href="passInsert.jsp"><i class="fa fa-gg"></i> Pass Insert</a></li>
           		    <li><a href="PassListServlet"><i class="fa fa-gg"></i> Pass List</a></li>
            	 </ul>
            	</li>
             	
             	<li class="treeview">
            	  <a href="BusDetailListServlet">
                	<i class="fa fa-gear"></i>
                	<span>Pass Type</span>
                	<i class="fa fa-angle-left pull-right"></i>
             	 </a>
             	 <ul class="treeview-menu">
             		<li><a href="passTypeInsert.jsp"><i class="fa fa-gg"></i> Pass Type Insert</a></li>
           		    <li><a href="PassTypeListServlet"><i class="fa fa-gg"></i> Pass Type List</a></li>
            	 </ul>
            	</li>
            	      
              </ul>
            </li>
            
           </ul>
           </li>
        
             <!-- -----------------------------------Management close-------------------------------   -->
            
            
            <li class="treeview">
              <a href="">
                <i class="fa fa-ticket"></i> <span>Reservation</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <li><a href="adminSearch.jsp"><i class="fa fa-gg"></i> Reservation Insert</a></li>
                <li><a href="ReservationListServlet"><i class="fa fa-gg"></i> Reservation List</a></li>
              </ul>
            </li>
            
            <li class="treeview">
              <a href="CityListServlet">
                <i class="fa fa-map-marker"></i> <span>City</span>
                <i class="fa fa-angle-left pull-right"></i>           
			  </a>
              <ul class="treeview-menu">
                <li><a href="cityInsert.jsp"><i class="fa fa-gg"></i> City Insert</a></li>
                <li><a href="CityListServlet"><i class="fa fa-gg"></i> City List</a></li>
              </ul>
            </li>
            
             <li class="treeview">
              <a href="OrganizationListServlet">
                <i class="fa fa-group"></i> <span>Organization</span>
                <i class="fa fa-angle-left pull-right"></i>           
			  </a>
              <ul class="treeview-menu">
                <li><a href="organizationInsert.jsp"><i class="fa fa-gg"></i><span> Organization Insert</span></a></li>
                <li><a href="OrganizationListServlet"><i class="fa fa-gg"></i> Organization List</a></li>
              </ul>
            </li>
            
              
            
              <!-- <li class="treeview">
              <a href="SeatTypeListServlet">
                <i class="fa fa-server"></i> <span>Seat Type</span>
                <i class="fa fa-angle-left pull-right"></i>           
			  </a>
              <ul class="treeview-menu">
                <li><a href="seatTypeInsert.jsp"><i class="fa fa-gg"></i><span> Seat Type Insert</span></a></li>
                <li><a href="SeatTypeListServlet"><i class="fa fa-gg"></i> Seat Type List</a></li>
              </ul>
            </li> -->
            
              <li class="treeview">
              <a href="#">
                <i class="fa fa-list-alt"></i> <span>Schedule</span>
                <i class="fa fa-angle-left pull-right"></i>           
			  </a>
              <ul class="treeview-menu">
                <li><a href="schuduleDetailInsert.jsp"><i class="fa fa-gg"></i><span> Schedule Insert</span></a></li>
                <li><a href="ScheduleDetailListServlet"><i class="fa fa-gg"></i> Schedule List</a></li>
              </ul>
            </li>
            
             <li class="treeview">
              <a href="RouteListServlet">
                <i class="fa fa-road"></i> <span>Route</span>
                <i class="fa fa-angle-left pull-right"></i>           
			  </a>
              <ul class="treeview-menu">
                <li><a href="routeInsert.jsp"><i class="fa fa-gg"></i><span> Route Insert</span></a></li>
                <li><a href="RouteListServlet"><i class="fa fa-gg"></i> Route List</a></li>
              </ul>
            </li>
            
             <li class="treeview">
              <a href="StationListServlet">
                <i class="fa fa-bank"></i> <span>Station</span>
                <i class="fa fa-angle-left pull-right"></i>           
			  </a>
              <ul class="treeview-menu">
                <li><a href="stationInsert.jsp"><i class="fa fa-gg"></i><span> Station Insert</span></a></li>
                <li><a href="StationListServlet"><i class="fa fa-gg"></i> Station List</a></li>
              </ul>
            </li>
            
            <li class="treeview">
              <a href="FeedbackListServlet">
                <i class="fa fa-comment"></i> <span>Feedback</span>
                <i class="fa fa-angle-left pull-right"></i>           
			  </a>
              <ul class="treeview-menu">
            <!--     <li><a href="feedbackInsert.jsp"><i class="fa fa-gg"></i><span> Feedback Insert</span></a></li> -->
                <li><a href="FeedbackListServlet"><i class="fa fa-gg"></i> Feedback List</a></li>
              </ul>
            </li>
             
            <li class="treeview">
            <a href="LogsListServlet">
                <i class="fa fa-newspaper-o"></i> <span>Logs</span>
                <i class="fa fa-angle-left pull-right"></i>           
			  </a>
              <ul class="treeview-menu">
                <li><a href="LogsListServlet"><i class="fa fa-gg"></i><span> Logs</span></a></li>
                <li><a href="Logging.txt"><i class="fa fa-gg"></i> Log Detail</a></li>
              </ul>
            </li>       
          </ul>
        </section>
      </aside>
      <div class="content-wrapper" style="min-height: 900px; height:900px;">
		<section class="content-header">
          <h1>
           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <small>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</small>
          </h1>
           <!--  <ol class="breadcrumb">
            <li> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
            <li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
          </ol>   -->
        </section>
      </div>
    </div>
     
	<div>

    <script src="AdminBootstrap/plugins/jQuery/jQuery-2.1.4.min.js"></script>
    <script src="AdminBootstrap/bootstrap/js/bootstrap.min.js"></script>
    <script src="AdminBootstrap/plugins/slimScroll/jquery.slimscroll.min.js"></script>
    <script src="AdminBootstrap/plugins/fastclick/fastclick.min.js"></script>
    <script src="AdminBootstrap/dist/js/app.min.js"></script>
    <script src="AdminBootstrap/dist/js/demo.js"></script>
    <script src="AdminBootstrap/plugins/datatables/jquery.dataTables.min.js"></script>
		<script src="AdminBootstrap/plugins/datatables/dataTables.bootstrap.min.js"></script>
<script>
		  $(function () {
			$("#example1").DataTable();
			$('#example2').DataTable({
			  "paging": true,
			  "lengthChange": false,
			  "searching": false,
			  "ordering": true,
			  "info": true,
			  "autoWidth": false
			});
		  });
		</script>
	</div>
	  <%  }else{
		  
		  request.setAttribute("msgLogin", "Please Login To Continue");
	response.sendRedirect("userLoginPage.jsp");
	
} %> 
  </body>
</html>
