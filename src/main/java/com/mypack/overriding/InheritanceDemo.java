package com.mypack.overriding;

class Y extends com.mypack.misc.Parent {
    
}
public class InheritanceDemo {
    public static void main(String arr[]) {
        Parent p = new Parent();
        Y y = new Y();
        //y.pass();//You can only call this method if child class override it
        //p.pass();
    }
}
