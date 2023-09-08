//Questa é una classe che rappresenta il modello di dati per Acquisto e possiede solo i campi che corrispondono alle colonne nelle tabelle del database.

import java.util.Date;//Classe usata per rappresentare il campo dataAcquisto. Questa classe fa parte del pacchetto java.util e rappresenta un istante specifico nel tempo

public class Acquisto {
    //Specifico i campi che appartengono alla classe Acquisto
    private int id;
    private int idProdotto;
    private int idCliente;
    private Date dataAcquisto;
    //aggiunto il campo Tot
    private int tot;

    // Costruttore vuoto
    public Acquisto() {}

    // Costruttore con parametri
    public Acquisto(int id, int idProdotto, int idCliente, Date dataAcquisto, int tot) {
        this.id = id;
        this.idProdotto = idProdotto;
        this.idCliente = idCliente;
        this.dataAcquisto = dataAcquisto;
        // Agiunto costruttore con parametri per il campo "Totale"
        this.tot= tot;
    }

    // Getter e Setter per accedere e modificare i valori dei campi

    //Getter e Setter per Id acquisto
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    //Getter e Setter per Id Prodotto
    public int getIdProdotto() {
        return idProdotto;
    }

    public void setIdProdotto(int idProdotto) {
        this.idProdotto = idProdotto;
    }
    
    //Getter e Setter per Id cliente
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    //Getter e Setter per Data acquisto
    public Date getDataAcquisto() {
        return dataAcquisto;
    }

    public void setDataAcquisto(Date dataAcquisto) {
        this.dataAcquisto = dataAcquisto;
    }

    //Aggiunto Getter e Setter per Totale
    public int getTot() {
        return tot;
    }

    public void setTotale(int tot) {
        this.tot = tot;
    }
}
