import java.util.ArrayList;

public class Admin {

    private int id;
    private String nom;
    private String email;
    private String motDePasse;

    // Simulations des données
    private ArrayList<String> utilisateurs = new ArrayList<>();
    private ArrayList<String> trajets = new ArrayList<>();

    public Admin(int id, String nom, String email, String motDePasse) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.motDePasse = motDePasse;
    }

    // GETTERS & SETTERS
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getMotDePasse() { return motDePasse; }
    public void setMotDePasse(String motDePasse) { this.motDePasse = motDePasse; }

    // ---------------- SPRINT 2 ----------------

    // admin veut voir utilisateurs
    public void gererUtilisateurs() {
        System.out.println("=== LISTE UTILISATEURS ===");

        if (utilisateurs.isEmpty()) {
            System.out.println("Aucun utilisateur");
        } else {
            for (String u : utilisateurs) {
                System.out.println("- " + u);
            }
        }
    }

    // admin veut voir trajets
    public void gererTrajets() {
        System.out.println("=== LISTE TRAJETS ===");

        if (trajets.isEmpty()) {
            System.out.println("Aucun trajet");
        } else {
            for (String t : trajets) {
                System.out.println("- " + t);
            }
        }
    }

    // ajout simulation (pour test)
    public void ajouterUtilisateur(String u) {
        utilisateurs.add(u);
    }

    public void ajouterTrajet(String t) {
        trajets.add(t);
    }

    // consultation dashboard
    public void consulterTableauDeBord(TableauDeBordAdmin tdb) {
        tdb.setNombreUtilisateurs(utilisateurs.size());
        tdb.setNombreTrajets(trajets.size());
        tdb.setNombreReservations(3); // simulation
        tdb.afficherStatistiques();
    }
}