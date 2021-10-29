package dbUtils;

import common.Constants;
import java.sql.*;

public class DbConnection {

  private static DbConnection dbConnection;
  private DbConnection() {
  }
  public static DbConnection getInstance() {
    if (dbConnection == null) {
      dbConnection = new DbConnection();
    }
    return dbConnection;
  }
  public Connection initConnection() {
    Connection conn;
    try {
      Class.forName(Constants.DRIVER);
      conn = DriverManager.getConnection(Constants.CONNECTION_URL, Constants.USERNAME, Constants.PASSWORD);
      return conn;
    } catch (SQLException | ClassNotFoundException e) {
      e.printStackTrace();
      return null;
    }
  }
}
