import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Auth auth = new Auth();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("1 Inscription");
            System.out.println("2 Connexion");
            System.out.println("3 Quitter");

            int choix = sc.nextInt();
            sc.nextLine();

            if (choix == 1) {

                System.out.print("Nom: ");
                String nom = sc.nextLine();

                System.out.print("Email: ");
                String email = sc.nextLine();

                System.out.print("Mot de passe: ");
                String mdp = sc.nextLine();

                auth.inscrire(nom, email, mdp);
            }

            else if (choix == 2) {

                System.out.print("Email: ");
                String email = sc.nextLine();

                System.out.print("Mot de passe: ");
                String mdp = sc.nextLine();

                auth.connexion(email, mdp);
            }

            else {
                break;
            }
        }
    }
}