package edu.uchicago.gerber.labjava.lec04.DemoClasses;

public class Cat extends Mammal{
    String breed;

    public Cat() {
        super(4);
    }

    public Cat(int numberOfLegs, String breed) {
        super(numberOfLegs);
        this.breed = breed;
    }

    @Override
    public void speak() {
        speak();
        System.out.println("Meow");
    }
}
