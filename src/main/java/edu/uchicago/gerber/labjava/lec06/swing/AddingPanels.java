package edu.uchicago.gerber.labjava.lec06.swing;

import javax.swing.*;

public class AddingPanels {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        final int FRAME_WIDTH = 300;
        final int FRAME_HEIGHT = 400;

        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("A Simple Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JTextArea jt1 = new JTextArea("This is some text added to the panel");
        jt1.setEditable(false);
        JTextArea jt2 = new JTextArea("This is some text that will also be added to the panel");
        jt2.setEditable(false);
        panel.add(jt1);
        panel.add(jt2);
        frame.add(panel);

        frame.setVisible(true);
    }
}
