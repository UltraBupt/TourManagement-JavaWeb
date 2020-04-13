<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

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
<!DOCTYPE HTML>
<html>
	<head>
		<base href="<%=basePath%>">
		<meta charset="UTF-8">
		<title>菜单管理</title>
		<style type="text/css">
        #main{
            width: 710px;
            height:360px;
            
        }
        #left{
            width: 300px;
            height:350px;
            border: 1px solid #CCC;
            float: left;
        }
        #center{
            width: 100px;
            height:350px;
            border: 1px solid yellowgreen;
            float: left;
        }
        #right{
            width: 300px;
            height:350px;
            border: 1px solid #CCC;
            float: left;
        }
        select{
            width: 260px;
            height:300px;
            font-size:20px;
        }
        .btn{
            width:100px;
            height:35px;
        }
        body {
        overflow-y: scroll;
        overflow-x: scroll;
        }
    </style>
    <script type="text/javascript" src="resource/js/jquery.js"></script>
		<script type="text/javascript">
		   function moveRight(){
			   $("#leftSel :selected").each(function(){
				   $("#rightSel").append($(this));
			   });
		   }
		   function moveLeft(){
			   $("#rightSel :selected").each(function(){
				   $("#leftSel").append($(this));
			   });
		   }
		   function moveAllright(){
			   $("#leftSel option").each(function(){
				   $("#rightSel").append($(this));
			   });
			   $("#rightSel option").each(function(){
				   $(this).attr("selected","selected");
			   });
		   }
		   function moveAllleft(){
			   $("#rightSel option").each(function(){
				   $("#leftSel").append($(this));
			   });
			   $("#leftSel option").each(function(){
				   $(this).attr("selected","selected");
			   });
		   }
		   function toSub(){
			   $("#rightSel option").each(function(){
				   $(this).attr("selected","selected");
			   });
			   $("#myForm").submit();
		   }
    	</script>
	</head>
	<body>
	
		<h1>菜单管理</h1>
		<form action="RoleDistributeServlet.shxt" method="post" id="myForm">
    	<div id="main">
        <div id="left" align="center">
            <span style="display:block;text-align:center;">未选中菜单</span>
            <select id="leftSel" multiple="multiple">
            
                <c:forEach items="${unSelectedMenuList }" var="left">
                    <option value="${left.menu_id }">${left.menu_name }</option>
                </c:forEach>
                
            </select>

        </div>
        <div id="center">
            <p>
                <input class="btn" type="button" value=">>" onclick="moveRight()">
            </p>
            <p>
                <input class="btn" type="button" value="<<" onclick="moveLeft()">
            </p>
            <p>
                <input class="btn" type="button" value="全部右移" onclick="moveAllright()">
            </p>
            <p>
                <input class="btn" type="button" value="全部左移" onclick="moveAllleft()">
            </p>


        </div>

        <div id="right" align="center">
            <span style="display:block;text-align:center;">选中菜单</span>
            <select id="rightSel" multiple="multiple" name="menus">
                <c:forEach items="${selectedMenuList }" var="right">
                    <option value="${right.menu_id }">${right.menu_name }</option>
                </c:forEach>
            </select>

        </div>

    </div>
        <input type="hidden" value="${role_id }" name="role_id"/>
        <input type="button" value="提交" onclick="toSub()"/>
    </form> 
    
	</body>
</html>
