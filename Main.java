import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 🔥 Base de données
        List<Trajet> base = new ArrayList<>();
        base.add(new Trajet("Manzah7", "CampusManar", "2026-04-19", "08:00", 20, 3));
        base.add(new Trajet("Manzah7", "ISGT", "2026-04-19", "10:00", 25, 1));
        base.add(new Trajet("Bardo2", "CampusManouba", "2026-04-19", "09:00", 15, 4));

        // =======================
        // 🔍 SAISIE AVEC CONTRÔLE
        // =======================

        System.out.print("Départ : ");
        String depart = sc.nextLine().trim();
        while (depart.isEmpty()) {
            System.out.print("Départ invalide, réessayez : ");
            depart = sc.nextLine().trim();
        }

        System.out.print("Destination : ");
        String destination = sc.nextLine().trim();
        while (destination.isEmpty()) {
            System.out.print("Destination invalide, réessayez : ");
            destination = sc.nextLine().trim();
        }

        System.out.print("Date (YYYY-MM-DD) : ");
        String date = sc.nextLine().trim();
        while (date.isEmpty()) {
            System.out.print("Date invalide, réessayez : ");
            date = sc.nextLine().trim();
        }

        // =======================
        // 🔍 RECHERCHE
        // =======================

        Recherche r = new Recherche(depart, destination, date);
        r.rechercherTrajet(base);

        System.out.println("\n--- Résultats ---");
        r.afficherResultat();

        if (true) {

            // =======================
            // 💰 PRIX MAX (contrôle)
            // =======================

            double prix;
            System.out.print("\nPrix max : ");

            while (!sc.hasNextDouble()) {
                System.out.print("Entrer un nombre valide : ");
                sc.next();
            }
            prix = sc.nextDouble();

            while (prix < 0) {
                System.out.print("Prix doit être positif : ");
                prix = sc.nextDouble();
            }

            r.filtrerParPrix(prix);

            sc.nextLine(); // buffer

            // =======================
            // ⏰ HEURE
            // =======================

            System.out.print("Heure : ");
            String heure = sc.nextLine().trim();

            while (heure.isEmpty()) {
                System.out.print("Heure invalide, réessayez : ");
                heure = sc.nextLine().trim();
            }

            r.filtrerParHeure(heure);

            // =======================
            // 🪑 PLACES
            // =======================

            System.out.print("Places min : ");
            int places;

            while (!sc.hasNextInt()) {
                System.out.print("Entrer un entier valide : ");
                sc.next();
            }
            places = sc.nextInt();

            while (places < 0) {
                System.out.print("Places doivent être positives : ");
                places = sc.nextInt();
            }

            r.filtrerParPlaces(places);
        }

        // =======================
        // 📌 RESULTAT FINAL
        // =======================

        System.out.println("\n--- Résultat final ---");
        r.afficherResultat();

        sc.close();
    }
}