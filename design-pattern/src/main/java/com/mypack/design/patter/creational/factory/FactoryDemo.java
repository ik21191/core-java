package com.mypack.design.patter.creational.factory;

import org.apache.log4j.Logger;

public class FactoryDemo {
	private static final Logger log = Logger.getLogger(FactoryDemo.class);
	
	public static void main(String arr[]) {
		LuxuryCar luxuryCar = (LuxuryCar)CarFactory.buildCar(CarType.LUXURY);
		log.info(luxuryCar);
		SmallCar smallCar = (SmallCar)CarFactory.buildCar(CarType.SMALL);
		log.info(smallCar);
		SedanCar sedanCar = (SedanCar)CarFactory.buildCar(CarType.SEDAN);
		log.info(sedanCar);
	}
}
