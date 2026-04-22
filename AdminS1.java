public class AdminS1 {

    private int id;
    private String nom;
    private String email;
    private String motDePasse;

    public AdminS1(int id, String nom, String email, String motDePasse) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.motDePasse = motDePasse;
    }

    public void afficherUtilisateurs() {
        System.out.println("Liste des utilisateurs (S1)");
    }

    public void afficherTrajets() {
        System.out.println("Liste des trajets (S1)");
    }

    public void consulterTableauDeBord(TableauDeBordS1 tdb) {
        tdb.afficherStatistiques();
    }
}