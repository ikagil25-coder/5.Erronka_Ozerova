import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Test {

    @Test
    void testPK1() {
        String stock = "";
        assertTrue(stock.isEmpty());
    }

    @Test
    void testPK2() {
        String stock = "bost";
        assertFalse(stock.matches("\\d+"));
    }

    @Test
    void testPK3() {
        int stock = 300;
        assertFalse(stock <= 200);
    }

    @Test
    void testPK4() {
        int stock = 0;
        assertFalse(stock >= 1);
    }

    @Test
    void testPK5() {
        String pasiloa = "";
        assertTrue(pasiloa.isEmpty());
    }

    @Test
    void testPK6() {
        String pasiloa = "hiru";
        assertFalse(pasiloa.matches("\\d+"));
    }

    @Test
    void testPK7() {
        int pasiloa = 100;
        assertFalse(pasiloa <= 50);
    }

    @Test
    void testPK8() {
        int pasiloa = 0;
        assertFalse(pasiloa >= 1);
    }

    @Test
    void testPK9() {
        String enpresa = "154";
        assertFalse(enpresa.matches("^[a-zA-Z]+$"));
    }

    @Test
    void testPK10() {
        String enpresa = "";
        assertEquals(0, enpresa.length());
    }

    @Test
    void testPK11() {
        String izena = "88";
        assertFalse(izena.matches("^[a-zA-Z]+$"));
    }

    @Test
    void testPK12() {
        String izena = "";
        assertTrue(izena.length() == 0);
    }

    @Test
    void testPK13() {
        String id = "";
        assertTrue(id.equals(""));
    }

    @Test
    void testPK14() {
        String id = "id";
        assertFalse(id.matches("\\d+"));
    }

    @Test
    void testPK15() {
        int id = 300;
        assertFalse(id <= 200);
    }

    @Test
    void testPK16() {
        int id = 0;
        assertFalse(id >= 1);
    }

    @Test
    void testPK17() {
        String ref = "12345";
        assertFalse(ref.startsWith("IR") || ref.startsWith("ER") || ref.startsWith("EZ"));
    }

    @Test
    void testPK18() {
        String ref = "IR1234";
        assertFalse(ref.length() == 7);
    }

    @Test
    void testPK19() {
        String ref = "";
        assertTrue(ref.isEmpty());
    }
}