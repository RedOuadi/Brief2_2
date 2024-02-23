import java.sql.*;
import java.util.Scanner;

public class BlackjackSql {
    private static final String url = "jdbc:postgresql://localhost:5432/Brief2";
    private static final String user = "root";
    private static final String password = "ader12";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connexion à la base de données établie avec succès.");

            boolean running = true;
            Scanner scanner = new Scanner(System.in);

            while (running) {
                System.out.println("Menu :");
                System.out.println("1. Afficher les mains");
                System.out.println("2. Créer une carte");
                System.out.println("3. Mettre à jour la valeur d'une main");
                System.out.println("4. Supprimer une main");
                System.out.println("5. Quitter");

                System.out.print("Choisissez une option : ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        afficherMains(conn);
                        break;
                    case 2:
                        creerCarte(conn);
                        break;
                    case 3:
                        mettreAJourMain(conn);
                        break;
                    case 4:
                        supprimerMain(conn);
                        break;
                    case 5:
                        running = false;
                        break;
                    default:
                        System.out.println("Option invalide. Veuillez choisir à nouveau.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void afficherMains(Connection conn) throws SQLException {
        String selectMainQuery = "SELECT * FROM Main";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(selectMainQuery)) {
            while (rs.next()) {
                int idMain = rs.getInt("id_main");
                int valeurTotal = rs.getInt("valeurTotal");
                int nbCartes = rs.getInt("nbCartes");
                System.out.println("Main - ID: " + idMain + ", Valeur totale: " + valeurTotal + ", Nombre de cartes: " + nbCartes);
            }
        }
    }

    private static void creerCarte(Connection conn) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez la couleur de la carte : ");
        String couleur = scanner.nextLine();
        System.out.print("Entrez la valeur de la carte : ");
        String valeur = scanner.nextLine();

        String insertCarteQuery = "INSERT INTO Carte (couleur, valeur) VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(insertCarteQuery)) {
            pstmt.setString(1, couleur);
            pstmt.setString(2, valeur);
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Nombre de lignes affectées : " + rowsAffected);
        }
    }

    private static void mettreAJourMain(Connection conn) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez l'ID de la main à mettre à jour : ");
        int idMain = scanner.nextInt();
        System.out.print("Entrez la nouvelle valeur totale de la main : ");
        int nouvelleValeur = scanner.nextInt();

        String updateMainQuery = "UPDATE Main SET valeurTotal = ? WHERE id_main = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(updateMainQuery)) {
            pstmt.setInt(1, nouvelleValeur);
            pstmt.setInt(2, idMain);
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Nombre de lignes affectées : " + rowsAffected);
        }
    }

    private static void supprimerMain(Connection conn) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez l'ID de la main à supprimer : ");
        int idMain = scanner.nextInt();

        String deleteMainQuery = "DELETE FROM Main WHERE id_main = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(deleteMainQuery)) {
            pstmt.setInt(1, idMain);
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Nombre de lignes affectées : " + rowsAffected);
        }
    }
}

