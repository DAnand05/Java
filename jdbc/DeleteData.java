package jdbc;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DeleteData extends JFrame {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/student";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1305";
    private static final String TABLE_NAME = "register";

    private JTable table;
    private DefaultTableModel tableModel;

    public DeleteData() {
        super("Delete Data");

        tableModel = new DefaultTableModel(new String[] { "ID", "FName", "LName", "Password" }, 0);
        table = new JTable(tableModel);

        JButton deleteButton = new JButton("Delete Selected Rows");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] selectedRows = table.getSelectedRows();
                if (selectedRows.length == 0) {
                    return;
                }

                int option = JOptionPane.showConfirmDialog(DeleteData.this,
                        "Are you sure you want to delete the selected rows?", "Confirm Delete",
                        JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                            Statement stmt = conn.createStatement()) {
                        for (int i = selectedRows.length - 1; i >= 0; i--) {
                            int id = (int) table.getValueAt(selectedRows[i], 0);
                            stmt.executeUpdate("DELETE FROM " + TABLE_NAME + " WHERE id = " + id);
                            tableModel.removeRow(selectedRows[i]);
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(DeleteData.this, "Error deleting rows: " + ex.getMessage(),
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(deleteButton);

        add(new JScrollPane(table), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
    }

    public void loadTableData() {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT id, F_Name, L_Name, Password FROM " + TABLE_NAME)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String fName = rs.getString("F_Name");
                String lName = rs.getString("L_Name");
                String pwd = rs.getString("Password");
                tableModel.addRow(new Object[] { id, fName, lName, pwd });
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading table data: " + ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        DeleteData obj = new DeleteData();
        obj.loadTableData();
        obj.setVisible(true);
    }

}
