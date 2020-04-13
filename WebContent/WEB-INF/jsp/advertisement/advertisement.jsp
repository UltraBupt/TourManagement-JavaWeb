<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8"/>
<title>广告列表</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<meta http-equiv="Content-type" content="text/html; charset=utf-8">
<meta content="" name="description"/>
<meta content="" name="author"/>
<link href="resource/assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
<link href="resource/assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css"/>
<link href="resource/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="resource/assets/global/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css"/>
<link href="resource/assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" href="resource/assets/global/plugins/select2/select2.css"/>
<link rel="stylesheet" type="text/css" href="resource/assets/global/plugins/datatables/extensions/Scroller/css/dataTables.scroller.min.css"/>
<link rel="stylesheet" type="text/css" href="resource/assets/global/plugins/datatables/extensions/ColReorder/css/dataTables.colReorder.min.css"/>
<link rel="stylesheet" type="text/css" href="resource/assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.css"/>
<link href="resource/assets/global/css/components.css" rel="stylesheet" type="text/css"/>
<link href="resource/assets/global/css/plugins.css" rel="stylesheet" type="text/css"/>
<link href="resource/assets/admin/layout/css/layout.css" rel="stylesheet" type="text/css"/>
<link id="style_color" href="resource/assets/admin/layout/css/themes/default.css" rel="stylesheet" type="text/css"/>
<link href="resource/assets/admin/layout/css/custom.css" rel="stylesheet" type="text/css"/>
<link rel="shortcut icon" href="favicon.ico"/>
<link rel="stylesheet" href="resource/artDialog/css/ui-dialog.css">
<script type="text/javascript" src="resource/js/jquery.js"></script>
<script src="resource/artDialog/dist/dialog-plus.js"></script>
<script src="resource/artDialog/lib/jquery-1.10.2.js"></script>
<script src="resource/artDialog/dist/dialog-min.js"></script>
<script type="text/javascript">
	//编辑广告
	function upload(advertisement_id){
	   var updateDialog = top.dialog({
		   title:'广告编辑',
		   url:'AdvertisementUpdateServlet.shxt?advertisement_id='+advertisement_id,
		   width:600,
		   height:265,
		   onclose:function(){
			  if(this.returnValue=="success"){
				  window.location.href=window.location.href;
			  }
		   }
	   });
	   updateDialog.showModal();
	}
	//添加广告
	function add(advertisement_id){
	   var addDialog = top.dialog({
		   title:'广告编辑',
		   url:'AdvertisementAddServlet.shxt?advertisement_id='+advertisement_id,
		   width:600,
		   height:225,
		   onclose:function(){
			  if(this.returnValue=="success"){
				  window.location.href=window.location.href;
			  }
		   }
	   });
	   addDialog.showModal();
	}
</script>
</head>
<body>
			<div class="portlet box red">
						<div class="portlet-title">
							<div class="caption">
								<i class="fa fa-comments"></i>广告管理
							</div>
							<div class="tools">
								<a href="javascript:;" class="collapse">
								</a>
								<a href="#portlet-config" data-toggle="modal" class="config">
								</a>
								<a href="javascript:;" class="reload">
								</a>
								<a href="javascript:;" class="remove">
								</a>
							</div>
						</div>
						<div class="portlet-body">
							<div class="table-scrollable">
							
							
							
								
								<table class="table table-bordered table-hover" >
								<thead>
								<tr>
									<th>
										 编号
									</th>
									<th>
										栏位
									</th>
									<th>
										 收益
									</th>
									<th>
										 广告
									</th>
									<th>
										操作
									</th>
								</tr>
								</thead>
								<tbody>
								<c:if test="${empty advertisement }">
									<tr class="danger">
										<td colspan="4" align="center">没有数据</td>
									</tr>
								</c:if>
								<c:forEach items="${advertisement }" var="advertisement" varStatus="vs">
									<tr class="danger">
									<td style="width: 100px; height: 100px">
										 ${vs.count }
									</td>
									<td>
										${advertisement.advertisement_name }
									</td>
									<td>
										${advertisement.advertisement_benefit }
									</td>
									<td>
										${advertisement.advertisement_desc }
									</td>
									<td>
										<shxt class="btn btn-circle btn-xs red" onclick="upload(${advertisement.advertisement_id})">编辑广告</shxt><br/>
										<shxt class="btn btn-circle btn-xs red" onclick="add(${advertisement.advertisement_id})">添加广告</shxt><br/>
									</td>
								</tr>
								</c:forEach>
								</tbody>
								</table>
								
								
								
							</div>
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
<script type="text/javascript" src="resource/assets/global/plugins/select2/select2.min.js"></script>
<script type="text/javascript" src="resource/assets/global/plugins/datatables/media/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="resource/assets/global/plugins/datatables/extensions/TableTools/js/dataTables.tableTools.min.js"></script>
<script type="text/javascript" src="resource/assets/global/plugins/datatables/extensions/ColReorder/js/dataTables.colReorder.min.js"></script>
<script type="text/javascript" src="resource/assets/global/plugins/datatables/extensions/Scroller/js/dataTables.scroller.min.js"></script>
<script type="text/javascript" src="resource/assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.js"></script>
<script src="resource/assets/global/scripts/metronic.js" type="text/javascript"></script>
<script src="resource/assets/admin/layout/scripts/layout.js" type="text/javascript"></script>
<script src="resource/assets/admin/layout/scripts/quick-sidebar.js" type="text/javascript"></script>
<script src="resource/assets/admin/layout/scripts/demo.js" type="text/javascript"></script>
<script src="resource/assets/admin/pages/scripts/table-advanced.js"></script>
<script>
jQuery(document).ready(function() {       
   Metronic.init(); // init metronic core components
Layout.init(); // init current layout
QuickSidebar.init(); // init quick sidebar
Demo.init(); // init demo features
   TableAdvanced.init();
});
</script>
</body>
</html>