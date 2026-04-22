public class ErdiIragankorra extends ProduktuenBerezitasunak {

    private double hezetasunMaximoa;

    public ErdiIragankorra(int produktu_id, String erreferentzia, String izena, String fabrikatzailea,
            String iraungitzeData, boolean hozteaBeharrezkoa, double hezetasunMaximoa) {
        super(produktu_id, erreferentzia, izena, fabrikatzailea, iraungitzeData, hozteaBeharrezkoa);
        this.hezetasunMaximoa = hezetasunMaximoa;
    }

    public ErdiIragankorra(int produktu_id, String erreferentzia, String izena, String fabrikatzailea, 
                           int pasilo_zbk, int kokapen_id, int mota,
                           String iraungitzeData, boolean hozteaBeharrezkoa, double hezetasunMaximoa) {
        super(produktu_id, erreferentzia, izena, fabrikatzailea, 
              pasilo_zbk, kokapen_id, mota, 
              iraungitzeData, hozteaBeharrezkoa);
        this.hezetasunMaximoa = hezetasunMaximoa;
    }

    public double getHezetasunMaximoa() {
        return hezetasunMaximoa;
    }

    public void setHezetasunMaximoa(double hezetasunMaximoa) {
        this.hezetasunMaximoa = hezetasunMaximoa;
    }

}
