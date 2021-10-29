import java.sql.*;

public class User extends DbConnection implements UserOperations {
  private String username;
  private String password;

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public String getPassword() {
    return this.password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public void setUsername(String username) {
    this.username = username;
  }

  @Override
  public void register() {
    DbConnection dbConnection = new DbConnection();
    Connection conn = dbConnection.initConnection();

    try (Statement stmt = conn.createStatement();) {
      String updateQuery = String.format("INSERT INTO user VALUES ('%s', '%s');", this.username, this.password);
      stmt.executeUpdate(String.format(updateQuery));
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

  @Override
  public void login() {
    DbConnection dbConnection = new DbConnection();
    Connection conn = dbConnection.initConnection();

    try (Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(String.format("SELECT * FROM user where username='%s' AND password='%s';", this.username, this.password));) {
      if (rs.next()) {
        System.out.println("Logging Successful");
        App.loggingSucceeded = true;
      } else {
        System.out.println("Wrong username or password");
        return;
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

  @Override
  public void listUsers() {
    if (App.loggingSucceeded) {
      DbConnection dbConnection = new DbConnection();
      Connection conn = dbConnection.initConnection();

      try (Statement stmt = conn.createStatement();
           ResultSet rs = stmt.executeQuery("SELECT * FROM user;");) {
        while (rs.next())
          System.out.println(rs.getString(1) + " " + rs.getString(2));
      } catch (Exception e) {
        e.printStackTrace();
      } finally {
        try {
          conn.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    } else {
      System.out.println("Please log into for that action");
    }

  }
}
