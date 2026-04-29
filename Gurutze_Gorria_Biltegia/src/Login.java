import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Login sistema kudeatzeko klasea
 */
public class Login {
    /**
     * Identifikatu erabiltzailea eta rola bueltatzen
     * @return String erabiltzailearen rola, edo null baldin okerra bada
     */
    public String logina() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Kaixo, sartu erabiltzailea:");
        String erabiltzailea = sc.nextLine();
        System.out.println("Kaixo, sartu pasahitza:");
        String pasahitza = sc.nextLine();

        String sql = "{CALL logina(?, ?)}";
        String rolObtenido = null;

        try (Connection conn = Konexioa.konektatu();
                CallableStatement cstmt = conn.prepareCall(sql)) {

            cstmt.setString(1, erabiltzailea);
            cstmt.setString(2, pasahitza);

            try (ResultSet rs = cstmt.executeQuery()) {
                if (rs.next()) {
                    rolObtenido = rs.getString("deskribapena");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rolObtenido;
    }
}