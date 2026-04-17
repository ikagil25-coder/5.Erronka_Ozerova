import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class biltegia {

   private String biltegi_kodea;
   private String izena;
   private String kokapena;

   public void elikagaiakGorde() {
   }

   public void produktuaGehitu(produktuak p) {
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

   public void produktuaAldatu() {
   }

   public void produtuakAldatu() {
   }

   public void produktuakEzabatu() {
   }

   public void produktuakBistaratu() {
   }

   public String getBiltegi_kodea() {
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
