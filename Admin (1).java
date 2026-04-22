public class Admin {

    private int id;
    private String nom;
    private String email;
    private String motDePasse;

    // Constructeur
    public Admin(int id, String nom, String email, String motDePasse) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.motDePasse = motDePasse;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getMotDePasse() { return motDePasse; }
    public void setMotDePasse(String motDePasse) { this.motDePasse = motDePasse; }

    // Méthodes (Sprint 1 simple)

    public void gererUtilisateurs() {
        System.out.println("Liste des utilisateurs affichée");
    }

    public void gererTrajets() {
        System.out.println("Liste des trajets affichée");
    }

    public void consulterTableauDeBord(TableauDeBordAdmin tdb) {
        tdb.afficherStatistiques();
    }
}