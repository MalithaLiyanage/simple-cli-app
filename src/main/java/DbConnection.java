import java.sql.*;

public class DbConnection {
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String connectionUrl = "jdbc:mysql://localhost:3306/mydb";
    private static String username;
    private static String password;

    public DbConnection(String username, String password) {
        this.username = username;
        this.password = password;

        try{
            Class.forName(driver);
            Connection con=DriverManager.getConnection(connectionUrl, username, password);
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from user");
            while(rs.next())
                System.out.println(rs.getString(1) + rs.getString(2) + rs.getInt(3));
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }
}
