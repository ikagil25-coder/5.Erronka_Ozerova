public class Main {
    public static void main(String[] args) {
        
        Stock stockKudeaketa = new Stock();
        SarrerakEtaIrteerak mugimenduak = new SarrerakEtaIrteerak();
        
       
        System.out.println("\n--- 1. Produktuak Sortzen eta BBDD-ra gehitzen ---");
        Iragankorra p1 = new Iragankorra(901, "REF-IR-901", "Esne freskoa", "Kaiku", 1, 1, 1, "2026-12-31", true);
        ErdiIragankorra p2 = new ErdiIragankorra(902, "REF-ER-902", "Olioa", "Urzu", 2, 2, 2, "2027-06-30", false, 40.5);
        EzIragankorra p3 = new EzIragankorra(903, "REF-EZ-903", "Lentejak", "Luengo", 3, 3, 3, false);
        EzIragankorra p4 = new EzIragankorra(904, "REF-EZ-904", "Atuna", "Isabel", 4, 4, 3, true);
        
        stockKudeaketa.produktuaGehitu(p1);
        stockKudeaketa.produktuaGehitu(p2);
        stockKudeaketa.produktuaGehitu(p3);
        stockKudeaketa.produktuaGehitu(p4);
        
        
        System.out.println("\n--- 2. Datu-basetik informazioa memoriara kargatzen ---");
        InformazioaKargatu kargatzailea = new InformazioaKargatu();
        java.util.ArrayList<Produktuak> nireStockMemoria = kargatzailea.kargatuInformazioa();
        
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