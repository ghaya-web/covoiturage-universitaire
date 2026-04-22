public class TableauDeBordAdmin {

    private int nombreUtilisateurs;
    private int nombreTrajets;
    private int nombreReservations;

    public TableauDeBordAdmin() {}

    public int getNombreUtilisateurs() { return nombreUtilisateurs; }
    public void setNombreUtilisateurs(int nombreUtilisateurs) {
        this.nombreUtilisateurs = nombreUtilisateurs;
    }

    public int getNombreTrajets() { return nombreTrajets; }
    public void setNombreTrajets(int nombreTrajets) {
        this.nombreTrajets = nombreTrajets;
    }

    public int getNombreReservations() { return nombreReservations; }
    public void setNombreReservations(int nombreReservations) {
        this.nombreReservations = nombreReservations;
    }

    public void afficherStatistiques() {
        System.out.println("=== TABLEAU DE BORD ADMIN ===");
        System.out.println("Nombre utilisateurs : " + nombreUtilisateurs);
        System.out.println("Nombre trajets : " + nombreTrajets);
        System.out.println("Nombre reservations : " + nombreReservations);
    }
}
