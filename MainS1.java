import java.util.*;

public class MainS1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<TrajetS1> base = new ArrayList<>();
        base.add(new TrajetS1("Manzah7", "CampusManar", "2026-04-19", "08:00", 20, 3));
        base.add(new TrajetS1("Manzah7", "ISGT", "2026-04-19", "10:00", 25, 1));
        base.add(new TrajetS1("Bardo2", "CampusManouba", "2026-04-19", "09:00", 19, 4));

        System.out.print("Départ : ");
        String depart = sc.nextLine();

        System.out.print("Destination : ");
        String destination = sc.nextLine();

        System.out.print("Date : ");
        String date = sc.nextLine();

        RechercheS1 r = new RechercheS1(depart, destination, date);
        List<TrajetS1> resultats = r.rechercher(base);

        System.out.println("\n--- Résultats ---");

        if (resultats.isEmpty()) {
            System.out.println("Aucun trajet trouvé");
        } else {
            for (TrajetS1 t : resultats) {
                System.out.println(t);
            }
        }

        sc.close();
    }
}