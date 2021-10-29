import java.sql.*;

public class DbConnection {
  private static final String driver = "com.mysql.cj.jdbc.Driver";
  private static final String connectionUrl = "jdbc:mysql://localhost:3306/mydb";
  private static final String username = "root";
  private static final String password = "";

  public Connection initConnection() {
    Connection conn;
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
