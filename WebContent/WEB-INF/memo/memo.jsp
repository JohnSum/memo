<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css" />
<link rel="stylesheet" href="<%=basePath%>css/zTreeStyle/zTreeStyle.css" type="text/css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/skin_/nav.css" />

<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>js/global.js"></script>
<script type="text/javascript" src="<%=basePath%>js/nav.js"></script>
<script type="text/javascript" src="<%=basePath%>js/Menu.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.ztree.core-3.5.js"></script>

<title>Insert title here</title>
</head>
<body>
	<div id="container">
		<div id="bd">
			<div class="sidebar">
				<div class="sidebar-bg"></div>
				<i class="sidebar-hide"></i>
				<h2>
					<a href="javascript:;"><span>安全管理</span></a>
				</h2>
				<ul class="nav">
					<li class="nav-li"><a href="javascript:;" class="ue-clear"><i
							class="nav-ivon"></i><span class="nav-text">新闻管理</span></a>
						<ul class="subnav">
							<li class="subnav-li" href="index.html" data-id="8"><a
								href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span
									class="subnav-text">新闻视频管理</span></a></li>
							<li class="subnav-li" href="form.html" data-id="9"><a
								href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span
									class="subnav-text">新闻频道管理</span></a></li>
							<li class="subnav-li" href="table.html" data-id="10"><a
								href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span
									class="subnav-text">地方新闻管理</span></a></li>
							<li class="subnav-li" data-id="11"><a href="javascript:;"
								class="ue-clear"><i class="subnav-icon"></i><span
									class="subnav-text">自定义设置1</span></a></li>
						</ul></li>
					<li class="nav-li current"><a href="javascript:;"
						class="ue-clear"><i class="nav-ivon"></i><span
							class="nav-text">用户信息设置</span></a>
						<ul class="subnav">
							<li class="subnav-li current" href="index.html" data-id="1"><a
								href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span
									class="subnav-text">首页</span></a></li>
							<li class="subnav-li" href="form.html" data-id="2"><a
								href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span
									class="subnav-text">表单</span></a></li>
							<li class="subnav-li" href="table.html" data-id="3"><a
								href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span
									class="subnav-text">表格</span></a></li>
							<li class="subnav-li" data-id="4"><a href="javascript:;"
								class="ue-clear"><i class="subnav-icon"></i><span
									class="subnav-text">自定义设置2</span></a></li>
						</ul></li>
					<li class="nav-li"><a href="javascript:;" class="ue-clear"><i
							class="nav-ivon"></i><span class="nav-text">工作安排</span></a>
						<ul class="subnav">
							<li class="subnav-li" data-id="5"><a href="javascript:;"
								class="ue-clear"><i class="subnav-icon"></i><span
									class="subnav-text">工作安排查询1</span></a></li>
							<li class="subnav-li" data-id="6"><a href="javascript:;"
								class="ue-clear"><i class="subnav-icon"></i><span
									class="subnav-text">安排管理1</span></a></li>
							<li class="subnav-li" data-id="7"><a href="javascript:;"
								class="ue-clear"><i class="subnav-icon"></i><span
									class="subnav-text">类型选择1</span></a></li>
						</ul></li>
					<li class="nav-li last-nav-li"><a href="javascript:;"
						class="ue-clear"><i class="nav-ivon"></i><span
							class="nav-text">数据管理</span></a>
						<ul class="subnav">
							<li class="subnav-li" data-id="12"><a href="javascript:;"
								class="ue-clear"><i class="subnav-icon"></i><span
									class="subnav-text">工作安排查询2</span></a></li>
							<li class="subnav-li" data-id="13"><a href="javascript:;"
								class="ue-clear"><i class="subnav-icon"></i><span
									class="subnav-text">安排管理2</span></a></li>
							<li class="subnav-li" data-id="14"><a href="javascript:;"
								class="ue-clear"><i class="subnav-icon"></i><span
									class="subnav-text">类型选择2</span></a></li>
						</ul></li>
				</ul>
				<div class="tree-list outwindow">
					<div class="tree ztree"></div>
				</div>
			</div>
			<div class="main">
				<div class="title">
					<i class="sidebar-show"></i>
					<ul class="tab ue-clear">
					</ul>
					<i class="tab-more"></i> <i class="tab-close"></i>
				</div>
				<div class="content"></div>
			</div>
		</div>
	</div>

	<div class="more-bab-list">
		<ul></ul>
		<div class="opt-panel-ml"></div>
		<div class="opt-panel-mr"></div>
		<div class="opt-panel-bc"></div>
		<div class="opt-panel-br"></div>
		<div class="opt-panel-bl"></div>
	</div>
</body>
<script type="text/javascript">
	var menu = new Menu({
		defaultSelect : $('.nav').find('li[data-id="1"]')
	});

	$('.sidebar h2').click(function(e) {
		$('.tree-list').toggleClass('outwindow');
		$('.nav').toggleClass('outwindow');
	});

	$(document).click(function(e) {
		if (!$(e.target).is('.tab-more')) {
			$('.tab-more').removeClass('active');
			$('.more-bab-list').hide();
		}
	});
</script>
</html>