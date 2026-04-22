import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Authentification auth = new Authentification();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n=== MENU ===");
            System.out.println("1. Inscription");
            System.out.println("2. Connexion");
            System.out.println("3. Quitter");

            System.out.print("Choix : ");
            int choix = sc.nextInt();
            sc.nextLine();

            if (choix == 1) {

                System.out.print("Nom : ");
                String nom = sc.nextLine();

                System.out.print("Email : ");
                String email = sc.nextLine();

                System.out.print("Mot de passe : ");
                String mdp = sc.nextLine();

                auth.inscrireUtilisateur(nom, email, mdp);

            }

            else if (choix == 2) {

                System.out.print("Email : ");
                String email = sc.nextLine();

                System.out.print("Mot de passe : ");
                String mdp = sc.nextLine();

                auth.authentifier(email, mdp);

            }

            else if (choix == 3) {
                System.out.println("Au revoir");
                break;
            }
        }

        sc.close();
    }
}