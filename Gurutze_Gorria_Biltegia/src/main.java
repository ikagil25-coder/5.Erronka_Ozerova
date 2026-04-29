import java.util.Scanner;

/**
 * Programa nagusia
 */
public class Main {
    /**
     * Logina biltegi aukeraketa eta menua
     * @param args komando lerroko argumentuak
     */
    public static void main(String[] args) {

        System.out.println("\n--- Gurutze Gorria Biltegia - Sartu zure datuak ---");
        Login loginProzesua = new Login();
        String rol = loginProzesua.logina();

        if (rol == null) {
            System.out.println("Erabiltzaile edo pasahitza okerra.");
            return;
        }

        System.out.println("\nOngi etorri! Zure rola: " + rol.toUpperCase());

        // Admin-ek biltegi bat aukeratu behar du
        Scanner sc = new Scanner(System.in);
        System.out.println("\nZe biltegi kudeatuko duzu? (BIL-001 / BIL-002)");
        String biltegiKodea = sc.nextLine().toUpperCase();

        switch (rol.toLowerCase()) {
            case "admin":
            case "administratzailea":
                Menuak.erakutsiAdminMenua(biltegiKodea);
                break;
            case "kudeatzaile":
            case "kudeatzailea":
                Menuak.erakutsiSarreraIrteeraMenua(biltegiKodea);
                break;
            case "stock":
            case "stock langilea":
                Menuak.erakutsiStockMenua(biltegiKodea);
                break;
            default:
                System.out.println("Rola ez da zuzena.");
                break;
        }sc.close();
    }
}