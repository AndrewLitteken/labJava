package edu.uchicago.gerber.labjava.lec06.swing;

import javax.swing.*;

import java.awt.*;

import static java.lang.Thread.sleep;

public class PersonViewer {
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame();
        final int FRAME_WIDTH = 300;
        final int FRAME_HEIGHT = 400;

        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("A Simple Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PersonComponent pc = new PersonComponent(150, 25);
        pc.setScale(1.75);
        frame.add(pc);

        frame.setVisible(true);

        sleep(3000);
        pc.setScale(0.5);
        Graphics g = frame.getGraphics();
        pc.paintComponent(g);
    }
}
