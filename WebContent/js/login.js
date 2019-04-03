// 是否显示密码
function checkboxOnclack(checkbox) {
	if (checkbox.checked == true) {
		$("password").setAttribute("type", "text");
	} else {
		$("password").setAttribute("type", "password");
	}
}

// 重置登录页面
function resetInfo() {
	$("username").value = "";
	$("password").value = "";
	$("checkNode").value = "";
	// 刷新验证码
	createCode();
}

// 验证码的生成和验证
var code;/* 定义一个验证码的全局变量 */
function createCode() {/* 生成验证码的函数 */
	code = "";
	var codeLength = 5;
	var checkCode = $("checkCode");
	checkCode.value = "";
	var selectChar = new Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 'a', 'b', 'c', 'd',
			'e', 'f', 'g', 'h', 'i', 'j', 'k', 'm', 'n', 'o', 'p', 'q',
			'r', 's', 't', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G',
			'H', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
			'U', 'V', 'W', 'X', 'Y', 'Z');
	for (var i = 0; i < codeLength; i++) {
		var charIndex = Math.floor(Math.random() * 56);
		code += selectChar[charIndex];
	}
	if (code.length != codeLength) {
		createCode();
	}
	checkCode.value = code;
	//document.getElementById("checkCode").value = code;
}

/**
 * 验证：1、工号、密码是否为空； 2、验证码是否正确。
 * 
 * @returns
 */
function validate() {
	var employee_id = $("employee_id").value;
	var password = $("password").value;
	if (employee_id == null || employee_id == '') {
		alert("请输入工号！");
		return false;
	} else if (password = null || password == '') {
		alert("请输入密码！");
		return false;
	}
	var inputCode = $("checkNode").value.toUpperCase();
	var codeToUp = code.toUpperCase();
	if (inputCode.length <= 0) {
		alert("请输入验证码！");
		return false;
	} else if (inputCode != codeToUp) {
		alert("验证码输入错误！");
		// createCode();
		return false;
	} else {
		return true;
	}
}