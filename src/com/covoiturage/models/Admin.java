import java.util.*;

public class Admin extends Utilisateur {

    public Admin(int id, String nom, String email, String mdp) {
        super(id, nom, email, mdp);
    }

    // ================= UTILISATEURS =================
    public void gererUtilisateurs(List<Utilisateur> users) {
        System.out.println("\n--- LISTE UTILISATEURS ---");

        if (users == null || users.isEmpty()) {
            System.out.println("Aucun utilisateur");
            return;
        }

        for (Utilisateur u : users) {
            System.out.println(u.getId() + " | " + u.getNom() + " | " + u.getEmail());
        }
    }

    // ================= TRAJETS =================
    public void gererTrajets(List<Trajet> trajets) {
        System.out.println("\n--- LISTE TRAJETS ---");

        if (trajets == null || trajets.isEmpty()) {
            System.out.println("Aucun trajet");
            return;
        }

        for (Trajet t : trajets) {
            t.afficherDetails();
        }
    }

    // ================= TABLEAU DE BORD =================
    public void consulterTableauDeBord(TableauDeBordAdmin tdb) {
        System.out.println("\n--- TABLEAU DE BORD ADMIN ---");

        if (tdb != null) {
            tdb.afficherStatistiques();
        } else {
            System.out.println("Tableau de bord indisponible");
        }
    }
}