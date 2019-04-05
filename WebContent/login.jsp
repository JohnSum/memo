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

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/login.css" />
<script type="text/javascript"
	src="<%=basePath%>/jquery-easyui-1.7.0/jquery.min.js"></script>

<script type="text/javascript" src="<%=basePath%>/js/login.js"></script>

<script type="text/javascript">
	/*在页面加载完成时生成一个随机的验证码*/
	window.onload = function() {
		createCode();
	}
</script>
<title>用户登录</title>

</head>
<body>
	<div id="lg">
		<form action="<%=basePath%>/user/userLogin" method="post" id="login">
			<table>
				<tr>
					<th colspan="3">
						<h1>用户登录</h1>
					</th>
				</tr>
				<tr>
					<th>
						<label for="account">账&ensp;&ensp;号：</label>
					</th>
					<td colspan="2">
						<input type="text" id="account" name="account" />
						<img src="" alt="" />
					</td>
				</tr>
				<tr>
					<th>
						<label for="password">密&ensp;&ensp;码：</label>
					</th>
					<td colspan="2">
						<input type="password" id="password" name="password" />
						<img src="" alt="" />
					</td>
				</tr>
				<tr>
					<td></td>
					<td colspan="2" style="text-align: left;">
						<input type="checkbox" id="view_psw" name="view_psw" />
						<label for="view_psw">
							<span style="color:red;">显示密码？</span>
						</label>
					</td>
				</tr>
				<tr>
					<th><label for="checkCode">验证码：</label></th>
					<td colspan="2">
						<input type="text" id="checkCode" class="code" />
						<img src="" alt="" />
						<input type="text" id="checkNode" class="code" />
						<a href="#" id="changeCode">刷新</a>
					</td>
				</tr>
				<tr>
					<td colspan="3">
						<input type="submit" value="登录" />
						<input type="button" id="rs" value="重置" />
					</td>
				</tr>
			</table>
			<br />
			<div></div>
		</form>
	</div>
</body>
</html>