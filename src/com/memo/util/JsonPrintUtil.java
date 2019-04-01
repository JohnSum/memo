package com.memo.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

/**
 * Ajax传回数据
 * 
 * @author JohnSum
 *
 */
public class JsonPrintUtil {
	public static void jsonPrint(String result, HttpServletResponse response) {
		try {
			PrintWriter out = response.getWriter();
			out.print(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
