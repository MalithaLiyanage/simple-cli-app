import java.sql.*;

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
    try {
      UserRepository userRepo = new UserRepository();
      userRepo.writeUser(dbConnection, this);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void login(DbConnection dbConnection) {
    try {
      UserRepository userRepo = new UserRepository();
      if (userRepo.isUserAvailable(dbConnection, this)) {
        System.out.println("Logging Successful");
        App.loggingSucceeded = true;
      } else {
        System.out.println("Wrong username or password");
        return;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void listUsers(DbConnection dbConnection) {
    try {
      UserRepository userRepo = new UserRepository();
      ResultSet allUsers = UserRepository.readAllUsers(dbConnection);
      Display.displayAllUsers(allUsers);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
