import com.covoiturage.models.Admin;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Covoiturage Universitaire Sprint 1 ===\n");

        // Création de l'objet Admin pour le test (Ines)
        Admin adminInes = new Admin("Ines", "ines@etudiant.tn");

        // Appel des fonctionnalités Admin
        System.out.println("--- Section Admin ---");
        adminInes.afficherUtilisateurs();
        adminInes.afficherTrajets();

        System.out.println("\n✅ Prototype V1 s'exécute avec succès.");
    }
}
