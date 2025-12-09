package com.mypack.io.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.apache.log4j.Logger;

public class SerializeDeserializeDemo {
  private static final Logger log = Logger.getLogger(SerializeDeserializeDemo.class);
  
  public static void serialize(String fileName) throws Exception {
    Address a1 = new Address("Shalimar Bagh");
    Person p1 = new Person("Imran Khan", a1);
    
    Person.staticField = "Static field 1";
    
    FileOutputStream out = new FileOutputStream(fileName);
    ObjectOutputStream objectOut = new ObjectOutputStream(out);

    log.info("Serializing object state...........");
    log.info("Before Serialization : hashCode() : " + p1.hashCode());
    objectOut.writeObject(p1);
    log.info("Saved.");

    objectOut.close();
    out.close();
  }
  
  public static void deSerialize(String fileName) throws Exception {
    FileInputStream in = new FileInputStream(fileName);
    ObjectInputStream inObject = new ObjectInputStream(in);
    
    Person p = (Person) inObject.readObject();
    
    log.info("After DeSerialization : hashCode() : " + p.hashCode());
    log.info(p);
    inObject.close();
    in.close();
  }
  public static void main(String[] args) throws Exception {
    //Serializing Person
    serialize("d://object.ser");
    //DeSerializing Person
    deSerialize("d://object.ser");
  }
}

class Person implements Serializable {
  private static final long serialVersionUID = 123456780L;

  private static final Logger log = Logger.getLogger(Person.class); 
  private Address add;
  private String name;
  /***
   * Static field is not serialized because it belongs to class not the object.
   */
  public static String staticField;
  
  
  public Person() {
      log.info("Person() default constructor is called.");
  }

  public Person(String name, Address add) {
      this.name = name;
      this.add = add;
      System.out.println("Person Parameterized consturtor is called ");
  }

  public String toString() {
      log.info("toString() is called");
      return "Person Name: " + name + "\tPerson Address: " + add.name + "\t staticField : " + staticField;
  }
  
  // implement readResolve method
  protected Object readResolve() {
    System.out.println("\n::::::::::::::::::: readResolve() method is called. ::::::::::::::::\n");
    return this; 
  }
}

class Address implements Serializable {
  private static final Logger log = Logger.getLogger(Address.class); 
  private static final long serialVersionUID = 3344556789L;

  String name;
  
  public Address() {
      log.info("Address() default constructor is callled.");
  }

  public Address(String name) {
      this.name = name;
  }
}