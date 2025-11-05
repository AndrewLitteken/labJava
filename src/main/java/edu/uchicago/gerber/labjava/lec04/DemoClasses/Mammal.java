package edu.uchicago.gerber.labjava.lec04.DemoClasses;

public class Mammal extends Animal implements RunningAble, IsLiving {
    public void speak() {
        System.out.println("I am a Mammal");
    }

    public boolean isLiving() {
        return true;
    }

    private int numberOfLegs;
    public Mammal(int numberOfLegs) {
        this.numberOfLegs = numberOfLegs;
    }

    @Override
    public boolean canRun() {return true;}

    public boolean isCat() {
        if (this instanceof Cat) {
            return true;
        }
        return false;
    }
}
