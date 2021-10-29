package entities;

public class User {
  private String username;
  private String password;
  private String email;

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }
  public User(String username, String password, String email) {
    this.username = username;
    this.password = password;
    this.email = email;
  }
  public User(User user, String password) {
    this.username = user.getUsername();
    this.password = password;
    this.email = user.getEmail();
  }

  public String getUsername() {
    return username;
  }
  public String getPassword() {
    return password;
  }

  public String getEmail() {
    return email;
  }

  @Override
  public String toString() {
    return  username + " " + password + " " + email;
  }

}
