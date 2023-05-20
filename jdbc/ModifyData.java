package jdbc;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ModifyData extends JFrame {

    // Database connection details
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/student";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1305";

    // Table details
    private static final String TABLE_NAME = "register";
    private JTable table;
    private DefaultTableModel tableModel;

    // Input fields for modifying a row
    private JTextField idField;
    private JTextField fNameField;
    private JTextField lNameField;
    private JTextField passwordField;

    public ModifyData() {
        super("Modify Data Demo");

        // Create the table model and table
        tableModel = new DefaultTableModel(new String[] { "ID", "First Name", "Last Name", "Password" }, 0);
        table = new JTable(tableModel);

        // Create the input fields and modify button
        idField = new JTextField(10);
        fNameField = new JTextField(10);
        lNameField = new JTextField(10);
        passwordField = new JTextField(10);

        JButton modifyButton = new JButton("Modify Row");
        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the selected row from the table
                int row = table.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(ModifyData.this, "Please select a row to modify", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Get the input values for the modified row
                int id = Integer.parseInt(idField.getText());
                String fName = fNameField.getText();
                String lName = lNameField.getText();
                String password = passwordField.getText();

                try (
                    Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                        PreparedStatement stmt = conn.prepareStatement("UPDATE " + TABLE_NAME
                                + " SET f_name = ?, l_name = ?, password = ? WHERE id = ?")) {
                    // Set the parameter values for the prepared statement
                    stmt.setString(1, fName);
                    stmt.setString(2, lName);
                    stmt.setString(3, password);
                    stmt.setInt(4, id);

                    // Execute the update and get the number of rows affected
                    int rowsAffected = stmt.executeUpdate();

                    // If one row was updated, update the table model as well
                    if (rowsAffected == 1) {
                        tableModel.setValueAt(id, row, 0);
                        tableModel.setValueAt(fName, row, 1);
                        tableModel.setValueAt(lName, row, 2);
                        tableModel.setValueAt(password, row, 3);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(ModifyData.this, "Error modifying row: " + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Create a panel to hold the input fields and modify button
        JPanel inputPanel = new JPanel();
        inputPanel.add(idField);
        inputPanel.add(fNameField);
        inputPanel.add(lNameField);
        inputPanel.add(passwordField);
        inputPanel.add(modifyButton);

                // Create a panel to hold the table and input panel
                JPanel mainPanel = new JPanel(new BorderLayout());
                mainPanel.add(new JScrollPane(table), BorderLayout.CENTER);
                mainPanel.add(inputPanel, BorderLayout.SOUTH);
        
                // Add the main panel to the frame
                setContentPane(mainPanel);
                pack();
                setLocationRelativeTo(null);
        
                // Load the data from the database into the table
                loadData();
        
                // Set the frame to be visible
                setVisible(true);
            }
        
            private void loadData() {
                // Clear the table model
                tableModel.setRowCount(0);
        
                try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT * FROM " + TABLE_NAME)) {
                    // Iterate over the result set and add each row to the table model
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String fName = rs.getString("f_name");
                        String lName = rs.getString("l_name");
                        String password = rs.getString("password");
        
                        tableModel.addRow(new Object[] { id, fName, lName, password });
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error loading data: " + ex.getMessage(), "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        
            public static void main(String[] args) {
                // Use the system look and feel
                try {
                    javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
        
                // Create and show the ModifyData frame
                new ModifyData();
            }
        }
        


























/* 
import java.awt.*;
import java.awt.event.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ModifyData extends JFrame {
    
    private static final String url="jdbc:mysql://localhost:3306/student";
    private static final String Username="root";
    private static final String Password="1305";
    private static final String TableName="register";

    private JTable tbl;
    private DefaultTableModel tblmdl;

    public ModifyData(){
        super("Modify Data");

        tblmdl = new DefaultTableModel(new String[] {"ID","FName", "LName", "Password"}, 0);
        tbl=new JTable(tblmdl);

        
    }
}
*/