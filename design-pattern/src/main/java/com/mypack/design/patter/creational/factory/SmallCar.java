package com.mypack.design.patter.creational.factory;

import org.apache.log4j.Logger;

public class SmallCar extends Car {
	
	private static final Logger log = Logger.getLogger(SmallCar.class);

	public SmallCar() {
		construct();
	}
	
	@Override
	protected void construct() {
		log.info("SmallCar created.");

	}

}
