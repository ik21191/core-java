package interfaces.changes;

interface Interface1 {

  /* Java8 default method */
  default void method1() {
    System.out.println("method1() of Interface1");
  }

  /* Java8 static method */
  static void staticMethod() {
    System.out.println("staticMethod() of Interface1");
  }

  default void log(String log) {
    System.out.println(log);
  }
}


interface Interface2 {
  default void method2() {
    System.out.println("method2() of Interface2");
  }

  default void log(String log) {
    System.out.println(log);
  }
}


class Implementor implements Interface1, Interface2 {
  /* If you don't provide implementation of log method then compiler will give compilation error */
  public void log(String log) {
    System.out.println(log);
    Interface2.super.method2();
  }

  @Override
  public void method1() {
    System.out.println("method1() in Implementor");
  }

  @Override
  public boolean equals(Object obj) {
    return false;
  }
}

public class InterfaceChangeDemo {

  public static void main(String[] args) {
    Implementor implementor = new Implementor();
    implementor.method1();
    implementor.log("This is log message.");

    Interface1.staticMethod();
  }

}
