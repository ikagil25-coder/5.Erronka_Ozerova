public class ErdiIragankorra extends ProduktuenBerezitasunak {
    private String iraungitzeData;
    private boolean hozteaBeharrezkoa;
    private double hezetasunMaximoa;

    public ErdiIragankorra(int id, String erreferentzia, String izena, String enpresa, String iraungitzeData, boolean hozteaBeharrezkoa, double hezetasunMaximoa) {
        super(id, erreferentzia, izena, enpresa);
        this.iraungitzeData = iraungitzeData;
        this.hozteaBeharrezkoa = hozteaBeharrezkoa;
        this.hezetasunMaximoa = hezetasunMaximoa;
    }

    // Getterrak
    public String getIraungitzeData() { return iraungitzeData; }
    public boolean isHozteaBeharrezkoa() { return hozteaBeharrezkoa; }
    public double getHezetasunMaximoa() { return hezetasunMaximoa; }

    // Setterrak
    public void setIraungitzeData(String iraungitzeData) { this.iraungitzeData = iraungitzeData; }
    public void setHozteaBeharrezkoa(boolean hozteaBeharrezkoa) { this.hozteaBeharrezkoa = hozteaBeharrezkoa; }
    public void setHezetasunMaximoa(double hezetasunMaximoa) { this.hezetasunMaximoa = hezetasunMaximoa; }
}
