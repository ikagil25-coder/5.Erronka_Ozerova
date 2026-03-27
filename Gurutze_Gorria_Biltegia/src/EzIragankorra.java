public class EzIragankorra extends ProduktuenBerezitasunak {
    private boolean kontserba;

    public EzIragankorra(int produktu_id, String erreferentzia, String izena, String fabrikatzailea, boolean kontserba) {
        super(produktu_id, erreferentzia, izena, fabrikatzailea, kontserba);
        this.kontserba = kontserba;
    }

    // Getterrak
    public boolean isKontserba() { return kontserba; }

    // Setterrak
    public void setKontserba(boolean kontserba) { this.kontserba = kontserba; }
}
