import java.time.LocalDate;
import java.time.LocalTime;

public class MainS2 {

    public static void main(String[] args) {

        // 👨‍✈️ Conducteur
        ConducteurS2 conducteur = new ConducteurS2("98765432", 4.5);
        conducteur.setNom("Ali");
        conducteur.setEmail("ali@gmail.com");

        // 🚗 Trajets
        Trajet t1 = new Trajet(1, "Tunis", "Sousse",
                LocalDate.of(2026, 4, 22),
                LocalTime.of(8, 30),
                12.5, 3);

        Trajet t2 = new Trajet(2, "Tunis", "Sfax",
                LocalDate.of(2026, 4, 23),
                LocalTime.of(14, 0),
                20.0, 4);

        // ✔ User Story 1
        conducteur.proposerTrajet(t1);
        conducteur.proposerTrajet(t2);

        // 👤 Profil
        conducteur.gererProfil();

        // ✔ User Story 2
        conducteur.consulterMesTrajets();

        System.out.println("\nTest diminution des places :");
        t1.diminuerPlaces();
        t1.afficherDetails();

        System.out.println("\nTest augmentation des places :");
        t1.augmenterPlaces();
        t1.afficherDetails();
    }
}
