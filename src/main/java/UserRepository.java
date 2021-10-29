import java.util.*;
import java.sql.*;

public class UserRepository {
  public void writeUser(DbConnection dbConnection, User user) throws SQLException {
    Connection conn = dbConnection.initConnection();
    Statement stmt = conn.createStatement();
    String updateQuery = String.format("INSERT INTO user VALUES ('%s', '%s');", user.getUsername(), user.getPassword());
    stmt.executeUpdate(updateQuery);
    conn.close();
  }
  public User readUser(DbConnection dbConnection, String username, String password) throws SQLException {
    Connection conn = dbConnection.initConnection();
    Statement stmt = conn.createStatement();
    String readQuery = String.format("SELECT * FROM user where username='%s' AND password='%s';", username, password);
    ResultSet rs = stmt.executeQuery(readQuery);

    if (rs.next()) {
      User result = new User(rs.getString(1), rs.getString(2));
      conn.close();
      return result;
    }
    return null;
  }
  public boolean isUserAvailable(DbConnection dbConnection, User user) throws SQLException {
    User resultUser = readUser(dbConnection, user.getUsername(), user.getPassword());
    return resultUser != null;
  }

  public static ResultSet readAllUsers(DbConnection dbConnection) throws SQLException {
    Connection conn = dbConnection.initConnection();
    Statement stmt = conn.createStatement();
    String readQuery = String.format("SELECT * FROM user;");
    conn.close();
    return stmt.executeQuery(readQuery);
  }
}
