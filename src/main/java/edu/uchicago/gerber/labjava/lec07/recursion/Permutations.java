package edu.uchicago.gerber.labjava.lec07.recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class Permutations {
    public static ArrayList<String> findPermutations(String str) {
        ArrayList<String> result = new ArrayList<>();

        if (str.length() == 1) {
            result.add(str);
            return result;
        }

        for (int i = 0; i < str.length(); i++) {
            String s = str.substring(0, i);
            String t = str.substring(i+1);
            String newString = s + t;
            ArrayList<String> tempList = findPermutations(newString);
            String c = str.substring(i, i+1);
            for (String v : tempList) {
                result.add(c + v);
            }
        }
        ArrayList<String> list = new ArrayList<>();
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String string = scanner.nextLine();

        for (String s : findPermutations(string)) {
            System.out.println(s);
        }
    }
}
