import java.time.LocalDate;
import java.time.LocalTime;

public class TrajetS2 {

    private int idTrajet;
    private String depart;
    private String destination;
    private LocalDate date;
    private LocalTime heure;
    private double prix;
    private int placesDisponibles;

    public TrajetS2(int idTrajet, String depart, String destination,
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

    public int getIdTrajet() {
        return idTrajet;
    }

    public void afficherDetails() {
        System.out.println(idTrajet + " | " + depart + " -> " + destination +
                " | " + date + " " + heure +
                " | " + prix + " DT | places: " + placesDisponibles);
    }

    public void modifier(String depart, String destination, double prix, int places) {
        this.depart = depart;
        this.destination = destination;
        this.prix = prix;
        this.placesDisponibles = places;
    }
}
