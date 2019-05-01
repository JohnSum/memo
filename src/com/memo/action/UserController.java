package com.memo.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.memo.entity.User;
import com.memo.service.UserService;
import com.memo.util.JsonPrintUtil;
import com.memo.util.MD5Util;

/**
 * 用户相关控制类
 * 
 * @author 廖明兴
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	/**
	 * 查询账号是否存在（网页端）
	 * 
	 * @param account
	 */
	@RequestMapping(value = "/selectAccount.action", method = RequestMethod.POST)
	public void selectUserByAccount(@RequestParam("account") String account, HttpServletResponse response) {
		String result;
		System.out.println("前台输入账号：" + account);
		if (userService.selectUserByAccount(account)) {
			System.out.println("找到该账号！");
			result = "yes";
		} else {
			System.err.println("账号不存在！");
			result = "no";
		}
		JsonPrintUtil.jsonPrint(result, response);
	}

	/**
	 * 用户登录（网页端）
	 * 
	 * @param account
	 * @param password
	 * @param response
	 */
	@RequestMapping(value = "/userLogin.action", method = RequestMethod.POST)
	public void userLogin(@RequestParam("account") String account, @RequestParam("password") String password,
			HttpSession session, HttpServletResponse response) {
		System.out.println("前台输入用户，账号：" + account + "，密码：" + password);
		User user = userService.userLogin(account, password);
		String result;
		if (user != null) {
			System.out.println("查到的用户信息：\n" + user);
			session.setAttribute("user", user);
			result = "yes";
		} else {
			System.err.println("密码输入错误！");
			session.removeAttribute("user");
			result = "no";
		}

		JsonPrintUtil.jsonPrint(result, response);
	}

	/**
	 * 修改密码（网页端）
	 * 
	 * @param account
	 * @param oldPsw
	 * @param newPsw
	 * @param response
	 */
	@RequestMapping(value = "/changePsw.action", method = RequestMethod.POST)
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
	 * 用户注册（网页端）
	 * 
	 * @param account
	 * @param nickname
	 * @param password
	 * @param id_num
	 */
	@RequestMapping(value = "/userRegister.action", method = RequestMethod.POST)
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

			if (userService.userRegister(user)) {
				JsonPrintUtil.jsonPrint("yes", response);
			} else {
				JsonPrintUtil.jsonPrint("err", response);
			}
		}
	}

	/**
	 * 判断session中是否包含用户信息
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

	/**
	 * 用户登录（微信端）
	 * 
	 * @param cookie
	 * @param account
	 * @param password
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/login.action", method = RequestMethod.POST)
	public @ResponseBody String login(@RequestParam("account") String account,
			@RequestParam("password") String password, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("前台输入用户，账号：" + account + "，密码：" + password);
		User user = userService.userLogin(account, MD5Util.getMd5(password));
		String sessionId = null;
		if (user != null) {
			System.out.println("查到的用户信息：\n" + user);
			request.getSession().setAttribute("user", user); // 添加用户信息到session中
			sessionId = request.getSession().getId();
			return sessionId;
		} else {
			System.err.println("密码输入错误！");
			request.getSession().removeAttribute("user");
			return null;
		}
	}

	/**
	 * 用户注册(微信端)
	 * 
	 * @param account
	 * @param nickname
	 * @param password
	 * @param id_num
	 */
	@RequestMapping(value = "/register.action", method = RequestMethod.POST)
	public void register(@RequestParam("account") String account, @RequestParam("nickname") String nickname,
			@RequestParam("password") String password, @RequestParam("id_num") String id_num,
			HttpServletResponse response) {
		if (userService.selectUserByAccount(account)) {
			JsonPrintUtil.jsonPrint("already", response);
		} else {
			User user = new User();
			user.setAccount(account);
			user.setNickname(nickname);
			user.setPassword(MD5Util.getMd5(password));
			user.setId_num(id_num);
			user.setPower(1);
			System.out.println(user);

			if (userService.userRegister(user)) {
				JsonPrintUtil.jsonPrint("success", response);
			} else {
				JsonPrintUtil.jsonPrint("err", response);
			}
		}
	}
	
	
}
