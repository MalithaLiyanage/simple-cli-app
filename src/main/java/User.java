import java.sql.*;
import java.util.ArrayList;

public class User extends DbConnection {
  private String username;
  private String password;

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public String getUsername() {
    return username;
  }
  public String getPassword() {
    return password;
  }

  public void register(DbConnection dbConnection) {
    UserRepository userRepo = new UserRepository();
    userRepo.writeUser(dbConnection, this);
  }

  public void login(DbConnection dbConnection) {
    UserRepository userRepo = new UserRepository();
    if (userRepo.isUserAvailable(dbConnection, this)) {
      System.out.println("Logging Successful");
      App.loggingSucceeded = true;
    } else {
      System.out.println("Wrong username or password");
      return;
    }
  }

  public static void listUsers(DbConnection dbConnection) {
    try {
      ArrayList allUsers = UserRepository.readAllUsers(dbConnection);
      Display.displayAllUsers(allUsers);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
