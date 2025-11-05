package edu.uchicago.gerber.labjava.lec02.car_example;

import edu.uchicago.gerber.labjava.lec02.Convert;
import edu.uchicago.gerber.labjava.lec03._simplepoly._2_Rectangle_Example;

public class Car {
    private String make;
    private String model;
    private int year;
    private String color;
    private String liscensePlate;

    public Car(String make, String model, int year, String color, String liscensePlate) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.liscensePlate = liscensePlate;
    }

    public String toString() {
        return "I am a " + color + " " + make + " " + model + " " + year + " " + " with liscense plate " + liscensePlate;
    }
}
