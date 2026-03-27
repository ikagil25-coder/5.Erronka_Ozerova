public class EzIragankorra extends ProduktuenBerezitasunak {
    private boolean kontserba;

    public EzIragankorra(int id, String erreferentzia, String izena, String enpresa, boolean kontserba) {
        super(id, erreferentzia, izena, enpresa);
        this.kontserba = kontserba;
    }

    // Getterrak
    public boolean isKontserba() { return kontserba; }

    // Setterrak
    public void setKontserba(boolean kontserba) { this.kontserba = kontserba; }
}
