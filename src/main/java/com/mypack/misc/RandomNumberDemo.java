package com.mypack.misc;

import java.util.Random;

import org.apache.log4j.Logger;

public class RandomNumberDemo {
	private static final Logger log = Logger.getLogger(RandomNumberDemo.class);

	public static void main(String[] args) {
		Random random = new Random();
		//Generate 5 random numbers
		for(int i = 1; i <= 5; i++) {
			log.info(random.nextInt(10));
		}
	}

}
