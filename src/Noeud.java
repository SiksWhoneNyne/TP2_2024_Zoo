public class Noeud {
    private Visiteur valeur;
    public Noeud suivant;

    public Noeud(Visiteur valeur){
        this.valeur = valeur;
        this.suivant = null;
    }

    public String toString(){
        return "[" + this.getVisiteur();
    }

    public Visiteur getVisiteur(){
        return valeur;
    }

    public Visiteur getValeur(){
        return valeur;
    }

    public Noeud getSuivant(){
        return suivant;
    }

    public void setSuivant(Noeud prochain){
        suivant = prochain;
    }
}
