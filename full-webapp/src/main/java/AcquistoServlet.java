
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager; // Importa DriverManager da java.sql
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AcquistoServlet extends HttpServlet {
    private AcquistoDAO acquistoDAO;

    public void init() {
        String url = "jdbc:sqlite:database.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Errore durante la connessione al database.", e);
        }
        acquistoDAO = new AcquistoDAO(conn);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Acquisto> acquisti = acquistoDAO.getAllAcquisti();
        request.setAttribute("acquisti", acquisti);
        RequestDispatcher dispatcher = request.getRequestDispatcher("acquisti.jsp");
        dispatcher.forward(request, response);
    }
}
