package com.memo.service;

import com.memo.entity.User;

public interface UserService {
	/**
	 * 根据账号查找用户
	 * 
	 * @param account
	 * @return
	 */
	public boolean selectUserByAccount(String account);

	/**
	 * 用户登录（账号+密码）
	 * 
	 * @param account
	 * @param password
	 * @return
	 */
	public User userLogin(String account, String password);

	/**
	 * 根据账号修改密码（先获得账号）
	 * 
	 * @param account
	 * @param newPsw
	 * @return
	 */
	public boolean changePsw(String account, String newPsw);

	/**
	 * 用户注册
	 * 
	 * @param user
	 * @return
	 */
	public boolean userRegister(User user);
}
