import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SarrerakEtaIrteerak {
    // --- SARRERAK ETA IRTEERAK ---

    public void sarreraErregistratu(int pId, int kantitatea, String donatzailea) {
        String sqlSarrera = "INSERT INTO Sarrerak (id_produktuak, data, kantitatea, donatzailea) VALUES (?, CURDATE(), ?, ?)";
        String sqlStock = "UPDATE Stock SET kantitate_totala = kantitate_totala + ? WHERE id_produktuak = ?";

        try (Connection conn = Konexioa.konektatu()) {
            conn.setAutoCommit(false);

            try (PreparedStatement psSarrera = conn.prepareStatement(sqlSarrera);
                    PreparedStatement psStock = conn.prepareStatement(sqlStock)) {

                psSarrera.setInt(1, pId);
                psSarrera.setInt(2, kantitatea);
                psSarrera.setString(3, donatzailea);
                psSarrera.executeUpdate();

                psStock.setInt(1, kantitatea);
                psStock.setInt(2, pId);
                psStock.executeUpdate();

                conn.commit();
                System.out.println("Sarrera ondo erregistratu da eta stock-a eguneratu da.");

            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }
        } catch (SQLException e) {
            System.out.println("Errorea sarrera egiterakoan...");
            e.printStackTrace();
        }
    }

    public void irteeraErregistratu(int pId, int kantitatea, String helmuga) {
        String sqlStockCheck = "SELECT kantitate_totala FROM Stock WHERE id_produktuak = ?";
        String sqlIrteera = "INSERT INTO Irteerak (id_produktuak, kantitatea, helmuga, data) VALUES (?, ?, ?, CURDATE())";
        String sqlStockUpdate = "UPDATE Stock SET kantitate_totala = kantitate_totala - ? WHERE id_produktuak = ?";

        try (Connection conn = Konexioa.konektatu()) {

            try (PreparedStatement psCheck = conn.prepareStatement(sqlStockCheck)) {
                psCheck.setInt(1, pId);
                ResultSet rs = psCheck.executeQuery();

                if (rs.next()) {
                    int unekoStocka = rs.getInt("kantitate_totala");
                    if (unekoStocka < kantitatea) {
                        System.out.println("ERROREA: Ez dago nahikoa stock (Unean: " + unekoStocka + ")");
                        return;
                    }
                } else {
                    System.out.println("ERROREA: Produktua ez da stock-ean aurkitu.");
                    return;
                }
            }

            conn.setAutoCommit(false);

            try (PreparedStatement psIrteera = conn.prepareStatement(sqlIrteera);
                    PreparedStatement psStock = conn.prepareStatement(sqlStockUpdate)) {
                psIrteera.setInt(1, pId);
                psIrteera.setInt(2, kantitatea);
                psIrteera.setString(3, helmuga);
                psIrteera.executeUpdate();

                // 3. Stock-a eguneratu (Kenketa)
                psStock.setInt(1, kantitatea);
                psStock.setInt(2, pId);
                psStock.executeUpdate();

                conn.commit();
                System.out.println("Irteera ondo erregistratu da.");

            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }
        } catch (SQLException e) {
            System.out.println("Errorea irteera egiterakoan...");
            e.printStackTrace();
        }
    }

}
