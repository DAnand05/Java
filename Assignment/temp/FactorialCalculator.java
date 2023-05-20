package temp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FactorialCalculator extends JFrame implements ActionListener {

    private JTextField inputField, resultField; // Create two text fields to hold input and result

    public FactorialCalculator() {
        setTitle("Factorial Calculator");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(2, 2));
        JLabel inputLabel = new JLabel("Enter a number:");
        inputField = new JTextField();
        JLabel resultLabel = new JLabel("Factorial:");
        resultField = new JTextField();
        resultField.setEditable(false); // Set the result field as read-only

        panel.add(inputLabel);
        panel.add(inputField);
        panel.add(resultLabel);
        panel.add(resultField);
        add(panel, BorderLayout.CENTER); // Add the input and result fields to the center of the frame

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this); // Register the frame as a listener for the button
        add(calculateButton, BorderLayout.SOUTH); // Add the button to the bottom of the frame

        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        try {
            int number = Integer.parseInt(inputField.getText()); // Get the input from the text field
            int factorial = 1;
            for (int i = 2; i <= number; i++) { // Calculate the factorial using a loop
                factorial *= i;
            }
            resultField.setText(String.valueOf(factorial)); // Display the result in the text field
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid integer."); // Display an error message if the input is not a valid integer
        }
    }

    public static void main(String[] args) {
        new FactorialCalculator(); // Create an instance of the calculator
    }
}
