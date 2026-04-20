import java.sql.*;

public class Prueba {
    public void ikusi() {
        Konexioa db = new Konexioa();

        try (Connection conexion = db.konektatu()) {
            String sql = "SELECT izena FROM Biltegia";
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString("izena"));
            }
        } catch (Exception e) {
            System.out.println("Errorea: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Prueba p = new Prueba();
        p.ikusi();
    }
}
