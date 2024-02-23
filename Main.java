public class Main implements MainInterface {
    public  int getValueAsNumber(String value) {
        if (value.equals("JACK") || value.equals("KING") || value.equals("QUEEN")) {
            return 10;
        } else if (value.equals("Ace")) {
            return 11;
        } else {
            return Integer.parseInt(value);
        }
    }public  void hitPlayer(PaquetCartes paquet) {
        Carte carte = paquet.getCarteAleatoire();
        int valeurCarte = getValueAsNumber(carte.getValeur());
        Joueur.totalValuePlayer += valeurCarte; // Mettre à jour la valeur totale des cartes du joueur
        System.out.println("Le joueur a reçu la carte : " + carte.getValeur() + " de " + carte.getCouleur());
        System.out.println("Valeur totale des cartes du joueur : " + Joueur.totalValuePlayer);
    }public  void hitCroupier(PaquetCartes paquet) {
        Carte carte = paquet.getCarteAleatoire();
        int valeurCarte = getValueAsNumber(carte.getValeur());
        Croupier.totalValueCroupierFinal+=valeurCarte;
        System.out.println("Le croupier a reçu la carte : " + carte.getValeur() + " de " + carte.getCouleur());
        System.out.println("Valeur totale des cartes du croupier : " + valeurCarte);
    }public  void hitHiddenCard(PaquetCartes paquet) {
        Carte carte = paquet.getCarteAleatoire();
        System.out.println("Le croupier a reçu une carte cachée.");
    }
}



