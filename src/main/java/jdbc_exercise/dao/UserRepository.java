package jdbc_exercise.dao;

import jdbc_exercise.model.User;

public class UserRepository {
    private static final String JDBC_MYSQL_LOCALHOST_SAMPLE = "jdbc:mysql://localhost/sample";
    private static final String USER = "root";
    private static final String PASSWORD = "rootpwd";

    private static final String INSERT_STATEMENT = "?";
    private static final String SELECT_STATEMENT = "?";
    private static final String UPDATE_STATEMENT = "?";
    private static final String DELETE_STATEMENT = "?";

    public void save(User user) {
        // TODO: Implement this method
    }

    public User find(int id) {
        // TODO: Implement this method
        return null;
    }

    public void update(User user) {
        // TODO: Implement this method
    }

    public void delete(int id) {
        // TODO: Implement this method
    }
}
