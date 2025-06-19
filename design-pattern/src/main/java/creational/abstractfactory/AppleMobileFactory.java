package creational.abstractfactory;

import creational.factory.Mobile;
import creational.factory.Iphone;

class AppleMobileFactory extends AbstractFactory {
  @Override
  public Mobile getMobile(String model) {
    if (model.equalsIgnoreCase("iphone")) {
      return new Iphone();
    }
    return null;
  }
}
