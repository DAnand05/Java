package temp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingCalculator extends JFrame implements ActionListener {

    private final JTextField textField;
    private double num1, num2, result;
    private char operator;

    public SwingCalculator() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(250, 250);

        textField = new JTextField(10);
        textField.setEditable(false);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 4));
        String[] buttonLabels = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", ".", "0", "C", "+"};

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        add(textField, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String buttonLabel = ((JButton) e.getSource()).getText();

        switch (buttonLabel) {
            case "C":
                textField.setText("");
                break;

            case "+":
            case "-":
            case "*":
            case "/":
                num1 = Double.parseDouble(textField.getText());
                operator = buttonLabel.charAt(0);
                textField.setText("");
                break;

            case "=":
                num2 = Double.parseDouble(textField.getText());
                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        result = num1 / num2;
                        break;
                }
                textField.setText(String.valueOf(result));
                num1 = result;
                break;

            default:
                textField.setText(textField.getText() + buttonLabel);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SwingCalculator::new);
    }
}
