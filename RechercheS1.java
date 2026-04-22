import java.util.ArrayList;
import java.util.List;

public class RechercheS1 {

    private String depart;
    private String destination;
    private String dateRecherche;

    public RechercheS1(String depart, String destination, String dateRecherche) {
        this.depart = depart;
        this.destination = destination;
        this.dateRecherche = dateRecherche;
    }

    public List<TrajetS1> rechercher(List<TrajetS1> base) {

        List<TrajetS1> resultats = new ArrayList<>();

        for (TrajetS1 t : base) {
            if (t.getDepart().equalsIgnoreCase(depart)
                    && t.getDestination().equalsIgnoreCase(destination)
                    && t.getDateRecherche().equals(dateRecherche)) {
                resultats.add(t);
            }
        }

        return resultats;
    }
}