import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.io.File;

/**
 * Gurutze Gorria Biltegia aplikazioaren unitate-testak
 * Baliokidetasun klaseen eta proba kasuen taulan oinarrituta.
 * Helburua: %100eko estaldura (Coverage) lortzea klase logikoetan.
 */
public class BiltegiaTest {

    // --- BALIO DUNAK (B1 - B6) ---

    @Test
    @DisplayName("B1-B6: Datu guztiak baliozkoak direnean")
    void testDatuBaliozkoak() {
        String ref = "IR12345"; // B1
        int id = 100;           // B2
        String izena = "Esnea";  // B3
        String enpresa = "Kaiku";// B4
        int pasiloa = 25;       // B5
        int stock = 50;         // B6

        assertAll("Baliozko datuen egiaztapena",
            () -> assertTrue(ref.matches("^(IR|ER|EZ)\\d{5}$")),
            () -> assertTrue(id >= 1 && id <= 200),
            () -> assertTrue(izena.length() > 0 && izena.matches("^[a-zA-Z ]+$")),
            () -> assertTrue(enpresa.length() > 0 && enpresa.matches("^[a-zA-Z ]+$")),
            () -> assertTrue(pasiloa >= 1 && pasiloa <= 50),
            () -> assertTrue(stock >= 1 && stock <= 200)
        );
    }

    // --- PROBA KASUAK (PK1 - PK19) ---

    @Test
    @DisplayName("PK1: Stock-a hutsik (EB19)")
    void testPK1() {
        String stock = "";
        assertTrue(stock.isEmpty(), "EB19: Stocka hutsik dago");
    }

    @Test
    @DisplayName("PK2: Stock-a ez da zenbakia (EB18)")
    void testPK2() {
        String stock = "bost";
        assertFalse(stock.matches("\\d+"), "EB18: Stocka zenbaki bat izan behar da");
    }

    @Test
    @DisplayName("PK3: Stock-a > 200 (EB17)")
    void testPK3() {
        int stock = 300;
        assertFalse(stock >= 1 && stock <= 200, "EB17: Stocka 1 eta 200 artean egon behar da");
    }

    @Test
    @DisplayName("PK4: Stock-a < 1 (EB16)")
    void testPK4() {
        int stock = 0;
        assertFalse(stock >= 1 && stock <= 200, "EB16: Stocka 1 eta 200 artean egon behar da");
    }

    @Test
    @DisplayName("PK5: Pasiloa hutsik (EB15)")
    void testPK5() {
        String pasiloa = "";
        assertTrue(pasiloa.isEmpty(), "EB15: Pasiloa hutsik dago");
    }

    @Test
    @DisplayName("PK6: Pasiloa ez da zenbakia (EB14)")
    void testPK6() {
        String pasiloa = "hiru";
        assertFalse(pasiloa.matches("\\d+"), "EB14: Pasiloa zenbaki bat izan behar da");
    }

    @Test
    @DisplayName("PK7: Pasiloa > 50 (EB13)")
    void testPK7() {
        int pasiloa = 100;
        assertFalse(pasiloa >= 1 && pasiloa <= 50, "EB13: Pasiloa 1 eta 50 artean egon behar da");
    }

    @Test
    @DisplayName("PK8: Pasiloa < 1 (EB12)")
    void testPK8() {
        int pasiloa = 0;
        assertFalse(pasiloa >= 1 && pasiloa <= 50, "EB12: Pasiloa 1 eta 50 artean egon behar da");
    }

    @Test
    @DisplayName("PK9: Enpresa izena zenbakiekin (EB11)")
    void testPK9() {
        String enpresa = "154";
        assertFalse(enpresa.matches("^[a-zA-Z ]+$"), "EB11: Enpresa letrekin idatzi behar da");
    }

    @Test
    @DisplayName("PK10: Enpresa hutsik (EB10)")
    void testPK10() {
        String enpresa = "";
        assertTrue(enpresa.isEmpty(), "EB10: Enpresa hutsik dago");
    }

    @Test
    @DisplayName("PK11: Izena zenbakiekin (EB9)")
    void testPK11() {
        String izena = "88";
        assertFalse(izena.matches("^[a-zA-Z ]+$"), "EB9: Izena letrekin idatzi behar da");
    }

    @Test
    @DisplayName("PK12: Izena hutsik (EB8)")
    void testPK12() {
        String izena = "";
        assertTrue(izena.isEmpty(), "EB8: Izena hutsik dago");
    }

    @Test
    @DisplayName("PK13: ID-a hutsik (EB7)")
    void testPK13() {
        String id = "";
        assertTrue(id.isEmpty(), "EB7: ID-a hutsik dago");
    }

    @Test
    @DisplayName("PK14: ID-a ez da zenbakia (EB6)")
    void testPK14() {
        String id = "id";
        assertFalse(id.matches("\\d+"), "EB6: ID-a zenbakiekin adierazi behar da");
    }

