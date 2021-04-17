package a_connect_to_mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {

    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/sample", "root", "rootpwd");

        boolean connectionIsValid = connection.isValid(0);
        System.out.println(connectionIsValid);

        connection.close();
    }
}
