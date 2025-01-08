package org.corpo;

import java.util.ArrayList;
import java.util.List;

public class EvenementRepository {
    private List<Evenement> evenements = new ArrayList<>();

    // Ajouter un evenement
    public void ajouterEvenement(Evenement evenement) {
        try {
            evenements.add(evenement);
            System.out.println("Evenement ajouté : " + evenement.getTitre());
        } catch (Exception e) {
            System.out.println("Erreur lors de l'ajout de l'evenement : " + e.getMessage());
        }
    }

    // Modifier un evenement
    public void modifierEvenement(Evenement evenement) {
        try {
            for (Evenement e : evenements) {
                if (e.getId() == evenement.getId()) {
                    e.setNom(evenement.getNom());
                    e.setTitre(evenement.getTitre());
                    e.setDateDebut(evenement.getDateDebut());
                    e.setDateFin(evenement.getDateFin());
                    e.setLieu(evenement.getLieu());
                    System.out.println("Evenement modifié : " + evenement.getTitre());
                    return;
                }
            }
            throw new IllegalArgumentException("Evenement non trouvé pour modification.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur de validation : " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erreur inattendue lors de la modification de l'evenement : " + e.getMessage());
        }
    }

    // Supprimer un evenement
    public void supprimerEvenement(int id) {
        try {
            evenements.removeIf(e -> e.getId() == id);
            System.out.println("Evenement supprimé avec l'ID : " + id);
        } catch (Exception e) {
            System.out.println("Erreur lors de la suppression de l'evenement : " + e.getMessage());
        }
    }

    // Trouver un evenement par ID
    public Evenement trouverParId(int id) {
        try {
            for (Evenement e : evenements) {
                if (e.getId() == id) {
                    return e;
                }
            }
            throw new IllegalArgumentException("Evenement introuvable avec l'ID : " + id);
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur de recherche : " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erreur inattendue lors de la recherche de l'evenement : " + e.getMessage());
        }
        return null;
    }

    // Récupérer tous les evenements
    public List<Evenement> trouverTous() {
        return evenements;
    }
}
