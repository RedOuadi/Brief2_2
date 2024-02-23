import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class PaquetCartes extends Carte implements PaquetCartesInterface {
    private List<Carte> listCartes;

    public PaquetCartes() {
        super("", ""); // Ne pas tenir compte des valeurs de couleur et de valeur pour le paquet de cartes
        listCartes = new ArrayList<>();
        initialiserPaquet();
    }

    public void initialiserPaquet() {
        String[] typeArr = {"Cœur", "Pique", "Carreau", "Trefle"};
        String[] valueArr = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "JACK", "KING", "QUEEN"};

        for (String couleur : typeArr) {
            for (String valeur : valueArr) {
                listCartes.add(new Carte(couleur, valeur));
            }
        }
    }

    public int getValeurDesCartes() {
        int total = 0;
        Main main = new Main(); // Crée une instance de la classe Main
        for (Carte carte : listCartes) {
            total += main.getValueAsNumber(carte.getValeur());
        }
        return total;
    }


    public Carte getCarteAleatoire() {
        Random random = new Random();
        int index = random.nextInt(listCartes.size());
        return listCartes.remove(index); // Retirer la carte du paquet
    }
}

