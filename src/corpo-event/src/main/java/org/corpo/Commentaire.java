package org.corpo;

public class Commentaire {
    private String dateDePublication;
    private String nomDuPublicateur;
    private String contenu;
    private int evenementId;

    // Getters et Setters
    public String getDateDePublication() {
        return dateDePublication;
    }

    public void setDateDePublication(String dateDePublication) {
        this.dateDePublication = dateDePublication;
    }

    public String getNomDuPublicateur() {
        return nomDuPublicateur;
    }

    public void setNomDuPublicateur(String nomDuPublicateur) {
        this.nomDuPublicateur = nomDuPublicateur;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public int getEvenementId() {
        return evenementId;
    }

    public void setEvenementId(int evenementId) {
        this.evenementId = evenementId;
    }

    // Validation du commentaire
    public boolean validerContenu() {
        return contenu != null && !contenu.trim().isEmpty();
    }
}
