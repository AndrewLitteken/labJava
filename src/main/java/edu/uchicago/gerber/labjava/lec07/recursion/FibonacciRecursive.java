package edu.uchicago.gerber.labjava.lec07.recursion;

import java.util.HashMap;
import java.util.Scanner;

public class FibonacciRecursive {

    static HashMap<Integer, Integer> cache = new HashMap<>();

    public static int getNthItem(int i) {
        if (i == 1) {
            return 1;
        }

        if (i == 2) {
            return 1;
        }

        if (cache.containsKey(i)) {
            return cache.get(i);
        }


        int result = getNthItem(i - 1) + getNthItem(i - 2);
        cache.put(i, result);
        return result;
    }

    public static int getNthItemIterative(int i) {
        int prev = 1;
        int curr = 1;

        if (i <= 2) {
            return 1;
        }

        for (int j = 3; j <= i; j++) {
            int temp = curr;
            curr = curr + prev;
            prev = temp;
        }

        return curr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("get element (r)ecursive, get element (i)terative, (c)heck element, or (e)xit: ");
        while (sc.hasNext()) {
            String s = sc.next();
            if (s.equals("r")) {
                System.out.print("Which element of the fibonacci sequence would you like to find: ");
                int i = sc.nextInt();
                int val = getNthItem(i);
                System.out.println("The " + i + "th element is " + val);
            } if (s.equals("i")) {
                System.out.print("Which element of the fibonacci sequence would you like to find: ");
                int i = sc.nextInt();
                int val = getNthItemIterative(i);
                System.out.println("The " + i + "th element is " + val);
            } else if (s.equals("c")) {
                System.out.print("What number do you want to see is in the sequence: ");
                int i = sc.nextInt();
                boolean exists = true;//existsInSequence(i);
                if (exists) {
                    System.out.println(i + " exists in the sequence.");
                } else {
                    System.out.println(i + " does not exist in the sequence.");
                }
            } else if (s.equals("e")) {
                break;
            }

            System.out.print("get element (r)ecursive, get element (i)terative, (c)heck element, or (e)xit: ");
        }
    }
}
