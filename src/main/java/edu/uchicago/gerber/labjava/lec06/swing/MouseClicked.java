package edu.uchicago.gerber.labjava.lec06.swing;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseClicked extends JPanel {

    public MouseClicked() {
        this.addMouseListener(new MousePressListener());
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        final int FRAME_WIDTH = 300;
        final int FRAME_HEIGHT = 400;

        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("A Simple Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new MouseClicked();
        frame.add(panel);

        frame.setVisible(true);
    }

    class MousePressListener implements MouseListener {
        private int prevX =  0;
        private int prevY = 0;
        @Override
        public void mouseClicked(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            System.out.println("Distance " + Math.sqrt(Math.pow(x - prevX, 2)
                    + Math.pow(y - prevY, 2)));
            prevX = x;
            prevY = y;
        }
        public void mousePressed(MouseEvent event) {
            System.out.println("Mouse pressed");
        }
        @Override
        public void mouseReleased(MouseEvent e) {
            System.out.println("Mouse released");
        }
        @Override
        public void mouseEntered(MouseEvent e) {
            System.out.println("Mouse entered");
        }
        @Override
        public void mouseExited(MouseEvent e) {
            System.out.println("Mouse exited");
        }
    }

}
