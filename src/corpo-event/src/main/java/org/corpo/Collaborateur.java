package org.corpo;
import java.util.Scanner;

public class Collaborateur extends Utilisateur {
    private final CommentaireRepository commentaireRepository;

    // Constructeur
    public Collaborateur(String nom, String prenom, String mail, String motDePasse, CommentaireRepository commentaireRepository) {
        super(nom, prenom, mail, motDePasse);
        this.commentaireRepository = commentaireRepository;
    }

    // Méthode pour consulter les événements
    public void consulterEvenement() {
        try {
            System.out.println(super.getNom() + " consulte les événements disponibles.");
            // Logique pour afficher les événements
        } catch (Exception e) {
            System.out.println("Erreur lors de la consultation des événements : " + e.getMessage());
        }
    }

    // Méthode pour créer un commentaire
    public void creerCommentaire(String contenu, int idEvenement) {
        try {
            if (contenu == null || contenu.isEmpty()) {
                throw new IllegalArgumentException("Le contenu du commentaire ne peut pas être vide.");
            }

            Commentaire commentaire = new Commentaire();
            commentaire.setContenu(contenu);
            commentaire.setEvenementId(idEvenement);
            commentaire.setNomDuPublicateur(super.getNom());
            commentaire.setDateDePublication(java.time.LocalDate.now().toString());

            if (!commentaire.validerContenu()) {
                throw new IllegalArgumentException("Le contenu du commentaire est invalide.");
            }

            commentaireRepository.ajouterCommentaire(commentaire);
            System.out.println("Commentaire ajouté avec succès !");
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur de validation : " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Une erreur inattendue est survenue : " + e.getMessage());
        } finally {
            System.out.println("Fin du processus de création du commentaire.");
        }
    }

    // Méthode pour afficher une zone de texte et saisir un commentaire
    public void saisirCommentaireViaConsole(int idEvenement) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("───────────────────────────────────────────");
            System.out.println("🔹 Zone de saisie de commentaire");
            System.out.println("Entrez votre commentaire ci-dessous (tapez 'FIN' pour valider) :");
            System.out.println("───────────────────────────────────────────");

            StringBuilder contenu = new StringBuilder();
            String ligne;

            // Lire les lignes de l'utilisateur jusqu'à "FIN"
            while (scanner.hasNextLine()) {
                ligne = scanner.nextLine();
                if (ligne.equalsIgnoreCase("FIN")) {
                    break;
                }
                contenu.append(ligne).append("\n");
            }

            // Créer le commentaire après la saisie
            creerCommentaire(contenu.toString().trim(), idEvenement);

        } catch (Exception e) {
            System.out.println("Erreur lors de la saisie du commentaire : " + e.getMessage());
        }
    }
}
