package com.xxt.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class IDUtils {

	public static String getId() {
		String format = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
		//随机三位数
		Random r = new Random();
		// n 1000   0-999   99
		for(int i=0 ; i<3 ;i++){
			format += r.nextInt(10);
		}
		return format;
	}
}
