<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
<meta charset="utf-8"/>
<title>主界面</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1" name="viewport"/>
<meta content="" name="description"/>
<meta content="" name="author"/>
<link href="resource/assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
<link href="resource/assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css"/>
<link href="resource/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="resource/assets/global/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css"/>
<link href="resource/assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css"/>
<link href="resource/assets/global/plugins/gritter/css/jquery.gritter.css" rel="stylesheet" type="text/css"/>
<link href="resource/assets/global/plugins/bootstrap-daterangepicker/daterangepicker-bs3.css" rel="stylesheet" type="text/css"/>
<link href="resource/assets/global/plugins/fullcalendar/fullcalendar/fullcalendar.css" rel="stylesheet" type="text/css"/>
<link href="resource/assets/global/plugins/jqvmap/jqvmap/jqvmap.css" rel="stylesheet" type="text/css"/>
<link href="resource/assets/admin/pages/css/tasks.css" rel="stylesheet" type="text/css"/>
<link href="resource/assets/global/css/components.css" rel="stylesheet" type="text/css"/>
<link href="resource/assets/global/css/plugins.css" rel="stylesheet" type="text/css"/>
<link href="resource/assets/admin/layout/css/layout.css" rel="stylesheet" type="text/css"/>
<link href="resource/assets/admin/layout/css/themes/darkblue.css" rel="stylesheet" type="text/css" id="style_color"/>
<link href="resource/assets/admin/layout/css/custom.css" rel="stylesheet" type="text/css"/>
<link rel="shortcut icon" href="favicon.ico"/>
<link rel="stylesheet" href="resource/artDialog/css/ui-dialog.css">
<script type="text/javascript" src="resource/js/jquery.js"></script>
<script src="resource/artDialog/dist/dialog-plus.js"></script>
<style type="text/css">
	#myframe{
		width:1110px;
		height:548px;
		overflow:hidden;
		marginwidth=”0″;
		marginheight=”0″;
	}

</style>
<script type="text/javascript">
	$(function(){
		  window.dialog=dialog;
	});
</script>
<script type="text/javascript">
function toUpdatePassword(){
	var user_id = '${sessionScope.session_user.user_id}';
	var d= top.dialog({
		title:'密码修改',
        width:700,
        height:300,
        url:'MyselfChangePassword.shxt?user_id='+user_id,
        onclose:function(){
        	if(this.returnValue=="success"){
				  window.location.href=window.location.href;
			  }
        }
    });
    d.showModal();
}
function toSelectSalary(){
	var user_id = '${sessionScope.session_user.user_id}';
	var d= top.dialog({
		title:'薪资查询',
        width:700,
        height:100,
        url:'MyselfSelectSalary.shxt?user_id='+user_id,
        onclose:function(){
        	if(this.returnValue=="success"){
				  window.location.href=window.location.href;
			  }
        }
    });
    d.showModal();
}
function toLeave(){
	var user_id = '${sessionScope.session_user.user_id}';
	var d= top.dialog({
		title:'请假条',
        width:700,
        height:300,
        url:'MyselfLeave.shxt?user_id='+user_id,
        onclose:function(){
        	if(this.returnValue=="success"){
				  window.location.href=window.location.href;
			  }
        }
    });
    d.showModal();
}
function toUpdateInformation(){
	var user_id = '${sessionScope.session_user.user_id}';
	var d= top.dialog({
		title:'个人信息编辑',
        width:700,
        height:500,
        url:'MyselfUpdateInformation.shxt?user_id='+user_id,
        onclose:function(){
        	if(this.returnValue=="success"){
				  window.location.href=window.location.href;
			  }
        }
    });
    d.showModal();
}
</script>
</head>

<body class="page-header-fixed page-quick-sidebar-over-content"  topmargin='0' leftmargin='0'>
<div class="page-header navbar navbar-fixed-top">
	<div class="page-header-inner">
		<div class="page-logo">
			<a href="LoginServlet.shxt">
				<h4>返回登陆界面</h4>
			</a>
			<div class="menu-toggler sidebar-toggler hide">
			</div>
		</div>
		<a href="javascript:;" class="menu-toggler responsive-toggler" data-toggle="collapse" data-target=".navbar-collapse">
		</a>
		<div class="top-menu">
			<ul class="nav navbar-nav pull-right">
				<li class="dropdown dropdown-user">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
					<img alt="" class="img-circle hide1" src="${sessionScope.session_user.user_photo_url }"/>
					<span class="username username-hide-on-mobile">
					${sessionScope.session_user.user_name } </span>
					<i class="fa fa-angle-down"></i>
					</a>
					<ul class="dropdown-menu">
						<li>
							<a href="javascript:void(0)" onclick="toUpdateInformation()">
								个人信息修改 
							</a>
						</li>
						<li>
							<a href="javascript:void(0)" onclick="toUpdatePassword()">
							 	密码修改
							</a>
						</li>
						<li>
							<a href="javascript:void(0)" onclick="toSelectSalary()">
								个人薪资查看
							</a>
						</li>
						<li>
							<a href="javascript:void(0)" onclick="toLeave()">
								我要请假 
							</a>
						</li>
						<li>
							<a href="WebIndexServlet.html" target="_blank">
								访问前台
							</a>
						</li>
						<li>
							<a href="LoginServlet.shxt">
								退出 
							</a>
						</li>
					</ul>
				</li>
				<li class="dropdown dropdown-quick-sidebar-toggler">
					<a href="javascript:;" class="dropdown-toggle">
					<i class="icon-logout"></i>
					</a>
				</li>
			</ul>
		</div>
	</div>
