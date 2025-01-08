package org.corpo;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Création des repositories
        EvenementRepository evenementRepo = new EvenementRepository();
        CommentaireRepository commentaireRepo = new CommentaireRepository();

        // Ajout d'un événement
        Evenement evenement1 = new Evenement(1, "Conférence", "Tech 2024", "2024-06-10", "2024-06-12", "Paris");
        evenementRepo.ajouterEvenement(evenement1);

        // Création d'un collaborateur
        Collaborateur collaborateur = new Collaborateur(
                "Alice", "Dupont", "alice@example.com", "password123", commentaireRepo
        );

        collaborateur.seConnecter();
        collaborateur.consulterEvenement();

        // Ouverture de la zone de texte pour saisir un commentaire
        collaborateur.saisirCommentaireViaConsole(1);

        collaborateur.seDeconnecter();

        // Affichage des commentaires liés à l'événement
        List<Commentaire> commentaires = commentaireRepo.trouverParId(1);
        System.out.println("\n🔹 Commentaires pour l'événement ID: 1");
        for (Commentaire c : commentaires) {
            System.out.println("Auteur: " + c.getNomDuPublicateur() + ", Contenu: " + c.getContenu());
        }
    }
}
