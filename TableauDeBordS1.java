public class TableauDeBordS1 {

    private int nombreUtilisateurs;
    private int nombreTrajets;
    private int nombreReservations;

    public TableauDeBordS1(int nombreUtilisateurs, int nombreTrajets, int nombreReservations) {
        this.nombreUtilisateurs = nombreUtilisateurs;
        this.nombreTrajets = nombreTrajets;
        this.nombreReservations = nombreReservations;
    }

    public void afficherStatistiques() {
        System.out.println("=== Tableau de Bord S1 ===");
        System.out.println("Utilisateurs : " + nombreUtilisateurs);
        System.out.println("Trajets : " + nombreTrajets);
        System.out.println("Réservations : " + nombreReservations);
    }
}