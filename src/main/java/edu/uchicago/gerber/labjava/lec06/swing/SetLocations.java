package edu.uchicago.gerber.labjava.lec06.swing;

import javax.swing.*;
import java.awt.*;

public class SetLocations {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        final int FRAME_WIDTH = 300;
        final int FRAME_HEIGHT = 400;

        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("A Simple Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        JComponent jLabel1 = new JLabel("Label 1");
        jLabel1.setBounds(new Rectangle(new Point(50, 100), jLabel1.getPreferredSize()));
        JComponent jLabel2 = new JLabel("Label 2");
        jLabel2.setBounds(new Rectangle(new Point(100, 200), jLabel2.getPreferredSize()));

        panel.add(jLabel1);
        panel.setLayout(null);
        panel.add(jLabel2);

        frame.add(panel);

        frame.setVisible(true);
    }
}
