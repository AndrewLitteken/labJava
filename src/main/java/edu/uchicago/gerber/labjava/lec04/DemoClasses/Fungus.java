package edu.uchicago.gerber.labjava.lec04.DemoClasses;

public class Fungus implements SelfReplicable, IsLiving {

    public boolean isLiving() {
        return true;
    }

    @Override
    public boolean canSelfReplicate() {return true;}
}
