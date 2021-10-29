package operations;

import java.util.ArrayList;
import entities.User;
import helpers.PasswordHelper;
import repositories.UserRepository;
import output.CommandLineInterface;

public class UserOperation {
  private final UserRepository userRepository;
  private User loggedInUser;

  public UserOperation() {
    userRepository = new UserRepository();
  }
  public void register(User user) {
    String encryptedPassword = PasswordHelper.encryptPassword(user.getPassword());
    User encryptedUser = new User(user, encryptedPassword);
    userRepository.writeUser(encryptedUser);
  }
  public void login(User user) {
    User resultUser = userRepository.readUser(user.getUsername());
    if (resultUser != null && PasswordHelper.verifyPassword(user.getPassword(), resultUser.getPassword())) {
      System.out.println("Logging Successful");
      loggedInUser = user;
    } else {
      System.out.println("Wrong username or password");
      return;
    }
  }
  public void listUsers() {
    if (loggedInUser != null) {
      ArrayList allUsers = userRepository.readAllUsers();
      CommandLineInterface.displayAllUsers(allUsers);
    } else {
      System.out.println("Please login for that action");
    }
  }
}
