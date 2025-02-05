package creational.factory;

import org.apache.log4j.Logger;

public class LuxuryCar extends Car {
	
	private static final Logger log = Logger.getLogger(LuxuryCar.class);

	public LuxuryCar() {
		construct();
	}
	
	@Override
	protected void construct() {
		log.info("Luxury card created.");
	}
}
