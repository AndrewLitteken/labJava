package edu.uchicago.gerber.labjava.lec06.swing;

import javax.swing.*;
import java.awt.*;

public class ShapeComponent extends JComponent {

    Color c1 = Color.BLACK;
    Color c2 = Color.RED;
    Color c3 = Color.GREEN;

    public void setColors(Color c1, Color c2, Color c3) {
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
    }

    @Override
    public void paintComponent(Graphics g) {
        g.fillOval(50, 20, 125, 100);
        g.setColor(Color.RED);
        g.fillOval(50, 75, 200, 200);
        /*g.setColor(c1);

        g.fillRect(10, 10, 60, 100);
        g.drawRect(10, 120, 100, 100);

        g.setColor(c2);
        g.fillOval(100, 10, 60, 100);

        g.setColor(c3);
        g.drawOval(120, 120, 100, 100);*/
    }
}
