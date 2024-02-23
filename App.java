import java.util.Scanner;
public class App {

    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        int choix;
        int maMise;

        Main main = new Main(); // Crée une instance de la classe Main

        do {
            System.out.println("1-Démarrer le jeu");
            System.out.println("2-Afficher mes jetons");
            System.out.println("0-Quitter le jeu");

            if (cin.hasNextInt()) {
                choix = cin.nextInt();
                switch (choix) {
                    case 1:
                        System.out.println("Combien voulez-vous miser pour ce jeu : ");
                        if (cin.hasNextInt()) {
                            maMise = cin.nextInt();
                            if (maMise > Joueur.coins) {
                                System.out.println("Vous n'avez pas assez de jetons");
                            } else if (Joueur.coins <= 0) {
                                System.out.println("Vous avez perdu tous vos jetons");
                                choix = 0;
                            } else {
                                System.out.println("************* Le joueur prend 2 cartes : ****************");
                                main.hitPlayer(new PaquetCartes());
                                main.hitPlayer(new PaquetCartes());
                                System.out.println("Main du joueur : " + "< " + Joueur.totalValuePlayer + " >");

                                System.out.println("************* Le croupier prend 2 cartes : ****************");
                                System.out.println(" Carte cachée ");
                                main.hitHiddenCard(new PaquetCartes());
                                main.hitCroupier(new PaquetCartes());
                                System.out.println("********************************************************");

                                if (Joueur.totalValuePlayer == 21) {
                                    BlackJack.TheBlackJack();
                                    Joueur.coins += maMise;
                                    choix = 0;
                                }

                                boolean enJeu = true;
                                int action;
                                do {
                                    System.out.println("1-Tirer une carte");
                                    System.out.println("2-Rester");
                                    action = cin.nextInt();
                                    switch (action) {
                                        case 1:
                                            System.out.println("************* Le joueur : ****************");
                                            main.hitPlayer(new PaquetCartes());
                                            System.out.println("valeur : " + Joueur.totalValuePlayer);
                                            System.out.println("**************************µµµ****************");
                                            if (Joueur.totalValuePlayer == 21 && Croupier.totalValueCroupierFinal < 21) {
                                                BlackJack.PlayerWin();
                                                Joueur.coins += maMise;
                                                enJeu = false;
                                            } else if (Joueur.totalValuePlayer == 21 && Croupier.totalValueCroupierFinal > 21) {
                                                BlackJack.PlayerWin();
                                                Joueur.coins += maMise;
                                                enJeu = false;
                                            } else if (Joueur.totalValuePlayer > 21 && Croupier.totalValueCroupierFinal <= 21) {
                                                BlackJack.CroupierWin();
                                                Joueur.coins -= maMise;
                                                enJeu = false;
                                            } else if (Joueur.totalValuePlayer < 21 && Croupier.totalValueCroupierFinal == 21) {
                                                BlackJack.CroupierWin();
                                                Joueur.coins -= maMise;
                                                enJeu = false;
                                            } else if (Joueur.totalValuePlayer == 21) {
                                                BlackJack.NowinNolose();
                                                enJeu = false;
                                            }
                                            break;

                                        case 2:
                                            while (Croupier.totalValueCroupierFinal <= 17) {
                                                System.out.println("************* Croupier: ****************");
                                                main.hitCroupier(new PaquetCartes());
                                            }

                                            if (Croupier.totalValueCroupierFinal > 21) {
                                                BlackJack.PlayerWin(); // Joueur gagne
                                                Joueur.coins+= maMise;
                                                enJeu = false;
                                            } else if (Croupier.totalValueCroupierFinal >= Joueur.totalValuePlayer) {
                                                BlackJack.CroupierWin();
                                                Joueur.coins -= maMise;
                                                enJeu = false;
                                            } else {
                                                BlackJack.PlayerWin();
                                                Joueur.coins += maMise;
                                                enJeu = false;
                                            }

                                            break;

                                        default:
                                            System.out.println("Erreur, votre choix est hors de portée ");
                                            enJeu = false;
                                            break;
                                    }
                                } while (enJeu);
                            }
                        } else {
                            System.out.println("Entrée invalide. Veuillez entrer un entier valide pour votre mise.");
                            cin.next(); // consommer une entrée invalide
                        }
                        break;

                    case 2:
                        System.out.println("Mes jetons sont : " + Joueur.coins);
                        break;

                    default:
                        System.out.println("===================Quitter le jeu====================");
                        break;
                }
            } else {
                System.out.println("Entrée invalide. Veuillez entrer un entier valide pour votre choix.");
                cin.next(); // consommer une entrée invalide
                choix = -1; // définir choix sur une valeur non nulle pour continuer la boucle
            }
        } while (choix != 0);
    }
}



