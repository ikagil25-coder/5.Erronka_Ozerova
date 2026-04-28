/**
 * Produktu ez-iragankorren klasea
 */
public class EzIragankorra extends ProduktuenBerezitasunak {
    private boolean kontserba;

    public EzIragankorra(int produktu_id, String erreferentzia, String izena, String fabrikatzailea,
            boolean kontserba) {
        super(produktu_id, erreferentzia, izena, fabrikatzailea, kontserba);
        this.kontserba = kontserba;
    }

    public EzIragankorra(int produktu_id, String erreferentzia, String izena, String fabrikatzailea, 
                         int pasilo_zbk, int kokapen_id, int mota,
                         boolean kontserba) {
        super();
        this.setProduktu_id(produktu_id);
        this.setErreferentzia(erreferentzia);
        this.setIzena(izena);
        this.setFabrikatzailea(fabrikatzailea);
        this.setPasilo_zbk(pasilo_zbk);
        this.setKokapen_id(kokapen_id);
        this.setMota(mota);
        this.kontserba = kontserba;
    }

    // Getterrak
    public boolean isKontserba() {
        return kontserba;
    }

    // Setterrak
    public void setKontserba(boolean kontserba) {
        this.kontserba = kontserba;
    }
}
