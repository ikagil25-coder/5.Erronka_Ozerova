
/**
 * Produktu orokorren klasea
 */
public class Produktuak {

    private int produktu_id;
    private String erreferentzia;
    private String izena;
    private String fabrikatzailea;
    private int pasilo_zbk;
    private int kokapen_id;
    private int mota;

    // Getters eta Setters
    /** @return produktuaren id-a */
    public int getProduktu_id() {
        return produktu_id;
    }

    /** @param produktu_id produktuaren id berria */
    public void setProduktu_id(int produktu_id) {
        this.produktu_id = produktu_id;
    }

    /** @return produktuaren erreferentzia */
    public String getErreferentzia() {
        return erreferentzia;
    }

    /** @param erreferentzia produktuaren erreferentzia berria */
    public void setErreferentzia(String erreferentzia) {
        this.erreferentzia = erreferentzia;
    }

    /** @return produktuaren izena */
    public String getIzena() {
        return izena;
    }

    /** @param izena produktuaren izen berria */
    public void setIzena(String izena) {
        this.izena = izena;
    }

    /** @return produktuaren fabrikatzailea */
    public String getFabrikatzailea() {
        return fabrikatzailea;
    }

    /** @param fabrikatzailea produktuaren fabrikatzaile berria */
    public void setFabrikatzailea(String fabrikatzailea) {
        this.fabrikatzailea = fabrikatzailea;
    }

    /** @return pasilo zenbakia */
    public int getPasilo_zbk() {
        return pasilo_zbk;
    }

    /** @param pasilo_zbk pasilo zenbaki berria */
    public void setPasilo_zbk(int pasilo_zbk) {
        this.pasilo_zbk = pasilo_zbk;
    }

    /** @return kokapen id-a */
    public int getKokapen_id() {
        return kokapen_id;
    }

    /** @param kokapen_id kokapen id berria */
    public void setKokapen_id(int kokapen_id) {
        this.kokapen_id = kokapen_id;
    }

    /** @return produktu mota */
    public int getMota() {
        return mota;
    }

    /** @param mota produktu mota berria */
    public void setMota(int mota) {
        this.mota = mota;
    }
}
