# STOREAPP

Storeapp è un'applicazione di database management che permette una facile gestione dei dati di un ipotetico negozio online per quanto riguarda i prodotti, i clienti e gli ordini.
Le tecnologie con cui è stata creata sono:

- Java
- SQLite
- Maven
- Java Server Page
- Bootstrap


## Backend

Per lavorare in maniera efficace e ordinata abbiamo compartimentanto il programma in tre tipi di classi:

- Modello di Dati
- DAO (Databse Access Object)
- Servlet


### Modello di Dati

Per rappresentare le tabelle Prodotti, Clienti e Acquisti, abbiamo creato delle classi Java corrispondenti; questi tipi di classe possiedono solo i campi che corrispondono alle colonne nelle tabelle del database.Ad esempio, la classe Prodotto ha un campo id, un campo nome, un campo prezzo, un campo immagine e un campo descrizione che corrispondono ad ogni colonna della tabella Prodotti.
```java
public class Prodotto {
    //Specifico i campi che appartengono alla classe Prodotto
    private int id;
    private String nome;
    private double prezzo;
    private String descrizione;
    private String immagine;
```

Le classi poi sono dotate di costruttori per inizializzare i campi, così come Getter e Setter per accedere e modificare i valori dei campi.

```java
    public Prodotto() {}
    public Prodotto(int id, String nome, double prezzo, String descrizione, String immagine) {
        this.id = id;
        this.nome = nome;
        this.prezzo = prezzo;
        //aggiungiamo descrizione
        this.descrizione = descrizione;
        //aggiungiamo immimmagine
        this.immagine = immagine;
    }
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
    public String getDescrizione() {
        return descrizione;
    }
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    public String getImmagine() {
        return immagine;
    }
    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }
}
```

### DAO (Data Access Object)

Abbiamo creato delle classi Java per 





- 3 Servlet