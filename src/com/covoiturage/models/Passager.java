import java.util.*;
import java.time.LocalDate;

public class Passager extends Utilisateur {

    private List<Reservation> reservations = new ArrayList<>();

    public Passager(int id, String nom, String email, String mdp) {
        super(id, nom, email, mdp);
    }

    // ================= RESERVER =================
    public Reservation reserverTrajet(Trajet t) {

        if (t == null) {
            System.out.println("Trajet invalide !");
            return null;
        }

        if (t.getPlaces() <= 0) {
            System.out.println("Pas de places !");
            return null;
        }

        t.diminuerPlaces();

        Reservation r = new Reservation(
                reservations.size() + 1,
                LocalDate.now().toString(), // 🔥 date automatique
                "CONFIRMEE",
                this,
                t
        );

        reservations.add(r);

        System.out.println("Réservation ajoutée avec succès");
        return r;
    }

    // ================= ANNULER =================
    public boolean annulerReservation(int id) {

        Iterator<Reservation> it = reservations.iterator();

        while (it.hasNext()) {
            Reservation r = it.next();

            if (r.getIdReservation() == id) {
                r.annulerReservation();
                it.remove();
                System.out.println("Réservation supprimée");
                return true;
            }
        }

        return false;
    }

    // ================= CONSULTER =================
    public void consulterReservations() {

        if (reservations.isEmpty()) {
            System.out.println("Aucune réservation");
            return;
        }

        System.out.println("\n--- MES RESERVATIONS ---");

        for (Reservation r : reservations) {
            System.out.println(r);
        }
    }

    // ================= GETTER =================
    public List<Reservation> getReservations() {
        return reservations;
    }

    // ================= VALIDATION =================
    public boolean estValide() {
        return super.estValide();
    }
}