import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class Login {
public String logina() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Kaixo, sartu erabiltzailea:");
    String erabiltzailea = sc.nextLine();
    System.out.println("Kaixo, sartu pasahitza:");
    String pasahitza = sc.nextLine();

    String sql = "{call erabiltzaile_logina(?, ?, ?)}";
    String rolObtenido = null;

    try (Connection conn = Konexioa.konektatu(); 
         CallableStatement cstmt = conn.prepareCall(sql)) {

        cstmt.setString(1, erabiltzailea);
        cstmt.setString(2, pasahitza);
        cstmt.registerOutParameter(3, java.sql.Types.VARCHAR);
        
        cstmt.execute();
        rolObtenido = cstmt.getString(3);

    } catch (SQLException e) {
        e.printStackTrace();
    }
    return rolObtenido; 
}
}