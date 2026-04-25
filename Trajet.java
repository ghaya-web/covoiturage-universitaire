import java.time.LocalDate;
import java.time.LocalTime;

public class Trajet {

    private int idTrajet;
    private String depart;
    private String destination;
    private LocalDate date;
    private LocalTime heure;
    private double prix;
    private int placesDisponibles;

    public Trajet(int idTrajet, String depart, String destination,
                  LocalDate date, LocalTime heure,
                  double prix, int placesDisponibles) {
        this.idTrajet = idTrajet;
        this.depart = depart;
        this.destination = destination;
        this.date = date;
        this.heure = heure;
        this.prix = prix;
        this.placesDisponibles = placesDisponibles;
    }

    // Getters & Setters
    public int getIdTrajet() { return idTrajet; }
    public void setIdTrajet(int idTrajet) { this.idTrajet = idTrajet; }

    public String getDepart() { return depart; }
    public void setDepart(String depart) { this.depart = depart; }

    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public LocalTime getHeure() { return heure; }
    public void setHeure(LocalTime heure) { this.heure = heure; }

    public double getPrix() { return prix; }
    public void setPrix(double prix) { this.prix = prix; }

    public int getPlacesDisponibles() { return placesDisponibles; }
    public void setPlacesDisponibles(int placesDisponibles) { this.placesDisponibles = placesDisponibles; }

    // Méthodes
    public void afficherDetails() {
        System.out.println("Trajet " + idTrajet +
                " : " + depart + " -> " + destination +
                " | Date: " + date +
                " | Heure: " + heure +
                " | Prix: " + prix +
                " | Places: " + placesDisponibles);
    }

    public void diminuerPlaces() {
        if (placesDisponibles > 0) {
            placesDisponibles--;
        }
    }

    public void augmenterPlaces() {
        placesDisponibles++;
    }
}