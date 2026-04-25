import java.util.ArrayList;
import java.util.List;

public class ConducteurS2 {

    private String nom;
    private String email;
    private String telephone;

    private List<TrajetS2> trajets = new ArrayList<>();

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

    public void ajouterTrajet(TrajetS2 t) {
        trajets.add(t);
        System.out.println("Trajet ajouté !");
    }

    public void afficherTrajets() {
        System.out.println("\nMes trajets:");
        if (trajets.isEmpty()) {
            System.out.println("Aucun trajet");
            return;
        }
        for (TrajetS2 t : trajets) {
            t.afficherDetails();
        }
    }

    

    public void modifierTrajet(int id, String d, String dest, double p, int pl) {
        for (TrajetS2 t : trajets) {
            if (t.getIdTrajet() == id) {
                t.modifier(d, dest, p, pl);
                System.out.println("Trajet modifié !");
                return;
            }
        }
        System.out.println("Trajet introuvable !");
    }

    public void supprimerTrajet(int id) {
        for (TrajetS2 t : trajets) {
            if (t.getIdTrajet() == id) {
                trajets.remove(t);
                System.out.println("Trajet supprimé !");
                return;
            }
        }
        System.out.println("Trajet introuvable !");
    }
}
