package com.mypack.design.patter.creational.factory;

import org.apache.log4j.Logger;

public class SedanCar extends Car {
	private static final Logger log = Logger.getLogger(SedanCar.class);
	
	public SedanCar() {
		construct();
	}

	@Override
	protected void construct() {
		log.info("SedanCar created.");

	}

}
