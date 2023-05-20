package Assignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {

    private JButton[] buttons;
    private JTextField display;
    private String[] buttonLabels = { "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+" };
    private String input = "";
    private double result = 0;
    private char operation = ' ';

    public Calculator() {
        setTitle("Calculator");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        buttons = new JButton[buttonLabels.length];

        for (int i = 0; i < buttonLabels.length; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            buttons[i].addActionListener(this);
            panel.add(buttons[i]);
        }

        display = new JTextField();
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);

        add(display, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        String buttonText = e.getActionCommand();
        
        // Handle numeric input
        if (buttonText.matches("[0-9\\.]+")) {
            input += buttonText;
            display.setText(input);
        } 
        
        // Handle arithmetic operations
        else if (buttonText.matches("[\\+\\-\\*/]")) {
            if (operation == ' ') {
                result = Double.parseDouble(input);
            } else {
                result = performOperation(result, Double.parseDouble(input), operation);
            }
            operation = buttonText.charAt(0);
            input = "";
            display.setText(String.valueOf(result));
        } 
        
        // Handle equals button
        else if (buttonText.equals("=")) {
            if (operation != ' ') {
                result = performOperation(result, Double.parseDouble(input), operation);
                operation = ' ';
                input = "";
                display.setText(String.valueOf(result));
            }
        } 
        
        // Handle clear button
        else if (buttonText.equals("C")) {
            input = "";
            result = 0;
            operation = ' ';
            display.setText("");
        }
    }

    private double performOperation(double a, double b, char op) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.setVisible(true);
    }
}
