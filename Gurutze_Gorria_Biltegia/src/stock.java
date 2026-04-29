import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Stock-a kudeatzeko klasea
 */
public class Stock {
    private String idBiltegia;

    public Stock(String idBiltegia) {
        this.idBiltegia = idBiltegia;
    }

    // --- CRUD METODOAK ---

    /**
     * Produktua gehitu datu basera
     * 
     * @param p produktu objektua
     */
    public void produktuaGehitu(Produktuak p) {
        String sql = "{CALL produktuaGehitu(?, ?, ?, ?, ?, ?, ?)}";

        try (Connection conn = Konexioa.konektatu();
                CallableStatement cstmt = conn.prepareCall(sql)) {

            cstmt.setInt(1, p.getProduktu_id());
            cstmt.setString(2, this.idBiltegia);
            cstmt.setString(3, p.getErreferentzia());
            cstmt.setString(4, p.getIzena());
            cstmt.setString(5, p.getFabrikatzailea());
            cstmt.setInt(6, p.getKokapen_id());
            cstmt.setInt(7, p.getMota());

            cstmt.execute();
            System.out.println("Produktua ondo gorde da datu basean!");

        } catch (SQLException e) {
            System.out.println("Errorea produktua gordetzean...");
            e.printStackTrace();
        }
    }

    /**
     * Produktua aldatu
     * 
     * @param p produktu objektua datu berriekin
     */
    public void produktuaAldatu(Produktuak p) {
        String sql = "{CALL produktuaAldatu(?, ?, ?, ?, ?, ?)}";

        try (Connection conn = Konexioa.konektatu();
                CallableStatement cstmt = conn.prepareCall(sql)) {

            cstmt.setString(1, p.getErreferentzia());
            cstmt.setString(2, p.getIzena());
            cstmt.setString(3, p.getFabrikatzailea());
            cstmt.setInt(4, p.getKokapen_id());
            cstmt.setInt(5, p.getMota());
            cstmt.setInt(6, p.getProduktu_id());

            int eguneratuta = cstmt.executeUpdate();

            if (eguneratuta > 0) {
                System.out.println("Produktua ondo aldatu da!");
            } else {
                System.out.println("Ez da produkturik aurkitu ID horrekin.");
            }

        } catch (SQLException e) {
            System.out.println("Errorea produktua aldatzean...");
            e.printStackTrace();
        }
    }

    /**
     * Produktua ezabatu datu basetik
     * 
     * @param ezabatuId produktuaren ID-a
     */
    public void produktuaEzabatu(int ezabatuId) {
        String sql = "{CALL produktuaEzabatu(?)}";

        try (Connection conn = Konexioa.konektatu();
                CallableStatement cstmt = conn.prepareCall(sql)) {

            cstmt.setInt(1, ezabatuId);
            int ezabatuta = cstmt.executeUpdate();

            if (ezabatuta > 0) {
                System.out.println("Produktuaren stock-a ondo ezabatu da (0-ra pasatu da)!");
            } else {
                System.out.println("Ez da produkturik aurkitu ID horrekin.");
            }

        } catch (SQLException e) {
            System.out.println("Errorea produktuaren stocka ezabatzean...");
            e.printStackTrace();
        }
    }

    /**
     * Produktu guztiak ikusi
     */
    public void produktuakBistaratu() {
        String sql = "{CALL produktuakBistaratu()}";

        try (Connection conn = Konexioa.konektatu();
                CallableStatement cstmt = conn.prepareCall(sql);
                ResultSet rs = cstmt.executeQuery()) {

            System.out.println("--- Datu basean dauden produktuak ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_produktuak") + " | Izena: " + rs.getString("izena"));
            }

        } catch (SQLException e) {
            System.out.println("Errorea bistaratzean...");
            e.printStackTrace();
        }
    }

    // STOCK KONTSULTAK

    /**
     * Stock gehien duen produktua ikusi
     */
    public void stockGehienDuenProduktua() {
        String sql = "{CALL stockGehienDuenProduktua()}";

        try (Connection conn = Konexioa.konektatu();
                CallableStatement cstmt = conn.prepareCall(sql);
                ResultSet rs = cstmt.executeQuery()) {

            if (rs.next()) {
                String izena = rs.getString("izena");
                int kantitatea = rs.getInt("kantitate_totala");
                System.out.println("Emaitza: " + izena + " (" + kantitatea + " unitate)");
            } else {
                System.out.println("Ez da produkturik aurkitu.");
            }

        } catch (SQLException e) {
            System.out.println("Errorea stock gehien duen produktua lortzean...");
            e.printStackTrace();
        }
    }

    /**
     * Agortutako produktuak ikusi
     */
    public void agortutakoProduktuak() {
        String sql = "{CALL agortutakoProduktuak()}";

        try (Connection conn = Konexioa.konektatu();
                CallableStatement cstmt = conn.prepareCall(sql);
                ResultSet rs = cstmt.executeQuery()) {

            System.out.println("--- Agortutako Produktuak ---");
            boolean badago = false;
            while (rs.next()) {
                badago = true;
                int id = rs.getInt("id_produktuak");
                String izena = rs.getString("izena");
                System.out.println("ID: " + id + " | Izena: " + izena + " | Stock: 0");
            }
            if (!badago)
                System.out.println("Ez dago agortutako produkturik.");

        } catch (SQLException e) {
            System.out.println("Errorea agortutako produktuak lortzean...");
            e.printStackTrace();
        }
    }

    /**
     * Donaziorik ez duten produktuak ikusi
     */
    public void donaziorikEzDutenProduktuak() {
        String sql = "{CALL donaziorikEzDutenProduktuak()}";

        try (Connection conn = Konexioa.konektatu();
                CallableStatement cstmt = conn.prepareCall(sql);
                ResultSet rs = cstmt.executeQuery()) {

            System.out.println("--- Donaziorik ez duten produktuak ---");
            boolean badago = false;
            while (rs.next()) {
                badago = true;
                int id = rs.getInt("id_produktuak");
                String izena = rs.getString("izena");
                String ref = rs.getString("erreferentzia");
                System.out.println("ID: " + id + " | Izena: " + izena + " | Ref: " + ref);
            }
            if (!badago)
                System.out.println("Produktu guztiek dituzte donazioak.");

        } catch (SQLException e) {
            System.out.println("Errorea donaziorik ez duten produktuak lortzean...");
            e.printStackTrace();
        }
    }
}
