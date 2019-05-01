package com.memo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memo.dao.UserMapper;
import com.memo.entity.User;
import com.memo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public boolean selectUserByAccount(String account) {
		if (userMapper.selectUserByAccount(account) >= 1) {
			return true;
		}
		return false;
	}

	@Override
	public User userLogin(String account, String password) {
		return userMapper.selectUser(account, password);
	}

	@Override
	public boolean changePsw(String account, String newPsw) {
		if(userMapper.changePsw(account, newPsw) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean userRegister(User user) {
		if(userMapper.addUser(user) > 0) {
			return true;
		}
		return false;
	}

}
