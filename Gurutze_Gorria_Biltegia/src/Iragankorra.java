public class Iragankorra extends ProduktuenBerezitasunak {
    private String iraungitzeData;
    private boolean hozteaBeharrezkoa;

    public Iragankorra(int id, String erreferentzia, String izena, String enpresa, String iraungitzeData, boolean hozteaBeharrezkoa) {
        super(id, erreferentzia, izena, enpresa);
        this.iraungitzeData = iraungitzeData;
        this.hozteaBeharrezkoa = hozteaBeharrezkoa;
    }

    // Getterrak
    public String getIraungitzeData() { return iraungitzeData; }
    public boolean isHozteaBeharrezkoa() { return hozteaBeharrezkoa; }

    // Setterrak
    public void setIraungitzeData(String iraungitzeData) { this.iraungitzeData = iraungitzeData; }
    public void setHozteaBeharrezkoa(boolean hozteaBeharrezkoa) { this.hozteaBeharrezkoa = hozteaBeharrezkoa; }
}
