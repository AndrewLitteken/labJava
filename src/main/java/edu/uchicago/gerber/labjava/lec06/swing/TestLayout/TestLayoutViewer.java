package edu.uchicago.gerber.labjava.lec06.swing.TestLayout;

import edu.uchicago.gerber.labjava.lec06.swing.ListAppender;

import javax.swing.*;

public class TestLayoutViewer {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        final int FRAME_WIDTH = 300;
        final int FRAME_HEIGHT = 400;

        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("A Simple Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = (new TestLayout()).getMainPanel();
        frame.add(panel);

        frame.setVisible(true);
    }
}
