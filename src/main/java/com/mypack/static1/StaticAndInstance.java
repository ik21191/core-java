package com.mypack.static1;

import org.apache.log4j.Logger;

public class StaticAndInstance {
	private static final Logger log = Logger.getLogger(StaticAndInstance.class);
	private static int count = 100;
	public static void main(String[] args) {

		StaticAndInstance staticAndInstance = new StaticAndInstance();
		staticAndInstance.count = 200;
		log.info(StaticAndInstance.count);
	}

}
