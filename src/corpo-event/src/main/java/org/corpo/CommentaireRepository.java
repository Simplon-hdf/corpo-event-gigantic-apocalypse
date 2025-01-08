package org.corpo;

import java.util.ArrayList;
import java.util.List;

public class CommentaireRepository {
    private final List<Commentaire> commentaires = new ArrayList<>();


    // Ajouter un commentaire
    public void ajouterCommentaire(Commentaire commentaire) {
        try {
            commentaires.add(commentaire);
            System.out.println("Commentaire ajouté par : " + commentaire.getNomDuPublicateur());
        } catch (Exception e) {
            System.out.println("Erreur lors de l'ajout du commentaire : " + e.getMessage());
        }
    }

    // Modifier un commentaire
    public void modifierCommentaire(Commentaire commentaire) {
        try {
            for (Commentaire c : commentaires) {
                if (c.getEvenementId() == commentaire.getEvenementId() &&
                        c.getNomDuPublicateur().equals(commentaire.getNomDuPublicateur())) {
                    c.setContenu(commentaire.getContenu());
                    System.out.println("Commentaire modifié par : " + commentaire.getNomDuPublicateur());
                    return;
                }
            }
            throw new IllegalArgumentException("Commentaire introuvable pour modification.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur de validation : " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erreur inattendue lors de la modification du commentaire : " + e.getMessage());
        }
    }

    // Supprimer un commentaire
    public void supprimerCommentaire(Commentaire commentaire) {
        try {
            commentaires.removeIf(c -> c.getEvenementId() == commentaire.getEvenementId() &&
                    c.getNomDuPublicateur().equals(commentaire.getNomDuPublicateur()));
            System.out.println("Commentaire supprimé.");
        } catch (Exception e) {
            System.out.println("Erreur lors de la suppression du commentaire : " + e.getMessage());
        }
    }

    // Trouver un commentaire par ID d'événement
    public List<Commentaire> trouverParId(int idEvenement) {
        try {
            List<Commentaire> resultats = new ArrayList<>();
            for (Commentaire c : commentaires) {
                if (c.getEvenementId() == idEvenement) {
                    resultats.add(c);
                }
            }
            return resultats;
        } catch (Exception e) {
            System.out.println("Erreur lors de la recherche des commentaires : " + e.getMessage());
        }
        return new ArrayList<>();
    }
}
