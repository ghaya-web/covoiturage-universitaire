public class User {
// version simple
    int id;
    String nom;
    String email;
    String motDePasse;

    public User(int Id, String Nom, String email, String motDePasse) {
        this.id = Id;
        this.nom = Nom;
        this.email = email;
        this.motDePasse = motDePasse;
    }

    public boolean login(String email, String motDePasse) {
        return this.email.equals(email) && this.motDePasse.equals(motDePasse);
    }
}