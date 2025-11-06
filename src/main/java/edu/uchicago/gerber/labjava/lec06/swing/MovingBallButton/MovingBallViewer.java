package edu.uchicago.gerber.labjava.lec06.swing.MovingBallButton;

import javax.swing.*;

import java.awt.*;

import static java.lang.Thread.sleep;

public class MovingBallViewer {
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame();
        final int FRAME_WIDTH = 400;
        final int FRAME_HEIGHT = 400;

        JPanel panel = new JPanel();
        JButton button = new JButton("Move Ball");
        MovingBallComponent mbc = new MovingBallComponent();
        mbc.setPreferredSize(new Dimension(400, 400));
        panel.add(button);
        JPanel ballPanel = new JPanel();
        ballPanel.add(mbc);
        mbc.addButton(button);
        panel.add(ballPanel);
        frame.add(panel);

        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("Moving Ball");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
}
