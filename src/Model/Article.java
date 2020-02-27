package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Article {
    private int prixHT,tauxTVA,codeBarre;
    private String reference,libelle;
    public static final ArrayList<Integer> MAP_TVA = new ArrayList<>(Arrays.asList(550,2000));

    public int getPrixHT() {
        return prixHT;
    }
    public int getTauxTVA() {
        return tauxTVA;
    }
    public int getCodeBarre() {
        return codeBarre;
    }
    public String getReference() {
        return reference;
    }
    public String getLibelle() {
        return libelle;
    }

    public Article( String libelle, String reference, int codeBarre, int prixHT, int tauxTVA) {
        this.prixHT = prixHT;
        this.tauxTVA = tauxTVA;
        this.codeBarre = codeBarre;
        this.reference = reference;
        this.libelle = libelle;
    }

    public float getPrixTTC(){
        return prixHT*tauxTVA/100;
    }
}
