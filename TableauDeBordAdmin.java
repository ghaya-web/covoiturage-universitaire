public class TableauDeBordAdmin {

    private int nombreUtilisateurs;
    private int nombreTrajets;
    private int nombreReservations;

    // Constructeur
    public TableauDeBordAdmin(int nombreUtilisateurs, int nombreTrajets, int nombreReservations) {
        this.nombreUtilisateurs = nombreUtilisateurs;
        this.nombreTrajets = nombreTrajets;
        this.nombreReservations = nombreReservations;
    }

    // Getters & Setters
    public int getNombreUtilisateurs() { return nombreUtilisateurs; }
    public void setNombreUtilisateurs(int nombreUtilisateurs) { this.nombreUtilisateurs = nombreUtilisateurs; }

    public int getNombreTrajets() { return nombreTrajets; }
    public void setNombreTrajets(int nombreTrajets) { this.nombreTrajets = nombreTrajets; }

    public int getNombreReservations() { return nombreReservations; }
    public void setNombreReservations(int nombreReservations) { this.nombreReservations = nombreReservations; }

    // Méthode principale
    public void afficherStatistiques() {
        System.out.println("=== Tableau de Bord Admin ===");
        System.out.println("Nombre d'utilisateurs : " + nombreUtilisateurs);
        System.out.println("Nombre de trajets : " + nombreTrajets);
        System.out.println("Nombre de réservations : " + nombreReservations);
    }
}