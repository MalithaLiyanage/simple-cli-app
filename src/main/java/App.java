import common.Actions;
import entities.User;
import operations.UserOperation;

import java.util.Scanner;

public class App {
  public static User promptLoginMessages(Scanner sc) {
    System.out.println("Enter Username");
    String username = sc.nextLine();
    System.out.println("Enter Password");
    String password = sc.nextLine();
    return new User(username, password);
  }

  public static User promptRegisterMessages(Scanner sc) {
    System.out.println("Enter Username");
    String username = sc.nextLine();
    System.out.println("Enter Password");
    String password = sc.nextLine();
    System.out.println("Enter Email");
    String email = sc.nextLine();
    return new User(username, password, email);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    UserOperation userOp = new UserOperation();
    while (true) {
      System.out.println("Choose an action by its number ---> 0.Register 1.Login 2.List Users");
      try {
        Actions.UserActions choice = Actions.UserActions.values()[Integer.parseInt(sc.nextLine())];
        switch (choice) {
          case REGISTER: {
            User user = promptRegisterMessages(sc);
            userOp.register(user);
            break;
          }
          case LOGIN: {
            User user = promptLoginMessages(sc);
            userOp.login(user);
            break;
          }
          case LIST_USERS: {
            userOp.listUsers();
            break;
          }
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
