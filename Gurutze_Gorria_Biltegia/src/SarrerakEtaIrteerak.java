import java.sql.CallableStatement;
import java.sql.Connection;
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
        String sql = "{CALL sarreraErregistratu(?, ?, ?, ?)}";

        try (Connection conn = Konexioa.konektatu();
             CallableStatement cstmt = conn.prepareCall(sql)) {

            cstmt.setInt(1, pId);
            cstmt.setInt(2, kantitatea);
            cstmt.setString(3, donatzailea);
            cstmt.setString(4, nanDonatzailea);
            cstmt.execute();

            System.out.println("Sarrera ondo erregistratu da!");

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
        String sql = "{CALL irteeraErregistratu(?, ?, ?)}";

        try (Connection conn = Konexioa.konektatu();
             CallableStatement cstmt = conn.prepareCall(sql)) {

            cstmt.setInt(1, pId);
            cstmt.setInt(2, kantitatea);
            cstmt.setString(3, helmuga);
            
            // El procedimiento ya comprueba el stock y devuelve un error si falla
            cstmt.execute();
            System.out.println("Irteera ondo erregistratu da.");

        } catch (SQLException e) {
            // Capturamos el mensaje de error personalizado del procedimiento (SIGNAL)
            System.out.println(e.getMessage());
        }
    }

    //  BISTARATU 
    /**
     * Sarrera guztiak bistaratu
     */
    public void sarrerakBistaratu() {
        String sql = "{CALL sarrerakBistaratu()}";
        try (Connection conn = Konexioa.konektatu();
             CallableStatement cstmt = conn.prepareCall(sql);
             ResultSet rs = cstmt.executeQuery()) {
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
        String sql = "{CALL irteerakBistaratu()}";
        try (Connection conn = Konexioa.konektatu();
             CallableStatement cstmt = conn.prepareCall(sql);
             ResultSet rs = cstmt.executeQuery()) {
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
     * @param kantitateBerria kantitate berria
     * @param donatzaileBerria donatzaile berriaren izena
     */
    public void sarreraAldatu(int idSarrera, int kantitateBerria, String donatzaileBerria) {
        String sql = "{CALL sarreraAldatu(?, ?, ?)}";
        try (Connection conn = Konexioa.konektatu();
             CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setInt(1, idSarrera);
            cstmt.setInt(2, kantitateBerria);
            cstmt.setString(3, donatzaileBerria);
            cstmt.executeUpdate();
            System.out.println("Sarrera aldatu da!");
        } catch (SQLException e) {
            System.out.println("Errorea sarrera aldatzean...");
        }
    }

    /**
     * Irteerak aldatu
     * @param idIrteera irteeraren ID-a
     * @param kantitateBerria kantitate berria
     * @param helmugaBerria helmuga berria
     */
    public void irteeraAldatu(int idIrteera, int kantitateBerria, String helmugaBerria) {
        String sql = "{CALL irteeraAldatu(?, ?, ?)}";
        try (Connection conn = Konexioa.konektatu();
             CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setInt(1, idIrteera);
            cstmt.setInt(2, kantitateBerria);
            cstmt.setString(3, helmugaBerria);
            cstmt.executeUpdate();
            System.out.println("Irteera aldatu da!");
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
        String sql = "{CALL sarreraEzabatu(?)}";
        try (Connection conn = Konexioa.konektatu();
             CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setInt(1, idSarrera);
            cstmt.executeUpdate();
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
        String sql = "{CALL irteeraEzabatu(?)}";
        try (Connection conn = Konexioa.konektatu();
             CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setInt(1, idIrteera);
            cstmt.executeUpdate();
            System.out.println("Irteera ezabatu da!");
        } catch (SQLException e) {
            System.out.println("Errorea irteera ezabatzean...");
        }
    }
}
