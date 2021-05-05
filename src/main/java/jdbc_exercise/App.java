package jdbc_exercise;

import jdbc_exercise.dao.UserRepository;
import jdbc_exercise.model.User;
import z_helper.SampleDBHelper;

public class App {

    public static void main(String[] args) {
        // Remember to comment the line below for the second run
        SampleDBHelper.createTableUsersWithOneUser();

        UserRepository userRepository = new UserRepository();

        User user = new User(8, "Joe", "Dooe");

        // Create user
        userRepository.save(user);

        // Find user by id
        userRepository.find(user.getId());
        System.out.println(user);

        // Update user
        user.setSurname("Doe");
        userRepository.update(user);

        // Find user by id
        userRepository.find(user.getId());
        System.out.println(user);

        // Delete user by id
        userRepository.delete(user.getId());
    }
}
