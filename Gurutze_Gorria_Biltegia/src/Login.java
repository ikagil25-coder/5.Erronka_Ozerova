import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class Login {

    public void Login() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Kaixo, sartu erabiltzailea mesedez:");
        String erabiltzailea = sc.nextLine();
        System.out.println("Kaixo, sartu pasahitza mesedez:");
        String pasahitza = sc.nextLine();
        sc.close();

        String sql = "{call erabiltzaile_logina(?, ?, ?)}";

        try (
                Connection conn = Konexioa.konektatu();
                CallableStatement cstmt = conn.prepareCall(sql)) {

            cstmt.setString(1, erabiltzailea);
            cstmt.setString(2, pasahitza);
            cstmt.registerOutParameter(3, Types.VARCHAR);

            cstmt.execute();
            String rolObtenido = cstmt.getString(3);

            if (rolObtenido != null) {
                System.out.println("Acceso exitoso. Rol: " + rolObtenido);
            } else {
                System.out.println("Credenciales incorrectas.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}