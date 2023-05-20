package class_practicals;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
    // Components
    private JTextField inputField1, inputField2, outputField;
    private JButton addButton, subtractButton, multiplyButton, divideButton;

    public Calculator() {
        // Set up frame
        setTitle("Calculator");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create components
        inputField1 = new JTextField(10);
        inputField2 = new JTextField(10);
        outputField = new JTextField(10);
        outputField.setEditable(false);
        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");

        // Add components to frame
        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(new JLabel("Input 1:"));
        panel.add(inputField1);
        panel.add(new JLabel("Input 2:"));
        panel.add(inputField2);
        panel.add(new JLabel("Result:"));
        panel.add(outputField);
        panel.add(addButton);
        panel.add(subtractButton);
        panel.add(multiplyButton);
        panel.add(divideButton);
        getContentPane().add(panel, BorderLayout.CENTER);

        // Add action listeners to buttons
        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);

        // Show frame
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // Get input values
        double input1 = Double.parseDouble(inputField1.getText());
        double input2 = Double.parseDouble(inputField2.getText());

        // Perform operation based on button clicked
        if (e.getSource() == addButton) {
            outputField.setText(Double.toString(input1 + input2));
        } else if (e.getSource() == subtractButton) {
            outputField.setText(Double.toString(input1 - input2));
        } else if (e.getSource() == multiplyButton) {
            outputField.setText(Double.toString(input1 * input2));
        } else if (e.getSource() == divideButton) {
            outputField.setText(Double.toString(input1 / input2));
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}

