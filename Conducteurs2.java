import java.util.ArrayList;
import java.util.List;

public class ConducteurS2 {

    private int id;
    private String nom;
    private String email;
    private String motDePasse;
    private String telephone;
    private double noteMoyenne;

    private List<Trajet> trajets;

    public ConducteurS2(String telephone, double noteMoyenne) {
        this.telephone = telephone;
        this.noteMoyenne = noteMoyenne;
        this.trajets = new ArrayList<>();
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getMotDePasse() { return motDePasse; }
    public void setMotDePasse(String motDePasse) { this.motDePasse = motDePasse; }

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public double getNoteMoyenne() { return noteMoyenne; }
    public void setNoteMoyenne(double noteMoyenne) { this.noteMoyenne = noteMoyenne; }

    // User Story 1
    public void proposerTrajet(Trajet trajet) {
        trajets.add(trajet);
        System.out.println("Trajet ajouté avec succès !");
    }

    // User Story 2
    public void consulterMesTrajets() {
        System.out.println("\nMes trajets :");
        for (Trajet t : trajets) {
            t.afficherDetails();
        }
    }

    public void gererProfil() {
        System.out.println("\nProfil conducteur : " + nom + " | " + email);
    }

    public void consulterReservationsRecues() {
        System.out.println("Fonction non implémentée (Sprint 2)");
    }
}
