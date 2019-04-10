package com.memo.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	 * 主页加载备忘录页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/memo.action", method = RequestMethod.GET)
	public String loadHomePage() {
		return "/memo/memo";
	}

}
