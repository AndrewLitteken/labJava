package edu.uchicago.gerber.labjava.lec02.car_example;

import edu.uchicago.gerber.labjava.lec02.car_example.Car;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String make = scanner.nextLine();
        String model = scanner.nextLine();
        String color = scanner.nextLine();
        int year = scanner.nextInt();
        scanner.nextLine();
        String liscensePlate = scanner.nextLine();

        Car c = new Car(make, model, year, color, liscensePlate);
    }
}
