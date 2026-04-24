import java.util.*;

public class Recherche {

    private String depart;
    private String destination;
    private String date;

    public Recherche(String dep, String dest, String date) {
        this.depart = dep;
        this.destination = dest;
        this.date = date;
    }

    public List<Trajet> rechercher(List<Trajet> trajets) {
        List<Trajet> resultats = new ArrayList<>();

        for (Trajet t : trajets) {
            if (t.getDepart().equalsIgnoreCase(depart)
                    && t.getDestination().equalsIgnoreCase(destination)
                    && t.getDate().equals(date)) {

                resultats.add(t);
            }
        }
        return resultats;
    }

    public List<Trajet> filtrer(List<Trajet> trajets, String heureMin, int minPlaces, double prixMax) {
        List<Trajet> filtres = new ArrayList<>();

        for (Trajet t : trajets) {
            boolean h = heureMin.isEmpty() || t.getHeure().compareTo(heureMin) >= 0;
            boolean p = t.getPlaces() >= minPlaces;
            boolean pr = t.getPrix() <= prixMax;

            if (h && p && pr) {
                filtres.add(t);
            }
        }
        return filtres;
    }

    public void afficher(List<Trajet> trajets) {
        if (trajets.isEmpty()) {
            System.out.println("Aucun trajet trouvé");
        } else {
            for (Trajet t : trajets) {
                t.afficherDetails();
            }
        }
    }

    // 🔥 AJOUT
    public boolean estValide() {
        if (depart == null || depart.isEmpty()) return false;
        if (destination == null || destination.isEmpty()) return false;
        if (date == null || date.isEmpty()) return false;
        return true;
    }
}
