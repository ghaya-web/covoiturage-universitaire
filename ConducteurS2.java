import java.util.ArrayList;
import java.util.List;

public class ConducteurS2 {

    private String nom;
    private String email;
    private String telephone;

    private List<Trajet> trajets = new ArrayList<>();

    // créer profil
    public void creerProfil(String nom, String email, String telephone) {
        this.nom = nom;
        this.email = email;
        this.telephone = telephone;
    }

    public void modifierProfil(String nom, String email) {
        this.nom = nom;
        this.email = email;
        System.out.println("Profil modifié !");
    }

    public void afficherProfil() {
        System.out.println("\nProfil:");
        System.out.println("Nom : " + nom);
        System.out.println("Email : " + email);
        System.out.println("Téléphone : " + telephone);
    }

    // ajouter trajet
    public void ajouterTrajet(Trajet t) {
        trajets.add(t);
        System.out.println("Trajet ajouté !");
    }

    // afficher trajets
    public void afficherTrajets() {
        System.out.println("\nMes trajets:");
        if (trajets.isEmpty()) {
            System.out.println("Aucun trajet");
            return;
        }
        for (Trajet t : trajets) {
            t.afficherDetails();
        }
    }

    // supprimer trajet
    public void supprimerTrajet(int id) {
        boolean removed = trajets.removeIf(t -> t.getIdTrajet() == id);
        if (removed)
            System.out.println("Trajet supprimé !");
        else
            System.out.println("Trajet introuvable");
    }

    // modifier trajet
    public void modifierTrajet(int id, String dep, String dest, double prix, int places) {
        for (Trajet t : trajets) {
            if (t.getIdTrajet() == id) {
                t.modifier(dep, dest, prix, places);
                System.out.println("✔ Trajet modifié !");
                return;
            }
        }
        System.out.println("Trajet introuvable");
    }
}
