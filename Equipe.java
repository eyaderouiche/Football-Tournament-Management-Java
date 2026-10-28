package coupe.football;

public class Equipe {
    private int id;
    private String nom;
    private String couleur;
    private int victoires;
    private boolean eliminee;
    private String niveauElimination;
    
    public Equipe(int id, String nom, String couleur) {
        this.id = id;
        this.nom = nom;
        this.couleur = couleur;
        this.victoires = 0;
        this.eliminee = false;
        this.niveauElimination = "";
    }
    
    public void gagnerMatch() {
        victoires++;
    }
    
    public void eliminer(String niveau) {
        eliminee = true;
        niveauElimination = niveau;
    }
    
    public void afficher() {
        System.out.println(id + ". " + nom + " (" + couleur + ") - " + 
                         victoires + " victoires - " + 
                         (eliminee ? "Eliminee en " + niveauElimination : "En competition"));
    }
    
    // GETTERS
    public int getId() { return id; }
    public String getNom() { return nom; }
    public String getCouleur() { return couleur; }
    public int getVictoires() { return victoires; }
    public boolean isEliminee() { return eliminee; }
    public String getNiveauElimination() { return niveauElimination; }
}