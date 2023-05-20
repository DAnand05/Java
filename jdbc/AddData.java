package jdbc;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class AddData extends JFrame implements ActionListener {
    JLabel idLabel, fNameLabel, lNameLabel, passwordLabel;
    JTextField idField, fNameField, lNameField, passwordField;
    JButton submitButton;

    public AddData() {
        setTitle("Register Form");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        idLabel = new JLabel("ID:");
        idField = new JTextField(10);
        fNameLabel = new JLabel("First Name:");
        fNameField = new JTextField(20);
        lNameLabel = new JLabel("Last Name:");
        lNameField = new JTextField(20);
        passwordLabel = new JLabel("Password:");
        passwordField = new JTextField(20);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        /*
        JPanel panel = new JPanel();
        panel.add(idLabel);
        panel.add(idField);
        panel.add(fNameLabel);
        panel.add(fNameField);
        panel.add(lNameLabel);
        panel.add(lNameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(submitButton);
        panel.setBounds(25,25,200,200);

        Border border = BorderFactory.createBevelBorder(BevelBorder.RAISED); // Creates a bevel border with raised edges
        panel.setBorder(border);

        add(panel);
        setVisible(true);
        */
         // Create a panel for the form
         JPanel panel = new JPanel();
         GroupLayout layout = new GroupLayout(panel);
         panel.setLayout(layout);
 
         // Add the components to the panel
         layout.setAutoCreateGaps(true);
         layout.setAutoCreateContainerGaps(true);
 
         layout.setHorizontalGroup(layout.createSequentialGroup()
             .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                 .addComponent(idLabel)
                 .addComponent(fNameLabel)
                 .addComponent(lNameLabel)
                 .addComponent(passwordLabel)
             )
             .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                 .addComponent(idField)
                 .addComponent(fNameField)
                 .addComponent(lNameField)
                 .addComponent(passwordField)
                 .addComponent(submitButton)
             )
         );
 
         layout.setVerticalGroup(layout.createSequentialGroup()
             .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                 .addComponent(idLabel)
                 .addComponent(idField)
             )
             .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                 .addComponent(fNameLabel)
                 .addComponent(fNameField)
             )
             .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                 .addComponent(lNameLabel)
                 .addComponent(lNameField)
             )
             .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                 .addComponent(passwordLabel)
                 .addComponent(passwordField)
             )
             .addComponent(submitButton)
         );
 
         // Add the panel to the frame
         add(panel);
         setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            try {
                // Establish connection
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "1305");

                // Create prepared statement
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO register(id, f_name, l_name, password) VALUES (?, ?, ?, ?)");

                // Set parameter values
                stmt.setInt(1, Integer.parseInt(idField.getText()));
                stmt.setString(2, fNameField.getText());
                stmt.setString(3, lNameField.getText());
                stmt.setString(4, passwordField.getText());

                // Execute query
                stmt.executeUpdate();

                // Close statement and connection
                stmt.close();
                conn.close();

                JOptionPane.showMessageDialog(null, "Data added successfully!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new AddData();
    }
}
