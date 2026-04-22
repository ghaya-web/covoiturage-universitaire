import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== TEST SPRINT 2 covoiturage uni =====");

        int idPassager = lireIntPositif(scanner, "ID du passager : ");
        String nom = lireNomValide(scanner, "Nom : ");
        String email = lireEmailValide(scanner, "Email : ");
        String motDePasse = lireMotDePasseValide(scanner, "Mot de passe : ");
        String numeroEtudiant = lireNumeroEtudiantValide(scanner, "Numéro étudiant : ");

        Passager passager = new Passager(idPassager, nom, email, motDePasse, numeroEtudiant);

        System.out.println("\n--- Informations du passager enregistrées avec succès ---");
        System.out.println(passager);

        int idTrajet = lireIntPositif(scanner, "\nID du trajet : ");
        String depart = lireTexteObligatoire(scanner, "Départ : ");
        String destination = lireDestinationValide(scanner, "Destination : ", depart);
        String date = lireDateValide(scanner, "Date (jj-mm-aaaa) : ");
        String heure = lireHeureValide(scanner, "Heure (hh:mm) : ");
        double prix = lireDoublePositifOuZero(scanner, "Prix : ");
        int placesDisponibles = lireIntPositifOuZero(scanner, "Nombre de places disponibles : ");

        try {
            Trajet trajet = new Trajet(idTrajet, depart, destination, date, heure, prix, placesDisponibles);

            System.out.println("\n--- Informations du trajet enregistrées avec succès ---");
            System.out.println(trajet);

            System.out.println("\n--- Réservation du trajet ---");
            Reservation reservation = passager.reserverTrajet(trajet);
            System.out.println("Réservation créée avec succès :");
            System.out.println(reservation);

            System.out.println("\n--- Réservations du passager ---");
            passager.afficherReservations();

            String reponse = lireOuiNon(scanner, "\nVoulez-vous annuler la réservation ? (oui/non) : ");

            if (reponse.equalsIgnoreCase("oui")) {
                passager.annulerReservation(reservation);
                System.out.println("\nRéservation après annulation :");
                System.out.println(reservation);
            } else {
                System.out.println("\nRéservation conservée.");
            }

            System.out.println("\n--- État final du trajet ---");
            System.out.println(trajet);

            System.out.println("\n--- État final des réservations du passager ---");
            passager.afficherReservations();

        } catch (IllegalArgumentException e) {
            System.out.println("Erreur de saisie : " + e.getMessage());
        } catch (IllegalStateException e) {
            System.out.println("Erreur métier : " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erreur inattendue : " + e.getMessage());
        }

        System.out.println("\n===== FIN DU TEST =====");
        scanner.close();
    }

    public static int lireIntPositif(Scanner scanner, String message) {
        while (true) {
            try {
                System.out.print(message);
                int valeur = Integer.parseInt(scanner.nextLine());

                if (valeur <= 0) {
                    throw new IllegalArgumentException("La valeur doit être strictement positive.");
                }

                return valeur;
            } catch (NumberFormatException e) {
                System.out.println("Erreur : veuillez entrer un entier valide.");
            } catch (IllegalArgumentException e) {
                System.out.println("Erreur : " + e.getMessage());
            }
        }
    }

    public static int lireIntPositifOuZero(Scanner scanner, String message) {
        while (true) {
            try {
                System.out.print(message);
                int valeur = Integer.parseInt(scanner.nextLine());

                if (valeur < 0) {
                    throw new IllegalArgumentException("La valeur ne peut pas être négative.");
                }

                return valeur;
            } catch (NumberFormatException e) {
                System.out.println("Erreur : veuillez entrer un entier valide.");
            } catch (IllegalArgumentException e) {
                System.out.println("Erreur : " + e.getMessage());
            }
        }
    }

    public static double lireDoublePositifOuZero(Scanner scanner, String message) {
        while (true) {
            try {
                System.out.print(message);
                double valeur = Double.parseDouble(scanner.nextLine());

                if (valeur < 0) {
                    throw new IllegalArgumentException("La valeur ne peut pas être négative.");
                }

                return valeur;
            } catch (NumberFormatException e) {
                System.out.println("Erreur : veuillez entrer un nombre valide.");
            } catch (IllegalArgumentException e) {
                System.out.println("Erreur : " + e.getMessage());
            }
        }
    }

    public static String lireTexteObligatoire(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            String valeur = scanner.nextLine().trim();

            if (valeur.isEmpty()) {
                System.out.println("Erreur : ce champ est obligatoire.");
            } else {
                return valeur;
            }
        }
    }

    public static String lireNomValide(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            String valeur = scanner.nextLine().trim();

            if (valeur.isEmpty()) {
                System.out.println("Erreur : le nom est obligatoire.");
            } else if (valeur.length() < 2) {
                System.out.println("Erreur : le nom doit contenir au moins 2 caractères.");
            } else {
                return valeur;
            }
        }
    }

    public static String lireEmailValide(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            String valeur = scanner.nextLine().trim();

            if (valeur.isEmpty()) {
                System.out.println("Erreur : l'email est obligatoire.");
            } else if (!valeur.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
                System.out.println("Erreur : format d'email invalide.");
            } else {
                return valeur;
            }
        }
    }

    public static String lireMotDePasseValide(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            String valeur = scanner.nextLine();

            if (valeur == null || valeur.trim().isEmpty()) {
                System.out.println("Erreur : le mot de passe est obligatoire.");
            } else if (valeur.length() < 4) {
                System.out.println("Erreur : le mot de passe doit contenir au moins 4 caractères.");
            } else {
                return valeur;
            }
        }
    }

    public static String lireNumeroEtudiantValide(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            String valeur = scanner.nextLine().trim();

            if (valeur.isEmpty()) {
                System.out.println("Erreur : le numéro étudiant est obligatoire.");
            } else if (valeur.length() < 4) {
                System.out.println("Erreur : le numéro étudiant est trop court.");
            } else {
                return valeur;
            }
        }
    }

    public static String lireDestinationValide(Scanner scanner, String message, String depart) {
        while (true) {
            System.out.print(message);
            String valeur = scanner.nextLine().trim();

            if (valeur.isEmpty()) {
                System.out.println("Erreur : la destination est obligatoire.");
            } else if (valeur.equalsIgnoreCase(depart)) {
                System.out.println("Erreur : la destination doit être différente du départ.");
            } else {
                return valeur;
            }
        }
    }

    public static String lireDateValide(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            String valeur = scanner.nextLine().trim();

            if (valeur.isEmpty()) {
                System.out.println("Erreur : la date est obligatoire.");
            } else if (!valeur.matches("^\\d{2}-\\d{2}-\\d{4}$")) {
                System.out.println("Erreur : le format de la date doit être jj-mm-aaaa.");
            } else {
                String[] parties = valeur.split("-");
                int jour = Integer.parseInt(parties[0]);
                int mois = Integer.parseInt(parties[1]);
                int annee = Integer.parseInt(parties[2]);

                if (mois < 1 || mois > 12) {
                    System.out.println("Erreur : le mois doit être compris entre 1 et 12.");
                } else if (jour < 1 || jour > 31) {
                    System.out.println("Erreur : le jour doit être compris entre 1 et 31.");
                } else if (annee < 2024) {
                    System.out.println("Erreur : l'année saisie n'est pas valide.");
                } else {
                    return valeur;
                }
            }
        }
    }

    public static String lireHeureValide(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            String valeur = scanner.nextLine().trim();

            if (valeur.isEmpty()) {
                System.out.println("Erreur : l'heure est obligatoire.");
            } else if (!valeur.matches("^\\d{2}:\\d{2}$")) {
                System.out.println("Erreur : le format de l'heure doit être hh:mm.");
            } else {
                String[] parties = valeur.split(":");
                int heures = Integer.parseInt(parties[0]);
                int minutes = Integer.parseInt(parties[1]);

                if (heures < 0 || heures > 23) {
                    System.out.println("Erreur : les heures doivent être entre 00 et 23.");
                } else if (minutes < 0 || minutes > 59) {
                    System.out.println("Erreur : les minutes doivent être entre 00 et 59.");
                } else {
                    return valeur;
                }
            }
        }
    }

    public static String lireOuiNon(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            String valeur = scanner.nextLine().trim();

            if (valeur.equalsIgnoreCase("oui") || valeur.equalsIgnoreCase("non")) {
                return valeur;
            } else {
                System.out.println("Erreur : veuillez répondre par 'oui' ou 'non'.");
            }
        }
    }
}