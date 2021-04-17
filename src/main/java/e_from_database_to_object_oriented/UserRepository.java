package e_from_database_to_object_oriented;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    public List<User> findAllUsers() {
        String sql = "Select * from USERS";
        List<User> users = new ArrayList<>();

        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/sample", "root", "rootpwd");
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                users.add(new User(id,firstName,lastName));
            }

        }catch (Exception e){
            //ignore
        }

        return users;
    }
}
