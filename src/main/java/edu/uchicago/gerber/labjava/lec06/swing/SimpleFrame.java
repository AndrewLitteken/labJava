package edu.uchicago.gerber.labjava.lec06.swing;

import javax.swing.*;

public class SimpleFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        final int FRAME_WIDTH = 300;
        final int FRAME_HEIGHT = 400;

        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("A Simple Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new JTextArea("This is some text added to the frame"));
        frame.add(new JTextArea("Only the last thing added is in the frame"));

        frame.setVisible(true);
    }
}
