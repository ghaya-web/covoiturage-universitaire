import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Admin admin = new Admin(1, "Ines", "admin@gmail.com", "1234");
        TableauDeBordAdmin tdb = new TableauDeBordAdmin();

        // données de test
        admin.ajouterUtilisateur("Ali");
        admin.ajouterUtilisateur("Sara");

        admin.ajouterTrajet("Manzah7 -> CampusManar");
        admin.ajouterTrajet("Ariana ->ISGT");

        Scanner sc = new Scanner(System.in);
        int choix;

        do {
            System.out.println("\n===== MENU ADMIN =====");
            System.out.println("1. Voir utilisateurs");
            System.out.println("2. Voir trajets");
            System.out.println("3. Tableau de bord");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");

            choix = sc.nextInt();

            switch (choix) {

                case 1:
                    admin.gererUtilisateurs();
                    break;

                case 2:
                    admin.gererTrajets();
                    break;

                case 3:
                    admin.consulterTableauDeBord(tdb);
                    break;

                case 0:
                    System.out.println("Déconnexion...");
                    break;

                default:
                    System.out.println("Choix invalide !");
            }

        } while (choix != 0);

        sc.close();
    }
}