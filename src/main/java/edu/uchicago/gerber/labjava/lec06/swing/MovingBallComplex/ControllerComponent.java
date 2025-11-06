package edu.uchicago.gerber.labjava.lec06.swing.MovingBallComplex;

import javax.swing.*;
import java.awt.*;

public class ControllerComponent {
    private JPanel upperPanel;
    private JPanel lowerPanel;
    private JPanel buttonPanel;
    private JPanel infoPanel;
    private JTextField speedText;
    private JTextField angleText;
    private JButton submitButton;
    private JButton resetButton;
    private JButton startButton;
    private JButton stepButton;
    private JPanel mainPanel;

    BallComponent bc;

    public ControllerComponent() {
        bc = new BallComponent();
        // Give the ball location calculator access to the buttons
        // so it is able to set up listeners
        bc.addAdvanceButton(stepButton);
        bc.addStartButton(startButton);
        bc.addResetButton(resetButton);
        bc.addChangeAngle(speedText, angleText, submitButton);

        // Use layout to ensure that the panel holding the viewer knows to center
        // the box in the middle of the frame.
        upperPanel.setLayout(new GridLayout(1, 1));
        upperPanel.add(bc, BorderLayout.CENTER);
    }

    // Get around the interference of using the WYSIWYG editor.
    public JPanel getMainPanel() {
        return mainPanel;
    }
}
