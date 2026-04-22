import java.util.ArrayList;

public class Auth {

    ArrayList<User> users = new ArrayList<>();
    int id = 1;

    public void inscrire(String nom, String email, String mdp) {

        User u = new User(id++, nom, email, mdp);
        users.add(u);

        System.out.println("Inscription réussie");
    }

    public void connexion(String email, String mdp) {

        for (User u : users) {

            if (u.login(email, mdp)) {
                System.out.println("Connexion réussie : " + u.nom);
                return;
            }
        }

        System.out.println("Email ou mot de passe incorrect");
    }
}