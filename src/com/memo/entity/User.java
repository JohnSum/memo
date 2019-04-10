package com.memo.entity;

public class User {
	public int account; // 账号
	public String nickname; // 名字
	public String password; // 密码
	public String id_num; // 身份证号（关联关联实名认证）
	public int power; // 权限

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int account, String nickname, String password, String id_num, int power) {
		super();
		this.account = account;
		this.nickname = nickname;
		this.password = password;
		this.id_num = id_num;
		this.power = power;
	}

	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId_num() {
		return id_num;
	}

	public void setId_num(String id_num) {
		this.id_num = id_num;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	@Override
	public String toString() {
		return "账号：" + account + ", 昵称：" + nickname + ", 密码：" + password + ", 身份证号：" + id_num + ", 权限：" + power;
	}

}
