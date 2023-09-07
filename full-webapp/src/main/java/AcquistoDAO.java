import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AcquistoDAO {

    private Connection conn;

    public AcquistoDAO(Connection conn) {
        this.conn = conn;
    }

    public List<Acquisto> getAllAcquisti() {
        List<Acquisto> acquisti = new ArrayList<>();

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM acquisti")) {

            while(rs.next()) {
                Acquisto a = new Acquisto();
                a.setId(rs.getInt("id"));
                a.setIdProdotto(rs.getInt("id_Prodotto"));
                a.setIdCliente(rs.getInt("id_Cliente"));
                a.setDataAcquisto(rs.getDate("data_Acquisto"));
                acquisti.add(a);
            }

        } catch (SQLException e) {
            // gestisci l'eccezione
            e.printStackTrace();
        }

        return acquisti;
    }

    public Acquisto getAcquistoById(int id) {
        Acquisto a = null;

        try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM acquisti WHERE id = ?")) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {

                if(rs.next()) {
                    a = new Acquisto();
                    a.setId(rs.getInt("id"));
                    a.setIdProdotto(rs.getInt("id_Prodotto"));
                    a.setIdCliente(rs.getInt("id_Cliente"));
                    a.setDataAcquisto(rs.getDate("data_Acquisto"));
                }

            }

        } catch (SQLException e) {
            // gestisci l'eccezione
            e.printStackTrace();
        }

        return a;
    }

    public void insertAcquisto(Acquisto a) {
        try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO acquisti (id_Prodotto, id_Cliente, data_Acquisto) VALUES (?, ?, ?)")) {

            stmt.setInt(1, a.getIdProdotto());
            stmt.setInt(2, a.getIdCliente());
            stmt.setDate(3, new java.sql.Date(a.getDataAcquisto().getTime()));
            stmt.executeUpdate();

        } catch (SQLException e) {
            // gestisci l'eccezione
            e.printStackTrace();
        }
    }
}