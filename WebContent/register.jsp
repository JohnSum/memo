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
<title>Insert title here</title>
</head>
<body>
	<div id="login">
		<h1>用户登录</h1>
		<form action="${basePath}/user/userRegister">
			<div>
				<label for="account">账号：</label><input type="text" id="account"
					name="account" /><br /> <label for="nickname">昵称</label><input
					type="text" id="nickname" name="nickname" /><br /> <label
					for="password">密码：</label><input type="password" id="password"
					name="password" /><br /> <label for="id_num">身份证号：</label><input
					type="text" id="id_num" name="id_num" /><br />
			</div>
			<br />
			<div>
				<input type="submit" value="注册" /> <input type="reset" value="重置" />
			</div>
		</form>
	</div>
</body>
</html>