import java.sql.ResultSet;
import java.sql.SQLException;

public class Display {
  public static void displayAllUsers (ResultSet rs) throws SQLException {
    while (rs.next()) {
      System.out.println(rs.getString(1) +" "+rs.getString(2));
    }
  }
}
