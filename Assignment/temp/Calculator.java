package temp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {

    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton;

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    public Calculator() {
        new JFrame("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLayout(null);

        textField = new JTextField();
        textField.setBounds(50, 25, 400, 50);
        textField.setFont(new Font("Arial", Font.PLAIN, 32));
        textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;

        for (int i = 0; i < 8; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(new Font("Arial", Font.PLAIN, 18));
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(new Font("Arial", Font.PLAIN, 18));
        }

        delButton.setBounds(50, 100, 100, 50);
        clrButton.setBounds(150, 100, 100, 50);

        JPanel panel1 = new JPanel();
        panel1.setBounds(50, 170, 400, 300);
        panel1.setLayout(new GridLayout(4, 4, 10, 10));

        panel1.add(numberButtons[1]);
        panel1.add(numberButtons[2]);
        panel1.add(numberButtons[3]);
        panel1.add(addButton);
        panel1.add(numberButtons[4]);
        panel1.add(numberButtons[5]);
        panel1.add(numberButtons[6]);
        panel1.add(subButton);
        panel1.add(numberButtons[7]);
        panel1.add(numberButtons[8]);
        panel1.add(numberButtons[9]);
        panel1.add(mulButton);
        panel1.add(decButton);
        panel1.add(numberButtons[0]);
        panel1.add(equButton);
        panel1.add(divButton);

        add(panel1);
        add(delButton);
        add(clrButton);
        add(textField);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton) {
            textField.setText
                    (textField.getText().concat(String.valueOf('.')));
        }
        if (e.getSource() == delButton) {
            String s = textField.getText();
            textField.setText("");
            for (int i = 0; i < s.length() - 1; i++)
                textField.setText(textField.getText() + s.charAt(i));
        }
        if (e.getSource() == clrButton) {
            textField.setText("");
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if (e.getSource() == equButton) {
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
        }
    }
}