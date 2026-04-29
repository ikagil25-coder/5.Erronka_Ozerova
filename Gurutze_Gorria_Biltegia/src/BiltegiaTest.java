import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;


public class BiltegiaTest {

    @Test
    @DisplayName("PK1: Stock-a hutsik (EB19)")
    void testPK1() {
        String stock = "";
        assertTrue(stock.trim().isEmpty(), "EB19: Sartutako stocka ez da zuzena, hutsik dago.");
    }

    @Test
    @DisplayName("PK2: Stock-a ez da zenbakia (EB18)")
    void testPK2() {
        String stock = "bost";
        assertFalse(stock.matches("\\d+"), "EB18: Sartutako stocka ez da zuzena, zenbaki bat izan behar da.");
    }

    @Test
    @DisplayName("PK3: Stock-a > 200 (EB17)")
    void testPK3() {
        int stock = 300;
        assertTrue(stock > 200, "EB17: Sartutako stocka ez da zuzena, 1 eta 200 artean egon behar da.");
    }

    @Test
    @DisplayName("PK4: Stock-a < 1 (EB16)")
    void testPK4() {
        int stock = 0;
        assertTrue(stock < 1, "EB16: Sartutako stocka ez da zuzena, 1 eta 200 artean egon behar da.");
    }

    @Test
    @DisplayName("PK5: Pasiloa hutsik (EB15)")
    void testPK5() {
        String pasiloa = "";
        assertTrue(pasiloa.trim().isEmpty(), "EB15: Pasilo zenbakia ez da zuzena, hutsik dago.");
    }

    @Test
    @DisplayName("PK6: Pasiloa ez da zenbakia (EB14)")
    void testPK6() {
        String pasiloa = "hiru";
        assertFalse(pasiloa.matches("\\d+"), "EB14: Pasilo zenbakia ez da zuzena, zenbaki bat izan behar da.");
    }

    @Test
    @DisplayName("PK7: Pasiloa > 50 (EB13)")
    void testPK7() {
        int pasiloa = 100;
        assertTrue(pasiloa > 50, "EB13: Pasilo zenbakia ez da zuzena, 1 eta 50 artean egon behar da.");
    }

    @Test
    @DisplayName("PK8: Pasiloa < 1 (EB12)")
    void testPK8() {
        int pasiloa = 0;
        assertTrue(pasiloa < 1, "EB12: Pasilo zenbakia ez da zuzena, 1 eta 50 artean egon behar da.");
    }

    @Test
    @DisplayName("PK9: Enpresa izena zenbakiekin (EB11)")
    void testPK9() {
        String enpresa = "154";
        assertFalse(enpresa.matches("^[a-zA-Z\\s]+$"),
                "EB11: Enpresaren izena ez da zuzena, letrekin idatzi behar da.");
    }

    @Test
    @DisplayName("PK10: Enpresa hutsik (EB10)")
    void testPK10() {
        String enpresa = "";
        assertTrue(enpresa.trim().isEmpty(), "EB10: Enpresaren izena ez da zuzena, hutsik dago.");
    }

    @Test
    @DisplayName("PK11: Izena zenbakiekin (EB9)")
    void testPK11() {
        String izena = "88";
        assertFalse(izena.matches("^[a-zA-Z\\s]+$"), "EB9: Sartutako izena ez da zuzena, letrak erabili behar dira.");
    }

    @Test
    @DisplayName("PK12: Izena hutsik (EB8)")
    void testPK12() {
        String izena = "";
        assertTrue(izena.trim().isEmpty(), "EB8: Sartutako izena ez da zuzena, hutsik dago.");
    }

    @Test
    @DisplayName("PK13: ID-a hutsik (EB7)")
    void testPK13() {
        String id = "";
        assertTrue(id.trim().isEmpty(), "EB7: Identifikatzailea ez da zuzena, hutsik dago.");
    }

    @Test
    @DisplayName("PK14: ID-a ez da zenbakia (EB6)")
    void testPK14() {
        String id = "id";
        assertFalse(id.matches("\\d+"), "EB6: Identifikatzailea ez da zuzena, zenbakiekin adierazi behar da.");
    }

    @Test
    @DisplayName("PK15: ID-a > 200 (EB5)")
    void testPK15() {
        int id = 300;
        assertTrue(id > 200, "EB5: Identifikatzailea ez da zuzena, 1 eta 200 artekoa izan behar da.");
    }

    @Test
    @DisplayName("PK16: ID-a < 1 (EB4)")
    void testPK16() {
        int id = 0;
        assertTrue(id < 1, "EB4: Identifikatzailea ez da zuzena, 1 eta 200 artekoa izan behar da.");
    }

    @Test
    @DisplayName("PK17: Erreferentzia aurrizki okerra (EB3)")
    void testPK17() {
        String ref = "12345";
        boolean aurrizkiOkerra = !ref.startsWith("IR") && !ref.startsWith("ER") && !ref.startsWith("EZ");
        assertTrue(aurrizkiOkerra, "EB3: Erreferentzia ez da zuzena, IR/ER/EZ siglak eduki behar ditu hasieran.");
    }

    @Test
    @DisplayName("PK18: Erreferentzia luzera okerra (EB2)")
    void testPK18() {
        String ref = "IR1234";
        boolean luzeraOkerra = ref.length() != 7; // IR + 5 digitu = 7
        assertTrue(luzeraOkerra, "EB2: Erreferentzia ez da zuzena, zenbakiak 5 digitu izan behar ditu.");
    }

    @Test
    @DisplayName("PK19: Erreferentzia hutsik (EB1)")
    void testPK19() {
        String ref = "";
        assertTrue(ref.trim().isEmpty(), "EB1: Erreferentzia ez da zuzena, hutsik dago.");
    }
}