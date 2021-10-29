import java.util.*;
import java.sql.*;

public class UserRepository {
  public void writeUser(DbConnection dbConnection, User user) {
    try( Connection conn = dbConnection.initConnection();
         Statement stmt = conn.createStatement();) {
      String updateQuery = String.format("INSERT INTO user VALUES ('%s', '%s');", user.getUsername(), user.getPassword());
      stmt.executeUpdate(updateQuery);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  public User readUser(DbConnection dbConnection, String username, String password) {
    try ( Connection conn = dbConnection.initConnection();
          Statement stmt = conn.createStatement();
          ResultSet rs = stmt.executeQuery(String.format("SELECT * FROM user where username='%s' AND password='%s';", username, password));) {
      if (rs.next()) {
        User result = new User(rs.getString(1), rs.getString(2));
        return result;
      }
    }catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }
  public boolean isUserAvailable(DbConnection dbConnection, User user) {
    User resultUser = readUser(dbConnection, user.getUsername(), user.getPassword());
    return resultUser != null;
  }

  public static ArrayList<User> readAllUsers(DbConnection dbConnection) {
    ArrayList<User> userArrayList = new ArrayList<User>();
    try ( Connection conn = dbConnection.initConnection();
          Statement stmt = conn.createStatement();
          ResultSet rs = stmt.executeQuery("SELECT * FROM user;");) {
      while(rs.next()) {
        userArrayList.add(new User(rs.getString(1), rs.getString(2)));
      }
    return userArrayList;
    } catch (SQLException e) {
      e.printStackTrace();
    }
   return null;
  }
}
