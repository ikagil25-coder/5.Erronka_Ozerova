import java.util.Scanner;

public class Menuak {

    public static void erakutsiAdminMenua() {
        Scanner sc = new Scanner(System.in);

        boolean irten = false;
        while (!irten) {
            System.out.println("Administratzaile menua");
            System.out.println("1.Kudeatzaile menua erabili");
            System.out.println("2.Stock kudeatzaile menua erabili");
            // System.out.println("3.Beste gauz batzuk egin");
            System.out.println("Aukeratu zenbaki bat");

            String aukera = sc.nextLine();

            switch (aukera) {
                case "1":
                    erakutsiSarreraIrteeraMenua();
                    break;
                case "2":
                    erakutsiStockMenua();
                    break;
                case "3":
                    // cosas del admin
                    break;
                case "0":
                    irten = true;
                    System.out.println("Ateratzen...");
                    break;

                default:
                    System.out.println("Zenbaki okerra");
                    break;

            }

        }

    }

    public static void erakutsiSarreraIrteeraMenua() {
        Scanner sc = new Scanner(System.in);
        boolean irten = false;
        while (!irten) {
            System.out.println("\n---  KUDEATZAILEA ---");
            System.out.println("1. Sarrera berria sortu");
            System.out.println("2. Irteera berria sortu");
            System.out.println("0. Irten");
            System.out.print("Aukeratu zenbaki bat: ");

            String aukera = sc.nextLine();

            switch (aukera) {
                case "1":
                    // Sarrera berria sortu
                    break;
                case "2":
                    // Irteera berria sortu
                    break;
                case "0":
                    irten = true;
                    System.out.println("Menutik ateratzen...");
                    break;
                default:
                    System.out.println("Sartu duzun zenbakia ez da zuzena, saiatu berriro.");
                    break;
            }
        }
    }

    public static void erakutsiStockMenua() {
        Scanner sc = new Scanner(System.in);
        boolean irten = false;

        while (!irten) {
            System.out.println("\n--- STOCK KUDEATZAILEA ---");
            System.out.println("1. Produktua gehitu");
            System.out.println("2. Produktua aldatu");
            System.out.println("3. Produktuak bistaratu");
            System.out.println("0. Irten");
            System.out.print("Aukeratu zenbaki bat: ");
            biltegia nireBiltegia = new biltegia();
            String aukera = sc.nextLine();
            switch (aukera) {

                case "1":
                    produktuak p = new produktuak();
                    
                    System.out.println("Idatzi produktuaren izena:");
                    String izena = sc.nextLine();
                    p.setIzena(izena);
                    
                    System.out.println("Idatzi produktuaren ID-a (Zenbakia bakarrik):");
                    int id = Integer.parseInt(sc.nextLine());
                    p.setProduktu_id(id);

                    System.out.println("Idatzi produktuaren erreferentzia");
                    String erreferentzia=sc.nextLine();
                    p.setErreferentzia(erreferentzia);

                    System.out.println("Idatzi produktu mota (1-Iragankorra, 2-Erdi, 3-Ez):");
                    int mota = Integer.parseInt(sc.nextLine());
                    p.setMota(mota);

                    System.out.println("Idatzi produktuaren fabrikatzailea");
                    String fabrikatzailea= sc.nextLine();
                    p.setFabrikatzailea(fabrikatzailea);

                    System.out.println("Idatzi produktuaren pasillo zenbakia");
                    int pasilloznb = Integer.parseInt(sc.nextLine());
                    p.setPasilo_zbk(pasilloznb);

                    System.out.println("Idatzi produktuaren kokapen ID-a (Zenbakia):");
                    int kokapen_id = Integer.parseInt(sc.nextLine());
                    p.setKokapen_id(kokapen_id);



                    
                    
                    nireBiltegia.produktuaGehitu(p);
                    break;
                    
                case "2":
                    // nireBiltegia.produktuaAldatu(...);
                    break;
                case "3":
                    // nireBiltegia.produktuakBistaratu();
                    break;
                case "0":
                    irten = true;
                    System.out.println("Menutik ateratzen...");
                    break;
                default:
                    System.out.println("Sartu duzun zenbakia ez da zuzena, saiatu berriro.");
                    break;
            }
        }
    }
}
