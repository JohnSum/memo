package com.memo.util;

import java.security.MessageDigest;

/**
 * MD5数据加密工具类
 * 
 * @author 廖明兴
 *
 */
public class MD5Util {
	/**
	 * 数据加密入口
	 * 
	 * @param password
	 * @return
	 */
	public static String getMd5(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes("utf-8"));
			byte[] bytes = md.digest(password.getBytes("utf-8"));
			return toHex(bytes);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 转换为十六进制
	 * 
	 * @param bytes
	 * @return
	 */
	private static String toHex(byte[] bytes) {
		final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
		StringBuilder ret = new StringBuilder(bytes.length * 2);
		for (int i = 0; i < bytes.length; i++) {
			ret.append(HEX_DIGITS[(bytes[i] >> 4) & 0x0f]);
			ret.append(HEX_DIGITS[bytes[i] & 0x0f]);
		}
		return "ME" + ret.toString() + "MO";
	}
}
