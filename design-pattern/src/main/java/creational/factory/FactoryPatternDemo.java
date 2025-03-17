package creational.factory;

public class FactoryPatternDemo {
	public static void main(String arg[]) {
		Mobile mobile1 = MobileFactory.createMobile("IPhone");
		mobile1.mobileBrand();
		Mobile mobile2 = MobileFactory.createMobile("OnePlus");
		mobile2.mobileBrand();
		Mobile mobile3 = MobileFactory.createMobile("Sony");
		mobile3.mobileBrand();
	}
}