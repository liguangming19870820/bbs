package com.xxt.common.utils;

import java.io.IOException;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.utils.AddrUtil;

public class MemcachedUtils {
	private static MemcachedClient client;
	static {
        try {
        	XMemcachedClientBuilder builder = new XMemcachedClientBuilder(AddrUtil.getAddresses("127.0.0.1:11211"));
			client=builder.build();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void set(String key, String value, int second) {
		try {
			client.set(key, second, value);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public static void set(String key, String value) {
		try {
			client.set(key, 0, value);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public static String get(String key) {
		try {
			return (String)client.get(key);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	public static void delete(String key) {
		try {
			client.delete(key);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
