package com.mypack.casting1;
class Animal 
{
    void makeNoise() {System.out.println("generic noise"); }
}
class Dog extends Animal 
{
    void makeNoise() {System.out.println("bark"); }
    void playDead() { System.out.println("roll over"); }
}
class CastTest1 
{
    public static void main(String [] args) {
    Animal [] a = {new Animal(), new Dog(), new Animal() };
    for(Animal animal : a) 
    {
        //animal.makeNoise();
        if(animal instanceof Animal) 
        {
            Dog d = (Dog) animal; // casting the ref. var.
            d.playDead();
        }

        }
    }
}
