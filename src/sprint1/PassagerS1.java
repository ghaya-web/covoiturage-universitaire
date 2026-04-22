public class PassagerS1 extends UtilisateurS1 {
    private String numeroEtudiant;

    public PassagerS1() {
        super();
    }

    public PassagerS1(String numeroEtudiant) {
        super();
        this.numeroEtudiant = numeroEtudiant;
    }

    public PassagerS1(int id, String nom, String email, String motDePasse, String numeroEtudiant) {
        super(id, nom, email, motDePasse);
        this.numeroEtudiant = numeroEtudiant;
    }

    public Reservation reserverTrajet(Trajet trajet) {
        if (trajet != null && trajet.getPlacesDisponibles() > 0) {
            trajet.setPlacesDisponibles(trajet.getPlacesDisponibles() - 1);
            return new Reservation(1, "2026-04-22", "Confirmée");
        }
        return null;
    }

    public void annulerReservation(Reservation reservation) {
        if (reservation != null) {
            reservation.annulerReservation();
        }
    }

    public void consulterReservations() {
        // Sprint 1 : méthode simple, démonstrative
    }

    public String getNumeroEtudiant() {
        return numeroEtudiant;
    }

    public void setNumeroEtudiant(String numeroEtudiant) {
        this.numeroEtudiant = numeroEtudiant;
    }

    @Override
    public String toString() {
        return "Passager{" +
                "id=" + getId() +
                ", nom='" + getNom() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", numeroEtudiant='" + numeroEtudiant + '\'' +
                '}';
    }
}
