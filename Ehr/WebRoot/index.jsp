<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link rel="shortcut icon" href="<%=path%>/res/image/f.ico">
        <link href="<%=path %>/res/css/public.css" type="text/css" rel="stylesheet">
        <link href="<%=path %>/res/css/houtai.css" type="text/css" rel="stylesheet">
        <link href="<%=path %>/res/css/smartMenu.css" type="text/css" rel="stylesheet">
        <title>校友网</title>
        <script src="<%=path%>/res/js/jquery.min.js"></script>
        <script type="text/javascript">
        	$(function(){
        		$("#logout").click(function(){
        			if (confirm("确定退出吗?"))
        				location.href="logout.action";
        		});
        	});
        </script>
        <script src="<%=path%>/res/js/menu.js"></script>
    </head>
    <body>
    	<div id="admin">
    		<jsp:include page="menu.jsp"></jsp:include>
    		<div class="ad-comment-box" id="ad-comment">
                <div class="ad-top-comment">
                    <div class="ad-message">
                        <div class="ad-top-left">
                            <div class="ad-change-btn"><a id="ad-list" href="javascript:;" class="scm ad-list-btn"></a></div>
                            <div class="ad-search-box clear">
                                <div class="ad-search-sel">
                                    <select>
                                        <option>新闻类</option>
                                        <option>新闻吩咐道类</option>
                                        <option>新闻广告费类</option>
                                        <option>新闻苟富贵类</option>
                                    </select>
                                </div>
                                <div class="ad-search-cha">
                                    <input type="text" class="ad-search-input" placeholder="请输入你要查找的内容">
                                    <input type="submit" class="scm ad-search-btn" value=""> 
                                </div>
                            </div>
                        </div>
                        <div class="ad-top-right">
                           
                            <div class="ad-welcom">
                                <div class="ad-wel-img"><img src="<%=path %>/res/image/min_logo.png" height="36" width="36"></div>
                                <div class="ad-wel-text">
                                    <div class="font-wel">欢迎您！<strong>${user.name }</strong></div>
                                    <div class="font-wel"><a href="javascript:;" id="logout"><strong>【退出】</strong></a></div>
                                </div>
                            </div>
                        </div>
                    </div>
                   
                    <div class="ad-sub-nav-box content-tabs">
                        <!-- <div class="ad-sub-record">历史记录</div> -->
                        <div class="ad-sub-wraper page-tabs J_menuTabs">
                            <ul class="ad-sub-list page-tabs-content">
                                <li class="active J_menuTab" data-id="index_v0.html">首页</li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="ad-main-comment J_mainContent" id="ad-iframe">
                    <iframe class="J_iframe" name="iframe0" width="100%" height="100%" id="mainUI" src="wel.jsp" frameborder="0" data-id="index_v0.html" seamless></iframe>
                </div>
    		</div>
    	</div>
        <script type="text/javascript" src="<%=path %>/res/js/jquery.min.js"></script>
        <script type="text/javascript" src="<%=path %>/res/js/contabs.js"></script>
        <script type="text/javascript" src="<%=path %>/res/js/maintabs.js"></script>
        <script type="text/javascript" src="<%=path %>/res/js/jquery-smartMenu-min.js"></script>
        <script type="text/javascript" src="<%=path %>/res/js/jquery.nicescroll.min.js"></script>
        <script type="text/javascript">
            $(function(){
                $(".ad-menu").niceScroll({cursorborder:"0 none",cursorcolor:"#1a1a19",cursoropacitymin:"0",boxzoom:false});
            })
        </script>
    </body>
</html>