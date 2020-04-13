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
		<title>修改密码</title>
		<link rel="stylesheet" href="resource/artDialog/css/ui-dialog.css">
		<script type="text/javascript" src="resource/js/jquery.js"></script>
		<script src="resource/artDialog/dist/dialog-plus.js"></script>
    	<link href="resource/css/style.css" rel="stylesheet" type="text/css"/>
    	<script type="text/javascript" src="resource/commons/utils.js"></script>
    	<script type="text/javascript" src="resource/commons/jquery.md5.js"></script>
	    <script type="text/javascript">
	       	var user_id = $.trim($("#user_id").val());
	    	function toChange(){
		       	var old_password = $.trim($("#old_password").val());
		      	if(old_password==0){
				    $("#old_message").css("color","red");
				    $("#old_message").html("请输入原始密码");
				    return false;
		      	}else{
		    	  	$.post("MyselfChangePasswordCheck.shxt",{old_password:old_password},function(data){
		            if(data.flag=="success"){
		            	$("#old_message").css("color","green");
		            	$("#old_message").html(data.message);
		                $("#new_password").prop("disabled",false).css("background","#FFF");
		                $("#re_password").prop("disabled",false).css("background","#FFF");
		                return false;
		              }else{
		            	$("#old_message").css("color","red");
		                $("#old_message").html(data.message);
		                $("#new_password").prop("disabled",true).css("background","#CCC");
		                $("#re_password").prop("disabled",true).css("background","#CCC");
		                return false;
		              }
		          },"json");
		    	  return false;
		      }
	    }
	    function toSub(){
	    	var old_password = $.trim($("#old_password").val());
	    	var new_password = $.trim($("#new_password").val());
	        var re_password = $.trim($("#re_password").val());
	        if(old_password==0){
	            $("#old_message").css("color","red");
	            $("#old_message").html("请输入原始密码");
	            return false;
	        }
	        if(new_password==0){
	            $("#new_message").css("color","red");
	            $("#new_message").html("请输入新密码");
	            return false;
	        }
	        if(re_password==0){
	            $("#re_message").css("color","red");
	            $("#re_message").html("请再次输入新密码");
	            return false;
	        }
	        if(new_password!=re_password){
	        	 $("#re_message").css("color","red");
	             $("#re_message").html("新密码不一致，请重新设置！");
	            return false;
	        }else{
	        	$("#new_message").css("color","green");
	            $("#new_message").html("可以使用！");
	        	$("#new_message").css("color","green");
	            $("#new_message").html("可以使用！");
		    	$("#passwordForm").submit();
	        }
	    }
	    function toClose(){
	         var dialog = top.dialog.get(window);
	         dialog.close(); 
	         dialog.remove();               
	         return false;
	    }
		</script>
</head>
<body>
    <div class="formbody">
       <form action="MyselfChangePassword.shxt" method="post" id="passwordForm">
        <ul class="forminfo">
            <li><label>原始密码</label><input id="old_password" type="text" class="dfinput" placeholder="请输入原始密码" maxlength="10" onchange="toChange()"/><i id="old_message"></i></li>
            <li><label>新密码</label><input name="new_password" id="new_password" type="password" class="dfinput" placeholder="请输入新密码" maxlength="10" disabled="disabled" style="background: #CCC;"/><i id="new_message"></i></li>
            <li><label>确认密码</label><input id="re_password" type="password" class="dfinput" placeholder="请再次输入新密码" maxlength="10" disabled="disabled"  style="background: #CCC;"/><i id="re_message"></i></li>
            <li><label>&nbsp;</label><input type="button" value="确认修改" onclick="toSub()"/>
            <input type="button" value="关闭窗口" onclick="toClose();"/></li>
        </ul>
        </form>
    

</div>
</body>
</html>