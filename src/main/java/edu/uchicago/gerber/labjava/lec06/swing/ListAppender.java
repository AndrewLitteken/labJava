package edu.uchicago.gerber.labjava.lec06.swing;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ListAppender extends JPanel {

    JTextArea textArea;
    JTextField field;
    JLabel label;
    JSlider slider;

    public ListAppender() {
        field = new JTextField(20);
        JButton button = new JButton("Submit");
        button.addActionListener(new SubmitListener() {});
        textArea = new JTextArea(10, 20);
        textArea.setEditable(false);
        slider = new JSlider(0, 255, 100);
        slider.addChangeListener(new SliderListener());
        label = new JLabel(Integer.toString(slider.getValue()));
        add(field);
        add(button);
        add(textArea);
        add(slider);
        add(label);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        final int FRAME_WIDTH = 300;
        final int FRAME_HEIGHT = 400;

        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("A Simple Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new ListAppender();
        frame.add(panel);

        frame.setVisible(true);
    }

    class SubmitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Button Pressed!");
            String text = field.getText();
            textArea.append(text + "\n");
        }
    }

    class SliderListener implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            label.setText(Integer.toString(slider.getValue()));
        }
    }
}
