import java.util.Scanner;

public class MainS1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Test Sprint 1 : Passager & Reservation ===");

        System.out.print("ID du passager : ");
        int idPassager = Integer.parseInt(scanner.nextLine());

        System.out.print("Nom du passager : ");
        String nom = scanner.nextLine();

        System.out.print("Email du passager : ");
        String email = scanner.nextLine();

        System.out.print("Mot de passe : ");
        String motDePasse = scanner.nextLine();

        System.out.print("Numéro étudiant : ");
        String numeroEtudiant = scanner.nextLine();

        System.out.println("======");

        Passager passager = new Passager(
                idPassager,
                nom,
                email,
                motDePasse,
                numeroEtudiant
        );

        System.out.print("ID du trajet : ");
        int idTrajet = Integer.parseInt(scanner.nextLine());

        System.out.print("Départ : ");
        String depart = scanner.nextLine();

        System.out.print("Destination : ");
        String destination = scanner.nextLine();

        System.out.print("Date : ");
        String date = scanner.nextLine();

        System.out.print("Heure : ");
        String heure = scanner.nextLine();

        System.out.print("Prix : ");
        double prix = Double.parseDouble(scanner.nextLine());

        System.out.print("Nombre de places disponibles : ");
        int placesDisponibles = Integer.parseInt(scanner.nextLine());

        Trajet trajet = new Trajet(
                idTrajet,
                depart,
                destination,
                date,
                heure,
                prix,
                placesDisponibles
        );

        Reservation reservation = passager.reserverTrajet(trajet);

        System.out.println("\n--- Résultats ---");112

        System.out.println(passager);

        System.out.println(trajet);

        if (reservation != null) {
            System.out.println(reservation);
        } else {
            System.out.println("Reservation impossible");
        }

        passager.annulerReservation(reservation);

        if (reservation != null) {
            System.out.println(reservation);
        }

        scanner.close();
    }
}
