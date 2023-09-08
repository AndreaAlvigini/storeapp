public class Prodotto {
    private int id;
    private String nome;
    private double prezzo;
    //aggiungo descrizione prodotto
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
        //descrizione e immagine aggiunte
        this.descrizione = descrizione;
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

    //aggiungo descrizione get set
    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    // immagine set get

    public String getImmagine() {
        return immagine;
    }

    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }
}