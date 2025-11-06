package edu.uchicago.gerber.labjava.lec06.swing.MovingBallComplex;

import javax.swing.*;

public class MovingBallViewer {
    public static void main(String[] args) {
        // Create the frame
        JFrame rf = new JFrame();
        rf.setSize(600, 800);
        // Add the controller (which contains the ball view to the frame)
        rf.add((new ControllerComponent()).getMainPanel());
        rf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rf.setVisible(true);
    }
}
