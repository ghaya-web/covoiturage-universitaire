import java.util.ArrayList;
import java.util.List;

public class Passager extends Utilisateur {
    private String numeroEtudiant;
    private List<Reservation> reservations;

    public Passager() {
        super();
        this.reservations = new ArrayList<>();
    }

    public Passager(String numeroEtudiant) {
        super();
        setNumeroEtudiant(numeroEtudiant);
        this.reservations = new ArrayList<>();
    }

    public Passager(int id, String nom, String email, String motDePasse, String numeroEtudiant) {
        super(id, nom, email, motDePasse);
        setNumeroEtudiant(numeroEtudiant);
        this.reservations = new ArrayList<>();
    }

    public Reservation reserverTrajet(Trajet trajet) {
        if (trajet == null) {
            throw new IllegalArgumentException("Le trajet ne peut pas être null.");
        }

        if (!trajet.estDisponible()) {
            throw new IllegalStateException("Aucune place disponible pour ce trajet.");
        }

        if (aDejaReserveTrajet(trajet)) {
            throw new IllegalStateException("Le passager a déjà réservé ce trajet.");
        }

        trajet.reserverUnePlace();

        Reservation reservation = new Reservation(
                reservations.size() + 1,
                "2026-04-22",
                Reservation.CONFIRMEE,
                this,
                trajet
        );

        reservations.add(reservation);
        return reservation;
    }

    public void annulerReservation(Reservation reservation) {
        if (reservation == null) {
            throw new IllegalArgumentException("La réservation ne peut pas être null.");
        }

        if (!reservations.contains(reservation)) {
            throw new IllegalStateException("Cette réservation n'appartient pas à ce passager.");
        }

        reservation.annulerReservation();
    }

    public List<Reservation> consulterReservations() {
        return reservations;
    }

    public boolean aDejaReserveTrajet(Trajet trajet) {
        for (Reservation reservation : reservations) {
            if (reservation.getTrajet().getIdTrajet() == trajet.getIdTrajet()
                    && !Reservation.ANNULEE.equalsIgnoreCase(reservation.getStatut())) {
                return true;
            }
        }
        return false;
    }

    public void afficherReservations() {
        System.out.println("=== Réservations du passager ===");
        if (reservations.isEmpty()) {
            System.out.println("Aucune réservation.");
            return;
        }

        for (Reservation reservation : reservations) {
            System.out.println(reservation);
        }
    }

    public String getNumeroEtudiant() {
        return numeroEtudiant;
    }

    public void setNumeroEtudiant(String numeroEtudiant) {
        if (numeroEtudiant == null || numeroEtudiant.trim().isEmpty()) {
            throw new IllegalArgumentException("Le numéro étudiant est obligatoire.");
        }
        if (numeroEtudiant.trim().length() < 4) {
            throw new IllegalArgumentException("Le numéro étudiant est trop court.");
        }
        this.numeroEtudiant = numeroEtudiant.trim();
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        if (reservations == null) {
            throw new IllegalArgumentException("La liste des réservations ne peut pas être null.");
        }
        this.reservations = reservations;
    }

    @Override
    public String toString() {
        return "Passager{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", numeroEtudiant='" + numeroEtudiant + '\'' +
                ", nombreReservations=" + reservations.size() +
                '}';
    }
}
