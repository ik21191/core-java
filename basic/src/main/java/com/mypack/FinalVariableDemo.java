package com.mypack;

import java.util.List;
class ClassWithFinalVariable{
//Without constructor it will show compile time error because the final value must be initialized
  final String name;
  public ClassWithFinalVariable(String name) {
    this.name = name;
  }
}
public class FinalVariableDemo {

  final static List<String> list = null;

  public static void main(String[] args) {
    ClassWithFinalVariable classWithFinalVariable = new ClassWithFinalVariable("Imrann Khan");
    System.out.println(classWithFinalVariable.name);
    //list=new ArrayList<String>();//You can not assign object to this final variable
  }
}