</div>
<div class="clearfix">
</div>
<div class="page-container">
	<div class="page-sidebar-wrapper">
		<div class="page-sidebar navbar-collapse collapse">
			<ul class="page-sidebar-menu " data-auto-scroll="true" data-slide-speed="200">
				<li class="sidebar-search-wrapper">
					<form class="sidebar-search " action="" method="POST">
						<a href="javascript:;" class="remove">
						<i class="icon-close"></i>
						</a>
						<div class="input-group">
							<input type="text" class="form-control" placeholder="欢迎使用" readonly>
						</div>
					</form>
				</li>
				<c:forEach items="${parentList }" var="parent">
					<li>
					<a href="javascript:;">
					<i class="icon-home"></i>
					<span class="title">${parent.menu_name }</span>
					<span class="selected"></span>
					<span class="arrow open"></span>
					</a>
					<ul class="sub-menu">
					<c:forEach items="${childList }" var="child">
						<c:if test="${child.parent_id==parent.menu_id }">
							<li>
								<a href="${child.menu_url }" target="myframe">
								<i class="icon-bar-chart"></i>
								${child.menu_name }</a>
							</li>
						</c:if>
					</c:forEach>
					</ul>
				</li>
				</c:forEach>
				
			</ul>
		</div>
	</div>
	<div class="page-content-wrapper">
		<div class="page-content" id="target">
		
			<iframe id="myframe" name="myframe" frameborder="no">
			
			</iframe>
			
		</div>
	</div>
	<a href="javascript:;" class="page-quick-sidebar-toggler"><i class="icon-close"></i></a>
</div>
<div class="page-footer">
	<div class="page-footer-inner">
		四海兴唐科技有限公司--祥云
	</div>
	<div class="scroll-to-top">
		<i class="icon-arrow-up"></i>
	</div>
</div>
<script src="resource/assets/global/plugins/jquery-1.11.0.min.js" type="text/javascript"></script>
<script src="resource/assets/global/plugins/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
<script src="resource/assets/global/plugins/jquery-ui/jquery-ui-1.10.3.custom.min.js" type="text/javascript"></script>
<script src="resource/assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="resource/assets/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
<script src="resource/assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="resource/assets/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
<script src="resource/assets/global/plugins/jquery.cokie.min.js" type="text/javascript"></script>
<script src="resource/assets/global/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
<script src="resource/assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
<script src="resource/assets/global/plugins/jqvmap/jqvmap/jquery.vmap.js" type="text/javascript"></script>
<script src="resource/assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.russia.js" type="text/javascript"></script>
<script src="resource/assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.world.js" type="text/javascript"></script>
<script src="resource/assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.europe.js" type="text/javascript"></script>
<script src="resource/assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.germany.js" type="text/javascript"></script>
<script src="resource/assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.usa.js" type="text/javascript"></script>
<script src="resource/assets/global/plugins/jqvmap/jqvmap/data/jquery.vmap.sampledata.js" type="text/javascript"></script>
<script src="resource/assets/global/plugins/flot/jquery.flot.min.js" type="text/javascript"></script>
<script src="resource/assets/global/plugins/flot/jquery.flot.resize.min.js" type="text/javascript"></script>
<script src="resource/assets/global/plugins/flot/jquery.flot.categories.min.js" type="text/javascript"></script>
<script src="resource/assets/global/plugins/jquery.pulsate.min.js" type="text/javascript"></script>
<script src="resource/assets/global/plugins/bootstrap-daterangepicker/moment.min.js" type="text/javascript"></script>
<script src="resource/assets/global/plugins/bootstrap-daterangepicker/daterangepicker.js" type="text/javascript"></script>
<script src="resource/assets/global/plugins/fullcalendar/fullcalendar/fullcalendar.min.js" type="text/javascript"></script>
<script src="resource/assets/global/plugins/jquery-easypiechart/jquery.easypiechart.min.js" type="text/javascript"></script>
<script src="resource/assets/global/plugins/jquery.sparkline.min.js" type="text/javascript"></script>
<script src="resource/assets/global/plugins/gritter/js/jquery.gritter.js" type="text/javascript"></script>
<script src="resource/assets/global/scripts/metronic.js" type="text/javascript"></script>
<script src="resource/assets/admin/layout/scripts/layout.js" type="text/javascript"></script>
<script src="resource/assets/admin/layout/scripts/quick-sidebar.js" type="text/javascript"></script>
<script src="resource/assets/admin/layout/scripts/demo.js" type="text/javascript"></script>
<script src="resource/assets/admin/pages/scripts/index.js" type="text/javascript"></script>
<script src="resource/assets/admin/pages/scripts/tasks.js" type="text/javascript"></script>
<script>
jQuery(document).ready(function() {    
   Metronic.init(); // init metronic core componets
   Layout.init(); // init layout
   QuickSidebar.init(); // init quick sidebar
Demo.init(); // init demo features
   Index.init();   
   Index.initDashboardDaterange();
   Index.initJQVMAP(); // init index page's custom scripts
   Index.initCalendar(); // init index page's custom scripts
   Index.initCharts(); // init index page's custom scripts
   Index.initChat();
   Index.initMiniCharts();
   Index.initIntro();
   Tasks.initDashboardWidget();
});
</script>
</body>
</html>