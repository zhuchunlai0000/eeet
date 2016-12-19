<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<title>人力资源管理系统</title>
<link rel="shortcut icon" href="<%=path%>/res/image/f.ico">
<link rel="stylesheet" type="text/css"
	href="<%=path%>/res/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="<%=path%>/res/css/style.css" />
	<script type="text/javascript" src="<%=path%>/res/js/jquery.min.js"></script>
	<script>
	$(function(){
		$("#rand").click(function(){
			$(this).prop("src","<%=path%>/image.jsp?num="+Math.random());
		});
		//异步数据提交
		$('#loginBtn').click(function(){
           $.ajax({
	            type: "post",
	            url: "<%=path%>/login.action",
	            data: {
	            	name:$("#name").val(), 
	            	pwd:$("#pwd").val(),
	            	rand:$("#randCode").val()
	            },
	            dataType: "json",
                success: function(data){
                	if (data.msg=="success"){
                		location.href="index.jsp";
                	}else if(data.msg=="fail"){
                		alert("帐号或密码错误");
                	}else{
                		alert("验证码错误");
                	}
	            },error:function(data){
	            	alert("系统异常");
	            }
	         });

	    });
	})
	</script>
</head>

<body class="login_body">
	<div class="login_div">
		<div class="col-xs-12 register_title">登录系统</div>
			<div class="nav">
				<div class="nav register_nav">
					<div class="col-xs-4">帐号:</div>
					<div class="col-xs-6">
						<input type="text" style="padding-left:5px;" name="" id="name"
							value="" placeholder="登录帐号" />
					</div>
				</div>
				<div class="nav register_psdnav">
					<div class="col-xs-4">密码:</div>
					<div class="col-xs-6">
						<input type="password" style="padding-left:5px;" name=""
							id="pwd" value="" placeholder="登录密码" />
					</div>
				</div>
				<div class="nav register_affirm">
					<div class="col-xs-4">验证码:</div>
					<div class="col-xs-6">
						<input type="text" style="padding-left:5px;" name=""
							id="randCode" value="" placeholder="验证码" />
					</div>
				</div>
				<div>
					<div class="col-xs-4"></div>
					<div class="col-xs-6">
						<img src="<%=path%>/image.jsp" id="rand" title="换一个" style="cursor:pointer;margin-top:5px;width:100px"/>
					</div>
				</div>
				<div class="col-xs-12 register_btn_div">
					<input type="button" class="sub_btn" value="登录" id="loginBtn" />
				</div>
			</div>
		<div class="col-xs-12 barter_register">版权所有：长春中勤科技集团</div>
	</div>
</body>
</html>
