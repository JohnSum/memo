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
	href="<%=basePath%>/css/login.css" />
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
	<div id="container">
		<div id="bd">
			<div class="login_box">
				<div id="logo"></div>
				<h1></h1>
				<form action="<%=basePath%>tx/to_index.action" method="post" id="login_form" onsubmit="return login()">
					<div class="user_box box">
						<!-- 账号 -->
						<div id="account_box" class="input">
							<div class="acco icon-position"></div>
							<div class="input-position">
								<input type="text" id="account" maxlength="16" name="account" 
									class="input-style" placeholder="请输入账号" />
								<img id="acco_tip" class="picture" src="" alt="" />
							</div><br />
						</div>	
						
						<!-- 密码 -->
						<div id="password_box" class="input">
							<div class="psw icon-position"></div>
							<div class="input-position">
								<input type="password" id="password" maxlength="16" name="password" 
									class="input-style" placeholder="请输入密码" />
								<img id="psw_tip" class="picture" src="" alt="" />
							</div><br />
						</div>
						
						<!-- 是否显示密码 -->
						<div id="view_box" class="input">
							<input type="checkbox" id="view_psw" name="view_psw" />
							<label for="view_psw"><span>显示密码？</span></label>
						</div><br />
						
						<!-- 验证码 -->
						<div id="checkcode_box" class="input">
							<input type="text" id="checkCode" maxlength = "5" placeholder="验证码" class="input-style" />
							<div id="checkNode" class="check-style"></div>
							<img id="check_tip" class="picture" src="" alt="" />
						</div><br />
					</div>
					<!-- 操作 -->
					<div class="op_box box">
						<select id="theme">
							<option value="1" selected="selected">粉 红 风 格</option>
							<option value="2">淡 蓝 风 格</option>
							<option value="3">青 柠 风 格</option>
							<option value="4">白 色 风 格</option>
						</select><br />
						<span>还没有账号？请点击<a href="#">注册</a></span><br />
						<input type="submit" id="sub" value="登 录" class="op" disabled />
						<input type="button" id="rs" value="重 置" class="op" /><br />
					</div><br />
				</form>
			</div>
			<div id="ft">CopyRight&nbsp;2019&nbsp;&nbsp;版权所有
			&nbsp;&nbsp;liaomingxing2017.vicp.io 仅供学习参考 &nbsp;&nbsp;渝CP备201904号</div>
		</div>
	</div>
	<script type="text/javascript">
		var height = $(window).height() > 445 ? $(window).height() : 445;
		$("#container").height(height);
		var bdheight = ($(window).height() - $('#bd').height()) / 2 - 20;
		$('#bd').css('padding-top', bdheight);
		$(window).resize(function(e) {
	        var height = $(window).height() > 445 ? $(window).height() : 445;
			$("#container").height(height);
			var bdheight = ($(window).height() - $('#bd').height()) / 2 - 20;
			$('#bd').css('padding-top', bdheight);
	    });
		$('select').select();
		
		$('.loginButton').click(function(e) {
	        document.location.href = "main.html";
	    });
	</script>
</body>
</html>