import java.util.ArrayList;

public class Authentification {

    private ArrayList<Utilisateur> utilisateurs = new ArrayList<>();
    private int compteurId = 1;

    // Inscription simple
    public Utilisateur inscrireUtilisateur(String nom, String email, String motDePasse) {
        Utilisateur user = new Utilisateur(compteurId++, nom, email, motDePasse);
        utilisateurs.add(user);

        System.out.println("Utilisateur inscrit : " + nom);
        return user;
    }

    // Connexion simple
    public boolean authentifier(String email, String motDePasse) {

        for (Utilisateur u : utilisateurs) {
            if (u.seConnecter(email, motDePasse)) {
                System.out.println("Connexion réussie : " + u.getNom());
                return true;
            }
        }

        System.out.println("Erreur de connexion");
        return false;
    }
}