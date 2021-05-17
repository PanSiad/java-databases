package jdbc_exercise.dao;

import jdbc_exercise.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserRepository {
    private static final String JDBC_MYSQL_LOCALHOST_SAMPLE = "jdbc:mysql://localhost/sample";
    private static final String USER = "root";
    private static final String PASSWORD = "rootpwd";

    private static final String INSERT_STATEMENT = "INSERT INTO USERS VALUES (?, ?, ?)";
    private static final String SELECT_STATEMENT = "SELECT * FROM USERS WHERE ID = ?";
    private static final String UPDATE_STATEMENT = "UPDATE USERS SET NAME = ?, SURNAME = ? WHERE ID = ?";
    private static final String DELETE_STATEMENT = "DELETE FROM USERS WHERE ID = ?";

    public void save(User user) {

        try (Connection connection = DriverManager.getConnection(JDBC_MYSQL_LOCALHOST_SAMPLE, USER, PASSWORD)) {

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STATEMENT);
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getSurname());
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User find(int id) {

        try (Connection connection = DriverManager.getConnection(JDBC_MYSQL_LOCALHOST_SAMPLE, USER, PASSWORD)) {

            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STATEMENT);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            //if result set has the user with the given id, return it
            while (rs.next()) {
                User user = new User(rs.getInt(id), rs.getString("name"), rs.getString("surname"));
                return user;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void update(User user) {

        try (Connection connection = DriverManager.getConnection(JDBC_MYSQL_LOCALHOST_SAMPLE, USER, PASSWORD)) {

            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STATEMENT);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setInt(3, user.getId());
            int rowsaffected = preparedStatement.executeUpdate();
            if (rowsaffected == 1) {
                System.out.println("User updated!");
            } else {
                System.out.println("Something went wrong -> none or multiple users affected instead of 1");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void delete(int id) {

        try (Connection connection = DriverManager.getConnection(JDBC_MYSQL_LOCALHOST_SAMPLE, USER, PASSWORD)) {

            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STATEMENT);
            preparedStatement.setInt(1, id);
            int rowsaffected = preparedStatement.executeUpdate();
            if (rowsaffected == 1) {
                System.out.println("User deleted!");
            } else {
                System.out.println("Something went wrong -> none or multiple users affected instead of 1");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
