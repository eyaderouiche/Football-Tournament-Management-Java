package coupe.football;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tournoi tournoi = new Tournoi();
        boolean quitter = false;
        
        System.out.println("=== APPLICATION DE GESTION DE LA COUPE NATIONALE DE FOOTBALL ===");
        
        while (!quitter) {
            afficherMenu();
            int choix = lireChoix(scanner);
            
            switch (choix) {
                case 1:
                    // 1. Entrer la liste des équipes
                    tournoi.creerEquipes();
                    System.out.println("\n✓ 16 équipes ont été créées avec succès.");
                    break;
                    
                case 2:
                    // 2. Organiser les matchs d'un niveau
                    organiserNiveau(scanner, tournoi);
                    break;
                    
                case 3:
                    // 3. Afficher le calendrier
                    tournoi.afficherCalendrier();
                    break;
                    
                case 4:
                    // 4. Afficher la liste des équipes participantes avec le nombre de matchs gagnés
                    tournoi.afficherEquipes();
                    break;
                    
                case 5:
                    // 5. Afficher les équipes éliminées avec le niveau d'élimination
                    tournoi.afficherEquipesEliminees();
                    break;
                    
                case 6:
                    // 6. Afficher les équipes encore en compétition
                    tournoi.afficherEquipesEnCompetition();
                    break;
                    
                case 7:
                    // 7. Afficher le classement final
                    tournoi.afficherClassement();
                    break;
                    
                case 8:
                    // 8. Quitter le programme
                    quitter = true;
                    System.out.println("\nMerci d'avoir utilisé l'application. Au revoir!");
                    break;
                    
                default:
                    System.out.println("\n✗ Choix invalide! Veuillez choisir un nombre entre 1 et 8.");
            }
            
            if (!quitter) {
                System.out.println("\nAppuyez sur Entrée pour continuer...");
                scanner.nextLine();
            }
        }
        
        scanner.close();
    }
    
    private static void afficherMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("MENU PRINCIPAL");
        System.out.println("=".repeat(50));
        System.out.println("1. Entrer la liste des équipes");
        System.out.println("2. Organiser/Jouer les matchs d'un niveau");
        System.out.println("3. Afficher le calendrier complet");
        System.out.println("4. Afficher la liste des équipes (avec victoires)");
        System.out.println("5. Afficher les équipes éliminées");
        System.out.println("6. Afficher les équipes encore en compétition");
        System.out.println("7. Afficher le classement final");
        System.out.println("8. Quitter le programme");
        System.out.println("=".repeat(50));
        System.out.print("Votre choix (1-8): ");
    }
    
    private static int lireChoix(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    private static void organiserNiveau(Scanner scanner, Tournoi tournoi) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("ORGANISATION DES MATCHS");
        System.out.println("=".repeat(50));
        System.out.println("1. Organiser les 1/8 de finale");
        System.out.println("2. Organiser les 1/4 de finale");
        System.out.println("3. Organiser les 1/2 finales");
        System.out.println("4. Organiser la finale");
        System.out.println("5. Organiser le match pour la 3e place");
        System.out.println("6. Jouer les 1/8 de finale");
        System.out.println("7. Jouer les 1/4 de finale");
        System.out.println("8. Jouer les 1/2 finales");
        System.out.println("9. Jouer la finale");
        System.out.println("10. Jouer le match pour la 3e place");
        System.out.println("0. Retour au menu principal");
        System.out.println("=".repeat(50));
        System.out.print("Votre choix (0-10): ");
        
        int choix = lireChoix(scanner);
        
        switch (choix) {
            case 1:
                tournoi.organiserHuitiemes();
                break;
            case 2:
                tournoi.organiserQuarts();
                break;
            case 3:
                tournoi.organiserDemis();
                break;
            case 4:
                tournoi.organiserFinale();
                break;
            case 5:
                tournoi.organiserMatchTroisieme();
                break;
            case 6:
                tournoi.jouerHuitiemes();
                break;
            case 7:
                tournoi.jouerQuarts();
                break;
            case 8:
                tournoi.jouerDemis();
                break;
            case 9:
                tournoi.jouerFinale();
                break;
            case 10:
                tournoi.jouerMatchTroisieme();
                break;
            case 0:
                System.out.println("Retour au menu principal...");
                break;
            default:
                System.out.println("✗ Choix invalide! Veuillez choisir entre 0 et 10.");
        }
    }
}