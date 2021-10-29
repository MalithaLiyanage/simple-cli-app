import java.sql.*;

public class DbConnection {
  private static String driver = "com.mysql.cj.jdbc.Driver";
  private static String connectionUrl = "jdbc:mysql://localhost:3306/mydb";
  private static String username = "root";
  private static String password = "";

  public Connection initConnection() {
    Connection conn = null;
    try {
      Class.forName(driver);
      conn = DriverManager.getConnection(connectionUrl, username, password);
      return conn;
    } catch (SQLException | ClassNotFoundException e) {
      e.printStackTrace();
      return null;
    }
  }
}
