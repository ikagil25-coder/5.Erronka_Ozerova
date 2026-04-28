import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Sarrerak eta irteerak kudeatzeko klasea
 */
public class SarrerakEtaIrteerak {
    private String idBiltegia;

    public SarrerakEtaIrteerak(String idBiltegia) {
        this.idBiltegia = idBiltegia;
    }

    //  SARRERAK ETA IRTEERAK 

    /**
     * Sarrera erregistratu
     * @param pId produktuaren ID-a
     * @param kantitatea sarreraren kantitatea
     * @param donatzailea donatzailearen izena
     * @param nanDonatzailea donatzailearen NAN-a
     */
    public void sarreraErregistratu(int pId, int kantitatea, String donatzailea, String nanDonatzailea) {
        String sqlSarrera = "INSERT INTO Sarrerak (id_produktuak, data, kantitatea, donatzailea) VALUES (?, CURDATE(), ?, ?)";
        String sqlDonazioa = "INSERT INTO Donazioak (id_produktuak, nan_donatzailea, kantitatea, data) VALUES (?, ?, ?, CURDATE())";
        String sqlStock = "UPDATE Stock SET kantitate_totala = kantitate_totala + ? WHERE id_produktuak = ?";

        try (Connection conn = Konexioa.konektatu()) {
            try (PreparedStatement psSarrera = conn.prepareStatement(sqlSarrera);
                 PreparedStatement psDonazioa = conn.prepareStatement(sqlDonazioa);
                 PreparedStatement psStock = conn.prepareStatement(sqlStock)) {

                psSarrera.setInt(1, pId);
                psSarrera.setInt(2, kantitatea);
                psSarrera.setString(3, donatzailea);
                psSarrera.executeUpdate();

                psDonazioa.setInt(1, pId);
                psDonazioa.setString(2, nanDonatzailea);
                psDonazioa.setInt(3, kantitatea);
                psDonazioa.executeUpdate();

                psStock.setInt(1, kantitatea);
                psStock.setInt(2, pId);
                psStock.executeUpdate();

                System.out.println("Sarrera ondo erregistratu da, donazioa gorde da eta stock-a eguneratu da.");

            }
        } catch (SQLException e) {
            System.out.println("Errorea sarrera egiterakoan...");
            e.printStackTrace();
        }
    }

    /**
     * Irteera erregistratu
     * @param pId produktuaren ID-a
     * @param kantitatea irteeraren kantitatea
     * @param helmuga nora bidaltzen den
     */
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

            try (PreparedStatement psIrteera = conn.prepareStatement(sqlIrteera);
                 PreparedStatement psStock = conn.prepareStatement(sqlStockUpdate)) {
                psIrteera.setInt(1, pId);
                psIrteera.setInt(2, kantitatea);
                psIrteera.setString(3, helmuga);
                psIrteera.executeUpdate();

                psStock.setInt(1, kantitatea);
                psStock.setInt(2, pId);
                psStock.executeUpdate();

                System.out.println("Irteera ondo erregistratu da.");

            }
        } catch (SQLException e) {
            System.out.println("Errorea irteera egiterakoan...");
            e.printStackTrace();
        }
    }

    //  BISTARATU 
    /**
     * Sarrera guztiak bistaratu
     */
    public void sarrerakBistaratu() {
        String sql = "SELECT * FROM Sarrerak";
        try (Connection conn = Konexioa.konektatu();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            System.out.println("\n--- SARRERAK ---");
            while (rs.next()) {
                System.out.println("ID Sarrera: " + rs.getInt("id_sarrera") + 
                                   " | Produktu ID: " + rs.getInt("id_produktuak") + 
                                   " | Kantitatea: " + rs.getInt("kantitatea") + 
                                   " | Donatzailea: " + rs.getString("donatzailea") + 
                                   " | Data: " + rs.getDate("data"));
            }
        } catch (SQLException e) {
            System.out.println("Errorea sarrerak bistaratzean...");
        }
    }

    /**
     * Irteera guztiak bistaratu
     */
    public void irteerakBistaratu() {
        String sql = "SELECT * FROM Irteerak";
        try (Connection conn = Konexioa.konektatu();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            System.out.println("\n--- IRTEERAK ---");
            while (rs.next()) {
                System.out.println("ID Irteera: " + rs.getInt("id_irteera") + 
                                   " | Produktu ID: " + rs.getInt("id_produktuak") + 
                                   " | Kantitatea: " + rs.getInt("kantitatea") + 
                                   " | Helmuga: " + rs.getString("helmuga") + 
                                   " | Data: " + rs.getDate("data"));
            }
        } catch (SQLException e) {
            System.out.println("Errorea irteerak bistaratzean...");
        }
    }

    // ALDATU
    /**
     * Sarrerak editatu
     * @param idSarrera sarreraren ID-a
     * @param donatzaileBerria donatzaile berriaren izena
     */
    public void sarreraAldatu(int idSarrera, String donatzaileBerria) {
        String sql = "UPDATE Sarrerak SET donatzailea = ? WHERE id_sarrera = ?";
        try (Connection conn = Konexioa.konektatu();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, donatzaileBerria);
            pstmt.setInt(2, idSarrera);
            pstmt.executeUpdate();
            System.out.println("Sarreraren donatzailea aldatu da!");
        } catch (SQLException e) {
            System.out.println("Errorea sarrera aldatzean...");
        }
    }

    /**
     * Irteerak aldatu
     * @param idIrteera irteeraren ID-a
     * @param helmugaBerria helmuga berria
     */
    public void irteeraAldatu(int idIrteera, String helmugaBerria) {
        String sql = "UPDATE Irteerak SET helmuga = ? WHERE id_irteera = ?";
        try (Connection conn = Konexioa.konektatu();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, helmugaBerria);
            pstmt.setInt(2, idIrteera);
            pstmt.executeUpdate();
            System.out.println("Irteeraren helmuga aldatu da!");
        } catch (SQLException e) {
            System.out.println("Errorea irteera aldatzean...");
        }
    }

    //  EZABATU 
    /**
     * Sarrera ezabatu
     * @param idSarrera ezabatu nahi den sarreraren ID-a
     */
    public void sarreraEzabatu(int idSarrera) {
        String sql = "DELETE FROM Sarrerak WHERE id_sarrera = ?";
        try (Connection conn = Konexioa.konektatu();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idSarrera);
            pstmt.executeUpdate();
            System.out.println("Sarrera ezabatu da!");
        } catch (SQLException e) {
            System.out.println("Errorea sarrera ezabatzean...");
        }
    }

    /**
     * Irteera ezabatu
     * @param idIrteera ezabatu nahi den irteeraren ID-a
     */
    public void irteeraEzabatu(int idIrteera) {
        String sql = "DELETE FROM Irteerak WHERE id_irteera = ?";
        try (Connection conn = Konexioa.konektatu();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idIrteera);
            pstmt.executeUpdate();
            System.out.println("Irteera ezabatu da!");
        } catch (SQLException e) {
            System.out.println("Errorea irteera ezabatzean...");
        }
    }
}
