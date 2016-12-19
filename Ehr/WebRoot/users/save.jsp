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

<title>用户增加</title>
<link rel="stylesheet" type="text/css"
	href="<%=path%>/res/css/bootstrap.min.css">
</head>

<body>
	<div class="container" style="margin-top:30px">
		<pre>用户增加</pre>
		<form method="post" action="<%=path%>/userssave.action">
		<table class="table table-responsive table-striped table-bordered table-hover table-condensed">
			<tbody>
				<tr>
					<td>用户姓名:</td>
					<td><input type="text" name="user.name" class="form-control"
					placeholder="用户姓名"></td>
				</tr>
				<tr>
					<td>登录密码:</td>
					<td><input type="password" name="user.pwd" class="form-control"
					placeholder="登录密码"></td>
				</tr>
				<tr>
					<td colspan="2" align="right">
					<button type="submit" class="btn btn-default" style="width:100px;">提交</button>
					</td>
				</tr>
			</tbody>
		</table>
		</form>
	</div>
</body>
</html>














