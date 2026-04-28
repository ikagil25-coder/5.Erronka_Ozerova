/**
 * Biltegiaren objektua
 */
public class Biltegia {

   private String biltegi_kodea;
   private String izena;
   private String kokapena;

   /**
    * Elikagaiak gorde (metodo hau ez dago inplementatuta)
    */
   public void elikagaiakGorde() {
   }

   /** @return biltegi kodea */
   public String getBiltegi_kodea() {
      return biltegi_kodea;
   }

   /** @param biltegi_kodea biltegi kode berria */
   public void setBiltegi_kodea(String biltegi_kodea) {
      this.biltegi_kodea = biltegi_kodea;
   }

   /** @return biltegiaren izena */
   public String getIzena() {
      return izena;
   }

   /** @param izena biltegi izen berria */
   public void setIzena(String izena) {
      this.izena = izena;
   }

   /** @return biltegiaren kokapena */
   public String getKokapena() {
      return kokapena;
   }

   /** @param kokapena biltegi kokapen berria */
   public void setKokapena(String kokapena) {
      this.kokapena = kokapena;
   }

}
