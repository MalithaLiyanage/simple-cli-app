package helpers;

import org.jasypt.util.password.BasicPasswordEncryptor;

public class PasswordHelper {

  public static String encryptPassword(String password) {
    BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
    return passwordEncryptor.encryptPassword(password);
  }
  public static boolean verifyPassword(String inputPassword, String encryptedPassword) {
    BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
    return passwordEncryptor.checkPassword(inputPassword, encryptedPassword);
  }
}
