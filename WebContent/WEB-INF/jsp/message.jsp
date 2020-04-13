<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//项目的发布路径，例如:  /rabc
	String path = request.getContextPath();
	/*
	全路径，形式如下: http://127.0.0.1:8001/rbac/
	request.getScheme()      ——> http 获取协议
	request.getServerName()  --> 127.0.0.1 获取服务名
	request.getServerPort()  --> 8001 获取端口号
	path                     --> /rbac 获取访问的路径 路
	*/
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="resource/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="resource/artDialog/css/ui-dialog.css">
<script src="resource/js/jquery.js"></script>
<script src="resource/bootstrap/js/bootstrap.min.js"></script>
<script src="resource/artDialog/dist/dialog-plus.js"></script>
<script type="text/javascript">
   function toClose(){
	   var dialog = top.dialog.get(window);
	   dialog.close($("#flg").val());
	   dialog.remove();
	   return false;
   }
</script>
</head>
<body>  
 <span>${message }</span>
         
 <input type="hidden" id="flg" value="${flg }"/>
 <input type="button" class="btn btn-danger" value="关闭窗口" onclick="toClose()"/>

   

</body>
</html>