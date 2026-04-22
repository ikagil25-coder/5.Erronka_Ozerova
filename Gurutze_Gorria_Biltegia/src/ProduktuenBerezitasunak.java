public class ProduktuenBerezitasunak extends Produktuak {
    private String iraungitzeData;
    private boolean hozteaBeharrezkoa;

    public ProduktuenBerezitasunak() {
        super();
    }

    public ProduktuenBerezitasunak(int id, String erreferentzia, String izena, String enpresa, String iraungitze_Data,
            boolean hozteaBeharrezkoa2) {
        this.iraungitzeData = iraungitzeData;
        this.hozteaBeharrezkoa = hozteaBeharrezkoa;
    }

    public ProduktuenBerezitasunak(int produktu_id, String erreferentzia, String izena, String fabrikatzailea,
            boolean kontserba) {
    }

    public ProduktuenBerezitasunak(int produktu_id, String erreferentzia, String izena, String fabrikatzailea, 
                                   int pasilo_zbk, int kokapen_id, int mota,
                                   String iraungitzeData, boolean hozteaBeharrezkoa) {
        super();
        this.setProduktu_id(produktu_id);
        this.setErreferentzia(erreferentzia);
        this.setIzena(izena);
        this.setFabrikatzailea(fabrikatzailea);
        this.setPasilo_zbk(pasilo_zbk);
        this.setKokapen_id(kokapen_id);
        this.setMota(mota);
        
        this.iraungitzeData = iraungitzeData;
        this.hozteaBeharrezkoa = hozteaBeharrezkoa;
    }

    public String getIraungitzeData() {
        return iraungitzeData;
    }

    public void setIraungitzeData(String iraungitzeData) {
        this.iraungitzeData = iraungitzeData;
    }

    public boolean isHozteaBeharrezkoa() {
        return hozteaBeharrezkoa;
    }

    public void setHozteaBeharrezkoa(boolean hozteaBeharrezkoa) {
        this.hozteaBeharrezkoa = hozteaBeharrezkoa;
    }
}
