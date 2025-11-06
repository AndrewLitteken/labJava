package edu.uchicago.gerber.labjava.lec06.swing.MovingBallComplex;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BallComponent extends JComponent {

    // Bookkeeping for all our relevant UI elements
    JButton startButton;
    JButton advanceButton;
    JButton resetButton;
    JButton submitButton;
    JTextField speedText;
    JTextField angleText;
    Timer t;

    // Bookkeeping for where the ball is in the box
    private double xPos = 0.0;
    private double yPos = 0.0;
    private double xVel = 0.0;
    private double yVel = 0.0;
    private int radius = 10;

    // flag for whether we added a ball or not
    boolean positionSelected = false;


    public BallComponent() {
        // adding our custom listener to draw the ball.
        addMouseListener(new MousePressListener());
        // A timer for our animation later
        t = new Timer(100, new AdvanceButtonListener());
    }

    // The logic for moving the ball around a fixed 500x500 size box.
    public void move(double sec) {
        // Get the new position
        double newX = xPos + xVel * sec;
        // If the left edge of the ball is outside the box to the left
        // adjust the new position to have bounced off the side, then back
        // in for the remainder of the time
        // In other words, we went (-newX) pixels too far to the left, so we want to be
        // -newX pixels to the right
        if (newX - radius <= 0) {
            xPos = radius - newX + radius;
            collideX();
        } else if (newX + radius >= 500) {
            // Repeat the same process here, except we overshot on the right edge.
            xPos = 500 - radius - (newX + radius - 500);
            collideX();
        } else {
            xPos = newX;
        }

        // Performing the same calculations for the top and bottom of the ball with the
        // top or bottom of the box. Notice here we use a -yVel since the coordinates for
        // drawing APIs are flipped from our usual cartesian coordinates.
        double newY = yPos - yVel * sec;
        if (newY - radius <= 0) {
            yPos = radius - newY + radius;
            collideY();
        } else if (newY + radius >= 500) {
            yPos = 500 - radius - (newY + radius - 500);
            collideY();
        } else {
            yPos = newY;
        }
    }

    public void addMovement(double angle, double speed) {
        // Based off of parsed values from the text boxes, recalculate
        // the x and y velocities.
        xVel = speed * Math.cos(Math.toRadians(angle));
        yVel = speed * Math.sin(Math.toRadians(angle));
    }

    // Reverse the direct we are moving because we hit a left or right wall.
    public void collideX() {
        xVel = -xVel;
    }

    // Reverse the direct we are moving because we hit a top or bottom wall.
    public void collideY() {
        yVel = -yVel;
    }

    public void paintComponent(Graphics g) {
        // Paint the box
        g.setColor(Color.WHITE);
        g.fillRect(getCanvasX(), getCanvasY(), 500, 500);
        // If there's no ball location set, exit here
        if (!positionSelected) {
            return;
        }

        // Set the color to black, and draw the ball.
        g.setColor(Color.BLACK);
        int currX = getCanvasX() + (int) xPos;
        int currY = getCanvasY() + (int) yPos;
        g.fillOval( currX - radius,  currY - radius, radius * 2, radius * 2);
    }

    // Given an X value in the frame, recalculate it to be from the persepective
    // of the upper left corner of our canvas
    public int getCanvasX() {
        return getX() + (getWidth() - 500) / 2;
    }

    // Given an Y value in the frame, recalculate it to be from the persepective
    // of the upper left corner of our canvas
    public int getCanvasY() {
        return getY() + (getHeight() - 500) / 2;
    }

    // Bookkeeping methods to have access to all the UI elements
    public void addAdvanceButton(JButton btn) {
        advanceButton = btn;
        btn.addActionListener(new AdvanceButtonListener());
    }

    public void addStartButton(JButton btn) {
        startButton = btn;
        btn.addActionListener(new StartButtonListener());
    }

    public void addResetButton(JButton btn) {
        resetButton = btn;
        btn.addActionListener(new ClearButtonListener());
    }

    public void addChangeAngle(JTextField speed, JTextField angle, JButton btn) {
        submitButton = btn;
        speedText = speed;
        angleText = angle;
        submitButton.addActionListener(new SubmitButtonListener());
    }

    // The listener for the button to start and stop animation
    class StartButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // If the position isn't set, we have nothing to do
            if (!positionSelected) {
                return;
            }
            if (!t.isRunning()) {
                // Start the timer to start animating
                t.start();
                // Change the button text back
                startButton.setText("Stop");
                // Don't allow any buttons to interfere
                advanceButton.setEnabled(false);
                resetButton.setEnabled(false);
                submitButton.setEnabled(false);
            } else  {
                // Stop the timer to stop animating
                t.stop();
                // Change the button text back
                startButton.setText("Start");
                // Allow other buttons to be pressed again
                advanceButton.setEnabled(true);
                resetButton.setEnabled(true);
                submitButton.setEnabled(true);
            }
        }
    }

    // The button used to clear the canvas
    class ClearButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Simply sets the fact that there is no more ball, and
            // redraws
            positionSelected = false;
            repaint();
        }
    }

    // The listener for whenever we want to change the values of the velocity
    class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Parse the values from the text field
            double speed = Double.parseDouble(speedText.getText());
            double angle = Double.parseDouble(angleText.getText());
            // Set the values in the outer class.
            addMovement(angle, speed);
        }
    }

    // The listener for our advance actions (button and timer)
    // whenever this is triggered, move the ball, and redraw the canvas.
    class AdvanceButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            move(0.1);
            repaint();
        }
    }

    // The mouse listener
    class MousePressListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            // Get the location of the mouse in the panel, but adjust it
            // to be calculating the location inside the rectangle we are drawing
            // to represent the box
            int x = e.getX() - getCanvasX();
            int y = e.getY() - getCanvasY();

            // check that our mouse didn't click outside of our box
            if (x < 0 || x > 500 || y < 0 || y > 500) {
                return;
            }

            // If there's already a ball, don't do anything
            if (positionSelected) {
                return;
            }

            // Set the ball positions, then redraw.
            xPos = x;
            yPos = y;
            positionSelected = true;
            repaint();
        }

        public void mousePressed(MouseEvent event) {}

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}
    }
}
