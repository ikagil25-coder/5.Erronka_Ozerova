import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Konexioa
{
    
    private static final String URL = "jdbc:mysql://localhost:3307/gg_biltegia";
    private static final String USER = "root";
    private static final String PASSWORD = "Passwordsql";

    public Connection konektatu() throws SQLException
    {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        System.out.println("Konexioa ondo burutu da!");
        return conn;
    }


    public static void main(String[] args) {
        Konexioa db = new Konexioa();
        try {
            Connection conn = db.konektatu();
            if (conn != null) {
                System.out.println("aaaa");
                conn.close(); 
            }
        } catch (SQLException e) {
            System.err.println("Mal:");
            e.printStackTrace();
        }
    }
}

