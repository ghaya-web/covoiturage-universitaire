public class TrajetS1 {
    private int idTrajet;
    private String depart;
    private String destination;
    private String date;
    private String heure;
    private double prix;
    private int placesDisponibles;

    public Trajet() {
    }

    public Trajet(int idTrajet, String depart, String destination, String date, String heure, double prix, int placesDisponibles) {
        this.idTrajet = idTrajet;
        this.depart = depart;
        this.destination = destination;
        this.date = date;
        this.heure = heure;
        this.prix = prix;
        this.placesDisponibles = placesDisponibles;
    }

    public int getIdTrajet() {
        return idTrajet;
    }

    public void setIdTrajet(int idTrajet) {
        this.idTrajet = idTrajet;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getPlacesDisponibles() {
        return placesDisponibles;
    }

    public void setPlacesDisponibles(int placesDisponibles) {
        this.placesDisponibles = placesDisponibles;
    }

    @Override
    public String toString() {
        return "Trajet{" +
                "idTrajet=" + idTrajet +
                ", depart='" + depart + '\'' +
                ", destination='" + destination + '\'' +
                ", date='" + date + '\'' +
                ", heure='" + heure + '\'' +
                ", prix=" + prix +
                ", placesDisponibles=" + placesDisponibles +
                '}';
    }
}
