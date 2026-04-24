import java.util.*;

public class Authentification {

    private List<Utilisateur> users = new ArrayList<>();
    private List<Admin> admins = new ArrayList<>();

    // ================= INSCRIPTION =================
    public void inscrireUtilisateur(String nom, String email, String mdp) {

        Utilisateur u = new Utilisateur(users.size() + 1, nom, email, mdp);

        if (!u.estValide()) {
            System.out.println("Inscription échouée !");
            return;
        }

        users.add(u);
        System.out.println("Inscription réussie");
    }

    // ================= LOGIN USER =================
    public Utilisateur authentifier(String email, String mdp) {

        for (Utilisateur u : users) {

            if (u.getEmail().equals(email) &&
                u.getMotDePasse().equals(mdp)) {

                u.seConnecter(); // ✅ suffit (1 seul affichage)
                return u;
            }
        }

        System.out.println("Erreur login utilisateur");
        return null;
    }

    // ================= LOGIN ADMIN =================
    public Admin authentifierAdmin(String email, String mdp) {

        for (Admin a : admins) {

            if (a.getEmail().equals(email) &&
                a.getMotDePasse().equals(mdp)) {

                System.out.println("Admin connecté");
                return a;
            }
        }

        System.out.println("Erreur login admin");
        return null;
    }

    // ================= AJOUT ADMIN =================
    public void ajouterAdmin(Admin a) {
        admins.add(a);
    }

    // ================= GET USERS =================
    public List<Utilisateur> getUsers() {
        return users;
    }

    public int getNombreUtilisateurs() {
        return users.size();
    }

    // ================= GET ADMINS =================
    public List<Admin> getAdmins() {
        return admins;
    }

    // ================= SUPPRIMER USER =================
    public void supprimerUtilisateur(int id) {

        Iterator<Utilisateur> it = users.iterator();

        while (it.hasNext()) {
            Utilisateur u = it.next();

            if (u.getId() == id) {
                it.remove();
                System.out.println("Utilisateur supprimé");
                return;
            }
        }

        System.out.println("Utilisateur introuvable");
    }
}