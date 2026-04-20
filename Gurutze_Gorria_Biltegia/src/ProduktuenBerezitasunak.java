public class ProduktuenBerezitasunak extends Produktuak {
    private String iraungitzeData;
    private boolean hozteaBeharrezkoa;

    public ProduktuenBerezitasunak(int id, String erreferentzia, String izena, String enpresa, String iraungitze_Data,
            boolean hozteaBeharrezkoa2) {
        this.iraungitzeData = iraungitzeData;
        this.hozteaBeharrezkoa = hozteaBeharrezkoa;
    }

    public ProduktuenBerezitasunak(int produktu_id, String erreferentzia, String izena, String fabrikatzailea,
            boolean kontserba) {
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
