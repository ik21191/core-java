package creational.factory;

public class FactoryPatternDemo {
  public static void main(String arg[]) {
    Mobile iphone = MobileFactory.createMobile("IPhone");
    iphone.mobileBrand();
    Mobile onePlus = MobileFactory.createMobile("OnePlus");
    onePlus.mobileBrand();
    Mobile sony = MobileFactory.createMobile("Sony");
    sony.mobileBrand();
  }
}
