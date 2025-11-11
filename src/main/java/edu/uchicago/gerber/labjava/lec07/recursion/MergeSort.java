package edu.uchicago.gerber.labjava.lec07.recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class MergeSort {

    public static ArrayList<Integer> recursiveMerge(ArrayList<Integer> arr, int start, int end) {
        if (start == end) {
            ArrayList<Integer> a = new ArrayList<>();
            a.add(arr.get(start));
            System.out.println("Start value: " + start + " " + end);
            System.out.println("Array: " + a);
            return a;
        }

        int mid = (end - start) / 2;
        if (end - start == 1) {
            mid = start;
        }

        ArrayList<Integer> frontHalf = recursiveMerge(arr, start, mid);
        ArrayList<Integer> backHalf = recursiveMerge(arr, mid + 1, end);

        int frontHalfIdx = 0;
        int backHalfIdx = 0;

        ArrayList<Integer> a = new ArrayList<>();
        while (frontHalfIdx < frontHalf.size() || backHalfIdx < backHalf.size()) {
            if (frontHalfIdx == frontHalf.size()) {
                a.add(backHalf.get(backHalfIdx++));
                continue;
            }

            if (backHalfIdx == backHalf.size()) {
                a.add(frontHalf.get(frontHalfIdx++));
                continue;
            }

            if (frontHalf.get(frontHalfIdx) <= backHalf.get(backHalfIdx)) {
                a.add(frontHalf.get(frontHalfIdx++));
            } else {
                a.add(backHalf.get(backHalfIdx++));
            }
        }

        System.out.println("Start value: " + start + " " + end);
        System.out.println("Array: " + a);
        return a;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nums = scanner.nextLine();
        String[] numArr = nums.split(" ");
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < numArr.length; i++) {
            list.add(Integer.parseInt(numArr[i]));
        }

        System.out.println("End: " + recursiveMerge(list, 0, list.size() - 1));
    }
}
