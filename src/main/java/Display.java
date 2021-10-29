import java.sql.SQLException;
import java.util.*;

public class Display {
  public static void displayAllUsers (ArrayList<User> allUsers) throws SQLException {
    for (User user: allUsers) {
      System.out.println(user.getUsername() +" "+user.getPassword());
    }
  }
}
