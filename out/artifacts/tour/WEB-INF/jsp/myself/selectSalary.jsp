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
		<title>查询薪资</title>
		<link rel="stylesheet" href="resource/artDialog/css/ui-dialog.css">
		<script type="text/javascript" src="resource/js/jquery.js"></script>
		<script src="resource/artDialog/dist/dialog-plus.js"></script>
    	<link href="resource/css/style.css" rel="stylesheet" type="text/css"/>
    	<script type="text/javascript" src="resource/commons/utils.js"></script>
    	<script type="text/javascript" src="resource/commons/jquery.md5.js"></script>
</head>
<body>
    <div class="formbody">
        <ul class="forminfo">
            <li><label>薪资</label><input id="salary_number" type="text" class="dfinput" name="salary_number" value="${salary_number }元" readonly="readonly"/></li>
        </ul>
	</div>
</body>
</html>