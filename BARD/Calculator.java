package BARD;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator {

    private JFrame frame;
    private JTextField display;
    private JButton[] buttons;

    public Calculator() {
        frame = new JFrame("Calculator");
        frame.setLayout(new BorderLayout());

        display = new JTextField();
        display.setEditable(false);
        frame.add(display, BorderLayout.NORTH);

        buttons = new JButton[10];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(String.valueOf(i));
        }

        JPanel buttonPanel = new JPanel(new GridLayout(4, 3));
        for (JButton button : buttons) {
            buttonPanel.add(button);
        }

        JButton clearButton = new JButton("Clear");
        buttonPanel.add(clearButton);

        JButton equalButton = new JButton("=");
        buttonPanel.add(equalButton);

        frame.add(buttonPanel, BorderLayout.CENTER);

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText("");
            }
        });

        equalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = display.getText();
                double value = Double.parseDouble(text);

                for (int i = 0; i < buttons.length; i++) {
                    if (buttons[i].getText().equals("+")) {
                        value += Double.parseDouble(buttons[i + 1].getText());
                        break;
                    } else if (buttons[i].getText().equals("-")) {
                        value -= Double.parseDouble(buttons[i + 1].getText());
                        break;
                    } else if (buttons[i].getText().equals("*")) {
                        value *= Double.parseDouble(buttons[i + 1].getText());
                        break;
                    } else if (buttons[i].getText().equals("/")) {
                        value /= Double.parseDouble(buttons[i + 1].getText());
                        break;
                    }
                }

                display.setText(String.valueOf(value));
            }
        });

        for (JButton button : buttons) {
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    display.setText(display.getText() + e.getActionCommand());
                }
            });
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Calculator();
            }
        });
    }
}
