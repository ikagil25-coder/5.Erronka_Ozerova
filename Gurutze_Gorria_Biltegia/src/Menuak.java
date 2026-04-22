import java.util.Scanner;

public class Menuak {

    public static void erakutsiAdminMenua() {
        Scanner sc = new Scanner(System.in);
        boolean irten = false;

        while (!irten) {
            System.out.println("\n--- ADMINISTRATZAILE MENUA ---");
            System.out.println("1. Kudeatzaile menua erabili (Sarrerak/Irteerak)");
            System.out.println("2. Stock kudeatzaile menua erabili (Produktuak)");
            System.out.println("0. Irten / Saioa itxi");
            System.out.print("Aukeratu zenbaki bat: ");

            String aukera = sc.nextLine();

            switch (aukera) {
                case "1":
                    erakutsiSarreraIrteeraMenua();
                    break;
                case "2":
                    erakutsiStockMenua();
                    break;
                case "0":
                    irten = true;
                    System.out.println("Saioa ixten...");
                    break;
                default:
                    System.out.println("Zenbaki okerra, saiatu berriro.");
                    break;
            }
        }
    }

    public static void erakutsiSarreraIrteeraMenua() {
        Scanner sc = new Scanner(System.in);
        SarrerakEtaIrteerak kudeaketa = new SarrerakEtaIrteerak(); // Zure klase berria
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
                    System.out.println("Idatzi produktuaren ID-a:");
                    int sarreraId = Integer.parseInt(sc.nextLine());

                    System.out.println("Zenbat unitate sartuko dira?");
                    int sarreraKantitatea = Integer.parseInt(sc.nextLine());

                    System.out.println("Zein da donatzailea?");
                    String donatzailea = sc.nextLine();

                    
                    kudeaketa.sarreraErregistratu(sarreraId, sarreraKantitatea, donatzailea);
                    break;

                case "2":
                    System.out.println("Idatzi produktuaren ID-a:");
                    int irteeraId = Integer.parseInt(sc.nextLine());

                    System.out.println("Zenbat unitate aterako dira?");
                    int irteeraKantitatea = Integer.parseInt(sc.nextLine());

                    System.out.println("Nora bidaliko dira? (Helmuga)");
                    String helmuga = sc.nextLine();

                    
                    kudeaketa.irteeraErregistratu(irteeraId, irteeraKantitatea, helmuga);
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
            System.out.println("3. Produktua ezabatu");
            System.out.println("4. Produktuak bistaratu");
            System.out.println("5. Stock gehien duen produktua bueltatu");
            System.out.println("6. Agortutako produktuak bueltatu");
            System.out.println("7. Donaziorik ez duten produktuak bueltatu ");
            System.out.println("0. Irten");
            System.out.print("Aukeratu zenbaki bat: ");
            Stock nireStock = new Stock();
            String aukera = sc.nextLine();
            switch (aukera) {

                case "1":
                    System.out.println("Zenbat produktu gehitu nahi dituzu?");
                    int kopurua = Integer.parseInt(sc.nextLine());

                    for (int i = 0; i < kopurua; i++) {
                        System.out.println("\n--- " + (i + 1) + ". produktua sartzen ---");
                        Produktuak p = new Produktuak();

                        System.out.println("Idatzi produktuaren izena:");
                        p.setIzena(sc.nextLine());

                        System.out.println("Idatzi produktuaren ID-a (Zenbakia bakarrik):");
                        p.setProduktu_id(Integer.parseInt(sc.nextLine()));

                        System.out.println("Idatzi produktuaren erreferentzia (Adib: IR12345, ER12345, EZ12345):");
                        p.setErreferentzia(sc.nextLine().toUpperCase());
                       

                        System.out.println("Idatzi produktuaren fabrikatzailea");
                        p.setFabrikatzailea(sc.nextLine());

                        System.out.println("Idatzi produktuaren pasillo zenbakia");
                        p.setPasilo_zbk(Integer.parseInt(sc.nextLine()));

                        System.out.println("Idatzi produktuaren kokapen ID-a (Zenbakia):");
                        p.setKokapen_id(Integer.parseInt(sc.nextLine()));
                        
                        System.out.println("Idatzi produktu mota (1-Iragankorra, 2-Erdi, 3-Ez):");
                        p.setMota(Integer.parseInt(sc.nextLine()));
if(p.getMota()==1){
    
}
                        nireStock.produktuaGehitu(p);
                    }
                    System.out.println("\nProzesua amaitu da. Produktu guztiak datu-basean sartu dira.");
                    break;

                case "2":
                    Produktuak pAldatu = new Produktuak();

                    System.out.println("Idatzi aldatu nahi duzun produktuaren ID-a:");
                    int aldatuId = Integer.parseInt(sc.nextLine());
                    pAldatu.setProduktu_id(aldatuId);

                    System.out.println("Idatzi izen berria:");
                    String izenBerria = sc.nextLine();
                    pAldatu.setIzena(izenBerria);

                    System.out.println("Idatzi erreferentzia berria (Adib: IR12345, ER12345, EZ12345):");
                    String errBerria = sc.nextLine();
                    pAldatu.setErreferentzia(errBerria);

                    System.out.println("Idatzi fabrikatzaile berria:");
                    String fabBerria = sc.nextLine();
                    pAldatu.setFabrikatzailea(fabBerria);

                    System.out.println("Idatzi kokapen ID berria:");
                    int kokBerria = Integer.parseInt(sc.nextLine());
                    pAldatu.setKokapen_id(kokBerria);

                    System.out.println("Idatzi mota berria (1-Iragankorra, 2-Erdi, 3-Ez):");
                    int motaBerria = Integer.parseInt(sc.nextLine());
                    pAldatu.setMota(motaBerria);

                    nireStock.produktuaAldatu(pAldatu);
                    break;

                case "3":
                    System.out.println("Idatzi ezabatu nahi duzun produktuaren ID-a:");
                    int ezabatuId = Integer.parseInt(sc.nextLine());
                    nireStock.produktuaEzabatu(ezabatuId);
                    break;
                case "4":
                    nireStock.produktuakBistaratu();
                    break;
                case "5":
                    nireStock.stockGehienDuenProduktua();
                    break;
                case "6":
                    nireStock.agortutakoProduktuak();
                    break;
                case "7":
                    nireStock.donaziorikEzDutenProduktuak();
                    break;
                case "0":
                    irten = true;
                    System.out.println("Menutik ateratzen...");
                    break;
                default:
                    System.out.println("Sartu duzun zenbakia ez da zuzena, saiatu berriro.");
                    break;
            }
            sc.close();
        }
    }
}
