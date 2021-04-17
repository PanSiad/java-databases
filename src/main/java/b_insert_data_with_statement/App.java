package b_insert_data_with_statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class App {

    public static void main(String[] args) {

        User userInput = readInputFromUser();
        String firstName = userInput.getName();
        String lastName = userInput.getLastName();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/sample", "root", "rootpwd");
             Statement stmt = connection.createStatement()) {

            String sqlInsert = "INSERT INTO USERS VALUES (4, '"+firstName+"', '"+lastName+"')";
            System.out.println(sqlInsert);
            stmt.execute(sqlInsert);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static User readInputFromUser() {

        return new User("Giwrgos", "papadopoulos'), (5,'GEORGE','MIKE'); -- ");
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
