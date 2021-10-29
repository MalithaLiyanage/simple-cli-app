import java.util.Locale;
import java.util.Scanner;

public class App {
  public static boolean loggingSucceeded = false;
  enum ActionTypes {
    REGISTER,
    LOGIN,
    LIST_USERS
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {
      System.out.println("Choose an action by its number ---> 0.Register 1.Login 2.List Users");
      ActionTypes choice = ActionTypes.values()[Integer.parseInt(sc.nextLine())];
      DbConnection dbConnection = new DbConnection();
      switch (choice) {
        case REGISTER: {
          System.out.println("Enter Username");
          String username = sc.nextLine();
          System.out.println("Enter Password");
          String password = sc.nextLine();
          User user = new User(username, password);
          user.register(dbConnection);
          break;
        }
        case LOGIN: {
          System.out.println("Enter Username");
          String username = sc.nextLine();
          System.out.println("Enter Password");
          String password = sc.nextLine();
          User user = new User(username, password);
          user.login(dbConnection);
          break;
        }
        case LIST_USERS: {
          if (loggingSucceeded) {
            User.listUsers(dbConnection);
          } else {
            System.out.println("Please login for that action");
          }
          break;
        }
        default: {
          throw new IllegalArgumentException("Invalid Choice: " + choice);
        }
      }
    }

  }
}
