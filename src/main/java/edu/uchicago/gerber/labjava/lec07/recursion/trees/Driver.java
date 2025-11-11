package edu.uchicago.gerber.labjava.lec07.recursion.trees;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nums = scanner.nextLine();
        String[] numArr = nums.split(" ");
        Node<Integer> headNode = new Node(Integer.parseInt(numArr[0]));
        for (int i = 1; i < numArr.length; i++) {
            headNode.add(Integer.parseInt(numArr[i]));
        }

        System.out.println(headNode.getInOrderString());

        int num = scanner.nextInt();
        System.out.println(headNode.contains(num));
    }
}
