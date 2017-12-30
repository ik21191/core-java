package com.mypack.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormat1 {
	public static void main(String[] arr) {
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	}
}
