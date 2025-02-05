package creational.factory;

import org.apache.log4j.Logger;

public class FactoryDemo {
	private static final Logger log = Logger.getLogger(FactoryDemo.class);
	
	public static void main(String arr[]) {
		Car luxuryCar = CarFactory.buildCar(CarType.LUXURY);
		log.info(luxuryCar);
		Car smallCar = CarFactory.buildCar(CarType.SMALL);
		log.info(smallCar);
		Car sedanCar = CarFactory.buildCar(CarType.SEDAN);
		log.info(sedanCar);
	}
}
