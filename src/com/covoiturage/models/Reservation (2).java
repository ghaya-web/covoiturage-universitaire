public class Reservation {

    private int idReservation;
    private String dateReservation;
    private String statut;
    private Passager passager;
    private Trajet trajet;

    public Reservation(int id, String date, String statut, Passager p, Trajet t) {
        this.idReservation = id;
        this.dateReservation = date;
        this.statut = statut;
        this.passager = p;
        this.trajet = t;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public Trajet getTrajet() {
        return trajet;
    }

    public Passager getPassager() {
        return passager;
    }

    public void confirmerReservation() {
        statut = "CONFIRMEE";
    }

    public void annulerReservation() {
        statut = "ANNULEE";
        if (trajet != null) {
            trajet.augmenterPlaces();
        }
    }

    public String toString() {
        return "Reservation " + idReservation + " | " + statut;
    }

    // 🔥 VALIDATION AMÉLIORÉE
    public boolean estValide() {

        if (trajet == null) {
            System.out.println("Reservation invalide : trajet null");
            return false;
        }

        if (passager == null) {
            System.out.println("Reservation invalide : passager null");
            return false;
        }

        if (statut == null || statut.trim().isEmpty()) {
            System.out.println("Reservation invalide : statut incorrect");
            return false;
        }

        return true;
    }
}