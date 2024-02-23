public class Joueur extends Carte implements JoueurInterface{
    static int coins = 500;
    static int totalValuePlayer;

    public Joueur(String couleur, String valeur) {
        super(couleur, valeur);
    }
}

