import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;

public class MainS2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ConducteurS2 c = new ConducteurS2(); 

        // création profil
        System.out.println("=== CREATION PROFIL ===");
        System.out.print("Nom : ");
        String nom = sc.nextLine();

        System.out.print("Email : ");
        String email = sc.nextLine();

        System.out.print("Téléphone : ");
        String tel = sc.nextLine();

        c.creerProfil(nom, email, tel);

        int choix;

        do {
            System.out.println("\n====== MENU CONDUCTEUR ======");
            System.out.println("1. Ajouter trajet");
            System.out.println("2. Afficher trajets");
            System.out.println("3. Modifier trajet");
            System.out.println("4. Supprimer trajet");
            System.out.println("5. Modifier profil");
            System.out.println("0. Quitter");
            System.out.print("Choix : ");

            choix = sc.nextInt();
            sc.nextLine();

            switch (choix) {

                case 1:
                    System.out.print("ID : ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Départ : ");
                    String dep = sc.nextLine();

                    System.out.print("Destination : ");
                    String dest = sc.nextLine();

                    System.out.print("Année : ");
                    int annee = sc.nextInt();

                    System.out.print("Mois : ");
                    int mois = sc.nextInt();

                    System.out.print("Jour : ");
                    int jour = sc.nextInt();

                    System.out.print("Heure : ");
                    int heure = sc.nextInt();

                    System.out.print("Minute : ");
                    int minute = sc.nextInt();

                    System.out.print("Prix : ");
                    double prix = sc.nextDouble();

                    System.out.print("Places disponibles : ");
                    int places = sc.nextInt();
                    sc.nextLine();

                    TrajetS2 t = new TrajetS2( 
                            id,
                            dep,
                            dest,
                            LocalDate.of(annee, mois, jour),
                            LocalTime.of(heure, minute),
                            prix,
                            places
                    );

                    c.ajouterTrajet(t);
                    break;

                case 2:
                    c.afficherTrajets();
                    break;

                case 3:
                    System.out.print("ID trajet : ");
                    int idm = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nouveau départ : ");
                    String nd = sc.nextLine();

                    System.out.print("Nouvelle destination : ");
                    String ndest = sc.nextLine();

                    System.out.print("Nouveau prix : ");
                    double np = sc.nextDouble();

                    System.out.print("Nouvelles places : ");
                    int npl = sc.nextInt();

                    c.modifierTrajet(idm, nd, ndest, np, npl);
                    break;

                case 4:
                    System.out.print("ID trajet : ");
                    int ids = sc.nextInt();
                    c.supprimerTrajet(ids);
                    break;

                case 5:
                    sc.nextLine();
                    System.out.print("Nouveau nom : ");
                    String nn = sc.nextLine();

                    System.out.print("Nouveau email : ");
                    String ne = sc.nextLine();

                    c.modifierProfil(nn, ne);
                    break;
            }

        } while (choix != 0);

        sc.close();
    }
}
