public class Utilisateur {
    protected int id;
    protected String nom;
    protected String email;
    protected String motDePasse;

    public Utilisateur() {
    }

    public Utilisateur(int id, String nom, String email, String motDePasse) {
        setId(id);
        setNom(nom);
        setEmail(email);
        setMotDePasse(motDePasse);
    }

    public boolean seConnecter(String email, String motDePasse) {
        if (email == null || motDePasse == null) {
            return false;
        }
        return this.email.equals(email.trim()) && this.motDePasse.equals(motDePasse);
    }

    public void seDeconnecter() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("L'identifiant doit être positif.");
        }
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        if (nom == null || nom.trim().isEmpty()) {
            throw new IllegalArgumentException("Le nom est obligatoire.");
        }
        if (nom.trim().length() < 2) {
            throw new IllegalArgumentException("Le nom doit contenir au moins 2 caractères.");
        }
        this.nom = nom.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("L'email est obligatoire.");
        }

        String valeur = email.trim();

        if (!valeur.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            throw new IllegalArgumentException("Format d'email invalide.");
        }

        this.email = valeur;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        if (motDePasse == null || motDePasse.trim().isEmpty()) {
            throw new IllegalArgumentException("Le mot de passe est obligatoire.");
        }
        if (motDePasse.length() < 4) {
            throw new IllegalArgumentException("Le mot de passe doit contenir au moins 4 caractères.");
        }
        this.motDePasse = motDePasse;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}