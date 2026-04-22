

public class Main {
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
                Menuak.erakutsiAdminMenua();
                break;
            case "kudeatzailea":
                Menuak.erakutsiSarreraIrteeraMenua();
                break;
            case "stock":
                Menuak.erakutsiStockMenua();
                break;
            default:
                System.out.println("Rola ez da zuzena.");
                break;
        }
    }
}