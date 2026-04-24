import java.util.*;

public class Conducteur extends Utilisateur {

    private String telephone;
    private double noteMoyenne;
    private List<Reservation> reservationsRecues = new ArrayList<>();
    private List<Trajet> trajetsProposes = new ArrayList<>();

    public Conducteur(int id, String nom, String email, String mdp, String tel) {
        super(id, nom, email, mdp);
        this.telephone = tel;
    }

    // ================= GETTERS =================
    public String getTelephone() {
        return telephone;
    }

    public double getNoteMoyenne() {
        return noteMoyenne;
    }

    public List<Reservation> getReservationsRecues() {
        return reservationsRecues;
    }

    public List<Trajet> getTrajetsProposes() {
        return trajetsProposes;
    }

    // ================= SETTERS =================
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setNoteMoyenne(double noteMoyenne) {
        this.noteMoyenne = noteMoyenne;
    }

    // ================= OPERATIONS =================

    // 🔧 Gestion profil
    public void gererProfil(String nom, String email, String tel) {
        this.nom = nom;
        this.email = email;
        this.telephone = tel;
        System.out.println("Profil conducteur mis à jour !");
    }

    // 📋 Consulter réservations reçues
    public void consulterReservationsRecues() {
        if (reservationsRecues.isEmpty()) {
            System.out.println("Aucune réservation reçue");
            return;
        }

        for (Reservation r : reservationsRecues) {
            System.out.println(r);
        }
    }

    // ➕ Ajouter réservation reçue
    public void ajouterReservation(Reservation r) {
        reservationsRecues.add(r);
    }

    // 🚗 Proposer trajet
    public void proposerTrajet(Trajet t) {
        trajetsProposes.add(t);
        System.out.println("Trajet proposé !");
    }

    // ❌ Supprimer trajet par ID
    public void supprimerTrajetPropose(int id) {
        boolean removed = trajetsProposes.removeIf(t -> t.getIdTrajet() == id);

        if (removed) {
            System.out.println("Trajet supprimé !");
        } else {
            System.out.println("Trajet introuvable !");
        }
    }

    // 🔍 Validation
    public boolean estValide() {
        if (!super.estValide()) return false;

        if (telephone == null || telephone.length() < 8) {
            System.out.println("Téléphone invalide !");
            return false;
        }
        return true;
    }
}