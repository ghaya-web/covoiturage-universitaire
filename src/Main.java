import com.covoiturage.models.Admin;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Covoiturage Universitaire Sprint 1 ===");
        
        // Création de l'objet Admin
        Admin admin = new Admin(1, "Ines", "ines@email.com", "ADMIN_ROLE");

        System.out.println("\n--- Section Admin ---");
        
        // Tester l'affichage des utilisateurs
        admin.afficherUtilisateurs();

        // Tester l'affichage des trajets
        admin.afficherTrajets();

        System.out.println("\n✅ Prototype V1 s'exécute avec succès.");
    }
}
