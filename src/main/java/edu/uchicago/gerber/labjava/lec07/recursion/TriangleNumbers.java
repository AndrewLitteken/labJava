package edu.uchicago.gerber.labjava.lec07.recursion;

import java.util.Scanner;

public class TriangleNumbers {

    public static int getIthTriNumber(int i) {
        if (i == 1) {
            return 1;
        }

        return getIthTriNumber(i - 1) + i;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Which triangle number: ");
        int n = scanner.nextInt();

        System.out.println("Number: " + getIthTriNumber(n));
    }
}
