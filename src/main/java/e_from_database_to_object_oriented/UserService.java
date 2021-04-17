package e_from_database_to_object_oriented;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

   public void printAllUsers() {
        userRepository.findAllUsers().forEach(System.out::println);
    }
}
