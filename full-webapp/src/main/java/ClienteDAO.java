import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    private Connection conn;

    public ClienteDAO(Connection conn) {
        this.conn = conn;
    }

    public List<Cliente> getAllClienti() { //metodo che resituisce una lista di oggetti Cliente
        List<Cliente> clienti = new ArrayList<>();

        try (Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM clienti")) {

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setIndirizzo(rs.getString("indirizzo"));
                c.setEmail(rs.getString("email"));
                c.setTelefono(rs.getString("telefono"));
                c.setPunti(rs.getInt("punti"));
                clienti.add(c);
            }

        } catch (SQLException e) {
            // gestisci l'eccezione
            e.printStackTrace();
        }

        return clienti;
    }

    public Cliente getClienteById(int id) {
        Cliente c = null;

        try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM clienti WHERE id = ?")) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    c = new Cliente();
                    c.setId(rs.getInt("id"));
                    c.setNome(rs.getString("nome"));
                    c.setIndirizzo(rs.getString("indirizzo"));
                    c.setEmail(rs.getString("email"));
                    c.setTelefono(rs.getString("telefono"));
                    c.setPunti(rs.getInt("punti"));
                }

            }

        } catch (SQLException e) {
            // gestisci l'eccezione
            e.printStackTrace();
        }

        return c;
    }

    public void insertCliente(Cliente c) {
        try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO clienti (nome, indirizzo, email, telefono, punti) VALUES (?, ?, ?, ?, ?)")) {

            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getIndirizzo());
            stmt.setString(3, c.getEmail());
            stmt.setString(4, c.getTelefono());
            stmt.setInt(5, c.getPunti());
            stmt.executeUpdate();

        } catch (SQLException e) {
            // gestisci l'eccezione
            e.printStackTrace();
        }
    }
}
