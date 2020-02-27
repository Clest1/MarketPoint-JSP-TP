package Model;

import Model.Article;

import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

public class Panier extends ArrayList<Article> {

    UUID token;
    int idClient;

    public UUID getToken() {
        return token;
    }

    public int getIdClient() {
        return idClient;
    }

    private Panier(){
        super();
    }
    public Panier(int idClient){
        this();
        this.idClient = idClient;
        this.token = UUID.randomUUID();
    }

    public float totalValeur(){
        float total = 0;
        for(Article article : this) {
            total += article.getPrixTTC();
        }
        return total;
    }
}
