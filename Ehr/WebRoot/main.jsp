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
<link rel="shortcut icon" href="<%=path%>/res/image/f.ico"/> 
<link rel="stylesheet" type="text/css"
	href="<%=path%>/res/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="<%=path%>/res/css/style.css" />
<script type="text/javascript" src="<%=path%>/res/js/jquery.min.js"></script>
<script>
	$(function(){
		$("#rand").click(function(){
			$(this).prop("src","<%=path%>/image.jsp?r="+Math.random());
		});
	});
</script>
</head>

<body class="login_body">
	<div class="login_div">
		<div class="col-xs-12 login_title">登录</div>
		<form action="" class="login" method="post">
			<div class="nav">
				<div class="nav login_nav">
					<div class="col-xs-4 login_username">帐号:</div>
					<div class="col-xs-6 login_usernameInput">
						<input type="text" style="padding-left:10px;" name="" id="name" value="" placeholder="登录帐号" />
					</div>
				</div>
				<div class="nav login_psdNav">
					<div class="col-xs-4">密码:</div>
					<div class="col-xs-6">
						<input type="password" style="padding-left:10px;" name="" id="psd" value=""
							placeholder="登录密码" />
					</div>
				</div>
				<div class="nav register_affirm">
					<div class="col-xs-4">验证码:</div>
					<div class="col-xs-6">
						<input type="password" style="padding-left:10px;" name="" id="affirm_psd" value=""
							placeholder="验证码" />
					</div>
				</div>
				<div>
					<div class="col-xs-4"></div>
					<div class="col-xs-6">
						<img src="<%=path%>/image.jsp" id="rand" title="看不清,换一个" style="cursor:pointer;margin-top: 10px;width: 80px;">
					</div>
				</div>
				<div class="col-xs-12 login_btn_div">
					<input type="submit" class="sub_btn" value="登录" id="login" />
				</div>
			</div>
		</form>
		<div class="col-xs-12 barter_register">
			版权所有：长春中勤科技集团有限责任公司
		</div>
	</div>
</body>
</html>










