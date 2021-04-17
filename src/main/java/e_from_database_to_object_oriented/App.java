package e_from_database_to_object_oriented;

public class App {

    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);
        userService.printAllUsers();
    }
}
