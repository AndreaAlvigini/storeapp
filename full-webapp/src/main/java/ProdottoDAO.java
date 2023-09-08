import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProdottoDAO {

    private Connection conn;

    public ProdottoDAO(Connection conn) {
        this.conn = conn;
    }

    public List<Prodotto> getAllProdotti() {
        List<Prodotto> prodotti = new ArrayList<>();

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM prodotti")) {

            while(rs.next()) {
                Prodotto p = new Prodotto();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setPrezzo(rs.getDouble("prezzo"));
                //aggiungere i campi
                prodotti.add(p);
            }

        } catch (SQLException e) {
            // gestisci l'eccezione
            e.printStackTrace();
        }

        return prodotti;
    }

    public Prodotto getProdottoById(int id) {
        Prodotto p = null;

        try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM prodotti WHERE id = ?")) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {

                if(rs.next()) {
                    p = new Prodotto();
                    p.setId(rs.getInt("id"));
                    p.setNome(rs.getString("nome"));
                    p.setPrezzo(rs.getDouble("prezzo"));
                }

            }

        } catch (SQLException e) {
            // gestisci l'eccezione
            e.printStackTrace();
        }

        return p;
    }

    public void insertProdotto(Prodotto p) {
        try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO prodotti (nome, prezzo) VALUES (?, ?)")) {

            stmt.setString(1, p.getNome());
            stmt.setDouble(2, p.getPrezzo());
            stmt.executeUpdate();

            

        } catch (SQLException e) {
            // gestisci l'eccezione
            e.printStackTrace();
        }
    }
    //inserire cancella prodotto
}