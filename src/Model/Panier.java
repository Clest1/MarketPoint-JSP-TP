package Model;

import Model.Article;

import java.util.ArrayList;
import java.util.Map;

public class Panier extends ArrayList<Article> {

    int idClient;

    private Panier(){
        super();
    }
    public Panier(int idClient){
        this();
        this.idClient = idClient;
    }

    public float totalValeur(){
        float total = 0;
        for(Article article : this) {
            total += article.getPrixTTC();
        }
        return total;
    }
}
