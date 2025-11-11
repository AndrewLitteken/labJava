package edu.uchicago.gerber.labjava.lec07.recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class BubbleSort {

    public static void recursiveBubbleSort(ArrayList<Integer> arr, int start) {
        if (start == arr.size() - 1) {
            System.out.println("Start value: " + start + " " + arr);
            return;
        }

        int curr =  arr.get(start);
        recursiveBubbleSort(arr, start + 1);

        for (int i = start + 1; i < arr.size(); i++) {
            int rightVal = arr.get(i);
            if (curr > rightVal) {
                arr.set(i, curr);
                arr.set(i - 1, rightVal);
            }
        }

        System.out.println("Start value: " + start + " " + arr);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nums = scanner.nextLine();
        String[] numArr = nums.split(" ");
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < numArr.length; i++) {
            list.add(Integer.parseInt(numArr[i]));
        }

        recursiveBubbleSort(list, 0);
    }
}
