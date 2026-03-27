public class ProduktuenBerezitasunak {
    protected int id;
    protected String erreferentzia;
    protected String izena;
    protected String enpresa;

    public ProduktuenBerezitasunak(int id, String erreferentzia, String izena, String enpresa) {
        this.id = id;
        this.erreferentzia = erreferentzia;
        this.izena = izena;
        this.enpresa = enpresa;
    }

    // Getterrak
    public int getId() {
        return id;
    }

    public String getErreferentzia() {
        return erreferentzia;
    }

    public String getIzena() {
        return izena;
    }

    public String getEnpresa() {
        return enpresa;
    }

    // Setterrak
    public void setId(int id) {
        this.id = id;
    }

    public void setErreferentzia(String erreferentzia) {
        this.erreferentzia = erreferentzia;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public void setEnpresa(String enpresa) {
        this.enpresa = enpresa;
    }

}
