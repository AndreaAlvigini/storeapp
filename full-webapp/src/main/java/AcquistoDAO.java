import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AcquistoDAO {

    private Connection conn; //connessione

    public AcquistoDAO(Connection conn) { //costruttore di classe
        this.conn = conn;
    }

    public List<Acquisto> getAllAcquisti() { //metodo che restituisce una lista di oggetti Acquisto
        List<Acquisto> acquisti = new ArrayList<>(); //creazione della lista

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM acquisti")) {

            while(rs.next()) {
                Acquisto a = new Acquisto(); //creazione oggetto Acquisto
                a.setId(rs.getInt("id")); //assegno i valori ad Acquisto in base alla riga del ResultSet
                a.setDataAcquisto(rs.getDate("data"));
                a.setIdProdotto(rs.getInt("id_prodotto"));
                a.setIdCliente(rs.getInt("id_cliente"));
                a.setTotale(rs.getDouble("totale"));
                acquisti.add(a); //aggiungo alla lista l'Acquisto completo di valori
            }

        } catch (SQLException e) {
            // gestisci l'eccezione
            e.printStackTrace();
        }

        return acquisti; //riporto la lista
    }

    public Acquisto getAcquistoById(int id) { //metodo di selezione di un Acquisto che prende in input l'id e restituisce l'Acquisto corrispondente
        Acquisto a = null;//creazione oggetto Acquisto vuoto

        try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM acquisti WHERE id = ?")) { //seleziona tutto da acquisti nella riga dell'id fornito

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {

                if(rs.next()) { //se l'id corrisponde a una riga di valori
                    a = new Acquisto();
                    a.setId(rs.getInt("id")); //riempio l'oggetto Acquisto a con i valori del ResultSet trovati all'id fornito
                    a.setDataAcquisto(rs.getDate("data"));
                    a.setIdProdotto(rs.getInt("id_prodotto"));
                    a.setIdCliente(rs.getInt("id_cliente"));
                    a.setTotale(rs.getDouble("totale"));
                }

            }

        } catch (SQLException e) {
            // gestisci l'eccezione
            e.printStackTrace();
        }

        return a;//riporta l'Acquisto
    }

    public void insertAcquisto(Acquisto a) { //metodo che prende in input un Acquisto (a) da inserire
        try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO acquisti (data, id_prodotto, id_cliente, totale) VALUES (?, ?, ?, ?)")) {

            stmt.setDate(1, new java.sql.Date(a.getDataAcquisto().getTime()));
            stmt.setInt(2, a.getIdProdotto());
            stmt.setInt(3, a.getIdCliente());
            stmt.setDouble(4, a.getTot());
            stmt.executeUpdate();

        } catch (SQLException e) {
            // gestisci l'eccezione
            e.printStackTrace();
        }
    }
}