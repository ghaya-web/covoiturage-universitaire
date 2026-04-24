public class TableauDeBordAdmin {

    private int nombreUtilisateurs;
    private int nombreTrajets;
    private int nombreReservations;

    public TableauDeBordAdmin(int u, int t, int r) {
        this.nombreUtilisateurs = u;
        this.nombreTrajets = t;
        this.nombreReservations = r;
    }

    public void setNombreUtilisateurs(int n) { this.nombreUtilisateurs = n; }
    public void setNombreTrajets(int n) { this.nombreTrajets = n; }
    public void setNombreReservations(int n) { this.nombreReservations = n; }

    public void afficherStatistiques() {
        System.out.println("Utilisateurs: " + nombreUtilisateurs);
        System.out.println("Trajets: " + nombreTrajets);
        System.out.println("Reservations: " + nombreReservations);
    }

    // 🔥 AJOUT
    public boolean estValide() {
        return nombreUtilisateurs >= 0 && nombreTrajets >= 0 && nombreReservations >= 0;
    }
}