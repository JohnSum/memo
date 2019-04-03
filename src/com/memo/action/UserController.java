package com.memo.action;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.memo.entity.User;
import com.memo.service.UserService;
import com.memo.util.JsonPrintUtil;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	/**
	 * 查询账号是否存在
	 * 
	 * @param account
	 */
	@RequestMapping(value = "/selectAccount", method = RequestMethod.POST)
	public void selectUserByAccount(@RequestParam("account") String account, HttpServletResponse response) {
		String result;
		if (userService.selectUserByAccount(account)) {
			result = "yes";
		} else {
			result = "no";
		}
		JsonPrintUtil.jsonPrint(result, response);
	}

	/**
	 * 用户登录
	 * 
	 * @param account
	 * @param password
	 * @param response
	 */
	@RequestMapping(value = "/userLogin", method = RequestMethod.POST)
	public void userLogin(@RequestParam("account") String account, @RequestParam("password") String password,
			HttpSession session, HttpServletResponse response) {
		User user = userService.userLogin(account, password);
		String result;
		if (user != null) {
			System.out.println("查询到该用户！");
			session.setAttribute("user", user);
			result = "yes";
		} else {
			System.out.println("用户不存在！");
			result = "no";
		}

		JsonPrintUtil.jsonPrint(result, response);
	}

	/**
	 * 修改密码
	 * 
	 * @param account
	 * @param oldPsw
	 * @param newPsw
	 * @param response
	 */
	@RequestMapping(value = "/changePsw", method = RequestMethod.POST)
	public void changePsw(@RequestParam("account") String account, @RequestParam("oldPsw") String oldPsw,
			@RequestParam("newPsw") String newPsw, HttpServletResponse response) {
		String result;
		if (userService.changePsw(account, newPsw)) {
			result = "yes";
		} else {
			result = "no";
		}

		JsonPrintUtil.jsonPrint(result, response);
	}

	/**
	 * 用户注册
	 * 
	 * @param account
	 * @param nickname
	 * @param password
	 * @param id_num
	 */
	@RequestMapping(value = "/userRegister", method = RequestMethod.POST)
	public void userRegister(@RequestParam("account") String account, @RequestParam("nickname") String nickname,
			@RequestParam("password") String password, @RequestParam("id_num") String id_num,
			HttpServletResponse response) {
		if (userService.selectUserByAccount(account)) {
			JsonPrintUtil.jsonPrint("no", response);
		} else {
			User user = new User();
			user.setAccount(account);
			user.setNickname(nickname);
			user.setPassword(password);
			user.setId_num(id_num);
			user.setPower(1);
			
			if(userService.userRegister(user)) {
				JsonPrintUtil.jsonPrint("yes", response);
			}else {
				JsonPrintUtil.jsonPrint("err", response);
			}
		}
	}
}
