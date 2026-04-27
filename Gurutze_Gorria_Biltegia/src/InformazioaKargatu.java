import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InformazioaKargatu {

    public ArrayList<Produktuak> kargatuInformazioa() {
        ArrayList<Produktuak> produktuZerrenda = new ArrayList<>();
        String sqlProduktuak = "SELECT * FROM Produktuak";

        try (Connection conn = Konexioa.konektatu();
                PreparedStatement pstmt = conn.prepareStatement(sqlProduktuak);
                ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id_produktuak");
                int mota = rs.getInt("mota");
                String ref = rs.getString("erreferentzia");
                String izena = rs.getString("izena");
                String fab = rs.getString("fabrikatzailea");
                int pasilo = rs.getInt("pasilo_zbk");
                int kokapen = rs.getInt("kokapen_id");

                if (mota == 1) {
                    String sqlIra = "SELECT * FROM Iragankorrak WHERE id_produktuak = ?";
                    try (PreparedStatement psIra = conn.prepareStatement(sqlIra)) {
                        psIra.setInt(1, id);
                        ResultSet rsIra = psIra.executeQuery();
                        if (rsIra.next()) {
                            Iragankorra pIra = new Iragankorra(id, ref, izena, fab, pasilo, kokapen, mota,
                                    rsIra.getString("iraungitze_data"), rsIra.getBoolean("hoztea"));
                            produktuZerrenda.add(pIra);
                        }
                    }
                } else if (mota == 2) {
                    String sqlErdi = "SELECT * FROM Erdi_Iragankorrak WHERE id_produktuak = ?";
                    try (PreparedStatement psErdi = conn.prepareStatement(sqlErdi)) {
                        psErdi.setInt(1, id);
                        ResultSet rsErdi = psErdi.executeQuery();
                        if (rsErdi.next()) {
                            ErdiIragankorra pErdi = new ErdiIragankorra(id, ref, izena, fab, pasilo, kokapen, mota,
                                    rsErdi.getString("iraungitze_data"), rsErdi.getBoolean("hoztea"),
                                    rsErdi.getDouble("hezetasuna"));
                            produktuZerrenda.add(pErdi);
                        }
                    }
                } else if (mota == 3) {
                    String sqlEz = "SELECT * FROM Ez_Iragankorrak WHERE id_produktuak = ?";
                    try (PreparedStatement psEz = conn.prepareStatement(sqlEz)) {
                        psEz.setInt(1, id);
                        ResultSet rsEz = psEz.executeQuery();
                        if (rsEz.next()) {
                            EzIragankorra pEz = new EzIragankorra(id, ref, izena, fab, pasilo, kokapen, mota,
                                    rsEz.getBoolean("kontserba"));
                            produktuZerrenda.add(pEz);
                        }
                    }
                }
            }
            System.out.println("Datu basetik kargatutako produktuak: " + produktuZerrenda.size());

        } catch (SQLException e) {
            System.out.println("Errorea informazioa datu basetik jasotzean...");
            e.printStackTrace();
        }

        return produktuZerrenda;
    }
}
