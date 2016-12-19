<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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

<title>绑定角色</title>
<link rel="stylesheet" type="text/css"
	href="<%=path%>/res/css/bootstrap.min.css">
</head>

<body>
	<div class="container" style="margin-top:30px">
		<pre>绑定角色</pre>
		<form method="post" action="<%=path%>/usersbindRole.action">
		<table class="table table-responsive table-striped table-bordered table-hover table-condensed">
			<tbody>
				<tr>
					<td>当前用户</td>
					<td>${user.name }</td>
				</tr>
				<tr>
					<td>角色选择:</td>
					<td>
						<c:forEach items="${roleList }" var="rl">
						<input type="checkbox" name="rids" value="${rl.id }" <c:if test="${fn:contains(bindIds,rl.id)}">checked</c:if>>
						${rl.name }<br>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="right">
					<button type="submit" class="btn btn-default" style="width:100px;">提交</button>
					</td>
				</tr>
			</tbody>
		</table>
		<input type="hidden" name="user.id" value="${user.id }">
		</form>
	</div>
</body>
</html>














