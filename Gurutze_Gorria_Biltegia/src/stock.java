import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Stock {

    // --- CRUD METODOAK ---

    public void produktuaGehitu(Produktuak p) {
        String sql = "INSERT INTO Produktuak (id_produktuak, id_biltegia, erreferentzia, izena, fabrikatzailea, kokapen_id, mota) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Konexioa.konektatu();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, p.getProduktu_id());
            pstmt.setString(2, "BIL-001");
            pstmt.setString(3, p.getErreferentzia());
            pstmt.setString(4, p.getIzena());
            pstmt.setString(5, p.getFabrikatzailea());
            pstmt.setInt(6, p.getKokapen_id());
            pstmt.setInt(7, p.getMota());

            pstmt.executeUpdate();

            System.out.println("Produktua ondo gorde da datu basean!");

        } catch (SQLException e) {
            System.out.println("Errorea produktua gordetzean datu-basean...");
            e.printStackTrace();
        }
    }

    public void produktuaAldatu(Produktuak p) {
        String sql = "UPDATE Produktuak SET erreferentzia=?, izena=?, fabrikatzailea=?, kokapen_id=?, mota=? WHERE id_produktuak=?";

        try (Connection conn = Konexioa.konektatu();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, p.getErreferentzia());
            pstmt.setString(2, p.getIzena());
            pstmt.setString(3, p.getFabrikatzailea());
            pstmt.setInt(4, p.getKokapen_id());
            pstmt.setInt(5, p.getMota());
            pstmt.setInt(6, p.getProduktu_id());

            int eguneratuta = pstmt.executeUpdate();

            if (eguneratuta > 0) {
                System.out.println("Produktua ondo aldatu da!");
            } else {
                System.out.println("Ez da produkturik aurkitu ID horrekin.");
            }

        } catch (SQLException e) {
            System.out.println("Errorea produktua aldatzean datu-basean...");
            e.printStackTrace();
        }
    }

    public void produktuaEzabatu(int ezabatuId) {
        String sql = "DELETE FROM PRODUKTUAK WHERE id_produktuak=?";

        try (Connection conn = Konexioa.konektatu();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, ezabatuId);

            int ezabatuta = pstmt.executeUpdate();

            if (ezabatuta > 0) {
                System.out.println("Produktua ondo ezabatu da!");
            } else {
                System.out.println("Ez da produkturik aurkitu ID horrekin.");
            }

        } catch (SQLException e) {
            System.out.println("Errorea produktua ezabatzean datu-basean...");
            e.printStackTrace();
        }
    }

    public void produktuakBistaratu() {
        String sql = "SELECT * FROM PRODUKTUAK";

        try (Connection conn = Konexioa.konektatu();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()) {

            System.out.println("--- Datu basean dauden produktuak ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_produktuak") + " | Izena: " + rs.getString("izena"));
            }

        } catch (SQLException e) {
            System.out.println("Errorea...");
            e.printStackTrace();
        }
    }

    // --- STOCK KONTSULTAK ---

    public void stockGehienDuenProduktua() {
        String sql = "SELECT p.izena, s.kantitate_totala FROM Produktuak p JOIN Stock s ON p.id_produktuak = s.id_produktuak ORDER BY s.kantitate_totala DESC LIMIT 1";

        try (Connection conn = Konexioa.konektatu();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()) {

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

    public void agortutakoProduktuak() {
        String sql = "SELECT p.id_produktuak, p.izena, s.kantitate_totala FROM Produktuak p JOIN Stock s ON p.id_produktuak = s.id_produktuak WHERE s.kantitate_totala = 0";

        try (Connection conn = Konexioa.konektatu();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()) {

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
            System.out.println("Errorea stock ez duten produktuak lortzean...");
            e.printStackTrace();
        }
    }

    public void donaziorikEzDutenProduktuak() {
        String sql = "SELECT p.id_produktuak, p.izena, p.erreferentzia FROM Produktuak p LEFT JOIN Donazioak d ON p.id_produktuak = d.id_produktuak WHERE d.id_donazioa IS NULL";

        try (Connection conn = Konexioa.konektatu();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()) {

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
