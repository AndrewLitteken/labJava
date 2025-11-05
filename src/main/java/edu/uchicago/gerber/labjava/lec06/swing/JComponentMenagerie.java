package edu.uchicago.gerber.labjava.lec06.swing;

import javax.swing.*;
import java.awt.*;

public class JComponentMenagerie {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        final int FRAME_WIDTH = 300;
        final int FRAME_HEIGHT = 400;

        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("A Simple Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();//new GridLayout(4, 2));
        // Single Line of text
        JComponent jtext = new JTextField("This is text area");
        JComponent jtext2 = new JTextField("This is text area 2");
        JPanel panel2 = new JPanel(new GridLayout(2, 1));
        panel2.add(jtext);
        panel2.add(jtext2);
        JTextField jtextEdit = new JTextField("This is noneditable text");
        JTextArea jtextArea = new JTextArea(10, 20);
        // Multilines of text
        jtextArea.setText("this is a text area\nMultiline");
        jtextEdit.setEditable(false);
        JComponent jtextButton = new JButton("Button");
        JComponent jSlider = new JSlider(0, 255, 100);
        JComponent jCheckBox = new JCheckBox("Check Box");
        JComponent jRadio = new JRadioButton("Radio Box");
        JComponent jLabel = new JLabel("Label");
        panel.add(panel2,  BorderLayout.NORTH);
        panel.add(jtextEdit, BorderLayout.EAST);
        panel.add(jtextArea, BorderLayout.SOUTH);
        panel.add(jtextButton);
        panel.add(jSlider);
        panel.add(jCheckBox);
        panel.add(jRadio);
        panel.add(jLabel);
        frame.add(panel);

        frame.setVisible(true);
    }
}
