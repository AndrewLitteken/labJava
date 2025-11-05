package edu.uchicago.gerber.labjava.lec04.DemoClasses;

import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.speak();

        Cat c = new Cat();
        c.speak();

        //Mammal m = new Mammal();

        Mammal m2 = d;
        //m.speak();
        m2.speak();

        System.out.println(m2.isCat());
        System.out.println(m2.isMammal());
        System.out.println(c.isCat());
        System.out.println(c.isMammal());

        SelfReplicable sr = new Fungus();
        RunningAble ra = c;

        ArrayList<IsLiving> living = new ArrayList<IsLiving>();

        living.add(new Fungus());
        living.add(new Cat());
        living.add(new Dog());

    }
}
