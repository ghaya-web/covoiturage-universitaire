public class Reservation {
    public static final String EN_ATTENTE = "En attente";
    public static final String CONFIRMEE = "Confirmée";
    public static final String ANNULEE = "Annulée";

    private int idReservation;
    private String dateReservation;
    private String statut;
    private Passager passager;
    private Trajet trajet;

    public Reservation() {
    }

    public Reservation(int idReservation, String dateReservation, String statut, Passager passager, Trajet trajet) {
        setIdReservation(idReservation);
        setDateReservation(dateReservation);
        setStatut(statut);
        setPassager(passager);
        setTrajet(trajet);
    }

    public void confirmerReservation() {
        if (passager == null || trajet == null) {
            throw new IllegalStateException("Impossible de confirmer une réservation incomplète.");
        }

        if (ANNULEE.equalsIgnoreCase(statut)) {
            throw new IllegalStateException("Impossible de confirmer une réservation déjà annulée.");
        }

        this.statut = CONFIRMEE;
    }

    public void annulerReservation() {
        if (ANNULEE.equalsIgnoreCase(statut)) {
            throw new IllegalStateException("La réservation est déjà annulée.");
        }

        if (trajet != null) {
            trajet.libererUnePlace();
        }

        this.statut = ANNULEE;
    }

    public boolean estActive() {
        return CONFIRMEE.equalsIgnoreCase(statut);
    }

    public void afficherDetails() {
        System.out.println("=== Réservation ===");
        System.out.println("ID : " + idReservation);
        System.out.println("Date réservation : " + dateReservation);
        System.out.println("Statut : " + statut);
        System.out.println("Passager : " + passager.getNom());
        System.out.println("Trajet : " + trajet.getDepart() + " -> " + trajet.getDestination());
    }

    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        if (idReservation <= 0) {
            throw new IllegalArgumentException("L'identifiant de réservation doit être positif.");
        }
        this.idReservation = idReservation;
    }

    public String getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(String dateReservation) {
        if (dateReservation == null || dateReservation.trim().isEmpty()) {
            throw new IllegalArgumentException("La date de réservation est obligatoire.");
        }
        this.dateReservation = dateReservation.trim();
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        if (statut == null || statut.trim().isEmpty()) {
            throw new IllegalArgumentException("Le statut est obligatoire.");
        }

        String valeur = statut.trim();

        if (!valeur.equalsIgnoreCase(EN_ATTENTE)
                && !valeur.equalsIgnoreCase(CONFIRMEE)
                && !valeur.equalsIgnoreCase(ANNULEE)) {
            throw new IllegalArgumentException("Statut invalide.");
        }

        this.statut = valeur;
    }

    public Passager getPassager() {
        return passager;
    }

    public void setPassager(Passager passager) {
        if (passager == null) {
            throw new IllegalArgumentException("Le passager ne peut pas être null.");
        }
        this.passager = passager;
    }

    public Trajet getTrajet() {
        return trajet;
    }

    public void setTrajet(Trajet trajet) {
        if (trajet == null) {
            throw new IllegalArgumentException("Le trajet ne peut pas être null.");
        }
        this.trajet = trajet;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "idReservation=" + idReservation +
                ", dateReservation='" + dateReservation + '\'' +
                ", statut='" + statut + '\'' +
                ", passager=" + passager.getNom() +
                ", trajet=" + trajet.getDepart() + " -> " + trajet.getDestination() +
                '}';
    }
}
