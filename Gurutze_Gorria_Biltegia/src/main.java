import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Login loginProzesua = new Login();
        String rol = loginProzesua.logina();

        if (rol == null) {
            System.out.println("Erabiltzaile edo pasahitza okerra.");
            return;
        }

        System.out.println("\nOngi etorri! Zure rola: " + rol.toUpperCase());
        
        switch (rol.toLowerCase()) {
            case "admin":
                erakutsiAdminMenua();
                break;
            case "kudeatzailea":
                erakutsiSarreraIrteeraMenua();
                break;
            case "stock":
                erakutsiStockMenua();
                break;
            default:
                System.out.println("Rola ez da zuzena.");
                break;
        }
    }

    private static void erakutsiAdminMenua() {
        System.out.println("==========================================");
        System.out.println("MENUA: ADMINISTRATZAILEA");
        System.out.println("==========================================");
    }

    private static void erakutsiSarreraIrteeraMenua() {
        System.out.println("==========================================");
        System.out.println("MENUA: KUDEATZAILEA (Sarrerak/Irteerak)");
        System.out.println("==========================================");
    }

    private static void erakutsiStockMenua() {
        System.out.println("==========================================");
        System.out.println("MENUA: STOCK KUDEAKETA");
        System.out.println("==========================================");
    }
}