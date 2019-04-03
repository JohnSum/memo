<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/csc"
	href="<%=basePath%>/css/login.css" />
<script type="text/javascript"
	src="<%=basePath%>/js/jquery-3.3.1.slim.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/login.js"></script>

<title>用户登录</title>

<script type="text/javascript">
	/*在页面加载完成时生成一个随机的验证码*/
	window.onload = function() {
		createCode();
	}
</script>
</head>
<body>
	<div id="login">
		<h1>用户登录</h1>
		<form action="<%=basePath%>/user/userLogin" method="post">
			<table>
				<tr>
					<th><label for="account">账&ensp;&ensp;号：</label></th>
					<td colspan="2"><input type="text" id="account" name="account" /></td>
				</tr>
				<tr>
					<th><label for="password">密&ensp;&ensp;码：</label></th>
					<td colspan="2"><input type="password" id="password"
						name="password" /></td>
				</tr>
				<tr>
					<th><label for="checkCode">验证码：</label></th>
					<td colspan="2"><input type="text" id="checkCode" /><span id="checkNode">123456</span></td>
				</tr>
				<tr>
					<td><input type="submit" value="登录" /></td>
					<td><input type="reset" value="重置" /></td>
					<td><input type="button" value="注册" /></td>
				</tr>
			</table>
			<br />
			<div></div>
		</form>
	</div>
</body>
</html>