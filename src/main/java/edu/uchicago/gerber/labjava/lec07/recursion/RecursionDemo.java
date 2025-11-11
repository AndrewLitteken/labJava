package edu.uchicago.gerber.labjava.lec07.recursion;

public class RecursionDemo {
    public static void testRecursion(int i) {
        if (i == 0) {
            return;
        }
        System.out.println(i);
        testRecursion(--i);
    }

    public static void main(String[] args) {
        testRecursion(100);
    }
}
