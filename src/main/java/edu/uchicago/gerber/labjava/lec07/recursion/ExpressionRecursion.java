package edu.uchicago.gerber.labjava.lec07.recursion;

import java.util.Scanner;

public class ExpressionRecursion {
    static String current;

    public static int parseFactor() {
        if (current.charAt(0) =='(') {
            int closeParen = 1;
            int stack = 0;
            // While looking for the last close parenthesis, for every open paren we see,
            // increase the count, and check that we see the same number of closing parentheses.
            while (closeParen < current.length() && (current.charAt(closeParen) != ')' || stack != 0)) {
                if  (current.charAt(closeParen) == '(') {
                    stack++;
                }
                if  (current.charAt(closeParen) == ')') {
                    stack--;
                }
                closeParen++;
            }

            // Get the substring of the values inside the parentheses to recurse on
            String s = current.substring(1, closeParen);
            // Save the current string so we can start from the end of the parentheses in the next
            // iteration.
            String old = current;
            current = s;
            int val = parseExpression();
            // Make sure we start after the close parentheses of this factor
            current = old.substring(s.length()+2);
            return val;
        }

        String num = "";
        int index = 0;
        // While we are finding parts of the number and not an operator.
        while (index < current.length() && current.charAt(index) != '+' && current.charAt(index) != '-' &&
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
                val += parseTerm();
            } else if (c == '-') {
                current = current.substring(idx);
                val -= parseTerm();
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
