package jdbc;

import java.sql.*;

public class JDBC {
    /** Make sure MySQL is installed locally and have some db in it.
     */
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?user=root");
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM employees");
        while (result.next()){
            int anInt = result.getInt("employee_id");
            System.out.println(anInt);
        }
        connection.close();
    }
}
