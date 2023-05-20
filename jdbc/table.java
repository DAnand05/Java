package jdbc;

import java.sql.*;

public class table {
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

            // Print the results to the console
            while (resultSet.next()) {
                int col1 = resultSet.getInt("id");
                String col2 = resultSet.getString("F_Name");
                String col3 = resultSet.getString("L_Name");
                String col4 = resultSet.getString("Password");
                System.out.println("ID: " + col1 + ", F_Name: " + col2 + ", L_Name: " + col3 + ", Password: " + col4);
            }
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
}
