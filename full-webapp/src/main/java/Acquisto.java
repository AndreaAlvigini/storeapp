//Questa é una classe che rappresenta il modello di dati per Acquisto, possiede solo i campi che corrispondono alle colonne nelle tabelle del database
import java.util.Date;

public class Acquisto {
    private int id;
    private int idProdotto;
    private int idCliente;
    private Date dataAcquisto;
    //aggiunto tot
    private Double tot;

    // Costruttore vuoto
    public Acquisto() {}

    // Costruttore con parametri
    public Acquisto(int id, int idProdotto, int idCliente, Date dataAcquisto, Double tot) {
        this.id = id;
        this.idProdotto = idProdotto;
        this.idCliente = idCliente;
        this.dataAcquisto = dataAcquisto;
        // Agiunto costruttore con parametri per totale
        this.tot= tot;
    }

    // Getter e Setter per accedere e modificare i valori dei campi

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProdotto() {
        return idProdotto;
    }

    public void setIdProdotto(int idProdotto) {
        this.idProdotto = idProdotto;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Date getDataAcquisto() {
        return dataAcquisto;
    }

    public void setDataAcquisto(Date dataAcquisto) {
        this.dataAcquisto = dataAcquisto;
    }

    //aggiunto getter e setter per totale
    public Double getTot() {
        return tot;
    }

    public void setTotale(Double tot) {
        this.tot = tot;
    }
}
