package org.corpo;


public class Evenement {
    private int id;
    private String nom;
    private String titre;
    private String dateDebut;
    private String dateFin;
    private String lieu;

    // Constructeur
    public Evenement(int id, String nom, String titre, String dateDebut, String dateFin, String lieu) {
        this.id = id;
        this.nom = nom;
        this.titre = titre;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.lieu = lieu;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    // Méthodes
    public void afficherDetails() {
        System.out.println("Evenement : " + titre + ", Lieu : " + lieu + ", Dates : " + dateDebut + " - " + dateFin);
    }
}
