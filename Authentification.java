import java.util.ArrayList;

public class Authentification {

    private ArrayList<utilisateur> utilisateurs = new ArrayList<>();
    private int compteurId = 1;

    // INSCRIPTION
    public utilisateur inscrireUtilisateur(String nom, String email, String motDePasse) {
  
        if (nom == null || nom.isEmpty()) {
            System.out.println("Nom invalide");
            return null;
        }

        if (email == null || !email.contains("@")) {
            System.out.println("Email invalide");
            return null;
        }

        for (utilisateur u : utilisateurs) {
            if (u.getEmail().equals(email)) {
                System.out.println("Email déjà utilisé");
                return null;
            }
        }

        if (motDePasse.length() < 4) {
            System.out.println("Mot de passe trop court");
            return null;
        }

        utilisateur user = new utilisateur(compteurId++, nom, email, motDePasse);
        utilisateurs.add(user);

        System.out.println("Utilisateur inscrit avec succès : " + nom);
        return user;
    }

    // AUTHENTIFICATION
    public boolean authentifier(String email, String motDePasse) {

        for (utilisateur u : utilisateurs) {
            if (u.seConnecter(email, motDePasse)) {
                System.out.println("Connexion réussie : " + u.getNom());
                return true;
            }
        }

        System.out.println("Email ou mot de passe incorrect");
        return false;
    }
}