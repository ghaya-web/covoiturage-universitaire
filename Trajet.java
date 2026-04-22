public class Trajet {

    private String depart;
    private String destination;
    private String dateRecherche;
    private String heure;
    private double prix;
    private int nombrePlacesDisponibles;

    public Trajet(String depart, String destination, String dateRecherche,
                  String heure, double prix, int nombrePlacesDisponibles) {
        this.depart = depart;
        this.destination = destination;
        this.dateRecherche = dateRecherche;
        this.heure = heure;
        this.prix = prix;
        this.nombrePlacesDisponibles = nombrePlacesDisponibles;
    }

    public String getDepart() { return depart; }
    public String getDestination() { return destination; }
    public String getDateRecherche() { return dateRecherche; }
    public String getHeure() { return heure; }
    public double getPrix() { return prix; }
    public int getNombrePlacesDisponibles() { return nombrePlacesDisponibles; }

    @Override
    public String toString() {
        return depart + " -> " + destination +
                " | Date: " + dateRecherche +
                " | Heure: " + heure +
                " | Prix: " + prix +
                " | Places: " + nombrePlacesDisponibles;
    }
}