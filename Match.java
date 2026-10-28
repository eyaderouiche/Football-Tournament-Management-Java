package coupe.football;

import java.util.Random;

public class Match {
    private Equipe equipe1;
    private Equipe equipe2;
    private Equipe vainqueur;
    private Equipe perdant;
    private String niveau;
    
    public Match(Equipe equipe1, Equipe equipe2, String niveau) {
        this.equipe1 = equipe1;
        this.equipe2 = equipe2;
        this.niveau = niveau;
    }
    
    public void jouerMatch() {
        Random rand = new Random();
        if(rand.nextBoolean()) {
            vainqueur = equipe1;
            perdant = equipe2;
        } else {
            vainqueur = equipe2;
            perdant = equipe1;
        }
        
        vainqueur.gagnerMatch();
        perdant.eliminer(niveau);
        
        System.out.println(equipe1.getNom() + " vs " + equipe2.getNom() + 
                         " -> Vainqueur: " + vainqueur.getNom());
    }
    
    // GETTERS
    public Equipe getEquipe1() { return equipe1; }
    public Equipe getEquipe2() { return equipe2; }
    public Equipe getVainqueur() { return vainqueur; }
    public Equipe getPerdant() { return perdant; }
    public String getNiveau() { return niveau; }
}