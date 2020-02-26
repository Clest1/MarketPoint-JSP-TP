package Model;

import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

public class Client {

    static int nbrClient = 0;
    String nom,prenom,pseudo;
    int id;
    UUID token;
    boolean isAdmin;

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

    public UUID getToken() {
        return token;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    private Client(){
        id = ++nbrClient;
        UUID token = null;
        nom = "XXXXX";
        prenom = "XXXXX";
        pseudo = "XXXXX";
        isAdmin = false;
    }
    public Client(String nom, String prenom, String pseudo) {
        this();
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
    }
    public Client(String nom, String prenom, String pseudo, boolean isAdmin){
        this(nom,prenom,pseudo);
        this.isAdmin = isAdmin;
    }
}
