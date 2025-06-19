package creational.factory;

class MobileFactory {
  public static Mobile createMobile(String brandName) {
    if (brandName == null || brandName.equals(""))
      return null;
    if (brandName.equals(Mobile.IPHONE))
      return new Iphone(2, "A9", true);
    else if (brandName.equals(Mobile.ONEPLUS))
      return new OnePlus(3, "A1", true);
    else if (brandName.equals(Mobile.SONY))
      return new Sony(6, "A4");
    else
      return null;
  }
}
