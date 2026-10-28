package coupe.football;

import java.util.*;

public class Tournoi {
    private List<Equipe> equipes;
    private List<Match> huitiemes;
    private List<Match> quarts;
    private List<Match> demis;
    private Match finale;
    private Match matchTroisieme;
    
    public Tournoi() {
        equipes = new ArrayList<>();
        huitiemes = new ArrayList<>();
        quarts = new ArrayList<>();
        demis = new ArrayList<>();
    }
    
    // Créer 16 équipes
    public void creerEquipes() {
        equipes.clear();
        String[] noms = {
            "Esperance", "Club Africain", "Etoile Sahel", "US Monastir",
            "CS Sfaxien", "Stade Tunisien", "CA Bizertin", "EGS Gafsa",
            "AS Marsa", "US Ben Guerdane", "Olympique Beja", "Hammam-Lif",
            "AS Gabes", "JS Kairouan", "US Tataouine", "CS Chebba"
        };
        
        for(int i = 0; i < 16; i++) {
            equipes.add(new Equipe(i+1, noms[i], "Equipe " + (i+1)));
        }
    }
    
    // Vérifier si les huitièmes ont été joués
    public boolean huitiemesJoues() {
        if (huitiemes.isEmpty()) return false;
        for (Match m : huitiemes) {
            if (m.getVainqueur() == null) return false;
        }
        return true;
    }
    
    // Vérifier si les quarts ont été joués
    public boolean quartsJoues() {
        if (quarts.isEmpty()) return false;
        for (Match m : quarts) {
            if (m.getVainqueur() == null) return false;
        }
        return true;
    }
    
    // Vérifier si les demis ont été joués
    public boolean demisJoues() {
        if (demis.isEmpty()) return false;
        for (Match m : demis) {
            if (m.getVainqueur() == null) return false;
        }
        return true;
    }
    
    // 1/8 finale - Organisation
    public void organiserHuitiemes() {
        huitiemes.clear();
        Collections.shuffle(equipes);
        
        System.out.println("\n--- 1/8 FINALE ---");
        for(int i = 0; i < 8; i++) {
            Match m = new Match(equipes.get(2*i), equipes.get(2*i+1), "1/8 finale");
            huitiemes.add(m);
            System.out.println((i+1) + ". " + equipes.get(2*i).getNom() + " vs " + equipes.get(2*i+1).getNom());
        }
    }
    
    public void jouerHuitiemes() {
        System.out.println("\nJOUER 1/8 FINALE:");
        if (huitiemes.isEmpty()) {
            System.out.println("ERREUR: Organisez d'abord les 1/8!");
            return;
        }
        for(Match m : huitiemes) {
            m.jouerMatch();
        }
    }
    
    // 1/4 finale
    public void organiserQuarts() {
        if(huitiemes.isEmpty()) {
            System.out.println("ERREUR: Organisez d'abord les 1/8!");
            return;
        }
        
        if (!huitiemesJoues()) {
            System.out.println("ERREUR: Jouez d'abord les 1/8 de finale!");
            return;
        }
        
        quarts.clear();
        List<Equipe> qualifies = new ArrayList<>();
        
        for(Match m : huitiemes) {
            qualifies.add(m.getVainqueur());
        }
        
        Collections.shuffle(qualifies);
        
        System.out.println("\n--- 1/4 FINALE ---");
        for(int i = 0; i < 4; i++) {
            Match m = new Match(qualifies.get(2*i), qualifies.get(2*i+1), "1/4 finale");
            quarts.add(m);
            System.out.println((i+1) + ". " + qualifies.get(2*i).getNom() + " vs " + qualifies.get(2*i+1).getNom());
        }
    }
    
    public void jouerQuarts() {
        System.out.println("\nJOUER 1/4 FINALE:");
        if (quarts.isEmpty()) {
            System.out.println("ERREUR: Organisez d'abord les 1/4!");
            return;
        }
        for(Match m : quarts) {
            m.jouerMatch();
        }
    }
    
