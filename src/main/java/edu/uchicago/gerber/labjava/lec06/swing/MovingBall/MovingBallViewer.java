package edu.uchicago.gerber.labjava.lec06.swing.MovingBall;

import edu.uchicago.gerber.labjava.lec06.swing.ShapeComponent;

import javax.swing.*;

import static java.lang.Thread.sleep;

public class MovingBallViewer {
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame();
        final int FRAME_WIDTH = 400;
        final int FRAME_HEIGHT = 400;

        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("Moving Ball");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        MovingBallComponent mbc = new MovingBallComponent();
        frame.add(mbc);

        frame.setVisible(true);
        sleep(3000);

        mbc.start();
    }
}
