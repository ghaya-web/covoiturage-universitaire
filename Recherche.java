import java.util.ArrayList;
import java.util.List;

public class Recherche {

    private String depart;
    private String destination;
    private String dateRecherche;

    private List<Trajet> resultats = new ArrayList<>();

    public Recherche(String depart, String destination, String dateRecherche) {
        this.depart = depart;
        this.destination = destination;
        this.dateRecherche = dateRecherche;
    }

    public void rechercherTrajet(List<Trajet> base) {
        resultats.clear();

        for (Trajet t : base) {
            if (t.getDepart().equalsIgnoreCase(depart)
                    && t.getDestination().equalsIgnoreCase(destination)
                    && t.getDateRecherche().equals(dateRecherche)) {
                resultats.add(t);
            }
        }
    }

    public void filtrerParPrix(double prixMax) {
        resultats.removeIf(t -> t.getPrix() > prixMax);
    }

    public void filtrerParHeure(String heure) {
        resultats.removeIf(t -> !t.getHeure().equals(heure));
    }

    public void filtrerParPlaces(int minPlaces) {
        resultats.removeIf(t -> t.getNombrePlacesDisponibles() < minPlaces);
    }

    public void afficherResultat() {
        if (resultats.isEmpty()) {
            System.out.println("❌ Aucun trajet trouvé.");
        } else {
            for (Trajet t : resultats) {
                System.out.println(t);
            }
        }
    }
}