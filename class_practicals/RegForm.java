package class_practicals;

import javax.swing.*;
import java.awt.*;

public class RegForm extends JFrame {
    public RegForm() {
        // set JFrame size to 700x800 pixels
        setSize(700, 800);
        // set JFrame layout to null
        setLayout(null);
        // set JFrame background color to white
        getContentPane().setBackground(Color.WHITE);

        // create a JLabel to hold the background image
        JLabel backgroundImage = new JLabel(new ImageIcon("img.png"));
        // set JLabel size to match the JFrame size
        backgroundImage.setBounds(0, 0, getWidth(), getHeight());
        // add the JLabel to the JFrame
        add(backgroundImage);

        // create registration form components
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();
        JButton submitButton = new JButton("Submit");

        // set component bounds
        nameLabel.setBounds(50, 50, 100, 30);
        nameField.setBounds(150, 50, 200, 30);
        emailLabel.setBounds(50, 100, 100, 30);
        emailField.setBounds(150, 100, 200, 30);
        submitButton.setBounds(150, 150, 100, 30);

        // add components to the JFrame
        add(nameLabel);
        add(nameField);
        add(emailLabel);
        add(emailField);
        add(submitButton);

        // set JFrame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        new RegForm();
    }
}
