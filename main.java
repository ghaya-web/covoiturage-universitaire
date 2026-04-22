public class Main {

    public static void main(String[] args) {

        System.out.println("=== Covoiturage — Sprint 1 ===");

        Authentification auth = new Authentification();

        // Test inscription
        auth.inscrireUtilisateur("Ahmed", "ahmed@mail.com", "1234");
        auth.inscrireUtilisateur("Fatma", "fatma@mail.com", "abcd");

        // Test connexion
        auth.authentifier("ahmed@mail.com", "1234"); // succès
        auth.authentifier("ahmed@mail.com", "0000"); // erreur
    }
}