package d_transactions_handling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class App {

    public static void main(String[] args) {

        User userInput = readInputFromUser();
        String firstName = userInput.getName();
        String lastName = userInput.getLastName();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/sample", "root", "rootpwd")) {

            connection.setAutoCommit(false);

            String sqlInsert = "INSERT INTO USERS VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);

            preparedStatement.setInt(1, 16);
            preparedStatement.setString(2, "giwrgos");
            preparedStatement.setString(3, "papadopoulos");
            System.out.println(sqlInsert);
            preparedStatement.executeUpdate();

            preparedStatement.setInt(1, 17);
            preparedStatement.setString(2,"Nikos");
            preparedStatement.setString(3,"Marinos");
            preparedStatement.executeUpdate();

            connection.commit();
            System.out.println("Done");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static User readInputFromUser() {

        return new User("Giwrgos", "papadopoulos");
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