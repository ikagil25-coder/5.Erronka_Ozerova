import java.util.Scanner;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 1. Datu basetik informazioa kargatu
        // kargatuInformazioa(); 

        // 2. Hasierako datuak sortu
        hasieratudatuak();

        System.out.println("==========================================");
        System.out.println("GURUTZE GORRIA - Biltegi Kudeaketa");
        System.out.println("==========================================");
        
        System.out.println("Sartu zure erabiltzaile profila:");
        System.out.println("1. Admin");
        System.out.println("2. Kudeatzailea");
        System.out.println("3. Stock kudeatzailea");
        System.out.print("Aukera: ");
        
        int profilAukera = sc.nextInt();
        
        switch (profilAukera) {
            case 1:
                erakutsiAdminMenua();
                break;
            case 2:
                erakutsiSarreraIrteeraMenua();
                break;
            case 3:
                erakutsiStockMenua();
                break;
            default:
                System.out.println("Aukera okerra. Agur!");
                break;
        }
        
        sc.close();
    }

    private static void hasieratudatuak() {
        System.out.println("Sistemaren hasieratzea: 4 produktu gehitzen datu-basera...");
        // Deitu produktuakGehitu(Biltegia)
    }



    private static void erakutsiAdminMenua() {
        System.out.println("\n--- ADMINISTRATZAILE MENUA ---");
    }

    private static void erakutsiSarreraIrteeraMenua() {
        System.out.println("\n---  KUDEATZAILEA ---");
    }

    private static void erakutsiStockMenua() {
        System.out.println("\n--- STOCK KUDEATZAILEA ---");
    }
}