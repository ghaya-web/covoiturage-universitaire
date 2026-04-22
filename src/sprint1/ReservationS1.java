public class ReservationS1 {
    private int idReservation;
    private String dateReservation;
    private String statut;

    public ReservationS1() {
    }

    public ReservationS1(int idReservation, String dateReservation, String statut) {
        this.idReservation = idReservation;
        this.dateReservation = dateReservation;
        this.statut = statut;
    }

    public void confirmerReservation() {
        this.statut = "Confirmée";
    }

    public void annulerReservation() {
        this.statut = "Annulée";
    }

    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public String getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(String dateReservation) {
        this.dateReservation = dateReservation;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "idReservation=" + idReservation +
                ", dateReservation='" + dateReservation + '\'' +
                ", statut='" + statut + '\'' +
                '}';
    }
}