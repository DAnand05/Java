package jdbc;

//using button in same frame

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DisplayData extends JFrame {
    private JButton button;
    private JTable table;

    public DisplayData() {
        button = new JButton("Display Data");

        // Add an action listener to the button
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Connection connection = null;
                try {
                    // Load the MySQL JDBC driver
                    Class.forName("com.mysql.cj.jdbc.Driver");

                    // Set up the connection to the database
                    String url = "jdbc:mysql://localhost:3306/student";
                    String username = "root";
                    String password = "1305";
                    connection = DriverManager.getConnection(url, username, password);

                    // Create a statement and execute a query
                    Statement statement = connection.createStatement();
                    String sql = "SELECT * FROM register";
                    ResultSet resultSet = statement.executeQuery(sql);

                    // Create a JTable and populate it with the data from the ResultSet
                    table = new JTable(buildTableModel(resultSet));

                    // Add the JTable to the JFrame
                    getContentPane().add(new JScrollPane(table), BorderLayout.CENTER);
                    pack();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } finally {
                    try {
                        // Close the connection
                        if (connection != null) {
                            connection.close();
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        // Add the button to the JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(button, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }

    public static javax.swing.table.DefaultTableModel buildTableModel(ResultSet resultSet) throws SQLException {
        // Create a DefaultTableModel to hold the data from the ResultSet
        java.util.Vector<String> columnNames = new java.util.Vector<String>();
        java.util.Vector<java.util.Vector<Object>> data = new java.util.Vector<java.util.Vector<Object>>();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }
        while (resultSet.next()) {
            java.util.Vector<Object> row = new java.util.Vector<Object>();
            for (int column = 1; column <= columnCount; column++) {
                row.add(resultSet.getObject(column));
            }
            data.add(row);
        }
        return new javax.swing.table.DefaultTableModel(data, columnNames);
    }

    public static void main(String[] args) {
        new DisplayData();
    }
}























/* 

//button addition


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ShowDataInSwingTable {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JButton button = new JButton("Show Table Data");

        // Add an action listener to the button
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Connection connection = null;
                try {
                    // Load the MySQL JDBC driver
                    Class.forName("com.mysql.cj.jdbc.Driver");

                    // Set up the connection to the database
                    String url = "jdbc:mysql://localhost:3306/student";
                    String username = "root";
                    String password = "1305";
                    connection = DriverManager.getConnection(url, username, password);

                    // Create a statement and execute a query
                    Statement statement = connection.createStatement();
                    String sql = "SELECT * FROM register";
                    ResultSet resultSet = statement.executeQuery(sql);

                    // Create a JTable and populate it with the data from the ResultSet
                    JTable table = new JTable(buildTableModel(resultSet));

                    // Create a new JFrame and add the JTable to it
                    JFrame tableFrame = new JFrame();
                    tableFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    tableFrame.setLayout(new BorderLayout());
                    tableFrame.add(new JScrollPane(table), BorderLayout.CENTER);
                    tableFrame.pack();
                    tableFrame.setVisible(true);
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } finally {
                    try {
                        // Close the connection
                        if (connection != null) {
                            connection.close();
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        // Add the button to the JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(button, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    public static javax.swing.table.DefaultTableModel buildTableModel(ResultSet resultSet) throws SQLException {
        // Create a DefaultTableModel to hold the data from the ResultSet
        java.util.Vector<String> columnNames = new java.util.Vector<String>();
        java.util.Vector<java.util.Vector<Object>> data = new java.util.Vector<java.util.Vector<Object>>();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }
        while (resultSet.next()) {
            java.util.Vector<Object> row = new java.util.Vector<Object>();
            for (int column = 1; column <= columnCount; column++) {
                row.add(resultSet.getObject(column));
            }
            data.add(row);
        }
        return new javax.swing.table.DefaultTableModel(data, columnNames);
    }
}


/* 

import java.awt.BorderLayout;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ShowDataInSwingTable {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Set up the connection to the database
            String url = "jdbc:mysql://localhost:3306/student";
            String username = "root";
            String password = "1305";
            connection = DriverManager.getConnection(url, username, password);

            // Create a statement and execute a query
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM register";
            ResultSet resultSet = statement.executeQuery(sql);

            // Create a JTable and populate it with the data from the ResultSet
            JTable table = new JTable(buildTableModel(resultSet));

            // Create a JFrame and add the JTable to it
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());
            frame.add(new JScrollPane(table), BorderLayout.CENTER);
            frame.pack();
            frame.setVisible(true);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the connection
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static javax.swing.table.DefaultTableModel buildTableModel(ResultSet resultSet) throws SQLException {
        // Create a DefaultTableModel to hold the data from the ResultSet
        java.util.Vector<String> columnNames = new java.util.Vector<String>();
        java.util.Vector<java.util.Vector<Object>> data = new java.util.Vector<java.util.Vector<Object>>();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }
        while (resultSet.next()) {
            java.util.Vector<Object> row = new java.util.Vector<Object>();
            for (int column = 1; column <= columnCount; column++) {
                row.add(resultSet.getObject(column));
            }
            data.add(row);
        }
        return new javax.swing.table.DefaultTableModel(data, columnNames);
    }
}


/* 

import java.awt.BorderLayout;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ShowDataInSwingTable {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Set up the connection to the database
            String url = "jdbc:mysql://localhost:3306/mydatabase";
            String username = "myusername";
            String password = "mypassword";
            connection = DriverManager.getConnection(url, username, password);

            // Create a statement and execute a query
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM mytable";
            ResultSet resultSet = statement.executeQuery(sql);

            // Create a JTable and populate it with the data from the ResultSet
            JTable table = new JTable(buildTableModel(resultSet));

            // Create a JFrame and add the JTable to it
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());
            frame.add(new JScrollPane(table), BorderLayout.CENTER);
            frame.pack();
            frame.setVisible(true);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the connection
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static javax.swing.table.DefaultTableModel buildTableModel(ResultSet resultSet) throws SQLException {
        // Create a DefaultTableModel to hold the data from the ResultSet
        java.util.Vector<String> columnNames = new java.util.Vector<String>();
        java.util.Vector<java.util.Vector<Object>> data = new java.util.Vector<java.util.Vector<Object>>();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }
        while (resultSet.next()) {
            java.util.Vector<Object> row = new java.util.Vector<Object>();
            for (int column = 1; column <= columnCount; column++) {
                row.add(resultSet.getObject(column));
            }
            data.add(row);
        }
        return new javax.swing.table.DefaultTableModel(data, columnNames);
    }
}

*/