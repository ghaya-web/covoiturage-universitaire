package com.covoiturage.models;

public class Admin {
    private String nom;
    private String email;

    public Admin(String nom, String email) {
        this.nom = nom;
        this.email = email;
    }

    public void afficherUtilisateurs() {
        System.out.println("--- Liste des Utilisateurs (Vue Admin) ---");
        System.out.println("1. Ahmed - ahmed@email.com");
        System.out.println("2. Sarra - sarra@email.com");
        System.out.println("Total : 2 utilisateurs inscrits.");
    }

    public void afficherTrajets() {
        System.out.println("--- Liste des Trajets Actifs ---");
        System.out.println("Trajet #1: Tunis -> Sousse (15 DT)");
        System.out.println("Trajet #2: Ariana -> Manouba (5 DT)");
    }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}