package edu.uchicago.gerber.labjava.lec06.swing;

import javax.swing.*;
import java.awt.*;

public class PersonComponent extends JComponent {

    private double scale = 1.0;
    private int x;
    private int y;

    public PersonComponent(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

    @Override
    protected void paintComponent(Graphics g) {
        int r = (int) (25 * scale);
        int headx = x - r;
        int armLength = (int) (55 * scale);
        int armXLength = (int) (Math.sqrt(Math.pow(armLength, 2) / 2));
        int armYLength = armXLength;
        int armYStart = y + 2 * r + 4 * r / 3;
        int armLeftStart = headx;
        int armRightStart = armLeftStart + 2 * r;

        int legLength = (int) (75 * scale);
        int legXLength = (int) (Math.sqrt(Math.pow(legLength, 2) / 2));
        int legYLength = legXLength;
        int legYStart = y + 6 * r;
        int legLeftStart = headx;
        int legRightStart = legLeftStart + 2 * r;

        g.drawOval(headx, y, 2 * r, 2 * r);
        g.setColor(Color.RED);
        g.drawRect(headx, y + 2*r, 2*r, 4*r);
        g.setColor(Color.BLUE);
        g.drawLine(armLeftStart, armYStart, armLeftStart - armXLength, armYStart - armYLength);
        g.drawLine(armRightStart, armYStart, armRightStart + armXLength, armYStart - armYLength);
        g.setColor(Color.MAGENTA);
        g.drawLine(legLeftStart, legYStart, legLeftStart - legXLength, legYStart + legYLength);
        g.drawLine(legRightStart, legYStart, legRightStart + legXLength, legYStart + legYLength);
    }
}
