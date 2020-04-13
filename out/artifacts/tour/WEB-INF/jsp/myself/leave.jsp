<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
	<head>
		<base href="<%=basePath%>">
		<meta charset="UTF-8">
		<title>假条填写</title>
		<link rel="stylesheet" href="resource/artDialog/css/ui-dialog.css">
		<script type="text/javascript" src="resource/js/jquery.js"></script>
		<script src="resource/artDialog/dist/dialog-plus.js"></script>
    	<link href="resource/css/style.css" rel="stylesheet" type="text/css"/>
    	<script type="text/javascript" src="resource/commons/utils.js"></script>
    	<script type="text/javascript" src="resource/commons/jquery.md5.js"></script>
    	<script type="text/javascript">
    	function toSub(){
    		var leave_day=$("#leave_day").val();
    		var leave_desc=$("#leave_desc").val();
    		var leave_startDay=$("#leave_startDay").val();
    		var leave_overDay=$("#leave_overDay").val();
    		if(leave_day.trim().length==0){
    			alert("请假天数不能为空，请重新输入");
    			return false;
    		}
    		if(leave_desc.trim().length==0){
    			alert("请假原因不能为空，请重新输入");
    			return false;
    		}
    		if(leave_startDay.trim().length==0){
    			alert("起始日期不能为空，请重新输入");
    			return false;
    		}
    		if(leave_overDay.trim().length==0){
    			alert("结束日期不能为空，请重新输入");
    			return false;
    		}
    		$("#myForm").submit();
    	}
    	</script>
</head>
<body>
	<form action="MyselfLeave.shxt" method="post" id="myForm">
	    <div class="formbody">
	        <ul class="forminfo">
	            <li><label>请假天数</label><input id="leave_day" type="number" class="dfinput" name="leave_day" value="" /></li>
	            <li><label>请假原因</label><input id="leave_desc" type="text" class="dfinput" name="leave_desc" value="" /></li>
	            <li><label>开始日期</label><input id="leave_startDay" type="text" class="dfinput" name="leave_startDay" value="" /></li>
	            <li><label>结束日期</label><input id="leave_overDay" type="text" class="dfinput" name="leave_overDay" value="" /></li>
	            <li><label>&nbsp;</label><input type="button" value="创建假条" onclick="toSub()"/>
	        </ul>
		</div>
	</form>
</body>
</html>