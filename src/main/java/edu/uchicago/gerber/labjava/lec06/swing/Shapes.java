package edu.uchicago.gerber.labjava.lec06.swing;

import javax.swing.*;
import java.awt.*;

public class Shapes {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        final int FRAME_WIDTH = 300;
        final int FRAME_HEIGHT = 400;

        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("A Simple Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);

        frame.setVisible(true);

        Graphics g = panel.getGraphics();

        g.setColor(Color.GREEN);
        g.drawOval(120, 120, 100, 100);

        g.setColor(Color.RED);
        g.fillOval(100, 10, 60, 100);

        g.setColor(Color.BLACK);

        g.fillRect(10, 10, 60, 100);
        g.drawRect(10, 120, 100, 100);
    }
}
