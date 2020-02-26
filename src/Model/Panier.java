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
}
