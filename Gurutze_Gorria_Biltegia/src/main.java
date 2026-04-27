public class Main {
    public static void main(String[] args) {
        
        Stock stockKudeaketa = new Stock();
        SarrerakEtaIrteerak mugimenduak = new SarrerakEtaIrteerak();
        
        System.out.println("\n--- Gurutze Gorria Biltegia - Sartu zure datuak ---");
        Login loginProzesua = new Login();
        String rol = loginProzesua.logina();

        if (rol == null) {
            System.out.println("Erabiltzaile edo pasahitza okerra.");
            return;
        }

        System.out.println("\nOngi etorri! Zure rola: " + rol.toUpperCase());

        switch (rol.toLowerCase()) {
            case "admin":
            case "administratzailea":
                Menuak.erakutsiAdminMenua();
                break;
            case "kudeatzaile":
            case "kudeatzailea":
                Menuak.erakutsiSarreraIrteeraMenua();
                break;
            case "stock":
            case "stock langilea":
                Menuak.erakutsiStockMenua();
                break;
            default:
                System.out.println("Rola ez da zuzena.");
                break;
        }
    }
}