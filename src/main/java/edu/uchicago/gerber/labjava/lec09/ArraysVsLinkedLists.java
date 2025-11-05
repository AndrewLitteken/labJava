package edu.uchicago.gerber.labjava.lec09;

import java.util.*;

public class ArraysVsLinkedLists {
    public static void main(String[] args) {

        LinkedList<Integer> ll = new LinkedList<>();
        ArrayList<Integer> lla = new ArrayList<Integer>();
        HashSet<Integer> lls = new HashSet<Integer>();
        Map<Integer, Double> llm = new HashMap<Integer, Double>();

        long tStart = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            lla.add(i);
        }
        long tEnd = System.currentTimeMillis();
        System.out.println("ArrayList Time: " + (tEnd - tStart));

        tStart = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            ll.add(i);
        }
        tEnd = System.currentTimeMillis();
        System.out.println("LinkedList Time: " + (tEnd - tStart));

        tStart = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            lls.add(i);
        }
        tEnd = System.currentTimeMillis();
        System.out.println("Set Time: " + (tEnd - tStart));

        tStart = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            llm.put(i, Math.sqrt(i));
        }
        tEnd = System.currentTimeMillis();
        //System.out.println("Map Time: " + (tEnd - tStart));

        Random r = new Random();
        tStart = System.currentTimeMillis();
        for (int i = 0; i < 500; i++) {
            int rint = r.nextInt(100000);
            ll.contains(rint);
        }
        tEnd = System.currentTimeMillis();
        System.out.println("LinkedList Time: " + (tEnd - tStart) / 500.0);

        tStart = System.currentTimeMillis();
        for (int i = 0; i < 500; i++) {
            int rint = r.nextInt(100000);
            lla.contains(rint);
        }
        tEnd = System.currentTimeMillis();
        System.out.println("ArrayList Time: " + (tEnd - tStart) / 500.0);

        tStart = System.currentTimeMillis();
        for (int i = 0; i < 500; i++) {
            int rint = r.nextInt(100000);
            lls.contains(rint);
        }
        tEnd = System.currentTimeMillis();
        System.out.println("Set Time: " + (tEnd - tStart) / 500.0);

        for (Integer i : llm.keySet()) {
            System.out.println("Key is: " + i);
            System.out.println("Value is: " + llm.get(i));
            llm.put(i, (double) i);
            System.out.println("Value is: " + llm.get(i));
        }
    }
}
