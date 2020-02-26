package Model;

import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

public class Client {

    static int nbrClient = 0;
    String nom,prenom,pseudo,motDePasse;
    int id;
    UUID token;
    boolean isAdmin;
    Panier panier;

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

    public Panier getPanier() {
        return panier;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public boolean isTokenSame(UUID token) {
        return this.token == token;
    }

    public boolean isPsswrdSame(String motDePasse) {
        return this.motDePasse == motDePasse;
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
        panier = new Panier(id);
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
