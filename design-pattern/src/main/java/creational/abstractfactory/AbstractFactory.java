package creational.abstractfactory;

import creational.factory.Mobile;

abstract class AbstractFactory {
  abstract Mobile getMobile(String model);
}
