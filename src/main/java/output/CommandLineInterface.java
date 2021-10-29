package output;

import java.util.*;
import entities.User;

public class CommandLineInterface {
  public static void displayAllUsers (ArrayList<User> allUsers) {
    for (User user: allUsers) {
      System.out.println(user);
    }
  }
}
