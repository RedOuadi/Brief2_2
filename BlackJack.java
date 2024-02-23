public class BlackJack {
    // Convertit la valeur de la carte en entier
    public static int getValueAsNumber(String value) {
        if (value.equals("Ace")) {
            if ((Joueur.totalValuePlayer + 11) > 21 || (Croupier.totalValueCroupierFinal + 11) > 21) {
                return 1;
            } else {
                return 11;
            }
        } else if (value.equals("JACK") || value.equals("KING") || value.equals("QUEEN")) {
            return 10;
        } else {
            return Integer.parseInt(value);
        }
    }

    public static void PlayerWin() {
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Vous avez gagné : " + "<Total>" + " ( " + Joueur.totalValuePlayer + " )");
        System.out.println("CROUPIER : " + "<Total>" + " ( " + Croupier.totalValueCroupierFinal + " )");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        // Réinitialise les valeurs des points
        Joueur.totalValuePlayer = 0;
        Croupier.totalValueCroupierFinal = 0;
    }

    public static void CroupierWin() {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Vous avez perdu : " + "<Total>" + " ( " + Joueur.totalValuePlayer + " )");
        System.out.println("CROUPIER a gagné : " + "<Total>" + " ( " + Croupier.totalValueCroupierFinal + " )");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        // Réinitialise les valeurs des points
        Joueur.totalValuePlayer = 0;
        Croupier.totalValueCroupierFinal = 0;
    }

    public static void TheBlackJack() {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("-----------------BlackJack------------------------------------------------");
        System.out.println("Vous avez gagné : " + "<Total>" + " ( " + Joueur.totalValuePlayer + " )");
        System.out.println("CROUPIER : " + "<Total>" + " ( " + Croupier.totalValueCroupierFinal + " )");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        // Réinitialise les valeurs des points
        Joueur.totalValuePlayer = 0;
        Croupier.totalValueCroupierFinal = 0;
    }

    public static void NowinNolose() {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("-----------------Match nul-------------------------------------------------");
        System.out.println("Vous : " + "<Total>" + " ( " + Joueur.totalValuePlayer + " )");
        System.out.println("CROUPIER : " + "<Total>" + " ( " + Croupier.totalValueCroupierFinal + " )");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        // Réinitialise les valeurs des points
        Joueur.totalValuePlayer = 0;
        Croupier.totalValueCroupierFinal = 0;
    }
}

