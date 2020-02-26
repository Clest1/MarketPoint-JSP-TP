package Model;

import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

public class Client {

    static int nbrClient = 0;
    String nom,prenom;
    int id;
    UUID token;
    boolean isAdmin;

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
        isAdmin = false;
    }
    public Client(String nom, String prenom) {
        this();
        this.nom = nom;
        this.prenom = prenom;
    }
    public Client(String nom, String prenom, boolean isAdmin){
        this(nom,prenom);
        this.isAdmin = isAdmin;
    }
}
