import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {
    @SuppressWarnings("resource")
    public String logina() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Kaixo, sartu erabiltzailea:");
        String erabiltzailea = sc.nextLine();
        System.out.println("Kaixo, sartu pasahitza:");
        String pasahitza = sc.nextLine();

        String sql = "SELECT r.deskribapena FROM Erabiltzaileak e JOIN Rola r ON e.id_rola = r.id_rola WHERE e.izena = ? AND e.pasahitza = ?";
        String rolObtenido = null;

        try (Connection conn = Konexioa.konektatu();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, erabiltzailea);
            pstmt.setString(2, pasahitza);

            try (ResultSet rs = pstmt.executeQuery()) {
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