import java.util.Scanner;

/**
 * Menua bistaratzeko klasea
 */
public class Menuak {

    /**
     * Admin menua
     * 
     * @param biltegiKodea biltegiaren kodea
     */
    public static void erakutsiAdminMenua(String biltegiKodea) {
        Scanner sc = new Scanner(System.in);
        boolean irten = false;

        while (!irten) {
            System.out.println("\n--- ADMINISTRATZAILE MENUA (" + biltegiKodea + ") ---");
            System.out.println("1. Kudeatzaile menua erabili (Sarrerak/Irteerak)");
            System.out.println("2. Stock kudeatzaile menua erabili (Produktuak)");
            System.out.println("0. Irten / Saioa itxi");
            System.out.print("Aukeratu zenbaki bat: ");

            String aukera = sc.nextLine();

            switch (aukera) {
                case "1":
                    erakutsiSarreraIrteeraMenua(biltegiKodea);
                    break;
                case "2":
                    erakutsiStockMenua(biltegiKodea);
                    break;
                case "0":
                    irten = true;
                    System.out.println("Saioa ixten...");
                    break;
                default:
                    System.out.println("Zenbaki okerra, saiatu berriro.");
                    break;
                  
            }  sc.close();
        }
    }

    /**
     * Kudeatzaile menua
     * 
     * @param biltegiKodea biltegiaren kodea
     */
    public static void erakutsiSarreraIrteeraMenua(String biltegiKodea) {
        Scanner sc = new Scanner(System.in);
        SarrerakEtaIrteerak kudeaketa = new SarrerakEtaIrteerak(biltegiKodea);
        boolean irten = false;

        while (!irten) {

            System.out.println("\n---  KUDEATZAILEA ---");
            System.out.println("1. Sarrera berria sortu");
            System.out.println("2. Irteera berria sortu");
            System.out.println("3. Sarrerak bistaratu");
            System.out.println("4. Sarrera aldatu (Donatzailea)");
            System.out.println("5. Sarrera ezabatu");
            System.out.println("6. Irteerak bistaratu");
            System.out.println("7. Irteera aldatu (Helmuga)");
            System.out.println("8. Irteera ezabatu");
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

                    System.out.println("Idatzi donatzailearen NAN-a (9 karaktere, adib: 12345678A):");
                    String nanDonatzailea = sc.nextLine();

                    kudeaketa.sarreraErregistratu(sarreraId, sarreraKantitatea, donatzailea, nanDonatzailea);
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

                case "3":
                    kudeaketa.sarrerakBistaratu();
                    break;

                case "4":
                    System.out.println("Idatzi aldatu nahi duzun sarreraren ID-a:");
                    int sAldatuId = Integer.parseInt(sc.nextLine());
                    System.out.println("Idatzi kantitate berria:");
                    int sKantBerria = Integer.parseInt(sc.nextLine());
                    System.out.println("Idatzi donatzaile berria:");
                    String donBerria = sc.nextLine();
                    kudeaketa.sarreraAldatu(sAldatuId, sKantBerria, donBerria);
                    break;

                case "5":
                    System.out.println("Idatzi ezabatu nahi duzun sarreraren ID-a:");
                    int sEzabatuId = Integer.parseInt(sc.nextLine());
                    kudeaketa.sarreraEzabatu(sEzabatuId);
                    break;

                case "6":
                    kudeaketa.irteerakBistaratu();
                    break;

                case "7":
                    System.out.println("Idatzi aldatu nahi duzun irteeraren ID-a:");
                    int iAldatuId = Integer.parseInt(sc.nextLine());
                    System.out.println("Idatzi kantitate berria:");
                    int iKantBerria = Integer.parseInt(sc.nextLine());
                    System.out.println("Idatzi helmuga berria:");
                    String helBerria = sc.nextLine();
                    kudeaketa.irteeraAldatu(iAldatuId, iKantBerria, helBerria);
                    break;

                case "8":
                    System.out.println("Idatzi ezabatu nahi duzun irteeraren ID-a:");
                    int iEzabatuId = Integer.parseInt(sc.nextLine());
                    kudeaketa.irteeraEzabatu(iEzabatuId);
                    break;

                case "0":
                    irten = true;
                    System.out.println("Menutik ateratzen...");
                    break;

                default:
                    System.out.println("Sartu duzun zenbakia ez da zuzena, saiatu berriro.");
                    break;
            }
        }sc.close();
    }

    /**
     * Stock menua
     * 
     * @param biltegiKodea biltegiaren kodea
     */
    public static void erakutsiStockMenua(String biltegiKodea) {
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
            Stock nireStock = new Stock(biltegiKodea);
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

                        try {
                            System.out.println("Idatzi produktuaren erreferentzia (Adib: IR12345, ER12345, EZ12345):");
                            String erreferentzia = sc.nextLine().toUpperCase();
                            if (!erreferentzia.matches("^(IR|ER|EZ)\\d{5}$")) {
                                throw new Exception("ERROREA: Formatu okerra!");
                            }
                            p.setErreferentzia(erreferentzia);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            System.out.println("Produktuaren sorkuntza bertan behera utzi da. Saiatu berriro.");
                            break;
                        }

                        System.out.println("Idatzi produktuaren fabrikatzailea");
                        p.setFabrikatzailea(sc.nextLine());

                        System.out.println("Idatzi produktuaren pasillo zenbakia");
                        p.setPasilo_zbk(Integer.parseInt(sc.nextLine()));

                        System.out.println("Idatzi produktuaren kokapen ID-a (Zenbakia):");
                        p.setKokapen_id(Integer.parseInt(sc.nextLine()));

                        System.out.println("Idatzi produktu mota (1-Iragankorra, 2-Erdi, 3-Ez):");
                        int mota = Integer.parseInt(sc.nextLine());

                        if (mota == 1) {
                            System.out.println("Idatzi iraugitze data (mm/dd/yyyy):");
                            String iraungitzeData = sc.nextLine();

                            System.out.println("Behar du hoztea?(true/false)");
                            boolean hoztea = Boolean.parseBoolean(sc.nextLine());

                            p = new Iragankorra(
                                    p.getProduktu_id(), p.getErreferentzia(), p.getIzena(), p.getFabrikatzailea(),
                                    p.getPasilo_zbk(), p.getKokapen_id(), p.getMota(),
                                    iraungitzeData, hoztea);
                        } else if (mota == 2) {
                            System.out.println("Idatzi iraugitze data (mm/dd/yyyy):");
                            String iraungitzeData = sc.nextLine();

                            System.out.println("Behar du hoztea?(true/false)");
                            boolean hoztea = Boolean.parseBoolean(sc.nextLine());
                            System.out.println("Idatzi hezetasun maximoa ");
                            double hezetasuna = Double.parseDouble(sc.nextLine());

                            p = new ErdiIragankorra(p.getProduktu_id(),
                                    p.getErreferentzia(),
                                    p.getIzena(),
                                    p.getFabrikatzailea(),
                                    p.getPasilo_zbk(),
                                    p.getKokapen_id(),
                                    p.getMota(),
                                    iraungitzeData,
                                    hoztea,
                                    hezetasuna);
                        } else if (mota == 3) {
                            System.out.println("Produktua kontserba bat da?(true/false)");
                            boolean kontserba = Boolean.parseBoolean(sc.nextLine());

                            p = new EzIragankorra(p.getProduktu_id(),
                                    p.getErreferentzia(),
                                    p.getIzena(),
                                    p.getFabrikatzailea(),
                                    p.getPasilo_zbk(),
                                    p.getKokapen_id(),
                                    p.getMota(),
                                    kontserba);
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

                    try {
                        System.out.println("Idatzi erreferentzia berria (Adib: IR12345, ER12345, EZ12345):");
                        String errBerria = sc.nextLine().toUpperCase();

                        if (!errBerria.matches("^(IR|ER|EZ)\\d{5}$")) {
                            throw new Exception("Erreferentziaren formatua ez da zuzena (IR-EZ-ER + 5 zenbaki)");
                        }
                        pAldatu.setErreferentzia(errBerria);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        System.out.println("Aldaketa ez da egin, saiatu berriro");
                        break;
                    }

                    System.out.println("Idatzi fabrikatzaile berria:");
                    String fabBerria = sc.nextLine();
                    pAldatu.setFabrikatzailea(fabBerria);

                    System.out.println("Idatzi kokapen ID berria:");
                    int kokBerria = Integer.parseInt(sc.nextLine());
                    pAldatu.setKokapen_id(kokBerria);

                    System.out.println("Idatzi mota berria (1-Iragankorra, 2-Erdi, 3-Ez):");
                    int motaBerria = Integer.parseInt(sc.nextLine());

                    if (motaBerria == 1) {
                        System.out.println("Idatzi iraugitze data (mm/dd/yyyy):");
                        String iraungitzeData = sc.nextLine();
                        System.out.println("Behar du hoztea?(true/false)");
                        boolean hoztea = Boolean.parseBoolean(sc.nextLine());

                        pAldatu = new Iragankorra(
                                pAldatu.getProduktu_id(), pAldatu.getErreferentzia(), pAldatu.getIzena(),
                                pAldatu.getFabrikatzailea(), pAldatu.getPasilo_zbk(), pAldatu.getKokapen_id(),
                                motaBerria,
                                iraungitzeData, hoztea);
                    } else if (motaBerria == 2) {
                        System.out.println("Idatzi iraugitze data (mm/dd/yyyy):");
                        String iraungitzeData = sc.nextLine();
                        System.out.println("Behar du hoztea?(true/false)");
                        boolean hoztea = Boolean.parseBoolean(sc.nextLine());
                        System.out.println("Idatzi hezetasun maximoa:");
                        double hezetasuna = Double.parseDouble(sc.nextLine());

                        pAldatu = new ErdiIragankorra(
                                pAldatu.getProduktu_id(), pAldatu.getErreferentzia(), pAldatu.getIzena(),
                                pAldatu.getFabrikatzailea(), pAldatu.getPasilo_zbk(), pAldatu.getKokapen_id(),
                                motaBerria,
                                iraungitzeData, hoztea, hezetasuna);
                    } else if (motaBerria == 3) {
                        System.out.println("Produktua kontserba bat da?(true/false)");
                        boolean kontserba = Boolean.parseBoolean(sc.nextLine());

                        pAldatu = new EzIragankorra(
                                pAldatu.getProduktu_id(), pAldatu.getErreferentzia(), pAldatu.getIzena(),
                                pAldatu.getFabrikatzailea(), pAldatu.getPasilo_zbk(), pAldatu.getKokapen_id(),
                                motaBerria,
                                kontserba);
                    } else {
                        pAldatu.setMota(motaBerria);
                    }

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
        }sc.close();
    }
}
