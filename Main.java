public class Main {
    public static void main(String[] args) {

        // Création admin
        Admin admin = new Admin(1, "Ines", "admin@gmail.com", "1234");

        // Création tableau de bord
        TableauDeBordAdmin tdb = new TableauDeBordAdmin(10, 5, 3);

        // Scénarios de base (Sprint 1)
        admin.gererUtilisateurs();
        admin.gererTrajets();
        admin.consulterTableauDeBord(tdb);
    }
}
