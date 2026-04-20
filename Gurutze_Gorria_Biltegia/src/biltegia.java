import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Biltegia {

   private String biltegi_kodea;
   private String izena;
   private String kokapena;

   public void elikagaiakGorde() {
   }

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
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

         pstmt.executeUpdate();

         System.out.println("Hauek dira datu basean dauden produktuak!");

      } catch (SQLException e) {
         System.out.println("Errorea...");
         e.printStackTrace();
      }
   }

   public void stockGehienDuenProduktua() {
            Stri ng sql = "SELECT * FROM PRODUKTUAK ORDER BY stock DESC LI

   
   public void agortutakoProduktuak() {
      return;
   }

   public void donaziorikEzDutenProduktuak() {
      return;
   }
   p

      return biltegi_kodea;
   }

   public void setBiltegi_kodea(String biltegi_kodea) {
      this.biltegi_kodea = biltegi_kodea;
   }

   public String getIzena() {
      return izena;
   }

   public void setIzena(String izena) {
      this.izena = izena;
   }

   public String getKokapena() {
      return kokapena;

   }

   public void setKokapena(String kokapena) {
      this.kokapena = kokapena;
   }

}