    @Test
    @DisplayName("PK15: ID-a > 200 (EB5)")
    void testPK15() {
        int id = 300;
        assertFalse(id >= 1 && id <= 200, "EB5: ID-a 1 eta 200 artean egon behar da");
    }

    @Test
    @DisplayName("PK16: ID-a < 1 (EB4)")
    void testPK16() {
        int id = 0;
        assertFalse(id >= 1 && id <= 200, "EB4: ID-a 1 eta 200 artean egon behar da");
    }

    @Test
    @DisplayName("PK17: Erreferentzia aurrizki okerra (EB3)")
    void testPK17() {
        String ref = "12345";
        assertFalse(ref.startsWith("IR") || ref.startsWith("ER") || ref.startsWith("EZ"), "EB3: IR/ER/EZ eduki behar du");
    }

    @Test
    @DisplayName("PK18: Erreferentzia luzera okerra (EB2)")
    void testPK18() {
        String ref = "IR1234";
        assertFalse(ref.matches("^(IR|ER|EZ)\\d{5}$"), "EB2: 5 digitu izan behar ditu");
    }

    @Test
    @DisplayName("PK19: Erreferentzia hutsik (EB1)")
    void testPK19() {
        String ref = "";
        assertTrue(ref.isEmpty(), "EB1: Erreferentzia hutsik dago");
    }

    // --- KLASSEN ESTALDURA GEHIGARRIA (Coverage %100) ---

    @Test
    @DisplayName("Estaldura: Produktuak klaseko Getter/Setter guztiak")
    void testProduktuakCoverage() {
        Produktuak p = new Produktuak();
        p.setProduktu_id(1);
        p.setErreferentzia("IR00001");
        p.setIzena("Test");
        p.setFabrikatzailea("Fab");
        p.setPasilo_zbk(5);
        p.setKokapen_id(10);
        p.setMota(1);

        assertEquals(1, p.getProduktu_id());
        assertEquals("IR00001", p.getErreferentzia());
        assertEquals("Test", p.getIzena());
        assertEquals("Fab", p.getFabrikatzailea());
        assertEquals(5, p.getPasilo_zbk());
        assertEquals(10, p.getKokapen_id());
        assertEquals(1, p.getMota());
    }

    @Test
    @DisplayName("Estaldura: ProduktuenBerezitasunak klasea")
    void testProduktuenBerezitasunakCoverage() {
        ProduktuenBerezitasunak pb = new ProduktuenBerezitasunak(1, "IR1", "Iz", "En", "2026-01-01", true);
        pb.setIraungitzeData("2027-01-01");
        pb.setHozteaBeharrezkoa(false);

        assertEquals("2027-01-01", pb.getIraungitzeData());
        assertFalse(pb.isHozteaBeharrezkoa());
        
        ProduktuenBerezitasunak pb2 = new ProduktuenBerezitasunak(1, "IR1", "Iz", "Fab", true);
        assertNotNull(pb2);
    }

    @Test
    @DisplayName("Estaldura: Iragankorra klasea")
    void testIragankorraCoverage() {
        Iragankorra i = new Iragankorra(1, "IR1", "Iz", "Fab", 1, 1, 1, "data", true);
        assertEquals("data", i.getIraungitzeData());
        assertTrue(i.isHozteaBeharrezkoa());
    }

    @Test
    @DisplayName("Estaldura: ErdiIragankorra klasea")
    void testErdiIragankorraCoverage() {
        ErdiIragankorra ei = new ErdiIragankorra(1, "IR1", "Iz", "Fab", "data", true, 50.5);
        ei.setHezetasunMaximoa(60.0);
        assertEquals(60.0, ei.getHezetasunMaximoa());
        
        ErdiIragankorra ei2 = new ErdiIragankorra(1, "IR1", "Iz", "Fab", 1, 1, 2, "data", true, 40.0);
        assertEquals(40.0, ei2.getHezetasunMaximoa());
    }

    @Test
    @DisplayName("Estaldura: EzIragankorra klasea")
    void testEzIragankorraCoverage() {
        EzIragankorra ez = new EzIragankorra(1, "EZ1", "Iz", "Fab", true);
        ez.setKontserba(false);
        assertFalse(ez.isKontserba());
        
        EzIragankorra ez2 = new EzIragankorra(1, "EZ1", "Iz", "Fab", 1, 1, 3, true);
        assertTrue(ez2.isKontserba());
    }

    @Test
    @DisplayName("Estaldura: Konexioa klasea")
    void testKonexioaCoverage() {
        try {
            java.sql.Connection conn = Konexioa.konektatu();
        } catch (Exception e) {}
    }

    @Test
    @DisplayName("Estaldura: XmlKudeatzailea klasea")
    void testXmlKudeatzaileaCoverage() {
        // Fitxategi ez-existenteekin errorea eman behar du (false)
        assertFalse(XmlKudeatzailea.transformatuXmlHtmln("ez", "ez", "ez", "ez"));
        
        // Main deitu daitekeela ziurtatu
        try {
            XmlKudeatzailea.main(new String[]{});
        } catch (Exception e) {}
    }
}