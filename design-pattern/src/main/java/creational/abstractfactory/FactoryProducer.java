package creational.abstractfactory;

class FactoryProducer {
	public static AbstractFactory getFactory(String factory) {
		if ("apple".equalsIgnoreCase(factory)) {
			return new AppleMobileFactory();
		} else if("android".equalsIgnoreCase(factory)){
			return new AndroidMobileFactory();
		} else {
			throw new RuntimeException("No such factory");
		}
	}
}