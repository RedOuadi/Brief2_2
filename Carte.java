
public class Carte implements CarteInterface{
    private String couleur;
    private String valeur;

    public Carte(String couleur, String valeur) {
        this.couleur = couleur;
        this.valeur = valeur;
    }

    public String getCouleur() {
        return couleur;
    }

    public String getValeur() {
        return valeur;
    }
    public void SetCouleur(String couleur) {
        this.couleur=couleur;
    }
    public void SetValeur(String valeur) {
        this.valeur=valeur;
    }


    
}

