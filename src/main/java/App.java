import java.util.Locale;
import java.util.Scanner;

public class App {
  enum ActionTypes {
    REGISTER,
    LOGIN,
    LIST_USERS
  }
  public static boolean loggingSucceeded = false;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {
      System.out.println("Choose an action by its number ---> 0.Register 1.Login 2.List Users");
      ActionTypes choice = ActionTypes.values()[Integer.parseInt(sc.nextLine())];
      switch (choice) {
        case REGISTER: {
          System.out.println("Enter Username");
          String username = sc.nextLine();
          System.out.println("Enter Password");
          String password = sc.nextLine();
          User user = new User(username, password);
          user.register();
          break;
        }
        case LOGIN: {
          System.out.println("Enter Username");
          String username = sc.nextLine();
          System.out.println("Enter Password");
          String password = sc.nextLine();
          User user = new User(username, password);
          user.login();
          break;
        }
        case LIST_USERS: {
          User user = new User("username", "password");
          user.listUsers();
          break;
        }
        default: {
          throw new IllegalArgumentException("Invalid Choice: " + choice);
        }
      }
    }

  }
}
