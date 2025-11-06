package edu.uchicago.gerber.labjava.lec06.swing.MovingBallButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovingBallComponent extends JComponent {
    public int x = 200;
    public int y = 200;
    public int baseY = 200;
    public int angle = 0;
    Timer timer;

    public void paintComponent(Graphics g) {
        System.out.println(x + " " + y + " " + baseY + " " + angle);
        g.drawOval(x - 25, y - 25, 50, 50);
    }

    public void move() {
        System.out.println("Moving Ball");
        angle += 1;
        angle %= 360;
        y = baseY + (int) (Math.sin(Math.toRadians(angle)) * 100);
        repaint();
    }

    class MoveListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            move();
        }
    }

    public void addButton(JButton button) {
        button.addActionListener(new MoveListener());
    }
}
