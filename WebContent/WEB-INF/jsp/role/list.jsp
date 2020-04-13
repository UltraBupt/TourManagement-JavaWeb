<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8"/>
<title>角色列表</title>
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
	//上一页下一页
	function toSub(flg,obj){
		switch(flg){
		case 1:	
			if($("#pageNow").val()=="1"){
				alert("当前已是首页，请勿点击");
				$(obj).attr("disabled",true);
			}else{
				$("#pageNow").val(1);
				$("#myForm").submit();
			}
			break;
		case 2:	
			if($("#pageNow").val()=="1"){
				alert("当前已是首页，请勿点击");
				$(obj).attr("disabled",true);
			}else{
				$("#pageNow").val($("#pageNow").val()-1);
				$("#myForm").submit();
			}
			break;
		case 3:	
			if($("#pageNow").val()==$("#totalPages").val()){
				alert("当前已是尾页，请勿点击");
				$(obj).attr("disabled",true);
			}else{
				$("#pageNow").val(parseInt($("#pageNow").val())+1);
				$("#myForm").submit();
			}
			break;
		case 4:	
			if($("#pageNow").val()==$("#totalPages").val()){
				alert("当前已是尾页，请勿点击");
				$(obj).attr("disabled",true);
			}else{
				$("#pageNow").val($("#totalPages").val());
				$("#myForm").submit();
			}
			break;
		case 5:
			$("#pageNow").val(1);
			break;
		}
	}
</script>
<script type="text/javascript">
	//添加角色
		function addRole(){
		   var addDialog = top.dialog({
			   title:'角色添加',
			   url:'RoleAddServlet.shxt',
			   width:600,
			   height:265,
			   onclose:function(){
				  if(this.returnValue=="success"){
					  window.location.href=window.location.href;
				  }
			   }
		   });
		   addDialog.showModal();
		}
		//编辑信息角色
		function upload(role_id){
		   var updateDialog = top.dialog({
			   title:'角色编辑',
			   url:'RoleUpdateServlet.shxt?role_id='+role_id,
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
		//变更状态
        function toChangeStatus(role_id,obj){
        	var txt = $.trim($(obj).html());
        	if(window.confirm("您确定要改变状态么")){
        		 $.post("ChangeStatusServlet.shxt",{role_id:role_id},function(data){
        			 if(data.flag=="success"){
        				 if(data.role_status==1){
        					  $(obj).html("禁用");
        				 }else{
        					 $(obj).html("可用");
        				 }
        				 return;
        			 }else{
        				 alert(data.message);
        				 return;
        			 }
        		 },"json");
        	}
        }
      //分配权限
		function distribute(role_id){
		   var distributeDialog = top.dialog({
			   title:'分配权限',
			   url:'RoleDistributeServlet.shxt?role_id='+role_id,
			   width:700,
			   height:480,
			   onclose:function(){
				  if(this.returnValue=="success"){
					  window.location.href=window.location.href;
				  }
			   }
		   });
		   distributeDialog.showModal();
		}
</script>
</head>
<body>
			<div class="portlet box red">
						<div class="portlet-title">
							<div class="caption">
								<i class="fa fa-comments"></i>角色管理
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
								<form action="RoleListServlet.shxt" method="post" id="myForm">
									<input type="text" name="role_name" id="role_name" value="${queryRole.role_name }" placeholder="请输入角色名称" maxlength="15">
									<select name="role_status" id="role_status" class="btn btn-sm dropdown-toggle selectpicker">
										<option value="">全部</option>
										<option value="1"
											<c:if test="${queryRole.role_status eq '1' }">
												selected
											</c:if>
										>可用</option>
										<option value="0"
											<c:if test="${queryRole.role_status eq '0' }">
												selected
											</c:if>
										>禁用</option>
									</select>
									<input type="submit" class="btn btn-circle btn-xs red" value="搜索" onclick="toSub(5,this)">
									<input type="hidden" name="pageNow" id="pageNow" value="${pageBean.pageNow }">
									<input type="hidden" name="totalPages" id="totalPages" value="${pageBean.totalPages }">
									<shxt class="btn btn-circle btn-xs red" onclick="addRole()">添加角色</shxt>
								</form>
								<table class="table table-bordered table-hover">
								<thead>
								<tr>
									<th>
										 角色编号
									</th>
									<th>
										 角色姓名
									</th>
									<th>
										 角色状态
									</th>
									<th>
										 角色描述
									</th>
									<th>
										 角色操作
									</th>
								</tr>
								</thead>
								<tbody>
								<c:if test="${empty pageBean.data }">
									<tr class="danger">
										<td colspan="7" align="center">没有数据</td>
									</tr>
								</c:if>
								<c:forEach items="${pageBean.data }" var="role" varStatus="vs">
									<tr class="danger">
									<td style="width: 84px; height: 84px">
										 ${vs.count+(pageBean.pageNow-1)*pageBean.pageSize }
									</td>
									<td>
										 ${role.role_name }
									</td>
									<td>
									<a href="javascript:void(0)" style="color:red" onclick="toChangeStatus('${role.role_id}',this)">
										<c:if test="${role.role_status eq '1' }">可用</c:if>
										<c:if test="${role.role_status eq '0' }">禁用</c:if>
									</a>
									</td>
									<td>
										 ${role.role_desc }
									</td>
									<td>
										 <shxt class="btn btn-circle btn-xs red" onclick="upload(${role.role_id})">编辑信息</shxt><br/>
										 <shxt class="btn btn-circle btn-xs red" onclick="distribute(${role.role_id})">分配权限</shxt><br/>
									</td>
								</tr>
								</c:forEach>
								</tbody>
								</table>
								<button class="btn btn-circle btn-xs red" onclick="toSub(1,this)">首页</button>
								<button class="btn btn-circle btn-xs red" onclick="toSub(2,this)">上一页</button>
								<button class="btn btn-circle btn-xs red" onclick="toSub(3,this)">下一页</button>
								<button class="btn btn-circle btn-xs red" onclick="toSub(4,this)">尾页</button><br/>
								第${pageBean.pageNow }页 共${pageBean.totalPages }页 共${pageBean.totalCount}条记录
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