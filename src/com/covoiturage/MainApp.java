import java.util.*;

public class MainApp {

    public static int lireInt(Scanner sc) {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.print("Entrée invalide, réessayez : ");
            }
        }
    }

    public static double lireDouble(Scanner sc) {
        while (true) {
            try {
                return Double.parseDouble(sc.nextLine());
            } catch (Exception e) {
                System.out.print("Entrée invalide, réessayez : ");
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Authentification auth = new Authentification();
        auth.ajouterAdmin(new Admin(1, "Admin", "admin@mail.com", "1234"));

        TableauDeBordAdmin tdb = new TableauDeBordAdmin(0, 0, 0);
        List<Trajet> trajets = new ArrayList<>();

        Utilisateur user = null;
        Passager passager = null;
        Conducteur conducteur = null;
        Admin admin = null;

        int choix;

        do {
            System.out.println("\n==================================");
            System.out.println("            UniRide               ");
            System.out.println("==================================");
            System.out.println("1. Inscription");
            System.out.println("2. Connexion");
            System.out.println("3. Mode Passager");
            System.out.println("4. Mode Conducteur");
            System.out.println("5. Mode Admin");
            System.out.println("0. Quitter");
            System.out.println("==================================");
            System.out.print("Votre choix : ");

            choix = lireInt(sc);

            switch (choix) {

                case 1:
                    System.out.print("Nom: ");
                    String nom = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Mot de passe: ");
                    String mdp = sc.nextLine();

                    auth.inscrireUtilisateur(nom, email, mdp);
                    break;

                case 2:

                    System.out.println("\n--- CONNEXION ---");

                    System.out.print("Email: ");
                    email = sc.nextLine();

                    System.out.print("Mot de passe: ");
                    mdp = sc.nextLine();

                    user = null;
                    passager = null;
                    conducteur = null;
                    admin = null;

                    System.out.println("1. Passager");
                    System.out.println("2. Conducteur");
                    System.out.println("3. Admin");
                    System.out.print("Votre choix : ");

                    int role = lireInt(sc);

                    if (role == 1) {

                        user = auth.authentifier(email, mdp);

                        if (user != null) {
                            passager = new Passager(1, user.getNom(), user.getEmail(), user.getMotDePasse());
                        }
                    }

                    else if (role == 2) {

                        user = auth.authentifier(email, mdp);

                        if (user != null) {

                            System.out.print("Téléphone: ");
                            String tel = sc.nextLine();

                            conducteur = new Conducteur(
                                    1,
                                    user.getNom(),
                                    user.getEmail(),
                                    user.getMotDePasse(),
                                    tel
                            );
                        }
                    }

                    else if (role == 3) {

                        admin = auth.authentifierAdmin(email, mdp);

                        if (admin != null) {
                            System.out.println("Admin connecté");
                        } else {
                            System.out.println("Accès refusé");
                        }
                    }

                    break;

                case 3:

                    if (passager == null) {
                        System.out.println("Connecte-toi d'abord");
                        break;
                    }

                    int chP;

                    do {
                        System.out.println("\n--- MENU PASSAGER ---");
                        System.out.println("1. Rechercher + filtrer trajet");
                        System.out.println("2. Réserver");
                        System.out.println("3. Annuler réservation");
                        System.out.println("4. Mes réservations");
                        System.out.println("0. Retour");
                        System.out.print("Votre choix : ");

                        chP = lireInt(sc);

                        switch (chP) {

                            case 1:

                                System.out.print("Depart: ");
                                String dep = sc.nextLine();

                                System.out.print("Destination: ");
                                String dest = sc.nextLine();

                                List<Trajet> resultats = new ArrayList<>();

                                for (Trajet t : trajets) {
                                    if (t.getDepart().equalsIgnoreCase(dep)
                                            && t.getDestination().equalsIgnoreCase(dest)) {
                                        resultats.add(t);
                                    }
                                }

                                if (resultats.isEmpty()) {
                                    System.out.println("Aucun trajet");
                                    break;
                                }

                                System.out.println("\n--- RESULTATS ---");
                                for (Trajet t : resultats) {
                                    t.afficherDetails();
                                }

                                System.out.println("\nFiltrer ? (1=oui / 0=non)");
                                System.out.print("Votre choix : ");
                                int f = lireInt(sc);

                                if (f == 1) {

                                    System.out.print("Prix max: ");
                                    double max = lireDouble(sc);

                                    System.out.print("Heure: ");
                                    String h = sc.nextLine();

                                    System.out.print("Places min: ");
                                    int p = lireInt(sc);

                                    List<Trajet> filtres = new ArrayList<>();

                                    for (Trajet t : resultats) {
                                        if (t.getPrix() <= max &&
                                            t.getHeure().equalsIgnoreCase(h) &&
                                            t.getPlaces() >= p) {
                                            filtres.add(t);
                                        }
                                    }

                                    System.out.println("\n--- RESULTATS FILTRÉS ---");

                                    if (filtres.isEmpty()) {
                                        System.out.println("Aucun trajet trouvé");
                                    } else {
                                        for (Trajet t : filtres) {
                                            t.afficherDetails();
                                        }
                                    }
                                }

                                break;

                            case 2:
                                System.out.print("ID trajet: ");
                                int id = lireInt(sc);

                                boolean ok = false;

                                for (Trajet t : trajets) {
                                    if (t.getIdTrajet() == id) {
                                        passager.reserverTrajet(t);
                                        System.out.println("Réservé");
                                        ok = true;
                                        break;
                                    }
                                }

                                if (!ok) System.out.println("Introuvable");
                                break;

                            case 3:
                                System.out.print("ID réservation: ");
                                int idr = lireInt(sc);

                                if (passager.annulerReservation(idr))
                                    System.out.println("Annulé");
                                else
                                    System.out.println("Introuvable");
                                break;

                            case 4:
                                passager.consulterReservations();
                                break;
                        }

                    } while (chP != 0);

                    break;

                case 4:

                    if (conducteur == null) {
                        System.out.println("Connecte-toi d'abord");
                        break;
                    }

                    int chC;

                    do {
                        System.out.println("\n--- MENU CONDUCTEUR ---");
                        System.out.println("1. Ajouter trajet");
                        System.out.println("2. Voir trajets");
                        System.out.println("3. Modifier trajet");
                        System.out.println("4. Supprimer trajet");
                        System.out.println("0. Retour");
                        System.out.print("Votre choix : ");

                        chC = lireInt(sc);

                        switch (chC) {

                            case 1:
                                System.out.print("ID: ");
                                int idt = lireInt(sc);

                                System.out.print("Depart: ");
                                String d = sc.nextLine();

                                System.out.print("Destination: ");
                                String ds = sc.nextLine();

                                System.out.print("Date: ");
                                String dt = sc.nextLine();

                                System.out.print("Heure: ");
                                String hr = sc.nextLine();

                                System.out.print("Prix: ");
                                double pr = lireDouble(sc);

                                System.out.print("Places: ");
                                int pl = lireInt(sc);

                                Trajet t2 = new Trajet(idt, d, ds, dt, hr, pr, pl);

                                if (t2.estValide()) {
                                    trajets.add(t2);
                                    conducteur.proposerTrajet(t2);
                                }
                                break;

                            case 2:
                                for (Trajet t : trajets)
                                    t.afficherDetails();
                                break;

                            case 3:
                                System.out.print("ID: ");
                                int idm = lireInt(sc);

                                for (Trajet t : trajets) {
                                    if (t.getIdTrajet() == idm) {

                                        System.out.print("Depart: ");
                                        t.setDepart(sc.nextLine());

                                        System.out.print("Destination: ");
                                        t.setDestination(sc.nextLine());

                                        System.out.print("Date: ");
                                        t.setDate(sc.nextLine());

                                        System.out.print("Heure: ");
                                        t.setHeure(sc.nextLine());

                                        System.out.print("Prix: ");
                                        t.setPrix(lireDouble(sc));

                                        System.out.print("Places: ");
                                        t.setPlaces(lireInt(sc));
                                    }
                                }
                                break;

                            case 4:
                                System.out.print("ID: ");
                                int ids = lireInt(sc);

                                trajets.removeIf(t -> t.getIdTrajet() == ids);
                                break;
                        }

                    } while (chC != 0);

                    break;

                case 5:

                    if (admin == null) {
                        System.out.println("Accès refusé");
                        break;
                    }

                    int chA;

                    do {
                        System.out.println("\n--- MENU ADMIN ---");
                        System.out.println("1. Utilisateurs");
                        System.out.println("2. Trajets");
                        System.out.println("3. Tableau de bord");
                        System.out.println("0. Retour");
                        System.out.print("Votre choix : ");

                        chA = lireInt(sc);

                        switch (chA) {

                            case 1:
                                admin.gererUtilisateurs(auth.getUsers());
                                break;

                            case 2:
                                admin.gererTrajets(trajets);
                                break;

                            case 3:
                                tdb.setNombreUtilisateurs(auth.getNombreUtilisateurs());
                                tdb.setNombreTrajets(trajets.size());
                                tdb.setNombreReservations(
                                        passager != null ? passager.getReservations().size() : 0
                                );

                                admin.consulterTableauDeBord(tdb);
                                break;
                        }

                    } while (chA != 0);

                    break;
            }

        } while (choix != 0);

        sc.close();
    }
}