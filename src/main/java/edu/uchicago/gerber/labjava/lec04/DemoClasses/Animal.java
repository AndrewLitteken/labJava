package edu.uchicago.gerber.labjava.lec04.DemoClasses;

public abstract class Animal {
    public abstract void speak();

    public boolean isMammal() {
        if (this instanceof Mammal) {
            return true;
        }
        return false;
    }
}
