package com.memo.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 事务控制类
 * 
 * @author 廖明兴
 *
 */
@Controller
@RequestMapping("/tx")
public class TransactionController {
	/**
	 * 登录跳转至主页
	 * 
	 * @return
	 */
	@RequestMapping(value = "to_index.action", method = RequestMethod.POST)
	public String toIndex() {
		return "/memo/index";
	}

	/**
	 * 主页默认加载备忘录页面(一般用户)
	 * 
	 * @return
	 */
	@RequestMapping(value = "/memo.action", method = RequestMethod.GET)
	public String memo() {
		return "/memo/memo";
	}

	/**
	 * 主页默认加载用户管理页面(管理员)
	 * 
	 * @return
	 */
	@RequestMapping(value = "/user.action", method = RequestMethod.GET)
	public String user() {
		return "/memo/user";
	}

}
