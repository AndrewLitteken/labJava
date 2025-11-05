package edu.uchicago.gerber.labjava.lec06.swing.MovingBall;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovingBallComponent extends JPanel {
    public int x = 200;
    public int y = 200;
    public int baseY = 200;
    public int angle = 0;
    Timer timer;

    public void paintComponent(Graphics g) {
        g.drawOval(x - 25, y - 25, 50, 50);
    }

    public void move() {
        angle += 1;
        angle %= 360;
        y = baseY + (int) (Math.sin(Math.toRadians(angle)) * 100);
        repaint();
    }

    class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            move();
        }
    }

    public void start() {
        Timer timer = new Timer(10, new TimerListener());
        timer.start();
    }
}
