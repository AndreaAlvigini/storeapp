import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProdottoDAO {

    private Connection conn; //connessione

    public ProdottoDAO(Connection conn) { //costruttore di classe
        this.conn = conn;
    }

    public List<Prodotto> getAllProdotti() { //metodo che restituisce una lista di oggetti Prodotto
        List<Prodotto> prodotti = new ArrayList<>(); //creazione della lista

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM prodotti")) {

            while(rs.next()) {
                Prodotto p = new Prodotto(); //creazione oggetto prodotto
                //utilizzo il metodo di Prodotto p per assegnare il valore all'id del prodotto,
                //leggendolo dal valore della colonna della riga corrente del ResultSet
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setDescrizione(rs.getString("descrizione"));
                p.setPrezzo(rs.getDouble("prezzo"));
                prodotti.add(p);
            }

        } catch (SQLException e) {
            // gestisci l'eccezione
            e.printStackTrace();
        }

        return prodotti; //riporta la lista di Prodotti
    }

    public Prodotto getProdottoById(int id) { //metodo di selezione prodotto in base all'id (in input) che restituisce un oggetto Prodotto
        Prodotto p = null; //creazione oggetto prodotto vuoto

        try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM prodotti WHERE id = ?")) { //selezione dalla tabella prodotti in base all'id

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {

                if(rs.next()) { //assegnazione dei valori all'oggetto Prodotto in base alla riga dell'id fornito
                    p = new Prodotto();
                    p.setId(rs.getInt("id"));
                    p.setNome(rs.getString("nome"));
                    p.setDescrizione(rs.getString("descrizione"));
                    p.setPrezzo(rs.getDouble("prezzo"));
                    p.setImmagine(rs.getString("immagine"));
                }

            }

        } catch (SQLException e) {
            // gestisci l'eccezione
            e.printStackTrace();
        }

        return p; //riporta il prodotto completo
    }

    public void insertProdotto(Prodotto p) { //metodo di inserimento che prende in input un Prodotto (p)
        try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO prodotti (nome, descrizione, prezzo, immagine) VALUES (?, ?, ?, ?)")) {

            stmt.setString(1, p.getNome()); //riporto i valori nella riga della tabella prodotti
            stmt.setString(2, p.getDescrizione());
            stmt.setDouble(3, p.getPrezzo());
            stmt.setString(4, p.getImmagine());
            stmt.executeUpdate();

        } catch (SQLException e) {
            // gestisci l'eccezione
            e.printStackTrace();
        }
    }
    //inserire cancella prodotto
}