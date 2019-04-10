package com.memo.dao;

import org.apache.ibatis.annotations.Param;

import com.memo.entity.User;

public interface UserMapper {
	/**
	 * 1、根据账号查询用户
	 * 
	 * @param account
	 * @return
	 */
	public int selectUserByAccount(@Param("account") int account);

	/**
	 * 2、根据账号+密码查询用户
	 * 
	 * @param account
	 * @param password
	 * @return
	 */
	public User selectUser(@Param("account") int account, @Param("password") String password);

	/**
	 * 3、修改密码
	 * 
	 * @param account
	 * @param newPsw
	 * @return
	 */
	public int changePsw(@Param("account") int account, @Param("newPsw") String newPsw);

	/**
	 * 4、添加用户
	 * 
	 * @param user
	 * @return
	 */
	public int addUser(@Param("user") User user);
}
