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
	@RequestMapping(value = "/selectAccount.action", method = RequestMethod.POST)
	public void selectUserByAccount(@RequestParam("account") int account, HttpServletResponse response) {
		String result;
		System.out.println("前台输入账号：" + account);
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
	@RequestMapping(value = "/userLogin.action", method = RequestMethod.POST)
	public void userLogin(@RequestParam("account") int account, @RequestParam("password") String password,
			HttpSession session, HttpServletResponse response) {
		System.out.println("前台输入用户，账号：" + account + "，密码：" + password);
		User user = userService.userLogin(account, password);
		String result;
		if (user != null) {
			System.err.println("查到的用户信息：\n" + user);
			session.setAttribute("user", user);
			result = "yes";
		} else {
			session.removeAttribute("user");
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
	@RequestMapping(value = "/changePsw.action", method = RequestMethod.POST)
	public void changePsw(@RequestParam("account") int account, @RequestParam("oldPsw") String oldPsw,
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
	@RequestMapping(value = "/userRegister.action", method = RequestMethod.POST)
	public void userRegister(@RequestParam("account") int account, @RequestParam("nickname") String nickname,
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

			if (userService.userRegister(user)) {
				JsonPrintUtil.jsonPrint("yes", response);
			} else {
				JsonPrintUtil.jsonPrint("err", response);
			}
		}
	}

	/**
	 * 登录跳转前判断用户信息是否已放入session
	 * 
	 * @param session
	 * @param response
	 */
	@RequestMapping("/selectSession.action")
	public void selectSession(HttpSession session, HttpServletResponse response) {
		if (session.getAttribute("user") != null) {
			System.out.println("session已存在：" + session.getAttribute("user"));
			JsonPrintUtil.jsonPrint("yes", response);
		} else {
			JsonPrintUtil.jsonPrint("no", response);
		}
	}
}
