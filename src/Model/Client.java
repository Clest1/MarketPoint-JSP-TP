package Model;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class Client {

    static int nbrClient = 0;
    String nom,prenom,pseudo,motDePasse;
    int id;
    UUID token;
    boolean isAdmin;
    UUID panier;

    public String getPseudo() {
        return pseudo;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getId() {
        return id;
    }

    public UUID getPanier() {
        return panier;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public boolean isTokenSame(String token) {
        if(token != null && this.token != null)
            return this.token.toString() == token;
        return false;
    }

    public boolean isPsswrdSame(String motDePasse) {
        return this.motDePasse.equals(motDePasse);
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    private Client(){
        id = ++nbrClient;
        UUID token = null;
        nom = "XXXXX";
        prenom = "XXXXX";
        pseudo = "XXXXX";
        motDePasse = "XXXXX";
        isAdmin = false;
        panier = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id || pseudo == client.pseudo;
    }

    public Client(String nom, String prenom, String pseudo, String motDePasse) {
        this();
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.motDePasse = motDePasse;
    }
    public Client(String nom, String prenom, String pseudo, String motDePasse, boolean isAdmin){
        this(nom,prenom,pseudo,motDePasse);
        this.isAdmin = isAdmin;
    }
}
