package edu.uchicago.gerber.labjava.lec07.recursion;

import java.util.Scanner;

public class ExpressionRecursion {
    static String current;

    public static int parseFactor() {
        if (current.charAt(0) =='(') {
            int closeParen = 1;
            while (current.charAt(closeParen) != ')') {
                closeParen++;
            }

            String s = current.substring(1, closeParen);
            String old = current;
            current = s;
            int val = parseExpression();
            current = old.substring(s.length());
            return val;
        }

        String num = "";
        int index = 0;
        while (current.charAt(index) != '+' && current.charAt(index) != '-' &&
                current.charAt(index) != '*' && current.charAt(index) != '/') {
            index++;
        }

        int val = Integer.parseInt(current.substring(0, index));
        current = current.substring(index);
        return val;
    }

    public static int parseTerm() {
        int val = parseFactor();

        boolean done = false;
        int idx = 0;
        while (!done) {
            if (current.isEmpty()) {
                break;
            }

            char c = current.charAt(idx++);
            if (c == '*') {
                current = current.substring(idx);
                val *= parseFactor();
            } else if (c == '/') {
                current = current.substring(idx);
                val /= parseFactor();
            } else {
                done = true;
            }
        }

        return val;
    }

    public static int parseExpression() {
        int val = parseTerm();

        boolean done = false;
        int idx = 0;
        while (!done) {
            if (current.isEmpty()) {
                break;
            }

            char c = current.charAt(idx++);
            if (c == '+') {
                current = current.substring(idx);
                val += parseFactor();
            } else if (c == '-') {
                current = current.substring(idx);
                val -= parseFactor();
            } else {
                done = true;
            }
        }

        return val;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter expression or (e)xit: ");
        while (scanner.hasNext()) {
            String s = scanner.next();
            if (s.equals("e")) {
                break;
            }

            current = s;
            int val = parseExpression();
            System.out.println(val);

            System.out.print("Enter expression or (e)xit: ");
        }
    }
}