    // 1/2 finale
    public void organiserDemis() {
        if(quarts.isEmpty()) {
            System.out.println("ERREUR: Organisez d'abord les 1/4!");
            return;
        }
        
        if (!quartsJoues()) {
            System.out.println("ERREUR: Jouez d'abord les 1/4 de finale!");
            return;
        }
        
        demis.clear();
        List<Equipe> qualifies = new ArrayList<>();
        
        for(Match m : quarts) {
            qualifies.add(m.getVainqueur());
        }
        
        System.out.println("\n--- 1/2 FINALE ---");
        for(int i = 0; i < 2; i++) {
            Match m = new Match(qualifies.get(2*i), qualifies.get(2*i+1), "1/2 finale");
            demis.add(m);
            System.out.println((i+1) + ". " + qualifies.get(2*i).getNom() + " vs " + qualifies.get(2*i+1).getNom());
        }
    }
    
    public void jouerDemis() {
        System.out.println("\nJOUER 1/2 FINALE:");
        if (demis.isEmpty()) {
            System.out.println("ERREUR: Organisez d'abord les 1/2!");
            return;
        }
        for(Match m : demis) {
            m.jouerMatch();
        }
    }
    
    // Finale
    public void organiserFinale() {
        if(demis.isEmpty()) {
            System.out.println("ERREUR: Organisez d'abord les 1/2!");
            return;
        }
        
        if (!demisJoues()) {
            System.out.println("ERREUR: Jouez d'abord les 1/2 finales!");
            return;
        }
        
        List<Equipe> qualifies = new ArrayList<>();
        for(Match m : demis) {
            qualifies.add(m.getVainqueur());
        }
        
        finale = new Match(qualifies.get(0), qualifies.get(1), "Finale");
        System.out.println("\n--- FINALE ---");
        System.out.println(qualifies.get(0).getNom() + " vs " + qualifies.get(1).getNom());
    }
    
    public void jouerFinale() {
        if(finale == null) {
            System.out.println("ERREUR: Organisez d'abord la finale!");
            return;
        }
        System.out.println("\nJOUER LA FINALE:");
        finale.jouerMatch();
    }
    
    // Match 3eme place
    public void organiserMatchTroisieme() {
        if(demis.isEmpty()) {
            System.out.println("ERREUR: Organisez d'abord les 1/2!");
            return;
        }
        
        if (!demisJoues()) {
            System.out.println("ERREUR: Jouez d'abord les 1/2 finales!");
            return;
        }
        
        List<Equipe> perdants = new ArrayList<>();
        for(Match m : demis) {
            perdants.add(m.getPerdant());
        }
        
        matchTroisieme = new Match(perdants.get(0), perdants.get(1), "3eme place");
        System.out.println("\n--- MATCH 3EME PLACE ---");
        System.out.println(perdants.get(0).getNom() + " vs " + perdants.get(1).getNom());
    }
    
    public void jouerMatchTroisieme() {
        if(matchTroisieme == null) {
            System.out.println("ERREUR: Organisez d'abord le match pour la 3e place!");
            return;
        }
        System.out.println("\nJOUER MATCH 3EME PLACE:");
        matchTroisieme.jouerMatch();
    }
    
    // Afficher calendrier complet
    public void afficherCalendrier() {
        System.out.println("\n=== CALENDRIER COMPLET ===");
        
        System.out.println("\n--- 1/8 DE FINALE ---");
        if (huitiemes.isEmpty()) {
            System.out.println("Non organisé");
        } else {
            for (int i = 0; i < huitiemes.size(); i++) {
                Match m = huitiemes.get(i);
                System.out.println((i+1) + ". " + m.getEquipe1().getNom() + " vs " + m.getEquipe2().getNom());
                if (m.getVainqueur() != null) {
                    System.out.println("   Résultat: " + m.getVainqueur().getNom() + " gagne");
                }
            }
        }
        
        System.out.println("\n--- 1/4 DE FINALE ---");
        if (quarts.isEmpty()) {
            System.out.println("Non organisé");
        } else {
            for (int i = 0; i < quarts.size(); i++) {
                Match m = quarts.get(i);
                System.out.println((i+1) + ". " + m.getEquipe1().getNom() + " vs " + m.getEquipe2().getNom());
                if (m.getVainqueur() != null) {
                    System.out.println("   Résultat: " + m.getVainqueur().getNom() + " gagne");
                }
            }
        }
        
        System.out.println("\n--- 1/2 FINALE ---");
        if (demis.isEmpty()) {
            System.out.println("Non organisé");
        } else {
            for (int i = 0; i < demis.size(); i++) {
                Match m = demis.get(i);
                System.out.println((i+1) + ". " + m.getEquipe1().getNom() + " vs " + m.getEquipe2().getNom());
                if (m.getVainqueur() != null) {
                    System.out.println("   Résultat: " + m.getVainqueur().getNom() + " gagne");
                }
            }
        }
        
        System.out.println("\n--- FINALE ---");
        if (finale == null) {
            System.out.println("Non organisée");
        } else {
            System.out.println(finale.getEquipe1().getNom() + " vs " + finale.getEquipe2().getNom());
            if (finale.getVainqueur() != null) {
                System.out.println("Résultat: " + finale.getVainqueur().getNom() + " gagne");
            }
        }
        
        System.out.println("\n--- MATCH 3EME PLACE ---");
        if (matchTroisieme == null) {
            System.out.println("Non organisé");
        } else {
            System.out.println(matchTroisieme.getEquipe1().getNom() + " vs " + matchTroisieme.getEquipe2().getNom());
            if (matchTroisieme.getVainqueur() != null) {
                System.out.println("Résultat: " + matchTroisieme.getVainqueur().getNom() + " gagne");
            }
        }
    }
    
