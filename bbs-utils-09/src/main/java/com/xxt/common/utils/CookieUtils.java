package com.xxt.common.utils;

import javax.servlet.http.Cookie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils {

	public static int EXPIRE_TIME_DEFAULT = 1 * 60 * 60 * 24;
	
	public static void addCookie(HttpServletResponse response, String name, String value) {
		Cookie cookie = new Cookie(name, value);
		cookie.setPath("/");
		response.addCookie(cookie);
	}
	
	public static void addCookie(HttpServletResponse response, String name, String value, int second) {
		Cookie cookie = new Cookie(name, value);
		if (second == 0) {
			cookie.setMaxAge(EXPIRE_TIME_DEFAULT);
		} else {
			cookie.setMaxAge(second);
		}
		cookie.setPath("/");
		response.addCookie(cookie);
	}
	
	public static String getCookie(HttpServletRequest request, String name) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals(name)) {
					return c.getValue();
				}
			}
		}
		return null;
	}
	
	public static void deleteCookie(HttpServletRequest request, HttpServletResponse response, String name) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals(name)) {
					Cookie cookie = new Cookie(name,"");
					cookie.setPath("/");
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
		}
	}
}
