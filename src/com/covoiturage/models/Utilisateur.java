public class Utilisateur {

    protected int id;
    protected String nom;
    protected String email;
    protected String motDePasse;

    public Utilisateur(int id, String nom, String email, String mdp) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.motDePasse = mdp;
    }

    // ================= GETTERS =================
    public int getId() { return id; }
    public String getNom() { return nom; }
    public String getEmail() { return email; }
    public String getMotDePasse() { return motDePasse; }

    // ================= LOGIN ACTION =================
    public void seConnecter() {
        System.out.println(nom + " est connecté");
    }

    public void seDeconnecter() {
        System.out.println(nom + " est déconnecté");
    }

    // ================= VALIDATION =================
    public boolean estValide() {

        // NOM
        if (nom == null || nom.trim().isEmpty()) {
            System.out.println("Nom invalide !");
            return false;
        }

        if (!nom.matches("[a-zA-Z\\s]+")) {
            System.out.println("Nom invalide : uniquement lettres autorisées !");
            return false;
        }

        // EMAIL
        if (email == null ||
            !email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {

            System.out.println("Email invalide !");
            return false;
        }

        // MOT DE PASSE
        if (motDePasse == null || motDePasse.trim().length() < 6) {
            System.out.println("Mot de passe invalide : minimum 6 caractères !");
            return false;
        }

        return true;
    }
}