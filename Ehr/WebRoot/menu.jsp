<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<div class="ad-menu" id="ad-menu">
	<div class="ad-logo">
		<img src="<%=path%>/res/image/m-logo.png" height="83" width="110">
	</div>
	<div class="ad-logo" style="color:#ffffff;font-size:16px">
		人力资源管理系统<br> <span style="color:#ffffff;font-size:12px">Human
			Resource Manager System</span>
	</div>
	<div class="ad-list">
		<ul>
			<li>
				<div class="li-item">
					<em class="scm li-ico ic1"></em>权限管理<span class="scm arrow"></span>
				</div>
				<dl>
					<dd>
						<a href="javaScript:;" id="res" class="dd-item">资源管理<span
							class="scm dd-ar"></span></a>
					</dd>
					<dd>
						<a href="javaScript:;" id="role" class="dd-item">角色管理<span class="scm dd-ar"></span></a>
					</dd>
					<dd>
						<a href="javaScript:;" id="users" class="dd-item">用户管理<span class="scm dd-ar"></span></a>
					</dd>
				</dl>
			</li>
			<li>
				<div class="li-item">
					<em class="scm li-ico ic2"></em>人力资源<span class="scm arrow"></span>
				</div>
				<dl>
					<dd>
						<a href="#" class="dd-item">部门管理<span class="scm dd-ar"></span></a>
					</dd>
					<dd>
						<a href="#" class="dd-item">员工管理<span class="scm dd-ar"></span></a>
					</dd>
				</dl>
			</li>
			<!-- <li>
				<div class="li-item">
					<em class="scm li-ico ic3"></em>组织管理<span class="scm arrow"></span>
				</div>
				<dl>
					<dd>
						<a href="#" class="dd-item">校友高级管理<span class="scm dd-ar"></span></a>
						<ul class="ad-item-list">
							<li class="J_menuItem" href="index_v1.html" data-index="1">测试用例一</li>
							<li class="J_menuItem" href="index_v2.html" data-index="2">测试用例二</li>
							<li class="J_menuItem" href="index_v3.html" data-index="3">测试用例三</li>
							<li class="J_menuItem" href="index_v4.html" data-index="4">测试用例四</li>
							<li class="J_menuItem" href="index_v5.html" data-index="5">测试用例五</li>
							<li class="J_menuItem" href="index_v6.html" data-index="6">测试用例六</li>
							<li class="J_menuItem" href="index_v7.html" data-index="7">测试用例七</li>
							<li class="J_menuItem" href="index_v8.html" data-index="8">测试用例八</li>
							<li class="J_menuItem" href="index_v9.html" data-index="9">测试用例九</li>
							<li class="J_menuItem" href="index_v10.html" data-index="10">测试用例十</li>
							<li class="J_menuItem" href="index_v11.html" data-index="11">测试用例十一</li>
						</ul>
					</dd>
					<dd>
						<a href="#" class="dd-item">校友查询<span class="scm dd-ar"></span></a>
						<ul class="ad-item-list">
							<li class="J_menuItem" href="index_v1.html" data-index="1">测试用例一</li>
							<li class="J_menuItem" href="index_v2.html" data-index="2">测试用例二</li>
							<li class="J_menuItem" href="index_v3.html" data-index="3">测试用例三</li>
							<li class="J_menuItem" href="index_v4.html" data-index="4">测试用例四</li>
							<li class="J_menuItem" href="index_v5.html" data-index="5">测试用例五</li>
							<li class="J_menuItem" href="index_v6.html" data-index="6">测试用例六</li>
							<li class="J_menuItem" href="index_v7.html" data-index="7">测试用例七</li>
							<li class="J_menuItem" href="index_v8.html" data-index="8">测试用例八</li>
							<li class="J_menuItem" href="index_v9.html" data-index="9">测试用例九</li>
							<li class="J_menuItem" href="index_v10.html" data-index="10">测试用例十</li>
							<li class="J_menuItem" href="index_v11.html" data-index="11">测试用例十一</li>
						</ul>
					</dd>
					<dd>
						<a href="#" class="dd-item">校友搜索<span class="scm dd-ar"></span></a>
						<ul class="ad-item-list">
							<li class="J_menuItem" href="index_v1.html" data-index="1">测试用例一</li>
							<li class="J_menuItem" href="index_v2.html" data-index="2">测试用例二</li>
							<li class="J_menuItem" href="index_v3.html" data-index="3">测试用例三</li>
							<li class="J_menuItem" href="index_v4.html" data-index="4">测试用例四</li>
							<li class="J_menuItem" href="index_v5.html" data-index="5">测试用例五</li>
							<li class="J_menuItem" href="index_v6.html" data-index="6">测试用例六</li>
							<li class="J_menuItem" href="index_v7.html" data-index="7">测试用例七</li>
							<li class="J_menuItem" href="index_v8.html" data-index="8">测试用例八</li>
							<li class="J_menuItem" href="index_v9.html" data-index="9">测试用例九</li>
							<li class="J_menuItem" href="index_v10.html" data-index="10">测试用例十</li>
							<li class="J_menuItem" href="index_v11.html" data-index="11">测试用例十一</li>
						</ul>
					</dd>
					<dd>
						<a href="#" class="dd-item">校友高输入<span class="scm dd-ar"></span></a>
						<ul class="ad-item-list">
							<li class="J_menuItem" href="index_v1.html" data-index="1">测试用例一</li>
							<li class="J_menuItem" href="index_v2.html" data-index="2">测试用例二</li>
							<li class="J_menuItem" href="index_v3.html" data-index="3">测试用例三</li>
							<li class="J_menuItem" href="index_v4.html" data-index="4">测试用例四</li>
							<li class="J_menuItem" href="index_v5.html" data-index="5">测试用例五</li>
							<li class="J_menuItem" href="index_v6.html" data-index="6">测试用例六</li>
							<li class="J_menuItem" href="index_v7.html" data-index="7">测试用例七</li>
							<li class="J_menuItem" href="index_v8.html" data-index="8">测试用例八</li>
							<li class="J_menuItem" href="index_v9.html" data-index="9">测试用例九</li>
							<li class="J_menuItem" href="index_v10.html" data-index="10">测试用例十</li>
							<li class="J_menuItem" href="index_v11.html" data-index="11">测试用例十一</li>
						</ul>
					</dd>
					<dd>
						<a href="#" class="dd-item">校友高级搜索<span class="scm dd-ar"></span></a>
					</dd>
					<dd>
						<a href="#" class="dd-item">校友高级搜索<span class="scm dd-ar"></span></a>
					</dd>
					<dd>
						<a href="#" class="dd-item">校友高级搜索<span class="scm dd-ar"></span></a>
					</dd>
					<dd>
						<a href="#" class="dd-item">校友高级搜索<span class="scm dd-ar"></span></a>
					</dd>
					<dd>
						<a href="#" class="dd-item">校友高级搜索<span class="scm dd-ar"></span></a>
					</dd>
					<dd>
						<a href="#" class="dd-item">校友高级搜索<span class="scm dd-ar"></span></a>
					</dd>
				</dl>
			</li>
			<li>
				<div class="li-item">
					<em class="scm li-ico ic4"></em>社区管理<span class="scm arrow"></span>
				</div>
				<dl>
					<dd>
						<a href="#" class="dd-item">校友高级搜索<span class="scm dd-ar"></span></a>
					</dd>
					<dd>
						<a href="#" class="dd-item">校友高级搜索<span class="scm dd-ar"></span></a>
					</dd>
				</dl>
			</li>
			<li>
				<div class="li-item">
					<em class="scm li-ico ic5"></em>捐赠管理<span class="scm arrow"></span>
				</div>
				<dl>
					<dd>
						<a href="#" class="dd-item">校友高级搜索<span class="scm dd-ar"></span></a>
					</dd>
					<dd>
						<a href="#" class="dd-item">校友高级搜索<span class="scm dd-ar"></span></a>
					</dd>
				</dl>
			</li>
			<li>
				<div class="li-item">
					<em class="scm li-ico ic6"></em>统计管理<span class="scm arrow"></span>
				</div>
				<dl>
					<dd>
						<a href="#" class="dd-item">校友高级搜索<span class="scm dd-ar"></span></a>
					</dd>
					<dd>
						<a href="#" class="dd-item">校友高级搜索<span class="scm dd-ar"></span></a>
					</dd>
				</dl>
			</li>
			<li>
				<div class="li-item">
					<em class="scm li-ico ic7"></em>系统管理<span class="scm arrow"></span>
				</div>
				<dl>
					<dd>
						<a href="#" class="dd-item">校友高级搜索<span class="scm dd-ar"></span></a>
					</dd>
					<dd>
						<a href="#" class="dd-item">校友高级搜索<span class="scm dd-ar"></span></a>
					</dd>
				</dl>
			</li> -->
		</ul>
	</div>
</div>
