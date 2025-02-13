package creational.abstractfactory;

import creational.factory.Mobile;
import creational.factory.OnePlus;
import creational.factory.Sony;

class AndroidMobileFactory extends AbstractFactory {
	@Override
	public Mobile getMobile(String brand) {
		if (brand.equalsIgnoreCase("Oneplus")) {
			return new OnePlus();
		} else if (brand.equalsIgnoreCase("Sony")) {
			return new Sony();
		}
		return null;
	}
}
