public class main {
    public static void main(String[] args) {

        System.out.println("Ongi etorri Gurutze Gorria Biltegiaren kudeaketa sistemara!");
        System.out.println("Aukeratu erabiltzaile bat: 1. Admin 2. Kudeatzailea 3. Stock Kudeatzailea");

        String usuario = "admin";
        
        if(usuario.equals("admin")){
            System.out.println("Ongi etorri, admin!");

        }else if(usuario.equals("kudeatzailea")){
            System.out.println("Ongi etorri, kudeatzailea!");

        }else if(usuario.equals("stockKudeatzailea")){
            System.out.println("Ongi etorri, stock kudeatzailea!");
        }
    }
}
