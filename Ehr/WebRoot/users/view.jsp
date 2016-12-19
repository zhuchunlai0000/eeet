<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<title>用户显示</title>
<link rel="stylesheet" type="text/css"
	href="<%=path%>/res/css/bootstrap.min.css">
<script>
	function doDelete(id){
		if (confirm("确定删除吗？"))
			location.href="<%=path %>/usersdelete.action?user.id="+id;
	}
	function doSave(){
		location.href="<%=path %>/users/save.jsp";
	}
	function doSearch(){
		location.href="<%=path %>/users/search.jsp";
	}
</script>
<script type="text/javascript" src="<%=path%>/res/js/jquery.min.js"></script>
<script>
$(function(){
	$("#checkAll").click(function(){
		var f=$("#checkAll").prop("checked");
		$("input[type='checkbox']").prop("checked",f);
	});
	$("#deleteAll").click(function(){
		if (confirm("确定删除吗？"))
			$("#ff").submit();
	});
});
</script>
</head>

<body>
	<div class="container" style="margin-top:30px;">
		<pre>用户管理</pre>
		<input type="button" class="btn btn-default navbar-btn" onclick="doSave()" value="新增">
		<input type="button" class="btn btn-default navbar-btn" id="deleteAll" value="删除选中">
		<input type="button" class="btn btn-default navbar-btn" onclick="doSearch()" value="查询">
		<form method="post" id="ff" action="<%=path %>/usersdeleteCheck.action">
		<table class="table table-responsive table-striped table-bordered table-hover table-condensed ">
			<thead>
				<tr class="info">
					<th>
					<input type="checkbox" id="checkAll">
					</th>
					<th>序号</th>
					<th>用户姓名</th>
					<th>操作指令</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list }" var="u" varStatus="vs">
				<tr>
					<td>
						<input type="checkbox" name="ids" value="${u.id }">
					</td>
					<td>${vs.count }</td>
					<td>${u.name }</td>
					<td>
					<a href="javaScript:;" onclick="doDelete(${u.id})">删除</a>
					<a href="<%=path %>/userspreUpdate.action?user.id=${u.id }">修改</a>
					<a href="<%=path%>/userspreBindRole.action?user.id=${u.id}">绑定角色</a>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		</form>
		<div>${pager }</div>
	</div>
</body>
</html>







