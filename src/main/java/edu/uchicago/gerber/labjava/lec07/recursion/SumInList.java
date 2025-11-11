package edu.uchicago.gerber.labjava.lec07.recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class SumInList {
    public static boolean sumInList(ArrayList<Integer> list, int start, int sum) {
        if (sum == 0) {
            return true;
        } else if (sum < 0) {
            return false;
        } else if (start ==  list.size()) {
            return false;
        }

        int val = list.get(start);

        System.out.print("start: " +  start + " sum: " +  sum + ": ");
        for (int i = start; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        boolean include = sumInList(list, start + 1, sum - val);
        boolean exclude = sumInList(list, start + 1, sum);
        System.out.println("start: " +  start + " sum: " +  sum + ": " + (include || exclude));

        return include || exclude;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nums = scanner.nextLine();
        String[] numArr = nums.split(" ");
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < numArr.length; i++) {
            list.add(Integer.parseInt(numArr[i]));
        }

        int sum = scanner.nextInt();

        System.out.println(sumInList(list, 0, sum));
    }

}
