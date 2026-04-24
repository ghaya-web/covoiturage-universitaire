public class Trajet {

    private int idTrajet;
    private String depart;
    private String destination;
    private String date;
    private String heure;
    private double prix;
    private int places;

    public Trajet(int id, String dep, String dest, String date,
                  String heure, double prix, int places) {
        this.idTrajet = id;
        this.depart = dep;
        this.destination = dest;
        this.date = date;
        this.heure = heure;
        this.prix = prix;
        this.places = places;
    }

    // ================= GETTERS =================
    public int getIdTrajet() { return idTrajet; }
    public String getDepart() { return depart; }
    public String getDestination() { return destination; }
    public String getDate() { return date; }
    public String getHeure() { return heure; }
    public double getPrix() { return prix; }
    public int getPlaces() { return places; }

    // ================= SETTERS (AJOUTÉS) =================
    public void setDepart(String depart) {
        this.depart = depart;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    // ================= MÉTHODES =================
    public void augmenterPlaces() { places++; }
    public void diminuerPlaces() { places--; }

    public void afficherDetails() {
        System.out.println(idTrajet + " | " + depart + " -> " + destination +
                " | " + date + "|" + heure +
                " | " + prix + "DT | Places: " + places);
    }

    public boolean estValide() {
        if (depart == null || depart.isEmpty()) return false;
        if (destination == null || destination.isEmpty()) return false;
        if (prix < 0) return false;
        if (places <= 0) return false;
        return true;
    }
}