    // Afficher équipes avec victoires
    public void afficherEquipes() {
        System.out.println("\n--- EQUIPES PARTICIPANTES ---");
        System.out.println("(avec nombre de victoires)");
        for(Equipe e : equipes) {
            System.out.println(e.getId() + ". " + e.getNom() + " - " + e.getVictoires() + " victoire(s)");
        }
    }
    
    // Afficher équipes éliminées
    public void afficherEquipesEliminees() {
        System.out.println("\n--- EQUIPES ELIMINEES ---");
        System.out.println("(avec niveau d'élimination)");
        boolean aucune = true;
        for(Equipe e : equipes) {
            if(e.isEliminee()) {
                System.out.println(e.getNom() + " (éliminée en " + e.getNiveauElimination() + ")");
                aucune = false;
            }
        }
        if(aucune) System.out.println("Aucune équipe éliminée pour le moment.");
    }
    
    // Afficher équipes en compétition
    public void afficherEquipesEnCompetition() {
        System.out.println("\n--- EQUIPES EN COMPETITION ---");
        boolean aucune = true;
        for(Equipe e : equipes) {
            if(!e.isEliminee()) {
                System.out.println(e.getNom());
                aucune = false;
            }
        }
        if(aucune) System.out.println("Aucune équipe en compétition.");
    }
    
    // Afficher classement final
    public void afficherClassement() {
        System.out.println("\n--- CLASSEMENT FINAL ---");
        
        if(finale == null || finale.getVainqueur() == null) {
            System.out.println("Le tournoi n'est pas encore terminé.");
            System.out.println("Jouez la finale d'abord.");
            return;
        }
        
        System.out.println("1. " + finale.getVainqueur().getNom() + " (Champion)");
        System.out.println("2. " + finale.getPerdant().getNom() + " (Finaliste)");
        
        if(matchTroisieme != null && matchTroisieme.getVainqueur() != null) {
            System.out.println("3. " + matchTroisieme.getVainqueur().getNom() + " (3eme place)");
            System.out.println("4. " + matchTroisieme.getPerdant().getNom() + " (4eme place)");
        }
        
        System.out.println("\n5. Équipes éliminées en 1/4 finale:");
        boolean aucuneQuart = true;
        for(Equipe e : equipes) {
            if(e.isEliminee() && e.getNiveauElimination().equals("1/4 finale")) {
                System.out.println("   - " + e.getNom());
                aucuneQuart = false;
            }
        }
        if (aucuneQuart) System.out.println("   Aucune");
        
        System.out.println("\n6. Autres équipes éliminées:");
        boolean aucuneAutre = true;
        for(Equipe e : equipes) {
            if(e.isEliminee() && !e.getNiveauElimination().equals("1/4 finale") && 
               !e.getNiveauElimination().contains("finale")) {
                System.out.println("   - " + e.getNom() + " (" + e.getNiveauElimination() + ")");
                aucuneAutre = false;
            }
        }
        if (aucuneAutre) System.out.println("   Aucune");
    }
}