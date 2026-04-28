import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Datu basearekiko konexioa kudeatzeko klasea
 */
public class Konexioa {

    private static final String URL = "jdbc:mysql://localhost:3306/GG_Biltegia";
    private static final String USER = "root";
    private static final String PASSWORD = "gabrielito10";

    /**
     * Konexioa egin
     * @return Connection datu basearen konexioa
     * @throws SQLException konexioa ezin bada egin
     */
    public static Connection konektatu() throws SQLException {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        return conn;
    }

    public static void main(String[] args) {
        Konexioa db = new Konexioa();
        try {
            Connection conn = db.konektatu();
            if (conn != null) {
                System.out.println("Konexioa ondo burutu da!");
                conn.close();
            }
        } catch (SQLException e) {
            System.err.println("Errorea datu-basearekin:");
            e.printStackTrace();
        }
    }
}
