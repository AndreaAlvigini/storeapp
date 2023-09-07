import java.util.Date;

public class Acquisto {
    private int id;
    private int idProdotto;
    private int idCliente;
    private Date dataAcquisto;

    // Costruttore vuoto
    public Acquisto() {}

    // Costruttore con parametri
    public Acquisto(int id, int idProdotto, int idCliente, Date dataAcquisto) {
        this.id = id;
        this.idProdotto = idProdotto;
        this.idCliente = idCliente;
        this.dataAcquisto = dataAcquisto;
    }

    // Getter e Setter

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
}
