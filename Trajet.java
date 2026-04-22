public class Trajet {
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
        setIdTrajet(idTrajet);
        setDepart(depart);
        setDestination(destination);
        setDate(date);
        setHeure(heure);
        setPrix(prix);
        setPlacesDisponibles(placesDisponibles);
    }

    public boolean estDisponible() {
        return placesDisponibles > 0;
    }

    public void reserverUnePlace() {
        if (!estDisponible()) {
            throw new IllegalStateException("Aucune place disponible pour ce trajet.");
        }
        placesDisponibles--;
    }

    public void libererUnePlace() {
        placesDisponibles++;
    }

    public void afficherDetails() {
        System.out.println("=== Trajet ===");
        System.out.println("ID : " + idTrajet);
        System.out.println("Départ : " + depart);
        System.out.println("Destination : " + destination);
        System.out.println("Date : " + date);
        System.out.println("Heure : " + heure);
        System.out.println("Prix : " + prix + " DT");
        System.out.println("Places disponibles : " + placesDisponibles);
    }

    public int getIdTrajet() {
        return idTrajet;
    }

    public void setIdTrajet(int idTrajet) {
        if (idTrajet <= 0) {
            throw new IllegalArgumentException("L'identifiant du trajet doit être positif.");
        }
        this.idTrajet = idTrajet;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        if (depart == null || depart.trim().isEmpty()) {
            throw new IllegalArgumentException("Le lieu de départ est obligatoire.");
        }
        this.depart = depart.trim();
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        if (destination == null || destination.trim().isEmpty()) {
            throw new IllegalArgumentException("La destination est obligatoire.");
        }
        if (depart != null && destination.trim().equalsIgnoreCase(depart)) {
            throw new IllegalArgumentException("La destination doit être différente du départ.");
        }
        this.destination = destination.trim();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        if (date == null || date.trim().isEmpty()) {
            throw new IllegalArgumentException("La date est obligatoire.");
        }

        String valeur = date.trim();

        if (!valeur.matches("^\\d{2}-\\d{2}-\\d{4}$")) {
            throw new IllegalArgumentException("Le format de la date doit être jj-mm-aaaa.");
        }

        String[] parties = valeur.split("-");
        int jour = Integer.parseInt(parties[0]);
        int mois = Integer.parseInt(parties[1]);
        int annee = Integer.parseInt(parties[2]);

        if (mois < 1 || mois > 12) {
            throw new IllegalArgumentException("Le mois doit être compris entre 1 et 12.");
        }
        if (jour < 1 || jour > 31) {
            throw new IllegalArgumentException("Le jour doit être compris entre 1 et 31.");
        }
        if (annee < 2024) {
            throw new IllegalArgumentException("L'année saisie n'est pas valide.");
        }

        this.date = valeur;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        if (heure == null || heure.trim().isEmpty()) {
            throw new IllegalArgumentException("L'heure est obligatoire.");
        }

        String valeur = heure.trim();

        if (!valeur.matches("^\\d{2}:\\d{2}$")) {
            throw new IllegalArgumentException("Le format de l'heure doit être hh:mm.");
        }

        String[] parties = valeur.split(":");
        int heures = Integer.parseInt(parties[0]);
        int minutes = Integer.parseInt(parties[1]);

        if (heures < 0 || heures > 23) {
            throw new IllegalArgumentException("Les heures doivent être entre 00 et 23.");
        }
        if (minutes < 0 || minutes > 59) {
            throw new IllegalArgumentException("Les minutes doivent être entre 00 et 59.");
        }

        this.heure = valeur;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        if (prix < 0) {
            throw new IllegalArgumentException("Le prix ne peut pas être négatif.");
        }
        this.prix = prix;
    }

    public int getPlacesDisponibles() {
        return placesDisponibles;
    }

    public void setPlacesDisponibles(int placesDisponibles) {
        if (placesDisponibles < 0) {
            throw new IllegalArgumentException("Le nombre de places disponibles ne peut pas être négatif.");
        }
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
