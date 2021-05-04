package c_insert_data_with_preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class App {

    public static void main(String[] args) {

       User userInput = readInputFromUser();
        String firstName = userInput.getName();
        String lastName = userInput.getLastName();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/sample", "root", "rootpwd")) {

            String sqlInsert = "INSERT INTO USERS VALUES (6, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            System.out.println(sqlInsert);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static User readInputFromUser() {

        String name = "Giwrgos";
        String lastName = "papadopoulos'), (5,'GEORGE','MIKE'); -- ";
        return new User(name, lastName);

    }

    static class User {
        private final String name ;
        private final String lastName;

        User(String name, String lastName) {
            this.name = name;
            this.lastName = lastName;
        }

        public String getName() {
            return name;
        }

        public String getLastName() {
            return lastName;
        }
    }
}