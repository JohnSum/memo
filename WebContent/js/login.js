$(function() {
	// 选中账号输入框
	$(".acco").bind("input propertychange", function() {
		$("#account").focus();
	});
	// 选中密码输入框
	$(".psw").click(function() {
		$("#password").focus();
	});

	// 是否显示密码
	$("#view_psw").click(function() {
		if ($(this).is(':checked')) {
			$("#password").attr("type", "text");
		} else {
			$("#password").attr("type", "password");
		}
	});

	// 刷新验证码
	$("#checkNode").click(function() {
		createCode();
	});

	// 重置登录页面
	$("#rs").click(function() {
		$("#account").val("");
		$("#acco_tip").attr("src", "");

		$("#password").val("");
		$("#psw_tip").attr("src", "");

		$("#checkCode").val("");
		$("#checkCode").removeAttr("result");
		$("#check_tip").attr("src", "");
		createCode();

		$("#sub").attr("disabled", "true");
	});

	// 修改账号时清空密码
	$("#account").focus(function() {
		$("#password").val('');
		$("#psw_tip").attr("src", "");
		$("#sub").attr("disabled", "true");
	});

	// 重新输入密码前清空以前的密码
	$("#password").focus(function() {
		$("#password").val('');
		$("#psw_tip").attr("src", "");
		$("#sub").attr("disabled", "true");
	});

	$("#account").blur(function() {
		var account = $(this).val();
		$("#acco_tip").css("display", "inline");
		if (account == null || account == '') {
			$("#acco_tip").attr("src", "img/login/no.png");
		} else {
			checkAccount(account);
		}
	});
	// ajax验证账号是否存在
	function checkAccount(account) {
		$.ajax({
			type : 'POST',
			url : path + "/user/selectAccount.action",
			data : {
				"account" : account
			},
			success : function(data) {
				if (data == "yes") {
					$("#acco_tip").attr("src", "img/login/yes.png");
				} else if (data == "no") {
					$("#acco_tip").attr("src", "img/login/no.png");
					$("#sub").attr("disabled", "true");
				}
			}
		});
	}

	$("#password").blur(function() {
		var account = $("#account").val();
		var password = $(this).val();
		if (account != null && account != '') {
			$("#psw_tip").css("display", "inline");

			if (password == null || password == '') {
				$("#psw_tip").attr("src", "img/login/no.png");
			} else {
				checkUser(account, password);
			}
		} else {
			$("#account").focus();
			$("#acco_tip").css("display", "inline");
			$("#acco_tip").attr("src", "img/login/no.png");
		}
	});
	// ajax验证用戶是否存在
	function checkUser(account, password) {
		$.ajax({
			type : 'POST',
			url : path + "/user/userLogin.action",
			data : {
				"account" : account,
				"password" : password
			},
			success : function(data) {
				if (data == "yes") {
					$("#psw_tip").attr("src", "img/login/yes.png");
					$("#sub").removeAttr("disabled");
				} else if (data == "no") {
					$("#password").focus();
					$("#psw_tip").attr("src", "img/login/no.png");
				}
			}
		});
	}

	$("#checkCode").blur(function() {
		var checkCode = $(this).val().toUpperCase();
		var checkNode = $("#checkNode").html().toUpperCase();
		$("#check_tip").css("display", "inline");
		check(checkCode, checkNode);
	});
	// 检查验证码是否正确
	function check(checkCode, checkNode) {
		if (checkCode.length <= 0) {
			$("#checkCode").attr("result", "0");
			$("#check_tip").attr("src", "img/login/no.png");
		} else if (checkCode == checkNode) {
			$("#checkCode").attr("result", "1");
			$("#check_tip").attr("src", "img/login/yes.png");
		} else {
			$("#checkCode").attr("result", "0");
			$("#check_tip").attr("src", "img/login/no.png");
		}
	}

	$("#theme").change(function() {
		var color = $(this).val();
		if (color == "2") {
			$("body").css("background-color", "#80ffff");
		} else if (color == "3") {
			$("body").css("background-color", "#80ff80");
		} else if (color == "4") {
			$("body").css("background-color", "#ffffff");
		} else {
			$("body").css("background-color", "#fdcfc4");
		}
	});
});

// 登录跳转
function login() {
	var checkResult = $("#checkCode").attr("result");
	if (checkResult == "1") {
		$.ajax({
			type : "GET",
			url : path + "/user/selectSession.action",
			success : function(data) {
				if (data == "yes") {
					return true;
				} else if (data == "no") {
					alert("登录已失效，请刷新页面后重新登录！");
					return false;
				} else {
					alert("系统故障，请联系管理员！");
				}
			},
			error : function() {
				alert("系统故障，请联系管理员！");
			}
		});
	} else {
		$("#check_tip").css("display", "inline");
		$("#check_tip").attr("src", "img/login/no.png");
		return false;
	}
}

// 验证码的生成和验证
var code;/* 定义一个验证码的全局变量 */
function createCode() {/* 生成验证码的函数 */
	code = "";
	var codeLength = 5;
	$("#checkNode").html("");
	var selectChar = new Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 'a', 'b', 'c', 'd',
			'e', 'f', 'g', 'h', 'i', 'j', 'k', 'm', 'n', 'o', 'p', 'q', 'r',
			's', 't', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
			'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
			'W', 'X', 'Y', 'Z');
	for (var i = 0; i < codeLength; i++) {
		var charIndex = Math.floor(Math.random() * 56);
		code += selectChar[charIndex];
	}
	if (code.length != codeLength) {
		createCode();
	}
	$("#checkNode").html(code);
}

var path = getRealPath();
// js获取项目根路径，如： http://localhost:8083/uimcardprj
function getRealPath() {
	// 获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
	var curWwwPath = window.document.location.href;
	// 获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
	var pathName = window.document.location.pathname;
	var pos = curWwwPath.indexOf(pathName);
	// 获取主机地址，如： http://localhost:8083
	var localhostPaht = curWwwPath.substring(0, pos);
	// 获取带"/"的项目名，如：/uimcardprj
	var projectName = pathName
			.substring(0, pathName.substr(1).indexOf('/') + 1);
	return (localhostPaht + projectName);
}