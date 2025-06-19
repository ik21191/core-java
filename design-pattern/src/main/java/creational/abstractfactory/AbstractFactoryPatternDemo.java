package creational.abstractfactory;

import creational.factory.Mobile;

public class AbstractFactoryPatternDemo {
  public static void main(String[] args) {
    AbstractFactory androidFactory = FactoryProducer.getFactory("android");
    Mobile oneplus = androidFactory.getMobile("Oneplus");
    oneplus.mobileBrand();
    Mobile sony = androidFactory.getMobile("Sony");
    sony.mobileBrand();
    AbstractFactory appleFactory = FactoryProducer.getFactory("apple");
    Mobile iphone = appleFactory.getMobile("iphone");
    iphone.mobileBrand();
  }
}
