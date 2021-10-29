package repositories;

import java.util.*;
import java.sql.*;
import dbUtils.DbConnection;
import entities.User;

public class UserRepository {
  public void writeUser(User user) {
    try( Connection conn = DbConnection.getInstance().initConnection();
         Statement stmt = conn.createStatement();) {
      String updateQuery = String.format("INSERT INTO user VALUES ('%s', '%s', '%s');", user.getUsername(), user.getPassword(), user.getEmail());
      stmt.executeUpdate(updateQuery);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public User readUser(String username) {
    try ( Connection conn = DbConnection.getInstance().initConnection();
          Statement stmt = conn.createStatement();
          ResultSet rs = stmt.executeQuery(String.format("SELECT * FROM user where username='%s';", username));) {
      if (rs.next()) {
        User result = new User(rs.getString("username"), rs.getString("password"));
        return result;
      }
    }catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  public ArrayList<User> readAllUsers() {
    ArrayList<User> userArrayList = new ArrayList<>();
    try ( Connection conn = DbConnection.getInstance().initConnection();
          Statement stmt = conn.createStatement();
          ResultSet rs = stmt.executeQuery("SELECT * FROM user;");) {
      while(rs.next()) {
        userArrayList.add(new User(rs.getString("username"), rs.getString("password"), rs.getString("email")));
      }
    return userArrayList;
    } catch (SQLException e) {
      e.printStackTrace();
    }
   return null;
  }
}
