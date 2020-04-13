<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8"/>
<title>个人信息修改</title>
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
<script type="text/javascript">
	function toSub(){
		var fk_org_id=$("#fk_org_id").val();
		var user_name=$("#user_name").val();
		var user_code=$("#user_code").val();
		var user_tel=$("#user_tel").val();
		var user_sex=$("#user_sex").val();
		var user_email=$("#user_email").val();
		if(fk_org_id.trim().length==0){
			alert("部门类型不能为空，请选择");
			return false;
		}
		if(user_name.trim().length==0){
			alert("姓名不能为空，请重新输入");
			return false;
		}
		if(user_code.trim().length==0){
			alert("身份证不能为空，请重新输入");
			return false;
		}
		if(user_tel.trim().length==0){
			alert("电话不能为空，请重新输入");
			return false;
		}
		if(user_sex.trim().length==0){
			alert("性别不能为空，请重新输入");
			return false;
		}
		if(user_email.trim().length==0){
			alert("邮箱不能为空，请重新输入");
			return false;
		}
		$("#myForm").submit();
	}
</script>
</head>
<body>
		<div class="portlet box yellow ">
			<div class="portlet-title">
				<div class="caption">
					<i class="fa fa-gift"></i> 个人信息修改
				</div>
							<div class="tools">
								<a href="" class="collapse">
								</a>
								<a href="#portlet-config" data-toggle="modal" class="config">
								</a>
								<a href="" class="reload">
								</a>
								<a href="" class="remove">
								</a>
							</div>
						</div>
						<div class="portlet-body form">
						
						
							<form class="form-horizontal" action="MyselfUpdateInformation.shxt" method="post" id="myForm">
								<div class="form-body">
									<div class="form-group">
										<div class="col-md-9">
											<input type="text" class="form-control input-sm"  name="account" id="account" value="${user.account }" disabled="disabled">
										</div>
									</div>
									<div class="col-md-4" style="height:100px">
										<select name="fk_org_id" id="fk_org_id" class="form-control input-xlarge select2me">
											<option value="">全部</option>
												<c:forEach items="${branch_list }" var="branch">
												<option value="${branch.branch_id }"
												<c:if test="${user.fk_org_id==branch.branch_id }">selected</c:if>
												>${branch.branch_name }
													</option>
												</c:forEach>
										</select>
									</div>
									<div class="form-group">
										<div class="col-md-9">
											<input type="text" class="form-control input-sm" placeholder="姓名" name="user_name" id="user_name" value="${user.user_name }">
										</div>
									</div>
									<div class="form-group">
										<div class="col-md-9">
											<input type="text" class="form-control input-sm" placeholder="身份证" name="user_code" id="user_code" value="${user.user_code }">
										</div>
									</div>
									<div class="form-group">
										<div class="col-md-9">
											<input type="text" class="form-control input-sm" placeholder="联系电话" name="user_tel" id="user_tel" value="${user.user_tel }">
										</div>
									</div>
									<div class="radio-list">
											<label>
											<input type="radio" name="user_sex" value="1" id="user_sex"
												<c:if test="${user.user_sex==1 }">checked</c:if>
											/>男</label>
											<label>
											<input type="radio" name="user_sex" value="2" id="user_sex"
												<c:if test="${user.user_sex==2 }">checked</c:if>
											/>女</label>
									</div>
									<div class="form-group">
										<div class="col-md-9">
											<input type="email" class="form-control input-sm" placeholder="邮箱" name="user_email" id="user_email" value="${user.user_email }">
										</div>
									</div>
									
									
								</div>
								<div class="form-actions right1">
									<button type="button" class="btn yellow" value="修改信息" onclick="toSub()">修改信息</button>
									<input id="user_id" name="user_id" type="hidden" value="${user.user_id }"/>
								</div>
							</form>
							
							
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