//Questa é una classe che rappresenta il modello di dati per Prodotto e possiede solo i campi che corrispondono alle colonne nelle tabelle del database.

public class Prodotto {
    //Specifico i campi che appartengono alla classe Prodotto
    private int id;
    private String nome;
    private double prezzo;
    //aggiungo campo descrizione prodotto
    private String descrizione;
    //aggiunta immagine
    private String immagine;

    // Costruttore vuoto
    public Prodotto() {}

    // Costruttore con parametri
    public Prodotto(int id, String nome, double prezzo, String descrizione, String immagine) {
        this.id = id;
        this.nome = nome;
        this.prezzo = prezzo;
        //aggiungiamo descrizione
        this.descrizione = descrizione;
        //aggiungiamo immimmagine
        this.immagine = immagine;
    }

    // Getter e Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    //aggiungo Getter Setter descrizione
    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    //aggiungo Getter Setter Immagine, immagine é una stringa perché corrispode a un url

    public String getImmagine() {
        return immagine;
    }

    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }
}