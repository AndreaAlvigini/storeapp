public class Cliente {
    private int id;
    private String nome;
    private String email;
    // aggiunto punti fedeltà
    private int punti;
    //aggiunto indirizzo
    private String indirizzo;
    //aggiungo telefono
    private String telefono;

    // Costruttore vuoto
    public Cliente() {
    }

    // Costruttore con parametri
    public Cliente(int id, String nome, String email, int punti, String indirizzo, String telefono) {
        this.id = id;
        this.nome = nome;
        this.email = email;

        // aggiunto punri costruttore
        this.punti = punti;
         // aggiunto indirizzo
        this.indirizzo = indirizzo;
         // aggiunto telefono
        this.telefono = telefono;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    // aggiunto punti get set punti

    public int getPunti() {
        return punti;
    }

    public void setPunti(int punti) {
        this.punti = punti;
    }


    // aggiunto indirizzo get set
    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    // aggiunto telefono get set
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}